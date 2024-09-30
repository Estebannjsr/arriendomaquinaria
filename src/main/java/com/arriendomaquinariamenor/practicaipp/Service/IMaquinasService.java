package com.arriendomaquinariamenor.practicaipp.Service;

import java.util.List;

import com.arriendomaquinariamenor.practicaipp.Model.Maquinas;
import com.arriendomaquinariamenor.practicaipp.Model.Usuario;

public interface IMaquinasService {
    //get
    public List<Maquinas> verMaquinas();
    //Post
    public Maquinas crearMaquina(Maquinas maquina);
    //Delete
    public void  eliminarMaquinas(Long id);
    //Find
    public Maquinas verMaquina(Long id);
    //Put
    public Maquinas editarMaquina(Long id, String nuevo_nombre, String nueva_marca, String nuevo_estado, Usuario nuevo_id_Usuario);
}
