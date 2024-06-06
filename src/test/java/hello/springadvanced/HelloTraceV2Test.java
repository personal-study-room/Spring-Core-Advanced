package hello.springadvanced;

import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.hellotrace.HelloTraceV2;
import org.junit.jupiter.api.Test;

public class HelloTraceV2Test {

  @Test
  void begin_end() {
    HelloTraceV2 trace = new HelloTraceV2();
    TraceStatus status = trace.begin("hello");
    TraceStatus status2 = trace.beginSync(status.getTraceId(), "hello2");
    trace.end(status2);
    trace.end(status);
  }

  @Test
  void begin_exception() {
    HelloTraceV2 trace = new HelloTraceV2();
    TraceStatus status = trace.begin("ex2");
    TraceStatus status2 = trace.beginSync(status.getTraceId(), "ex2");
    trace.exception(status2, new IllegalArgumentException());
    trace.exception(status, new IllegalArgumentException());
  }
}
