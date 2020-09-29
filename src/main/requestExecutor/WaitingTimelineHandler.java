package requestExecutor;

import java.time.LocalDate;

public class WaitingTimelineHandler {
    private final String service;
    private final String question;
    private final char responseType;
    private final LocalDate date;
    private final int time;

    public String getService() {
        return service;
    }

    public String getQuestion() {
        return question;
    }

    public char getResponseType() {
        return responseType;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public WaitingTimelineHandler(String service, String question, char responseType, LocalDate date, int time) {
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.date = date;
        this.time = time;
    }
}
