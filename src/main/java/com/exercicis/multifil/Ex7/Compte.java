package com.exercicis.multifil.Ex7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Compte {
    int id;
    int saldo;
    final ReentrantLock lock = new ReentrantLock();
    final Condition transf = lock.newCondition(); 

    public Compte(int id, int saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public void transferir(Compte c, int q) throws InterruptedException{

        Compte lock1 = this.id < c.getId() ? this : c;
        Compte lock2 = this.id < c.getId()? this: c;

        lock1.lock.lock();
        lock2.lock.lock();

        try{
            
            while (this.saldo < q) { 
                transf.await();
            }

            this.saldo -= q;
            c.saldo += q;
            
            c.transf.signalAll();
            
        } finally {
            lock1.lock.unlock();
            lock2.lock.unlock();
        }
    }

    public  void afegir(int q){
        this.saldo = saldo + q;
    }

    public int getSaldo() {
        return saldo;
    } 
    
}
