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
    Result<Tuple<String, Input>> rFirstName = input.readString("First Name:");
    Result<Tuple<String, Input>> rLastName = input.readString("Last Name:");

    return rId.flatMap(tId -> rFirstName.flatMap(tFirstName ->
                                                         rLastName.flatMap(tLastName ->
                                                                                   Result.success(new Tuple<>(Person.apply(tId._1, tFirstName._1, tLastName._1), tLastName._2)))));

  }
}
