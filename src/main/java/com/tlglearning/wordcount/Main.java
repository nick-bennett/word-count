package com.tlglearning.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

  private static final String TEST_FILE_NAME = "hound-of-the-baskervilles.txt";

  public static void main(String[] args) throws IOException {
    try (
        InputStream input = Main.class.getClassLoader().getResourceAsStream(TEST_FILE_NAME);
        Reader reader = new InputStreamReader(input);
        BufferedReader buffer = new BufferedReader(reader)
    ) {
      WordCounter counter = new WordCounter();
      String line;
      while ((line = buffer.readLine()) != null) {
        // TODO Pass line to a method of WordCounter.
        counter.add(line);
      }

      counter
          .getCounts()
          .entrySet()
          .stream()
          .sorted(Comparator.comparing(Entry<String, Integer>::getValue).reversed())
          .limit(10)
          .forEach(System.out::println);
    }
  }

}
