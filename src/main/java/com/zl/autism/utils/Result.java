package com.zl.autism.utils;

import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Method;

public class Result<T> implements IResult<T>
{
  private int statusCode = 1;
  private String statusMessage = "";
  private T data = null;
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public void setStatusCode(int code)
  {
    this.statusCode = code;
  }
  
  public String getStatusMessage()
  {
    return this.statusMessage;
  }
  
  public void setStatusMessage(String message)
  {
    this.statusMessage = message;
  }
  
  public T getData()
  {
    return (T)this.data;
  }
  
  public void setData(T data)
  {
    this.data = data;
  }
  
  public String toJson()
  {
    return JSONObject.toJSONString(this);
  }
  
  public String toXml()
  {
    return null;
  }
  
  public void autoFillByMethod(Method method, int statusCode)
  {
    autoFillByMethod(method, statusCode, null);
  }
  
  public void autoFillByMethod(Method method, int statusCode, String defaultMessage)
  {
    String msg = ReflectUtils.getResponseMessageByMethod(method, statusCode);
    setStatusCode(statusCode);
    if ((msg == null) || (msg.isEmpty())) {
      setStatusMessage(defaultMessage);
    } else {
      setStatusMessage(msg);
    }
  }
  
  public void autoFillException(int statusCode, String msg)
  {
    setStatusCode(statusCode);
    setStatusMessage(msg);
  }
  
  public boolean isSuccessful()
  {
    if ((0 == this.statusCode) || (200 == this.statusCode)) {
      return true;
    }
    return false;
  }
  
  public static IResult<Object> getSuccessResult()
  {
    Result<Object> result = new Result();
    result.setStatusCode(0);
    return result;
  }
}

