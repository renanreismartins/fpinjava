package com.fpinjava.advancedtrees.exercise11_05;


import com.fpinjava.common.List;
import org.junit.Assert;
import org.junit.Test;

import static com.fpinjava.advancedtrees.exercise11_05.Heap.empty;


public class HeapTest {

  @Test
  public void testAdd() throws Exception {
    List<Integer> list = List.list(1, 2, 3, 4, 5, 6, 7);
    Heap<Integer> queue = list.foldLeft(Heap.<Integer>empty(), h -> h::add);
    queue.head().map(a -> a == 1).forEachOrThrow(Assert::assertTrue);
  }

  @Test
  public void testAdd2() throws Exception {
    List<Integer> list = List.list(7, 3, 1, 6, 4, 6, 2);
    Heap<Integer> queue = list.foldLeft(Heap.<Integer>empty(), h -> h::add);
    queue.head().map(a -> a == 1).forEachOrThrow(Assert::assertTrue);
  }

  @Test
  public void addTwoElements() {
    //this was just for debuggability and evaluation
    Heap.<Integer>empty().add(0).add(1);
  }
}
