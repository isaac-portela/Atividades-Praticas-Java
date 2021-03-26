package arvoregenealogica;

public class Main {
    public static void main(String[] args) {
        Pessoa avô_m = new Pessoa("Gilberto");
        Pessoa avó_m = new Pessoa("Maria");
        Pessoa avô_p = new Pessoa("Konohamaru");
        Pessoa avó_p = new Pessoa("Denise");
        Pessoa mae = new Pessoa("Julia", avô_m, avó_m);
        Pessoa pai = new Pessoa("Mateus", avô_p, avó_p);
        Pessoa[] filhos = new Pessoa[4];
        filhos[0] = new Pessoa("Mario", pai, mae);
        filhos[1] = new Pessoa("Juleide", pai, mae);
        filhos[2] = new Pessoa("Astoufo", pai, mae);
        filhos[3] = new Pessoa("Juleide", pai, mae);

        System.out.println("--------Irmaõs-------------");
        for (int i = 0; i < filhos.length; i++) {
            for (int j = i + 1; j < filhos.length; j++) {
                if (filhos[i].ehIrma(filhos[j]))
                    System.out.println(filhos[i].getNome() + " e irmão/irmã de " + filhos[j].getNome());
            }
        }
        System.out.println("\n\n----------------SEMANTICA-------------");
        for (int i = 0; i < filhos.length; i++) {
            for (int j = i + 1; j < filhos.length; j++) {
                if (filhos[i].ehSemanticamenteIgual(filhos[j]))
                    System.out.println("O objeto " + filhos[i].getNome() + "[" + i + "]" + " e " + filhos[j].getNome() + "[" + j + "]" + " possuem a mesma semantica!");
            }
        }


    }
}
