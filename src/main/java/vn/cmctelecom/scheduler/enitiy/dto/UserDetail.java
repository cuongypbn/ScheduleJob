package vn.cmctelecom.scheduler.enitiy.dto;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
public class UserDetail implements UserDetails {
    private final JsonElement user;
    String ROLE_PREFIX = "ROLE_";

    public UserDetail(JsonElement user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        JsonArray roles  = user.getAsJsonObject().get("resource_access").getAsJsonObject().get("account").getAsJsonObject().get("roles").getAsJsonArray();

        if (roles != null) {
            roles.forEach( jsonElement -> {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ROLE_PREFIX + jsonElement.getAsString());
                authorities.add(authority);
            });
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return user.getAsJsonObject().get("email").toString();
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
