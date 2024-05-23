package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import org.junit.Test;

public class Lecture6 {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;
  final Predicate<Integer> moreThan = x -> x > 4;

  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Predicate<Integer> moreThan = x -> x > 4;
    Integer integer = Arrays.stream(numbers)
        .filter(moreThan)
        .findAny()
        .orElse(-100);

    System.out.println(integer);
  }

  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer x = Arrays.stream(numbers)
        .filter(numbersLessThan10)
        .findFirst()
        .orElse(0);

    System.out.println(x);
  }
}

