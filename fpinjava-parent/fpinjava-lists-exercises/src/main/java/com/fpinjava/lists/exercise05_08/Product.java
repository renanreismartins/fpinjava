package com.fpinjava.lists.exercise05_08;

import com.fpinjava.lists.exercise05_06.List;

public class Product {

  public static Double product(List<Double> ints) {
    return product_(ints, 1D);
  }

  private static Double product_(List<Double> ints, Double acc) {

    return ints.isEmpty()
            ? acc
            : product_(ints.tail(), acc * ints.head());

  }
}
