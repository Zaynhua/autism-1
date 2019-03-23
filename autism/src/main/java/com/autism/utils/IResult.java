package com.autism.utils;

import java.lang.reflect.Method;

public abstract interface IResult<T>
{
  public abstract int getStatusCode();
  
  public abstract void setStatusCode(int paramInt);
  
  public abstract String getStatusMessage();
  
  public abstract void setStatusMessage(String paramString);
  
  public abstract void autoFillByMethod(Method paramMethod, int paramInt);
  
  public abstract void autoFillByMethod(Method paramMethod, int paramInt, String paramString);
  
  public abstract T getData();
  
  public abstract void setData(T paramT);
  
  public abstract String toJson();
  
  public abstract String toXml();
  
  public abstract boolean isSuccessful();
}
