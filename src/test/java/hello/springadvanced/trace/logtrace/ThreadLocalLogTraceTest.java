package hello.springadvanced.trace.logtrace;

import hello.springadvanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

  ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

  @Test
  void begin_end_level2() {
    TraceStatus status1 = trace.begin("hello1");
    TraceStatus status2 = trace.begin("hello2");
    trace.exception(status2, new Exception());
    trace.exception(status1, new Exception());

  }
}