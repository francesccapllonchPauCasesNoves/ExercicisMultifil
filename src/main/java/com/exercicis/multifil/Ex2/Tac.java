package com.exercicis.multifil.Ex2;

public class Tac implements Runnable{

    String tac;

    public Tac(){
        this.tac = "TAC";
    }


    @Override 
    public void run(){
        
        System.out.println(tac);        
    }
    
    
}
