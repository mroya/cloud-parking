package one.digitalinnovation.parking;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link one.digitalinnovation.parking.model.Parking} entity
 */
public class ParkingDto implements Serializable {
    private final String id;
    private final String license;
    private final String state;
    private final String model;
    private final String color;
    private final LocalDateTime entryDate;
    private final LocalDateTime exitDate;
    private final Double bill;

    public ParkingDto(String id, String license, String state, String model, String color, LocalDateTime entryDate, LocalDateTime exitDate, Double bill) {
        this.id = id;
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.bill = bill;
    }

    public String getId() {
        return id;
    }

    public String getLicense() {
        return license;
    }

    public String getState() {
        return state;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public Double getBill() {
        return bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingDto entity = (ParkingDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.license, entity.license) &&
                Objects.equals(this.state, entity.state) &&
                Objects.equals(this.model, entity.model) &&
                Objects.equals(this.color, entity.color) &&
                Objects.equals(this.entryDate, entity.entryDate) &&
                Objects.equals(this.exitDate, entity.exitDate) &&
                Objects.equals(this.bill, entity.bill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, license, state, model, color, entryDate, exitDate, bill);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "license = " + license + ", " +
                "state = " + state + ", " +
                "model = " + model + ", " +
                "color = " + color + ", " +
                "entryDate = " + entryDate + ", " +
                "exitDate = " + exitDate + ", " +
                "bill = " + bill + ")";
    }
}