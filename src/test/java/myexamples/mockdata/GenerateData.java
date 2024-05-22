package myexamples.mockdata;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import myexamples.beans.Car;
import org.apache.commons.io.IOUtils;

public class GenerateData {

  public static ImmutableList<Car> getCars() throws IOException {
    // 1. File Name
    String fileName = "CarModels.json";

    // 2. Class Loader
    ClassLoader cl = GenerateData.class.getClassLoader();

    // 3. Input stream
    InputStream input = cl.getResourceAsStream(fileName);

    // 4. Creation of String json
    assert input != null;
    String json = IOUtils.toString(input, Charset.defaultCharset());

    // 5. TypeToken
    Type listType = new TypeToken<ArrayList<Car>>() {
    }.getType();

    // 6. returning of ImmutableList
    List<Car> cars = new Gson().fromJson(json, listType);
    return ImmutableList.copyOf(cars);
  }
}
