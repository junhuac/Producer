package kafka;

public class RequestClass {
    String deviceid;
    String latitude;
    String longitude;

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }
    
    public String getLatitude() {
        return latitude;
    }
    
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    public String getLongitude() {
        return longitude;
    }
    
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    public RequestClass(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public RequestClass() {
    }
}
