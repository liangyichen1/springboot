package com.llfy.demo.oa.entity;

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
 * @since 2018-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String menuId;

    private String menuName;


}
