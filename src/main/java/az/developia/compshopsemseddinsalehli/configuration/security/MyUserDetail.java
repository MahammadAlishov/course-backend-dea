package az.developia.compshopsemseddinsalehli.configuration.security;

import az.developia.compshopsemseddinsalehli.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class MyUserDetail implements UserDetails {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String surname;

    public MyUserDetail(User u) {
        this.username = u.getUsername();
        this.password = u.getPassword();
        this.email = u.getEmail();
        this.phone = u.getPhone();
        this.name = u.getName();
        this.surname = u.getSurname();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true;
    }
}
