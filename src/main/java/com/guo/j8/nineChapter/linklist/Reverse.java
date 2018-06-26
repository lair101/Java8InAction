package com.guo.j8.nineChapter.linklist;


import org.junit.jupiter.api.Test;

/**
 * Description
 *
 * Reverse a linked list. Have you met this question in a real interview? Example
 *
 * For linked list 1->2->3, the reversed linked list is 3->2->1 Challenge
 *
 * Reverse it in-place and in one-pass
 */
public class Reverse {


  /**
   * reverse the list and return new head
   * 
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {

    if (head == null)
      return head; // check null

    ListNode pre = null;

    while (head != null) {
      ListNode tmp = head.next; // save the old next relation of node pre head --> 2(tmp) ---> 3
                                // ---> 4 -->...
      head.next = pre; // pre(null) <-- head 2 ---> 3 ---> 4 -->...
      pre = head; // null <-- pre(head) 2 ---> 3 ---> 4 -->...
      head = tmp; // null <-- pre 2(head) ---> 3 ---> 4 -->...
    }

    return pre;
  }

  /**
   * reverse the mth nth nodes m< n
   * 
   * @param head
   * @param m
   * @param n
   * @return
   */
  public ListNode reverseListBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode node = dummy;
    int i = 0;
    while (node != null) {
      if (i == m - 1) {
        node.next = reverse(node.next, m, n, i + 1, null, null);
        break;
      }
      node = node.next;
      i++;
    }
    return dummy.next;

  }

  public ListNode reverse(ListNode node, int m, int n, int i, ListNode newHead, ListNode newTail) {
    if (i == m) {
      return reverse(node.next, m, n, i + 1, node, node);
    } else if (i == n + 1) {
      newTail.next = node;
      return newHead;
    } else {
      ListNode next = node.next;
      node.next = newHead;
      return reverse(next, m, n, i + 1, node, newTail);
    }
  }

  private void print(ListNode head) {
    ListNode h = head;
    while (h != null) {
      System.out.print(h.val + "-->");
      h = h.next;
    }
  }

  @Test
  public void test() {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    ListNode n6 = new ListNode(6);
    ListNode n7 = new ListNode(7);
    ListNode n8 = new ListNode(8);
    ListNode n9 = new ListNode(9);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;
    n8.next = n9;
    n9.next = null;

    Reverse r = new Reverse();
    r.print(n1);
    ListNode newHead = r.reverseListBetween(n1, 4, 7);
    System.out.println();
    r.print(newHead);
  }

}
