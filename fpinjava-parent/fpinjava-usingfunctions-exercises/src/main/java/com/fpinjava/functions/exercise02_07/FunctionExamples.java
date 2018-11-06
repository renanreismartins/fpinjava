package com.fpinjava.functions.exercise02_07;


public class FunctionExamples {


  static <A, B, C> Function<B, C> partialA(A a, Function<A, Function<B, C>> f) {
    return new Function<B, C>() {
      @Override
      public C apply(B b) {
        return f.apply(a).apply(b);
      }
    };
  }

}
