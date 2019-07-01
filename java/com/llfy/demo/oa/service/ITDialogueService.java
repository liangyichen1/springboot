package com.llfy.demo.oa.service;

import com.llfy.demo.oa.entity.TDialogue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author llfy
 * @since 2018-12-03
 */
public interface ITDialogueService extends IService<TDialogue> {


    List<TDialogue> dialogueList(String userAId,String userBId);

    List<TDialogue> dialogueMessage(String userId);
}
