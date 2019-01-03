package com.fpinjava.io.exercise13_03;


import com.fpinjava.common.Result;
import com.fpinjava.common.Stream;
import com.fpinjava.common.Tuple;

public class ReadConsole {

  public static void main(String... args) {
    Stream<Person> stream = Stream.unfold(ConsoleReader.consoleReader(), ReadConsole::person);
    stream.toList().forEach(System.out::println);
  }

  public static Result<Tuple<Person, Input>> person(Input input) {
    Result<Tuple<Integer, Input>> rId = input.readInt("Id:");

    return rId.flatMap(tId -> tId._2.readString("First Name:")
                                    .flatMap(tFirstName ->
                                                         tFirstName._2.readString("Last Name:")
                                                                      .flatMap(tLastName ->
                                                                                   Result.success(new Tuple<>(Person.apply(tId._1, tFirstName._1, tLastName._1), tLastName._2)))));

  }
}
