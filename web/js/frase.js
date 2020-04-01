$("#botao-frase").click(fraseAleatoria);

function fraseAleatoria() {
    $("#spinner").toggle();
    
    var indice = {indice : null}; // Caso queira pegar por um indice expecifico

    $.get("http://localhost:8080/frase", indice,  trocaFraseAleatoria)
    .fail(function(){
    	$("#erro").toggle();
    	setTimeout(function(){
    		$("#erro").toggle();
    	},1500);
    })
    .always(function(){
    	$("#spinner").toggle();
    });
}

function trocaFraseAleatoria(data) {

    var texto = data.split("-")[0];
    var tempo = data.split("-")[1];

    $(".frase").text(texto);
    atualizaTamanhoFrase();
    atualizaTempoInicial(tempo);
}
