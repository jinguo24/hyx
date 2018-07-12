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
import com.simple.domain.po.Question;
import com.simple.service.QuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("question")
@Api(description="常见问题维护")
public class QuestionController extends BaseController
{
	@Autowired
    private QuestionService questionService;

    private Logger logger = Logger.getLogger(QuestionController.class);

    @ApiOperation("列表")
    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute Question question,Integer pageNum, Integer pageSize) {
    	if (null == question) question = new Question();
        final PageInfo<Question> page = questionService.listAsPage(question, pageNum, pageSize);
        return new ResultData(page);
    }

    @ApiOperation("新增")
    @PostMapping("add")
    public ResultData add(@RequestBody Question question) {
        //Assert.notNull(question.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        questionService.saveOrUpdate(question);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@RequestBody  Question question) {
        questionService.saveOrUpdate(question);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        questionService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
	
    
    @GetMapping("/findById")
    @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
   public ResultData findById(String id) {
       return new ResultData(Result.SUCCESS, "成功",  questionService.getById(id));
   }
	
	
}
