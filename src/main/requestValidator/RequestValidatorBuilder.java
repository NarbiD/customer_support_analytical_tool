package requestValidator;

public class RequestValidatorBuilder {
    private int serviceNumber;
    private int subserviceNumber;
    private int questionNumber;
    private int questionCategoryNumber;
    private int questionSubcategoryNumber;

    public RequestValidatorBuilder setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
        return this;
    }

    public RequestValidatorBuilder setSubserviceNumber(int subserviceNumber) {
        this.subserviceNumber = subserviceNumber;
        return this;
    }

    public RequestValidatorBuilder setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
        return this;
    }

    public RequestValidatorBuilder setQuestionCategoryNumber(int questionCategoryNumber) {
        this.questionCategoryNumber = questionCategoryNumber;
        return this;
    }

    public RequestValidatorBuilder setQuestionSubcategoryNumber(int questionSubcategoryNumber) {
        this.questionSubcategoryNumber = questionSubcategoryNumber;
        return this;
    }

    public RequestValidator createRequestValidator() {
        return new RequestValidatorImpl(serviceNumber, subserviceNumber, questionNumber, questionCategoryNumber, questionSubcategoryNumber);
    }
}