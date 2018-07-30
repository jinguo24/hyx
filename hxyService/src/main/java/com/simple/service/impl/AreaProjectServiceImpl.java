package com.simple.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.domain.po.AreaProject;
import com.simple.mapper.AreaProjectMapper;
import com.simple.service.AreaProjectService;
@Service
public class AreaProjectServiceImpl implements AreaProjectService {
	
	@Autowired
    AreaProjectMapper areaProjectMapper;


    @Override
    public PageInfo<AreaProject> listAsPage(AreaProject record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> areaProjectMapper.findList(record));
    }

    @Override
    public AreaProject getById(String id) {
        return areaProjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(AreaProject record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            areaProjectMapper.insertSelective(record);
        } else {
            areaProjectMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        areaProjectMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
