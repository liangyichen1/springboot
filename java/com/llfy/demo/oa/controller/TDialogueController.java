package com.llfy.demo.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.llfy.demo.oa.entity.TDialogue;
import com.llfy.demo.oa.entity.TUser;
import com.llfy.demo.oa.service.ITDialogueService;
import com.llfy.demo.oa.service.ITDiaryService;
import com.llfy.demo.oa.service.ITUserService;
import com.llfy.demo.tool.MessageResult;
import com.llfy.demo.tool.ResponseData;
import com.llfy.demo.tool.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.llfy.demo.base.web.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author llfy
 * @since 2018-12-03
 */
@CrossOrigin
@RestController
@RequestMapping("/oa/t-dialogue")
public class TDialogueController extends BaseController {

    @Autowired
    private ITUserService userService;

    @Autowired
    private ITDialogueService dialogueService;

    /**
     * 对话列表（A——>B）
     * @param userBId
     * @param request
     * @return
     */
    @ApiOperation(value = "对话列表")
    @PostMapping("dialogueList")
    public ResponseData dialogueList(String userBId, HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问",null);
        }
        List<TDialogue> list = dialogueService.dialogueList(tUser.getId(),userBId);
        TDialogue dialogue = new TDialogue();
        for (int i = 0 ; i < list.size() ; i++){
            if (list.get(i).getType() == 1){
                dialogue.setState(1);
                dialogue.setDialogueId(list.get(i).getDialogueId());
                dialogueService.updateById(dialogue);
            }
        }
        return MessageResult.success("200","对话列表",list);
    }

    /**
     * 新增一条对话
     * @param dialogue
     * @param request
     * @return
     */
    @ApiOperation(value = "新增一条对话")
    @PostMapping("saveDialogue")
    public ResponseMessage saveDialogue(@RequestBody TDialogue dialogue,HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        dialogue.setDialogueId(String.valueOf(UUID.randomUUID()));
        dialogue.setCreateTime(new Date());
        dialogue.setUserAId(tUser.getId());
        dialogue.setState(0);
        Boolean flag = dialogueService.save(dialogue);
        if (flag){
            return MessageResult.success("200","新增成功");
        }
        return MessageResult.success("500","新增失败");
    }
    /**
     * 消息
     * @param userId
     * @param request
     * @return
     */
    @ApiOperation(value = "消息")
    @PostMapping("dialogueMessage")
    public ResponseData dialogueMessage(String userId, HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问",null);
        }
        List<TDialogue> list = dialogueService.dialogueMessage(userId);
        return MessageResult.success("200","对话列表",list);
    }
    /**
     * 撤回一条对话
     * @param dialogueId
     * @return
     */
    @ApiOperation(value = "撤回一条对话")
    @PostMapping("deleteDialogue")
    public ResponseMessage deleteDialogue(String dialogueId,HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        UpdateWrapper<TDialogue> wrapper = new UpdateWrapper<>();
        wrapper.eq("dialogue_id",dialogueId);
        Boolean flag = dialogueService.remove(wrapper);
        if (flag){
            return MessageResult.success("200","撤回成功");
        }
        return MessageResult.success("500","撤回失败");
    }
}
