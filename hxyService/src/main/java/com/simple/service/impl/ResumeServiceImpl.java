package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Resume;
import com.simple.mapper.ResumeMapper;
import com.simple.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {
	
	@Autowired
    ResumeMapper resumeMapper;


    @Override
    public PageInfo<Resume> listAsPage(Resume record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> resumeMapper.findList(record));
    }

    @Override
    public Resume getById(String id) {
        return resumeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Resume record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            resumeMapper.insertSelective(record);
        } else {
            resumeMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        resumeMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
