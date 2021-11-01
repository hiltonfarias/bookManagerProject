package com.github.hiltonfarias.bookManager.model;

import com.github.hiltonfarias.bookManager.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

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
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "USERS")
public class User extends EntityBase {
//    public class User extends EntityBase implements UserDetails {
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

//    @Enumerated(EnumType.STRING)
//    @Column(name = "USER_PERMISSION", nullable = false)
//    private PermissionType permissionType;

    @OneToMany(mappedBy = "users",fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
    @Column(name = "USER_BOOKS", nullable = false)
    private List<Book> bookList;

    @Column(name = "USER_ACTIVE", nullable = false)
    private boolean active;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> grantedAuthorities = Arrays.asList(new SimpleGrantedAuthority(permissionType.getCode()));
//        return grantedAuthorities;
////        return Arrays.asList(new SimpleGrantedAuthority(permissionType.getCode()));
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.login;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.active;
//    }
}
