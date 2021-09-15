function retrieve(id){
    alert("entra el retrieve receta");
    $.ajax({  
        type: "GET",
        url: "http://localhost:8080/receta/retrieve/" + id,        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            console.log(response);    
            let receta= response;            
            $("#lblNombreR").html(receta.numero);
            $("#spMedicamento").html(receta.medicamento);
            $("#spDosis").html(receta.dosis);

            $("#txtIdReceta").val(receta.idReceta);
            
        },
		error : function(err){
			console.error(err);
		}
    });
    alert("sale el retrieve receta");
} 


function show(lista){ 
    $("#tblConsulta").empty(); 
    lista.forEach(consulta => {        
        $("#tblConsulta").append('<tr>'            
            + '<td>' + consulta.sintoma +'</td>'
            + '<td>' + consulta.diagnostico +'</td>'
            + '<td>' + consulta.fechaHora +'</td>'
            + '<td>' + consulta.monto +'</td>'
            //Boton de consultar
            + '<td>'
            + '<button onclick="retrieve('+ consulta.idConsulta +')" type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#mdConsulta">Consultar</button>'
            + '</td>'                        
        +'</tr>');
    });
}

function list(){
    alert("entra la consulta list");
    
    $.ajax({        
        type: "GET", 
        url: "http://localhost:8080/consulta/list",      
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
    let id = $("#txtIdReceta").val();
    $.ajax({        
        type: "DELETE", 
        url: "http://localhost:8080/receta/delete/" + id,       
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

