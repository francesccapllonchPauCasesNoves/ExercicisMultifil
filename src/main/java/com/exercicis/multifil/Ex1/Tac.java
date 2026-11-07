package com.exercicis.multifil.Ex1;

public class Tac extends Thread{

    String tac;

    public Tac(){
        this.tac = "TAC";
    }


    @Override 
    public void run(){
        
        System.out.println(tac);        
    }
    
    
}
