package com.simple.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.domain.po.Question;
import com.simple.mapper.QuestionMapper;
import com.simple.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
    QuestionMapper questionMapper;


    @Override
    public PageInfo<Question> listAsPage(Question record, Integer pageIndex, Integer pageSize) {
    	String orderBy =" query_count desc ";
        return PageHelper.startPage(pageIndex, pageSize,orderBy).doSelectPageInfo(() -> questionMapper.findList(record));
    }

    @Override
    public Question getById(String id) {
        return questionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Question record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            questionMapper.insert(record);
        } else {
            questionMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        questionMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
