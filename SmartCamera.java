public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera> {
    private boolean status;
    private int batteryLife;
    private boolean nightVision;

    public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {

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

    }

    public void recordOff() {

    }

    public boolean testObject() {

    }

    public boolean shutDownObject() {

    }

    @Override
    public boolean controlMotion(boolean hasMotion, boolean isDay) {
        return false;
    }

    @Override
    public int compareTo(SmartCamera o) {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}