package com.llfy.demo.oa.service.impl;

import com.llfy.demo.oa.entity.TRole;
import com.llfy.demo.oa.mapper.TRoleMapper;
import com.llfy.demo.oa.service.ITRoleService;
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
 * @since 2018-11-28
 */
@Service
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements ITRoleService {

    @Autowired
    private TRoleMapper roleMapper;

}
