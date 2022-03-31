import java.util.Calendar;

public class SmartLight extends SmartObject implements LocationControl, Programmable {
    private boolean hasLightTurned;
    private Calendar programTime;
    private boolean programAction;

    public SmartLight(String alias, String macId) {
        programTime = Calendar.getInstance();
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
        if (getConnectionStatus()) {
            if (!hasLightTurned) {
                setHasLightTurned(true);
                setProgramAction(false);
                System.out.println(
                        "SmartLight - " + getAlias() + " is turned on now (Current time: "
                                + programTimeToString()
                                + ")");
            } else {
                System.out.println(
                        "SmartLight - " + getAlias() + " has been already turned on");
            }
        }
    }

    public void turnOffLight() {
        if (getConnectionStatus()) {
            if (hasLightTurned) {
                setHasLightTurned(false);
                setProgramAction(true);
                System.out.println("SmartLight - " + getAlias() + " is turned off now (Current time: "
                        + programTimeToString() + ")");
            } else {
                System.out.println("SmartLight - " + getAlias() + " has been already turned off");
            }
        }
    }

    public boolean testObject() {
        if (getConnectionStatus()) {
            SmartObjectToString();
            turnOnLight();
            turnOffLight();
            System.out.println("Test completed for SmartLight");
            return true;
        }
        return false;

    }

    public boolean shutDownObject() {
        if (getConnectionStatus()) {
            SmartObjectToString();
            turnOffLight();
            return true;
        }
        return false;

    }

    @Override
    public void onLeave() {
        if (getConnectionStatus()) {
            turnOffLight();
            System.out.println("On Leave -> SmartLight - " + getAlias());
        }
    }

    @Override
    public void onCome() {
        if (!getConnectionStatus()) {
            turnOnLight();
            System.out.println("On Come -> SmartLight - " + getAlias());
        }
    }

    @Override
    public void setTimer(int seconds) {
        if (getConnectionStatus()) {
            setProgramTime(programTime);
            if (hasLightTurned) {
                System.out.println("SmartLight - " + getAlias() + " will be turned off " + seconds
                        + " seconds later! (Current time: " + programTimeToString() + ")");
            } else {
                System.out.println("SmartLight - " + getAlias() + " will be turned on " + seconds
                        + " seconds later! (Current time: " + programTimeToString() + ")");
            }
            programTime.add(Calendar.SECOND, seconds);

        }
    }

    @Override
    public void cancelTimer() {
        if (getConnectionStatus()) {
            programTime = null;
        }
    }

    @Override
    public void runProgram() {
        boolean isTimeProperly = (programTime != null);
        if (isTimeProperly && getConnectionStatus() && programTimeToString().equals(currentTime())) {
            System.out.println("RunProgram -> SmartLight" + getAlias());
            if (programAction) {
                turnOnLight();
            } else {
                turnOffLight();
            }
            programTime = null;
        }

    }

    public String programTimeToString() {
        return programTime.get(Calendar.HOUR_OF_DAY) + ":" + programTime.get(Calendar.MINUTE) + ":"
                + programTime.get(Calendar.SECOND);
    }

}