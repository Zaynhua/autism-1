package com.autism.utils;

public abstract interface ResponseMessage {
  
  public static final int SUCCESS_CODE = 200;
  public static final int NOT_FOUND = 410;
  public static final int INVALID_ARGUMENTS = 400;
  public static final int OBJECT_EXISTS = 418;
  public static final int ERROR_CODE = 406;
  
  public static final String ADD_SUCCESS_MSG = "添加成功";
  public static final String ADD_ERROR_MSG = "添加失败";
  public static final String UPDATE_SUCCESS_MSG = "更新成功";
  public static final String UPDATE_ERROR_MSG = "更新失败";
  public static final String DELETE_SUCCESS_MSG = "删除成功";
  public static final String DELETE_ERROR_MSG = "删除失败";
  public static final String QUERY_SUCCESS_MSG = "查询成功";
  public static final String QUERY_ERROR_MSG = "查询失败";
  public static final String UPLOAD_SUCCESS_MSG = "上传成功";
  public static final String UPLOAD_FAILED_MSG = "上传失败";
  public static final String SYNC_SUCCESS_MSG = "同步成功";
  public static final String SYNC_ERROR_MSG = "同步失败";
}
