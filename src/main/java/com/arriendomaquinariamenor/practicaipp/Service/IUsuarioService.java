package com.arriendomaquinariamenor.practicaipp.Service;

import java.util.List;

import com.arriendomaquinariamenor.practicaipp.Model.Usuario;

public interface IUsuarioService {
    
    //get
    public List<Usuario> verUsuarios();
    //Post
    public Usuario crearUsuario(Usuario usuario);
    //Delete
    public String eliminarUsuario(Long id);
    //Find
    public Usuario verUsuario(Long id);
    //Put
    public Usuario editarUsuario(Long id, String nuevo_nombre, String nuevo_apellido, int nuevo_rut, String nueva_direccion);
}
