package com.autism.controller;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autism.model.User;
import com.autism.model.response.IDResult;
import com.autism.model.response.UserPageResult;
import com.autism.model.response.UserResult;
import com.autism.service.UserService;
import com.autism.utils.ResponseMessage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/")
@Api(value="restful",description="网页端用户模块")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	@ApiOperation(value="用户登录(login)",notes="")
	@ApiResponses({
	    @ApiResponse(code=ResponseMessage.SUCCESS_CODE,message=ResponseMessage.LOGIN_SUCCESS_MSG,response=UserResult.class),
	    @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.LOGIN_FAILED_MSG,response=UserResult.class)})
	public UserResult login(
			@ApiParam(name="phone",value="用户电话号码",required=true)@RequestParam String phone,
			@ApiParam(name="password",value="密码",required=true)@RequestParam String password,
			@ApiParam(name="type",value="登录类型",required=true)@RequestParam String type
			) {
UserResult rs = new UserResult();
		
		try {
			//条件都符合开始操作
			
			User user = this.userService.login(phone, password, type);
			
			rs.setData(user);
			rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(),e);
			rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
		}
		
		return rs;
	}
	
	
	//增加用户或网页端注册
	@RequestMapping(value="/addUser",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	@ApiOperation(value="增加用户或网页端注册",notes="")
	@ApiResponses({
		@ApiResponse(code=ResponseMessage.SUCCESS_CODE,message=ResponseMessage.ADD_SUCCESS_MSG,response=IDResult.class),
		@ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.ADD_ERROR_MSG,response=IDResult.class)})
	public IDResult addUser(@ApiParam(name="user",required=true)@RequestBody User user) {
		IDResult rs = new IDResult();
		try {
			String uuid = this.userService.addUser(user);
			rs.setData(uuid);
			rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
		}
		return rs;
	}
	
	//获取多个用户信息
	@RequestMapping(value="/getUserList",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	@ApiOperation(value="网页端获取多个用户信息",notes="")
	@ApiResponses({
		@ApiResponse(code=ResponseMessage.SUCCESS_CODE,message=ResponseMessage.QUERY_SUCCESS_MSG,response=UserPageResult.class),
		@ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.QUERY_ERROR_MSG,response=UserPageResult.class)
	})
	public UserPageResult getUserInfo(
			@ApiParam(name="uuid",value="用户唯一表示uuid",required=false)@RequestParam(required=false)ArrayList<String> uuid,
			@ApiParam(name="open_id",value="授权用户唯一标识",required=false)@RequestParam(required=false)ArrayList<String> openId,
			@ApiParam(name="pageNum",value="当前页码")@RequestParam(defaultValue="1") int pageNum,
			@ApiParam(name="pageSize",value="每页显示的条数")@RequestParam(defaultValue="10") int pageSize) {
			
		UserPageResult rs = new UserPageResult();
		try {
			PageHelper.startPage(pageNum,pageSize);
			ArrayList<User> users = this.userService.getUserInfo(uuid, openId);
			PageInfo<User> page = new PageInfo<User>(users);
			rs.setData(page);
			rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(),e);
			rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
		}
		return rs;
		
	}
		
	
	//删除用户
	@RequestMapping(value="/delete",method=RequestMethod.DELETE,produces="application/json;charset=UTF-8")
	@ResponseBody
	@ApiOperation(value="删除用户",notes="")
	@ApiResponses({
		@ApiResponse(code=ResponseMessage.SUCCESS_CODE,message=ResponseMessage.DELETE_SUCCESS_MSG,response=IDResult.class),
		@ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.DELETE_ERROR_MSG,response=IDResult.class)
	})
	public IDResult deleteUser(
			@ApiParam(name="uuid",value="用户uuid",required=true)@RequestParam String uuid) {
		IDResult rs = new IDResult();
		try {
			String deluuid = this.userService.deleteUser(uuid);
			rs.setData(deluuid);
			rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
		}
		return rs;
	}
		
	//更新用户
	@RequestMapping(value="/update",method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	@ApiOperation(value="更新用户",notes="")
	@ApiResponses({@ApiResponse(code=ResponseMessage.SUCCESS_CODE,message=ResponseMessage.UPDATE_SUCCESS_MSG,response=UserResult.class),
			@ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.UPDATE_ERROR_MSG,response=UserResult.class)
		})
	public IDResult updateUser(
			@ApiParam(name="user",value="需要更新的用户信息",required=true)@RequestParam User user) {
		IDResult rs = new IDResult();
		try {
			String uuid = this.userService.updateUser(user);
			rs.setData(uuid);
			rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(),e);
			rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
		}
		return rs;
	}
	
	
}
