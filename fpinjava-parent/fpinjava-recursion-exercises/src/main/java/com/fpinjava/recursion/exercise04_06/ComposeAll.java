package com.fpinjava.recursion.exercise04_06;

import java.util.List;

import com.fpinjava.common.Function;


public class ComposeAll {

  static <T> Function<T, T> composeAll(List<Function<T, T>> list) {

    Function<Integer, Integer> f1 = i -> i + 1;
    Function<Integer, Integer> f2 = i -> i + 2;
    Function<Integer, Integer> f3 = i -> i + 3;


    // A -> fA -> A


    return null;
  }

  static <A> Function<A, A> compose(Function<A, A> f1, Function<A, A> f2) {
    //Function<T, Function<T, F>> composed = T -> T -> F;

    Function<A, A> composed = arg -> f1.apply(f2.apply(arg));
    return composed;
  }

//  static <F, A> Function<Function<A, A>, Function<>> partial(Function<A, A> f1) {
//    return null;
//  }

    static Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>> > composer = a -> b -> arg -> a.apply(b.apply(arg));

  public static void main(String[] args) {
    Function<Integer, Integer> f1 = i -> i + 1;
    Function<Integer, Integer> f2 = i -> i + 2;
    Function<Integer, Integer> f3 = i -> i + 3;



    //System.out.println(f1.apply(f2.apply(f3.apply(0))));
    System.out.println(f1.apply(f2.apply(0)));
    System.out.println(composer.apply(f1).apply(f2).apply(0));
  }
}
