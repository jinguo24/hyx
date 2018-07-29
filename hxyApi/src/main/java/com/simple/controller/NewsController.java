package com.simple.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.domain.po.News;
import com.simple.service.NewsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("news")
@Api(description="新闻和合作伙伴接口")
public class NewsController extends BaseController
{
	@Autowired
    private NewsService newsService;

    private Logger logger = Logger.getLogger(NewsController.class);

    @ApiOperation("按浏览数排序的列表")
    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="type",value="类别 0：新闻 1.战略伙伴",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=false),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=false)})
    public ResultData list(Integer type,Integer pageNum, Integer pageSize) {
    	News news = new News();
    	news.setType(type);
    	pageSize = pageSize==null?5:pageSize;
    	pageNum= pageNum==null?1:pageNum;
        final PageInfo<News> page = newsService.listAsPage(news, pageNum, pageSize);
        return new ResultData(page);
    }
    
    @ApiOperation("按发布日期排序的列表")
    @GetMapping("newestList")
    @ApiImplicitParams({
	  @ApiImplicitParam(name="type",value="类别 0：新闻 1.战略伙伴",dataType="int", paramType = "query",required=true),
	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=false),
	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=false)})
    public ResultData newestList(Integer type,Integer pageNum, Integer pageSize) {
		News news = new News();
		news.setType(type);
		pageSize = pageSize==null?5:pageSize;
		pageNum= pageNum==null?1:pageNum;
	    final PageInfo<News> page = newsService.newestList(news, pageNum, pageSize);
    return new ResultData(page);
}
    
//
//    @PostMapping("add")
//    public ResultData add(@RequestBody News news) {
//        //Assert.notNull(news.getName(), "角色名不能为空");
//        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
//        newsService.saveOrUpdate(news);
//        return new ResultData();
//    }
//
//    @PostMapping("update")
//    public ResultData update(@RequestBody News news) {
//        newsService.saveOrUpdate(news);
//        return new ResultData();
//    }
//
//    @GetMapping("/del")
//     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
//    public ResultData delete(String id) {
//        newsService.deleteById(id);
//        return new ResultData(Result.SUCCESS, "删除成功", null);
//    }
//    
     @GetMapping("/findById")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData findById(String id) {
    	 News news = newsService.getById(id);
    	 News temp =new News();
    	 temp.setId(news.getId());
    	 temp.setQueryCount(news.getQueryCount()+1);
    	 newsService.saveOrUpdate(temp); 
    	return new ResultData(Result.SUCCESS,"查询成功",news);
    }
//	
//	
	
}
