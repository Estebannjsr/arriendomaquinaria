package com.arriendomaquinariamenor.practicaipp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arriendomaquinariamenor.practicaipp.Model.Maquinas;
import com.arriendomaquinariamenor.practicaipp.Model.Usuario;
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
    public Maquinas editarMaquina(Long id, String nuevo_nombre, String nueva_marca, String nuevo_estado, Usuario nuevo_id_Usuario) {
        Maquinas maquina = this.verMaquina(id);


        maquina.setNombre(nuevo_nombre);
        maquina.setMarca(nueva_marca);
        maquina.setEstado(nuevo_estado);
        maquina.setId_usuario(nuevo_id_Usuario);

        this.crearMaquina(maquina);
        return  maquina;
    }
}
