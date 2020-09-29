import requestFactory.CommandLineRequestFactory;
import requestFactory.RequestFactory;
import requestReader.RequestReader;
import requestExecutor.RequestExecutor;

public class Application {

    public static void main(String[] args) {
        final String dateFormat = "d.M.yyyy";

        RequestFactory factory = new CommandLineRequestFactory();
        RequestReader reader = factory.createRequestReader();
        RequestExecutor executor = factory.createRequestExecutor(dateFormat);

        reader.readAndRun(executor);
    }
}
