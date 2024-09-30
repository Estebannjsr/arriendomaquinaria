window.onload = function() {
    listarUsuarios();
}

let listarUsuarios = async () => {
    const peticion = await fetch("http://localhost:8080/usuarios/ver", {
        method: "GET",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        }
    });

    const usuarios = await peticion.json();
    let contenidoTabla = "";

    for (let usuario of usuarios) {
        let contenidoFila = `<tr>
            <td>${usuario.id_usuario || 'No disponible'}</td>
            <td>${usuario.nombre || 'No disponible'}</td>
            <td>${usuario.apellido || 'No disponible'}</td>
            <td>${usuario.rut || 'No disponible'}</td>
            <td>${usuario.direccion || 'No disponible'}</td>
            <td>
                <i onClick="editarUsuario(${usuario.id_usuario})" class="material-icons button edit">edit</i>
                <i onClick="borrarUsuario(${usuario.id_usuario})" class="material-icons button delete">delete</i>
            </td>
        </tr>`;
        contenidoTabla += contenidoFila;
    }

    document.querySelector("#tabla tbody").innerHTML = contenidoTabla;
}

let borrarUsuario = async (id_usuario) => {
    const peticion = await fetch(`http://localhost:8080/usuarios/eliminar/${id_usuario}`, {
        method: "DELETE",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        }
    });

    // Manejo de respuesta
    if (peticion.ok) {
        console.log("Usuario eliminado con éxito");
        listarUsuarios(); // Actualiza la lista de usuarios después de eliminar
    } else {
        console.error("Error al eliminar el usuario:", peticion.statusText);
    }
};

let editarUsuario = async (id_usuario) => {
    mostrarFormulario();

    const peticion = await fetch(`http://localhost:8080/usuarios/ver/${id_usuario}`, {
        method: "GET",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        }
    });

    const usuario = await peticion.json();

    // Asignar los valores del usuario al formulario
    document.getElementById("nombre").value = usuario.nombre;
    document.getElementById("apellido").value = usuario.apellido;
    document.getElementById("rut").value = usuario.rut;
    document.getElementById("direccion").value = usuario.direccion;

    // Cambiar el comportamiento del botón para actualizar
    let btnmodificar = document.getElementById("boton");
    btnmodificar.onclick = () => aplicarActualizacion(id);
}

let aplicarActualizacion = async (id_usuario) => {
    let campos = {};
    campos.nombre = document.getElementById("nombre").value;
    campos.apellido = document.getElementById("apellido").value;
    campos.rut = document.getElementById("rut").value;
    campos.direccion = document.getElementById("direccion").value;

    const peticion = await fetch(`http://localhost:8080/usuarios/editar/${id_usuario}`, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(campos)
    });

    if (peticion.ok) {
        alert('Usuario actualizado correctamente');
        listarUsuarios(); // Actualiza la lista de usuarios
    } else {
        console.log('Error al actualizar el usuario');
    }
}

// Función para mostrar el formulario
function mostrarFormulario() {
    document.getElementById("formulario").style.visibility = "visible";
}
