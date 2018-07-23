package com.simple.controller;

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
import com.simple.domain.po.Resume;
import com.simple.service.ResumeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("resume")
@Api(description="简历查询接口")
public class ResumeController extends BaseController
{
	@Autowired
    private ResumeService resumeService;

    private Logger logger = Logger.getLogger(ResumeController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute Resume resume,Integer pageNum, Integer pageSize) {
    	if (null == resume) resume = new Resume();
        final PageInfo<Resume> page = resumeService.listAsPage(resume, pageNum, pageSize);
        return new ResultData(page);
    }
//
//    @PostMapping("add")
//    public ResultData add(@RequestBody Resume resume) {
//        //Assert.notNull(resume.getName(), "角色名不能为空");
//        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
//        resumeService.saveOrUpdate(resume);
//        return new ResultData();
//    }
//
//    @PostMapping("update")
//    public ResultData update(@RequestBody Resume resume) {
//        resumeService.saveOrUpdate(resume);
//        return new ResultData();
//    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        resumeService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",resumeService.getById(id));
    }
	
	
	
}
