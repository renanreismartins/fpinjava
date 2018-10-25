  package com.fpinjava.recursion.exercise04_07;

import java.util.List;

import com.fpinjava.common.Function;

import static com.fpinjava.common.CollectionUtilities.foldLeft;

  public class ComposeAll {

  public static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
    throw new RuntimeException("To be implemented.");
  }
  public static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
    return x -> foldLeft(list, x, a -> b -> { System.out.println("apply"); return b.apply(a); } );
  }

  public static <T> Function<T, T> composeAllViaFoldRight(List<Function<T, T>> list) {
    throw new RuntimeException("To be implemented.");
  }
}
