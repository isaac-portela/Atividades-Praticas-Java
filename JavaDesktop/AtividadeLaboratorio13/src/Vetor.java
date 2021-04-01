public class Vetor {
    private int[] vetor = new int[20];

    public Vetor() {
    }

    public Vetor(int[] vetor) {
        this.vetor = vetor;
    }

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    public void maiorMenorValorVetor() {
        int maior = -1, menor = 102, i;
        for (i = 0; i < vetor.length; i++) {
            if (vetor[i] > maior)
                maior = vetor[i];
            if (vetor[i] < menor)
                menor = vetor[i];
        }
        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);
    }

    public void primeiraOcorrencia(int num) {
        int primeiraOcorrencia = -1;
        for (int i = vetor.length - 1; i >= 0; i--) {
            if (vetor[i] == num)
                primeiraOcorrencia = i;
        }
        if (primeiraOcorrencia != -1)
            System.out.println("Posição da primeira ocorrencia: " + primeiraOcorrencia);
        else
            System.out.println("Não há nenhuma ocorrencia do número " + num + " no vetor");
    }

    public void todasOcorrencias(int num) {
        System.out.println("------------Posiçoes de todas as ocorrencias do número " + num + " no vetor de 20 posições--------- ");
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == num)
                System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public void numeroOcorrencias(int num) {
        int cont = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == num)
                cont++;
        }
        System.out.println("O elemento " + num + " ocorre " + cont + " vezes no vetor");
    }
}
