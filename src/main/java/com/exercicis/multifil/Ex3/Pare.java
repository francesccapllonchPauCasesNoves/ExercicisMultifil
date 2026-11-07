package com.exercicis.multifil.Ex3;

public class Pare {
    public static void main(String[] args) {
        
        Buffer buffer = new Buffer();

        Tic tic = new Tic(buffer);
        Tac tac = new Tac(buffer);
        

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
