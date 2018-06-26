package com.guo.j8.nineChapter.searching;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/***
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 *
 * Note:
 *
 *     S will be a string with length at most 12.
 *     S will consist only of letters or digits.
 */
public class Permutation {

    //using template of dfs to loop all the possibilities
    //add condition for letter case

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(S, res, 0, sb);
        return res;
    }

    private void dfs(String str, List<String> res, int index, StringBuilder sb) {
        if(index == str.length()){
            res.add(sb.toString());
            return ;
        } else {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                sb.append(str.charAt(index));
                dfs(str, res, index+1, sb);
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append( Character.toLowerCase(str.charAt(index)));
                dfs(str, res, index+1, sb);
                sb.deleteCharAt(sb.length()-1);
                sb.append(Character.toUpperCase(str.charAt(index)));
                dfs(str, res, index+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }

        }

    }

    @Test
    public void test() {
        Permutation p = new Permutation();
        List<String> res = p.letterCasePermutation("a1b2");
        System.out.println(res);
    }
}
