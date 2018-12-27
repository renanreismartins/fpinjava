package com.fpinjava.state.exercise12_05;


import com.fpinjava.common.Function;
import com.fpinjava.common.Tuple;

public interface Random<A> extends Function<RNG, Tuple<A, RNG>> {

  static <A> Random<A> unit(A a) {
    return rng -> new Tuple<>(a, rng);
  }

  static <A, B> Random<B> map(Random<A> s, Function<A, B> f) {
    return rng -> {
      Tuple<A, RNG> t = s.apply(rng);
      return new Tuple<>(f.apply(t._1), t._2);
    };
  }

  static <A, B, C> Random<C> map2(Random<A> ra, Random<B> rb, Function<A, Function<B, C>> f) {
    Random<C> r = rng -> {
      Tuple<A, RNG> a = ra.apply(rng);
      Tuple<B, RNG> b = rb.apply(a._2);
      return new Tuple<>(f.apply(a._1).apply(b._1), b._2);
    };

    return r;
  }

  Random<Integer> intRnd = RNG::nextInt;

  Random<Boolean> booleanRnd = Random.map(intRnd, x -> x % 2 == 0);

  Random<Double> doubleRnd = map(intRnd, x -> x / (((double) Integer.MAX_VALUE) + 1.0));

  Random<Tuple<Integer, Integer>> intPairRnd = map2(intRnd, intRnd, a -> b -> new Tuple<>(a, b)); // To be implemented

}
