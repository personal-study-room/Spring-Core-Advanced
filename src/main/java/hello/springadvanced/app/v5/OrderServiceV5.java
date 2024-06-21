package hello.springadvanced.app.v5;


import hello.springadvanced.trace.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

  private final OrderRepositoryV5 orderRepository;
  private final TraceTemplate traceTemplate;

  public void orderItem(String itemId) {
    traceTemplate.execute("OrderServiceV5.orderItem()", () -> {
      orderRepository.save(itemId);
      return null;
    });
  }
}
