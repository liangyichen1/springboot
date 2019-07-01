package com.llfy.demo.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.llfy.demo.oa.entity.TPower;
import com.llfy.demo.oa.entity.TRole;
import com.llfy.demo.oa.entity.TUser;
import com.llfy.demo.oa.service.ITPowerService;
import com.llfy.demo.oa.service.ITRoleService;
import com.llfy.demo.oa.service.ITUserService;
import com.llfy.demo.tool.MessageResult;
import com.llfy.demo.tool.ResponseData;
import com.llfy.demo.tool.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.llfy.demo.base.web.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author llfy
 * @since 2018-11-28
 */
@CrossOrigin
@RestController
@RequestMapping("/oa/t-role")
public class TRoleController extends BaseController {


    @Autowired
    private ITRoleService roleService;
    /**
     *注入userService
     */
    @Autowired
    private ITUserService userService;

    @Autowired
    private ITPowerService powerService;
    /**
     * 角色列表
     * @return
     */
    @ApiOperation(value = "角色列表")
    @GetMapping("listRole")
    public ResponseData listRole(String token){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",token);
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问",null);
        }
        QueryWrapper<TRole> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        List<TRole> data = roleService.list(wrapper);
        return MessageResult.success("200","角色列表",data);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @ApiOperation(value ="新增角色")
    @PostMapping("addRole")
    public ResponseMessage addRole(@RequestBody TRole role, HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        //验证名称是否重复
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("role_name",role.getRoleName());
        TRole tRole = roleService.getOne(wrapper);
        if (tRole != null){
            return MessageResult.success("500","角色名已存在");
        }
        //新增操作
        role.setRoleId(String.valueOf(UUID.randomUUID()));
        role.setCreateTime(new Date());
        Boolean flag = roleService.save(role);
        if (flag){
            TPower power = new TPower();
            for(Integer i = 1 ; i < 6 ; i++){
                power.setPowerId(String.valueOf(UUID.randomUUID()));
                power.setMenuId(String.valueOf(i));
                power.setRoleId(role.getRoleId());
                power.setStatus(0);
                powerService.save(power);
            }
            return MessageResult.success("200","新增成功");
        }else{
            return MessageResult.success("500","新增失败");
        }
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @ApiOperation(value = "修改角色")
    @PostMapping("updateRole")
    public ResponseMessage updateRole(@RequestBody TRole role, HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        //验证名称是否重复
        QueryWrapper<TRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name",role.getRoleName());
        wrapper.ne("role_id",role.getRoleId());
        TRole tRole = roleService.getOne(wrapper);
        if (tRole != null){
            return MessageResult.success("500","角色名称已存在");
        }
        //修改操作
        role.setUpdateTime(new Date());
        Boolean flag = roleService.updateById(role);
        if (flag){
            return MessageResult.success("200","修改成功");
        }else{
            return MessageResult.success("500","修改失败");
        }
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @ApiOperation(value = "删除角色")
    @PostMapping("deleteRole")
    public ResponseMessage deleteRole(String roleId, HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        //验证角色是否在使用中
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        TUser user = userService.getOne(wrapper);
        if (user != null){
            return MessageResult.success("500","正在使用中");
        }
        //删除操作
        Boolean flag = roleService.removeById(roleId);
        if (flag){
            QueryWrapper<TPower> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("role_id",roleId);
            powerService.remove(wrapper1);
            return MessageResult.success("200","删除成功");
        }else{
            return MessageResult.success("500","删除失败");
        }
    }

    /**
     * 批量删除用户
     * @param roleId
     * @return
     */
    @ApiOperation(value = "批量删除用户")
    @PostMapping("deleteListRole")
    public ResponseMessage deleteListRole(String roleId,HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        String[] ids = roleId.split(",");
        List<String> list = Arrays.asList(ids);
        for (String Str: list){
            //验证角色是否在使用中
            QueryWrapper<TUser> wrapper = new QueryWrapper<>();
            wrapper.eq("role_id",Str);
            TUser user = userService.getOne(wrapper);
            if (user != null){
                return MessageResult.success("500","正在使用中");
            }
        }
        Boolean flag = roleService.removeByIds(list);
        if (flag){
            return MessageResult.success("200","删除成功");
        }
        return MessageResult.success("500","删除失败");
    }
}
