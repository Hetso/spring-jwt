package br.com.hetso.springjwt.data.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@SuperBuilder
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Column(nullable = false, unique = true)
    private final String username;

    @Column(nullable = false, unique = true)
    private final String email;

    @Column(nullable = false, name = "first_name")
    private final String firstName;

    @Column(nullable = false, name = "last_name")
    private final String lastName;

    @Column(nullable = false)
    private final String password;

    private final Boolean enabled;

    @Column(name = "account_non_locked")
    private final Boolean accountNonLocked;

    @Column(name = "account_non_expired")
    private final Boolean accountNonExpired;

    @Column(name = "credentials_non_expired")
    private final Boolean credentialsNonExpired;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permissions", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "permission_id") })
    private final List<PermissionModel> permissions;

    // SPRING SECURITY GETTERS

    public List<String> getRoles() {
        return this.permissions.stream()
            .map(PermissionModel::getName)
            .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissions;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}
