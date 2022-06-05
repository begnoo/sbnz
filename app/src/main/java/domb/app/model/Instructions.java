package domb.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import domb.app.model.enums.PartEnum;

@Entity
@SQLDelete(sql = "UPDATE instructions SET active = false WHERE id = ?")
@Where(clause = "active = true")
public class Instructions extends BaseEntity {

    @Column
    private String instructions;
    
    @Enumerated(EnumType.STRING)
    @Column
    private PartEnum part;
    // private CauseEnum cause;

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public PartEnum getPart() {
        return this.part;
    }

    public void setPart(PartEnum part) {
        this.part = part;
    }

}
