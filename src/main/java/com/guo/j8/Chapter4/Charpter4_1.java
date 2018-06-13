package com.guo.j8.Chapter4;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Charpter4_1 {

    /***
     * Stream vs Collections
     *
     * Stream : eager construction  : load the entire block of data and then consume
     *                                like CD movie
     *
     *          * Can be only traversal once
     *
     * Collections : lazy construction : consume only when needed
     *                                 like Internet online video
     *
     *
     * Stream operations:
     *
     *
     *      Operation 	Type 	Return type 	Argument of the operation 	Function descriptor /Purpose
     *      filter 	Intermediate 	Stream<T> 	Predicate<T> 	T -> boolean
     *      map 	Intermediate 	Stream<R> 	Function<T, R> 	T -> R
     *      limit 	Intermediate 	Stream<T>
     *      sorted 	Intermediate 	Stream<T> 	Comparator<T> 	(T, T) -> int
     *      distinctIntermediate 	Stream<T>
     *      forEach Terminal 	Consumes each element from a stream and applies a lambda to each of them
     *      count 	Terminal 	Returns the number of elements in a stream. The operation returns a long
     *      collect Terminal 	Reduces the stream to create a collection such as a List, a Map, or even an Integer
     *
     */

    /**
     * String to Stream
     *
     * We barely use it. Normally we directly process it.
     * If we want to put into stream, We can process it to Stream<Character></>
     */
    public void stringToStream(){
        String str = "this is a test string";
        Stream<Character> characterStream = str.chars()
                .mapToObj(c -> (char) c);

        characterStream.filter(c -> {
            System.out.println(c);
            return c > 'a';
        }).map(c -> {
            System.out.println(c);
            return c.charValue();
        }).forEach(c->{
            System.out.println(c);
            }
        );

    }

    /**
     * List to Stream
     */
    public void listToStream(){
        List<String> lines = Arrays.asList("spring", "node", "haolin");
        lines.stream().filter(s -> {
            return s.equalsIgnoreCase("Haolin");
        }).collect(Collectors.toList()).get(0);
    }

    /**
     * Map to Stream
     */
    public void mapToStream(){
        HashMap<String, Integer> map = new HashMap<>();

        map.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return 0;
            }
        }).limit(3).distinct().count();
    }


}
