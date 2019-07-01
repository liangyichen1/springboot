package com.llfy.demo.oa.service.impl;

import com.llfy.demo.oa.entity.TMenu;
import com.llfy.demo.oa.mapper.TMenuMapper;
import com.llfy.demo.oa.service.ITMenuService;
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
 * @since 2018-11-30
 */
@Service
public class TMenuServiceImpl extends ServiceImpl<TMenuMapper, TMenu> implements ITMenuService {

    @Autowired
    private TMenuMapper menuMapper;

    @Override
    public List<TMenu> powerByRole(Integer status, String roleId) {
        return menuMapper.powerByRole(status,roleId);
    }
}
