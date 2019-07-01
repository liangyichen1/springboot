package com.llfy.demo.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.llfy.demo.oa.entity.TPower;
import com.llfy.demo.oa.entity.TUser;
import com.llfy.demo.oa.service.ITPowerService;
import com.llfy.demo.oa.service.ITUserService;
import com.llfy.demo.tool.MessageResult;
import com.llfy.demo.tool.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.llfy.demo.base.web.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/oa/t-power")
public class TPowerController extends BaseController {

    @Autowired
    private ITPowerService powerService;

    @Autowired
    private ITUserService userService;

    /**
     * 权限设置
     * @param roleId
     * @param menuId
     * @return
     */
    @ApiOperation(value = "权限设置")
    @PostMapping("setPower")
    public ResponseMessage setPower(String roleId, String menuId,Integer status, HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        if (tUser.getRoleId().equals(roleId)){
            return MessageResult.success("500","不可以设置自己的权限");
        }
        String[] ids = menuId.split(",");
        List<String> list = Arrays.asList(ids);
        QueryWrapper<TPower> wrapper = new QueryWrapper<>();
        TPower power = new TPower();
        wrapper.eq("role_id",roleId).in("menu_id",list);
        power.setStatus(status);
        powerService.update(power,wrapper);
        return MessageResult.success("200","修改成功");
    }
}
