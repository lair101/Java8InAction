// package com.guo.j8.nineChapter.BT;
//
//
// import java.awt.event.ItemEvent;
// import java.util.*;
//
// /***
// * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support
// the following operations: get and put.
// *
// * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
// otherwise return -1.
// * put(key, value) - Set or insert the value if the key is not already present.
// * When the cache reaches its capacity, it should invalidate the least frequently used item before
// inserting a new item.
// * For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same
// frequency), the least recently used key would be evicted.
// *
// *
// *
// * LFUCache cache = new LFUCache( 2 / capacity / );
// *
// *cache.put(1,1);
// *cache.put(2,2);
// *cache.get(1); // returns 1
// *cache.put(3,3); // evicts key 2
// *cache.get(2); // returns -1 (not found)
// *cache.get(3); // returns 3.
// *cache.put(4,4); // evicts key 1.
// *cache.get(1); // returns -1 (not found)
// *cache.get(3); // returns 3
// *cache.get(4); // returns 4
// *
// *
// *
// */
// public class LFU {
//
// //get as O(1) --> hashmap
// //put as O(1) --> LinkedList
// //To get least frequent usage element, we also need to get a counter
// //SortedSet saves the <key, calltimes> object, and sort it ascending
// //we can combine object into one
// //
// int capacity;
// class Item{
// int key;
// int usage;
// int val;
//
// Item(int key, int usage,int val){
// this.key =key;
// this.usage =usage;
// this.val = val;
// }
// }
//
// public LFU(int capacity) {
// this.capacity = capacity;
// }
//
// LinkedHashMap<Integer,Item> map = new LinkedHashMap<>();
//
// //put
// public void put(int key, int value){
// //check the capacity, if reach the bottleneck, remove the least usaged one
// if(map.size()+1>=capacity){
// //remove the least frequent one
// map.
//
// }
//
// map.put(key,value);
// }
//
//
// //get
// public int get(int key){
//
// }
//
//
// }
