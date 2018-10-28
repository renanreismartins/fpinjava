package com.fpinjava.lists.exercise05_07;

import com.fpinjava.lists.exercise05_06.List;

public class Sum {

  public static Integer sum(List<Integer> ints) {
    return sum_(ints, 0);
  }

  private static Integer sum_(List<Integer> ints, Integer acc) {

    return ints.isEmpty()
            ? acc
            : sum_(ints.tail(), acc + ints.head());

  }
}
