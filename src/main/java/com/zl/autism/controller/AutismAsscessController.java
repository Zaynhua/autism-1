package com.zl.autism.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.autism.model.AutismAsscess;
import com.zl.autism.model.response.AsscessPageResult;
import com.zl.autism.model.response.IDResult;
import com.zl.autism.service.AutismAsscessService;
import com.zl.autism.utils.ResponseMessage;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/asscess")
@Api(value="restful",description="评估信息模块")
public class AutismAsscessController {

    private static final Logger logger = LoggerFactory.getLogger(AutismAsscessController.class);

    @Autowired
    private AutismAsscessService autismAsscessService;


    @RequestMapping(value="/addAsscess",method= RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="添加评估信息表",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.ADD_SUCCESS_MSG,response= IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.ADD_ERROR_MSG,response=IDResult.class)})
    public IDResult addAsscess(@ApiParam(name="user",required=true)@RequestBody AutismAsscess autismAsscess) {
        IDResult rs = new IDResult();
        try {
            String uuid = this.autismAsscessService.addAsscess(autismAsscess);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value="/delAsscess",method= RequestMethod.DELETE,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="删除评估信息表单",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.DELETE_SUCCESS_MSG,response= IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.DELETE_ERROR_MSG,response=IDResult.class)})
    public IDResult delAsscess(@ApiParam(name="uuid",required=true)@RequestParam String uuid) {
        IDResult rs = new IDResult();
        try {
            String id = this.autismAsscessService.delAsscess(uuid);
            rs.setData(id);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value="/getAsscess",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="获取评估信息表单",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.QUERY_SUCCESS_MSG,response= AsscessPageResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.QUERY_ERROR_MSG,response=AsscessPageResult.class)})
    public AsscessPageResult getAsscess(@ApiParam(name="uuid",required=false)@RequestParam(required = false)ArrayList<String> uuid,
                                        @ApiParam(name="interventionId",required = false,value = "干预对象ID")@RequestParam(required = false)ArrayList<String> interventionId,
                                        @ApiParam(name="InterventionistId",required = false,value = "干预师ID")@RequestParam(required = false)ArrayList<String> interventionistId,
                                        @ApiParam(name="pageNum",value="当前页码")@RequestParam(defaultValue="1") int pageNum,
                                        @ApiParam(name="pageSize",value="每页显示的条数")@RequestParam(defaultValue="10") int pageSize) {
        AsscessPageResult rs = new AsscessPageResult();

        try {
            PageHelper.startPage(pageNum,pageSize);
            ArrayList<AutismAsscess> list = this.autismAsscessService.getAsscess(uuid,interventionId,interventionistId);
            PageInfo<AutismAsscess> page = new PageInfo<AutismAsscess>(list);
            rs.setData(page);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE,e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "更新评估信息",notes="")
    @ApiResponses({
            @ApiResponse(code = ResponseMessage.SUCCESS_CODE,message = ResponseMessage.UPDATE_SUCCESS_MSG,response = IDResult.class),
            @ApiResponse(code = ResponseMessage.ERROR_CODE,message = ResponseMessage.UPDATE_ERROR_MSG,response = IDResult.class)
    })
    public IDResult updateAsscess(@ApiParam(name="autismAsscess",value = "更新的评估信息")@RequestBody AutismAsscess autismAsscess){
        IDResult rs = new IDResult();
        try {
            String id =this.autismAsscessService.updateAsscess(autismAsscess);
            rs.setData(id);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE,e.getMessage());
        }
        return rs;
    }
}
