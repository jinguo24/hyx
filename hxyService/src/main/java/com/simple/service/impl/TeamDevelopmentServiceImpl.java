package com.simple.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.domain.po.TeamDevelopment;
import com.simple.mapper.TeamDevelopmentMapper;
import com.simple.service.TeamDevelopmentService;

@Service
public class TeamDevelopmentServiceImpl implements TeamDevelopmentService {
	
	@Autowired
    TeamDevelopmentMapper teamDevelopmentMapper;


    @Override
    public PageInfo<TeamDevelopment> listAsPage(TeamDevelopment record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> teamDevelopmentMapper.findList(record));
    }

    @Override
    public TeamDevelopment getById(String id) {
        return teamDevelopmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(TeamDevelopment record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            teamDevelopmentMapper.insert(record);
        } else {
            teamDevelopmentMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        teamDevelopmentMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
