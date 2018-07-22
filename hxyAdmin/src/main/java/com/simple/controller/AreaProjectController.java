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
import com.simple.domain.po.AreaProject;
import com.simple.service.AreaProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("areaProject")
@Api(description="地区项目管理")
public class AreaProjectController extends BaseController
{
	@Autowired
    private AreaProjectService areaProjectService;

    private Logger logger = Logger.getLogger(AreaProjectController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute AreaProject areaProject,Integer pageNum, Integer pageSize) {
    	if (null == areaProject) areaProject = new AreaProject();
        final PageInfo<AreaProject> page = areaProjectService.listAsPage(areaProject, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@RequestBody AreaProject areaProject) {
        //Assert.notNull(areaProject.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        areaProjectService.saveOrUpdate(areaProject);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@RequestBody AreaProject areaProject) {
        areaProjectService.saveOrUpdate(areaProject);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        areaProjectService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",areaProjectService.getById(id));
    }
	
	
	
}
