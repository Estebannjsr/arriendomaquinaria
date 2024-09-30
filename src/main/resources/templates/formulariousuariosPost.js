// creamos el metodo crearMaquina antes
let crearUsuarios = async () => {
    let campos = {}; 
    // Guardamos dentro los elementos por el id del formulario y con .value rescatamos los valores
    campos.nombre = document.getElementById("nombre").value;
    campos.apellido = document.getElementById("apellido").value;
    campos.rut = document.getElementById("rut").value;
    campos.direccion = document.getElementById("direccion").value;

    try {
        const peticion = await fetch("http://localhost:8080/usuarios/crear", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(campos)
        });

        if (peticion.ok) {
            // Aquí puedes procesar la respuesta si es exitosa
            alert('Usuario creado correctamente');
        } else {
            console.log('Error al crear el Usuario');
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
        crearUsuarios();
    });
} else {
    console.error('Botón no encontrado');
}
