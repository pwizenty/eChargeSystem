package de.fhdo.echarge.chargingpointservice.entity;

import java.util.Date;

public class TimePeriod {
    private Date start;
    private Date end;

    public TimePeriod() {
    }

    public TimePeriod(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "TimePeriod{"
                + "start=" + start
                + ", end=" + end
                + '}';
    }
}
