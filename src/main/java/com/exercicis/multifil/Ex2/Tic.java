package com.exercicis.multifil.Ex2;

public class Tic implements Runnable {

    String tic;

    public Tic(){

        this.tic = "TIC";
    }

    @Override 
    public void run(){
        
        for(int i = 0; i < 100; i++){
            System.out.println("TIC");
        }
        
    }
    
}
