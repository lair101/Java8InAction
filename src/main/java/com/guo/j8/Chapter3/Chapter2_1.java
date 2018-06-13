package com.guo.j8.Chapter3;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chapter2_1 {

    /**
     *
     *  lambda expression
     * (parameters) -> expression
        or (note the curly braces for statements)
        (parameters) -> { statements; }



        Java 8 default functional interface:

         Predicate<T> Consumer<T> Function<T, R>
         Supplier<T> UnaryOperator<T> BinaryOperator<T> BiPredicate<L, R>
         BiConsumer<T, U>
         BiFunction<T, U, R>
         Function descriptor
         T -> boolean T -> void
         T -> R
         () -> T
         T -> T
         (T, T) -> T
         (L, R) -> boolean
         (T, U) -> void
         (T, U) -> R
         Primitive specializations
         IntPredicate, LongPredicate, DoublePredicate
         IntConsumer, LongConsumer, DoubleConsumer
         IntFunction<R>, IntToDoubleFunction, IntToLongFunction, LongFunction<R>, LongToDoubleFunction, LongToIntFunction, DoubleFunction<R>, ToIntFunction<T>, ToDoubleFunction<T>, ToLongFunction<T>
         BooleanSupplier, IntSupplier, LongSupplier, DoubleSupplier IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator
         ObjIntConsumer<T>, ObjLongConsumer<T>, ObjDoubleConsumer<T>
         ToIntBiFunction<T, U>, ToLongBiFunction<T, U>, ToDoubleBiFunction<T, U>
     */


    /**
     * create a functional interface for the actual data handle part
     * @param t
     * @param test
     * @param <T>
     */
    public <T> void testone(T t, TestInter test){
        test.t(t);
    }

    /**
     * create function has return type
     *
     * <T,R> declare generic type
     * List<R> return type
     *
     * @param t
     * @param test
     * @param <T>
     * @param <R>
     * @return
     */
    public <T, R> List<R> testTwo(T t, TestInter2<T,R> test){
        List<R> result = new ArrayList<>();
        result.add(test.t(t));
        return result;

    }


    @Test
    public void test(){
        int i =0;
       // testone(i,(k) -> {System.out.println(k);});
        List<Integer> rs = testTwo("deds",(String s) -> s.length());
        System.out.println(rs);
    }




}




