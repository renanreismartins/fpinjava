package com.fpinjava.state.exercise12_02;


import com.fpinjava.common.List;
import com.fpinjava.common.Tuple;

import static com.fpinjava.common.CollectionUtilities.list;

public class Generator {

  public static Tuple<Integer, RNG> integer(RNG rng) {
    return rng.nextInt();
  }

  public static Tuple<Integer, RNG> integer(RNG rng, int limit) {
    Tuple<Integer, RNG> random = rng.nextInt();
    return new Tuple<>(Math.abs(random._1 % limit), random._2);
  }

  public static Tuple<List<Integer>, RNG> integers(RNG rng, int length) {
    //List<Integer> range = List.range(0, length);


    return new Tuple<>(List.list(), rng);

    // length 1
    //Tuple<Integer, RNG> t = rng.nextInt();
    //return new Tuple<>(List.list(t._1), t._2);
  }
}
