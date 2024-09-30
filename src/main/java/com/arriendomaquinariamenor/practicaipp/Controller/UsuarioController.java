package com.arriendomaquinariamenor.practicaipp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arriendomaquinariamenor.practicaipp.Model.Usuario;
import com.arriendomaquinariamenor.practicaipp.Service.IUsuarioService;




@RestController
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;


    //Get
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/usuarios/ver")
    public List<Usuario> verUsuarios(){
      return usuarioService.verUsuarios();
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/usuarios/ver/{id}")
    public Usuario veUsuario(@PathVariable Long id) {
        return usuarioService.verUsuario(id);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping("/usuarios/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @CrossOrigin("http://127.0.0.1:5500")
    @DeleteMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id){
        return usuarioService.eliminarUsuario(id);
    }

    @CrossOrigin("http://127.0.0.1:5500")
     @PutMapping("/usuarios/editar/{id}")
        public Usuario editarUsuario(@PathVariable Long id, @RequestParam String nuevo_nombre, @RequestParam String nuevo_apellido, @RequestParam int nuevo_rut, @RequestParam String nueva_direccion ) {
         return usuarioService.editarUsuario(id, nuevo_nombre, nuevo_apellido, nuevo_rut, nueva_direccion);
     }
    
    

    
    
}
