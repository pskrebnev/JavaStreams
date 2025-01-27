package dependency.injection;

public class EmailService implements MessageService {

  @Override
  public String getMessage() {
    return "Email message";
  }
}
