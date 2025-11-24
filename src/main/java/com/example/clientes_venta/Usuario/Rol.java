package com.example.clientes_venta.Usuario;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Rol {
    USER(Collections.emptySet()),
    ADMIN(Set.of(
        Permission.ADMIN_READ,
        Permission.ADMIN_CREATE,
        Permission.ADMIN_UPDATE,
        Permission.ADMIN_DELETE
    )), 
    ;

    @Getter
    private final Set<Permission> permissions;


    public List<SimpleGrantedAuthority> getAuthorities(){

        var authorities = getPermissions().stream()
            .map(permission -> new SimpleGrantedAuthority(permission.name()))
            .toList();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
