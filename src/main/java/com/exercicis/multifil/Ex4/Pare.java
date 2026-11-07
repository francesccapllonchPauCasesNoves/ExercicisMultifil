package com.exercicis.multifil.Ex4;

public class Pare {

    public static void main(String[] args) {

        Comptador c = new Comptador();
        
        Incrementador inc1 = new Incrementador(c,1);
        Incrementador inc2 = new Incrementador(c,3);
        Incrementador inc3 = new Incrementador(c,5);

        Thread primer = new Thread(inc1);
        Thread segon = new Thread(inc2);
        Thread tercer = new Thread(inc3);

        primer.start();
        segon.start();
        tercer.start();

        try {
            primer.join();
            segon.join();
            tercer.join();

            System.out.println(c.getValor());
        } catch ( InterruptedException e) {

            System.out.println(e.getMessage());
        }

    }
    
}
