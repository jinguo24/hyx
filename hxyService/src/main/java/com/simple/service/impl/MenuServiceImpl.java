package com.simple.service.impl;

import java.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Menu;
import com.simple.mapper.MenuMapper;
import com.simple.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
    MenuMapper menuMapper;


    @Override
    public PageInfo<Menu> listAsPage(Menu record, Integer pageIndex, Integer pageSize) {
        return PageHelper.startPage(pageIndex, pageSize,"sort_num desc,create_time desc ").doSelectPageInfo(() -> menuMapper.findList(record));
    }

    @Override
    public Menu getById(String id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Menu record) {
        if (record.getId() == null) {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            menuMapper.insert(record);
        } else {
            menuMapper.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public void deleteById(String id) {
        menuMapper.deleteByPrimaryKey(id);
    }
    
    
    
    
    
    
    
    
}
