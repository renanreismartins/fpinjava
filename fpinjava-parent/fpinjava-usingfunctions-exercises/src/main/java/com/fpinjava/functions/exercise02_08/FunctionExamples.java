package com.fpinjava.functions.exercise02_08;

public class FunctionExamples {

  static <A, B, C> Function<A, C> partialB(B b, Function<A, Function<B, C>> f) {
    return new Function<A, C>() {
      @Override
      public C apply(A a) {
        return f.apply(a).apply(b);
      }
    };
  };
}
