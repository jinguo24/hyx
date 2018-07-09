package com.simple.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;
import com.simple.domain.po.Menu;
import com.simple.service.MenuService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("menu")
public class MenuController extends BaseController
{
	@Autowired
    private MenuService menuService;

    private Logger logger = Logger.getLogger(MenuController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute Menu menu,Integer pageNum, Integer pageSize) {
    	if (null == menu) menu = new Menu();
        final PageInfo<Menu> page = menuService.listAsPage(menu, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@ModelAttribute Menu menu) {
        //Assert.notNull(menu.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        menuService.saveOrUpdate(menu);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@ModelAttribute  Menu menu) {
        menuService.saveOrUpdate(menu);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        menuService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
	
	
	
}
