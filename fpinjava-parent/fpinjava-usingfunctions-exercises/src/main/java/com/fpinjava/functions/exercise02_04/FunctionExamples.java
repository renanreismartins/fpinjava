package com.fpinjava.functions.exercise02_04;

public class FunctionExamples {

  public static final Function<Integer, Integer> triple = x -> x * 3;

  public static final Function<Integer, Integer> square = x -> x * x;

  //Write a function to compose the two functions square and triple used in exercise 2.2.
  static Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> compose = new Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>>() {
    @Override
    public Function<Function<Integer, Integer>, Function<Integer, Integer>> apply(Function<Integer, Integer> f1) {
      return new Function<Function<Integer, Integer>, Function<Integer, Integer>>() {
        @Override
        public Function<Integer, Integer> apply(Function<Integer, Integer> f2) {
          return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
              return f1.apply(f2.apply(arg));
            }
          };
        }
      };
    }
  };

  public void testInterface() {
    compose.apply(triple).apply(square).apply(3);
  }

  Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> composeLambdaVersion = f1 -> f2 -> arg -> f1.apply(f2.apply(arg));

  public static final Function<Integer, Integer> f = compose.apply(square).apply(triple);
}
