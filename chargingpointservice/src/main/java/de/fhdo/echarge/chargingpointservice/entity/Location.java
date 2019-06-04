package de.fhdo.echarge.chargingpointservice.entity;

public class Location {
    private String id;
    private String street;
    private String streetNumber;
    private String city;
    private String zipCode;
    private double latitude;
    private double longitude;

    public Location() {
    }

    /**
     * Constructor with all parameters.
     *
     * @param street       street
     * @param streetNumber streetNumber
     * @param city         city
     * @param zipCode      zipCode
     * @param latitude     latitude
     * @param longitude    longitude
     */
    public Location(String street, String streetNumber, String city, String zipCode,
                    double latitude, double longitude) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Location{"
                + "id='" + id + '\''
                + ", street='" + street + '\''
                + ", streetNumber='" + streetNumber + '\''
                + ", city='" + city + '\''
                + ", zipCode='" + zipCode + '\''
                + ", latitude=" + latitude
                + ", longitude=" + longitude
                + '}';
    }
}