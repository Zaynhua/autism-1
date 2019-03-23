package com.autism.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.autism.mapper.CommentMapper;
import com.autism.model.Comment;
import com.autism.service.ICommentService;
import com.autism.utils.CommonUtil;
import com.autism.utils.RandomUtils;

@Service
public class CommentServiceImpl implements ICommentService{
  @Autowired
  private CommentMapper commentMapper;

  public ArrayList<Comment> getCommentByProjectId(String projectId) {
    // TODO Auto-generated method stub
    return this.commentMapper.getCommentByProjectId(projectId);
  }

  public String addComment(Comment comment) throws Exception{
    // TODO Auto-generated method stub
    
//    if (user==null) {
//      throw new Exception("用户信息为空，不可新增");
//    }
    
    if (comment==null) {
       throw new Exception("评论JaveBean为空，不可新增评论");
    }
    
    if(StringUtils.isEmpty(comment.getProjectId())){
      throw new Exception("未传入项目Id，不可新增评论");
    }
    
    if (StringUtils.isEmpty(comment.getText())) {
      throw new Exception("评论内容为空，不可新增评论");
    }
    
    String nowTime = CommonUtil.createNowDate();
    String id = RandomUtils.UUIDString();
    comment.setUuid(id);
//    comment.setCreateId(user.getId());
//    comment.setUpdateId(user.getId());
    comment.setCreateTime(nowTime);
    comment.setUpdateTime(nowTime);
    
    
    this.commentMapper.insertSelective(comment);
    
    return id;
  }
  
}
