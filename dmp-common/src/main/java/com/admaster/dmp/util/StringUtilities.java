package com.admaster.dmp.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;



public abstract class StringUtilities {

	private StringUtilities() {}

	/**
	 * 检查指定的字符串是否为空。
	 * <ul>
	 * <li>SysUtils.isEmpty(null) = true</li>
	 * <li>SysUtils.isEmpty("") = true</li>
	 * <li>SysUtils.isEmpty("   ") = true</li>
	 * <li>SysUtils.isEmpty("abc") = false</li>
	 * </ul>
	 * 
	 * @param value 待检查的字符串
	 * @return true/false
	 */
	public static boolean isEmpty(String value) {
		int strLen;
		if (value == null || (strLen = value.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(value.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查对象是否为数字型字符串,包含负数开头的。
	 */
	public static boolean isNumeric(Object obj) {
		if (obj == null) {
			return false;
		}
		char[] chars = obj.toString().toCharArray();
		int length = chars.length;
		if(length < 1)
			return false;
		
		int i = 0;
		if(length > 1 && chars[0] == '-')
			i = 1;
		
		for (; i < length; i++) {
			if (!Character.isDigit(chars[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查指定的字符串列表是否不为空。
	 */
	public static boolean areNotEmpty(String... values) {
		boolean result = true;
		if (values == null || values.length == 0) {
			result = false;
		} else {
			for (String value : values) {
				result &= !isEmpty(value);
			}
		}
		return result;
	}

	/**
	 * 把通用字符编码的字符串转化为汉字编码。
	 */
	public static String unicodeToChinese(String unicode) {
		StringBuilder out = new StringBuilder();
		if (!isEmpty(unicode)) {
			for (int i = 0; i < unicode.length(); i++) {
				out.append(unicode.charAt(i));
			}
		}
		return out.toString();
	}

	public static String toUnderlineStyle(String name) {
		StringBuilder newName = new StringBuilder();
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (Character.isUpperCase(c)) {
				if (i > 0) {
					newName.append("_");
				}
				newName.append(Character.toLowerCase(c));
			} else {
				newName.append(c);
			}
		}
		return newName.toString();
	}

	public static String convertString(byte[] data, int offset, int length) {
		if (data == null) {
			return null;
		} else {
			try {
				return new String(data, offset, length, "utf-8");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static byte[] convertBytes(String data) {
		if (data == null) {
			return null;
		} else {
			try {
				return data.getBytes(ConstantUtilities.CHARSET_UTF8);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static List<Long> splitStrToList(String str){
		List<Long> list = new ArrayList<Long>();
		if (StringUtils.isEmpty(str)) {
			 return new ArrayList<>(0);
		}
		String[] split = StringUtils.split(str, ConstantUtilities.SEGMENTATION);
		for (String string : split) {
			list.add(NumberUtils.toLong(string, -1l));
		}
		return list ;
	}
	
	
	public static List<Integer> splitStrToListInt(String str){
		List<Integer> list = new ArrayList<Integer>();
		if (StringUtils.isEmpty(str)) {
			 return new ArrayList<>(0);
		}
		String[] split = StringUtils.split(str, ConstantUtilities.SEGMENTATION);
		for (String string : split) {
			list.add(NumberUtils.toInt(string, -1));
		}
		return list ;
	}
	
	
	public static List<String> splitStrToListString(String str){
		List<String> list = new ArrayList<String>();
		if (StringUtils.isEmpty(str)) {
			 return new ArrayList<>(0);
		}
		String[] split = StringUtils.split(str, ConstantUtilities.SEGMENTATION);
		for (String string : split) {
			list.add(string);
		}
		return list ;
	}
	
	
	/**
	 * 将string 转换为 long
	 * 
	 * @param strs
	 * @return 空 list
	 */
	public static List<Long> strLongList(String str, String splitChars) {
		if (StringUtils.isEmpty(str)) {
			return new ArrayList<Long>(0);
		}
		return splitStrLongList(str, splitChars);
	}

	/**
	 * 拆分字符串，为long 的list类型
	 * @param str
	 * @param splitChars
	 * @return
	 */
	public static List<Long> splitStrLongList(String str, String splitChars) {
		if(StringUtils.isEmpty(str))
			return new ArrayList<>(0);
		String[] strs = str.split(splitChars);
		List<Long> list = new ArrayList<Long>(strs.length);
		for (String item : strs) {
			list.add(NumberUtils.toLong(item));
		}
		return list;
	}
	
	/**
	 * 拆分字符串，为Integer 的list类型
	 * @param str
	 * @param splitChars
	 * @return
	 */
	public static List<Integer> splitStrIntList(String str, String splitChars) {
		if(StringUtils.isEmpty(str))
			return new ArrayList<>(0);
		String[] strs = str.split(splitChars);
		List<Integer> list = new ArrayList<Integer>(strs.length);
		for (String item : strs) {
			list.add(NumberUtils.toInt(item));
		}
		return list;
	}
	
	/**
	 * 将string 转换为 long
	 * 默认分割符为,
	 * @param strs
	 * @return 空 list
	 */
	public static List<Long> strLongList(String strs) {
		return strLongList(strs, ConstantUtilities.SEGMENTATION);
	}
	
	/**
	 * 将string 转换为 long
	 * 
	 * @param strs
	 * @return 为 null
	 */ 
	public static List<Long> strLongNullList(String str, String splitChars) {
		if (StringUtils.isEmpty(str)) {
			 return new ArrayList<>(0);
		}
		return splitStrLongList(str, splitChars);
	}
	
	/**
	 * 将string 转换为 long
	 * 默认分割符为,
	 * @param strs
	 * @return 为 null
	 */
	public static List<Long> strLongNullList(String strs) {
		return strLongNullList(strs, ConstantUtilities.SEGMENTATION);
	}

	/**
	 * 将string 转为list
	 * 
	 * @param strs
	 * @return 为 null
	 */ 
	public static List<String> strNullList(String str, String splitChars) {
		if (StringUtils.isEmpty(str)) {
			 return new ArrayList<>(0);
		}
		return splitStrList(str, splitChars);
	}

	/**
	 * 将string 转为list
	 * @param str
	 * @param splitChars
	 * @return
	 */
	public static List<String> splitStrList(String str, String splitChars) {
		if (StringUtils.isEmpty(str)) {
			 return new ArrayList<>(0);
		}
		String[] strs = str.split(splitChars);
		List<String> list = new ArrayList<String>(strs.length);
		for (String item : strs) {
			list.add(item);
		}
		return list;
	}
	
	/**
	 * 将string 转为list
	 * 默认分割符为,
	 * @param strs
	 * @return 为 null
	 */
	public static List<String> strNullList(String strs) {
		return strNullList(strs, ConstantUtilities.SEGMENTATION);
	}

	/**
	 * 将string 转为list
	 * 
	 * @param strs
	 * @return 为 空list
	 */ 
	public static List<String> strList(String str, String splitChars) {
		if (StringUtils.isEmpty(str)) {
			return new ArrayList<String>(0);
		}
		return splitStrList(str, splitChars);
	}
	
	/**
	 * 将string 转为list
	 * 默认分割符为,
	 * @param strs
	 * @return 为 空list
	 */
	public static List<String> strList(String strs) {
		return strList(strs, ConstantUtilities.SEGMENTATION);
	}
	
	
	/**
	 * 将string 转为list
	 * 
	 * @param strList
	 * @param splitChars
	 * @return 
	 */ 
	public static String listToStr(List<?> strList, String splitChars) {
		StringBuffer str = new StringBuffer();
		if (CollectionUtils.isEmpty(strList)) {
			return str.toString();
		}
		for (Object object : strList) {
			str.append(object);
			str.append(splitChars);
		}
		String string = str.toString();
		if(StringUtils.isNotEmpty(string)){
			string = string.substring(0, string.lastIndexOf(","));
		}
		return string;
	}
	
	public static String listToStr(List<?> strList) {
		return listToStr(strList, ConstantUtilities.SEGMENTATION);
	}

}
