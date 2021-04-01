
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

            try {
                int[] v = new int[20];
                int numero;
                Random gerador = new Random();
                Scanner entrada = new Scanner(System.in);
                System.out.println("Digite um numero: ");
                numero = entrada.nextInt();
                //gerando o vetor
                for (int i = 0; i < v.length; i++) {
                    v[i] = gerador.nextInt(40);
                }
                Vetor vetor = new Vetor(v);
                //imprimindo o vetor
                System.out.println("Imprindo o vetor de 20 posições aleatoriamente");
                for (int j = 0; j < v.length; j++) {
                    System.out.print(v[gerador.nextInt(19)] + " ");
                }
                System.out.println();
                vetor.maiorMenorValorVetor();
                vetor.primeiraOcorrencia(numero);
                vetor.todasOcorrencias(numero);
                vetor.numeroOcorrencias(numero);

            } catch (InputMismatchException ex1) {
                System.out.println("\n\nNão é um numero\nDigite APENAS NUMEROS INTEIROS! ");
                main(args);
            } catch (ArrayIndexOutOfBoundsException ex2) {
                System.out.println("\n\nPosição do array invalida, estouro do array");
                main(args);
            } catch (Exception ex3) {
                System.out.println(ex3.getMessage());
            } finally {
                System.out.println("");
            }
        }

}
