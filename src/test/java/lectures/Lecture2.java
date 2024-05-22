package lectures;

import beans.Person;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  IntPredicate by3 = x -> x % 3 == 0;

  @Test
  public void range() throws Exception {
    IntStream.range(1, 11).filter(by3).forEach(System.out::println);
  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
    IntStream.range(0, people.size()).forEach(index -> {
      Person person = people.get(index);
      System.out.println(person);
    });
  }

  @Test
  public void intStreamIterate() throws Exception {
    IntStream.iterate(0, x -> x + 1)
        .filter(by3)
        .limit(10)
        .forEach(System.out::println);
  }
}
