package com.guo.j8.nineChapter.linklist;

import org.junit.jupiter.api.Test;

/***
 * remove the duplicated nodes from unsorted list
 */
public class RemoveDup {

	public ListNode removeDup(ListNode head) {
		if (head == null)
			return null; // check null
		ListNode newHead = head; // keep the current head
		while (newHead.next != null) {
			ListNode pre = newHead;
			ListNode cur = newHead.next; // get the runner for this newHead
											// element
			while (cur != null) {
				if (cur.val == newHead.val) {
					pre.next = cur.next;
					cur = cur.next;
				} else {
					cur = cur.next;
					pre = pre.next;
				}
			}
			newHead = newHead.next;
		}
		return head;
	}

	@Test
	public void test() {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(1);
		ListNode p5 = new ListNode(1);
		ListNode p6 = new ListNode(1);
		ListNode p7 = new ListNode(1);
		ListNode p8 = new ListNode(4);
		ListNode p9 = new ListNode(5);
		ListNode p10 = new ListNode(6);
		ListNode p11 = new ListNode(7);
		ListNode p12 = new ListNode(8);
		ListNode p13 = new ListNode(9);

		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = p7;
		p7.next = p8;
		p8.next = p9;
		p9.next = p10;
		p10.next = p11;
		p11.next = p12;
		p12.next = p13;

		// printListlist(p1);

		ListNode head = removeDup(p1);

		printListlist(head);
	}

	private void printListlist(ListNode p1) {
		ListNode h = p1;
		while (h != null) {
			System.out.print(h.val + "-->");
			h = h.next;
		}
	}
}
