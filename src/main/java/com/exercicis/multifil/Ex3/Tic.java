package com.exercicis.multifil.Ex3;

public class Tic implements Runnable {

    String tic;
    Buffer buff;

    public Tic(Buffer buff){

        this.tic = "TIC";
        this.buff = buff;
    }

    @Override 
    public void run(){
   
        for(int i = 0; i < 100; i++){ 
             
            try {
                buff.incrementarComptador();
            } catch (InterruptedException ex) {
                System.getLogger(Tic.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        
    }
    
}
