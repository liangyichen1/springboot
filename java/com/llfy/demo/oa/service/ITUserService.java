package com.llfy.demo.oa.service;

import com.llfy.demo.oa.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author llfy
 * @since 2018-11-23
 */
public interface ITUserService extends IService<TUser> {

    Boolean getUserByName(TUser user);

    TUser getUser(TUser user);

    Boolean getUserByNameAndId(TUser user);

    List<TUser> listUser(String userName);
}
