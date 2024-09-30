package com.arriendomaquinariamenor.practicaipp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity @Getter @Setter
public class Maquinas {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String marca;
    private String estado;


    @OneToOne
    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
    private Usuario id_usuario;

    public Maquinas(){

    }

    public Maquinas(String estado, Long id, String marca, String nombre, Usuario id_usuario) {
        this.estado = estado;
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.id_usuario = id_usuario;
    }

    
}
