package com.backend.migue.security.Service;

import com.backend.migue.security.Entity.Rol;
import com.backend.migue.security.Enums.RolNombre;
import com.backend.migue.security.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
 public void save(Rol rol){
        rolRepository.save(rol);
 }
}
