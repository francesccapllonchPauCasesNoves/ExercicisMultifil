package com.exercicis.multifil.Ex5;

public class Pare {

    public static void main(String[] args) {
        Comptador c = new Comptador();
        Incrementador inc = new Incrementador(c, 3);
        Decrementador dec = new Decrementador(c, 1);

        Thread i = new Thread(inc);
        Thread d = new Thread(dec);

        i.start();
        d.start();

        try {
            d.join();
            i.join();
            System.out.println(c.getValor());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
