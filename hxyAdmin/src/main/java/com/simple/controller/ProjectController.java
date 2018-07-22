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
import com.simple.domain.po.Project;
import com.simple.service.ProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("project")
@Api(description="项目查询接口")
public class ProjectController extends BaseController
{
	@Autowired
    private ProjectService projectService;

    private Logger logger = Logger.getLogger(ProjectController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute Project project,Integer pageNum, Integer pageSize) {
    	if (null == project) project = new Project();
        final PageInfo<Project> page = projectService.listAsPage(project, pageNum, pageSize);
        return new ResultData(page);
    }

//    @PostMapping("add")
//    public ResultData add(@RequestBody Project project) {
//        //Assert.notNull(project.getName(), "角色名不能为空");
//        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
//        projectService.saveOrUpdate(project);
//        return new ResultData();
//    }
//
//    @PostMapping("update")
//    public ResultData update(@RequestBody Project project) {
//        projectService.saveOrUpdate(project);
//        return new ResultData();
//    }
//
//    @GetMapping("/del")
//     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
//    public ResultData delete(String id) {
//        projectService.deleteById(id);
//        return new ResultData(Result.SUCCESS, "删除成功", null);
//    }
//    
//     @GetMapping("/findById")
//     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
//    public ResultData findById(String id) {
//    	return new ResultData(Result.SUCCESS,"查询成功",projectService.getById(id));
//    }
	
	
	
}
