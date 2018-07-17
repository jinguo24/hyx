package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.AreaInfo;
import com.simple.mapper.AreaInfoMapper;
import com.simple.service.AreaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaInfoServiceImpl implements AreaInfoService {
	
	@Autowired
    AreaInfoMapper areaInfoMapper;


    @Override
    public PageInfo<AreaInfo> listAsPage(AreaInfo record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> areaInfoMapper.findList(record));
    }

    @Override
    public AreaInfo getById(String id) {
        return areaInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(AreaInfo record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            areaInfoMapper.insert(record);
        } else {
            areaInfoMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        areaInfoMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
