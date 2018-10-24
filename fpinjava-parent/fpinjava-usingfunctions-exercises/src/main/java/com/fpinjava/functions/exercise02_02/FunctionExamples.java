package com.fpinjava.functions.exercise02_02;

import java.util.function.BiFunction;

public class FunctionExamples {

  public static final Function<Integer, Integer> triple = x -> x * 3;

  public static final Function<Integer, Integer> square = x -> x * x;

  //Write a new version of the compose method by using lambdas.
  public static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
    return arg -> f1.apply(f2.apply(arg));
  }


  // Extra: instead of method, use a function
  BiFunction<Function<Integer, Integer>, Function<Integer, Integer>, Function<Integer, Integer>> compose =
          (f1, f2) -> arg -> f1.apply(f2.apply(arg));
}
