package com.llfy.demo.oa.service;

import com.llfy.demo.oa.entity.TDiary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author llfy
 * @since 2018-11-28
 */
public interface ITDiaryService extends IService<TDiary> {

    List<TDiary> diarylist();

    List<TDiary> diarylist1();

    List<TDiary> fraction();
}
