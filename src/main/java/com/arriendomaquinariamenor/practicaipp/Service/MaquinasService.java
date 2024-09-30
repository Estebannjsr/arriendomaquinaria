package com.arriendomaquinariamenor.practicaipp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arriendomaquinariamenor.practicaipp.Model.Maquinas;
import com.arriendomaquinariamenor.practicaipp.Repository.IMaquinasRepository;

@Service
public class MaquinasService implements  IMaquinasService{
    @Autowired
    private IMaquinasRepository maquinasrepository;

    @Override //GET
    public List<Maquinas> verMaquinas() {
      List<Maquinas> maquinas = maquinasrepository.findAll();
      return maquinas;
    }

    @Override //Post
    public Maquinas crearMaquina(Maquinas maquina) {
        maquinasrepository.save(maquina);
        return maquina;
    }

    @Override//Delete
    public void eliminarMaquinas(Long id) {
        maquinasrepository.deleteById(id);
        
    }

    @Override//Buscar por id
    public Maquinas verMaquina(Long id) {
        Maquinas maquina = maquinasrepository.findById(id).orElse(null);
        return maquina;

    }

    
    @Override
    public Maquinas editarMaquina(Long id, String nuevo_nombre, String nueva_marca, String nuevo_estado) {
        Maquinas maquina = this.verMaquina(id);

        
        maquina.setNombre(nuevo_nombre);
        maquina.setMarca(nueva_marca);
        maquina.setEstado(nuevo_estado);

        this.crearMaquina(maquina);
        return  maquina;
    }
}
