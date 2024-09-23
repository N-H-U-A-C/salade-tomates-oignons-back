package fr.m2i.saladetomatesoignonsback.business.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.UUID;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "account_id")
    private UUID id;

    @Column(name = "username")
    @NotBlank
    @Size(max = 20)
    private String username;

    @Column(name = "mail")
    @NotBlank
    @Email
    @Size(max = 50)
    private String email;

    @Column(name = "account_password")
    @NotBlank
    private String password;

    @Column(name = "default_serving")
    private int defaultServing;

    @Column(name = "avatar")

    @Size(max = 500)
    private String avatar;

    @Column(name = "vegetarian")
    boolean vegetarian;

    @Column(name = "vegan")
    boolean vegan;

    @Column(name = "gluten_free")
    boolean glutenFree;

    @Column(name = "lactose_free")
    boolean lactoseFree;

    @Column(name = "account_admin")
    private boolean admin;

    public Account() {
    }

    public UUID getId() {
        return id;
    }

    public @NotBlank @Size(max = 20) String getUsername() {
        return username;
    }

    public @NotBlank @Email @Size(max = 50) String getEmail() {
        return email;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public int getDefaultServing() {
        return defaultServing;
    }

    public @Size(max = 500) String getAvatar() {
        return avatar;
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

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return id != null && id.equals(account.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", defaultServing=" + defaultServing +
                ", avatar='" + avatar + '\'' +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", glutenFree=" + glutenFree +
                ", lactoseFree=" + lactoseFree +
                ", admin=" + admin +
                '}';
    }
}
