package requestFactory;

import requestExecutor.RequestExecutor;
import requestExecutor.OutputStreamRequestExecutor;
import requestReader.RequestReader;
import requestReader.InputStreamRequestReader;

public class CommandLineRequestFactory implements RequestFactory {

    @Override
    public RequestReader createRequestReader() {
        return new InputStreamRequestReader(System.in);
    }

    @Override
    public RequestExecutor createRequestExecutor(String dateFormat) {
        return new OutputStreamRequestExecutor(System.out, dateFormat);
    }
}
