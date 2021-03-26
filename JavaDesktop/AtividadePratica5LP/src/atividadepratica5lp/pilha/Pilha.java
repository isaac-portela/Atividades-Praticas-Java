package atividadepratica5lp.pilha;

import atividadepratica5lp.EstruturaEstatica;

public class Pilha <T> extends EstruturaEstatica<T> {
    public  Pilha(){
        super();
    }
    public Pilha(int capacidade){
        super(capacidade);
    }
    public void empilha(T elemento){
         this.adiciona(elemento);
    }
    public T desempilha(){
        if(this.estaVazia()){
            return null;
        }
        T elemento = this.elementos[tamanho-1];
        tamanho--;
        return elemento;
    }
}
