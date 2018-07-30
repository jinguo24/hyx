package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Notice;
import com.simple.mapper.NoticeMapper;
import com.simple.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
    NoticeMapper noticeMapper;


    @Override
    public PageInfo<Notice> listAsPage(Notice record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> noticeMapper.findList(record));
    }

    @Override
    public Notice getById(String id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Notice record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            noticeMapper.insertSelective(record);
        } else {
            noticeMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        noticeMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
