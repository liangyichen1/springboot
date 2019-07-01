package com.llfy.demo.oa.service.impl;

import com.llfy.demo.oa.entity.TDialogue;
import com.llfy.demo.oa.mapper.TDialogueMapper;
import com.llfy.demo.oa.service.ITDialogueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author llfy
 * @since 2018-12-03
 */
@Service
public class TDialogueServiceImpl extends ServiceImpl<TDialogueMapper, TDialogue> implements ITDialogueService {

    @Autowired
    private TDialogueMapper dialogueMapper;

    @Override
    public List<TDialogue> dialogueList(String userAId, String userBId) {
        return dialogueMapper.dialogueList(userAId,userBId);
    }

    @Override
    public List<TDialogue> dialogueMessage(String userId) {
        return dialogueMapper.dialogueMessage(userId);
    }
}
