package com.fpinjava.recursion.exercise04_04;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.TailCall;

import java.util.List;

import static com.fpinjava.common.TailCall.ret;
import static com.fpinjava.common.TailCall.sus;


public class Range {

  public static List<Integer> range(Integer start, Integer end) {
    return range_(start, end, CollectionUtilities.list()).eval();
  }

  public static TailCall<List<Integer>> range_(Integer start, Integer end, List<Integer> acc) {
    return end <= start
            ? ret(acc)
            : sus(() -> range_(start + 1, end, CollectionUtilities.append(acc, start)));
  }
}
