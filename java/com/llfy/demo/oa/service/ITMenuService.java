package com.llfy.demo.oa.service;

import com.llfy.demo.oa.entity.TMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author llfy
 * @since 2018-11-30
 */
public interface ITMenuService extends IService<TMenu> {

    List<TMenu> powerByRole(Integer status, String roleId);

}
