
function set(doctor){
    $("txtLicencia").val(doctor.licencia);
    $("txtEspecialidad").val(doctor.especialidad);
    $("txtNombreD").val(doctor.nombre);
    $("txtCedula").val(doctor.cedula);
    $("txtIdDoctor").val(doctor.idDoctor)
}0


function serializeForm(){
    let doctor ={
        "licencia":$("#txtLicencia").val(),
        "especialidad":$("#txtEspecialidad").val(),
        "nombre":$("#txtNombreD").val(),
        "cedula":$("#txtCedula").val(),
        "idDoctor":$("#txtIdDoctor").val()
    };
    return doctor;
}

function save(){
    var doctor=serializeForm();
    console.log(doctor);
    var requestBody = JSON.stringify(doctor);
    console.log(requestBody);

    if(doctor.idDoctor == 0){
        $.ajax({        
            type: "POST", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/doctor/create", //Dirección para realizar la petición HTTP
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
    else{
        //Update
        let id = doctor.idDoctor;
        $.ajax({        
            type: "PUT", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/doctor/update/" + id, //Dirección para realizar la petición HTTP
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

    $('#frmDoctor').on('submit', function() {
        var form = document.getElementById('frmDoctor');
        var a = form.checkValidity();
        console.log(a);
        if(a){
            save();
        }
    });   
});
