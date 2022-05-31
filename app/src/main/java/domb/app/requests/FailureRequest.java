package domb.app.requests;

public class FailureRequest {
    
    private long questionId;
    private String answerValue;


    public long getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }


    public String getAnswerValue() {
        return this.answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }
    

}