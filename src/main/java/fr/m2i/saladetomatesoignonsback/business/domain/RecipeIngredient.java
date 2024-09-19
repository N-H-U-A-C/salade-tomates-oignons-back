package fr.m2i.saladetomatesoignonsback.business.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

// Class that models the many-to-many associative table (with attribute) between Recipe and Ingredient
@Entity
@Table(name = "compose")
public class RecipeIngredient {

    @EmbeddedId
    private RecipeIngredientId id;

    @Column(name = "quantity")
    @Positive
    private double quantity;

    @Column(name = "consumed")
    private boolean consumed;

    @ManyToOne()
    @JoinColumn(name = "recipe_id")
    @MapsId("recipeId")
    @JsonBackReference
    private Recipe recipe;

    @ManyToOne()
    @JoinColumn(name = "ingredient_id")
    @MapsId("ingredientId")
    private Ingredient ingredient;

    protected RecipeIngredient() {
    }

    public RecipeIngredient(Recipe recipe, Ingredient ingredient) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.id = new RecipeIngredientId(recipe.getId(), ingredient.getId());
    }

    public RecipeIngredientId getId() {
        return id;
    }

    @Positive
    public double getQuantity() {
        return quantity;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Objects.equals(recipe, that.recipe) && Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe, ingredient);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", consumed=" + consumed +
                ", recipe=" + recipe +
                ", ingredient=" + ingredient +
                '}';
    }

    // Class that models the composite primary key of an RecipeIngredient (many-to-many associative table with attribute)
    @Embeddable
    public static class RecipeIngredientId implements Serializable {

        @Column(name = "recipe_id")
        private UUID recipeId;

        @Column(name = "ingredient_id")
        private UUID ingredientId;

        protected RecipeIngredientId() {
        }

        public RecipeIngredientId(UUID recipeId, UUID ingredientId) {
            this.recipeId = recipeId;
            this.ingredientId = ingredientId;
        }

        public UUID getRecipeId() {
            return recipeId;
        }

        public UUID getIngredientId() {
            return ingredientId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RecipeIngredientId recipeIngredientId = (RecipeIngredientId) o;
            return Objects.equals(getRecipeId(), recipeIngredientId.getRecipeId()) && Objects.equals(getIngredientId(), recipeIngredientId.getIngredientId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getRecipeId(), getIngredientId());
        }

        @Override
        public String toString() {
            return "RecipeIngredientId{" +
                    "recipeId=" + recipeId +
                    ", ingredientId=" + ingredientId +
                    '}';
        }
    }
}
