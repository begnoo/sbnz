package domb.app.dto;

public class AddQuestionDTO {
    private String questionText;
    private Long answerId;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public AddQuestionDTO() {
    }

    public AddQuestionDTO(String questionText, Long answerId) {
        this.questionText = questionText;
        this.answerId = answerId;
    }
}
