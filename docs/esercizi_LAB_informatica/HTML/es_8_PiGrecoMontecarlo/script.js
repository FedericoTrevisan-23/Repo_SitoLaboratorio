const canvas = document.getElementById('myCanvas');
const ctx = canvas.getContext('2d');
const width = canvas.width;
const height = canvas.height;
const r = width / 2; // Il raggio è metà della larghezza del canvas

let N = 0; // Punti totali
let M = 0; // Punti nel cerchio

// Funzione per disegnare la situazione iniziale (quadrato giallo e cerchio azzurro)
function disegnaSfondo() {
    // Quadrato circoscritto
    ctx.fillStyle = "yellow";
    ctx.fillRect(0, 0, width, height);
    
    // Cerchio inscritto
    ctx.beginPath();
    ctx.arc(r, r, r, 0, 2 * Math.PI);
    ctx.fillStyle = "lightblue";
    ctx.fill();
    ctx.stroke();
}

function aggiungiPunti(numeroDiPunti) {
    for (let i = 0; i < numeroDiPunti; i++) {
        // Genera coordinate casuali x e y tra -1 e 1
        let x = (Math.random() * 2) - 1;
        let y = (Math.random() * 2) - 1;
        
        N++; // Incrementa i casi totali simulati
        
        // Mappa le coordinate da [-1, 1] alla dimensione reale in pixel del Canvas [0, 400]
        let canvasX = (x + 1) * r;
        let canvasY = (y + 1) * r;
        
        // Verifica se il punto cade dentro il cerchio (Equazione della circonferenza)
        if ((x * x) + (y * y) <= 1) {
            M++; // Incrementa i casi favorevoli
            ctx.fillStyle = "green"; // Colore per i punti interni
        } else {
            ctx.fillStyle = "red";   // Colore per i punti esterni
        }
        
        // Disegna il singolo punto sul canvas
        ctx.fillRect(canvasX, canvasY, 2, 2); 
    }
    
    // Aggiorna i testi nella pagina
    aggiornaInterfaccia();
}

// Aggiorna i valori mostrati in tempo reale nell'HTML
function aggiornaInterfaccia() {
    let pi = 4 * (M / N);
    
    document.getElementById('totali').innerText = N;
    document.getElementById('cerchio').innerText = M;
    document.getElementById('pi_stimato').innerText = pi.toFixed(6);
}

// Avvia il disegno dello sfondo appena il file viene caricato
disegnaSfondo();