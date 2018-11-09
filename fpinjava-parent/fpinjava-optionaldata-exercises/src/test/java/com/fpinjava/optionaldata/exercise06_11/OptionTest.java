package com.fpinjava.optionaldata.exercise06_11;

import com.fpinjava.common.Function;
import com.fpinjava.common.List;
import org.junit.Test;

import static com.fpinjava.common.List.list;
import static com.fpinjava.optionaldata.exercise06_11.Option.some;
import static org.junit.Assert.assertEquals;

public class OptionTest {

  private static Function<Integer, Function<String, Integer>> parseWithRadix = radix -> string -> Integer.parseInt(string, radix);

  @Test
  public void testSequence() {
    Function<String, Option<Integer>> parse16 = Option.hlift(parseWithRadix.apply(16));
    List<String> list = list("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    assertEquals("Some([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, NIL])", Option.sequence(list.map(parse16)).toString());
  }

  @Test
  public void testSequenceError() {
    Function<String, Option<Integer>> parse8 = Option.hlift(parseWithRadix.apply(8));
    List<String> list = list("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    assertEquals("None", Option.sequence(list.map(parse8)).toString());
  }

  public static <A> Option<List<A>> sequence2(List<Option<A>> list) {
    return list.isEmpty()
            ? some(list())
            : list.head()
                  .flatMap(hh -> sequence2(list.tail()).map(x -> x.cons(hh)));
  }

  @Test
  public void myTest1() {
    Option.sequence(list());
    some(list());

    Option.sequence(list(some(1)));
    some(1).flatMap(hh -> some(list()).map(x -> x.cons(hh)));
    some(1).flatMap(hh -> some(list().cons(hh)));
    some(1).flatMap(hh -> some(list(1)));
    some(list(1));

    Option.sequence(list(some(1), some(1)));
    some(1).flatMap(hh -> (some(2).flatMap(hh2 -> some(list()).map(y -> y.cons(hh2)))).map(x -> x.cons(hh)));
    some(1).flatMap(hh -> (some(2).flatMap(hh2 -> some(list()).map(y -> list().cons(2)))).map(x -> x.cons(hh)));
    some(1).flatMap(hh -> (some(2).flatMap(hh2 -> some(list()).map(y -> list(2)))).map(x -> x.cons(hh)));
    some(1).flatMap(hh -> some(list(2)).map(x -> x.cons(hh)));
    some(1).flatMap(hh -> some(list(2)).map(x -> list(2).cons(1)));
    some(1).flatMap(hh -> some(list(1, 2)));

  }

  @Test
  public void myTest() {
    Option.sequence(list(some(1), some(1)));


    some(1).flatMap(hh1 -> some(2).flatMap(hh2 -> some(list()).map(x -> x.cons(hh2)).map(y -> y.cons(hh1))));
    some(1).flatMap(hh1 -> some(2).flatMap(hh2 -> some(list()).map(y -> y.cons(2).cons(1))));
    some(1).flatMap(hh1 -> some(2).flatMap(hh2 -> some(list().cons(2).cons(1))));
    some(1).flatMap(hh1 -> some(2).flatMap(hh2 -> some(list(1, 2))));
    some(1).flatMap(hh1 -> some(some(list(1, 2))));
    Option<List<Integer>> some = some(list(1, 2));


  }
}
