package requestFactory;

import requestExecutor.RequestExecutor;
import requestExecutor.OutputStreamRequestExecutor;
import requestReader.RequestReader;
import requestReader.InputStreamRequestReader;

public class CommandLineRequestFactory implements RequestFactory {

    @Override
    public RequestReader createRequestReader() {
        return null; // todo new InputStreamRequestReader(System.in);
    }

    @Override
    public RequestExecutor createRequestExecutor(String dateFormat) {
        return null; // todo new OutputStreamRequestExecutor(System.out, dateFormat);
    }
}
