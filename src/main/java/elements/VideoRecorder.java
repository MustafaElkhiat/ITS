package elements;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VideoRecorder")
public class VideoRecorder extends Device {
    private int portNum;

    public VideoRecorder() {
    }

    public VideoRecorder(String device, String mac_address, String ip_address, Department department, DeviceType deviceType, int portNum) {
        super(device, mac_address, ip_address, department, deviceType);
        this.portNum = portNum;
    }

    public int getPortNum() {
        return portNum;
    }

    public void setPortNum(int portNum) {
        this.portNum = portNum;
    }
}
