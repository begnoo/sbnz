package domb.app.model.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;

import domb.app.model.BaseEntity;

@Entity
public class Failure extends BaseEntity {

    @Column
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
