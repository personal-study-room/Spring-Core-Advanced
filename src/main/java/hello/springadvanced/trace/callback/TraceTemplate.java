package hello.springadvanced.trace.callback;

import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TraceTemplate {

  private final LogTrace trace;

  public <T> T execute(String message, TraceCallBack<T> callBack) {
    TraceStatus status = null;
    try {
      status = trace.begin(message);

      // 로직호출
      T result = callBack.call();

      trace.end(status);
      return result;

    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
