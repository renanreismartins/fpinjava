package com.fpinjava.makingjavafunctional.exercise03_05;

import com.fpinjava.common.Function;

import java.util.List;

public class Fold {

  public static Integer fold(List<Integer> is, Integer identity,
                             Function<Integer, Function<Integer, Integer>> f) {
    Integer acc = identity;
    for (Integer i : is) {
      acc = f.apply(i).apply(acc);
    }
    return acc;
  }
}
