package fr.m2i.saladetomatesoignonsback.business.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id @GeneratedValue(strategy = GenerationType.UUID) @Column(name = "ingredient_id")
    private UUID id;

    @Column(name = "ingredient_label")
    @NotBlank @Size(max = 30)
    private String label;

    @Column(name = "vegetarian")
    @NotNull
    private boolean vegetarian;

    @Column(name = "vegan")
    @NotNull
    private boolean vegan;

    @Column(name = "gluten_free")
    @NotNull
    private boolean glutenFree;

    @Column(name = "lactose_free")
    @NotNull
    private boolean lactoseFree;

    @Column(name = "calorie")
    @NotNull
    private int calorie;

    @ManyToOne
    @Nullable
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToMany
    @JoinTable(name = "filter_ingredient",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "ingredient",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference
    private List<AccountIngredient> accountIngredients = new ArrayList<>();

    public Ingredient() {
    }

    public UUID getId() {
        return id;
    }

    public @NotBlank @Size(max = 30) String getLabel() {
        return label;
    }

    @NotNull
    public boolean isVegetarian() {
        return vegetarian;
    }

    @NotNull
    public boolean isVegan() {
        return vegan;
    }

    @NotNull
    public boolean isGlutenFree() {
        return glutenFree;
    }

    @NotNull
    public boolean isLactoseFree() {
        return lactoseFree;
    }

    @NotNull
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<AccountIngredient> getAccountIngredients() {
        return accountIngredients;
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
                ", accounts=" + accounts +
                ", accountIngredients=" + accountIngredients +
                '}';
    }
}
