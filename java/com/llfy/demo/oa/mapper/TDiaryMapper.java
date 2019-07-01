package com.llfy.demo.oa.mapper;

import com.llfy.demo.oa.entity.TDiary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author llfy
 * @since 2018-11-28
 */
public interface TDiaryMapper extends BaseMapper<TDiary> {

    List<TDiary> diarylist();

    List<TDiary> diarylist1();

    List<TDiary> fraction();
}
