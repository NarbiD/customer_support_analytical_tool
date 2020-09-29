package requestFactory;

import requestExecutor.RequestExecutor;
import requestExecutor.OutputStreamRequestExecutor;
import requestReader.RequestReader;
import requestReader.InputStreamRequestReader;
import requestValidator.RequestValidator;
import requestValidator.RequestValidatorBuilder;

public class CommandLineRequestFactory implements RequestFactory {

    @Override
    public RequestReader createRequestReader() {
        return new InputStreamRequestReader(System.in);
    }

    @Override
    public RequestExecutor createRequestExecutor(String dateFormat, RequestValidator validator) {
        return new OutputStreamRequestExecutor(System.out, dateFormat, validator);
    }

    @Override
    public RequestValidatorBuilder createRequestValidatorBuilder() {
        return new RequestValidatorBuilder();
    }
}
