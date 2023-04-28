var people = document.querySelectorAll(".tr-pessoa");
var inputText = document.querySelector(".search-contact-input");

//Formatação da exibição da data de nascimento
for (let i = 0; i < people.length; i++) {
    let person = people[i];
    let personDataNascimento = person.querySelector(".td-data-nascimento");

    let dataNascimentoSplitted = personDataNascimento.textContent.split("-");

    if (!personDataNascimento.textContent == "") {
        personDataNascimento.textContent = `${dataNascimentoSplitted[2]}/${dataNascimentoSplitted[1]}/${dataNascimentoSplitted[0]}`;
    } else { }
}

//Pesquisa por nome
inputText.addEventListener("input", function () {
    let text = inputText.value;

    for (let i = 0; i < people.length; i++) {
        let person = people[i];
        let personName = person.querySelector(".td-nome").textContent;

        if (!personName.toLowerCase().includes(text.toLowerCase())) {
            person.classList.add("invisible");
        } else {
            person.classList.remove("invisible");
        }
    }
});

//Animação do delete
people.forEach(person => {
    let deleteButton = person.querySelector("#delete-button");

    deleteButton.addEventListener('click', (event) => {

        event.preventDefault();

        let urlLink = deleteButton.getAttribute('href');


        person.classList.add('delete-person');

        setInterval(() => {
            window.location.href = urlLink;
        }, 500)
    })
})

const socialMediasBtn = document.querySelectorAll(".btn-social-media");

//Oculta botões de rede social caso não tenha link
socialMediasBtn.forEach((btn) => {
    if (btn.getAttribute('href') == '')
        btn.classList.add("invisible")
})