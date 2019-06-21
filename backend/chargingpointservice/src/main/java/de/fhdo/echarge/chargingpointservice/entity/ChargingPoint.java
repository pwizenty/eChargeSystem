package de.fhdo.echarge.chargingpointservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "chargingpoint")
public class ChargingPoint {
    @Id
    private String id;
    private String Name;
    private Location location;
    private String description;
    private String ownerId;
    private String chargingType;
    private String plugType;
    private boolean offered;
    private Offer offer;
    private List<TimePeriod> availableAt;
    private List<BookingEntry> bookedAt;
    private List<UsageHistory> usageHistories;
    private double consumedEnergyInKWh;
    private boolean activated;
    private boolean blocked;
    private boolean inUse;

    public ChargingPoint() {
    }

    public ChargingPoint(String name, Location location, String description, String ownerId,
                         String chargingType, String plugType, boolean offered,
                         Offer offer, List<TimePeriod> availableAt,
                         List<BookingEntry> bookedAt,
                         List<UsageHistory> usageHistories, double consumedEnergyInKWh, boolean activated,
                         boolean blocked, boolean inUse) {
        Name = name;
        this.location = location;
        this.description = description;
        this.ownerId = ownerId;
        this.chargingType = chargingType;
        this.plugType = plugType;
        this.offered = offered;
        this.offer = offer;
        this.availableAt = availableAt;
        this.bookedAt = bookedAt;
        this.usageHistories = usageHistories;
        this.consumedEnergyInKWh = consumedEnergyInKWh;
        this.activated = activated;
        this.blocked = blocked;
        this.inUse = inUse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getChargingType() {
        return chargingType;
    }

    public void setChargingType(String chargingType) {
        this.chargingType = chargingType;
    }

    public String getPlugType() {
        return plugType;
    }

    public void setPlugType(String plugType) {
        this.plugType = plugType;
    }

    public boolean isOffered() {
        return offered;
    }

    public void setOffered(boolean offered) {
        this.offered = offered;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public List<TimePeriod> getAvailableAt() {
        return availableAt;
    }

    public void setAvailableAt(
            List<TimePeriod> availableAt) {
        this.availableAt = availableAt;
    }

    public List<BookingEntry> getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(
            List<BookingEntry> bookedAt) {
        this.bookedAt = bookedAt;
    }

    public List<UsageHistory> getUsageHistories() {
        return usageHistories;
    }

    public void setUsageHistories(
            List<UsageHistory> usageHistories) {
        this.usageHistories = usageHistories;
    }

    public double getConsumedEnergyInKWh() {
        return consumedEnergyInKWh;
    }

    public void setConsumedEnergyInKWh(double consumedEnergyInKWh) {
        this.consumedEnergyInKWh = consumedEnergyInKWh;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    @Override
    public String toString() {
        return "ChargingPoint{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", location=" + location +
                ", description='" + description + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", chargingType='" + chargingType + '\'' +
                ", plugType='" + plugType + '\'' +
                ", offered=" + offered +
                ", offer=" + offer +
                ", availableAt=" + availableAt +
                ", bookedAt=" + bookedAt +
                ", usageHistories=" + usageHistories +
                ", consumedEnergyInKWh=" + consumedEnergyInKWh +
                ", activated=" + activated +
                ", blocked=" + blocked +
                ", inUse=" + inUse +
                '}';
    }
}