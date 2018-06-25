package com.guo.j8.nineChapter.searching;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subset {


    /**
     * Notice that the given numbers are distinct. So we dont need to consider the duplicated elements
     * DFS searching for all the possibilities
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> tmp, int index) {

        if(index > nums.length){
            res.add(new ArrayList<Integer>());
        }else{
            res.add(new ArrayList<>(tmp));  //get a copy of curent tmp array list
        }
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(nums, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    @Test
    public void test() {
        Subset s = new Subset();
        List<List<Integer>> res = s.subsets(new int[]{1, 2, 3});
        for (List<Integer> a : res) {
            System.out.println(a);
        }

    }


}
