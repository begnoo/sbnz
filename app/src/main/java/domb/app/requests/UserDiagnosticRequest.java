package domb.app.requests;

import java.util.List;

import domb.app.model.statuses.FeelEnum;
import domb.app.model.statuses.LookEnum;
import domb.app.model.statuses.NotWorkingEnum;
import domb.app.model.statuses.SmellEnum;
import domb.app.model.statuses.SoundEnum;

public class UserDiagnosticRequest {
    
    private List<SoundEnum> sound;
    private List<LookEnum> look;
    private List<SmellEnum> smell;
    private List<FeelEnum> feel;
    private List<NotWorkingEnum> notWorking;

    public List<SoundEnum> getSound() {
        return this.sound;
    }

    public void setSound(List<SoundEnum> sound) {
        this.sound = sound;
    }

    public List<LookEnum> getLook() {
        return this.look;
    }

    public void setLook(List<LookEnum> look) {
        this.look = look;
    }

    public List<SmellEnum> getSmell() {
        return this.smell;
    }

    public void setSmell(List<SmellEnum> smell) {
        this.smell = smell;
    }

    public List<FeelEnum> getFeel() {
        return this.feel;
    }

    public void setFeel(List<FeelEnum> feel) {
        this.feel = feel;
    }

    public List<NotWorkingEnum> getNotWorking() {
        return this.notWorking;
    }

    public void setNotWorking(List<NotWorkingEnum> notWorking) {
        this.notWorking = notWorking;
    }
}