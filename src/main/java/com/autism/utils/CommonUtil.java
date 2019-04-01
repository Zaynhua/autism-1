package com.autism.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.github.pagehelper.StringUtil;

public class CommonUtil {

  public static String createNowDate() {
    Date nowDate = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date = format.format(nowDate);
    return date;
}
  public static Date StringToDate(String date) {
	  Date parse = null;
	  if(StringUtil.isEmpty(date)) {
		  return parse;
	  }
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  try {
		  parse = formatter.parse(date);
	  } catch (ParseException e) {
		  e.printStackTrace();
	  }
	  return parse;
  }
  //获得当前时间戳
  public static String getNowTimeStamp() {
	  long time = System.currentTimeMillis();
	  String nowTimeStamp = String.valueOf(time / 1000);
	  return nowTimeStamp;
  }

}
