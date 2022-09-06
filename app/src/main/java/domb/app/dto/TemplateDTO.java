package domb.app.dto;

public class TemplateDTO {
    private Long questionId;
    private String answerValue;
    private String part;

    public TemplateDTO(Long questionId, String answerValue, String part) {
        this.questionId = questionId;
        this.answerValue = answerValue;
        this.part = part;
    }

    public TemplateDTO() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}
