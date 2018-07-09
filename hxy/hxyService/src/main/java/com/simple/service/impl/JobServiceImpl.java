package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Job;
import com.simple.mapper.JobMapper;
import com.simple.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
    JobMapper jobMapper;


    @Override
    public PageInfo<Job> listAsPage(Job record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> jobMapper.findList(record));
    }

    @Override
    public Job getById(String id) {
        return jobMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Job record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            jobMapper.insert(record);
        } else {
            jobMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        jobMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
