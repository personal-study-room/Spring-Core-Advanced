package hello.springadvanced.trace.strategy;


import hello.springadvanced.trace.strategy.code.strategy.ContextV2;
import hello.springadvanced.trace.strategy.code.strategy.Strategy;
import hello.springadvanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.springadvanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

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

  @Test
  void strategy1() {
    StrategyLogic1 strategyLogic1 = new StrategyLogic1();
    ContextV2 context1 = new ContextV2();
    context1.execute(strategyLogic1);

    StrategyLogic2 strategyLogic2 = new StrategyLogic2();
    ContextV2 context2 = new ContextV2();
    context2.execute(strategyLogic2);
  }

  @Test
  void strategy2() {
    ContextV2 context1 = new ContextV2();
    Strategy strategy1 = new Strategy() {
      @Override
      public void call() {
        log.info("business logic 1");
      }
    };

    log.info("strategy1={}", strategy1.getClass());
    context1.execute(strategy1);



    ContextV2 context2 = new ContextV2();
    Strategy strategy2 = new Strategy() {
      @Override
      public void call() {
        log.info("business logic 2");
      }
    };

    log.info("strategy1={}", strategy2.getClass());
    context2.execute(strategy2);
  }


  @Test
  void strategy3() {
    ContextV2 context1 = new ContextV2();
    context1.execute(() -> log.info("logic 1"));

    ContextV2 context2 = new ContextV2();
    context2.execute(() -> log.info("logic 2"));
  }

}
