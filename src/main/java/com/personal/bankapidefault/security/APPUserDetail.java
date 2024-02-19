package com.personal.bankapidefault.security;

import com.personal.bankapidefault.entity.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class APPUserDetail implements UserDetails {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private Timestamp createdAt;
    private Boolean status;
    private boolean isEnabled;
    private boolean isCredentialsNonExpired;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private List<GrantedAuthority> authorities;


    public APPUserDetail() {
        super();
    }


    public APPUserDetail(UsersEntity usersEntity) {
        this.id = usersEntity.getId();
        this.userName = usersEntity.getUserName();
        this.firstName = usersEntity.getFirstName();
        this.lastName = usersEntity.getLastName();
        this.email = usersEntity.getEmail();
        this.password = usersEntity.getPassword();
        this.phoneNumber = usersEntity.getPhoneNumber();
        this.address = usersEntity.getAddress();
        this.createdAt = usersEntity.getCreatedAt();
        this.status = usersEntity.getStatus();
        this.isEnabled = usersEntity.isEnabled();
        this.isCredentialsNonExpired = usersEntity.isCredentialsNonExpired();
        this.isAccountNonExpired = usersEntity.isAccountNonExpired();
        this.isAccountNonLocked = usersEntity.isAccountNonLocked();
        this.authorities = grantedAuthorities(usersEntity);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public List<GrantedAuthority> grantedAuthorities(UsersEntity usersEntity){
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(!usersEntity.getSecurityRoleEntities().isEmpty()){
            usersEntity.getSecurityRoleEntities().forEach(securityRoleEntity -> {
                authorities.add(new SimpleGrantedAuthority(securityRoleEntity.getName()));
            });
        }
        return authorities;
    }


}
