const canvas = document.getElementById("Lavagna");
const ctx = canvas.getContext("2d");
const BLACK = "#000000";

let tartaruga = {
    pennello: true,
    posizione: {x: 0, y: 0},
    colore: BLACK,
    angolo: 0,
    
    avanti: function(pixel){
        ctx.beginPath(); 
        ctx.strokeStyle = this.colore; 
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
    },
}

function disegnaLatoKoch(pixel, n) {
    if (n === 0) {
        tartaruga.avanti(pixel);
    } else {
        let pezzo = pixel / 3;
        
        disegnaLatoKoch(pezzo, n - 1);
        tartaruga.ruota(60); 
        
        disegnaLatoKoch(pezzo, n - 1);
        tartaruga.ruota(-120); 
        
        disegnaLatoKoch(pezzo, n - 1);
        tartaruga.ruota(60); 
        
        disegnaLatoKoch(pezzo, n - 1);
    }
}

tartaruga.posizione.x = 240;  
tartaruga.posizione.y = 450; 
tartaruga.angolo = 0;        

let lunghezzaLato = 300;
let livelloDettaglio = 6;

disegnaLatoKoch(lunghezzaLato, livelloDettaglio);
tartaruga.ruota(-120); 

disegnaLatoKoch(lunghezzaLato, livelloDettaglio);
tartaruga.ruota(-120); 

disegnaLatoKoch(lunghezzaLato, livelloDettaglio);
tartaruga.ruota(-120);


