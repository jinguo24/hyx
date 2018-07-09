package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.MarketingPic;
import com.simple.mapper.MarketingPicMapper;
import com.simple.service.MarketingPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketingPicServiceImpl implements MarketingPicService {
	
	@Autowired
    MarketingPicMapper marketingPicMapper;


    @Override
    public PageInfo<MarketingPic> listAsPage(MarketingPic record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> marketingPicMapper.findList(record));
    }

    @Override
    public MarketingPic getById(String id) {
        return marketingPicMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(MarketingPic record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            marketingPicMapper.insert(record);
        } else {
            marketingPicMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        marketingPicMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
