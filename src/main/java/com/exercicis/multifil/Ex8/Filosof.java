package com.exercicis.multifil.Ex8;

public class Filosof extends Thread {
    private final int id;
    private final Cobert cobertEsquerre;
    private final Cobert cobertDret;

    public Filosof(int id, Cobert cobertEsquerre, Cobert cobertDret) {
        this.id = id;
        this.cobertEsquerre = cobertEsquerre;
        this.cobertDret = cobertDret;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof " + id + " està pensant...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void menjar() throws InterruptedException {
        System.out.println("Filòsof " + id + " ha començat a MENJAR amb els coberts " 
            + cobertEsquerre.getId() + " i " + cobertDret.getId());
        Thread.sleep((long) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            // Simulem 3 cicles de pensar i menjar
            for (int i = 0; i < 3; i++) {
                pensar();

                // ESTRATÈGIA DE PREVENCIÓ DE DEADLOCK (Extensió)
                // Determinem quin cobert s'agafa primer depenent de l'ID del filòsof
                Cobert primerLock = cobertEsquerre;
                Cobert segonLock = cobertDret;

                // L'últim filòsof (ID 4) trenca la simetria començant per la dreta
                if (id == 4) {
                    primerLock = cobertDret;
                    segonLock = cobertEsquerre;
                }

                // 1. Intenta adquirir el primer cobert
                primerLock.lock.lock();
                try {
                    System.out.println("Filòsof " + id + " té 1 cobert.");
                    
                    // 2. Intenta adquirir el segon cobert
                    segonLock.lock.lock();
                    try {
                        // Secció crítica: Té els dos coberts
                        menjar();
                    } finally {
                        // Allibera el segon cobert sempre
                        segonLock.lock.unlock();
                    }
                } finally {
                    // Allibera el primer cobert sempre
                    primerLock.lock.unlock();
                    System.out.println("Filòsof " + id + " ha deixat els coberts a la taula.");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Filòsof " + id + " ha estat interromput.");
        }
    }
}