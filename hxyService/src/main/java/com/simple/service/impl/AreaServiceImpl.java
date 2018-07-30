package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Area;
import com.simple.mapper.AreaMapper;
import com.simple.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
    AreaMapper areaMapper;


    @Override
    public PageInfo<Area> listAsPage(Area record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> areaMapper.findList(record));
    }

    @Override
    public Area getById(String id) {
        return areaMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Area record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            areaMapper.insertSelective(record);
        } else {
            areaMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        areaMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
