var mascotass=[];

function list(){
    $("#tblMascota").empty(); //Eliminar el contenido del tbody de la tabla    
    mascotass.forEach(mascota => {   
        $("#tblMascota").append('<tr>'   
            + '<td>' + mascota.nombre +'</td>'
            + '<td>' + mascota.tipo +'</td>'         
            + '<td>' + mascota.edad +'</td>'
            + '<td>' + mascota.genero +'</td>'   
            + '<td>' + mascota.idMascota +'</td>'                                  
        +'</tr>');       
    });
}

function add(){
    let mascota = {
        "nombre" : $("#txtNombreM").val(),
        "tipo" : $("#txtTipo").val(),
        "edad":$("#txtEdad").val(),
        "genero":$("#txtGenero").val(),
        "idMascota":$("#txtIdMascota").val(),
    }
    mascotass.push(mascota);
    list();
}

function set(propietario){
    $("txtNombre").val(propietario.nombre);
    $("txtCedula").val(propietario.cedula);
    $("txtCelular").val(propietario.celular);
    $("txtCorreo").val(propietario.correo);
    $("txtIdPropietario").val(propietario.idPropietario)
}


function serializeForm(){
    let propietario = {
        "nombre" : $("#txtNombre").val(),
        "cedula" : $("#txtCedula").val(),
        "celular" : $("#txtCelular").val(),
        "correo" : $("#txtCorreo").val(),
        "idPropietario":$("#txtIdPropietario").val(),
        "mascotass" : mascotass
    };
    return propietario;
}




function save(){    
    //Creando el objeto
    var propietario = serializeForm(); 
    console.log(propietario);   
    var requestBody = JSON.stringify(propietario);
    console.log(requestBody);    
    //Utilizar jQuery AJAX para enviar al Backend

    if(propietario.idPropietario==0){
        alert("si entra propietario create");
        $.ajax({  
            type: "POST", 
            url: "http://localhost:8080/propietario/create", 
            data: requestBody, 
            contentType : "application/json",
            crossDomain: true,
            dataType: "json",
            success : function(response){
                console.log(response);         
            },
            error : function(err){
                console.error(err);
            }        
        });
    }
    else{
        let id = propietario.idPropietario;
        alert("si entra update propietario ")
        $.ajax({        
            type: "PUT", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/propietario/update/" + id, //Dirección para realizar la petición HTTP
            data: requestBody, //El contenido Body de la petición HTTP                
            contentType : "application/json",
            crossDomain: true,
            dataType: "json",
            success : function(response){
                console.log(response);             
		    },
		    error : function(err){
			    console.error(err);
		    }            
        });
    }
    
}


$(function() {       

    $("#btnAgregar").click(function(){
        alert("funciona el add");
        add();
    });

    $('#frmPropietario').on('submit', function() {
        alert("funsiona el frmPropietario");
        var form = document.getElementById('frmPropietario');
        var a = form.checkValidity();
        console.log(a);
        if(a){
            save();
        }
    }); 

});