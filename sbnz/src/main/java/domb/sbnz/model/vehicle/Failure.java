package domb.sbnz.model.vehicle;

import domb.sbnz.model.BaseEntity;

public class Failure extends BaseEntity {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
