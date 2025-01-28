package lectures;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, -23, 93, 99);

    System.out.println(numbers.stream()
        .min(Comparator.naturalOrder())
        .orElse(Integer.MAX_VALUE));
  }

  @Test
  public void max() {
    final List<Integer> numbers = ImmutableList.of(1, 2, 1473, 100, 23, 93, 99);

    System.out.println(numbers.stream()
        .max(Comparator.naturalOrder())
        .orElse(Integer.MIN_VALUE));
  }
}