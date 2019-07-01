package com.llfy.demo.oa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.llfy.demo.base.entity.BaseEntity;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.scheduling.support.SimpleTriggerContext;

/**
 * <p>
 * 
 * </p>
 *
 * @author llfy
 * @since 2018-12-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_dialogue")
public class TDialogue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId("dialogue_id")
    private String dialogueId;

    @TableField("user_a_id")
    private String userAId;

    @TableField("user_b_id")
    private String userBId;

    @TableField("dialogue_content")
    private String dialogueContent;

    private Integer type;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    @TableField("state")
    private Integer state;

}
