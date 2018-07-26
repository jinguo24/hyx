package com.simple.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.simple.common.rest.ResultData;
import com.simple.domain.po.Banner;
import com.simple.service.BannerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("banner")
@Api(description="首页轮播图")
public class BannerController extends BaseController
{
	@Autowired
    private BannerService bannerService;

    private Logger logger = Logger.getLogger(BannerController.class);

    @GetMapping("list")
        @ApiImplicitParams({
//    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="条数",dataType="int", paramType = "query",required=false)})
    public ResultData list(Integer pageSize) {
    	Banner banner = new Banner();
    	pageSize = pageSize==null?5:pageSize;
        final PageInfo<Banner> page = bannerService.listAsPage(banner, 1, pageSize);
        return new ResultData(page);
    }

//    @PostMapping("add")
//    public ResultData add(@RequestBody Banner banner) {
//        //Assert.notNull(banner.getName(), "角色名不能为空");
//        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
//        bannerService.saveOrUpdate(banner);
//        return new ResultData();
//    }
//
//    @PostMapping("update")
//    public ResultData update(@RequestBody Banner banner) {
//        bannerService.saveOrUpdate(banner);
//        return new ResultData();
//    }
//
//    @GetMapping("/del")
//     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
//    public ResultData delete(String id) {
//        bannerService.deleteById(id);
//        return new ResultData(Result.SUCCESS, "删除成功", null);
//    }
//    
//     @GetMapping("/findById")
//     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
//    public ResultData findById(String id) {
//    	return new ResultData(Result.SUCCESS,"查询成功",bannerService.getById(id));
//    }
//	
//	
//	
}
