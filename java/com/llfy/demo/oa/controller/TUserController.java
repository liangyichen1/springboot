package com.llfy.demo.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.llfy.demo.oa.entity.TUser;
import com.llfy.demo.oa.service.ITUserService;
import com.llfy.demo.tool.MessageResult;
import com.llfy.demo.tool.ResponseData;
import com.llfy.demo.tool.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.llfy.demo.base.web.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * <p>
 *  用户控制层
 * </p>
 *
 * @author llfy
 * @since 2018-11-23
 */
@CrossOrigin
@RestController
@RequestMapping("/oa/t-user")
public class TUserController extends BaseController {

    /**
     *注入userService
     */
    @Autowired
    private ITUserService userService;

    /**
     * 登陆验证
     * @param user
     * @param session
     * @return
     */
    @ApiOperation(value = "登陆验证")
    @PostMapping("login")
    public ResponseData login(@RequestBody TUser user, HttpSession session){
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",user.getUserName());
        TUser userFlag = userService.getOne(wrapper);
        if (userFlag == null){
            return MessageResult.success("500","用户名不存在",null);
        }
        QueryWrapper<TUser> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("user_name",user.getUserName()).eq("user_pwd",user.getUserPwd());
        TUser tUser = userService.getOne(wrapper1);
        if (tUser == null){
            return MessageResult.success("500","密码错误",null);
        }
        String token = String.valueOf(UUID.randomUUID());
        tUser.setToken(token);
        userService.updateById(tUser);
        return MessageResult.success("200","登陆成功",tUser);
    }

    /**
     * 用户列表
     * @return
     */
    @ApiOperation(value = "用户列表")
    @GetMapping("listUser")
    public ResponseData listUser(String token,String userName){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",token);
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问",null);
        }
        List<TUser> data = userService.listUser(userName);
        return MessageResult.success("200","用户列表",data);
    }

    /**
     * 教师列表
     * @return
     */
    @ApiOperation(value = "教师列表")
    @GetMapping("listTeacher")
    public ResponseData listTeacher(HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问",null);
        }
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id","1").eq("user_state",1);
        List<TUser> data = userService.list(wrapper);
        return MessageResult.success("200","教师列表",data);
    }

    /**
     * 留言列表
     * @return
     */
    @ApiOperation(value = "留言列表")
    @GetMapping("listUserContent")
    public ResponseData listUserContent(String userName,HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问",null);
        }
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.ne("id",tUser.getId()).eq("user_state",1).like("user_name",userName);
        List<TUser> data = userService.list(wrapper);
        return MessageResult.success("200","用户列表",data);
    }

    /**
     * 退出登陆
     * @param id
     * @return
     */
    @ApiOperation(value = "退出登陆")
    @GetMapping("loginOut")
    public ResponseMessage loginOut(String id){
        TUser tUser = new TUser();
        tUser.setToken("");
        tUser.setId(id);
        userService.updateById(tUser);
        return MessageResult.success("200","退出成功");
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @ApiOperation(value = "新增用户")
    @PostMapping("saveUser")
    public ResponseMessage saveUser(@RequestBody TUser user,HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        //验证名称是否重复
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",user.getUserName());
        TUser userFlag = userService.getOne(wrapper);
        if (userFlag != null){
            return MessageResult.success("500","用户名已存在");
        }
        //新增操作
        user.setId(String.valueOf(UUID.randomUUID()));
        user.setCreateTime(new Date());
        user.setUserPwd("000000");
        user.setUserState(0);
        Boolean flag = userService.save(user);
        if (flag){
            return MessageResult.success("200","新增成功");
        }
        return MessageResult.success("500","新增失败");
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户")
    @PostMapping("updateUser")
    public ResponseMessage updateUser(@RequestBody TUser user,HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        //验证名称是否重复
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",user.getUserName()).ne("id",user.getId());
        TUser userFlag = userService.getOne(wrapper);
        if (userFlag != null){
            return MessageResult.success("500","用户名已存在");
        }
        //修改操作
        user.setUpdateTime(new Date());
        Boolean flag = userService.updateById(user);
        if (flag){
            return MessageResult.success("200","更新成功");
        }
        return MessageResult.success("500","更新失败");
    }
    /**
     * 修改密码
     * @param userId
     * @param userPwd
     * @return
     */
    @ApiOperation(value = "修改密码")
    @PostMapping("setPass")
    public ResponseMessage setPass(String userId,String userPwd,HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        //修改操作
        TUser user = new TUser();
        user.setId(userId);
        user.setUserPwd(userPwd);
        Boolean flag = userService.updateById(user);
        if (flag){
            return MessageResult.success("200","更新成功");
        }
        return MessageResult.success("500","更新失败");
    }
    /**
     * 删除用户
     * @param userId
     * @return
     */
    @ApiOperation(value = "删除用户")
    @PostMapping("deleteUser")
    public ResponseMessage deleteUser(String userId,HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        //删除操作
        Boolean flag = userService.removeById(userId);
        if (flag){
            return MessageResult.success("200","删除成功");
        }
        return MessageResult.success("500","删除失败");
    }

    /**
     * 批量删除用户
     * @param userId
     * @return
     */
    @ApiOperation(value = "批量删除用户")
    @PostMapping("deleteListUser")
    public ResponseMessage deleteListUser(String userId,HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        //批量删除操作
        String[] ids = userId.split(",");
        List<String> list = Arrays.asList(ids);
        Boolean flag = userService.removeByIds(list);
        if (flag){
            return MessageResult.success("200","删除成功");
        }
        return MessageResult.success("500","删除失败");
    }

    /**
     * 修改状态
     * @param userId
     * @return
     */
    @ApiOperation(value = "修改状态")
    @PostMapping("updateState")
    public ResponseMessage updateState(String userId,HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        TUser user = userService.getById(userId);
        if (user.getUserState() == 0){
            user.setUserState(1);
        }else{
            user.setUserState(0);
        }
        TUser user1 = new TUser();
        user1.setId(userId);
        user1.setUserState(user.getUserState());
        Boolean flag = userService.updateById(user1);
        if (flag){
            return MessageResult.success("200","更新成功");
        }
        return MessageResult.success("500","更新失败");
    }

    /**
     * 重置密码
     * @param userId
     * @return
     */
    @ApiOperation(value = "重置密码")
    @PostMapping("rePass")
    public ResponseMessage rePass(String userId,HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        TUser user = new TUser();
        user.setId(userId);
        user.setUserPwd("000000");
        Boolean flag = userService.updateById(user);
        if (flag){
            return MessageResult.success("200","密码重置为000000");
        }
        return MessageResult.success("500","重置失败");
    }
}
