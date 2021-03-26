package avaliacao3bimestre;

import java.util.ArrayList;

public class Vereador extends Candidato {
    private int voto;

    public Vereador() {
    }

    public Vereador(String nome, String email, String dataNascimento, String codigo, int voto) {
        super(nome, email, dataNascimento, codigo);
        this.voto = voto;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public void adicionarCandidatos(ArrayList<Vereador> vetor, String nome, String email, String dataNascimento, String codigo) {
        vetor.add(new Vereador(nome, email, dataNascimento, codigo, 0));
    }

    public void adicionaVoto() {
        this.voto += 1;
    }

}
