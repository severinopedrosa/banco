package controller;

import java.util.concurrent.Semaphore;

public class Controller extends Thread {
    private Semaphore semaforo;
    private int Saldo;

    public Controller ( Semaphore semaforo, int Saldo ) {
        this.semaforo = semaforo;
        this.Saldo = Saldo;
    }

    public void Transicao () {
        int transicao = (int)(Math.random() * 10);
        int SaldoInicial = (int)(Math.random() * 100 + 1000);
        int Valor = (int)(Math.random() * 100);
        int Codigo = (int)(Math.random() * 100 + 1000);

        if ( transicao > 0 ) {
            Saldo = SaldoInicial - Valor;
            System.out.println("A Conta " + Codigo + ": tinha saldo de R$ " + SaldoInicial);
            System.out.println("Realizou um Saque de R$ " + Valor);
            System.out.println("Saldo atualizado de R$ " + Saldo);
            System.out.println();
        } 
        else {
            Saldo = SaldoInicial + Valor;
            System.out.println("A Conta " + Codigo + ": tinha saldo de R$ " + SaldoInicial);
            System.out.println("Realizou um Depósito de R$ " + Valor);
            System.out.println("Saldo atualizado de R$ " + Saldo);
            System.out.println();
        }
    }

    public void run() {
		try {
			semaforo.acquire();
			Transicao();
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();	
		}
    }
}