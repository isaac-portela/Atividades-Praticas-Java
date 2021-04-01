package avaliacaopratica4bimestre;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fila<T> {
    private ItemFila<T> primeiro;
    private ItemFila<T> ultimo;
    private int tamanho;

    public Object ultimo() {
        return this.ultimo.getConteudo();
    }

    public void inserir(T valor) {
        ItemFila novoItem = new ItemFila();
        novoItem.setConteudo(valor);
        if (this.vazia()) {
            primeiro = novoItem;
            ultimo = novoItem;
        } else {
            ultimo.setProximo(novoItem);
            ultimo = novoItem;
        }
        this.tamanho++;
    }

    public T remover() throws FilaVaziaException {
        if (!this.vazia()) {
            T valor = primeiro.getConteudo();
            primeiro = primeiro.getProximo();
            this.tamanho--;
            return valor;
        } else {
            throw new FilaVaziaException("ERRO: A fila está vazia, portanto não e possivel remover qualquer elemento dela");
        }
    }
/*
    public void salvarArquivo(String caminhoArquivo) throws IOException {
        File file = new File(caminhoArquivo);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        ItemFila aux = this.primeiro;
        while (aux != null) {
            bw.write(aux.getConteudo().toString() + "\r\n");
            aux = aux.getProximo();
        }
        bw.close();
    }

 */
/*
    public void carregarArquivo(String caminhoArquivo, IConversor<T> conversor) throws IOException {
        this.limpar();
        FileReader fr = null;
        try {
            fr = new FileReader(caminhoArquivo);
            BufferedReader br = null;
            try {
                br = new BufferedReader(fr);
                while (br.ready()) {
                    String linha = br.readLine();
                    this.inserir(conversor.converter(linha));
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
        } finally {
            if (fr != null) {
                fr.close();
            }
        }
    }

 */

    public Object[] toArray (IConversor<T> conversor){
        Object[] array = new Object[this.tamanho];
        ItemFila<T> item = this.primeiro;
        int i=0;
        while(item!=null){
            array[i] = conversor.converterParaArray(item.getConteudo());
            item = item.getProximo();
            i++;
        }
        return array;
    }

    public boolean vazia() {
        return this.primeiro == null;
    }

    public void limpar() {
        this.primeiro = null;
    }

    public int getTamanho() {
        return this.tamanho;
    }
}

