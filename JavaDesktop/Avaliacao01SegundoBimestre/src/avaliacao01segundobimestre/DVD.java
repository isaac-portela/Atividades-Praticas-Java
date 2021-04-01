package avaliacao01segundobimestre;

public class DVD extends Midia {
    private int nFaixas;

    public DVD() {
    }

    public DVD(int codigo, double preco, String nome, int nFaixas) {
        super(codigo, preco, nome);
        this.nFaixas = nFaixas;
    }

    public int getnFaixas() {
        return nFaixas;
    }

    public void setnFaixas(int nFaixas) {
        this.nFaixas = nFaixas;
    }

    @Override
    public String imprimeDados() {
        return  "Codigo: " + this.codigo + "\n" + "Preço: " + this.preco + "\n" + "Nome: " + this.nome;
    }

    @Override
    public String informaTipo() {
        return  " é um DVD";
    }
}
