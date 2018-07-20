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
import com.simple.domain.po.Recruit;
import com.simple.service.RecruitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("recruit")
@Api(description="招聘接口")
public class RecruitController extends BaseController
{
	@Autowired
    private RecruitService recruitService;

    private Logger logger = Logger.getLogger(RecruitController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute Recruit recruit,Integer pageNum, Integer pageSize) {
    	if (null == recruit) recruit = new Recruit();
        final PageInfo<Recruit> page = recruitService.listAsPage(recruit, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@ModelAttribute Recruit recruit) {
        //Assert.notNull(recruit.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        recruitService.saveOrUpdate(recruit);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@ModelAttribute  Recruit recruit) {
        recruitService.saveOrUpdate(recruit);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        recruitService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
	
	
	
}
