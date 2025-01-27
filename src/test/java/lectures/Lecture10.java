package lectures;


import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class Lecture10 {

  private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
      Lists.newArrayList("Mariam", "Alex", "Ismail"),
      Lists.newArrayList("John", "Alesha", "Andre"),
      Lists.newArrayList("Susy", "Ali")

  );

  @Before
  public void setUp() {
    System.out.println(arrayListOfNames);
  }

  @Test
  public void withoutFlatMap() throws Exception {

    long start = System.currentTimeMillis();
//    [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
    List<String> newNames = new ArrayList<>();
    arrayListOfNames.forEach(newNames::addAll);
    System.out.println(newNames);
    System.out.println(System.currentTimeMillis() - start + "ms");

//    [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]

    List<String> names = Lists.newArrayList();

    for (List<String> listOfNames : arrayListOfNames) {
      for (String name : listOfNames) {
        names.add(name);
      }
    }

    System.out.println(names);
  }

  @Test
  public void withFlatMap() throws Exception {

    long start = System.currentTimeMillis();
//   [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
    List<String> names = arrayListOfNames.stream()
        .flatMap(Collection::stream)
        .collect(Collectors.toList());

    System.out.println(names);
    System.out.println(System.currentTimeMillis() - start + "ms");
  }
}

