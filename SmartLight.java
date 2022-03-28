import java.util.Calendar;

public class SmartLight extends SmartObject implements LocationControl, Programmable {
    private boolean hasLightTurned;
    private Calendar programTime;
    private boolean programAction;

    public SmartLight(String alias, String macId) {
        setAlias(alias);
        setMacId(macId);
    }

    public boolean getHasLightTurned() {
        return this.hasLightTurned;
    }

    public void setHasLightTurned(boolean hasLightTurned) {
        this.hasLightTurned = hasLightTurned;
    }

    public Calendar getProgramTime() {
        return this.programTime;
    }

    public void setProgramTime(Calendar programTime) {
        this.programTime = programTime;
    }

    public boolean getProgramAction() {
        return this.programAction;
    }

    public void setProgramAction(boolean programAction) {
        this.programAction = programAction;
    }

    public void turnOnLight() {
        if (controlConnection()) {
            setHasLightTurned(true);
        }
    }

    public void turnOffLight() {
        if (!controlConnection()) {
            setHasLightTurned(false);
        }
    }

    public boolean testObject() {
        
    }

    public boolean shutDownObject() {

    }

    @Override
    public void onLeave() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onCome() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTimer(int seconds) {
        // TODO Auto-generated method stub

    }

    @Override
    public void cancelTimer() {
        // TODO Auto-generated method stub

    }

    @Override
    public void runProgram() {
        // TODO Auto-generated method stub

    }
}
