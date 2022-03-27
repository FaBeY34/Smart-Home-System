import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable {
    private boolean status;
    private Calendar programTime;
    private boolean programAction;

    public SmartPlug(String alias, String macId) {

    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public void turnOn() {

    }

    public void turnOff() {

    }

    public boolean testObject() {

    }

    public boolean shutDownObject() {

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
