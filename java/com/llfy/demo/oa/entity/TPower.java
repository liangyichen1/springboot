package com.llfy.demo.oa.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.llfy.demo.base.entity.BaseEntity;
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
@TableName("t_power")
public class TPower extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "power_id")
    private String powerId;

    @TableField(value = "menu_id")
    private String menuId;

    @TableField(value = "role_id")
    private String roleId;

    @TableField(value = "status")
    private Integer status;

}
