function retrieve(id){
    alert("entra el retrieve mascotas");
    $.ajax({  
        type: "GET",
        url: "http://localhost:8080/mascota/retrieve/" + id,        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);    
            let mascota = response;            
            $("#lblNombre").html(mascota.numero);
            $("#spNombre").html(mascota.nombre);
            $("#spTipo").html(mascota.tipo);
            $("#spEdad").html(mascota.edad);
            $("#spGenero").html(mascota.genero);
            $("#txtIdMascota").val(mascota.idMascota);
            
        },
		error : function(err){
			console.error(err);
		}
    });
    alert("sale el retrieve mascotas");
} 


function show(lista){ 
    $("#tblPropietario").empty(); 
    lista.forEach(propietario => {        
        $("#tblPropietario").append('<tr>'            
            + '<td>' + propietario.nombre +'</td>'
            + '<td>' + propietario.cedula +'</td>'
            + '<td>' + propietario.celular +'</td>'
            + '<td>' + propietario.correo +'</td>'
            //Boton de consultar
            + '<td>'
            + '<button onclick="retrieve('+ propietario.idPropietario +')" type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#mdPropietario">Consultar</button>'
            + '</td>'                        
        +'</tr>');
    });
}

function list(){
    alert("entra la propietario list");
    
    $.ajax({        
        type: "GET", 
        url: "http://localhost:8080/propietario/list",      
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
    let id = $("#txtIdMascota").val();
    $.ajax({        
        type: "DELETE", 
        url: "http://localhost:8080/mascota/delete/" + id,       
        contentType : "application/json",        
        success : function(response){
            console.log(response);                            
		},
		error : function(err){
			console.error(err);
		}        
    });
}

$( document ).ready(function() {    
    list();
    $("#btnEliminar").click(function(){        
        del();
    });
}); 

