package com.zl.autism.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.autism.model.UserAndGame;
import com.zl.autism.model.response.IDResult;
import com.zl.autism.model.response.UserAndGamePageResult;
import com.zl.autism.service.UserAndGameService;
import com.zl.autism.utils.ResponseMessage;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/gameRelation")
@Api(value="restful",description="用户游戏关联模块")
public class UserAndGameController {

    private static final Logger logger = LoggerFactory.getLogger(UserAndGameController.class);

    @Autowired
    private UserAndGameService userAndGameService;

    @RequestMapping(value = "/addGameRelation",method= RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="添加用户游戏联系",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.ADD_SUCCESS_MSG,response= IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.ADD_ERROR_MSG,response=IDResult.class)})
    public IDResult addGameRelation(@ApiParam(name = "gameRelation",value = "用户游戏关联详情")@RequestBody UserAndGame game){
        IDResult rs = new IDResult();
        try {
            String uuid = this.userAndGameService.addUserRelation(game);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value = "/delGameRelation",method= RequestMethod.DELETE,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="删除用户游戏联系",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.DELETE_SUCCESS_MSG,response= IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.DELETE_ERROR_MSG,response=IDResult.class)})
    public IDResult delGameRelation(@ApiParam(name = "uuid",value = "uuid")@RequestParam String uuid){
        IDResult rs = new IDResult();
        try {
            this.userAndGameService.delGameRelation(uuid);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value = "/updateGameRelation",method= RequestMethod.PUT,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="更新用户游戏联系",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.UPDATE_SUCCESS_MSG,response= IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.UPDATE_ERROR_MSG,response=IDResult.class)})
    public IDResult updateGameRelation(@ApiParam(name = "gameRelation",value = "用户游戏关联详情")@RequestBody UserAndGame game){
        IDResult rs = new IDResult();
        try {
            String uuid = this.userAndGameService.updateGameRelation(game);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value = "/getGameRelation",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="更新用户游戏联系",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.QUERY_SUCCESS_MSG,response= UserAndGamePageResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.QUERY_ERROR_MSG,response=UserAndGamePageResult.class)})
    public UserAndGamePageResult getGameRelation(@ApiParam(name = "uuidList",value = "uuidList",required = false)@RequestParam(required = false) ArrayList<String> uuidList,
                                                 @ApiParam(name="pageNum",value="当前页码")@RequestParam(defaultValue="1") int pageNum,
                                                 @ApiParam(name="pageSize",value="每页显示的条数")@RequestParam(defaultValue="10") int pageSize){
        UserAndGamePageResult rs = new UserAndGamePageResult();
        try {
            PageHelper.startPage(pageNum,pageSize);
            ArrayList<UserAndGame> list= this.userAndGameService.getGameRelation(uuidList);
            PageInfo<UserAndGame> page = new PageInfo<UserAndGame>(list);
            rs.setData(page);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }
}
