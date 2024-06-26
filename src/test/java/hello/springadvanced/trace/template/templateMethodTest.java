package hello.springadvanced.trace.template;


import hello.springadvanced.trace.template.code.AbstractTemplate;
import hello.springadvanced.trace.template.code.SubClassLogic1;
import hello.springadvanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class templateMethodTest {

  @Test
  void templateMethodV0() {
    logic1();
    logic2();
  }

  private void logic1() {
    long startTime = System.currentTimeMillis();
    //비지니스 로직 실행
    log.info("비지니스 로직1 실행");
    // 비지니스 로직 종료
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime={}", resultTime);
  }

  private void logic2() {
    long startTime = System.currentTimeMillis();
    //비지니스 로직 실행
    log.info("비지니스 로직2 실행");
    // 비지니스 로직 종료
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime={}", resultTime);
  }

  // template method pattern 적용
  @Test
  void templateMethodV1() {
    AbstractTemplate template1 = new SubClassLogic1();
    template1.execute();

    AbstractTemplate template2 = new SubClassLogic2();
    template2.execute();

  }

  @Test
  void templateMethodV2() {
    AbstractTemplate template1 = new AbstractTemplate() {
      @Override
      protected void call() {
        log.info("logic 1 executed");
      }
    };

    log.info("클래스 이름1={}", template1.getClass());
    template1.execute();


    AbstractTemplate template2 = new AbstractTemplate() {
      @Override
      protected void call() {
        log.info("logic 2 executed");
      }
    };
    log.info("클래스 이름2={}", template2.getClass());
    template2.execute();
  }
}
