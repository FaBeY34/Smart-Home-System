import java.util.ArrayList;

public class SmartHome implements Comparable<SmartCamera> {
    private ArrayList<SmartObject> smartObjectList;

    public SmartHome() {
        
    }

    public ArrayList<SmartObject> getSmartObjectList() {
        return smartObjectList;
    }

    public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
        this.smartObjectList = smartObjectList;
    }

    public boolean addSmartObject(SmartObject smartObject) {

    }

    public boolean removeSmartObject(SmartObject smartObject) {

    }

    public void controlLocation(boolean onCome) {

    }

    public void controlMotion(boolean hasMotion, boolean isDay) {

    }

    public void controlProgrammable() {

    }

    public void controlTimer(int seconds) {

    }

    public void controlTimerRandomly() {

    }

    public void sortCameras() {

    }

    @Override
    public int compareTo(SmartCamera o) {
        // TODO Auto-generated method stub
        return 0;
    }

}
