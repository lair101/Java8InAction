package com.guo.j8.nineChapter.BT;


import java.util.HashMap;

/***
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 * following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1. put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before
 * inserting a new item.
 *
 * Follow up: Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 / capacity /) //cache.put(1,1); //cache.put(2,2);
 * //cache.get(1); // returns 1 //cache.put(3,3); // evicts key 2 //cache.get(2); // returns -1 (not
 * found) //cache.put(4,4); // evicts key 1 //cache.get(1); // returns -1 (not found)
 * //cache.get(3); // returns 3 //cache.get(4); // returns 4
 *
 ***/
public class LRU {

  // hashmap + doule linkedlist
  // hashmap for o(1) get
  // double linkedlist for o(1) set
  int capacity = 0;
  Node head = null;
  Node end = null;
  HashMap<Integer, Node> map = new HashMap<>();

  public LRU(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      // Node exsited
      Node n = map.get(key);
      remove(n);
      add(n);
      return n.val;
    } else {
      // not exsited
      return -1;
    }
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) {
      // update value
      Node old = map.get(key);
      old.val = value;
      remove(old);
      add(old);
    } else {
      Node newNode = new Node(key, value);
      if (map.size() + 1 > capacity) {
        // remove end node(least used node)
        map.remove(end.key);
        remove(end);
        add(newNode);
      } else {
        add(newNode);
      }
      map.put(key, newNode);
    }
  }

  private void remove(Node n) {
    if (n.pre == null) {
      // this is head node
      head = n.next;
    } else {
      n.pre.next = n.next;
    }

    if (n.next == null) {
      // this is end node
      end = n.pre;
    } else {
      n.next.pre = n.pre;
    }
  }

  private void add(Node n) {
    // add the node to the head
    n.next = head;
    n.pre = null;
    if (head != null)
      head.pre = n;

    head = n;
    if (end == null)
      end = head;

  }
}


class Node {
  Node pre;
  int val;
  int key;
  Node next;

  Node(int key, int val) {
    this.val = val;
    this.key = key;
  }
}
