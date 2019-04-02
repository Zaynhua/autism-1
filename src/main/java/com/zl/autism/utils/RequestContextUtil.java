package com.zl.autism.utils;

import org.springframework.web.context.request.RequestContextHolder;

import com.zl.autism.model.CurrentUser;

public class RequestContextUtil {
  public static CurrentUser getRequestUser(){
    CurrentUser user = (CurrentUser)RequestContextHolder.getRequestAttributes().getAttribute("USER",0);
    return user;
  }
}
