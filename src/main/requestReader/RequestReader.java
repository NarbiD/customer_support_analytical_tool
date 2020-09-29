package requestReader;

import requestExecutor.RequestExecutor;

public interface RequestReader {
    void readAndRun(RequestExecutor executor);
}
