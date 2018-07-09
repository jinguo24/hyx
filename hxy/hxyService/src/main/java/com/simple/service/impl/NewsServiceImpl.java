package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.News;
import com.simple.mapper.NewsMapper;
import com.simple.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
    NewsMapper newsMapper;


    @Override
    public PageInfo<News> listAsPage(News record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> newsMapper.findList(record));
    }

    @Override
    public News getById(String id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(News record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            newsMapper.insert(record);
        } else {
            newsMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        newsMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
