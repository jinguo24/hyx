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
import com.simple.domain.po.MeetInfo;
import com.simple.service.MeetInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("meetInfo")
public class MeetInfoController extends BaseController
{
	@Autowired
    private MeetInfoService meetInfoService;

    private Logger logger = Logger.getLogger(MeetInfoController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute MeetInfo meetInfo,Integer pageNum, Integer pageSize) {
    	if (null == meetInfo) meetInfo = new MeetInfo();
        final PageInfo<MeetInfo> page = meetInfoService.listAsPage(meetInfo, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@ModelAttribute MeetInfo meetInfo) {
        //Assert.notNull(meetInfo.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        meetInfoService.saveOrUpdate(meetInfo);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@ModelAttribute  MeetInfo meetInfo) {
        meetInfoService.saveOrUpdate(meetInfo);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        meetInfoService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
	
	
	
}
