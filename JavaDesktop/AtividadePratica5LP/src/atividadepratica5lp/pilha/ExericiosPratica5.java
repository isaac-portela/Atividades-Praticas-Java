package atividadepratica5lp.pilha;

import atividadepratica5lp.pilha.Pilha;

import java.util.Scanner;

public class ExericiosPratica5 {
    public static void main(String[] args) {
        Pilha<Integer> par = new Pilha<Integer>();
        Pilha<Integer> impar = new Pilha<Integer>();
        Scanner entrada = new Scanner(System.in);
        int n;
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número: ");
            n = entrada.nextInt();
            if (n == 0) {
                Integer numeroDsempilhado = par.desempilha();
                if (numeroDsempilhado == null)
                    System.out.println("A pilha par está vazia, foi possivel desempilhar");
                else
                    System.out.println("Elemento desempilhado da pilha par: " + numeroDsempilhado);

                numeroDsempilhado = impar.desempilha();
                if (numeroDsempilhado == null)
                    System.out.println("A pilha impar está vazia, foi possivel desempilhar");
                else
                    System.out.println("Elemento desempilhado da pilha impar: " + numeroDsempilhado);

            } else {
                if (n % 2 == 0) {
                    System.out.println("Número par, empilhando na pilha par: " + n);
                    par.empilha(n);
                } else {
                    System.out.println("Número impar, empilhando na pilha ímpar: " + n);
                    impar.empilha(n);
                }
            }
        }

        System.out.println("\n-----Desempilhando todos os elementos da pilha par-----");
        while (!par.estaVazia()){
            System.out.println("Elemento desempilhado da pilha par: "+par.desempilha());
        }
        System.out.println("-----Desempilhando todos os elementos da pilha impar-----");
        while (!impar.estaVazia()){
            System.out.println("Elemento desempilhado da pilha impar: "+impar.desempilha());
        }
    }
}
