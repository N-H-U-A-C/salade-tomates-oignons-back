package fr.m2i.saladetomatesoignonsback.business.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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
    @Min(1)
    private int defaultServing;

    @Column(name = "avatar")
    @Size(max = 500)
    private String avatar;

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

    @Min(1)
    public int getDefaultServing() {
        return defaultServing;
    }

    public @Size(max = 500) String getAvatar() {
        return avatar;
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
                ", admin=" + admin +
                '}';
    }
}
