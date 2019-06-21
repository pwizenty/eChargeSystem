package de.fhdo.echarge.chargingpointservice.entity;

public class Offer {
    private PAYMENTUNIT paymentUnit;
    private float pricePerUnit;
    private PAYMENTMETHOD paymentmethod;

    public Offer() {
    }

    public Offer(PAYMENTUNIT paymentUnit, float pricePerUnit,
                 PAYMENTMETHOD paymentmethod) {
        this.paymentUnit = paymentUnit;
        this.pricePerUnit = pricePerUnit;
        this.paymentmethod = paymentmethod;
    }

    public PAYMENTUNIT getPaymentUnit() {
        return paymentUnit;
    }

    public void setPaymentUnit(PAYMENTUNIT paymentUnit) {
        this.paymentUnit = paymentUnit;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public PAYMENTMETHOD getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(PAYMENTMETHOD paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    @Override
    public String toString() {
        return "Offer{"
                + "paymentUnit=" + paymentUnit
                + ", pricePerUnit=" + pricePerUnit
                + ", paymentmethod=" + paymentmethod
                + '}';
    }
}
