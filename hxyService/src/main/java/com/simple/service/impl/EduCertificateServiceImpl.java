package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.EduCertificate;
import com.simple.mapper.EduCertificateMapper;
import com.simple.service.EduCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EduCertificateServiceImpl implements EduCertificateService {
	
	@Autowired
    EduCertificateMapper eduCertificateMapper;


    @Override
    public PageInfo<EduCertificate> listAsPage(EduCertificate record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> eduCertificateMapper.findList(record));
    }

    @Override
    public EduCertificate getById(String id) {
        return eduCertificateMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(EduCertificate record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            eduCertificateMapper.insert(record);
        } else {
            eduCertificateMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        eduCertificateMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
