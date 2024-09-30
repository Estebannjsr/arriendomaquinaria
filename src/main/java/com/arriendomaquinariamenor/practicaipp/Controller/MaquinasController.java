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

import com.arriendomaquinariamenor.practicaipp.Model.Maquinas;
import com.arriendomaquinariamenor.practicaipp.Service.IMaquinasService;




@RestController
public class MaquinasController {
    @Autowired 
    IMaquinasService maquinaservice;

    //Get
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/maquinas/ver")
    public List<Maquinas> verMaquinas() {
        return  maquinaservice.verMaquinas();
    }

    //Get 
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/maquinas/ver/{id}")
    public Maquinas getMethodName(@PathVariable Long id) {
        Maquinas maquina = maquinaservice.verMaquina(id);
        return maquina;

    }
    




    //Post
    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping("/maquinas/crear")
    public Maquinas crearMaquina(@RequestBody Maquinas maquina) {
        maquinaservice.crearMaquina(maquina);
        return maquina;
    }

    //Delete
    @CrossOrigin("http://127.0.0.1:5500")
    @DeleteMapping("/maquinas/eliminar/{id}")
    public String eliminarMaquinas(@PathVariable Long id){
        maquinaservice.eliminarMaquinas(id);
        return "La maquina se ha eliminado con exito";
    }
    @CrossOrigin("http://127.0.0.1:5500")
    @PutMapping("/maquinas/editar/{id}")
    public Maquinas editarMaquina(@PathVariable Long id, 
    @RequestParam(required= false, name="nombre") String nuevo_nombre,
     @RequestParam(required= false, name="marca") String nueva_marca,
     @RequestParam (required= false, name="estado")String nuevo_estado){
    maquinaservice.editarMaquina(id, nuevo_nombre, nueva_marca, nuevo_estado);
    
    Maquinas maquina = maquinaservice.verMaquina(id);
    return maquina;
    }
    
    
    
}
