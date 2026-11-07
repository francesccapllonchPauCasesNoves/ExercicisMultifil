package com.exercicis.multifil.Ex3;

public class Buffer {
    int comptador = 0;

    int max = 1;

    public int getMax() {
        return max;
    }

    public synchronized void incrementarComptador() throws InterruptedException{
        while(comptador == max){
            wait(); 
        }

        this.comptador++;
        System.out.println("TIC");
        notifyAll();

    }

    public synchronized void decrementarComptador() throws InterruptedException{
        while(comptador == 0){
             wait();
        }
        this.comptador--;
        System.out.println("TAC");
        notifyAll();
    }

    
}
