package lectures;


import java.io.IOException;

import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture13 {

  @Test
  public void intermediateAndTerminalOperations() throws Exception {
    System.out.println(
        MockData.getCars()
            .stream()
            .filter(car -> {
              System.out.println("filter car " + car);
              return car.getPrice() < 10000;
            })
            .map(car -> {
              System.out.println("mapping car " + car);
              return car.getPrice();
            })
            .map(price -> {
              System.out.println("mapping price " + price);
              return price + (price * .14);
            })

            .limit(5)
            .collect(Collectors.toList())
    );
  }

  @Test
  public void reducePrice() throws IOException {
    MockData.getCars().stream()
        .map(car -> {
          System.out.println("Previous price: " + car.getPrice());
          System.out.println(car);
          return car.getPrice();
        })
        .map(price -> {
          System.out.println("After decreasing: " + price * 0.9 + "\n");
          return price * 0.9;
        })
        .limit(5)
        .collect(Collectors.toList())
        .forEach(System.out::println);
  }

}
