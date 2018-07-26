package com.simple.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.common.rest.ResultData;
import com.simple.domain.po.MeetInfo;
import com.simple.service.MeetInfoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("meetInfo")
@Api(description="申请加盟信息接口")
public class MeetInfoController extends BaseController
{
	@Autowired
    private MeetInfoService meetInfoService;

    private Logger logger = Logger.getLogger(MeetInfoController.class);

//    @GetMapping("list")
//        @ApiImplicitParams({
//    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
//    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
//    public ResultData list(@ModelAttribute MeetInfo meetInfo,Integer pageNum, Integer pageSize) {
//    	if (null == meetInfo) meetInfo = new MeetInfo();
//        final PageInfo<MeetInfo> page = meetInfoService.listAsPage(meetInfo, pageNum, pageSize);
//        return new ResultData(page);
//    }

    @PostMapping("add")
    public ResultData add(@RequestBody MeetInfo meetInfo) {
        //Assert.notNull(meetInfo.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        meetInfoService.saveOrUpdate(meetInfo);
        return new ResultData();
    }

//    @PostMapping("update")
//    public ResultData update(@RequestBody MeetInfo meetInfo) {
//        meetInfoService.saveOrUpdate(meetInfo);
//        return new ResultData();
//    }
//
//    @GetMapping("/del")
//     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
//    public ResultData delete(String id) {
//        meetInfoService.deleteById(id);
//        return new ResultData(Result.SUCCESS, "删除成功", null);
//    }
//    
//     @GetMapping("/findById")
//     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
//    public ResultData findById(String id) {
//    	return new ResultData(Result.SUCCESS,"查询成功",meetInfoService.getById(id));
//    }
//	
}
