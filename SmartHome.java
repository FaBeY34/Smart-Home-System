import java.util.ArrayList;

public class SmartHome implements Comparable<SmartCamera> {
    private ArrayList<SmartObject> smartObjectList;

    public SmartHome() {
        smartObjectList = new ArrayList<>();
    }

    public ArrayList<SmartObject> getSmartObjectList() {
        return smartObjectList;
    }

    public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
        this.smartObjectList = smartObjectList;
    }

    public boolean addSmartObject(SmartObject smartObject) throws Exception {
        if (smartObjectList.contains(smartObject)) {
            throw new Exception("This smart object already exists");
        }
        return smartObjectList.add(smartObject);
    }

    public boolean removeSmartObject(SmartObject smartObject) throws Exception {
        if (!smartObjectList.contains(smartObject)) {
            throw new Exception("This smart object is not found");
        }
        return smartObjectList.remove(smartObject);
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
        return 0;
    }

}