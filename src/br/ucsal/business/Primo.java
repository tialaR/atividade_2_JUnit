package br.ucsal.business;

import java.util.Scanner;

public class Primo {
	
	public int solicitaNumero(){
		System.out.println("Digite um número entre 1 e 10000:");
        int numeroDigitado = new Scanner(System.in).nextInt();
        if (numeroDigitado > 10000 || numeroDigitado < 1){
        	System.out.println("Número incompatível.");
            return -1;
        }
        return numeroDigitado;
    }
	
	
	public static boolean ehPrimo(int numero) {
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;   
        }
        return true;
    }
	
	public boolean isPrimo(int numero) {
		boolean verificacao = ehPrimo(numero);
        if (verificacao){
            System.out.println("O número " + numero + " é primo.");
            return true;
        }else{
            System.out.println("O número " + numero + " não é primo.");
        }

        return false;
    }

}
