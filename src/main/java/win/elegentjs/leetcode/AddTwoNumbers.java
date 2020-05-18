package win.elegentjs.leetcode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);


        ListNode l2 = new ListNode(0);


        ListNode result = new Solution().addTwoNumbers(l1, l2);

        System.out.println(result);

    }

}

class Solution {

    // 求解思路：将两个链表分别还原为非负整数，再执行相加，最后将和分解为链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val1 = getIntValue(l1);
        int val2 = getIntValue(l2);

        int sum = val1 + val2;


        ListNode rootNode = null;
        ListNode itemNode = null;

        while(sum > 0) {
            if (rootNode == null) {
                rootNode = new ListNode(sum % 10);
                itemNode = rootNode;
                sum = sum / 10;
            } else {
                itemNode.next = new ListNode(sum % 10);
                itemNode = itemNode.next;
                sum = sum / 10;
            }
        }

        if (rootNode == null) {
            rootNode = new ListNode(0);
        }

        return rootNode;
    }


    private int getIntValue(ListNode node) {
        int result = 0;

        int len = 1;
        for (ListNode item = node; item != null; item = item.next) {
            result +=  len * item.val;
            len *= 10;
        }

        return result;
    }



}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    private int getIntValue(ListNode node) {
        int result = 0;

        int len = 1;
        for (ListNode item = node; item.next != null; item = item.next) {
            result +=  len * item.val;
            len *= 10;
        }

        return result;
    }

      public String toString() {
          String result = "";

          for (ListNode item = this; item != null; item = item.next) {
              result += item.val + " -> ";
          }

          return result.substring(0, result.length() - 4);
      }
  }