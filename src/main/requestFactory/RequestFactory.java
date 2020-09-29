package requestFactory;

import requestExecutor.RequestExecutor;
import requestReader.RequestReader;

public interface RequestFactory {
    RequestReader createRequestReader();
    RequestExecutor createRequestExecutor(String dateFormat);
}
