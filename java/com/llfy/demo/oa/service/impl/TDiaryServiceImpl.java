package com.llfy.demo.oa.service.impl;

import com.llfy.demo.oa.entity.TDiary;
import com.llfy.demo.oa.mapper.TDiaryMapper;
import com.llfy.demo.oa.service.ITDiaryService;
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
public class TDiaryServiceImpl extends ServiceImpl<TDiaryMapper, TDiary> implements ITDiaryService {

    @Autowired
    private TDiaryMapper diaryMapper;
    @Override
    public List<TDiary> diarylist() {
        return diaryMapper.diarylist();
    }

    @Override
    public List<TDiary> diarylist1() {
        return diaryMapper.diarylist1();
    }

    @Override
    public List<TDiary> fraction() {
        return diaryMapper.fraction();
    }
}
