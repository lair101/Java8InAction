package com.guo.j8.Chapter3;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Chpater3_2 {

    //use lambda expression as sort
    //to sort a hashmap, we have to map it into new map
    //but if we only want to first serveral elments.
    //We can sort it and put it into list
    public Character getMostChar(String s){

        char rs;

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : s.trim().replace("\\s+"," ").toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        rs = map.entrySet().stream().sorted(
                Map.Entry.<Character, Integer>comparingByValue().reversed()
        ).limit(1).collect(Collectors.toList()).get(0).getKey();

        return rs;
    }



    //use string reverse the sentence
    //Easy way :
    //Use stringbuilder to append the string from tail to head
    //but Java 8 we can put string[] into list and reversely writeout
    public String reverseString(String str){

        String[] strs = str.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
        }

        return sb.toString();
    }


    @Test
    public void test(){
        String s = "asjgnkldsfngksndklfgn";
        System.out.println(getMostChar(s));
    }
}
