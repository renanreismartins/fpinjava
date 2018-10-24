package com.fpinjava.functions.exercise02_01;

import java.util.function.BiFunction;

public class FunctionExamples {

  public static final Function<Integer, Integer> triple = new Function<Integer, Integer>() {

    @Override
    public Integer apply(Integer arg) {
      return arg * 3;
    }
  };

  public static final Function<Integer, Integer> square = new Function<Integer, Integer>() {

    @Override
    public Integer apply(Integer arg) {
      return arg * arg;
    }
  };

  public static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
    return new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer arg) {
        return f1.apply(f2.apply(arg));
      }
    };
  }

  // Extra: instead of method, use a function
  // No lambdas to make it didactic
  BiFunction<Function<Integer, Integer>, Function<Integer, Integer>, Function<Integer, Integer>> compose =
    new BiFunction<Function<Integer, Integer>, Function<Integer, Integer>, Function<Integer, Integer>>() {
      @Override
      public Function<Integer, Integer> apply(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return new Function<Integer, Integer>() {
          @Override
          public Integer apply(Integer arg) {
            return f1.apply(f2.apply(arg));
          }
        };
      }
    };
  }
