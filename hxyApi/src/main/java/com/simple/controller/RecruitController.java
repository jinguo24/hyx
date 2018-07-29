package com.simple.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.domain.po.Recruit;
import com.simple.service.RecruitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("recruit")
@Api(description="招聘列表接口")
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

//    @PostMapping("add")
//    public ResultData add(@RequestBody Recruit recruit) {
//        //Assert.notNull(recruit.getName(), "角色名不能为空");
//        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
//        recruitService.saveOrUpdate(recruit);
//        return new ResultData();
//    }
//
//    @PostMapping("update")
//    public ResultData update(@RequestBody Recruit recruit) {
//        recruitService.saveOrUpdate(recruit);
//        return new ResultData();
//    }
//
//    @GetMapping("/del")
//     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
//    public ResultData delete(String id) {
//        recruitService.deleteById(id);
//        return new ResultData(Result.SUCCESS, "删除成功", null);
//    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",recruitService.getById(id));
    }
	
	
	
}
