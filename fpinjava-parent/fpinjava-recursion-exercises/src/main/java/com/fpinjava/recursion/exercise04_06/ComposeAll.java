package com.fpinjava.recursion.exercise04_06;

import java.util.List;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.Function;

import static com.fpinjava.common.CollectionUtilities.head;


public class ComposeAll {

  static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
    // something like this where instead of "head(list)" we could use "function identity"
    //CollectionUtilities.foldLeft(list, head(list), a -> b -> Function.compose(a, b));

    return CollectionUtilities.foldRight(list, Function.identity(), a -> b -> Function.compose(a, b));
  }
}