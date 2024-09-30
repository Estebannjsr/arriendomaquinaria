package com.arriendomaquinariamenor.practicaipp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_usuario;
    private String nombre;
    private String apellido;
    private int rut;
    private String Direccion;

    public Usuario(){
        
    }

    public Usuario(String Direccion, String apellido, Long id_usuario, String nombre, int rut) {
        this.Direccion = Direccion;
        this.apellido = apellido;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.rut = rut;
    }

    
}
