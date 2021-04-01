package avaliacao01segundobimestre;

public class CD extends Midia {
    private int nMusicas;

    public CD() {
    }

    public CD(int codigo, double preco, String nome, int nMusicas) {
        super(codigo, preco, nome);
        this.nMusicas = nMusicas;
    }

    public int getnMusicas() {
        return nMusicas;
    }

    public void setnMusicas(int nMusicas) {
        this.nMusicas = nMusicas;
    }

    @Override
    public String imprimeDados() {
        return  "Codigo: " + this.codigo + "\n" + "Preço: " + this.preco + "\n" + "Nome: " + this.nome;
    }

    @Override
    public String informaTipo() {

        return " é um CD";
    }
}
