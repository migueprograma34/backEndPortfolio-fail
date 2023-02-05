package com.backend.migue.security.Entity;

import com.backend.migue.security.Enums.RolNombre;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    public Rol(RolNombre rolNombre){
        this.rolNombre = rolNombre;
    }
    @Const

}
