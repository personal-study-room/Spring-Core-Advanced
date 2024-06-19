package hello.springadvanced.trace.strategy.code.strategy;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * 필드에 전략을 보관하는 방식
 */
@Slf4j
@AllArgsConstructor
public class ContextV1 {

  private Strategy strategy;

  public void execute() {
    long startTime = System.currentTimeMillis();
    //비지니스 로직 실행
    strategy.call(); // 주입받고 해당 구현체는 선택 가능.
    // 비지니스 로직 종료
    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime={}", resultTime);
  }
}
