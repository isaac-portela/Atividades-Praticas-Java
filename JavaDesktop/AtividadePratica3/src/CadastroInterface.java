import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;

public class CadastroInterface extends JFrame {
    private int index = 0;
    private int flag = 0;
    private ArrayList<Dados> pessoasDados = new ArrayList<Dados>();
    private JLabel[] labels = new JLabel[10];
    private JTextField nome, logradouro, numeroLogradouro, profissao;
    private JComboBox<String> tipoLogradouro;
    private JFormattedTextField telefoneResi, telefoneComer, telefoneCell, cpf, rg;
    private MaskFormatter ftmTelefoneResi, fmtCpf, ftmTelefoneCell, ftmTelefoneComer, fmtRg;
    private JButton novo, alterar, excluir, buscar, esquerda, direita, salvar, cancelar;
    private Container ctn;
    private final String[] tipos = {"Aeroporto", "Alameda", "Área", "Avenida", "Campo", "Chácara", "Colônia",
            "Condomínio", "Conjunto", "Distrito", "Esplanada", "Estação", "Estrada", "Favela", "Fazenda", "Feira",
            "Jardim", "Ladeira", "Lago", "Lagoa", "Largo", "Loteamento", "Morro", "Núcleo", "Parque",
            "Passarela", "Pátio", "Praça", "Quadra", "Recanto", "Residencial", "Rodovia", "Rua", "Setor", "Sítio",
            "Travessa", "Trecho", "Trevo", "Vale", "Vereda", "Via", "Viaduto", "Viela", "Vila"};
 

    public CadastroInterface() throws ParseException {
        super("Cadastro");
        setSize(650, 485);
        ctn = getContentPane();
        ctn.setLayout(null);
        // instanciando Jlabels
        labels[0] = new JLabel("Nome");
        labels[1] = new JLabel("Tipo Logradouro");
        labels[2] = new JLabel("Logradouro");
        labels[3] = new JLabel("Número");
        labels[4] = new JLabel("Telefone Residencial");
        labels[5] = new JLabel("Telefone Comercial");
        labels[6] = new JLabel("Telefone Celular");
        labels[7] = new JLabel("CPF");
        labels[8] = new JLabel("RG");
        labels[9] = new JLabel("Profissão");


        labels[0].setBounds(10, 10, 140, 25);
        labels[1].setBounds(10, 40, 140, 25);
        labels[2].setBounds(10, 70, 140, 25);
        labels[3].setBounds(10, 100, 140, 25);
        labels[4].setBounds(10, 140, 140, 25);
        labels[5].setBounds(10, 170, 140, 25);
        labels[6].setBounds(10, 200, 140, 25);
        labels[7].setBounds(10, 230, 140, 25);
        labels[8].setBounds(10, 260, 140, 25);
        labels[9].setBounds(10, 290, 140, 25);
        nome = new JTextField();
        tipoLogradouro = new JComboBox<String>();
        for (String tipo : tipos) {
            tipoLogradouro.addItem(tipo);
        }
        logradouro = new JTextField();
        numeroLogradouro = new JTextField();

        ftmTelefoneResi = new MaskFormatter("(##) ####-####");
        ftmTelefoneComer = new MaskFormatter("#### ### ####");
        ftmTelefoneCell = new MaskFormatter("+(##) ###### ####");
        fmtCpf = new MaskFormatter("###.###.###-##");
        fmtRg = new MaskFormatter("UU-##.###.###");

        telefoneResi = new JFormattedTextField(ftmTelefoneResi);
        telefoneComer = new JFormattedTextField(ftmTelefoneComer);
        telefoneCell = new JFormattedTextField(ftmTelefoneCell);
        cpf = new JFormattedTextField(fmtCpf);
        rg = new JFormattedTextField(fmtRg);
        profissao = new JTextField();

        nome.setBounds(170, 10, 430, 25);
        tipoLogradouro.setBounds(170, 40, 430, 25);
        logradouro.setBounds(170, 70, 430, 25);
        numeroLogradouro.setBounds(170, 100, 430, 25);
        telefoneResi.setBounds(170, 140, 430, 25);
        telefoneComer.setBounds(170, 170, 430, 25);
        telefoneCell.setBounds(170, 200, 430, 25);
        cpf.setBounds(170, 230, 430, 25);
        rg.setBounds(170, 260, 430, 25);
        profissao.setBounds(170, 290, 430, 25);

        novo = new JButton("Novo");
        alterar = new JButton("Alterar");
        excluir = new JButton("Excluir");
        buscar = new JButton("Buscar");
        esquerda = new JButton("<- Esquerda");
        direita = new JButton("Direita ->");
        salvar = new JButton("Salvar");
        cancelar = new JButton("Cancelar");

        novo.setBounds(10, 340, 148, 40);
        alterar.setBounds(158, 340, 148, 40);
        excluir.setBounds(306, 340, 148, 40);
        buscar.setBounds(454, 340, 148, 40);
        esquerda.setBounds(10, 380, 148, 40);
        direita.setBounds(158, 380, 148, 40);
        salvar.setBounds(306, 380, 148, 40);
        cancelar.setBounds(454, 380, 148, 40);

        nome.setEnabled(false);
        tipoLogradouro.setEnabled(false);
        logradouro.setEnabled(false);
        numeroLogradouro.setEnabled(false);
        telefoneResi.setEnabled(false);
        telefoneComer.setEnabled(false);
        telefoneCell.setEnabled(false);
        cpf.setEnabled(false);
        rg.setEnabled(false);
        profissao.setEnabled(false);

        alterar.setEnabled(false);
        direita.setEnabled(false);
        esquerda.setEnabled(false);
        excluir.setEnabled(false);
        salvar.setEnabled(false);
        cancelar.setEnabled(false);
        buscar.setEnabled(false);

        numeroLogradouro.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                String caracteres = "0987654321";
                if (!caracteres.contains(e.getKeyChar() + "")) {
                    e.consume();//aciona esse propriedade para eliminar a ação do evento
                }
                if ((numeroLogradouro.getText().length() >= 10)) {
                    e.consume();
                    numeroLogradouro.setText(numeroLogradouro.getText().substring(0, 10));
// esta linha acima é para remover os caracteres inválidos caso o usuário tenha copiado o
// conteúdo de algum lugar com tamanho maior que o definido.
                }//fim do if do tamanho da string do campo
            }
        });

        novo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trataBotaoNovo();
            }
        });
        alterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trataBotaoAlterar();
            }
        });
        excluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trataBotaoExcluir();
            }
        });
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trataBotaoBuscar();
            }
        });
        esquerda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trataBotaoEsquerda();
            }
        });
        direita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trataBotaoDireita();
            }
        });
        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trataBotaoSalvar();
            }
        });
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trataBotaoCancelar();
            }
        });


        ctn.add(labels[0]);
        ctn.add(labels[1]);
        ctn.add(labels[2]);
        ctn.add(labels[3]);
        ctn.add(labels[4]);
        ctn.add(labels[5]);
        ctn.add(labels[6]);
        ctn.add(labels[7]);
        ctn.add(labels[8]);
        ctn.add(labels[9]);
        ctn.add(nome);
        ctn.add(tipoLogradouro);
        ctn.add(logradouro);
        ctn.add(numeroLogradouro);
        ctn.add(telefoneResi);
        ctn.add(telefoneComer);
        ctn.add(telefoneCell);
        ctn.add(cpf);
        ctn.add(rg);
        ctn.add(profissao);
        ctn.add(novo);
        ctn.add(alterar);
        ctn.add(excluir);
        ctn.add(buscar);
        ctn.add(esquerda);
        ctn.add(direita);
        ctn.add(salvar);
        ctn.add(cancelar);
    }


    private void trataBotaoNovo() {
        nome.setText("");
        tipoLogradouro.setSelectedIndex(0);
        logradouro.setText("");
        numeroLogradouro.setText("");
        telefoneResi.setText("");
        telefoneComer.setText("");
        telefoneCell.setText("");
        cpf.setText("");
        rg.setText("");
        profissao.setText("");
        nome.setEnabled(true);
        tipoLogradouro.setEnabled(true);
        logradouro.setEnabled(true);
        numeroLogradouro.setEnabled(true);
        telefoneResi.setEnabled(true);
        telefoneComer.setEnabled(true);
        telefoneCell.setEnabled(true);
        cpf.setEnabled(true);
        rg.setEnabled(true);
        profissao.setEnabled(true);
        salvar.setEnabled(true);
        novo.setEnabled(false);
        esquerda.setEnabled(false);
        direita.setEnabled(false);
        cancelar.setEnabled(true);
        buscar.setEnabled(false);
        alterar.setEnabled(false);
        excluir.setEnabled(false);
    }

    private void trataBotaoAlterar() {
        flag = 1;
        nome.setEnabled(true);
        tipoLogradouro.setEnabled(true);
        logradouro.setEnabled(true);
        numeroLogradouro.setEnabled(true);
        telefoneResi.setEnabled(true);
        telefoneComer.setEnabled(true);
        telefoneCell.setEnabled(true);
        cpf.setEnabled(true);
        rg.setEnabled(true);
        profissao.setEnabled(true);
        salvar.setEnabled(true);
        alterar.setEnabled(false);
        excluir.setEnabled(false);
        cancelar.setEnabled(true);
    }

    private void trataBotaoExcluir() {
        if (pessoasDados.size() > 0) {
            pessoasDados.remove(pessoasDados.get(index));
            nome.setText("");
            tipoLogradouro.setSelectedIndex(0);
            logradouro.setText("");
            numeroLogradouro.setText("");
            telefoneResi.setText("");
            telefoneComer.setText("");
            telefoneCell.setText("");
            cpf.setText("");
            rg.setText("");
            profissao.setText("");
            nome.setEnabled(false);
            tipoLogradouro.setEnabled(false);
            logradouro.setEnabled(false);
            numeroLogradouro.setEnabled(false);
            telefoneResi.setEnabled(false);
            telefoneComer.setEnabled(false);
            telefoneCell.setEnabled(false);
            cpf.setEnabled(false);
            rg.setEnabled(false);
            profissao.setEnabled(false);
            direita.setEnabled(true);
            esquerda.setEnabled(true);
            salvar.setEnabled(false);
            novo.setEnabled(true);
            buscar.setEnabled(true);
            cancelar.setEnabled(false);
            alterar.setEnabled(false);
            excluir.setEnabled(false);
            alterar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Usuario exluido com Sucesso", "Exluido", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não existe nenhuma pessoa cadastrada, portando não se pode realizar essa operação", "Exluido", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void trataBotaoBuscar() {
         String inputValue = JOptionPane.showInputDialog("Buscar(Digite o nome do usuario que você deseja buscar os  seus dados)");
          int v=-1;
          int i=0;
                for (Dados pessoa : pessoasDados) {
                    if (pessoa.getNome().equals(inputValue)){
                        v = i;
                    } else {
                    }
                    i= i+1;
                }
                if(v!=-1){
                    JOptionPane.showMessageDialog(null,"Nome: "  +pessoasDados.get(v).getNome()+"\n" + "Tipo Logradouro: " + pessoasDados.get(v).getTipoLogradouro()+ "\nCPF: "+ pessoasDados.get(v).getCpf()+ "\nProfissão: " + pessoasDados.get(v).getProfisao() ,"Elemento Buscado",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi possivel buscar os dados dessa pessoa, pois ela não está cadastrada no sistema");
                }
      
    }


    private void trataBotaoEsquerda() {
        if (index == 0 && pessoasDados.size() == 1) {
            setarCampost(pessoasDados.get(index));
        }
        if (index == 0 && pessoasDados.size() > 1) {
            setarCampost(pessoasDados.get(index));
            index--;
        }
        index--;
        if (index >= 0 && pessoasDados.size() > 0) {
            setarCampost(pessoasDados.get(index));
        } else {
            index = 0;
            JOptionPane.showMessageDialog(null, "Você ja está no primeiro registro.", "ALERTA", JOptionPane.WARNING_MESSAGE);
        }

        alterar.setEnabled(true);
        excluir.setEnabled(true);
        cancelar.setEnabled(true);
        novo.setEnabled(false);
        direita.setEnabled(true);
        esquerda.setEnabled(true);
    }

    private void trataBotaoDireita() {
        if (index == 0 && pessoasDados.size() == 1) {
            setarCampost(pessoasDados.get(index));
            index++;
        }
        index++;
        if (index < pessoasDados.size()) {
            setarCampost(pessoasDados.get(index));
        } else {
            index = pessoasDados.size() - 1;
            JOptionPane.showMessageDialog(null, "Você ja está no ultimo registro.", "ALERTA", JOptionPane.WARNING_MESSAGE);
        }
        novo.setEnabled(false);
        alterar.setEnabled(true);
        excluir.setEnabled(true);
        direita.setEnabled(true);
        esquerda.setEnabled(true);
        cancelar.setEnabled(true);
    }

    public void setarCampost(Dados p) {
        nome.setText(p.getNome());
        tipoLogradouro.setSelectedItem(p.getTipoLogradouro());
        logradouro.setText(p.getLogradouro());
        numeroLogradouro.setText(p.getNumeroLogradouro());
        telefoneResi.setText(p.getTelefoneResi());
        telefoneComer.setText(p.getTelefoneComer());
        telefoneCell.setText(p.getTelefoneCell());
        cpf.setText(p.getCpf());
        rg.setText(p.getRg());
        profissao.setText(p.getProfisao());
    }

    private void trataBotaoSalvar() {
        int verifica = 0;
        if (flag == 0) {
            for (Dados pessoa : pessoasDados) {
                if (pessoa.getNome().equals(nome.getText()) && pessoa.getLogradouro().equals(logradouro.getText()) && pessoa.getNumeroLogradouro().equals(numeroLogradouro.getText()) || pessoa.getTelefoneResi().equals(telefoneResi.getText()) || pessoa.getTelefoneComer().equals(telefoneComer.getText()) || pessoa.getTelefoneCell().equals(telefoneCell.getText()) || pessoa.getCpf().equals(cpf.getText()) || pessoa.getRg().equals(rg.getText()) && pessoa.getProfisao().equals(profissao.getText())) {
                    verifica = 1;
                }
            }
            if (verifica == 1) {
                JOptionPane.showMessageDialog(null, "Você ja está cadastrado", "Aviso", JOptionPane.ERROR_MESSAGE);
            } else if (nome.getText().equals("") || logradouro.getText().equals("") || numeroLogradouro.getText().equals("") || telefoneResi.getText().equals("") || telefoneComer.getText().equals("") || telefoneCell.getText().equals("") || cpf.getText().equals("") || rg.getText().equals("") || profissao.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos", "Aviso", JOptionPane.ERROR_MESSAGE);
            } else {
                pessoasDados.add(new Dados(nome.getText(), String.valueOf(tipoLogradouro.getSelectedItem()), logradouro.getText(), numeroLogradouro.getText(), telefoneResi.getText(), telefoneComer.getText(), telefoneCell.getText(), cpf.getText(), rg.getText(), profissao.getText()));
                JOptionPane.showMessageDialog(null, "Usuario Cadastrado com sucesso", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
                nome.setText("");
                tipoLogradouro.setSelectedIndex(0);
                logradouro.setText("");
                numeroLogradouro.setText("");
                telefoneResi.setText("");
                telefoneComer.setText("");
                telefoneCell.setText("");
                cpf.setText("");
                rg.setText("");
                profissao.setText("");
                nome.setEnabled(false);
                tipoLogradouro.setEnabled(false);
                logradouro.setEnabled(false);
                numeroLogradouro.setEnabled(false);
                telefoneResi.setEnabled(false);
                telefoneComer.setEnabled(false);
                telefoneCell.setEnabled(false);
                cpf.setEnabled(false);
                rg.setEnabled(false);
                profissao.setEnabled(false);
                direita.setEnabled(true);
                esquerda.setEnabled(true);
                salvar.setEnabled(false);
                novo.setEnabled(true);
                buscar.setEnabled(true);
                cancelar.setEnabled(false);
                alterar.setEnabled(false);
                excluir.setEnabled(false);
            }
        } else if (flag == 1) {
            if (nome.getText().equals("") || logradouro.getText().equals("") || numeroLogradouro.getText().equals("") || telefoneResi.getText().equals("") || telefoneComer.getText().equals("") || telefoneCell.getText().equals("") || cpf.getText().equals("") || rg.getText().equals("") || profissao.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos", "Aviso", JOptionPane.ERROR_MESSAGE);
            } else {
                pessoasDados.get(index).setNome(nome.getText());
                pessoasDados.get(index).setTipoLogradouro(String.valueOf(tipoLogradouro.getSelectedItem()));
                pessoasDados.get(index).setLogradouro(logradouro.getText());
                pessoasDados.get(index).setLogradouro(numeroLogradouro.getText());
                pessoasDados.get(index).setTelefoneResi(telefoneResi.getText());
                pessoasDados.get(index).setTelefoneComer(telefoneComer.getText());
                pessoasDados.get(index).setTelefoneCell(telefoneCell.getText());
                pessoasDados.get(index).setCpf(cpf.getText());
                pessoasDados.get(index).setRg(rg.getText());
                pessoasDados.get(index).setProfisao(profissao.getText());
                nome.setText("");
                tipoLogradouro.setSelectedIndex(0);
                logradouro.setText("");
                numeroLogradouro.setText("");
                telefoneResi.setText("");
                telefoneComer.setText("");
                telefoneCell.setText("");
                cpf.setText("");
                rg.setText("");
                profissao.setText("");
                nome.setEnabled(false);
                tipoLogradouro.setEnabled(false);
                logradouro.setEnabled(false);
                numeroLogradouro.setEnabled(false);
                telefoneResi.setEnabled(false);
                telefoneComer.setEnabled(false);
                telefoneCell.setEnabled(false);
                cpf.setEnabled(false);
                rg.setEnabled(false);
                profissao.setEnabled(false);
                direita.setEnabled(true);
                esquerda.setEnabled(true);
                salvar.setEnabled(false);
                novo.setEnabled(true);
                buscar.setEnabled(true);
                cancelar.setEnabled(false);
                alterar.setEnabled(false);
                excluir.setEnabled(false);
            }
        }
        flag = 0;
    }


    private void trataBotaoCancelar() {
        nome.setText("");
        tipoLogradouro.setSelectedIndex(0);
        logradouro.setText("");
        numeroLogradouro.setText("");
        telefoneResi.setText("");
        telefoneComer.setText("");
        telefoneCell.setText("");
        cpf.setText("");
        rg.setText("");
        profissao.setText("");
        nome.setEnabled(false);
        tipoLogradouro.setEnabled(false);
        logradouro.setEnabled(false);
        numeroLogradouro.setEnabled(false);
        telefoneResi.setEnabled(false);
        telefoneComer.setEnabled(false);
        telefoneCell.setEnabled(false);
        cpf.setEnabled(false);
        rg.setEnabled(false);
        profissao.setEnabled(false);
        salvar.setEnabled(false);
        novo.setEnabled(true);
        buscar.setEnabled(true);
        direita.setEnabled(true);
        esquerda.setEnabled(true);
        cancelar.setEnabled(false);
        alterar.setEnabled(false);
        excluir.setEnabled(false);
    }
}
