$("#botao-placar").click(mostraPlacar);

function inserePlacar() {
    var corpoTabela = $(".placar").find("tbody");
    var usuario = "Ygor Kayan"
    var numPalavras = $("#contador-palavras").text();

    var linha = novaLinha(usuario, numPalavras);
    linha.find(".botao-remover").click(removeLinha);

    corpoTabela.append(linha);
    $(".placar").slideDown(500);
    scrollPlacar();
}

function scrollPlacar() {
    var posicaoPlacar = $(".placar").offset().top;
    $("body").animate(
        {
            scrollTop: posicaoPlacar + "px"
        }, 1000);
}

function novaLinha(usuario, palavras) {
    var linha = $("<tr>");
    var colunaUsuario = $("<td>").text(usuario).addClass("usuario");
    var colunaPalavras = $("<td>").text(palavras).addClass("pontuacao");
    var colunaRemover = $("<td>");

    var link = $("<a>").addClass("botao-remover").attr("href", "#");
    var icone = $("<i>").addClass("small").addClass("material-icons").text("delete");

    link.append(icone);

    colunaRemover.append(link);

    linha.append(colunaUsuario);
    linha.append(colunaPalavras);
    linha.append(colunaRemover);

    return linha;
}

function removeLinha() {
    event.preventDefault();
    var linha = $(this).parent().parent();

    linha.fadeOut(1000);
    setTimeout(function () {
        linha.remove();
    }, 1000);
}

function mostraPlacar() {
    $(".placar").stop().slideToggle(600);
}



$("#botao-sicronismo").click(function () {
    salvarPlacar();
})


function salvarPlacar() {

    var listaPlacar = [];
    var linhas = $("tbody>tr");

    linhas.each(function () {
        var nome = $(this).find("td:nth-child(1)").text();
        var palavras = $(this).find("td:nth-child(2)").text();

        listaPlacar.push(nome + "-" + palavras)
    });

    var dados = {
        placar: listaPlacar
    }

    $.post("http://localhost:8080/placar", dados, function () {
        console.log("salvo");
    })

}


function atualizarPlacar() {
    $.get("http://localhost:8080/placar", function(data) {
    
        data.forEach(function(linha) {
            var linha = novaLinha(linha.nome, linha.pontuaçao);
            linha.find(".botao-remover").click(removeLinha);
            $("tbody").append(linha);
        })
    })
}

