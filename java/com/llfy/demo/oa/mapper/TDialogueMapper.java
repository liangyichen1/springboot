package com.llfy.demo.oa.mapper;

import com.llfy.demo.oa.entity.TDialogue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author llfy
 * @since 2018-12-03
 */
public interface TDialogueMapper extends BaseMapper<TDialogue> {


    List<TDialogue> dialogueList(@Param("userAId") String userAId,@Param("userBId") String userBId);

    List<TDialogue> dialogueMessage(String userId);
}
