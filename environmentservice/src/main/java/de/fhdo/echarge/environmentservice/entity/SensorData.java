package de.fhdo.echarge.environmentservice.entity;

import java.util.Date;

public class SensorData {
    private String value;
    private Date timestamp;

    public SensorData() {
    }

    public SensorData(String value, Date timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SensorData{"
                + "value='" + value + '\''
                + ", timestamp=" + timestamp
                + '}';
    }
}
