package com.fpinjava.functions.exercise02_10;

public class FunctionExamples {

  public static <A, B, C> Function<A, Function<B, C>> curry(Function<Tuple<A, B>, C> f) {
    return new Function<A, Function<B, C>>() {
      @Override
      public Function<B, C> apply(A a) {
        return new Function<B, C>() {
          @Override
          public C apply(B b) {
            return f.apply(new Tuple<>(a, b));
          }
        };
      }
    };
  }
}
