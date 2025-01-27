package dependency.injection;

import com.google.inject.AbstractModule;

public class MessageModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(MessageService.class).to(EmailService.class);
  }
}
