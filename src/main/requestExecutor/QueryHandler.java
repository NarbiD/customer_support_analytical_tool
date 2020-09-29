package requestExecutor;

import java.time.LocalDate;
import java.util.List;

public class QueryHandler {
    private final String service;
    private final String question;
    private final char responseType;
    private final LocalDate startLocalDate;
    private final LocalDate endLocalDate;

    public QueryHandler(String service, String question, char responseType, LocalDate startLocalDate, LocalDate endLocalDate) {
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.startLocalDate = startLocalDate;
        this.endLocalDate = endLocalDate;
    }

    public int calcAvgTime(List<WaitingTimelineHandler> queryItems) {
        return queryItems.stream()
                .filter(this::filter)
                .mapToInt(WaitingTimelineHandler::getTime)
                .average().stream()
                .mapToInt(d->(int)d)
                .findFirst()
                .orElse(-1);
    }

    private boolean filter(WaitingTimelineHandler waitingTimeline) {
        return (service.equals("*") || waitingTimeline.getService().startsWith(service)) &&
                (question.equals("*") || waitingTimeline.getQuestion().startsWith(question)) &&
                waitingTimeline.getResponseType() == responseType &&
                (endLocalDate==null ?
                        waitingTimeline.getDate().isEqual(startLocalDate) :
                        waitingTimeline.getDate().isAfter(startLocalDate) &&
                                waitingTimeline.getDate().isBefore(endLocalDate));
    }
}
