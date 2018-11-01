package com.fpinjava.lists.exercise05_17;

import com.fpinjava.lists.exercise05_16.List;

public class Triple {

  public static List<Integer> triple(List<Integer> list) {
    //return List.foldRight(list, List.<Integer>list(), x -> y -> cons(x * 3, y)); WHY DOES NOT IT WORK?

    return List.foldRight(list, List.<Integer>list(), a -> b ->
            b.cons(a * 3));
  }

}
