//Formatação do contato
const contato = document.querySelector(".contato");

contato.addEventListener("focusout", function () {
    let textoContato = contato.value;

    switch (textoContato.length) {
        case 10:
            {
                let ddd = textoContato.substr(0, 2);
                let beforeDash = textoContato.substr(2, 4);
                let afterDash = textoContato.substr(6, 4);

                contato.value = `(${ddd}) ${beforeDash}-${afterDash}`;
                textoContato = contato.value;
            }
            break;

        case 11:
            {
                let ddd = textoContato.substr(0, 2);
                let beforeDash = textoContato.substr(2, 5);
                let afterDash = textoContato.substr(7, 4);

                contato.value = `(${ddd}) ${beforeDash}-${afterDash}`;
                textoContato = contato.value;
            }
            break;

        default:
            {
                if (textoContato.length > 0 && (!textoContato.startsWith("(") || textoContato.length != 15 && textoContato.length != 14)) {
                    alert("Por favor verifique o contato, digite apenas números com o DDD.");
                }
            }
            break;
    }
});

//Formatação da data de nascimento 
const dataNascimento = document.querySelector(".data-nascimento");
const form = document.querySelector("form");

dataNascimento.addEventListener("focusout", function () {

    dataNascimento.value = dataNascimento.value.replaceAll("/", "");

    let dataNascimentoSplitted = dataNascimento.value.split("");

    if (dataNascimentoSplitted.length != 8 && dataNascimentoSplitted.length > 0) {
        alert("Por favor verifique a data de nascimento, digite apenas os números no formato dd/mm/aaaa.");
    } else if (dataNascimentoSplitted.length > 0 && dataNascimentoSplitted.length == 8) {

        let day = dataNascimentoSplitted[0] + dataNascimentoSplitted[1];
        let month = dataNascimentoSplitted[2] + dataNascimentoSplitted[3];
        let year = dataNascimentoSplitted[4] + dataNascimentoSplitted[5] + dataNascimentoSplitted[6] + dataNascimentoSplitted[7];
        dataNascimento.value = `${day}/${month}/${year}`;
    }
});

form.addEventListener("submit", function (e) {
    const nome = document.querySelector(".nome");

    if (nome.value == "") {
        alert('O Nome não pode estar vazio.')
        e.preventDefault();
    }

    if (dataNascimento.value.length > 0 && dataNascimento.value.length == 10) {
        let dataNascimentoSplitted = dataNascimento.value.split("/");
        dataNascimento.value = `${dataNascimentoSplitted[2]}-${dataNascimentoSplitted[1]}-${dataNascimentoSplitted[0]}`;
    }
});