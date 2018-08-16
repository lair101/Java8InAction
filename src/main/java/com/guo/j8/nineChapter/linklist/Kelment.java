package com.guo.j8.nineChapter.linklist;

import org.junit.jupiter.api.Test;

/**
 * return kth node value from the tail
 */
public class Kelment {

	public int Kvalue(ListNode head, int k) {

		int len = getLen(head);

		if (len < k) {
			return 0;
		} else {
			for (int i = 0; i < len - k; i++) {
				head = head.next;
			}
			return head.val;
		}

	}

	private int getLen(ListNode head) {
		int res = 0;
		if (head == null)
			return res;
		while (head != null) {
			head = head.next;
			res++;
		}
		return res;
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

		System.out.println(Kvalue(p1, 3));
	}
}
