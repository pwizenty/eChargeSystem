package de.fhdo.echarge.chargingpointservice.entity;

public class UsageHistory {
    private TimePeriod period;
    private double consumedEnergyInKWh;
    private String userId;

    public UsageHistory() {
    }

    public UsageHistory(TimePeriod period, double consumedEnergyInKWh, String userId) {
        this.period = period;
        this.consumedEnergyInKWh = consumedEnergyInKWh;
        this.userId = userId;
    }

    public TimePeriod getPeriod() {
        return period;
    }

    public void setPeriod(TimePeriod period) {
        this.period = period;
    }

    public double getConsumedEnergyInKWh() {
        return consumedEnergyInKWh;
    }

    public void setConsumedEnergyInKWh(double consumedEnergyInKWh) {
        this.consumedEnergyInKWh = consumedEnergyInKWh;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UsageHistory{"
                + "period=" + period
                + ", consumedEnergyInKWh=" + consumedEnergyInKWh
                + ", userId='" + userId + '\''
                + '}';
    }
}
