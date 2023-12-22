// VALOR BASE DEL TICKET
const ticket = 200;

// DESCUENTOS DISPONIBLES
const descEstudiante = 0.80;
const descTrainee = 0.50;
const descJunior = 0.15;


const nombre = document.getElementById('nombre');
const apellido = document.getElementById('apellido');
const email = document.getElementById('email');
const cantidad = document.getElementById('cantidad');
const categoria = document.getElementById('categoria');
const totalPagar = document.getElementById('totalAPagar');
const btnResumen = document.getElementById('resumen');
const btnBorrar = document.getElementById('borrar')

function calcularPago() {

    let total = cantidad.value * ticket;


    switch (categoria.value) {
        case "estudiante":
            total = total - (total * descEstudiante);
            break;
        case "trainee":
            total = total - (total * descTrainee);
            break;
        case "junior":
            total = total - (total * descJunior);
            break;
    }

    totalPagar.textContent = `Total a Pagar: $ ${total}`;

}
function borrarCasillas(){
    nombre.value = "";
    apellido.value = "";
    email.value ="";
    cantidad.value = "";
    totalPagar.value = 'Total a Pagar: $';
    categoria.value = "sinCategoria"
}

btnResumen.addEventListener('click', (e) => {
    e.preventDefault();
    calcularPago();
});

btnBorrar.addEventListener('click', (e)=> {
    e.preventDefault()
    borrarCasillas()
});