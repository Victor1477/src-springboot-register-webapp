var people = document.querySelectorAll(".tr-pessoa");
var inputText = document.querySelector(".search-contact");
const app = document.querySelector(".app");

setInterval(() => {
    app.classList.remove("start-invisible")
    app.classList.add("load-page")
}, 100)

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

//Animação de mudança de tela
const deletedOrReturnHomeLink = document.querySelector(".deleted-return-link");
const newContactButton = document.querySelector("#btn-new-contact");
changeScreenAnimation(app, deletedOrReturnHomeLink);
changeScreenAnimation(app, newContactButton);