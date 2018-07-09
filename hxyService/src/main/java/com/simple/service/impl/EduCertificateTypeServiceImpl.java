package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.EduCertificateType;
import com.simple.mapper.EduCertificateTypeMapper;
import com.simple.service.EduCertificateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EduCertificateTypeServiceImpl implements EduCertificateTypeService {
	
	@Autowired
    EduCertificateTypeMapper eduCertificateTypeMapper;


    @Override
    public PageInfo<EduCertificateType> listAsPage(EduCertificateType record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize).doSelectPageInfo(() -> eduCertificateTypeMapper.findList(record));
    }

    @Override
    public EduCertificateType getById(String id) {
        return eduCertificateTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(EduCertificateType record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            eduCertificateTypeMapper.insert(record);
        } else {
            eduCertificateTypeMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        eduCertificateTypeMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
