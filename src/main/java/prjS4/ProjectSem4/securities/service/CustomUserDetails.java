package prjS4.ProjectSem4.securities.service;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import prjS4.ProjectSem4.entities.Accounts;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    
    Accounts acc;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return acc.getAccessList().stream()
                .map(access -> new SimpleGrantedAuthority("ROLE_" + mapRoleNumberToRoleName(access.getRoleId().getRoleNum())))
                .collect(Collectors.toList());
    }
    
    private String mapRoleNumberToRoleName(Integer roleNum) {
        return switch (roleNum) {
            case 1 -> "SUPER_ADMIN";
            case 2 -> "ADMIN";
            case 3 -> "MANAGEMENT_EMPLOYEE";
            case 4 -> "EMPLOYEE";
            case 5 -> "USER";
            case 6 -> "COMPLETED_USER";
            default -> "UNKNOWN";
        };
    }

    @Override
    public String getPassword() {
        return acc.getUserPassword();
    }

    @Override
    public String getUsername() {
        return acc.getUserName();
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
