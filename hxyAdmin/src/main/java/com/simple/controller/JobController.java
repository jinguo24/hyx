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
import com.simple.domain.po.Job;
import com.simple.service.JobService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
@Api(description="招聘就业接口")
@RestController
@RequestMapping("job")
public class JobController extends BaseController
{
	@Autowired
    private JobService jobService;

    private Logger logger = Logger.getLogger(JobController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute Job job,Integer pageNum, Integer pageSize) {
    	if (null == job) job = new Job();
        final PageInfo<Job> page = jobService.listAsPage(job, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@RequestBody Job job) {
        //Assert.notNull(job.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        jobService.saveOrUpdate(job);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@RequestBody  Job job) {
        jobService.saveOrUpdate(job);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        jobService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
	
    @GetMapping("/findById")
    @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
   public ResultData findById(String id) {
   	return new ResultData(Result.SUCCESS,"查询成功",jobService.getById(id));
   }
	
}
