package com.exercicis.multifil.Ex1;

public class Pare {
    public static void main(String[] args) {
        
        Thread tic = new Tic();
        Thread tac = new Tac();

        tic.start();
        tac.start();


    }


    

}
