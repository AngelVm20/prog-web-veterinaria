//Arreglos de objetos
var provincias=[];

//tutoria
//ilustra un forEach, muestra los elementos del arreglo en consola
//la flecha es la implementacion de x, se utiliza en las funciones callback
function mostrar(){
    //puede poner condiciones como, solo los nombres, en ese caso => x.nombre
    provincias.forEach((x)=>
        console.log(x));
        //console.log(x.nombre) ejemplo de solo lo que quiero mostrar
}

function filtrar(){
    var filtro=document.getElementById('txtFiltro').value;
    var result=provincias.filter( (x)=> x.nombre.includes(filtro));
    console.log(result);
}
//filtra los menores dependiendo del valor ingresado
function filtrarPorcentaje(){
    var strfiltro=document.getElementById('txtFiltroPorcentaje').value;
                                    //aqui esta el condicional para el filtro
    var result=provincias.filter( (x)=> x.porcentaje < parseFloat(strfiltro));
    console.log(result);
}




function imprimir(){
    console.log(provincias);
    let tbProvincias=document.getElementById('tblProvincias');
    tbProvincias.innerHTML = '';
    //x representa un elemento del arreglo
    //forEach un bucle
    provincias.forEach((x)=>{
        let tr=document.createElement('tr');
        let tdNum=document.createElement('td');
        let tdNom=document.createElement('td');
        let tdConf=document.createElement('td');
        let tdFall=document.createElement('td');
        let tdPro=document.createElement('td');
        let tdPor=document.createElement('td');
        //Asignar Valores
        tdNum.innerText=provincias.indexOf(x)+1;
        tdNom.innerText=x.nombre;
        tdConf.innerText=x.confirmados;
        tdFall.innerText=x.fallecidos;
        tdPro.innerText=x.probables;
        tdPor.innerText=x.porcentaje;
        //agrega las columnas a las filas
        tr.append(tdNum);
        tr.append(tdNom);
        tr.append(tdConf);
        tr.append(tdFall);
        tr.append(tdPro);
        tr.append(tdPor);
        tbProvincias.append(tr);
    });
    sumarConfirmados();
    sumarFallecidos();
    sumarProbables();
}
//metodo agregar
function agregar(){
    //lectura de valores en los input
    let conf=document.getElementById('txtConfirmados').value;
    let fall=document.getElementById('txtFallecidos').value;
    let fallpro=document.getElementById('txtFallecidosProbables').value;
    let nomPro=document.getElementById('slProvincia').value;
    let por=document.getElementById('txtPorcentaje').value;
    //crear objeto con los valores
    let nuevaProvincia={
        "nombre":nomPro,
        "confirmados": parseInt(conf),
        "fallecidos": parseInt (fall),
        "probables": parseInt (fallpro),
        "porcentaje": parseFloat (por)

    };
    //agregar el objeto al arreglo
    provincias.push(nuevaProvincia);
    borrar();
    imprimir();
}
function borrar(){
    document.getElementById('txtConfirmados').value=0;
    document.getElementById('txtFallecidos').value=0;
    document.getElementById('txtFallecidosProbables').value=0;
    document.getElementById('txtPorcentaje').value=0;
    document.getElementById('slProvincia').value=0;
}
function sumarConfirmados(){
    let totalConfirmados=0;
    provincias.forEach((x)=>{
        totalConfirmados=totalConfirmados+x.confirmados;
    });
    let tbTotalConfirmados=document.getElementById('tdTotalConfirmados');
    tbTotalConfirmados.innerText=totalConfirmados;
}
function sumarFallecidos(){
    let totalFallecidos = 0;
    provincias.forEach((x)=>{
        totalFallecidos = totalFallecidos + x.fallecidos;
    });
    let tbTotalFallecidos = document.getElementById('tdTotalFallecidos');
    tbTotalFallecidos.innerText = totalFallecidos;
}


function sumarProbables(){
    let totalProbables = 0;
    provincias.forEach((x)=>{
        totalProbables = totalProbables + x.probables;
    });
    let tbTotalProbables = document.getElementById('tdTotalProbables');
    tbTotalProbables.innerText = totalProbables;
}