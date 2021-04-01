package avaliacaopratica4bimestre;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SenhaView extends JFrame {
    public static final String caminhoArquivoFila = "c:\\lixo\\fila.txt";
    private Fila<Cliente> fila = new Fila<>();
    private JLabel texto_inicial1, texto_inicial2;
    private JLabel lb_nome, lb_matricula, lb_proximo_atendido, lb_fila, lb_nome_proximo;
    private JTextField jTextNome, jTextMatricula;
    private JTable jTable1;
    private JButton btn_salvar, btn_proximo;
    private JScrollPane scrow;

    public SenhaView() {
        super("SenhaView");
        setSize(500, 600);

        setLayout(null);
        // instanciando elementos do primeiro painel
        texto_inicial1 = new JLabel();
        texto_inicial1.setText("<html><b>Para ser Atendido informe seu Nome e Matricula. Você estará na fila!</b></html>");
        texto_inicial1.setOpaque(true);
        texto_inicial1.setForeground(Color.BLACK);
        texto_inicial2 = new JLabel();
        texto_inicial2.setText("<html><b>Quando chegar a sua vez de ser atendido o seu nome aparecerá no painel</b></html>");
        texto_inicial2.setOpaque(true);
        texto_inicial2.setForeground(Color.BLACK);
        lb_nome = new JLabel("Nome:");
        jTextNome = new JTextField();
        lb_matricula = new JLabel("Matricula:");
        jTextMatricula = new JTextField();
        btn_salvar = new JButton("Salvar");

        // pocionando os elementos do primeiro painel
        texto_inicial1.setBounds(10, 0, 500, 23);
        texto_inicial2.setBounds(10, 20, 500, 20);
        lb_nome.setBounds(10, 50, 200, 20);
        jTextNome.setBounds(10, 75, 465, 26);
        lb_matricula.setBounds(10, 106, 200, 20);
        jTextMatricula.setBounds(10, 131, 465, 26);
        btn_salvar.setBounds(395, 167, 80, 20);
        add(texto_inicial1);
        add(texto_inicial2);
        add(lb_nome);
        add(jTextNome);
        add(lb_matricula);
        add(jTextMatricula);
        add(btn_salvar);


        lb_proximo_atendido = new JLabel("Proximo a ser atendido: ");
        lb_proximo_atendido.setBounds(10, 207, 200, 20);
        lb_nome_proximo = new JLabel("Nome - Matricula");
        lb_nome_proximo.setOpaque(true);
        lb_nome_proximo.setForeground(Color.RED);
        lb_nome_proximo.setFont(new Font("Verdana", Font.BOLD, 20));
        lb_nome_proximo.setBounds(10, 232, 500, 70);
        lb_fila = new JLabel("Fila:");
        lb_fila.setBounds(10, 307, 100, 20);

        // tabela
        String[] columNames = {"Nome", "Matricula"};
        String[][] rowData = {{"", ""}};
        DefaultTableModel tableModel = new DefaultTableModel(rowData, columNames);
        jTable1 = new JTable(tableModel);
        //jTable1.setBounds(10,332,460,180);
        scrow = new JScrollPane(jTable1);
        scrow.setBounds(10, 332, 460, 180);
        btn_proximo = new JButton("Proximo");
        btn_proximo.setBounds(375, 522, 100, 20);

        //Eventos
        btn_salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trataBotaoSalvar();
            }
        });
        btn_proximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trataBotaoProximo();
            }
        });

        add(lb_proximo_atendido);
        add(lb_nome_proximo);
        add(lb_fila);
        add(scrow);
        add(btn_proximo);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void trataBotaoSalvar() {
        if (!jTextNome.getText().equals("") && !jTextMatricula.getText().equals("")) {
        /*
        try {
            fila.carregarArquivo(SenhaView.caminhoArquivoFila, new ConversorCliente());
        } catch (IOException ex) {
            System.out.println("Ocorreu um erro ao carregar o arquivo da fila: " + ex.getMessage());
        }
        */
            Cliente cliente = new Cliente();
            cliente.setNome((this.jTextNome.getText()));
            cliente.setMatricula(this.jTextMatricula.getText());
            fila.inserir(cliente);
        /*
        try {
            fila.salvarArquivo(SenhaView.caminhoArquivoFila);
        } catch (IOException ex) {
            System.out.println("Ocorreu um erro ao salvar a fila: " + ex.getMessage());
        }
         */
            jTextNome.setText("");
            jTextMatricula.setText("");
                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.addColumn("Nome");
                tableModel.addColumn("Matricula");
                for (Object clieteArray : fila.toArray(new ConversorCliente())) {
                    tableModel.addRow((Object[]) clieteArray);
                }
                this.jTable1.setModel(tableModel);

        }

    }

    public void trataBotaoProximo() {
        /*
        try {
            fila.carregarArquivo(SenhaView.caminhoArquivoFila, new ConversorCliente());
        }catch (IOException ex){
            System.out.println("Ocorreu um erro ao carregar o arquivo da fila: " + ex.getMessage());
        }
        */if(!fila.vazia()) {
            try {
                Cliente cliente = fila.remover();
                this.lb_nome_proximo.setText(cliente.getNome() + " - " + cliente.getMatricula());
            } catch (FilaVaziaException ex) {
                System.out.println(ex.getMessage());
            }
        }
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Matricula");
        for (Object clieteArray : fila.toArray(new ConversorCliente())) {
            tableModel.addRow((Object[]) clieteArray);
        }
        this.jTable1.setModel(tableModel);
        tableModel.fireTableDataChanged();

        /*
        try{
            fila.salvarArquivo(SenhaView.caminhoArquivoFila);
        }catch (IOException ex){
            System.out.println("Ocorreu um erro ao salvar a fila: " + ex.getMessage());
        }
    */

    }
}
