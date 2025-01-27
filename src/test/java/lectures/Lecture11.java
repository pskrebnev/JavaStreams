package lectures;


import beans.Car;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;



import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");


    StringBuilder sb = new StringBuilder(names.stream()
        .reduce("", String::concat));

    System.out.println(sb.reverse());

    
  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");


    String longName = names.stream()
        .map(n -> n.toUpperCase(Locale.ROOT))
        .collect(Collectors.joining("|"));

    System.out.println(longName);
  }

  @Test
  public void groupCarByColor() throws IOException {
    MockData.getCars().stream()
        .collect(Collectors.groupingBy(Car::getColor))
        .forEach((color, cars) -> {
          System.out.println("<--->");
          System.out.println(color);
          cars.stream()
              .limit(2)
              .forEach(System.out::println);
        });



  }
}
