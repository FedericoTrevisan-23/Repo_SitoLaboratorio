const canvas = document.getElementById('pianoCartesiano');
const ctx = canvas.getContext('2d');
const width = canvas.width;
const height = canvas.height;

// Impostazioni della telecamera e dello zoom
const centroX = width / 2;
const centroY = height / 2;
const scala = 40; // 40 pixel rappresentano 1 unità (es. da 0 a 1)

// Trasforma il testo dell'utente in una funzione matematica eseguibile da JS
function creaFunzioneJS(espressione) {
    // Sostituisce il simbolo della potenza (^) con quello di JS (**)
    let formula = espressione.replace(/\^/g, '**');
    
    // Aggiunge "Math." davanti alle funzioni matematiche classiche
    const funzioniMatematiche = ['sin', 'cos', 'tan', 'log', 'exp', 'sqrt', 'abs'];
    funzioniMatematiche.forEach(f => {
        // Usa una RegExp per trovare la parola esatta e sostituirla
        formula = formula.replace(new RegExp('\\b' + f + '\\b', 'g'), 'Math.' + f);
    });

    // Ritorna una funzione reale in JavaScript
    // es: se l'utente scrive "sin(x)", diventa una funzione che ritorna "Math.sin(x)"
    return new Function('x', 'return ' + formula + ';');
}

// Disegna gli assi X e Y e la griglia
function disegnaAssi() {
    ctx.clearRect(0, 0, width, height); // Pulisci la lavagna

    ctx.strokeStyle = '#e0e0e0';
    ctx.lineWidth = 1;

    // Disegna la griglia di sfondo
    for (let i = 0; i <= width; i += scala) {
        ctx.beginPath(); ctx.moveTo(i, 0); ctx.lineTo(i, height); ctx.stroke();
        ctx.beginPath(); ctx.moveTo(0, i); ctx.lineTo(width, i); ctx.stroke();
    }

    ctx.strokeStyle = '#000000';
    ctx.lineWidth = 2;

    // Asse X
    ctx.beginPath();
    ctx.moveTo(0, centroY);
    ctx.lineTo(width, centroY);
    ctx.stroke();

    // Asse Y
    ctx.beginPath();
    ctx.moveTo(centroX, 0);
    ctx.lineTo(centroX, height);
    ctx.stroke();
}

// Calcola e disegna la curva
function disegnaGrafico() {
    disegnaAssi(); // Ridisegna lo sfondo fresco

    const inputUtente = document.getElementById('funzione').value;
    if (!inputUtente) return;

    let f;
    try {
        f = creaFunzioneJS(inputUtente);
    } catch (e) {
        alert("Errore nella formula! Controlla la sintassi.");
        return;
    }

    ctx.beginPath();
    ctx.strokeStyle = 'red'; // Colore della funzione
    ctx.lineWidth = 2;

    // Disegniamo la funzione pixel per pixel da sinistra a destra
    for (let px = 0; px < width; px++) {
        // 1. Converto la X del pixel (es. da 0 a 600) nella X matematica (es. da -7.5 a +7.5)
        let xMatematica = (px - centroX) / scala;
        
        // 2. Calcolo la Y matematica usando la funzione
        let yMatematica = f(xMatematica);
        
        // 3. Converto la Y matematica indietro in un pixel del Canvas
        // (Sottraggo perché nei Canvas la Y cresce verso il basso!)
        let py = centroY - (yMatematica * scala);

        // Se è il primo punto, sposto la penna lì, altrimenti tiro una riga
        if (px === 0) {
            ctx.moveTo(px, py);
        } else {
            ctx.lineTo(px, py);
        }
    }
    
    ctx.stroke(); // Renderizza la linea
}

// Esegui la prima volta appena la pagina viene caricata
disegnaGrafico();