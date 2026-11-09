package com.exercicis.multifil.Ex6;

public class Productor implements Runnable{

    
    Buffer b = new Buffer();

    public Productor(Buffer buffer) {

        this.b = buffer;
    }


    @Override
    public synchronized void run() {

        for (int i = 0; i < 10; i++) {
            int random = (int)(Math.random() * (100 - 0 +1))+0;
            try {
                b.addNombre(random);
            } catch (InterruptedException ex) {
                System.getLogger(Productor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
            
    }
    
}
