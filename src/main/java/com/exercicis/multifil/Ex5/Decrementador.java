package com.exercicis.multifil.Ex5;

public class Decrementador implements Runnable{

    int vegades = 0;
    Comptador c;

    public Decrementador(Comptador c, int vegades) {
        this.vegades = vegades;
        this.c=c;
    }

    @Override
    public void run() {
        for (int i =0; i< vegades; i++) {
            c.decrementar();            
        }
    }


    
}
