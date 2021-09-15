function retrieve(id){
        
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/doctor/retrieve/" + id, //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            alert("si entra");
            console.log(response);    
            let doctor = response;            
            $("#lblNombre").html(doctor.numero);
            $("#spLicencia").html(doctor.licencia);
            $("#spEspecialidad").html(doctor.especialidad);
            $("#spNombre").html(doctor.nombre);
            $("#spCedula").html(doctor.cedula);
            $("#txtIdDoctor").val(doctor.idDoctor);
            
        },
		error : function(err){
			console.error(err);
		}
    });
}

function show(lista){ 
    $("#tblDoctor").empty(); //Eliminar el contenido del tbody de la tabla
    lista.forEach(doctor => {        
        $("#tblDoctor").append('<tr>'            
            + '<td>' + doctor.licencia +'</td>'
            + '<td>' + doctor.especialidad +'</td>'
            + '<td>' + doctor.nombre +'</td>'
            + '<td>' + doctor.cedula +'</td>'          
            //Boton de consultar
            + '<td>'
            + '<button onclick="retrieve('+ doctor.idDoctor +')" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#mdDoctor">Consultar</button>'
            + '</td>'                        
        +'</tr>');
    });
}

function list(){
    //Utilizar jQuery AJAX para enviar al Backend
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/doctor/list", //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);
            show(response);
		},
		error : function(err){
			console.error(err);
		},
        complete: function(xhr, textStatus) {            
            if(xhr.status == 404){
                alert(xhr.responseText);
            }
            if(xhr.status == 500){
                alert(xhr.responseText);
            }
        }          
    });
}

function del(){
    let id = $("#txtIdDoctor").val();
    $.ajax({        
        type: "DELETE", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/doctor/delete/" + id, //Dirección para realizar la petición HTTP        
        contentType : "application/json",        
        success : function(response){
            console.log(response);                            
		},
		error : function(err){
			console.error(err);
		},
        complete : function(xhr, textStatus){
            if(xhr.status == 200)
            {
                alert(xhr.responseText);
                list();         
            }            
        }   
    });
}

$( document ).ready(function() {    
    list();
    $("#btnEliminar").click(function(){        
        del();
    });
});