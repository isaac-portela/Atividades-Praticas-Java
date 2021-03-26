package atividadepratca02;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableStringConverter;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

public class SistemaCadrastro extends JFrame {
    private ArrayList<Dados> pessoasDados = new ArrayList<Dados>();
    private JLabel[] itens = new JLabel[9];
    private JTextField nome, endereco;
    private JFormattedTextField telefone, cpf, telefone2;
    private JComboBox<String> tipoSanguineo, fatorRh, curso;
    private JTextField contatoEmergencia;
    private JButton inserir, cancelar, mostra;
    private MaskFormatter ftmTelefone, fmtCpf;//Atributo formatador para telefone
    private final String[] cursos = {"Arquitetura e Urbanismo", "Biomedicina", "Ciência da Computação", "Ciências Contábeis",
            "Direito", "Educação Física", "Enfermagem", "Engenharia Civil", "Engenharia Mecânica", "Engenharia da Computação", "Engenharia de Software",
            "Farmácia", "Fisioterapia", "Geografia", "Gestão Comercial", "Gestão Financeira", "Jornalismo", "Letras", "Logística", "Nutrição", "Odontologia",
            "Psicologia", "Rádio, TV e Internet"};

    public SistemaCadrastro() throws ParseException {
        // Chamando  contrutor do Jframe(classe mãe)
        super("Sistema de Cadrastro");
        setSize(400, 450);
        setLayout(null);

        //---------------------------Instanciando JLabel-----------------------------------
        itens[0] = new JLabel("Nome");
        itens[0].setBounds(10, 10, 100, 25);
        itens[1] = new JLabel("Endereço");
        itens[1].setBounds(10, 45, 100, 25);
        itens[2] = new JLabel("Telefone");
        itens[2].setBounds(10, 80, 100, 25);
        itens[3] = new JLabel("CPF");
        itens[3].setBounds(10, 115, 100, 25);
        itens[4] = new JLabel("Tipo sanguineo");
        itens[4].setBounds(10, 150, 140, 25);
        itens[5] = new JLabel("Fator RH");
        itens[5].setBounds(220, 150, 100, 25);
        itens[6] = new JLabel("Curso");
        itens[6].setBounds(10, 185, 100, 25);
        itens[7] = new JLabel("Contato de emergência");
        itens[7].setBounds(10, 220, 140, 25);
        itens[8] = new JLabel("Telefone");
        itens[8].setBounds(10, 255, 100, 25);

        // -----------------------Instanciando JButtons-------------------------------------
        inserir = new JButton("Inserir");
        inserir.setBounds(70, 310, 100, 75);
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(170, 310, 100, 75);
        mostra = new JButton("Mostra");
        mostra.setBounds(270, 310, 100, 75);
        // Instanciando JtextField/JFormattedTextField

        ftmTelefone = new MaskFormatter("+(##) ## ##### ####");
        fmtCpf = new MaskFormatter("###.###.###-##");

        nome = new JTextField();
        nome.setBounds(150, 10, 200, 25);
        endereco = new JTextField();
        endereco.setBounds(150, 45, 200, 25);
        contatoEmergencia = new JTextField();
        contatoEmergencia.setBounds(150, 220, 200, 25);
        telefone = new JFormattedTextField(ftmTelefone);
        telefone.setBounds(150, 80, 200, 25);
        cpf = new JFormattedTextField(fmtCpf);
        cpf.setBounds(150, 115, 200, 25);
        telefone2 = new JFormattedTextField(ftmTelefone);
        telefone2.setBounds(150, 255, 200, 25);

        // ----------------Instanciando JComboBOX----------------------
        tipoSanguineo = new JComboBox<String>();
        tipoSanguineo.setBounds(150, 150, 50, 25);
        tipoSanguineo.addItem("A");
        tipoSanguineo.addItem("B");
        tipoSanguineo.addItem("AB");
        tipoSanguineo.addItem("O");

        fatorRh = new JComboBox<String>();
        fatorRh.setBounds(280, 150, 50, 25);
        fatorRh.addItem("+");
        fatorRh.addItem("-");

        curso = new JComboBox<String>();
        curso.setBounds(150, 185, 200, 25);
        for (String c : cursos) {
            curso.addItem(c);
        }

        // Eventos
        inserir.addActionListener(new BotaoInserir());
        cancelar.addActionListener(new BotaoCancelar());
        mostra.addActionListener(new BotaoMostra());


        // colocandos os componentes no Frame

        getContentPane().add(itens[0]);
        getContentPane().add(nome);
        getContentPane().add(itens[1]);
        getContentPane().add(endereco);
        getContentPane().add(itens[2]);
        getContentPane().add(telefone);
        getContentPane().add(itens[3]);
        getContentPane().add(cpf);
        getContentPane().add(itens[4]);
        getContentPane().add(tipoSanguineo);
        getContentPane().add(itens[5]);
        getContentPane().add(fatorRh);
        getContentPane().add(itens[6]);
        getContentPane().add(curso);
        getContentPane().add(itens[7]);
        getContentPane().add(contatoEmergencia);
        getContentPane().add(itens[8]);
        getContentPane().add(telefone2);
        getContentPane().add(inserir);
        getContentPane().add(cancelar);
        getContentPane().add(mostra);

    }

    public class BotaoInserir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int verifica = 0;
            for (Dados pessoa : pessoasDados) {
                if (pessoa.getNome().equals(nome.getText()) && pessoa.getEndereco().equals(endereco.getText()) && pessoa.getTelefone1().equals(telefone.getText()) || pessoa.getCpf().equals(cpf.getText())) {
                    verifica = 1;
                }
            }
            if (verifica == 1) {
                JOptionPane.showMessageDialog(null, "Você ja está cadastrado", "Aviso", JOptionPane.ERROR_MESSAGE);
            } else if (nome.getText().equals("") || endereco.getText().equals("") || telefone.getText().equals("") || cpf.getText().equals("") || contatoEmergencia.getText().equals("") || telefone2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos", "Aviso", JOptionPane.ERROR_MESSAGE);
            } else {
                pessoasDados.add(new Dados(nome.getText(), endereco.getText(), telefone.getText(), cpf.getText(), String.valueOf(tipoSanguineo.getSelectedItem()), String.valueOf(fatorRh.getSelectedItem()), String.valueOf(curso.getSelectedItem()), contatoEmergencia.getText(), telefone2.getText()));
                JOptionPane.showMessageDialog(null, "Usuario Cadastrado com sucesso", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public class BotaoCancelar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            nome.setText("");
            endereco.setText("");
            telefone.setText("");
            cpf.setText("");
            tipoSanguineo.setSelectedIndex(0);
            fatorRh.setSelectedIndex(0);
            curso.setSelectedIndex(0);
            contatoEmergencia.setText("");
            telefone.setText("");
            telefone2.setText("");
        }
    }

    public class BotaoMostra  implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //String[] colunas = {"Nome", "Endereço", "Telefone", "CPF", "Tipo Sanguineo", "Fator RH", "Curso", "Contato de emergencia", "Telefone"};
            for (Dados pessoa : pessoasDados){
                System.out.println("NOME: "+pessoa.getNome()+"        ENDEREÇO: "+pessoa.getEndereco()+"        TELEFONE: "+ pessoa.getTelefone1()+"        CPF:"+pessoa.getCpf()+"        TIPO SANGUINEO: "+pessoa.getTiposanguineo()+"     FATOR RH:"+pessoa.getFatorrh()+"     CURSO: "+pessoa.getCurso()+"     CONTADO DE EMERGÊNCIA: "+pessoa.getContatoEmergencia()+"     TELEFONE: "+pessoa.getTelefone2()+"     \n");
            }
        }

    }
}
