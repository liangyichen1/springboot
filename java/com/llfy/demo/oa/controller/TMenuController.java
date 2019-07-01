package com.llfy.demo.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.llfy.demo.oa.entity.TMenu;
import com.llfy.demo.oa.entity.TUser;
import com.llfy.demo.oa.service.ITMenuService;
import com.llfy.demo.oa.service.ITUserService;
import com.llfy.demo.tool.MessageResult;
import com.llfy.demo.tool.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.llfy.demo.base.web.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author llfy
 * @since 2018-11-30
 */
@CrossOrigin
@RestController
@RequestMapping("/oa/t-menu")
public class TMenuController extends BaseController {

    @Autowired
    private ITUserService userService;

    @Autowired
    private ITMenuService menuService;
    /**
     * 查询角色权限
     * @param roleId
     * @param status
     * @return
     */
    @ApiOperation(value = "查询角色权限")
    @GetMapping("powerByRole")
    public ResponseData powerByRole(String roleId,Integer status,String token){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",token);
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问",null);
        }
        List<TMenu> list = menuService.powerByRole(status,roleId);
        return MessageResult.success("200","角色权限列表",list);
    }
    /**
     * 查询角色导航权限
     * @param request
     * @return
     */
    @ApiOperation(value = "查询角色导航权限")
    @GetMapping("powerByRole1")
    public ResponseData powerByRole1(HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问",null);
        }
        String token = request.getHeader("token");
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("token",token);
        TUser user = userService.getOne(wrapper);
        List<TMenu> list = menuService.powerByRole(1,user.getRoleId());
        return MessageResult.success("200","角色权限列表",list);
    }
}
