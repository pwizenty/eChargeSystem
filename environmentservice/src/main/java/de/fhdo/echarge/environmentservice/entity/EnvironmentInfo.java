package de.fhdo.echarge.environmentservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "environment")
public class EnvironmentInfo {
    @Id
    private String id;
    private String description;
    private int sensorId;
    private SENSORTYPE sensorType;
    private SensorData sensorDataHistory;

    public EnvironmentInfo() {
    }

    public EnvironmentInfo(String description, int sensorId,
                           SENSORTYPE sensorType,
                           SensorData sensorDataHistory) {
    	this.description = description;
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

    public SensorData getSensorDataHistory() {
        return sensorDataHistory;
    }

    public void setSensorDataHistory(
            SensorData sensorDataHistory) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}