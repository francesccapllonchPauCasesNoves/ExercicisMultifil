package com.exercicis.multifil.Ex1;


public class Tic extends Thread {

    String tic;

    public Tic(){

        this.tic = "TIC";
    }

    @Override 
    public void run(){
        
        while (true) {
            System.out.println(tic);
        }
        
    }
    
}
