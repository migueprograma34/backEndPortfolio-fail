package com.backend.migue.security.Controller;

import com.backend.migue.security.Enums.RolNombre;
import com.backend.migue.security.JWT.JwtProvider;
import com.backend.migue.security.Service.RolService;
import com.backend.migue.security.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
     if (bindingResult.hasErrors())
        return new ResponseEntity<>(new Mensaje("Campos invalidos o email invalido"), HttpStatus.BAD_REQUEST);
     if (usuarioService.existsByNombreUsuario(nombreUsuario.getNombreUsuario()))
         return new ResponseEntity<>(new Mensaje("usuario ya existente"),HttpStatus.BAD_REQUEST);
     if (usuarioService.existsByEmail(email.getEmail()))
         return new ResponseEntity<>(new Mensaje("Email ya existente"),HttpStatus.BAD_REQUEST);
     Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()) );

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
    }

}
