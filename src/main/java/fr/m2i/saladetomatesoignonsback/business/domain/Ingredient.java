package fr.m2i.saladetomatesoignonsback.business.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ingredient_id")
    private UUID id;
    @Column(name = "ingredient_label")
    private String label;
    @Column(name = "vegetarian")
    private boolean vegetarian;
    @Column(name = "vegan")
    private boolean vegan;
    @Column(name = "gluten_free")
    private boolean glutenFree;
    @Column(name = "lactose_free")
    private boolean lactoseFree;
    @Column(name = "calorie")
    private int calorie;

    @ManyToOne
    @Nullable
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    public Ingredient() {
    }

    public UUID getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public boolean isLactoseFree() {
        return lactoseFree;
    }

    public int getCalorie() {
        return calorie;
    }

    @Nullable
    public Animal getAnimal() {
        return animal;
    }

    public Unit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient ingredient = (Ingredient) o;
        return id != null && id.equals(ingredient.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", glutenFree=" + glutenFree +
                ", lactoseFree=" + lactoseFree +
                ", calorie=" + calorie +
                ", animal=" + animal +
                ", unit=" + unit +
                '}';
    }
}
