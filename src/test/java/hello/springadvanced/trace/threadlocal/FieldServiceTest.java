package hello.springadvanced.trace.threadlocal;


import hello.springadvanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

  private final FieldService fieldService = new FieldService();

  @Test
  void field() {
    log.info("main start");
    Runnable userA = () -> {
      fieldService.logic("userA");
    };

    Runnable userB = () -> {
      fieldService.logic("userB");
    };

    Thread threadA = new Thread(userA);
    threadA.setName("thread-A");

    Thread threadB = new Thread(userB);
    threadB.setName("thread-B");

    threadA.start();
    sleep(2000);  // 동시성 문제 발생 X
    threadB.start();

    sleep(2000); // 메인 쓰레드 종료 대기
    log.info("main exitq");

  }


  @Test
  void field2() {
    log.info("main start");
    Runnable userA = () -> {
      fieldService.logic("userA");
    };

    Runnable userB = () -> {
      fieldService.logic("userB");
    };

    Thread threadA = new Thread(userA);
    threadA.setName("thread-A");

    Thread threadB = new Thread(userB);
    threadB.setName("thread-B");

    threadA.start();
    sleep(100);  // 동시성 문제 발생 O
    threadB.start();

    sleep(2000); // 메인 쓰레드 종료 대기
    log.info("main exitq");


  }


  private void sleep(int mills) {
    try {
      Thread.sleep(mills);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
