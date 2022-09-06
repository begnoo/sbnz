package domb.app.dto;

public class AddAnswerDTO {
    private Long questionId;
    private String answerText;

    public AddAnswerDTO() {
    }

    public AddAnswerDTO(Long questionId, String answerText) {
        this.questionId = questionId;
        this.answerText = answerText;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getAnswerText() {
        return answerText;
    }

}
