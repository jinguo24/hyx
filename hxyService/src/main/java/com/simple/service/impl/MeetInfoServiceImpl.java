package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.MeetInfo;
import com.simple.mapper.MeetInfoMapper;
import com.simple.service.MeetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetInfoServiceImpl implements MeetInfoService {
	
	@Autowired
    MeetInfoMapper meetInfoMapper;


    @Override
    public PageInfo<MeetInfo> listAsPage(MeetInfo record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> meetInfoMapper.findList(record));
    }

    @Override
    public MeetInfo getById(String id) {
        return meetInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(MeetInfo record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            meetInfoMapper.insertSelective(record);
        } else {
            meetInfoMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        meetInfoMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
