package com.simple.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.domain.po.Menu;
import com.simple.service.MenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Api(description="首页导航接口")
@RestController
@RequestMapping("menu")
public class MenuController extends BaseController
{
	@Autowired
    private MenuService menuService;

    private Logger logger = Logger.getLogger(MenuController.class);

//    @GetMapping("list")
//        @ApiImplicitParams({
//    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
//    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
//    public ResultData list(@ModelAttribute Menu menu,Integer pageNum, Integer pageSize) {
//    	if (null == menu) menu = new Menu();
//        final PageInfo<Menu> page = menuService.listAsPage(menu, pageNum, pageSize);
//        return new ResultData(page);
//    }
    
    
    @ApiOperation("查询导航列表")
    @GetMapping("findAllList")
    public  ResultData findAllList() {
    int pageSize=1000;int pageNum=1;
    Menu menu = new Menu();
    menu.setParentId("0");
    final PageInfo<Menu> page = menuService.listAsPage(menu, pageNum, pageSize);//查一级导航
    for(Menu m:page.getList()) {
    	 menu = new Menu();
    	 menu.setParentId(m.getId());
    	 final PageInfo<Menu> pages = menuService.listAsPage(menu, pageNum, pageSize);//查二级导航
    	 m.setSubMenus(pages.getList());
    }
    return new ResultData(page);	
    }

    
    @ApiOperation("添加/修改导航接口【添加一级导航时,parentId 传0  二级导航传一级导航的id】")
    @PostMapping("add")
    public ResultData add(@RequestBody Menu menu) {
        //Assert.notNull(menu.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        menuService.saveOrUpdate(menu);
        return new ResultData();
    }

    @PostMapping("updateStatus")
    public ResultData updateStatus(@RequestBody  Menu menu) {
    	Menu temp = new Menu();
    	temp.setId(menu.getId());
    	temp.setStatus(menu.getStatus());
        menuService.saveOrUpdate(temp);
        return new ResultData();
    }
    
    @PostMapping("update")
    public ResultData update(@RequestBody  Menu menu) {
        menuService.saveOrUpdate(menu);
        return new ResultData();
    }
    
    @ApiOperation("查询详情接口")
    @GetMapping("/findById")
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",menuService.getById(id));
    }
	
    @ApiOperation("删除导航接口")
    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        menuService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
	
	
	
}
