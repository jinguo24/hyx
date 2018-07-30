package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.GroupIntroduction;
import com.simple.mapper.GroupIntroductionMapper;
import com.simple.service.GroupIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupIntroductionServiceImpl implements GroupIntroductionService {
	
	@Autowired
    GroupIntroductionMapper groupIntroductionMapper;


    @Override
    public PageInfo<GroupIntroduction> listAsPage(GroupIntroduction record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> groupIntroductionMapper.findList(record));
    }

    @Override
    public GroupIntroduction getById(String id) {
        return groupIntroductionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(GroupIntroduction record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            groupIntroductionMapper.insertSelective(record);
        } else {
            groupIntroductionMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        groupIntroductionMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
