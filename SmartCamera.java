public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera> {
    private boolean status;
    private int batteryLife;
    private boolean nightVision;

    public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
        setAlias(alias);
        setMacId(macId);
        this.nightVision = nightVision;
        this.batteryLife = batteryLife;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getBatteryLife() {
        return this.batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public boolean getNightVision() {
        return this.nightVision;
    }

    public void setNightVision(boolean nightVision) {
        this.nightVision = nightVision;
    }

    public void recordOn(boolean isDay) {
        if (isDay && nightVision && !getConnectionStatus()) {
            setStatus(true);

        }
    }

    public void recordOff() {

    }

    public boolean testObject() {
        if (getConnectionStatus()) {
            SmartObjectToString();
            System.out.println("Test is starting for " + getClass().getSimpleName() + " day time ");
            recordOn(true);
            recordOff();
            System.out.println("Test is starting for " + getClass().getSimpleName() + " night time");
            recordOn(false);
            recordOff();
            System.out.println("Test  completed for " + getClass().getSimpleName());
            return true;
        }
        return false;
    }

    public boolean shutDownObject() {
        if (getConnectionStatus()) {
            SmartObjectToString();
            status = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean controlMotion(boolean hasMotion, boolean isDay) {
        if (hasMotion) {
            System.out.println("Motion detected");
            
            if (getConnectionStatus()) {

                if (isDay) {
                    recordOn(true);
                } else {
                    status = nightVision;
                }
            }
        } else {
            System.out.println("Motion not detected");
        }

    }

    @Override
    public int compareTo(SmartCamera smartCamera) {
        return Integer.compare(this.batteryLife, smartCamera.batteryLife);
    }

    public String statusToString() {
        return status ? "is recording" : "is not recording";
    }

    @Override
    public String toString() {
        return "SmartCamera -> " + getAlias() + "'s battery life is " + batteryLife + " status " + statusToString();
    }
}