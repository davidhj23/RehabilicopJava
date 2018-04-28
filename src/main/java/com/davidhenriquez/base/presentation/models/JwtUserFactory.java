package com.davidhenriquez.base.presentation.models;

import com.davidhenriquez.base.data_access.domain.Usuario;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(Usuario usuario) {
        return new JwtUser(
    		usuario.getIdUsuario(),
    		
    		usuario.getUsername(),
    		usuario.getPassword(),
    		usuario.getEmail(),
    		usuario.isEnabled(),
    		
    		usuario.getIdentificacion(),
    		usuario.getNombres(),
    		usuario.getApellidos(),
    		usuario.getDireccion(),
    		usuario.getTelefono(),
    		usuario.getCelular(),
    		
    		usuario.getUltimoAcceso(),
    		usuario.getRoles()        		
        );
    }

    /*private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }*/
}
