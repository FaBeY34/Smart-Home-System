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
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Adding new SmartObject");
        System.out.println("--------------------------------------------------------------------------");
        smartObjectList.add(smartObject);
        smartObject.connect("10.0.0." + (100 + smartObjectList.indexOf(smartObject)));
        System.out.println("Test is starting for " + smartObject.getClass().getSimpleName());
        smartObject.testObject();
        System.out.println();
        return true;
    }

    public boolean removeSmartObject(SmartObject smartObject) throws Exception {
        if (!smartObjectList.contains(smartObject)) {
            throw new Exception("This smart object is not found");
        }
        return smartObjectList.remove(smartObject);
    }

    public void controlLocation(boolean onCome) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("LocationControl: " + ((onCome) ? "onCome" : "onLeave"));
        System.out.println("--------------------------------------------------------------------------");
        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof LocationControl) {
                if (onCome) {
                    ((LocationControl) smartObject).onCome();
                } else {
                    ((LocationControl) smartObject).onLeave();
                }
            }
        }
    }

    public void controlMotion(boolean hasMotion, boolean isDay) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("MotionControl: HasMotion, isDay");
        System.out.println("--------------------------------------------------------------------------");

        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof MotionControl) {
                ((MotionControl) smartObject).controlMotion(hasMotion, isDay);
            }
        }
    }

    public void controlProgrammable() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Programmable: runProgram");
        System.out.println("--------------------------------------------------------------------------");

        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof Programmable) {
                ((Programmable) smartObject).runProgram();
            }
        }
    }

    public void controlTimer(int seconds) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Programmable: Timer = " + seconds + " seconds");
        System.out.println("-----------------------------------------------------------------------");

        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof Programmable) {
                if (seconds != 0) {
                    ((Programmable) smartObject).setTimer(seconds);
                } else {
                    ((Programmable) smartObject).cancelTimer();
                }
            }
        }
    }

    public void controlTimerRandomly() {
        int randomNumber = (int) (Math.random() * 3);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Programmable: Timer = 5 or 10 seconds randomly");
        System.out.println("-----------------------------------------------------------------------");

        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof Programmable) {
                if (randomNumber != 0) {
                    ((Programmable) smartObject).setTimer(randomNumber * 5);
                } else {
                    ((Programmable) smartObject).cancelTimer();
                }
            }
        }
    }

    public void sortCameras() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Sort Smart Cameras");
        System.out.println("--------------------------------------------------------------------------");

        ArrayList<SmartCamera> smartCameras = new ArrayList<>();

        for (SmartObject smartObject : smartObjectList) {
            if (smartObject instanceof SmartCamera && smartObject instanceof Comparable) {
                smartCameras.add((SmartCamera) smartObject);
            }
        }
        SmartCamera maxBatteryLife = smartCameras.get(0);
        // for (int i = 1; i < smartCameras.size(); i++) {
        // if (Integer.compare(maxBatteryLife.getBatteryLife(),
        // smartCameras.get(i).getBatteryLife()) == -1) {
        // maxBatteryLife = smartCameras.get(i);
        // }
        // }
        for (int i = 1; i < smartCameras.size(); i++) {
            if (maxBatteryLife.compareTo(smartCameras.get(i)) == -1) {
                maxBatteryLife = smartCameras.get(i);
            }
        }
    }

    @Override
    public int compareTo(SmartCamera smartCamera) {
        return 0;

    }

}