package domb.app.model.facts;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import domb.app.model.BaseEntity;

@Entity
@SQLDelete(sql = "UPDATE question SET active = false WHERE id = ?")
@Where(clause = "active = true")
public class Question extends BaseEntity {

    @Column
    private String question;
    
    @OneToMany
    private List<Answer> answers;

    public Question() {
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

}