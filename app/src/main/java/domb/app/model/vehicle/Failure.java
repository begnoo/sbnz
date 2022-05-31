package domb.app.model.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import domb.app.model.BaseEntity;

@Entity
@SQLDelete(sql = "UPDATE failure SET active = false WHERE id = ?")
@Where(clause = "active = true")
public class Failure extends BaseEntity {

    @Column
    private String type;
    
    @Transient
    private long questionId;
    
    @Transient
    private String answerValue;

    public Failure() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
