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
        if (!getConnectionStatus()) {
            setHasLightTurned(true);
            System.out.println(
                    getClass().getSimpleName() + " - " + getAlias() + "is turned on now (Current time: " + programTime
                            + ")");
        } else {
            System.out.println(
                    getClass().getSimpleName() + " - " + getAlias() + " has been already turned on");
        }
    }

    public void turnOffLight() {
        if (getConnectionStatus()) {
            setHasLightTurned(false);
            System.out.println(getClass().getSimpleName() + " - " + getAlias() + "is turned off now (Current time: "
                    + programTime + ")");
        } else {
            System.out.println(getClass().getSimpleName() + " - " + getAlias() + "has been already turned off");
        }
    }

    public boolean testObject() {
        SmartObjectToString();
        turnOnLight();
        turnOffLight();

    }

    public boolean shutDownObject() {

    }

    @Override
    public void onLeave() {

    }

    @Override
    public void onCome() {

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