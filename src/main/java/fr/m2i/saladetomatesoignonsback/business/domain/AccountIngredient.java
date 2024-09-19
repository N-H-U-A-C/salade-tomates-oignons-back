package fr.m2i.saladetomatesoignonsback.business.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

// Class that models the many-to-many associative table (with attribute) between Account and Ingredient
@Entity
@Table(name = "add_fridge")
public class AccountIngredient {

    @EmbeddedId
    private AccountIngredientId id;

    @Column(name = "add_fridge_quantity")
    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    @MapsId("accountId")
    @JsonBackReference
    private Account account;

    @ManyToOne()
    @JoinColumn(name = "ingredient_id")
    @MapsId("ingredientId")
    private Ingredient ingredient;

    protected AccountIngredient() {
    }

    public AccountIngredient(Account account, Ingredient ingredient) {
        this.account = account;
        this.ingredient = ingredient;
        this.id = new AccountIngredientId(account.getId(), ingredient.getId());
    }

    public AccountIngredientId getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Account getAccount() {
        return account;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountIngredient that = (AccountIngredient) o;
        return Objects.equals(account, that.account) && Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, ingredient);
    }

    @Override
    public String toString() {
        return "AccountIngredient{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", account=" + account +
                ", ingredient=" + ingredient +
                '}';
    }

    // Class that models the composite primary key of an AccountIngredient (many-to-many associative table with attribute)
    @Embeddable
    public static class AccountIngredientId implements Serializable {

        @Column(name = "account_id")
        private UUID accountId;

        @Column(name = "ingredient_id")
        private UUID ingredientId;

        protected AccountIngredientId() {
        }

        public AccountIngredientId(UUID accountId, UUID ingredientId) {
            this.accountId = accountId;
            this.ingredientId = ingredientId;
        }

        public UUID getAccountId() {
            return accountId;
        }

        public UUID getIngredientId() {
            return ingredientId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AccountIngredientId accountIngredientId = (AccountIngredientId) o;
            return Objects.equals(getAccountId(), accountIngredientId.getAccountId()) && Objects.equals(getIngredientId(), accountIngredientId.getIngredientId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getAccountId(), getIngredientId());
        }

        @Override
        public String toString() {
            return "AccountIngredientId{" +
                    "accountId=" + accountId +
                    ", ingredientId=" + ingredientId +
                    '}';
        }
    }
}
