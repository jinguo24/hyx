package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Banner;
import com.simple.mapper.BannerMapper;
import com.simple.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {
	
	@Autowired
    BannerMapper bannerMapper;


    @Override
    public PageInfo<Banner> listAsPage(Banner record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> bannerMapper.findList(record));
    }

    @Override
    public Banner getById(String id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Banner record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            bannerMapper.insert(record);
        } else {
            bannerMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        bannerMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
