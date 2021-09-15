var recetass=[];

function list(){
    $("#tblReceta").empty();    
    recetass.forEach(receta => {   
        $("#tblReceta").append('<tr>'   
            + '<td>' + receta.medicamento +'</td>'
            + '<td>' + receta.dosis +'</td>'            
            + '<td>' + receta.idReceta +'</td>'                                  
        +'</tr>');       
    });
}

function add(){
    let receta = {
        "medicamento" : $("#txtMedicamento").val(),
        "dosis" : $("#txtDosis").val(),
        "idReceta":$("#txtIdReceta").val(),
    }
    recetass.push(receta);
    list();
}

function set(consulta){
    $("txtSintoma").val(consulta.sintoma);
    $("txtDiagnostico").val(consulta.diagnostico);
    $("txtFecha").val(consulta.fechaHora);
    $("txtMonto").val(consulta.monto);
    $("txtIdConsulta").val(consulta.idConsulta)
}


function serializeForm(){
    let consulta = {
        "sintoma" : $("#txtSintoma").val(),
        "diagnostico" : $("#txtDiagnostico").val(),
        "fechaHora" : $("#txtFecha").val(),
        "monto" : $("#txtMonto").val(),
        "idConsulta":$("#txtIdConsulta").val(),
        "recetass" : recetass
    };
    return consulta;
}




function save(){    
    alert("entra el save consulta");
    var consulta = serializeForm(); 
    console.log(consulta);   
    var requestBody = JSON.stringify(consulta);
    console.log(requestBody);    
    

    if(consulta.idConsulta==0){
        alert("si entra consulta create");
        $.ajax({  
            type: "POST", 
            url: "http://localhost:8080/consulta/create", 
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
        let id = consulta.idConsulta;
        alert("si entra update consulta ")
        $.ajax({        
            type: "PUT", 
            url: "http://localhost:8080/consulta/update/" + id,
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
    
}


$(function() {       

    $("#btnAgregar").click(function(){
        alert("funciona el add");
        add();
    });

    $('#frmConsulta').on('submit', function() {
        alert("funsiona el frmConsulta");
        var form = document.getElementById('frmConsulta');
        var a = form.checkValidity();
        console.log(a);
        if(a){
            save();
        }
    }); 

});