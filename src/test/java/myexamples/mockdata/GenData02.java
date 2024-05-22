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

public class GenData02 {

  public static ImmutableList<Car> getCars() throws IOException {
    String fileName = "CarModels.json";
    ClassLoader cl = GenData02.class.getClassLoader();
    InputStream input = cl.getResourceAsStream(fileName);
    assert input != null;
    String json = IOUtils.toString(input, Charset.defaultCharset());
    Type listType = new TypeToken<ArrayList<Car>>() {
    }.getType();
    List<Car> cars = new Gson().fromJson(json, listType);
    return ImmutableList.copyOf(cars);
  }
}
