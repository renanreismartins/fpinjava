package com.fpinjava.functions.exercise02_05;

public interface Function<T, U> {

  U apply(T arg);

  //Write a polymorphic version of the compose function.
  // didnt did this, but understood the concept, the previous implementation is not enough because how java treat the types
  static <T, U, V> Function<Function<U, V>,Function<Function<T, U>, Function<T, V>>> higherCompose() {
    return f -> g -> x -> f.apply(g.apply(x));
  }
}
