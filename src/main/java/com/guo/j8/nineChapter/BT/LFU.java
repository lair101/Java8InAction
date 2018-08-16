package com.guo.j8.nineChapter.BT;

import org.junit.jupiter.api.Test;

import java.util.*;

/***
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new
 * item. For the purpose of this problem, when there is a tie (i.e., two or more
 * keys that have the same frequency), the least recently used key would be
 * evicted.
 *
 *
 *
 * LFUCache cache = new LFUCache( 2 / capacity / );
 *
 * cache.put(1,1); cache.put(2,2); cache.get(1); // returns 1 cache.put(3,3); //
 * evicts key 2 cache.get(2); // returns -1 (not found) cache.get(3); // returns
 * 3. cache.put(4,4); // evicts key 1. cache.get(1); // returns -1 (not found)
 * cache.get(3); // returns 3 cache.get(4); // returns 4
 *
 *
 *
 */

public class LFU {

	// HashMap for O(1)
	// Double linkedList for each freq
	int capacity;

	class Node {
		int freq;
		int val;
		Node pre;
		Node pos;

		Node(int val, int freq) {
			this.freq = freq;
			this.val = val;
		}
	}

	HashMap<Integer, Node> map = new HashMap<>();

	ArrayList<Node> arr = new ArrayList<>(); // store the head of each double
												// linkedList

	public LFU(int capacity) {
		this.capacity = capacity;
	}

	// put
	public void put(int key, int value) {

		// check if node is existed or not
		if (map.containsKey(key)) {
			// if existed, its a update
			// get the current node
			Node cur = map.get(key);
			int curFreq = cur.freq;
			remove(arr, curFreq, cur);
			// update node
			cur.freq++;
			cur.val = value;
			add(arr, curFreq, cur); // curFreq == index of arr
			// update hashmap
			map.put(key, cur);

		} else {
			// if not
			// create new node
			Node newNode = new Node(value, 0);
			// add the node into arr[0] tail
			add(arr, 0, newNode);
			// check if hashmap over weight
			// add it to map
			map.put(key, newNode);
			if (map.size() > capacity) {
				removeRecent();
				map.remove(key);
			}
		}
	}

	private void removeRecent() {
		// remove the head of arr[0]
		Node head = arr.get(0);
		if (head == null)
			return;
		Node newhead = head.pos;
		newhead.pre = head.pre;
		head.pre.pos = newhead;
		head = newhead;

		if (head.pre == head && head.pos == head) {
			// head is cur, we need to move the head pointer
			arr.set(0, null);
		}

	}

	private void remove(ArrayList<Node> arr, int curFreq, Node cur) {
		// get head of arr[curFreq] double list
		Node head = arr.get(curFreq);
		if (head == cur) {
			// head is cur, we need to move the head pointer
			arr.set(curFreq, null);
		}

		Node pre = cur.pre;
		Node pos = cur.pos;
		pre.pos = pos;
		pos.pre = pre;

	}

	private void add(ArrayList<Node> arr, int i, Node newNode) {
		if (arr.size() == i) {
			// create head;
			newNode.pre = newNode;
			newNode.pos = newNode;
			arr.add(newNode);
		} else {
			Node head = arr.get(i);
			head.pos.pre = newNode;
			newNode.pos = head.pos;
			newNode.pre = head;
			head.pos = newNode;
		}

	}

	// get
	public String get(int key) {

		// check if hashmap has the node
		if (map.containsKey(key)) {
			// get the node
			Node cur = map.get(key);
			if (cur == null)
				return "null";
			// remove the old node
			int curFreq = cur.freq;
			remove(arr, curFreq, cur);
			// update node freq
			cur.freq++;
			add(arr, curFreq, cur);
			return String.valueOf(cur.val);
		} else {
			return "-1";
		}

	}

	@Test
	public void test() {
		LFU l = new LFU(2);
		l.put(1, 1);
		l.put(2, 2);
		System.out.println(l.get(1));
		l.put(3, 3);
		System.out.println(l.get(2));
		System.out.println(l.get(3));
		l.put(4, 4);
		System.out.println(l.get(1));
		System.out.println(l.get(3));
		System.out.println(l.get(4));
	}

}
