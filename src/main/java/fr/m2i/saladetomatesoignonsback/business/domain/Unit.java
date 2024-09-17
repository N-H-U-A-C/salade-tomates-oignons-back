package fr.m2i.saladetomatesoignonsback.business.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "unit_id")
    private UUID id;

    @Column(name = "unit_label")
    private String label;

    public Unit() {
    }

    public Unit(UUID id, String label) {
        this.id = id;
        this.label = label;
    }

    public UUID getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unit)) return false;
        Unit unit = (Unit) o;
        return id != null && id.equals(unit.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
