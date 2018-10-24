package com.fpinjava.functions.exercise02_03;


public class FunctionExamples {

  //Write a function to add two Integers.
  // no lambdas.
  static Function<Integer, Function<Integer, Integer>> add = new Function<Integer, Function<Integer, Integer>>() {
    @Override
    public Function<Integer, Integer> apply(Integer arg1) {
      return new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer arg2) {
          return arg1 + arg2;
        }
      };
    }
  };

  public void testInterface() {
    add.apply(2).apply(3);
  }


  Function<Integer, Function<Integer, Integer>> addLambdaVersion = arg1 -> arg2 -> arg1 + arg2;

  public static final BinaryOperator add2 =  null; // To be implemented

  public static final BinaryOperator mult =  null; // To be implemented
}
