package fila;

public class Pratica04 {
    public static void main(String[] args) {
        Fila<Documentos> filaDocumentos = new Fila<Documentos>();
        filaDocumentos.enfileirar(new Documentos("A", 10));
        filaDocumentos.enfileirar(new Documentos("B", 200));
        filaDocumentos.enfileirar(new Documentos("C", 20));
        filaDocumentos.enfileirar(new Documentos("D", 32));
        filaDocumentos.enfileirar(new Documentos("E", 12));
        filaDocumentos.enfileirar(new Documentos("F", 44));
        filaDocumentos.enfileirar(new Documentos("G", 56));
        while (!filaDocumentos.estaVazia()) {
            Documentos docAtual = filaDocumentos.desenfileirar();
            System.out.println("Imprimindo documento " + docAtual.getNome());
            try {
                Thread.sleep(100 * docAtual.getNumFolhas());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        System.out.println("-----Todos os documentos foram impressos.-----");
    }
}
