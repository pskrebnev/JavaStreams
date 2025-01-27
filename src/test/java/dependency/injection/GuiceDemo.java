package dependency.injection;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceDemo {
  public static void main(String[] args) {
    // Create an injector
    Injector injector = Guice.createInjector(new MessageModule());

    // Get the TextEditor instance
    MessageApplication app = injector.getInstance(MessageApplication.class);

    // Call the spellCheck method
    app.sendMessage("Hi", "Email");
  }
}
