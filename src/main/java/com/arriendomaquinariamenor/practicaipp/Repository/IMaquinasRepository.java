package com.arriendomaquinariamenor.practicaipp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arriendomaquinariamenor.practicaipp.Model.Maquinas;

@Repository
public interface IMaquinasRepository extends JpaRepository<Maquinas, Long> {
    
}
