package com.douyinpay.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/** 字符串工具类 */
public class StringUtil {
  private StringUtil() {}

  /**
   * 将给定对象转换为字符串，每行缩进 4 个空格（除了首行）
   *
   * @param o 对象
   * @return 格式化字符串
   */
  public static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static String urlEncode(String string) {
    try {
      return URLEncoder.encode(string, StandardCharsets.UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

}
