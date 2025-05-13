package com.sulvic.mcf.util;

@SuppressWarnings({"unused"})
public class ZimedaString{

	public static boolean isNullOrEmpty(String str){ return str == null || str.equals(""); }

	public static String padEnd(String str, char ch, int length){
		if(isNullOrEmpty(str)) throw new NullPointerException("String cannot be empty or null");
		String result = str;
		int len = result.length();
		while((len = result.length()) < length) result += ch;
		return result;
	}

	public static String padStart(String str, char ch, int length){
		if(isNullOrEmpty(str)) throw new NullPointerException("String cannot be empty or null");
		String result = str;
		int len;
		while((len = result.length()) < length) result = ch + str;
		return result;
	}

}
