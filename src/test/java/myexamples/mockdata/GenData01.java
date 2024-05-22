package myexamples.mockdata;

import com.google.common.collect.ImmutableList;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import myexamples.beans.Car;
import org.apache.commons.io.IOUtils;

public class GenData01 {

  public static ImmutableList<Car> getCars() throws IOException {
    // 1. File name
    String fileName = "CarModels.json";

    // 2. Class Loader
    ClassLoader cl = GenData01.class.getClassLoader();

    // 3. Input
    InputStream is = cl.getResourceAsStream(fileName);

    // 4. Creation of String JSON
    assert is != null;
    String json = IOUtils.toString(is, Charset.defaultCharset());

    // 5. TypeToken
    Type listType = new TypeToken<ArrayList<Car>>() {
    }.getType();

    // 6. returning of ImmutableList
    List<Car> cars = new Gson().fromJson(json, listType);
    return ImmutableList.copyOf(cars);
  }
}
