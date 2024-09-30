let verMaquinas = async () => {
    try {
        const response = await fetch("http://localhost:8080/maquinas/ver");
        
        if (response.ok) {
            const maquinas = await response.json();
            const maquinasList = document.getElementById("maquinas-list");

            maquinas.forEach(maquina => {
                const listItem = document.createElement("li");
                listItem.innerHTML = `
                    <div class="maquina-card">
                        <h3>${maquina.nombre}</h3>
                        <p>Marca: ${maquina.marca}</p>
                        <p>Estado: ${maquina.estado}</p>
                        <a href="verMaquina.html?id=${maquina.id}">Ver detalles</a>
                    </div>
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
