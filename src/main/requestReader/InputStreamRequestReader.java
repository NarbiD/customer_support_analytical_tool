package requestReader;

import requestExecutor.RequestExecutor;

import java.io.*;

public class InputStreamRequestReader implements RequestReader {
    final InputStream inputStream;

    public InputStreamRequestReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void readAndRun(RequestExecutor executor) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            int count = Integer.parseInt(reader.readLine().trim());
            while (count-->0) {
                String request = reader.readLine();
                executor.execute(request);
            }
        } catch (ClassCastException | IllegalArgumentException e) {
            System.err.println("Wrong request format: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Can not read request" + e.getMessage());
        }
    }
}
