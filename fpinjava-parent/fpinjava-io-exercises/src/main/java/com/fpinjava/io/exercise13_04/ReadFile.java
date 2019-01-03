package com.fpinjava.io.exercise13_04;


import com.fpinjava.common.List;
import com.fpinjava.common.Result;
import com.fpinjava.common.Stream;

import java.io.File;

public class ReadFile {

  // adjust the path variable as needed
  private static String path = "data.txt";

  public static void main(String... args) {
    String path = System.getProperty("user.dir") + "/fpinjava-io-exercises/src/main/java/com/fpinjava/io/exercise13_04/" + ReadFile.path; // just make it work
    Result<Input> rReader = FileReader.fileReader(path);
    Result<List<Person>> rPeople = rReader.map(input -> Stream.unfold(input, ReadConsole::person).toList()); // using the method from ReadConsole... same thing
    rPeople.forEach(l -> l.forEach(System.out::println));
  }
}
