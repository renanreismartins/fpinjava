package com.fpinjava.state.exercise12_09;


import com.fpinjava.common.Function;
import com.fpinjava.common.List;
import com.fpinjava.common.Tuple;

public class State<S, A> {

  public final Function<S, Tuple<A, S>> run;

  public State(Function<S, Tuple<A, S>> run) {
    super();
    this.run = run;
  }

  public static <S, A> State<S, A> unit(A a) {
    return new State<>(s -> new Tuple<>(a, s));
  }

  public <B> State<S, B> map(Function<A, B> f) {
    return new State<>((S s) -> new Tuple<>(f.apply(run.apply(s)._1), s));
  }

  public <B, C> State<S, C> map2(State<S, B> sb, Function<A, Function<B, C>> f) {
    throw new IllegalStateException("To be implemented");
  }

  public <B> State<S, B> flatMap(Function<A, State<S, B>> f) {
    return new State<>(s -> {
      Tuple<A, S> as = run.apply(s);
      State<S, B> sb = f.apply(as._1);
      return sb.run.apply(as._2);
    });
  }

  public static <S, A> State<S, List<A>> sequence(List<State<S, A>> fs) {
    throw new IllegalStateException("To be implemented");
  }

}