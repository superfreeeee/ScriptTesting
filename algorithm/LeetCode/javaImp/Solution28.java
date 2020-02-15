package javaImp;

/**
 * Solution28
 */
public class Solution28 {

  public int strStr(String haystack, String needle) {
    if(needle.length() == 0)
      return 0;
    char[] template = haystack.toCharArray();
    char head = needle.charAt(0);

    for(int i=0 ; i<template.length ; i++) {
      if(template[i] == head && haystack.substring(i).startsWith(needle))
        return i;
    }
    return -1;
  }

  public int strStr2(String haystack, String neddle) {
    return haystack.indexOf(neddle);
  }

  public static void main(String[] args) {
    Solution28 s28 = new Solution28();
    String haystack = "aaa";
    String needle = "bba";
    int result = s28.strStr(haystack, needle);
    System.out.println(result);
  }
}