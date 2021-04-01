package fila;

import base.EstruturaEstatica;

public class Fila<T> extends EstruturaEstatica {
    public Fila() {
        super();
    }

    public Fila(int capacidade) {
        super(capacidade);
    }

    public void enfileirar(T elemento) {
        this.adiciona(elemento);
    }

    public T espiar() {
        if (this.estaVazia()) {
            return null;
        }
        return (T) this.elementos[0];
    }

    public T desenfileirar() {
        if (this.estaVazia()) {
            return null;
        }
        T elementoASerRemovido = espiar();
        for (int i = 0; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamanho--;

        return elementoASerRemovido;
    }
}
