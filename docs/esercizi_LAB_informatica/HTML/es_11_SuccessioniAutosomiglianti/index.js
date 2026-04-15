const canvas = document.getElementById("Lavagna");
const ctx = canvas.getContext("2d");

let tartaruga = {
    pennello: true,
    posizione: {x: 0, y: 0},
    colore: "#000000",
    angolo: 0,
    
    avanti: function(pixel){
        ctx.beginPath();
        ctx.strokeStyle = this.colore;
        ctx.lineWidth = 1; 
        ctx.moveTo(this.posizione.x, this.posizione.y);
        
        this.posizione.x += pixel * Math.cos(this.angolo * (Math.PI/180));
        this.posizione.y += pixel * Math.sin(this.angolo * (Math.PI/180));
        
        if(this.pennello == true){
            ctx.lineTo(this.posizione.x, this.posizione.y);
            ctx.stroke();
        } else {
            ctx.moveTo(this.posizione.x, this.posizione.y);
        }
    },
    
    ruota: function(angolo){
        this.angolo += angolo;
    },
    
    alzaPennello: function(){ 
        this.pennello = false; 
    }, 

    abbassaPennello: function(){ 
        this.pennello = true; 
    },

    coloreLinea: function(nuovoColore){ 
        this.colore = nuovoColore; 
    }
}

function generaStringa(numeroIterazioni) {
    let testo = "0";

    for (let i = 0; i < numeroIterazioni; i++) {
        let nuovoTesto = "";
        for (let carattere of testo) {
            if (carattere === "0") {
                nuovoTesto += "01";
            } else {
                nuovoTesto += "10";
            }
        }
        testo = nuovoTesto;
    }
    return testo;
}

function disegnaSuccessione(iterazioni) {
    let istruzioni = generaStringa(iterazioni);
    
    tartaruga.posizione.x = 800;
    tartaruga.posizione.y = 10;
    tartaruga.angolo = 0;
    
    for (let carattere of istruzioni) {
        if (carattere === "0") {
            tartaruga.avanti(3);
        } else {
            tartaruga.ruota(-60);
        }
    }
}

disegnaSuccessione(20);