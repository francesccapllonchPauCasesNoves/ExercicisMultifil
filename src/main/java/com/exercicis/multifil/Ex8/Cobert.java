package com.exercicis.multifil.Ex8;

import java.util.concurrent.locks.ReentrantLock;

public class Cobert {
    private final int id;
    // Pany explícit que utilitzarà cada filòsof per bloquejar aquest cobert específic
    final ReentrantLock lock = new ReentrantLock();

    public Cobert(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
