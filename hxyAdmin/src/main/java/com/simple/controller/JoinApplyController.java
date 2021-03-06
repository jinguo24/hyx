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
import com.simple.domain.po.JoinApply;
import com.simple.service.JoinApplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("joinApply")
@Api(description="申请加盟")
public class JoinApplyController extends BaseController
{
	@Autowired
    private JoinApplyService joinApplyService;

    private Logger logger = Logger.getLogger(JoinApplyController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute JoinApply joinApply,Integer pageNum, Integer pageSize) {
    	if (null == joinApply) joinApply = new JoinApply();
        final PageInfo<JoinApply> page = joinApplyService.listAsPage(joinApply, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@RequestBody JoinApply joinApply) {
        //Assert.notNull(joinApply.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        joinApplyService.saveOrUpdate(joinApply);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@RequestBody JoinApply joinApply) {
        joinApplyService.saveOrUpdate(joinApply);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        joinApplyService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",joinApplyService.getById(id));
    }
	
	
	
}
