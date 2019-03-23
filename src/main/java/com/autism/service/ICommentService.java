package com.autism.service;

import java.util.ArrayList;

import com.autism.model.Comment;

public interface ICommentService {

  public ArrayList<Comment> getCommentByProjectId(String projectId);

  public String addComment(Comment comment) throws Exception;
}
