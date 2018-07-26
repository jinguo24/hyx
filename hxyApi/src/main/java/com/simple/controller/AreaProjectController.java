package com.simple.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.domain.po.Area;
import com.simple.domain.po.AreaProject;
import com.simple.service.AreaProjectService;
import com.simple.service.AreaService;
import com.simple.vo.AreaProjectVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("areaProject")
@Api(description="全国大公鸡的接口")
public class AreaProjectController extends BaseController
{
	@Autowired
    private AreaProjectService areaProjectService;
	
	@Autowired
    private AreaService areaService;


    private Logger logger = Logger.getLogger(AreaProjectController.class);

//    @GetMapping("list")
//        @ApiImplicitParams({
//    	  @ApiImplicitParam(name="pageNum",value="页数",dataType="int", paramType = "query",required=true),
//    	  @ApiImplicitParam(name="pageSize",value="每页条数",dataType="int", paramType = "query",required=true)})
//    public ResultData list(@ModelAttribute AreaProject areaProject,Integer pageNum, Integer pageSize) {
//    	if (null == areaProject) areaProject = new AreaProject();
//        final PageInfo<AreaProject> page = areaProjectService.listAsPage(areaProject, pageNum, pageSize);
//        return new ResultData(page);
//    }
//
//    @PostMapping("add")
//    public ResultData add(@RequestBody AreaProject areaProject) {
//        //Assert.notNull(areaProject.getName(), "角色名不能为空");
//        //Assert.isTrue(!checkUnique(sysRole.getName(), null), "重复的角色名");
//        areaProjectService.saveOrUpdate(areaProject);
//        return new ResultData();
//    }
//
//    @PostMapping("update")
//    public ResultData update(@RequestBody AreaProject areaProject) {
//        areaProjectService.saveOrUpdate(areaProject);
//        return new ResultData();
//    }
//
//    @GetMapping("/del")
//     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
//    public ResultData delete(String id) {
//        areaProjectService.deleteById(id);
//        return new ResultData(Result.SUCCESS, "删除成功", null);
//    }
//    
//     @GetMapping("/findById")
//     @ApiImplicitParam(name="id",value="id",dataType="String", paramType = "query",required=true)
//    public ResultData findById(String id) {
//    	return new ResultData(Result.SUCCESS,"查询成功",areaProjectService.getById(id));
//    }
	
    @GetMapping("list")
    @ApiOperation("id:为 地区表中的id , projectIds 为省里边包含的项目id数组 ")
    @ApiImplicitParam(name="proviceCode",value="省编码(可不传，则查所有省份)",dataType="int", paramType = "query",required=false)
	public Result list(Integer proviceCode) {
		 Area area = new Area();
		 if(proviceCode==null) {
			 area.setParentID(0);
		 }else {
			 area.setParentID(proviceCode);
		 }
    	 final PageInfo<Area> page = areaService.listAsPage(area, 1, 50);
    	 List<AreaProjectVo> vos =new ArrayList<>();
    	 for(Area a: page.getList()) {
    		 AreaProjectVo vo = new AreaProjectVo();
    		 vo.setId(a.getId());
    		 vo.setName(a.getName());
    		 AreaProject ap = new AreaProject();
    		 ap.setProviceId(a.getId());
    		 PageInfo<AreaProject> aps = areaProjectService.listAsPage(ap,1,10);
    		 List<String> list = new ArrayList<>();
    		 for(AreaProject p :aps.getList()) {
    			 list.add(p.getId());
    		 }
    		 vo.setProjectIds(list);
    		 vos.add(vo);
    	 }
		return new ResultData(Result.SUCCESS,"查询成功",vos);
	}
	
}
