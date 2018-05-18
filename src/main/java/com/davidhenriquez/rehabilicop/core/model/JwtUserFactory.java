package com.davidhenriquez.rehabilicop.core.model;

import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(Usuario usuario) {
        return new JwtUser( 
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
}
