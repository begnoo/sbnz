package domb.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE instructions SET active = false WHERE id = ?")
@Where(clause = "active = true")
public class Instructions extends BaseEntity {

    @Column
    private String instructions;
    
    @Column
    private String part;
    // private CauseEnum cause;


    public Instructions() {
    }

    public Instructions(String instructions, String part) {
        this.instructions = instructions;
        this.part = part;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPart() {
        return this.part;
    }

    public void setPart(String part) {
        this.part = part;
    }

}
