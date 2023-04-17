function changeScreenAnimation(app, element) {
    element.addEventListener('click', (e) => {
        e.preventDefault();

        let urlLink = element.getAttribute('href');

        setInterval(() => {
            app.classList.remove('load-page')
        }, 10)

        app.classList.add('close-page')

        setInterval(() => {
            window.location.href = urlLink;
        }, 1000)
    })
}