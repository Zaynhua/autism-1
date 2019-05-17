package com.zl.autism.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.autism.model.AutismCComment;
import com.zl.autism.model.AutismCommunitys;
import com.zl.autism.model.response.AutismCCommentPageResult;
import com.zl.autism.model.response.AutismCommunitysPageResult;
import com.zl.autism.model.response.IDResult;
import com.zl.autism.service.AutismCCommentService;
import com.zl.autism.service.AutismCommunitysService;
import com.zl.autism.utils.ResponseMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/ccomment")
@Api(value="restful",description="社区评论模块")
public class AutismCCommentController {

    private static final Logger logger = LoggerFactory.getLogger(AutismCCommentController.class);

    @Autowired
    private AutismCCommentService autismCCommentService;

    @RequestMapping(value="/getCComments",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="获得社区详情评论",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.QUERY_SUCCESS_MSG,response= AutismCCommentPageResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.QUERY_ERROR_MSG,response=AutismCCommentPageResult.class)
    })

    public AutismCCommentPageResult getCComments(
            @ApiParam(name = "uuids",value = "uuid",required = false)@RequestParam(required = false)ArrayList<String> uuids,
            @ApiParam(name="pageNum",value="当前页码")@RequestParam(defaultValue="1") int pageNum,
            @ApiParam(name="pageSize",value="每页显示的条数")@RequestParam(defaultValue="10") int pageSize) {

        AutismCCommentPageResult rs = new AutismCCommentPageResult();

        try {
            PageHelper.startPage(pageNum,pageSize);
            ArrayList<AutismCComment> list = this.autismCCommentService.getAutismCCommentList(uuids);
            PageInfo<AutismCComment> page = new PageInfo<AutismCComment>(list);
            rs.setData(page);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }

    @RequestMapping(value="/addCComment",method= RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="添加社区评论",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.ADD_SUCCESS_MSG,response=IDResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.ADD_ERROR_MSG,response=IDResult.class)
    })

    public IDResult addCComment(@ApiParam(name = "ccomment",value = "评论详情") @RequestBody AutismCComment comment) {

        IDResult rs = new IDResult();

        try {
            String uuid = this.autismCCommentService.addCComment(comment);
            rs.setData(uuid);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }


}
