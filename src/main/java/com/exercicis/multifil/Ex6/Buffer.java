package com.exercicis.multifil.Ex6;

import java.util.ArrayList;

public class Buffer {

    private final int max = 5;
    private final ArrayList<Integer> buffer = new ArrayList<>();

    public  void addNombre(int n) throws InterruptedException {
        
        while(buffer.size() == max){
            wait();
        }
        
        buffer.add(n);
        notifyAll();
    }

    

    public   void getBuffer() throws InterruptedException{

        while(buffer.isEmpty()){
            wait();
        }
        int darrer = this.buffer.getLast();

        this.buffer.removeLast();
        System.out.println(darrer);
        notifyAll(); 
            

    }
        
   


}
