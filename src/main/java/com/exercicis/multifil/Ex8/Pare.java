package com.exercicis.multifil.Ex8;

public class Pare {
    public static void main(String[] args) {
        int numFilosofs = 5;
        Filosof[] filosofs = new Filosof[numFilosofs];
        Cobert[] coberts = new Cobert[numFilosofs];

        // 1. Col·loquem els 5 coberts a la taula
        for (int i = 0; i < numFilosofs; i++) {
            coberts[i] = new Cobert(i);
        }

        // 2. Asseiem els filòsofs i els assignem els coberts veïns
        for (int i = 0; i < numFilosofs; i++) {
            Cobert cobertEsquerre = coberts[i];
            // L'operador mòdul (%) fa que el filòsof 4 (últim) agafi com a dret el cobert 0 (el primer)
            Cobert cobertDret = coberts[(i + 1) % numFilosofs];

            filosofs[i] = new Filosof(i, cobertEsquerre, cobertDret);
            filosofs[i].start();
        }

        // 3. Esperem que tots acabin de sopar
        for (int i = 0; i < numFilosofs; i++) {
            try {
                filosofs[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Tots els filòsofs han acabat la vetllada sense bloquejos!");
    }
}