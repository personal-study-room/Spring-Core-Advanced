package hello.springadvanced.app.v4;


import hello.springadvanced.trace.logtrace.LogTrace;
import hello.springadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

  private final LogTrace trace;

  public void save(String itemId) {

    AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
      @Override
      protected Void call() {
        if (itemId.equals("ex")) {
          throw new IllegalStateException("예외 발생");
        }
        sleep(1000);
        return null;
      }
    };
    template.execute("OrderRepositoryV4.orderItem()");
  }


  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
