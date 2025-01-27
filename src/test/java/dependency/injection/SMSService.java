package dependency.injection;

public class SMSService implements MessageService {

  @Override
  public String getMessage() {
    return "SMS message";
  }
}
