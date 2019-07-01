package com.llfy.demo.oa.mapper;

import com.llfy.demo.oa.entity.TMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author llfy
 * @since 2018-11-30
 */
public interface TMenuMapper extends BaseMapper<TMenu> {

    List<TMenu> powerByRole(@Param("status") Integer status, @Param("roleId") String roleId);

}
