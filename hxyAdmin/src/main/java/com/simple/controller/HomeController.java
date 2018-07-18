package com.simple.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simple.common.rest.Result;
import com.simple.common.rest.ResultData;
import com.simple.domain.po.SysPermission;
import com.simple.domain.po.SysRole;
import com.simple.domain.po.UserInfo;
import com.simple.error.ErrorCode;
import com.simple.error.SystemException;
import com.simple.service.SysPermissionService;
import com.simple.service.SysRoleService;
import com.simple.shiro.UserSession;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(description="登录相关接口")
public class HomeController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping("login")
    public ResultData login() {
        return new ResultData(Result.UNLOGIN, "用户未登录");
    }

    @ApiOperation("登录")
    @PostMapping("/doLogin")
    public ResultData login(@RequestBody UserInfo user) {
    	ResultData data = new ResultData();
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            throw new SystemException(ErrorCode.LOGIN_USER_OR_PWD_ERROR);
        }
        try {
        	   Subject subject = SecurityUtils.getSubject();
               UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
               subject.login(token);
               List<SysRole> roleList = sysRoleService.findRoleByUserId(user.getId());
               if (null != roleList && roleList.size() > 0) {
       	        List<SysPermission> permissionList = sysPermissionService
       	                .findPermissionByRoleIds(roleList.stream().map(SysRole::getId).collect(Collectors.toList()));
       			user.setRole(roleList);
       	        user.setPermission(permissionList);
               }
            UserInfo info =(UserInfo) SecurityUtils.getSubject().getSession().getAttribute(UserSession.userInfo);
            info.setPassword("保密");
           System.out.println("id:"+ SecurityUtils.getSubject().getSession().getId());
           	data.data=info;
        }catch(Exception e) {
        	 return new ResultData(ResultData.ERROR,"用户名或者密码错误");
        }
      
        return data;

    }

}