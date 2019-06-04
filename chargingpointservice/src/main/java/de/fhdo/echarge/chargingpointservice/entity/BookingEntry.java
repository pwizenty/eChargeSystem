package de.fhdo.echarge.chargingpointservice.entity;

public class BookingEntry {
    private TimePeriod period;
    private Offer offer;
    private double consumedEnergyInKWh;
    private String bookedByUserId;

    public BookingEntry() {
    }

    public BookingEntry(TimePeriod period, Offer offer, double consumedEnergyInKWh,
                        String bookedByUserId) {
        this.period = period;
        this.offer = offer;
        this.consumedEnergyInKWh = consumedEnergyInKWh;
        this.bookedByUserId = bookedByUserId;
    }

    public TimePeriod getPeriod() {
        return period;
    }

    public void setPeriod(TimePeriod period) {
        this.period = period;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public double getConsumedEnergyInKWh() {
        return consumedEnergyInKWh;
    }

    public void setConsumedEnergyInKWh(double consumedEnergyInKWh) {
        this.consumedEnergyInKWh = consumedEnergyInKWh;
    }

    public String getBookedByUserId() {
        return bookedByUserId;
    }

    public void setBookedByUserId(String bookedByUserId) {
        this.bookedByUserId = bookedByUserId;
    }

    @Override
    public String toString() {
        return "BookingEntry{"
                + "period=" + period
                + ", offer=" + offer
                + ", consumedEnergyInKWh=" + consumedEnergyInKWh
                + ", bookedByUserId='" + bookedByUserId + '\''
                + '}';
    }
}
