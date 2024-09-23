package fr.m2i.saladetomatesoignonsback.business.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "animal")
public class Animal {

    @Id @GeneratedValue(strategy = GenerationType.UUID) @Column(name = "animal_id")
    private UUID id;

    @Column(name = "animal_label")
    @NotBlank @Size(max = 20)
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

    public @NotBlank @Size(max = 20) String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return id != null && id.equals(animal.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
