package com.llfy.demo.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.llfy.demo.oa.entity.TDiary;
import com.llfy.demo.oa.entity.TUser;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
@RequestMapping("/oa/t-diary")
public class TDiaryController extends BaseController {

    @Autowired
    private ITDiaryService diaryService;

    @Autowired
    private ITUserService userService;
    /**
     * 日记列表（学生）
     * @return
     */
    @ApiOperation(value = "日记列表（学生）")
    @GetMapping("listDiary")
    public ResponseData listDiary(){
        List<TDiary> list = diaryService.diarylist();
        return MessageResult.success("200","日记列表",list);
    }

    /**
     * 日记列表（教师）
     * @return
     */
    @ApiOperation(value = "日记列表（教师）")
    @GetMapping("listDiary1")
    public ResponseData listDiary1(){
        List<TDiary> list = diaryService.diarylist1();
        return MessageResult.success("200","日记列表",list);
    }

    /**
     * 日记详情
     * @return
     */
    @ApiOperation(value = "日记详情")
    @GetMapping("listDiaryById")
    public ResponseData listDiaryById(String diaryId){
        TDiary diary = diaryService.getById(diaryId);
        return MessageResult.success("200","日记列表",diary);
    }

    /**
     * 成绩分类数量
     * @return
     */
    @ApiOperation(value = "成绩分类数量")
    @GetMapping("fraction")
    public ResponseData fraction(){
        List<TDiary> list = diaryService.fraction();
        return MessageResult.success("200","日记列表",list);
    }

    /**
     * 编辑日记
     * @param diary
     * @return
     */
    @ApiOperation(value ="编辑日记")
    @PostMapping("addDiary")
    public ResponseMessage addRole(@RequestBody TDiary diary){
        if (diary.getDiaryId() == null){
            diary.setDiaryId(String.valueOf(UUID.randomUUID()));
            diary.setCreateTime(new Date());
            diary.setDiaryState(0);
            Boolean flag = diaryService.save(diary);
            if (flag){
                return MessageResult.success("200","新增成功");
            }else{
                return MessageResult.success("500","新增失败");
            }
        }else{
            diary.setUpdateTime(new Date());
            diary.setDiaryState(0);
            Boolean flag = diaryService.updateById(diary);
            if (flag){
                return MessageResult.success("200","修改成功");
            }else{
                return MessageResult.success("500","修改失败");
            }
        }
    }

    /**
     * 修改状态
     * @param diary
     * @return
     */
    @ApiOperation(value = "修改状态")
    @PostMapping("updateDiaryState")
    public ResponseMessage updateDiaryState(@RequestBody TDiary diary, HttpServletRequest request){
        //验证是否登陆
        QueryWrapper<TUser> userToken = new QueryWrapper<>();
        userToken.eq("token",request.getHeader("token"));
        TUser tUser = userService.getOne(userToken);
        if (tUser == null){
            return MessageResult.success("401","无权限访问");
        }
        diary.setUpdateTime(new Date());
        diary.setStudentId(tUser.getId());
        Boolean flag = diaryService.updateById(diary);
        if (flag){
            return MessageResult.success("200","提交成功");
        }else{
            return MessageResult.success("500","提交失败");
        }
    }

    /**
     * 删除日记
     * @param diaryId
     * @return
     */
    @ApiOperation(value = "删除日记")
    @PostMapping("deleteDiary")
    public ResponseMessage deleteDiary(String diaryId){
        Boolean flag = diaryService.removeById(diaryId);
        if (flag){
            return MessageResult.success("200","删除成功");
        }else{
            return MessageResult.success("500","删除失败");
        }
    }

    /**
     * 批量删除日记
     * @param diaryId
     * @return
     */
    @ApiOperation(value = "批量删除日记")
    @PostMapping("deleteListRole")
    public ResponseMessage deleteListRole(String diaryId){
        String[] ids = diaryId.split(",");
        List<String> list = Arrays.asList(ids);
        Boolean flag = diaryService.removeByIds(list);
        if (flag){
            return MessageResult.success("200","删除成功");
        }
        return MessageResult.success("500","删除失败");
    }
}
