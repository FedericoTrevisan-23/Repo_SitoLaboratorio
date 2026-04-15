const canvas = document.getElementById('myCanvas');
const ctx = canvas.getContext('2d');
const width = canvas.width;
const height = canvas.height;

// margini interni (20px) per non disegnare attaccato ai bordi
const offsetX = 20; 
const offsetY = height - 20; 
const scale = width - 40; // "raggio = 1" misurato in pixel (460px)

// funzione matematica f(x) = radice_quadrata(1 - x^2)
function f(x) {
    return Math.sqrt(1 - (x * x));
}

// Disegna l'asse cartesiano e la linea curva (l'arco di circonferenza)
function disegnaSistema() {
    ctx.clearRect(0, 0, width, height); // Pulisce la lavagna
    
    // Disegna Asse X e Asse Y
    ctx.beginPath();
    ctx.moveTo(offsetX, 0);                 // Asse Y (verticale)
    ctx.lineTo(offsetX, height);
    ctx.moveTo(0, offsetY);                 // Asse X (orizzontale)
    ctx.lineTo(width, offsetY);
    ctx.strokeStyle = '#000';
    ctx.lineWidth = 2;
    ctx.stroke();

    // Disegna l'arco di circonferenza pixel per pixel
    ctx.beginPath();
    for(let px = 0; px <= scale; px++) {
        let x = px / scale;                 // Trasforma il pixel in un valore tra 0 e 1
        let y = f(x);                       // Calcola l'altezza y
        
        let cx = offsetX + px;              // Mappa la x sul Canvas
        let cy = offsetY - (y * scale);     // Mappa la y sul Canvas (sottraggo perché la Y del Canvas scende)
        
        if (px === 0) ctx.moveTo(cx, cy);
        else ctx.lineTo(cx, cy);
    }
    ctx.strokeStyle = 'blue';
    ctx.lineWidth = 2;
    ctx.stroke();
}

// Funzione principale che crea i trapezi e fa i conti
function eseguiCalcolo() {
    // Prendo il numero di trapezi dall'input HTML
    let n = parseInt(document.getElementById('inputN').value);
    if(isNaN(n) || n < 1) n = 1;

    disegnaSistema(); // Prepara lo sfondo fresco
    
    let h = 1 / n; // La larghezza della base di ogni trapezio sull'asse x
    let areaTotale = 0;

    // Ciclo per costruire i trapezi uno a uno
    for (let i = 0; i < n; i++) {
        let x0 = i * h;             // Punto x di partenza della base
        let x1 = (i + 1) * h;       // Punto x di fine della base
        
        let y0 = f(x0);             // Altezza del lato sinistro
        let y1 = f(x1);             // Altezza del lato destro
        
        // Conversione delle coordinate in coordinate Canvas (pixel)
        let cx0 = offsetX + (x0 * scale);
        let cx1 = offsetX + (x1 * scale);
        let cy0 = offsetY - (y0 * scale);
        let cy1 = offsetY - (y1 * scale);
        let base_y = offsetY;       // Il pavimento (y=0)

        // disegno trapezio
        ctx.beginPath();
        ctx.moveTo(cx0, base_y);    // Angolo in basso a sinistra
        ctx.lineTo(cx1, base_y);    // Linea fino all'angolo in basso a destra
        ctx.lineTo(cx1, cy1);       // Linea in su fino al tetto destro
        ctx.lineTo(cx0, cy0);       // Linea diagonale fino al tetto sinistro
        ctx.closePath();            // Ritorna in basso a sinistra
        
        ctx.fillStyle = 'rgba(255, 165, 0, 0.4)'; // Colore arancione con trasparenza
        ctx.fill();
        ctx.strokeStyle = '#d35400';
        ctx.lineWidth = 1;
        ctx.stroke();

        
        // Area trapezio = somma delle basi * altezza / 2
        // Nel nostro caso le "basi" sono y0 e y1 (le linee verticali), e l'"altezza" è h (la larghezza orizzontale)
        areaTotale += ((y0 + y1) * h) / 2;
    }

    // Calcolo Pi greco e aggiorno i testi nella pagina
    let piStimato = 4 * areaTotale;
    document.getElementById('area_totale').innerText = areaTotale.toFixed(6);
    document.getElementById('pi_stimato').innerText = piStimato.toFixed(6);
}

// Avvia il calcolo di default (con 5 trapezi) appena si apre la pagina
eseguiCalcolo();