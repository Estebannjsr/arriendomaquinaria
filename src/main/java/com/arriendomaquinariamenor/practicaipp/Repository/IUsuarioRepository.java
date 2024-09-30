package com.arriendomaquinariamenor.practicaipp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arriendomaquinariamenor.practicaipp.Model.Usuario;

@Repository
public interface IUsuarioRepository extends  JpaRepository<Usuario, Long> {
    
}
