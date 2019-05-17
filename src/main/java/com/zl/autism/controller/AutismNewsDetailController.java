package com.zl.autism.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.autism.model.AutismCComment;
import com.zl.autism.model.AutismNewsDetail;
import com.zl.autism.model.response.AutismCCommentPageResult;
import com.zl.autism.model.response.AutismNewsDetailPageResult;
import com.zl.autism.model.response.IDResult;
import com.zl.autism.service.AutismCCommentService;
import com.zl.autism.service.AutismNewsDetailService;
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
@RequestMapping("/news")
@Api(value="restful",description="社区评论模块")
public class AutismNewsDetailController {

    private static final Logger logger = LoggerFactory.getLogger(AutismNewsDetailController.class);

    @Autowired
    private AutismNewsDetailService autismNewsDetailService;

    @RequestMapping(value="/getDetail",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value="获得新闻详情",notes="")
    @ApiResponses({
            @ApiResponse(code= ResponseMessage.SUCCESS_CODE,message=ResponseMessage.QUERY_SUCCESS_MSG,response= AutismNewsDetailPageResult.class),
            @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.QUERY_ERROR_MSG,response=AutismNewsDetailPageResult.class)
    })

    public AutismNewsDetailPageResult getDetail(
            @ApiParam(name = "uuids",value = "uuid",required = false)@RequestParam(required = false)ArrayList<String> uuids,
            @ApiParam(name="pageNum",value="当前页码")@RequestParam(defaultValue="1") int pageNum,
            @ApiParam(name="pageSize",value="每页显示的条数")@RequestParam(defaultValue="10") int pageSize) {

        AutismNewsDetailPageResult rs = new AutismNewsDetailPageResult();

        try {
            PageHelper.startPage(pageNum,pageSize);
            ArrayList<AutismNewsDetail> list = this.autismNewsDetailService.getAutismCCommentList(uuids);
            PageInfo<AutismNewsDetail> page = new PageInfo<AutismNewsDetail>(list);
            rs.setData(page);
            rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            rs.autoFillException(ResponseMessage.ERROR_CODE, e.getMessage());
        }
        return rs;
    }



}
