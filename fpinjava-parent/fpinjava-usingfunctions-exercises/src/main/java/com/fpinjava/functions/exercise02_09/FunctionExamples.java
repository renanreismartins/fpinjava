package com.fpinjava.functions.exercise02_09;

public class FunctionExamples {

  private static String format = "%s, %s, %s, %s";
  <A, B, C, D> String func(A a, B b, C c, D d) {
    return String.format(format, a, b, c, d);
  }


  public static <A, B, C, D> Function<A, Function<B, Function<C, Function<D, String>>>> f() {
    return a -> b ->  c -> d -> String.format("%s, %s, %s, %s", a, b, c, d);
  }

  public static <A, B, C, D> Function<A, Function<B, Function<C, Function<D, String>>>> f2() {
    return a ->  b -> c ->  d -> String.format("%s, %s, %s, %s", a, b, c, d);
  }

  <A,B,C,D> Function<A, Function<B, Function<C, Function<D, String>>>> f1() {
    return a -> b -> c -> d -> String.format("%s, %s, %s, %s", a, b, c, d);
  }
}
