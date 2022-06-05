package domb.app.responses;

import domb.app.model.enums.PartEnum;

public class InstructionsResponse {
    
    private PartEnum part;
    private String instructions;

    public PartEnum getPart() {
        return this.part;
    }

    public void setPart(PartEnum part) {
        this.part = part;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(String instuctions) {
        this.instructions = instuctions;
    }

}
