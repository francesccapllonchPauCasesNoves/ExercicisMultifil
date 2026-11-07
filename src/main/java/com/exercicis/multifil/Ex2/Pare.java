package com.exercicis.multifil.Ex2;

public class Pare {
    public static void main(String[] args) {
        
        Tic tic = new Tic();
        Tac tac = new Tac();

        Thread primer= new Thread(tic);
        Thread segon = new Thread(tac);

        primer.start();
        segon.start();

        try{
            primer.join();
            segon.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

    }


    

}
