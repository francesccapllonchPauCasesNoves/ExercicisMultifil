package com.exercicis.multifil.Ex7;

import java.util.ArrayList;
import java.util.List;

public class Pare {
    public static void main(String[] args) {
        int numeroComptes = 5;
        int saldoInicial = 200;
        int numeroClients = 10;
        
        List<Compte> banc = new ArrayList<>();

        for (int i = 0; i < numeroComptes; i++) {
            banc.add(new Compte(i, saldoInicial));
        }
        
        imprimirSaldoTotal(banc, "INICIAL");

        // 2. Creem i arrenquem els fils (Clients)
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < numeroClients; i++) {
            Client c = new Client(banc);
            clients.add(c);
            c.start();
        }

        // 3. Esperem que totes les transferències (10 x 100 = 1000 operacions) acabin
        for (Client c : clients) {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 4. Verifiquem la consistència: El total ha de seguir sent 1000€
        imprimirSaldoTotal(banc, "FINAL");
    }

    private static void imprimirSaldoTotal(List<Compte> banc, String moment) {
        int total = 0;
        for (Compte c : banc) {
            total += c.getSaldo();
        }
        System.out.println("Saldo total " + moment + " del banc: " + total + " euros.");
    }
}
