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
import com.simple.domain.po.MarketingPic;
import com.simple.service.MarketingPicService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("marketingPic")
public class MarketingPicController extends BaseController
{
	@Autowired
    private MarketingPicService marketingPicService;

    private Logger logger = Logger.getLogger(MarketingPicController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute MarketingPic marketingPic,Integer pageNum, Integer pageSize) {
    	if (null == marketingPic) marketingPic = new MarketingPic();
        final PageInfo<MarketingPic> page = marketingPicService.listAsPage(marketingPic, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@ModelAttribute MarketingPic marketingPic) {
        //Assert.notNull(marketingPic.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        marketingPicService.saveOrUpdate(marketingPic);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@ModelAttribute  MarketingPic marketingPic) {
        marketingPicService.saveOrUpdate(marketingPic);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        marketingPicService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
	
	
	
}
