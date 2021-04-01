package atividadelaboratorio14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ExcecaoNumeroZero {
        Matriz matriz = new Matriz();
        int[][] m = new int[4][4];
        int numero;
        Scanner entrada = new Scanner(System.in);
        try {
            m = matriz.gerarMatriz();
            System.out.print("\nDigite um número: ");
            numero = entrada.nextInt();
            System.out.println();
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    if (m[i][j] < 10) {
                        System.out.print(" ");
                    }
                    System.out.print(m[i][j] + " ");
                }
                System.out.println();
            }
            matriz.menorMaior();
            matriz.primeiraOcorrencia(numero);
            matriz.ultimaOcorrencia(numero);
            matriz.todasOcorrencia(numero);
            int nOcorrecias = matriz.numeroOcorrencias(numero);
            System.out.println("\nNúmero de Ocorrencias: " + nOcorrecias);
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.err.println("Ocorreu um estouro no vetor");
            main(args);
        } catch (InputMismatchException e2) {
            System.err.println("O valor recebido é inapropriado; Por favor digite um numero inteiro");
            main(args);
        } catch (ExcecaoNumeroZero e3) {
            System.err.printf("%s\n\n", e3.getMessage());
            main(args);
        } finally {
            System.out.println("");
        }
    }
}
