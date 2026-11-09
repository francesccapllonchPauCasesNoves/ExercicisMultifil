package com.exercicis.multifil.Ex7;

import java.util.List;
import java.util.Random;

public class Client extends Thread{
    private final List<Compte> banc;
    private final Random random = new Random();

    public Client (List<Compte> banc){
        this.banc = banc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int origenB = random.nextInt(banc.size());
            int destiB;

            do {
                destiB = random.nextInt(banc.size());
            } while (origenB == destiB);

            Compte origen = banc.get(origenB);
            Compte desti = banc.get(destiB);


            int quant = (int)(Math.random() * (100 - 0 +1))+0;
            try {
                origen.transferir(desti, quant);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
