package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Project;
import com.simple.mapper.ProjectMapper;
import com.simple.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
    ProjectMapper projectMapper;


    @Override
    public PageInfo<Project> listAsPage(Project record, Integer pageIndex, Integer pageSize) {
    	record.setStatus(0);
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> projectMapper.findList(record));
    }

    @Override
    public Project getById(String id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Project record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            projectMapper.insert(record);
        } else {
            projectMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        projectMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
