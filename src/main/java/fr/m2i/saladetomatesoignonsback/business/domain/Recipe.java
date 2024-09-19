package fr.m2i.saladetomatesoignonsback.business.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "recipe_id")
    private UUID id;

    @Column(name = "recipe_label")
    @NotBlank
    @Size(max = 60)
    private String label;

    @Column(name = "recipe_public")
    private boolean publicRecipe;

    @Column(name = "instruction")
    @NotBlank
    private String instruction;

    @Column(name = "duration")
    @Positive
    private int duration;

    @Column(name = "recipe_picture")
    @Size(max = 500)
    private String picture;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "recipe",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    public Recipe() {
    }

    public UUID getId() {
        return id;
    }

    public @NotBlank @Size(max = 60) String getLabel() {
        return label;
    }

    public boolean isPublicRecipe() {
        return publicRecipe;
    }

    public @NotBlank String getInstruction() {
        return instruction;
    }

    @Positive
    public int getDuration() {
        return duration;
    }

    public @Size(max = 500) String getPicture() {
        return picture;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return id != null && id.equals(recipe.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", publicRecipe=" + publicRecipe +
                ", instruction='" + instruction + '\'' +
                ", duration=" + duration +
                ", picture='" + picture + '\'' +
                ", account=" + account +
                ", recipeIngredients=" + recipeIngredients +
                '}';
    }
}
