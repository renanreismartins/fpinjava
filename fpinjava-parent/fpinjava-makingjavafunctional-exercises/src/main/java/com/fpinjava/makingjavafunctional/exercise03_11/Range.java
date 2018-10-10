package com.fpinjava.makingjavafunctional.exercise03_11;

import java.util.ArrayList;
import static  com.fpinjava.makingjavafunctional.exercise03_10.CollectionUtilities.*;
import java.util.List;


public class Range {

  // ugly as hell
  public static List<Integer> range(int start, int end) {
    List<Integer> list = new ArrayList<>();
    for (int i = start; i < end; i++) {
       list.add(i);
    }

    return list;
  }
}
