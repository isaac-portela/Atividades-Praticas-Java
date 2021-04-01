package atividadelaboratorio14;

import java.util.Random;

public class Matriz {
    private int[][] matriz = new int[4][4];
    Random gerador = new Random();

    public Matriz() {
    }

    public Matriz(int[][] matriz) {
        this.matriz = matriz;
    }


    public Random getGerador() {
        return gerador;
    }

    public void setGerador(Random gerador) {
        this.gerador = gerador;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int[][] gerarMatriz() throws ExcecaoNumeroZero {
        int elemento;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                elemento = this.gerador.nextInt(15);
                if (elemento == 0) {
                    throw new ExcecaoNumeroZero(elemento);
                } else {
                    this.matriz[i][j] = elemento;
                }

            }
        }
        return this.matriz;
    }

    public void menorMaior() {
        int menor = 100, maior = -1;
        for (int[] linha : matriz) {
            for (int valor : linha) {
                if (valor > maior)
                    maior = valor;
                else if (valor < menor)
                    menor = valor;
            }
        }
        System.out.println("Menor valor da matriz:" + menor);
        System.out.println("Maior valor da matriz:" + maior);
    }

    public void primeiraOcorrencia(int numero) {
        int[] posicao = new int[2];
        for (int linha = matriz.length - 1; linha >= 0; linha--) {
            for (int coluna = matriz[linha].length - 1; coluna >= 0; coluna--) {
                if (numero == matriz[linha][coluna]) {
                    posicao[0] = linha;
                    posicao[1] = coluna;
                }
            }
        }
        int nOcorrecias = numeroOcorrencias(numero);
        if (nOcorrecias > 0)
            System.out.println("A primeira ocorrencia de " + numero + " = " + "[" + posicao[0] + "]" + "[" + posicao[1] + "]");
        else
            System.out.println("Não tem primeira ocorrencia");
    }

    public void ultimaOcorrencia(int numero) {
        int[] posicao = new int[2];
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                if (numero == matriz[linha][coluna]) {
                    posicao[0] = linha;
                    posicao[1] = coluna;
                }
            }
        }
        int nOcorrecias = numeroOcorrencias(numero);
        if (nOcorrecias > 0)
            System.out.println("A ultima ocorrencia de " + numero + " = " + "[" + posicao[0] + "]" + "[" + posicao[1] + "]");
        else
            System.out.println("Não tem ultima ocorrencia");

    }

    public void todasOcorrencia(int numero) {
        int nOcorrecias = numeroOcorrencias(numero);
        if (nOcorrecias > 0) {
            System.out.print("Posições de todas as ocorrencias do elemento " + numero + " na matriz: ");
            int[] posicao = new int[2];
            for (int linha = 0; linha < matriz.length; linha++) {
                for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                    if (numero == matriz[linha][coluna]) {
                        System.out.print("[" + linha + "][" + coluna + "] ");
                    }
                }
            }
        } else {
            System.out.print("Não ha nenhuma ocorrencia do numero " + numero + " na matriz");
        }
        System.out.println();
    }

    public int numeroOcorrencias(int numero) {
        int cont = 0;
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                if (numero == matriz[linha][coluna]) {
                    cont++;
                }
            }
        }
        return cont;
    }

}
