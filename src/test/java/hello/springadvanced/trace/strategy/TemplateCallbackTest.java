package hello.springadvanced.trace.strategy;

import hello.springadvanced.trace.strategy.code.template.Callback;
import hello.springadvanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

  @Test
  void callback1() {
    TimeLogTemplate timeLogTemplate1 = new TimeLogTemplate();
    timeLogTemplate1.execute(new Callback() {
      @Override
      public void call() {
        log.info("logic1");

      }
    });

    TimeLogTemplate timeLogTemplate2 = new TimeLogTemplate();
    timeLogTemplate2.execute(new Callback() {
      @Override
      public void call() {
        log.info("logic1");

      }
    });
  }

  @Test
  void callback2WithLambda() {
    TimeLogTemplate timeLogTemplate1 = new TimeLogTemplate();
    timeLogTemplate1.execute(() -> log.info("logic1"));

    TimeLogTemplate timeLogTemplate2 = new TimeLogTemplate();
    timeLogTemplate2.execute(() -> log.info("logic1"));
  }
}
