package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.JoinApply;
import com.simple.mapper.JoinApplyMapper;
import com.simple.service.JoinApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinApplyServiceImpl implements JoinApplyService {
	
	@Autowired
    JoinApplyMapper joinApplyMapper;


    @Override
    public PageInfo<JoinApply> listAsPage(JoinApply record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> joinApplyMapper.findList(record));
    }

    @Override
    public JoinApply getById(String id) {
        return joinApplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(JoinApply record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            joinApplyMapper.insertSelective(record);
        } else {
            joinApplyMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        joinApplyMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
