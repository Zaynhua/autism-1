package com.zl.autism.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.autism.model.AutismDept;
import com.zl.autism.model.response.AutismDeptPageResult;
import com.zl.autism.model.response.IDResult;
import com.zl.autism.service.AutismDeptService;
import com.zl.autism.utils.ResponseMessage;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//机构表
@Controller
@RequestMapping("/dept")
@Api(value="restful",description="机构信息模块")
public class AutismDeptController {

    private static final Logger logger = LoggerFactory.getLogger(AutismDeptController.class);

    @Autowired
    private AutismDeptService autismDeptService;


    @RequestMapping(value="/addDept",method= RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="添加机构表",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.ADD_SUCCESS_MSG,response= IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.ADD_ERROR_MSG,response=IDResult.class)})
    public IDResult addAsscess(@ApiParam(name="user",required=true)@RequestBody AutismDept dept) {
        IDResult rs = new IDResult();
        try {
            String uuid = this.autismDeptService.addDept(dept);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value="/delDept",method= RequestMethod.DELETE,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="删除机构",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.DELETE_SUCCESS_MSG,response= IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.DELETE_ERROR_MSG,response=IDResult.class)})
    public IDResult delAsscess(@ApiParam(name="uuid",required=true)@RequestParam String uuid) {
        IDResult rs = new IDResult();
        try {
            String id = this.autismDeptService.delDept(uuid);
            rs.setData(id);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value="/getDept",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="获取机构",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.QUERY_SUCCESS_MSG,response= AutismDeptPageResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.QUERY_ERROR_MSG,response=AutismDeptPageResult.class)})
    public AutismDeptPageResult getAsscess(@ApiParam(name="uuid",required=false)@RequestParam(required = false) ArrayList<String> uuid,
                                           @ApiParam(name="pageNum",value="当前页码")@RequestParam(defaultValue="1") int pageNum,
                                           @ApiParam(name="pageSize",value="每页显示的条数")@RequestParam(defaultValue="10") int pageSize) {
        AutismDeptPageResult rs = new AutismDeptPageResult();

        try {
            PageHelper.startPage(pageNum,pageSize);
            ArrayList<AutismDept> list = this.autismDeptService.getAutismDepts(uuid);
            PageInfo<AutismDept> page = new PageInfo<AutismDept>(list);
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
    public IDResult updateAsscess(@ApiParam(name="dept",value = "更新的评估信息")@RequestBody AutismDept dept){
        IDResult rs = new IDResult();
        try {
            String id = this.autismDeptService.updateDept(dept);
            rs.setData(id);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE,e.getMessage());
        }
        return rs;
    }

}
