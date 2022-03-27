public class SmartObject {
    private String alias;
    private String macId;
    private String IP;
    private boolean connectionStatus;

    public SmartObject() {

    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String iP) {
        this.IP = iP;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public boolean connect(String ID) {

    }
    public boolean disconnect() {

    }
    
    public void SmartObjectToString() {
        
    }

    public boolean controlConnection() {

    }

    public boolean testObject() {
        
    }

    public boolean shutDownObject() {

    }
    
}
