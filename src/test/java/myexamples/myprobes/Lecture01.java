package myexamples.myprobes;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import myexamples.beans.Car;
import myexamples.mockdata.GenData01;
import myexamples.mockdata.GenData02;
import myexamples.mockdata.GenerateData;
import org.junit.Test;

public class Lecture01 {

  @Test
  public void printAllCars() throws IOException {
//    ImmutableList<Car> cars = GenerateData.getCars();
//    ImmutableList<Car> cars = GenData01.getCars();
    ImmutableList<Car> cars = GenData02.getCars();
    cars.stream().skip(40).limit(5).forEach(System.out::println);
  }
}
