let verUsuarios = async () => {
    try {
        const response = await fetch("http://localhost:8080/usuarios/ver");
        
        if (response.ok) {
            const usuarios = await response.json();
            const usuariosList = document.getElementById("maquinas-list");

            usuarios.forEach(usuario => {
                const listItem = document.createElement("li");

                // Crear un contenedor para los detalles de la máquina
                listItem.innerHTML = `
                    <span>Nombre: <strong>${usuario.nombre}</strong></span>
                    <span>Apellido: <strong>${usuario.apellido}</strong></span>
                    <span>Rut: <strong>${usuario.rut}</strong></span>
                    <span>Direccion: <strong>${usuario.direccion}</strong></span>
                `;
                
                usuariosList.appendChild(listItem);
            });
        } else {
            console.error('Error al obtener los usuarios');
        }
    } catch (error) {
        console.error('Error de red:', error);
    }
};

// Ejecutar la función al cargar la página
document.addEventListener("DOMContentLoaded", verUsuarios);
