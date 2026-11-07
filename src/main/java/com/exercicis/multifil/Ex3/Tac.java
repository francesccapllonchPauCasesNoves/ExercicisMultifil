package com.exercicis.multifil.Ex3;

public class Tac implements Runnable{

    String tac;
    Buffer buff;
    

    public Tac(Buffer buff){
        this.tac = "TAC";
        this.buff = buff;
    }


    @Override 
    public void run(){
        for(int i = 0; i < 100; i++){
                
            try {
                buff.decrementarComptador();
            } catch (InterruptedException ex) {
                System.getLogger(Tic.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }        
    }
    
    
}
