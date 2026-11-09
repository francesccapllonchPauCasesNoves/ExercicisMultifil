package com.exercicis.multifil.Ex6;

public class Consumidor implements Runnable{

    Buffer b = new Buffer();
    
    public Consumidor(Buffer b){

        this.b=b;

    }

    @Override
    public synchronized  void run() {
        
        for (int i = 0; i < 10; i++) {
            try {
                b.getBuffer();
            } catch (InterruptedException ex) {
                System.getLogger(Consumidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        
    }
    
}
