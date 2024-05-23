package lectures;

import beans.Person;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {

  @Test
  public void understandingCollect() throws Exception {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(Collectors.toList());

    emails.forEach(System.out::println);
  }

  @Test
  public void getCollectionParam() throws IOException {
    ArrayList<String> emails = MockData.getPeople().stream()
        .map(Person::getEmail)
        .collect(ArrayList::new,
            ArrayList::add,
            ArrayList::addAll);

    emails.forEach(System.out::println);
  }

  @Test
  public void getCollectionSimpl() throws IOException {
    List<String> emailList = MockData.getPeople().stream()
        .map(Person::getEmail)
        .collect(Collectors.toList());

    emailList.forEach(System.out::println);
  }

  @Test
  public void compare() {
    long start = System.currentTimeMillis();

    List<String> list1 = Arrays.asList("1", "2", "3", "4");
    List<String> list2 = Arrays.asList("1", "4", "5", "6");

// Remove duplicates from both lists
    Set<String> uniqueElements = new HashSet<>();
    uniqueElements.addAll(list1);
    uniqueElements.addAll(list2);

// Combine the unique elements into a single list
    List<String> combinedList = new ArrayList<>(uniqueElements);

// Print the combined list
    combinedList.forEach(System.out::println);
    System.out.println(System.currentTimeMillis() - start + " ms");
  }
}
