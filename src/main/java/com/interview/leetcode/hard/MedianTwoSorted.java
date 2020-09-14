package com.interview.leetcode.hard;

public class MedianTwoSorted {
  public static void main(String[] args) {
    int[] nums1 = { };
    int[] nums2 = { 1 };
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int both = nums1.length + nums2.length;
    int[] nums3 = new int[both];
    int i = 0;
    int j = 0;
    int x = 0;
    if (nums1.length == 0) {
      nums3 = nums2;
      x = both;
    }
    if (nums2.length == 0) {
      nums3 = nums1;
      x = both;
    }
    while (x < both) {
      if (nums1[i] <= nums2[j]) {
        nums3[x] = nums1[i];
        x++;
        i++;
        if (i == nums1.length) {
          while (j < nums2.length) {
            nums3[x] = nums2[j];
            x++;
            j++;
          }
        }
      } else {
        nums3[x] = nums2[j];
        x++;
        j++;
        if (j == nums2.length) {
          while (i < nums1.length) {
            nums3[x] = nums1[i];
            x++;
            i++;
          }
        }
      }
    }
    int n = nums3.length;
    if (n % 2 != 0) {
      return (double) nums3[n/2];
    } else {
      return (double) (nums3[n/2 - 1] +  nums3[n/2])/2;
    }
  }
}
