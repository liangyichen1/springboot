package com.llfy.demo.oa.mapper;

import com.llfy.demo.oa.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author llfy
 * @since 2018-11-23
 */
public interface TUserMapper extends BaseMapper<TUser> {


    TUser getUserByName(TUser user);

    TUser getUser(TUser user);

    TUser getUserByNameAndId(TUser user);

    List<TUser> listUser(@Param("userName") String userName);
}
