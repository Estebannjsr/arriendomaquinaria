package com.arriendomaquinariamenor.practicaipp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arriendomaquinariamenor.practicaipp.Model.Usuario;
import com.arriendomaquinariamenor.practicaipp.Repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    IUsuarioRepository usuarioRepository;

    //Get
    @Override
    public List<Usuario> verUsuarios() {
        return usuarioRepository.findAll();
    }
        
    

    @Override 
    public Usuario crearUsuario(Usuario usuario){
        Usuario usu =  usuarioRepository.save(usuario);
        return usu;
    }

    //Get x id
    @Override
    public Usuario verUsuario(Long id){
        Usuario usu = usuarioRepository.findById(id).orElse(null);
        return usu;
    }

    //Delete
    @Override
    public String  eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
        return "Usuario eliminado con exito";
    }

    //Put
    @Override
    public Usuario editarUsuario(Long id, String nuevo_nombre, String nuevo_apellido, int nuevo_rut, String nueva_direccion){
        Usuario usuario = this.verUsuario(id);

        usuario.setNombre(nuevo_nombre);
        usuario.setApellido(nuevo_apellido);
        usuario.setRut(nuevo_rut);
        usuario.setDireccion(nueva_direccion);
        
        this.crearUsuario(usuario);

        return usuario;

        
    }




}
