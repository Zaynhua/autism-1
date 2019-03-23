package com.autism.utils;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectUtils
{
  private static final Logger LOG = LoggerFactory.getLogger(ReflectUtils.class);
  
  public static Method getCalledMethodByClass(Class<?> cls, int stackLevel, Class[] parameterTypes)
  {
    if (cls == null)
    {
      LOG.error("The input class is empty.");
      return null;
    }
    if (stackLevel >= Thread.currentThread().getStackTrace().length)
    {
      LOG.error("The calling stack level beyond to the stack trace length.");
      
      return null;
    }
    if (Thread.currentThread().getStackTrace().length <= stackLevel)
    {
      LOG.error("The stackLevel(" + stackLevel + ") beyounds the current stack trace's limitation");
      
      return null;
    }
    String methodName = Thread.currentThread().getStackTrace()[stackLevel].getMethodName();
    if ((methodName == null) || (methodName.isEmpty()))
    {
      LOG.error("Cannot get current method name");
      return null;
    }
    if (parameterTypes == null)
    {
      for (Method method : cls.getMethods()) {
        if (method.getName().equalsIgnoreCase(methodName)) {
          return method;
        }
      }
      LOG.error("Cannot find method " + methodName + " by name");
    }
    else
    {
      try
      {
        return cls.getMethod(methodName, parameterTypes);
      }
      catch (NoSuchMethodException e1)
      {
        LOG.error("Cannot find method " + methodName + " with name and parameter types caused by no such method", 
          e1);
      }
      catch (SecurityException e)
      {
        LOG.error("Cannot find method " + methodName + " by name and parameter types caused by security exception", 
          e);
      }
    }
    return null;
  }
  
  public static Method getCurrentMethodByClass(Class<?> cls, Class[] parameterTypes)
  {
    return getCalledMethodByClass(cls, 3, parameterTypes);
  }
  
  public static String getResponseMessageByMethod(Method method, int statusCode)
  {
    if (method == null) {
      return null;
    }
    ApiResponses respAnnotations = (ApiResponses)method.getAnnotation(ApiResponses.class);
    if (respAnnotations.value().length <= 0)
    {
      LOG.info("There is no annotation named ApiResponses for method " + method
        .getName());
      return null;
    }
    for (ApiResponse resp : respAnnotations.value()) {
      if (statusCode == resp.code()) {
        return resp.message();
      }
    }
    LOG.info("Cannot find response message by status code " + statusCode + 
      " in method " + method.getName());
    return null;
  }
}
