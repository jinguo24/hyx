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
import com.simple.domain.po.Notice;
import com.simple.service.NoticeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("notice")
public class NoticeController extends BaseController
{
	@Autowired
    private NoticeService noticeService;

    private Logger logger = Logger.getLogger(NoticeController.class);

    @GetMapping("list")
        @ApiImplicitParams({
    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
    public ResultData list(@ModelAttribute Notice notice,Integer pageNum, Integer pageSize) {
    	if (null == notice) notice = new Notice();
        final PageInfo<Notice> page = noticeService.listAsPage(notice, pageNum, pageSize);
        return new ResultData(page);
    }

    @PostMapping("add")
    public ResultData add(@ModelAttribute Notice notice) {
        //Assert.notNull(notice.getName(), "角色名不能为空");
        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
        noticeService.saveOrUpdate(notice);
        return new ResultData();
    }

    @PostMapping("update")
    public ResultData update(@ModelAttribute  Notice notice) {
        noticeService.saveOrUpdate(notice);
        return new ResultData();
    }

    @GetMapping("/del")
     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
    public ResultData delete(String id) {
        noticeService.deleteById(id);
        return new ResultData(Result.SUCCESS, "删除成功", null);
    }
	
	
	
}
