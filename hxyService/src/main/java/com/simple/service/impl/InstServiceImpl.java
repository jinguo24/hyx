package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Inst;
import com.simple.mapper.InstMapper;
import com.simple.service.InstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstServiceImpl implements InstService {
	
	@Autowired
    InstMapper instMapper;


    @Override
    public PageInfo<Inst> listAsPage(Inst record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> instMapper.findList(record));
    }

    @Override
    public Inst getById(String id) {
        return instMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Inst record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            instMapper.insert(record);
        } else {
            instMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        instMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
