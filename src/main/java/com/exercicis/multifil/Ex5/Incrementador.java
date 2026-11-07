package com.exercicis.multifil.Ex5;

public class Incrementador implements Runnable{

    int vegades = 0;
    Comptador c;

    public Incrementador(Comptador c, int vegades) {
        this.vegades = vegades;
        this.c=c;
    }

    @Override
    public void run() {
        for (int i =0; i< vegades; i++) {
            c.incrementar();            
        }
    }


    
}