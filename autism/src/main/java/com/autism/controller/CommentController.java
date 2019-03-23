package com.autism.controller;

import java.util.ArrayList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.autism.model.Comment;
import com.autism.model.response.CommentPageResult;
import com.autism.model.response.IDResult;
import com.autism.service.impl.CommentServiceImpl;
import com.autism.utils.ResponseMessage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/comment")
@Api(value="restful",description="评论模块")
public class CommentController {
  
  @Autowired
  private CommentServiceImpl commentService;
  
  private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
  
  @RequestMapping(value="/getCommentPage",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
  @ResponseBody
  @ApiOperation(value="查询评论列表(getCommentPage)",notes="")
  @ApiResponses({
    @ApiResponse(code=ResponseMessage.SUCCESS_CODE,message=ResponseMessage.QUERY_SUCCESS_MSG,response=CommentPageResult.class),
    @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.QUERY_ERROR_MSG,response=CommentPageResult.class)})
  public CommentPageResult getCommentPage(
      @ApiParam(name="projectId",value="项目ID",required=false)@RequestParam(required=false) String projectId,
      @ApiParam(name="pageNum",value="当前页码")@RequestParam(defaultValue="1") int pageNum,
      @ApiParam(name="pageSize",value="每页显示的条数")@RequestParam(defaultValue="10") int pageSize
      ){
    CommentPageResult rs = new CommentPageResult();
    
    try {
      if (StringUtils.isEmpty(projectId)) {
        rs.autoFillException(ResponseMessage.ERROR_CODE,"未传入");
        return rs;
      }
      
      PageHelper.startPage(pageNum,pageSize);
      ArrayList<Comment> comments = this.commentService.getCommentByProjectId(projectId);
      PageInfo<Comment> page = new PageInfo<Comment>(comments);
      rs.setData(page);
      rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
    } catch (Exception e) {
      // TODO: handle exception
      logger.error(e.getMessage(),e);
      rs.autoFillException(ResponseMessage.ERROR_CODE,e.getMessage());
    }
    return rs;
  }

  
  
  @RequestMapping(value="/addComment",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
  @ResponseBody
  @ApiOperation(value="添加评论(addComment)",notes="")
  @ApiResponses({
    @ApiResponse(code=ResponseMessage.SUCCESS_CODE,message=ResponseMessage.ADD_SUCCESS_MSG,response=IDResult.class),
    @ApiResponse(code=ResponseMessage.ERROR_CODE,message=ResponseMessage.ADD_ERROR_MSG,response=IDResult.class)})
  public IDResult addComment(
//      @ApiParam(name="userId",value="用户ID",required=false)@RequestParam(required=false)String userId,
      @ApiParam(name="comment",value="评论",required=true)@RequestBody Comment comment
      ){
    IDResult rs = new IDResult();
    
    try {
//      CurrentUser user = RequestContextUtil.getRequestUser();
      String id = this.commentService.addComment(comment);
      rs.setData(id);
      rs.setStatusCode(ResponseMessage.SUCCESS_CODE);
    } catch (Exception e) {
      // TODO: handle exception
      logger.error(e.getMessage(),e);
      rs.autoFillException(ResponseMessage.ERROR_CODE,e.getMessage());
    }
    return rs;
  }
}
