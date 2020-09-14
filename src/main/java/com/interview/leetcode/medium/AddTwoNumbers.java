package com.interview.leetcode.medium;

class ListNode {
  int val;
  ListNode next;
  ListNode() {
  }
  ListNode(int val) {
    this.val = val;
  }
  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(val + " ");
    ListNode nextLN = next;
    while (nextLN != null) {
      stringBuilder.append(nextLN.val + " ");
      nextLN = nextLN.next;
    }
    return stringBuilder.toString();
  }
}

public class AddTwoNumbers {
  public static ListNode createLN(int[] numArr) {
    ListNode currNode = new ListNode();
    ListNode retNode = currNode;
    for (int i = 0; i < numArr.length; i++) {
      if (currNode.next == null) {
        currNode.val = numArr[i];
        if (i < numArr.length - 1) {
          currNode.next = new ListNode();
          currNode = currNode.next;
        }
      }
    }
    return retNode;
  }
  public static void main(String[] args) {
    int[] numArr1 = { 2, 4, 3 };
    int[] numArr2 = { 5, 6, 4 };
    ListNode l1 = createLN(numArr1);
    ListNode l2 = createLN(numArr2);
    System.out.println("ListNode:" + addTwoNumbers(l1, l2));
  }
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    int first = 0;
    int second = 0;
    int total = 0;
    ListNode l3 = new ListNode();
    ListNode retLN = l3;
    while(l1 != null || l2 != null) {
      first = 0;
      second = 0;
      if (l1 != null) {
        first = l1.val;
      }
      if (l2 != null) {
        second = l2.val;
      }
      total = first + second + carry;
      if (total >= 10) {
        l3.val = total % 10;
        carry = 1;
      } else {
        l3.val = total;
        carry = 0;
      }
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
      if (l1 != null || l2 != null || carry == 1) {
        l3.next = new ListNode();
      }
      l3 = l3.next;
    }
    if (carry == 1) {
      l3.val = 1;
      l3.next = null;
    } else {
      l3 = null;
    }
    return retLN;
  }
}
