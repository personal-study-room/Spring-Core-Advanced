package hello.springadvanced.app.v5;


import hello.springadvanced.trace.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

  private final OrderServiceV5 orderService;
  private final TraceTemplate traceTemplate;

  @GetMapping("/v5/request")
  public String request(@RequestParam("itemId") String itemId) {
    return traceTemplate.execute("OrderControllerV5.request()", () -> {
      orderService.orderItem(itemId);
      return "ok";
    });
  }
}
