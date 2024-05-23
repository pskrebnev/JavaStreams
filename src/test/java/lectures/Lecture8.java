package lectures;


import beans.Car;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {
    Map<String, List<Car>> groupedByProducers = MockData.getCars().stream()
        .collect(Collectors.groupingBy(Car::getMake));

    groupedByProducers.forEach((producer, listCars) -> {
      System.out.println(producer);
      listCars.stream()
          .limit(3)
          .forEach(System.out::println);
      System.out.println("\n");
    });
  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Vincent",
            "Alex",
            "Mohammado",
            "Vincent",
            "Alex",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex",
            "Alex"
        );

   names.stream()
       .collect(Collectors.groupingBy(
           Function.identity(),
           Collectors.counting()
       ))
       .entrySet().stream()
       .sorted(Map.Entry.comparingByKey())
       .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

    System.out.println("---");

   names.stream()
       .collect(Collectors.groupingBy(
           Function.identity(),
           Collectors.counting()
       ))
       .entrySet().stream()
       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
       .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
  }
}