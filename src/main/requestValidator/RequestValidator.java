package requestValidator;

public interface RequestValidator {
    boolean validateServices(String service);
    boolean validateQuestions(String service);
}
