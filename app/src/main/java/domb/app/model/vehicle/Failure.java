package domb.app.model.vehicle;

import domb.app.model.BaseEntity;

public class Failure extends BaseEntity {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
