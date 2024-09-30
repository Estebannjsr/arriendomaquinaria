// creamos el metodo crearMaquina antes
let crearMaquina = async () => {
    let campos = {}; 
    // Guardamos dentro los elementos por el id del formulario y con .value rescatamos los valores
    campos.nombre = document.getElementById("nombre").value;
    campos.marca = document.getElementById("marca").value;
    campos.estado = document.getElementById("estado").value;

    try {
        const peticion = await fetch("http://localhost:8080/maquinas/crear", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(campos)
        });

        if (peticion.ok) {
            // Aquí puedes procesar la respuesta si es exitosa
            alert('Máquina creada correctamente');
        } else {
            console.log('Error al crear la máquina');
        }
    } catch (error) {
        console.error('Error de red:', error);
    }
};

// capturamos el botón y le ponemos evento
let boton = document.getElementById("boton");

if (boton) {
    boton.addEventListener("click", evento => {
        evento.preventDefault(); // Evita que el formulario se envíe de forma tradicional
        crearMaquina();
    });
} else {
    console.error('Botón no encontrado');
}
