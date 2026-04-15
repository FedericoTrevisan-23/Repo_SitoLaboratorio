document.addEventListener("DOMContentLoaded", () => {
const filterButtons = document.querySelectorAll('.filter-btn');
const cards = document.querySelectorAll('.card');

    filterButtons.forEach(button => {
        button.addEventListener('click', () => {
            // Rimuove 'active' (il colore rosso) da tutti i bottoni e lo mette su quello cliccato
            filterButtons.forEach(btn => btn.classList.remove('active'));
            button.classList.add('active');

            const filterValue = button.getAttribute('data-filter');

            cards.forEach(card => {
                // Se il filtro è 'all' (Tutti) oppure la card ha la classe corrispondente (java o html)
                if (filterValue === 'all' || card.classList.contains(filterValue)) {
                    card.style.display = 'flex'; // Mostra la card
                } else {
                    card.style.display = 'none'; // Nasconde la card
                }
            });
        });
    });
});