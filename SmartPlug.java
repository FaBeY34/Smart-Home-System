import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable {
    private boolean status;
    private Calendar programTime;
    private boolean programAction;

    public SmartPlug(String alias, String macId) {
        setAlias(alias);
        setMacId(macId);
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
        if (!getConnectionStatus()) {
            setStatus(true);
            System.out.println(
                    this.getClass().getSimpleName() + " - " + getAlias() + " is turned on now (Current time: "
                            + programTime
                            + ")");
        } else {
            System.out.println(
                    this.getClass().getSimpleName() + " - " + getAlias() + " has been already turned on");
        }
    }

    public void turnOff() {
        if (getConnectionStatus()) {
            setStatus(false);
            System.out
                    .println(this.getClass().getSimpleName() + " - " + getAlias() + "is turned off now (Current time: "
                            + programTime + ")");
        } else {
            System.out.println(this.getClass().getSimpleName() + " - " + getAlias() + "has been already turned off");
        }
    }

    public boolean testObject() {
        if (getConnectionStatus()) {
            SmartObjectToString();
            turnOn();
            turnOff();
            System.out.println("Test completed for " + this.getClass().getSimpleName());
            return true;
        } else {
            return false;
        }

    }

    public boolean shutDownObject() {
        if (getConnectionStatus()) {
            SmartObjectToString();
            turnOff();
        } else {
            return false;
        }
    }

    @Override
    public void setTimer(int seconds) {

    }

    @Override
    public void cancelTimer() {

    }

    @Override
    public void runProgram() {

    }
}