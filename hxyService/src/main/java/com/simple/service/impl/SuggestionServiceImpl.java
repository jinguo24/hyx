package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Suggestion;
import com.simple.mapper.SuggestionMapper;
import com.simple.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {
	
	@Autowired
    SuggestionMapper suggestionMapper;


    @Override
    public PageInfo<Suggestion> listAsPage(Suggestion record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> suggestionMapper.findList(record));
    }

    @Override
    public Suggestion getById(String id) {
        return suggestionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Suggestion record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            suggestionMapper.insert(record);
        } else {
            suggestionMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        suggestionMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
