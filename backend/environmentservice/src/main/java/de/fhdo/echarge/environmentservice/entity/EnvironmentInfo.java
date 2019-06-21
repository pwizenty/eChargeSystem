package de.fhdo.echarge.environmentservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "environment")
public class EnvironmentInfo {
    @Id
    private String id;
    private int sensorId;
    private SENSORTYPE sensorType;
    private List<SensorData> sensorDataHistory;

    public EnvironmentInfo() {
    }

    public EnvironmentInfo(int sensorId,
                           SENSORTYPE sensorType,
                           List<SensorData> sensorDataHistory) {
        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.sensorDataHistory = sensorDataHistory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public SENSORTYPE getSensorType() {
        return sensorType;
    }

    public void setSensorType(SENSORTYPE sensorType) {
        this.sensorType = sensorType;
    }

    public List<SensorData> getSensorDataHistory() {
        return sensorDataHistory;
    }

    public void setSensorDataHistory(
            List<SensorData> sensorDataHistory) {
        this.sensorDataHistory = sensorDataHistory;
    }

    @Override
    public String toString() {
        return "EnvironmentInfo{"
                + "id='" + id + '\''
                + ", sensorId=" + sensorId
                + ", sensorType=" + sensorType
                + ", sensorDataHistory=" + sensorDataHistory
                + '}';
    }
}