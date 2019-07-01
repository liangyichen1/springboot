package com.llfy.demo.oa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.llfy.demo.base.entity.BaseEntity;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author llfy
 * @since 2018-11-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TDiary extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId("diary_id")
    private String diaryId;

    /**
     * 学生id
     */
    @TableField("student_id")
    private String studentId;

    /**
     * 教师id
     */
    @TableField("teacher_id")
    private String teacherId;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    /**
     * 日记标题
     */
    @TableField("diary_title")
    private String diaryTitle;

    @TableField("diary_text")
    private String diaryText;

    /**
     * 状态：0未提交；1待审核；2驳回；3打分后；
     */
    @TableField("diary_state")
    private Integer diaryState;

    /**
     * 评价
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 成绩
     */
    @TableField("fraction")
    private String fraction;
}
