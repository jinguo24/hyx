package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.ObtainEmployment;
import com.simple.mapper.ObtainEmploymentMapper;
import com.simple.service.ObtainEmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObtainEmploymentServiceImpl implements ObtainEmploymentService {
	
	@Autowired
    ObtainEmploymentMapper obtainEmploymentMapper;


    @Override
    public PageInfo<ObtainEmployment> listAsPage(ObtainEmployment record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> obtainEmploymentMapper.findList(record));
    }

    @Override
    public ObtainEmployment getById(String id) {
        return obtainEmploymentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(ObtainEmployment record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            obtainEmploymentMapper.insertSelective(record);
        } else {
            obtainEmploymentMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        obtainEmploymentMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
