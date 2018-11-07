package com.fpinjava.optionaldata.exercise06_07;


import com.fpinjava.common.Function;
import com.fpinjava.common.List;
import com.fpinjava.optionaldata.exercise06_06.Option;


public class Variance {

    static Function<List<Double>, Double> sum =
            ds -> ds.foldLeft(0.0, a -> b -> a + b);

    static Function<List<Double>, Option<Double>> mean =
            ds -> ds.isEmpty()
                    ? Option.none()
                    : Option.some(sum.apply(ds) / ds.length());

    // 1st version - step by step
//  static Function<List<Double>, Option<Double>> variance = new Function<List<Double>, Option<Double>>() {
//    @Override
//    public Option<Double> apply(List<Double> l) {
//      Option<Double> maybeValuesMean = Variance.mean.apply(l);
//      Option<List<Double>> maybeValuesVariance = maybeValuesMean.map(m -> l.map(x -> Math.pow(x - m, 2)));
//      Option<Double> variance = maybeValuesVariance.flatMap(valuesVariance -> mean.apply(valuesVariance));
//
//      return variance;
//    }
//  };

    // let intellij do it's job
    static Function<List<Double>, Option<Double>> variance = l -> mean.apply(l)
                                                                      .map(m -> l.map(x -> Math.pow(x - m, 2)))
                                                                      .flatMap(valuesVariance -> mean.apply(valuesVariance));
}

