package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    final Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

    List<Car> carsFiltered = cars.stream()
        .filter(carPredicate)
        .collect(Collectors.toList());

    carsFiltered.forEach(System.out::println);
    System.out.println(carsFiltered.size());
  }


  @Test
  public void getCarsWithSetProducers() throws IOException {
    ImmutableList<Car> cars = MockData.getCars();
    Predicate<Car> setProducers = car -> car.getMake().equals("Toyota")
        || car.getMake().equals("Ford");
    Predicate<Car> issueYear = car -> car.getYear() > 2010;

    cars.stream()
        .filter(setProducers)
        .filter(issueYear)
        .limit(20)
        .forEach(System.out::println);
  }



  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    Function<Person, PersonDTO> personDTOFunction = person -> new PersonDTO(person.getId(),
        person.getFirstName(), person.getAge());

    List<PersonDTO> dtos = people.stream()
        .map(personDTOFunction)
        .collect(Collectors.toList());

    dtos.stream()
        .skip(100)
        .limit(5)
        .forEach(System.out::println);

    assertThat(dtos).hasSize(1000);
    System.out.println(dtos.size());

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    double average = MockData.getCars()
        .stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);
    System.out.println(average);
  }

  @Test
  public void test() throws Exception {
    MockData.getCars().forEach(System.out::println);
  }
}



