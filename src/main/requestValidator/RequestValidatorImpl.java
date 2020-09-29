package requestValidator;

public class RequestValidatorImpl implements RequestValidator{

    int serviceNumber;
    int subserviceNumber;
    int questionNumber;
    int questionCategoryNumber;
    int questionSubcategoryNumber;

    public RequestValidatorImpl(int serviceNumber, int subserviceNumber, int questionNumber, int questionCategoryNumber, int questionSubcategoryNumber) {
        this.serviceNumber = serviceNumber;
        this.subserviceNumber = subserviceNumber;
        this.questionNumber = questionNumber;
        this.questionCategoryNumber = questionCategoryNumber;
        this.questionSubcategoryNumber = questionSubcategoryNumber;
    }

    @Override
    public boolean validateServices(String service) {
        String[] services = service.split("\\.");
        return services[0].equals("*") ||
                serviceNumber > 0 && Integer.parseInt(services[0]) <= serviceNumber &&
                subserviceNumber > 0 && (services.length != 2 || Integer.parseInt(services[1]) <= subserviceNumber);
    }

    @Override
    public boolean validateQuestions(String question) {
        String[] questions = question.split("\\.");
        return questions[0].equals("*") ||
                questionNumber > 0 && Integer.parseInt(questions[0]) <= questionNumber &&
                questionCategoryNumber > 0 && (questions.length < 2 || Integer.parseInt(questions[1]) <= questionCategoryNumber) &&
                questionSubcategoryNumber > 0 && (questions.length < 3 || Integer.parseInt(questions[2]) <= questionSubcategoryNumber);
    }

}
