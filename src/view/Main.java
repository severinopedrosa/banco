package view;

import java.util.concurrent.Semaphore;
import controller.Controller;

public class Main {
    public static void main(String[] args) {
        int Saldo = 0;
        Semaphore semaforo = new Semaphore(1);

        for ( int i = 0 ; i < 20 ; i ++ ) {
            Thread thread = new Controller(semaforo, Saldo);
            thread.start();
        }
    }
}