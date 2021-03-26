package avaliacao3bimestre;

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Scanner;

public class Prefeito extends Candidato {
    private int voto;
    private VicePrefeito vicePrefeito;

    public Prefeito() {
    }

    public Prefeito(String nome, String email, String dataNascimento, String codigo, int voto, VicePrefeito vicePrefeito) {
        super(nome, email, dataNascimento, codigo);
        this.voto = voto;
        this.vicePrefeito = vicePrefeito;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public VicePrefeito getVicePrefeito() {
        return vicePrefeito;
    }

    public void setVicePrefeito(VicePrefeito vicePrefeito) {
        this.vicePrefeito = vicePrefeito;
    }

    public void adicionarCandidatos(ArrayList<Prefeito> vetor, String nome, String email, String dataNascimento, String codigo) {
        System.out.println("Agora digite os dados do vice prefeito(nome, e-mail, data de nascimento e código do candidato)");
        Scanner entradaVice = new Scanner(System.in);
        System.out.print("Nome: ");
        String nomeV = entradaVice.nextLine();
        System.out.print("Email: ");
        String emailV = entradaVice.nextLine();
        System.out.print("Data de nascimento: ");
        String dataNascimentoV = entradaVice.nextLine();

        VicePrefeito vice = new VicePrefeito(nomeV, emailV, dataNascimentoV,"67");
        vetor.add(new Prefeito(nome, email, dataNascimento, codigo, 0, vice));
    }

    public void adicionaVoto() {
        this.voto += 1;
    }
}
