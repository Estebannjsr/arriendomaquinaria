let verMaquinas = async () => {
    try {
        const response = await fetch("http://localhost:8080/maquinas/ver");
        
        if (response.ok) {
            const maquinas = await response.json();
            const maquinasList = document.getElementById("maquinas-list");

            maquinas.forEach(maquina => {
                const listItem = document.createElement("li");

                // Crear un contenedor para los detalles de la máquina
                listItem.innerHTML = `
                    <span>Nombre: <strong>${maquina.nombre}</strong></span>
                    <span>Marca: <strong>${maquina.marca}</strong></span>
                    <span>Estado: <strong>${maquina.estado}</strong></span>
                `;
                
                maquinasList.appendChild(listItem);
            });
        } else {
            console.error('Error al obtener las máquinas');
        }
    } catch (error) {
        console.error('Error de red:', error);
    }
};

// Ejecutar la función al cargar la página
document.addEventListener("DOMContentLoaded", verMaquinas);
