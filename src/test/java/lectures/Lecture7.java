package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {


  Predicate<Car> carColor = car -> car.getColor().equals("Blue");

  @Test
  public void count() throws Exception {
    Long qty = MockData.getCars().stream()
        .filter(carColor)
        .count();

    System.out.println(qty);

  }

  @Test
  public void min() throws Exception {

    Car car = MockData.getCars().stream()
        .min(Comparator.comparing(Car::getPrice))
        .get();

    System.out.println(car);

  }

  @Test
  public void max() throws Exception {

    Predicate<Car> isYellow = car -> car.getColor().equalsIgnoreCase("yellow");

    double yellowPrice = MockData.getCars().stream()
        .filter(isYellow)
        .mapToDouble(Car::getPrice)
        .max()
        .orElse(0.00);

    System.out.println(yellowPrice);

  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();

    OptionalDouble average = cars.stream()
        .mapToDouble(Car::getPrice)
        .average();

    System.out.println(average.getAsDouble());

  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
  }

}