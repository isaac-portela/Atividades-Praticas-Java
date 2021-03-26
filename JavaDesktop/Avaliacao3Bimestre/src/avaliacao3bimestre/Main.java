package avaliacao3bimestre;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner entrada = new Scanner(System.in);
        Prefeito prefeito = new Prefeito();
        Vereador vereador = new Vereador();
        ArrayList<Prefeito> prefeitosVetor = new ArrayList<>();
        ArrayList<Vereador> vereadorVetor = new ArrayList<>();
        ArrayList<Eleitores> eleitoresVetor = new ArrayList<>();
        System.out.println("Observação: O Vice prefeito é cadrastrado junto com o prefeito, pois eles estão em composição");
        System.out.println("-------Realize o cadastro dos candidatos, para os cargos de prefeito, vice-prefeito e vereador.--------");
        int numeroEscolhido = 3;
        int zona, sessao;
        String nome, email, dataNascimento, codigo, titulo;
        while (numeroEscolhido != 0) {
            System.out.println("Digite 0 para finalizar o cadrastro dos candidatos(obs: apenas digite 0 depois de cadrastrar ao menos um Prefeito e um Vereador)");
            System.out.println("Digite 1 para cadastrar um Prefeito");
            System.out.println("Digite 2 para cadastrar um Vereador");
            numeroEscolhido = Integer.parseInt(entrada.nextLine());
            if (numeroEscolhido == 1) {
                System.out.println("---Digite os dados do Prefeito----");
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                System.out.print("Email: ");
                email = entrada.nextLine();
                System.out.print("Data de nascimento: ");
                dataNascimento = entrada.nextLine();
                System.out.print("Codigo do candidato: ");
                codigo = entrada.nextLine();
                prefeito.adicionarCandidatos(prefeitosVetor, nome, email, dataNascimento, codigo);
            } else if (numeroEscolhido == 2) {
                System.out.println("---Digite os dados do Verador ----");
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                System.out.print("Email: ");
                email = entrada.nextLine();
                System.out.print("Data de nascimento: ");
                dataNascimento = entrada.nextLine();
                System.out.print("Codigo do candidato: ");
                codigo = entrada.nextLine();
                vereador.adicionarCandidatos(vereadorVetor, nome, email, dataNascimento, codigo);
            }
        }

        numeroEscolhido = 3;
        System.out.println("------Realize o cadrastro dos eleitores---------");
        while (numeroEscolhido != 0) {
            System.out.println("Digite 0 para finalizar o cadrastro dos eleitores");
            System.out.println("Digite 1 para cadastrar um eleitor");
            numeroEscolhido = Integer.parseInt(entrada.nextLine());
            if (numeroEscolhido == 1) {
                System.out.println("---Digite os dados do eleitor----");
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                System.out.print("Data de nascimento: ");
                dataNascimento = entrada.nextLine();
                System.out.print("Titulo do eleitor: ");
                titulo = entrada.nextLine();
                System.out.print("Zona: ");
                zona = Integer.parseInt(entrada.nextLine());
                System.out.print("Seção: ");
                sessao = Integer.parseInt(entrada.nextLine());
                eleitoresVetor.add(new Eleitores(nome, dataNascimento, titulo, zona, sessao));
            }
        }

        System.out.println("\n-----------------Presidente da urna inicia o processo de eleição------------------------------------");
        String nomePresidente, horaAbertura, tituloPresidente;
        int zonaPresidente, secaoPresidente, numeroEleitoresSessao;

        System.out.println("Informe seus dados Preseidente da urna");
        System.out.print("Nome: ");
        nomePresidente = entrada.nextLine();
        System.out.print("Zona: ");
        zonaPresidente = Integer.parseInt(entrada.nextLine());
        System.out.print("Seção: ");
        secaoPresidente = Integer.parseInt(entrada.nextLine());
        System.out.print("Titulo: ");
        tituloPresidente = entrada.nextLine();
        System.out.print("Hora de abertura: ");
        horaAbertura = entrada.nextLine();
        DateFormat formatador = new SimpleDateFormat("HH:mm");
        Date dataAbertura = formatador.parse(horaAbertura);
        System.out.print("Número de eleitores na seção: ");
        numeroEleitoresSessao = Integer.parseInt(entrada.nextLine());
        System.out.println("\n\nComeça o processo  em que os eleitores comparecem para a eleição");
        String voto;
        int confima;
        int cont = 0;
        int finalizaVotação = 4;
        int votoBranco = 0, votoNulo = 0, verificaNulo;
        while (finalizaVotação != 0) {
            confima = 0;
            System.out.println("Olá eleitor, por favor informe seu número de título");
            titulo = entrada.nextLine();
            System.out.println("");
            for (Prefeito p : prefeitosVetor) {
                System.out.println(p.getNome() + ": " + p.getCodigo());
            }
            System.out.println("Digite o codigo de 2 digitos do candidato a prefeito ou  99 para votar em branco ");
            System.out.println("Em qual candidato a prefeito você deseja votar? ");
            while (confima == 0) {
                verificaNulo = 1;
                voto = entrada.nextLine();
                System.out.println("Digite 0 para cancelar o voto ou  1 para confima-lo");
                confima = Integer.parseInt(entrada.nextLine());
                if (confima == 1) {
                    if (voto.equals("99")) {
                        votoBranco += 1;
                    } else {
                        for (Prefeito p : prefeitosVetor) {
                            if (p.getCodigo().equals(voto)) {
                                p.adicionaVoto();
                                verificaNulo = 0;
                            }
                        }
                        if (verificaNulo == 1) {
                            votoNulo += 1;
                        }
                    }

                } else if (confima == 0) {
                    System.out.print("VOTO CANCELADO; Por favor digite de novo o codigo do candidato prefeito que você deseja votar: ");
                }

            }
            confima = 0;
            for (Vereador v : vereadorVetor) {
                System.out.println(v.getNome() + ": " + v.getCodigo());
            }
            System.out.println("Digite o codigo de 4 digitos do candidato a vereador ou  9999 para votar em branco ");
            System.out.println("Em qual candidato a vereador você deseja votar? ");
            while (confima == 0) {
                verificaNulo = 1;
                voto = entrada.nextLine();
                System.out.println();
                System.out.println("Digite 0 para cancelar o voto ou  1 para confima-lo");
                confima = Integer.parseInt(entrada.nextLine());
                if (confima == 1) {
                    if (voto.equals("9999")) {
                        votoBranco += 1;
                    } else {
                        for (Vereador v : vereadorVetor) {
                            if (v.getCodigo().equals(voto)) {
                                v.adicionaVoto();
                                verificaNulo = 0;
                            }
                        }
                        if (verificaNulo == 1) {
                            votoNulo += 1;
                        }
                    }

                } else if (confima == 0) {
                    System.out.print("VOTO CANCELADO; Por favor digite de novo o codigo do candidato a vereador que você deseja votar: ");
                }

            }

            cont += 1;
            if (cont >= eleitoresVetor.size()) {
                System.out.println("Todos os Eleitores ja votaram.");
                System.out.println("Presidente da urna digite 0 caso queira finalizar a eleição ou qualquer outro numero caso deseje continuar");
                finalizaVotação = Integer.parseInt(entrada.nextLine());
                cont=0;
            }
        }
        Calendar horafinal = Calendar.getInstance();
        int hora = horafinal.get(Calendar.HOUR_OF_DAY);
        int min = horafinal.get(Calendar.MINUTE);
        System.out.println("\n\n------------------Relatorio da Eleição----------------------");
        System.out.println("Hora de inicio da eleição: " + horaAbertura);
        System.out.println("Hora Final: " + hora + ":" + min);
        System.out.println("--Conteudo do Vetor Prefeito---");
        int i = 0;
        for (Prefeito p : prefeitosVetor) {
            System.out.println("\nPrefeito [" + i + "]: ");
            System.out.println("Nome: " + p.getNome());
            System.out.println("Email: " + p.getEmail());
            System.out.println("Data de Nascimento: " + p.getDataNascimento());
            System.out.println("Codigo: " + p.getCodigo());
            System.out.println("Nome do Vice Prefeito: " + p.getVicePrefeito().getNome());
            System.out.println("Números de Votos: " + p.getVoto());
            i += 1;
        }
        i = 0;
        for (Vereador v : vereadorVetor) {
            System.out.println("\nVereador [" + i + "]: ");
            System.out.println("Nome: " + v.getNome());
            System.out.println("Email: " + v.getEmail());
            System.out.println("Data de Nascimento: " + v.getDataNascimento());
            System.out.println("Codigo: " + v.getCodigo());
            System.out.println("Números de Votos: " + v.getVoto());
            i += 1;
        }
        System.out.println();
        System.out.println("Numero de votos brancos: " + votoBranco);
        System.out.println("Numero de votos nulos: " + votoNulo);

    }
}
