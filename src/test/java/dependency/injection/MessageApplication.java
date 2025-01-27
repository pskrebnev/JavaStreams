package dependency.injection;

import com.google.inject.Inject;

public class MessageApplication {
  private final MessageService service;

  @Inject
  public MessageApplication(MessageService service) {
    this.service = service;
  }

  public void sendMessage(String message, String receiver) {
    System.out.println("Message sent to " + service.getMessage() + " with message="
        + message + " and receiver=" + receiver);
  }

}
