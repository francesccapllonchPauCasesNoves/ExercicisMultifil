package com.exercicis.multifil.Ex6;

public class Pare {

    public static void main(String[] args) {

        Buffer b1 = new Buffer();

        Productor p1 = new Productor(b1);
        Consumidor c1 = new Consumidor(b1);

        Thread prod = new Thread(p1);

        Thread cons = new Thread(c1);

        prod.start();
        cons.start();

        try {
            prod.join();
            cons.join();
                
        } catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }
        
    }
}
