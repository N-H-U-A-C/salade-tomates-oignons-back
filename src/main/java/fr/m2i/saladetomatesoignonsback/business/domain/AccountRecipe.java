package fr.m2i.saladetomatesoignonsback.business.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

// Class that models the many-to-many associative table (with attribute) between Account and Recipe
@Entity
@Table(name = "filter_recipe")
public class AccountRecipe {

    @EmbeddedId
    private AccountRecipeId id;

    @Column(name = "rating")
    @Min(0) @Max(5)
    private int rating;

    @Column(name = "favorite")
    private boolean favorite;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    @MapsId("accountId")
    @JsonBackReference
    private Account account;

    @ManyToOne()
    @JoinColumn(name = "recipe_id")
    @MapsId("recipeId")
    private Recipe recipe;

    protected AccountRecipe() {
    }

    public AccountRecipe(Account account, Recipe recipe) {
        this.account = account;
        this.recipe = recipe;
        this.id = new AccountRecipeId(account.getId(), recipe.getId());
    }

    public AccountRecipeId getId() {
        return id;
    }

    @Min(0)
    @Max(5)
    public int getRating() {
        return rating;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public Account getAccount() {
        return account;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRecipe that = (AccountRecipe) o;
        return Objects.equals(account, that.account) && Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, recipe);
    }

    @Override
    public String toString() {
        return "AccountRecipe{" +
                "id=" + id +
                ", rating=" + rating +
                ", favorite=" + favorite +
                ", account=" + account +
                ", recipe=" + recipe +
                '}';
    }

    // Class that models the composite primary key of an AccountRecipe (many-to-many associative table with attribute)
    @Embeddable
    public static class AccountRecipeId implements Serializable {

        @Column(name = "account_id")
        private UUID accountId;

        @Column(name = "recipe_id")
        private UUID recipeId;

        protected AccountRecipeId() {
        }

        public AccountRecipeId(UUID accountId, UUID recipeId) {
            this.accountId = accountId;
            this.recipeId = recipeId;
        }

        public UUID getAccountId() {
            return accountId;
        }

        public UUID getRecipeId() {
            return recipeId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AccountRecipeId accountRecipeId = (AccountRecipeId) o;
            return Objects.equals(getAccountId(), accountRecipeId.getAccountId()) && Objects.equals(getRecipeId(), accountRecipeId.getRecipeId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getAccountId(), getRecipeId());
        }

        @Override
        public String toString() {
            return "AccountRecipeId{" +
                    "accountId=" + accountId +
                    ", recipeId=" + recipeId +
                    '}';
        }
    }
}
