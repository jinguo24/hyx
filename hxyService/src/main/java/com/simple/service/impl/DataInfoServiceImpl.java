package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.DataInfo;
import com.simple.mapper.DataInfoMapper;
import com.simple.service.DataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataInfoServiceImpl implements DataInfoService {
	
	@Autowired
    DataInfoMapper dataInfoMapper;


    @Override
    public PageInfo<DataInfo> listAsPage(DataInfo record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> dataInfoMapper.findList(record));
    }

    @Override
    public DataInfo getById(String id) {
        return dataInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(DataInfo record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            dataInfoMapper.insert(record);
        } else {
            dataInfoMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        dataInfoMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
