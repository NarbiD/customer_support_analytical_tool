package requestExecutor;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OutputStreamRequestExecutor implements RequestExecutor {
    final String WAITING_TIMELINE_PREFIX = "C";
    final String QUERY_PREFIX = "D";
    final String EMPTY_OUTPUT = "-";

    final DateTimeFormatter dateFormatter;
    final PrintWriter writer;

    List<WaitingTimelineHandler> items;

    public OutputStreamRequestExecutor(OutputStream outputStream, String dateFormat) {
        this.dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        this.writer = new PrintWriter(outputStream);
        this.items = new ArrayList<>();
    }

    @Override
    public void execute(String request) {
        if (request.startsWith(WAITING_TIMELINE_PREFIX)) {
            items.add(getWaitingTimelineHandler(request));
        } else if (request.startsWith(QUERY_PREFIX)) {
            QueryHandler queryHandler = getQueryHandler(request);
            int result = queryHandler.calcAvgTime(items);
            writer.println(result > 0 ? result : EMPTY_OUTPUT);
            writer.flush();
        } else {
            throw new IllegalArgumentException("Unknown request type");
        }
    }

    private WaitingTimelineHandler getWaitingTimelineHandler(String query) {
        String[] queryParts = query.split(" ");
        String service = queryParts[1];
        String question = queryParts[2];
        String requestType = queryParts[3];
        String date = queryParts[4];
        String time = queryParts[5];

        return new WaitingTimelineHandler(service, question, requestType.charAt(0), LocalDate.parse(date, dateFormatter), Integer.parseInt(time));
    }

    private QueryHandler getQueryHandler(String query) {
        String[] queryParts = query.split(" ");
        String service = queryParts[1];
        String question = queryParts[2];
        String requestType = queryParts[3];
        String[] dates = queryParts[4].split("-");
        LocalDate startDate = LocalDate.parse(dates[0], dateFormatter);
        LocalDate endDate = dates.length==2 ? LocalDate.parse(dates[1], dateFormatter) : null;

        return new QueryHandler(service, question, requestType.charAt(0), startDate, endDate);
    }
}
