package com.autism.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomUtils {
  public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String LETTERCHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String NUMBERCHAR = "0123456789";
  
  public static String generateString(int length)
  {
    StringBuffer sb = new StringBuffer();
    Random random = new Random();
    for (int i = 0; i < length; i++) {
      sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length())));
    }
    return sb.toString();
  }
  
  public static String generateMixString(int length)
  {
    StringBuffer sb = new StringBuffer();
    Random random = new Random();
    for (int i = 0; i < length; i++) {
      sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt("abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length())));
    }
    return sb.toString();
  }
  
  public static String generateLowerString(int length)
  {
    return generateMixString(length).toLowerCase();
  }
  
  public static String generateUpperString(int length)
  {
    return generateMixString(length).toUpperCase();
  }
  
  public static String generateZeroString(int length)
  {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < length; i++) {
      sb.append('0');
    }
    return sb.toString();
  }
  
  public static String toFixdLengthString(long num, int fixdlenth)
  {
    StringBuffer sb = new StringBuffer();
    String strNum = String.valueOf(num);
    if (fixdlenth - strNum.length() >= 0) {
      sb.append(generateZeroString(fixdlenth - strNum.length()));
    } else {
      throw new RuntimeException("������" + num + "������������" + fixdlenth + "������������������");
    }
    sb.append(strNum);
    return sb.toString();
  }
  
  public static int getNotSimple(int[] param, int len)
  {
    Random rand = new Random();
    for (int i = param.length; i > 1; i--)
    {
      int index = rand.nextInt(i);
      int tmp = param[index];
      param[index] = param[(i - 1)];
      param[(i - 1)] = tmp;
    }
    int result = 0;
    for (int i = 0; i < len; i++) {
      result = result * 10 + param[i];
    }
    return result;
  }
  
  public static String UUIDString()
  {
    UUID uuid = UUID.randomUUID();
    String id = uuid.toString().replaceAll("-", "");
    return id;
  }
  
  public static String getSequence(String strSeq)
  {
    Random random = new Random();
    String sRand = "";
    for (int i = 0; i < 5; i++)
    {
      String rand = String.valueOf(random.nextInt(10));
      sRand = sRand + rand;
    }
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    String orderId = strSeq + df.format(new Date()) + sRand;
    return orderId;
  }
}
