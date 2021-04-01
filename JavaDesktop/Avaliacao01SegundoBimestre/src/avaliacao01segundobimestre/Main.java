package avaliacao01segundobimestre;


public class Main {
    public static void main(String[] args) {
        Midia[] tipoMidia = new Midia[8];
        tipoMidia[0] = new DVD(10, 200.00, "Jazz in concert", 5);
        tipoMidia[1] = new DVD(11, 201.00, "Popular Bras", 5);
        tipoMidia[2] = new DVD(12, 199.00, "Country", 7);
        tipoMidia[3] = new DVD(13, 188.00, "Samba no bar", 7);
        tipoMidia[4] = new DVD(14, 130.00, "Sertanejo ao vivo", 6);
        tipoMidia[5] = new CD(20, 45.00, "Roupa nova", 10);
        tipoMidia[6] = new CD(21, 55.00, "Caetano", 12);
        tipoMidia[7] = new CD(22, 59.00, "Gil", 10);

        System.out.println("----------Imprimindo se as Mídias são CDs ou DVDs--------------");
        for (Midia midia : tipoMidia) {
            System.out.println(midia.getNome() + midia.informaTipo());
        }
        System.out.println("\n");
        System.out.println("----------Informações do elemento Samba no bar--------------");
        for (Midia midia : tipoMidia) {
            if (midia.getNome().equals("Samba no bar")) {
                if (midia instanceof DVD) {
                    DVD sambaBar = new DVD();
                    sambaBar = (DVD) midia;
                    System.out.println(sambaBar.imprimeDados() + "\nNúmero de faixas: " + sambaBar.getnFaixas());
                } else {
                    CD sambaBar = new CD();
                    sambaBar = (CD) midia;
                    System.out.println(sambaBar.imprimeDados() + "\nNúmero de musicas: " +  sambaBar.getnMusicas());
                }
            }
        }
    }
}
