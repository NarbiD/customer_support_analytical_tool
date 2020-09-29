package requestFactory;

import requestExecutor.RequestExecutor;
import requestReader.RequestReader;
import requestValidator.RequestValidator;
import requestValidator.RequestValidatorBuilder;

public interface RequestFactory {
    RequestReader createRequestReader();
    RequestExecutor createRequestExecutor(String dateFormat, RequestValidator validator);
    RequestValidatorBuilder createRequestValidatorBuilder();
}
