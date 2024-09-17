package fr.m2i.saladetomatesoignonsback.business.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "animal_id")
    private UUID id;

    @Column(name = "animal_label")
    private String label;

    public Animal() {
    }

    public Animal(String label) {
        this.label = label;
    }

    public Animal(UUID id, String label) {
        this(label);
        this.id = id;
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
        if (!(o instanceof Animal animal)) return false;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
