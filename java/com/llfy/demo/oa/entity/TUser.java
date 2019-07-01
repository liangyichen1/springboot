package com.llfy.demo.oa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.llfy.demo.base.entity.BaseEntity;

import java.beans.Transient;
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
 * @since 2018-11-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_user")
public class TUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * uuid
     */
    @TableId("id")
    private String id;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    /**
     * 用户email
     */
    @TableField("user_email")
    private String userEmail;

    /**
     * 用户电话
     */
    @TableField("user_phone")
    private String userPhone;

    /**
     * 用户状态：0启用；1停用
     */
    @TableField("user_state")
    private Integer userState;

    /**
     * 用户密码
     */
    @TableField("user_pwd")
    private String userPwd;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date updateTime;

    /**
     * role_id
     */
    @TableField("role_id")
    private String roleId;

    @TableField("token")
    private String token;

}
