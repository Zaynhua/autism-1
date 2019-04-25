package com.zl.autism.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.autism.model.AutismUserRelation;
import com.zl.autism.model.response.AutismUserRelationPageResult;
import com.zl.autism.model.response.IDResult;
import com.zl.autism.service.AutismUserRelationService;
import com.zl.autism.utils.ResponseMessage;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/userRelation")
@Api(value="restful",description="用户关联模块")
public class AutismUserRelationController {

    private static final Logger logger = LoggerFactory.getLogger(AutismUserRelationController.class);

    @Autowired
    private AutismUserRelationService autismUserRelationService;


    @RequestMapping(value="/addRelation",method= RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="新增用户关联",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.ADD_SUCCESS_MSG,response= IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.ADD_ERROR_MSG,response=IDResult.class)})
    public IDResult addRelation(@ApiParam(name = "userRelation",value = "userRelation")@RequestBody AutismUserRelation userRelation){
        IDResult rs = new IDResult();

        try {
            String uuid = this.autismUserRelationService.addRelation(userRelation);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }

        return rs;
    }

    @RequestMapping(value="/delRelation",method= RequestMethod.DELETE,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="删除用户关联",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.DELETE_SUCCESS_MSG,response= IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.DELETE_ERROR_MSG,response=IDResult.class)})
    public IDResult delRelation(@ApiParam(name = "uuid",value = "uuid")@RequestParam String uuid){
        IDResult rs = new IDResult();

        try {
            this.autismUserRelationService.delRelation(uuid);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }

        return rs;
    }


    @RequestMapping(value="/updateRelation",method= RequestMethod.PUT,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="更新用户关系",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.UPDATE_SUCCESS_MSG,response= IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.UPDATE_ERROR_MSG,response=IDResult.class)})
    public IDResult updateRelation(
            @ApiParam(name = "userRelation",value = "userRelation")@RequestBody AutismUserRelation userRelation){
        IDResult rs = new IDResult();

        try {

            String uuid =this.autismUserRelationService.updateRelation(userRelation);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }

        return rs;
    }


    @RequestMapping(value="/getRelation",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="查询用户关系",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.QUERY_SUCCESS_MSG,response= AutismUserRelationPageResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.QUERY_ERROR_MSG,response=AutismUserRelationPageResult.class)})
    public AutismUserRelationPageResult getRelation(@ApiParam(name = "uuids",value = "uuids",required = false)@RequestParam(required = false) ArrayList<String> uuids,
                                                    @ApiParam(name = "userId",value = "userId",required = false)@RequestParam(required = false) String userId,
                                                    @ApiParam(name="pageNum",value="当前页码")@RequestParam(defaultValue="1") int pageNum,
                                                    @ApiParam(name="pageSize",value="每页显示的条数")@RequestParam(defaultValue="10") int pageSize){
        AutismUserRelationPageResult rs = new AutismUserRelationPageResult();

        try {
            PageHelper.startPage(pageNum,pageSize);
            ArrayList<AutismUserRelation> list = this.autismUserRelationService.getRelations(uuids,userId);
            PageInfo<AutismUserRelation> page = new PageInfo<AutismUserRelation>(list);
            rs.setData(page);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }

        return rs;
    }

}
