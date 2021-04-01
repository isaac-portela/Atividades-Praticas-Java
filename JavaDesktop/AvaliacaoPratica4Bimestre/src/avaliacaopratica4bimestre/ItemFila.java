package avaliacaopratica4bimestre;

public class ItemFila<T> {
    private T conteudo;
    private ItemFila proximo;
    public T getConteudo() {
        return conteudo;
    }
    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }
    public ItemFila getProximo() {
        return proximo;
    }
    public void setProximo(ItemFila itemFila) {
        this.proximo = itemFila;
    }
}
