import requestFactory.CommandLineRequestFactory;
import requestFactory.RequestFactory;
import requestReader.RequestReader;
import requestExecutor.RequestExecutor;
import requestValidator.RequestValidator;

public class Application {

    public static void main(String[] args) {
        final String dateFormat = "d.M.yyyy";

        RequestFactory factory = new CommandLineRequestFactory();
        RequestValidator validator = factory.createRequestValidatorBuilder()
                .setServiceNumber(10)
                .setSubserviceNumber(3)
                .setQuestionNumber(10)
                .setQuestionCategoryNumber(20)
                .setQuestionSubcategoryNumber(5)
                .createRequestValidator();

        RequestReader reader = factory.createRequestReader();
        RequestExecutor executor = factory.createRequestExecutor(dateFormat, validator);

        reader.readAndRun(executor);
    }
}
