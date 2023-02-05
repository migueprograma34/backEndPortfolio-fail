package com.backend.migue.Repository;

import com.backend.migue.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository< Persona,Long>{
}
