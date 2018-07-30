package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Recruit;
import com.simple.mapper.RecruitMapper;
import com.simple.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruitServiceImpl implements RecruitService {
	
	@Autowired
    RecruitMapper recruitMapper;


    @Override
    public PageInfo<Recruit> listAsPage(Recruit record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> recruitMapper.findList(record));
    }

    @Override
    public Recruit getById(String id) {
        return recruitMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Recruit record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            recruitMapper.insertSelective(record);
        } else {
            recruitMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        recruitMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
