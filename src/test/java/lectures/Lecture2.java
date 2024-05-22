package lectures;

import beans.Person;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {
    IntPredicate even = x -> x % 3 == 0;
    IntStream.range(1, 11).filter(even).forEach(System.out::println);

  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
    IntStream.range(0, people.size())
        .forEach(index -> {
          Person person = people.get(index);
          System.out.println(person);
        });
  }

  @Test
  public void intStreamIterate() throws Exception {
    IntStream.iterate(0, operand -> operand + 1)
        .filter(number -> number % 2 == 0)
        .limit(20)
        .forEach(System.out::println);
  }
}
