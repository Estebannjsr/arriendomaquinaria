window.onload = function(){
    listasPeliculas();
}


let listasPeliculas = async ()=>{
    const peticion = await fetch("http://localhost:8080/maquinas/ver",
        {
            method: "GET",
            headers:{
                "Accept": "application/json",
                "Content-Type": "application/json"
            }
        } );

        const maquinas = await peticion.json();

        let contenidoTabla = "";
        for(let maquina of maquinas){
            let contenidoFila = `<tr>
            <td>${maquina.id}</td>
            <td>${maquina.nombre}</td>
            <td>${maquina.marca}</td>
            <td>${maquina.estado}</td>
            <td>
            <i onClick="editarmaquina(${maquina.id})" class="material-icons button edit">edit</i>

            <i onClick="borrarMaquina(${maquina.id})" class="material-icons button delete">delete</i>
            </td>
            </tr>
            `
            contenidoTabla += contenidoFila;
        }

        document.querySelector("#tabla tbody").outerHTML = contenidoTabla;
}

let borrarMaquina = async (id)=>{
    const peticion = await fetch(`http://localhost:8080/maquinas/eliminar/${id}`, {
        method: "DELETE",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        }
    });

        listasPeliculas();


    }

    let editarmaquina = async (id) => {
        mostrarFormulario();
    
        idEditar = id; // Aquí ahora id estará definido porque se recibe como parámetro
    
        // Realizas la petición a la API usando el id que se pasa como parámetro
        const peticion = await fetch(`http://localhost:8080/maquinas/ver/${id}`, {
            method: "GET",
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            }
        });
    
        // Obtienes la respuesta de la API
        const maquina = await peticion.json();
    
        // Asignas el valor al campo de texto del formulario
        document.getElementById("nombre").value = maquina.nombre;
        document.getElementById("marca").value = maquina.marca;
        document.getElementById("estado").value = maquina.estado;

        let btnmodificar = document.getElementById("boton");
    }

    let aplicarActualizacion =  async(id)=>{
        let campos = {};
        campos.id = id;
        campos.nombre = document.getElementById("nombre").value;
        campos.marca = document.getElementById("marca").value;
        campos.estado = document.getElementById("estado").value;
    
        const p = await fetch("http://localhost:8080/maquinas/ver   ")
    
    }


    
    // Función para mostrar el formulario
    function mostrarFormulario() {
        let formulario = document.getElementById("formulario").style.visibility = "visible";
    }
    