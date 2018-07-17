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
import com.simple.domain.po.ObtainEmployment;
import com.simple.service.ObtainEmploymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
@Api(description="就业接口")
@RestController
@RequestMapping("obtainEmployment")
public class ObtainEmploymentController extends BaseController
{
	@Autowired
    private ObtainEmploymentService obtainEmploymentService;

    private Logger logger = Logger.getLogger(ObtainEmploymentController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute ObtainEmployment obtainEmployment,Integer pageNum, Integer pageSize) {
    	if (null == obtainEmployment) obtainEmployment = new ObtainEmployment();
        final PageInfo<ObtainEmployment> page = obtainEmploymentService.listAsPage(obtainEmployment, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@RequestBody ObtainEmployment obtainEmployment) {
        //Assert.notNull(obtainEmployment.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        obtainEmploymentService.saveOrUpdate(obtainEmployment);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@RequestBody ObtainEmployment obtainEmployment) {
        obtainEmploymentService.saveOrUpdate(obtainEmployment);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        obtainEmploymentService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	return new ResultData(Result.SUCCESS,"查询成功",obtainEmploymentService.getById(id));
    }
	
	
	
}
