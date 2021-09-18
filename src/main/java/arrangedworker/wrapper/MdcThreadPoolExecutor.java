package arrangedworker.wrapper;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;

import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @author dongma
 */
@Slf4j
public class MdcThreadPoolExecutor implements Executor {

    private final Executor executor;

    public MdcThreadPoolExecutor(Executor executor) {
        this.executor = executor;
    }

    public Map<String, String> getThreadContext() {
        return MDC.getCopyOfContextMap();
    }

    private Runnable getMdcRunnable(Runnable runnable, Map<String, String> threadContext) {
        return () -> {
            if (threadContext != null) {
                MDC.put(MdcConstants.TRACE_ID, threadContext.get(MdcConstants.TRACE_ID));
            }
            try {
                runnable.run();
            } catch (Exception e) {
                log.error("MdcThreadPoolExecutor run error =", e);
                throw e;
            } finally {
                MDC.remove(MdcConstants.TRACE_ID);
            }
        };
    }

    @Override
    public void execute(@NonNull Runnable command) {
        executor.execute(getMdcRunnable(command, getThreadContext()));
    }
}
