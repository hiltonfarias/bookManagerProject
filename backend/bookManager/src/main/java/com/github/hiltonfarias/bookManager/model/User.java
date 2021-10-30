package com.github.hiltonfarias.bookManager.model;

import com.github.hiltonfarias.bookManager.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
public class User extends EntityBase implements UserDetails {

    private static final Long serialVersionUID = 1L;

    @Column(name = "USER_LOGIN", nullable = false)
    private String login;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "USER_EMAIL", nullable = false)
    private String email;

    @Column(name = "USER_BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_PERMISSION", nullable = false)
    private PermissionType permissionType;

    @OneToMany(mappedBy = "users",fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
    @Column(name = "USER_BOOKS", nullable = false)
    private List<Book> bookList;

    @Column(name = "USER_ACTIVE", nullable = false)
    private boolean active;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (isActive() != user.isActive()) return false;
        if (!getLogin().equals(user.getLogin())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getFullName().equals(user.getFullName())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getBirthDate().equals(user.getBirthDate())) return false;
        if (getPermissionType() != user.getPermissionType()) return false;
        return getBookList().equals(user.getBookList());
    }

    @Override
    public int hashCode() {
        int result = getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getFullName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getBirthDate().hashCode();
        result = 31 * result + getPermissionType().hashCode();
        result = 31 * result + getBookList().hashCode();
        result = 31 * result + (isActive() ? 1 : 0);
        return result;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(permissionType.getCode()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
