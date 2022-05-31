package domb.app.model.facts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import domb.app.model.BaseEntity;

@Entity
@SQLDelete(sql = "UPDATE answer SET active = false WHERE id = ?")
@Where(clause = "active = true")
public class Answer extends BaseEntity {

    @Column
    private String answerText;
    
    @ManyToOne
    private Question followUpQuestion;


    public Answer() {
    }

    public String getAnswerText() {
        return this.answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Question getFollowUpQuestion() {
        return this.followUpQuestion;
    }

    public void setFollowUpQuestion(Question followUpQuestion) {
        this.followUpQuestion = followUpQuestion;
    }

}
