package com.simple.controller;

import org.apache.commons.lang3.StringUtils;
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
import com.simple.domain.po.Area;
import com.simple.service.AreaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Api(description="获取省市区接口")
@RestController
@RequestMapping("area")
public class AreaController extends BaseController
{
	@Autowired
    private AreaService areaService;

    private Logger logger = Logger.getLogger(AreaController.class);

//    @GetMapping("list")
//        @ApiImplicitParams({
//    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
//    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
//    public ResultData list(@ModelAttribute Area area,Integer pageNum, Integer pageSize) {
//    	if (null == area) area = new Area();
//        final PageInfo<Area> page = areaService.listAsPage(area, pageNum, pageSize);
//        return new ResultData(page);
//    }
    @ApiOperation("通过父级code 获取子级别,查所有省份 ，可不传")
    @GetMapping("findByParentCode")
    @ApiImplicitParam(name="code",value="code",dataType="int", paramType = "query",required=false)
    public ResultData findByParentCode(Integer code) {
    	if(code==null) {
    		code =0;
    	}
    	 Area area = new Area();
    	 area.setParentID(code);
    	 final PageInfo<Area> page = areaService.listAsPage(area, 1, 1000);
    	 return new ResultData(page);
    }
    
//    @GetMapping("AllList")
//    public ResultData allList() {
//    	  Area area =new Area(); 
//    	  area.setParentID(0);
//    	  final PageInfo<Area> page = areaService.listAsPage(area, 1, 1000);
//    	  for(Area a: page.getList()) {
//    		  area =new Area(); 
//        	  area.setParentID(a.getCode());
//        	  final PageInfo<Area> cityPage = areaService.listAsPage(area, 1, 1000);
//        	  a.setSubList(cityPage.getList());
//        	  for(Area ar:cityPage.getList()) {
//        		  area =new Area(); 
//            	  area.setParentID(ar.getCode());
//            	  final PageInfo<Area> areaPage = areaService.listAsPage(area, 1, 1000);
//            	  ar.setSubList(cityPage.getList());
//        	  }
//    	  }
//          return new ResultData(page);
//    }

//    @PostMapping("add")
//    public ResultData add(@ModelAttribute Area area) {
//        //Assert.notNull(area.getName(), "角色名不能为空");
//        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
//        areaService.saveOrUpdate(area);
//        return new ResultData();
//    }
//
//    @PostMapping("update")
//    public ResultData update(@ModelAttribute  Area area) {
//        areaService.saveOrUpdate(area);
//        return new ResultData();
//    }
//
//    @GetMapping("/del")
//     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
//    public ResultData delete(String id) {
//        areaService.deleteById(id);
//        return new ResultData(Result.SUCCESS, "删除成功", null);
//    }
//	
//	
	
}
