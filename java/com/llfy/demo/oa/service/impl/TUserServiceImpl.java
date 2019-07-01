package com.llfy.demo.oa.service.impl;

import com.llfy.demo.oa.entity.TUser;
import com.llfy.demo.oa.mapper.TUserMapper;
import com.llfy.demo.oa.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author llfy
 * @since 2018-11-23
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public Boolean getUserByName(TUser user) {
        TUser tUser = userMapper.getUserByName(user);
        if (tUser != null ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public TUser getUser(TUser user) {
        return userMapper.getUser(user);
    }

    @Override
    public Boolean getUserByNameAndId(TUser user) {
        TUser tUser = userMapper.getUserByNameAndId(user);
        if (tUser != null ){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public List<TUser> listUser(String userName) {
        return userMapper.listUser(userName);
    }
}
