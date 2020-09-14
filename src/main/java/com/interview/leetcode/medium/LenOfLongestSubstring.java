package com.interview.leetcode.medium;

public class LenOfLongestSubstring {
  public static void main(String[] args) {
    String testStr = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(testStr));
  }

  public static int lengthOfLongestSubstring(String testStr) {
    String second = "";
    String longest = "";
    int longestStr = 0;
    if (testStr.length() == 1) {
      return 1;
    }
    for (int i = 0; i < testStr.length(); i++) {
      longest = testStr.substring(i, i+1);
      for (int j = i+1; j < testStr.length(); j++) {
        second = testStr.substring(j, j+1);
        if (!longest.contains(second)) {
          longest = longest + second;
        } else {
          if (longestStr < longest.length()) {
            longestStr = longest.length();
          }
          break;
        }
      }
      if (longestStr < longest.length()) {
        longestStr = longest.length();
      }
    }
    return longestStr;
  }
}
