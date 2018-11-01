package com.fpinjava.lists.exercise05_18;

import com.fpinjava.lists.exercise05_16.List;

public class DoubleToString {

  public static List<String> doubleToString(List<Double> list) {
    return List.foldRight(list, List.list(), e -> acc -> acc.cons(e.toString()));
  }
}
