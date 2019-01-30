/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.telas.cadastro;

import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import bean.animais.AnimaisDAO;
import bean.animais.AnimaisVO;
import bean.cidades.CidadesVO;
import bean.clientes.ClientesDAO;
import bean.clientes.ClientesVO;
import bean.cpf.CodigoPessoaFisicaDAO;
import bean.cpf.CodigoPessoaFisicaVO;
import bean.dependentes.DependentesDAO;
import bean.dependentes.DependentesVO;
import bean.enderecos.EnderecosDAO;
import bean.enderecos.EnderecosVO;
import bean.especies.EspeciesDAO;
import bean.especies.EspeciesVO;
import bean.racas.RacasDAO;
import bean.racas.RacasVO;
import bean.registro_geral.RegistroGeralDAO;
import bean.registro_geral.RegistroGeralVO;
import bean.uf.UnidadesFederaisDAO;
import bean.uf.UnidadesFederaisVO;
import java.text.ParseException;

/**
 *
 * @author 28233708
 */
public class TelaCadastraClientes extends javax.swing.JInternalFrame {

    private boolean achouCEP = false;
    private boolean achouCEP_Dep = false;
    private boolean pesquisaCEP = false;
    private boolean pesquisaCEP_Dep = false;
    private int ID_Animal = 0;
    private int ID_Dependente = 0;

    /**
     * Creates new form TelaCadastraClientes
     */
    public TelaCadastraClientes() {
        initComponents();
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        this.alimentaJComboBox();
    }

    public void alimentaJComboBox() {

        UnidadesFederaisDAO estadoDAO = new UnidadesFederaisDAO();
        for (UnidadesFederaisVO e : estadoDAO.listarTodos()) {
            cmbEstado.addItem(e.getNome());
            cmbEstadoDep.addItem(e.getNome());
        }

        EspeciesDAO especieDAO = new EspeciesDAO();
        for (EspeciesVO es : especieDAO.listarTodos()) {
            cmbEspecies.addItem(es.getDescricao());
        }

    }

    public static String formatString(String string, String mask)
            throws java.text.ParseException {
        javax.swing.text.MaskFormatter mf = new javax.swing.text.MaskFormatter(mask);
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(string);
    }

    public void preencheCampos(ClientesVO cliente, DependentesVO dependente, char tipo) {
        if (tipo == 'C') {
            txtCpf.setText(cliente.getCpf().getCpf());
            cmbTipoCpf.setSelectedItem(cliente.getCpf().getTipo());
            txtRg.setText(cliente.getRg().getRg());
            txtNome.setText(cliente.getNome());
            cmbtpoCliente.setSelectedItem(cliente.getTipo());
            switch (cliente.getSexo()) {
                case "MASCULINO":
                    rdbMasc.setSelected(true);
                    break;
                case "FEMININO":
                    rdbFem.setSelected(true);
                    break;
            }
            txtCep.setText(cliente.getCep().getCep());
            cmbEstado.setSelectedItem(cliente.getCep().getEstado());
            cmbCidade.setSelectedItem(cliente.getCep().getCidade());
            txtEndereco.setText(cliente.getCep().getEndereco());
            txtBairro.setText(cliente.getCep().getBairro());
            txtNum.setText(String.valueOf(cliente.getNum_resid()));
            txtEmail.setText(cliente.getEmail());
            txtTelefone.setText(cliente.getTelefone());
            txtCelular.setText(cliente.getCelular());
        } 
        else if(tipo == 'D'){
            txtCpfDepen.setText(dependente.getCpf().getCpf());
            cmbTipoCpfDep.setSelectedItem(dependente.getCpf().getTipo());
            txtRgDepen.setText(dependente.getRg().getRg());
            txtNomeDepen.setText(dependente.getNome());
            cmbtpoCliente.setSelectedItem(cliente.getTipo());
            switch (dependente.getSexo()) {
                case "MASCULINO":
                    rdbMasculinoDep.setSelected(true);
                    break;
                case "FEMININO":
                    rdbFemininoDep.setSelected(true);
                    break;
            }
            txtCepDepen.setText(dependente.getCep().getCep());
            cmbEstadoDep.setSelectedItem(dependente.getCep().getEstado());
            cmbCidadeDep.setSelectedItem(dependente.getCep().getCidade());
            txtEndDepen.setText(dependente.getCep().getEndereco());
            txtBairroDep.setText(dependente.getCep().getBairro());
            txtNumDep.setText(String.valueOf(dependente.getNum_resid()));
            txtEmailDepen.setText(dependente.getEmail());
            txtCelDepen.setText(dependente.getCelular());
        }

    }

    public void bloquearCampos() {
        btnCadastar.setEnabled(false);
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);

        txtCpf.setEditable(false);
        txtCpfDepen.setEditable(false);
        cmbTipoCpf.setEnabled(false);
        cmbTipoCpfDep.setEnabled(false);
        txtRg.setEditable(false);
        txtRgDepen.setEditable(false);
        txtNome.setEditable(false);
        txtNomeDepen.setEditable(false);
        txtNomeAnimal.setEditable(false);
        cmbtpoCliente.setEnabled(false);
        rdbMasc.setEnabled(false);
        rdbMasculinoDep.setEnabled(false);
        rbtMacho.setEnabled(false);
        rdbFem.setEnabled(false);
        rdbFemininoDep.setEnabled(false);
        rbtFemea.setEnabled(false);
        txtCep.setEditable(false);
        txtCepDepen.setEditable(false);
        btnBuscarCep.setEnabled(false);
        btnBuscarCepDep.setEnabled(false);
        cmbEstado.setEnabled(false);
        cmbEstadoDep.setEnabled(false);
        cmbCidade.setEnabled(false);
        cmbCidadeDep.setEnabled(false);
        txtEndereco.setEditable(false);
        txtEndDepen.setEditable(false);
        txtBairro.setEditable(false);
        txtBairroDep.setEditable(false);
        txtNum.setEditable(false);
        txtNumDep.setEditable(false);
        txtEmail.setEditable(false);
        txtEmailDepen.setEditable(false);
        txtTelefone.setEditable(false);
        txtCelular.setEditable(false);
        txtCelDepen.setEditable(false);
    }

    public void desbloquearCampos() {
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSelect.setEnabled(false);
        btnUpdate.setEnabled(true);

        txtCpf.setEditable(true);
        txtCpfDepen.setEditable(true);
        cmbTipoCpf.setEnabled(true);
        cmbTipoCpfDep.setEnabled(true);
        txtRg.setEditable(true);
        txtRgDepen.setEditable(true);
        txtNome.setEditable(true);
        txtNomeDepen.setEditable(true);
        txtNomeAnimal.setEditable(true);
        cmbtpoCliente.setEnabled(true);
        rdbMasc.setEnabled(true);
        rdbMasculinoDep.setEnabled(true);
        rbtMacho.setEnabled(true);
        rdbFem.setEnabled(true);
        rdbFemininoDep.setEnabled(true);
        rbtFemea.setEnabled(true);
        txtCep.setEditable(true);
        txtCepDepen.setEditable(true);
        btnBuscarCep.setEnabled(true);
        btnBuscarCepDep.setEnabled(true);
        cmbEstado.setEnabled(true);
        cmbEstadoDep.setEnabled(true);
        cmbCidade.setEnabled(true);
        cmbCidadeDep.setEnabled(true);
        txtEndereco.setEditable(true);
        txtEndDepen.setEditable(true);
        txtBairro.setEditable(true);
        txtBairroDep.setEditable(true);
        txtNum.setEditable(true);
        txtNumDep.setEditable(true);
        txtEmail.setEditable(true);
        txtEmailDepen.setEditable(true);
        txtTelefone.setEditable(true);
        txtCelular.setEditable(true);
        txtCelDepen.setEditable(true);
    }

    public void recomecar() {
        limpaCampos();
        desbloquearCampos();
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnCadastar.setEnabled(true);
        btnSelect.setEnabled(true);
    }

    public void limpaCampos() {
        txtCpf.setText("");
        txtRg.setText("");
        txtNome.setText("");
        txtNasc.setText("");
        txtCep.setText("");
        txtCep.setEditable(true);
        btnBuscarCep.setEnabled(true);
        txtEmail.setText("");
        txtEndereco.setText("");
        txtEndereco.setEditable(true);
        txtNum.setText("");
        txtBairro.setText("");
        txtBairro.setEditable(true);
        txtTelefone.setText("");
        txtCelular.setText("");
        txtNomeDepen.setText("");
        txtCpfDepen.setText("");
        txtRgDepen.setText("");
        txtCepDepen.setText("");
        txtCepDepen.setEditable(true);
        btnBuscarCepDep.setEnabled(true);
        txtEndDepen.setText("");
        txtEndDepen.setEditable(true);
        txtBairroDep.setText("");
        txtBairroDep.setEditable(true);
        txtNumDep.setText("");
        txtEmailDepen.setText("");
        txtCelDepen.setText("");
        txtAreaObsAnimal.setText("");
        //limpando e desbloqueando JComboxs 
        cmbEstado.setEnabled(true);
        cmbEstado.setSelectedIndex(0);
        cmbEstadoDep.setEnabled(true);
        cmbEstadoDep.setSelectedIndex(0);
        cmbCidade.setEnabled(true);
        cmbCidade.setSelectedIndex(0);
        cmbCidadeDep.setEnabled(true);
        cmbCidadeDep.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCliente = new javax.swing.ButtonGroup();
        buttonGroupDep = new javax.swing.ButtonGroup();
        buttonGroupAnimal = new javax.swing.ButtonGroup();
        jPanelDadosPessoais = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNome = new JTextFieldFormatado(50, 'L');
        rdbMasc = new javax.swing.JRadioButton();
        rdbFem = new javax.swing.JRadioButton();
        lblFotoCliente = new javax.swing.JLabel();
        btnFotoCliente = new javax.swing.JButton();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtRg = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbtpoCliente = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbTipoCpf = new javax.swing.JComboBox<>();
        jPanelContato = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbCidade = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtNum = new JTextFieldFormatado(4, 'N');
        txtTelefone = new javax.swing.JFormattedTextField();
        txtEndereco = new JTextFieldFormatado(100, 'L');
        txtCelular = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBairro = new JTextFieldFormatado(45, 'L');
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnBuscarCep = new javax.swing.JButton();
        cmbEstado = new javax.swing.JComboBox<>();
        btnCadastar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanelDependente = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtNomeDepen = new JTextFieldFormatado(50, 'L');
        txtCpfDepen = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        txtEndDepen = new JTextFieldFormatado(100, 'L');
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRgDepen = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCepDepen = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        txtEmailDepen = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtCelDepen = new javax.swing.JFormattedTextField();
        lblSexoDep = new javax.swing.JLabel();
        rdbMasculinoDep = new javax.swing.JRadioButton();
        rdbFemininoDep = new javax.swing.JRadioButton();
        lblFotoDep = new javax.swing.JLabel();
        btnFotoDep = new javax.swing.JButton();
        btnBuscarCepDep = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        cmbCidadeDep = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        cmbEstadoDep = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        cmbTipoCpfDep = new javax.swing.JComboBox<>();
        txtBairroDep = new JTextFieldFormatado(45, 'L');
        jLabel30 = new javax.swing.JLabel();
        txtNumDep = new JTextFieldFormatado(4, 'N');
        jPanelAnimal = new javax.swing.JPanel();
        lblFotoAnimal = new javax.swing.JLabel();
        btnFotoAnimal = new javax.swing.JButton();
        lblNomeAnimal = new javax.swing.JLabel();
        cmbCor = new javax.swing.JComboBox<>();
        lblCor = new javax.swing.JLabel();
        lblRaca = new javax.swing.JLabel();
        cmbRaca = new javax.swing.JComboBox<>();
        lblSexoAnimal = new javax.swing.JLabel();
        rbtMacho = new javax.swing.JRadioButton();
        rbtFemea = new javax.swing.JRadioButton();
        txtNomeAnimal = new JTextFieldFormatado(50, 'L');
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaObsAnimal = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtNasc = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbEspecies = new javax.swing.JComboBox<>();
        btnSelect = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("CADASTRO DE NOVOS CLIENTES");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanelDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jLabel4.setText("Nome completo:");

        lblSexo.setText("Sexo:");

        jLabel10.setText("CPF:");

        buttonGroupCliente.add(rdbMasc);
        rdbMasc.setSelected(true);
        rdbMasc.setText("Masculino");

        buttonGroupCliente.add(rdbFem);
        rdbFem.setText("Feminino");

        lblFotoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/img/clientes/cliente (2).png"))); // NOI18N

        btnFotoCliente.setText("Enviar foto");
        btnFotoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoClienteActionPerformed(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel19.setText("RG:");

        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Tipo de cliente:");

        cmbtpoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COMUM", "FREGUÊS" }));

        jLabel11.setText("Tipo de CPF:");

        cmbTipoCpf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "P.FÍSICA", "P.JURÍDICA" }));

        javax.swing.GroupLayout jPanelDadosPessoaisLayout = new javax.swing.GroupLayout(jPanelDadosPessoais);
        jPanelDadosPessoais.setLayout(jPanelDadosPessoaisLayout);
        jPanelDadosPessoaisLayout.setHorizontalGroup(
            jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(122, 122, 122))
            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(lblSexo)
                        .addGap(18, 18, 18)
                        .addComponent(rdbMasc)
                        .addGap(18, 18, 18)
                        .addComponent(rdbFem))
                    .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbtpoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(lblFotoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(btnFotoCliente)
                        .addGap(26, 26, 26))))
        );
        jPanelDadosPessoaisLayout.setVerticalGroup(
            jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel11)
                    .addComponent(cmbTipoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbtpoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbFem)
                    .addComponent(rdbMasc)
                    .addComponent(lblSexo))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                .addComponent(lblFotoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFotoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2))
        );

        jPanelContato.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

        jLabel16.setText("CEP:");

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Telefone:");

        jLabel6.setText("Celular:");

        jLabel14.setText("Cidade:");

        cmbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel15.setText("Estado:");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Endereço:");

        jLabel12.setText("N°");

        jLabel13.setText("Bairro:");

        jLabel20.setText("E-mail:");

        btnBuscarCep.setText("Buscar");
        btnBuscarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCepActionPerformed(evt);
            }
        });

        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContatoLayout = new javax.swing.GroupLayout(jPanelContato);
        jPanelContato.setLayout(jPanelContatoLayout);
        jPanelContatoLayout.setHorizontalGroup(
            jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContatoLayout.createSequentialGroup()
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContatoLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel16))
                    .addGroup(jPanelContatoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelContatoLayout.createSequentialGroup()
                        .addGap(493, 493, 493)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtCelular))
                    .addGroup(jPanelContatoLayout.createSequentialGroup()
                        .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelContatoLayout.createSequentialGroup()
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(btnBuscarCep, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstado, 0, 235, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContatoLayout.createSequentialGroup()
                                .addComponent(txtEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addGap(1, 1, 1)))
                        .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelContatoLayout.createSequentialGroup()
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(59, 59, 59))
            .addGroup(jPanelContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelContatoLayout.setVerticalGroup(
            jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContatoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        btnCadastar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnCadastar.setText("Cadastrar");
        btnCadastar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jPanelDependente.setBorder(javax.swing.BorderFactory.createTitledBorder("Seu dependente"));

        jLabel23.setText("Nome completo:");

        jLabel25.setText("CPF:");

        try {
            txtCpfDepen.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel17.setText("Endereço:");

        jLabel18.setText("N°");

        jLabel8.setText("RG:");

        try {
            txtRgDepen.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel21.setText("CEP:");

        try {
            txtCepDepen.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel22.setText("E-mail:");

        jLabel26.setText("Celular:");

        try {
            txtCelDepen.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblSexoDep.setText("Sexo: ");

        buttonGroupDep.add(rdbMasculinoDep);
        rdbMasculinoDep.setSelected(true);
        rdbMasculinoDep.setText("Masculino\n");

        buttonGroupDep.add(rdbFemininoDep);
        rdbFemininoDep.setText("Feminino");

        lblFotoDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/img/clientes/chamar.png"))); // NOI18N

        btnFotoDep.setText("Enviar foto");

        btnBuscarCepDep.setText("Buscar");
        btnBuscarCepDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCepDepActionPerformed(evt);
            }
        });

        jLabel27.setText("Cidade:");

        cmbCidadeDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel28.setText("Estado:");

        cmbEstadoDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoDepActionPerformed(evt);
            }
        });

        jLabel29.setText("Tipo de CPF:");

        cmbTipoCpfDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "P.FÍSICA", "P.JURÍDICA" }));

        jLabel30.setText("Bairro:");

        javax.swing.GroupLayout jPanelDependenteLayout = new javax.swing.GroupLayout(jPanelDependente);
        jPanelDependente.setLayout(jPanelDependenteLayout);
        jPanelDependenteLayout.setHorizontalGroup(
            jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDependenteLayout.createSequentialGroup()
                .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDependenteLayout.createSequentialGroup()
                        .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDependenteLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDependenteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel22)
                                .addGap(8, 8, 8)
                                .addComponent(txtEmailDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDependenteLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBairroDep, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumDep, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDependenteLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCelDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGap(27, 27, 27)
                        .addComponent(btnFotoDep))
                    .addGroup(jPanelDependenteLayout.createSequentialGroup()
                        .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDependenteLayout.createSequentialGroup()
                                .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDependenteLayout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNomeDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDependenteLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCpfDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbTipoCpfDep, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)))
                                .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelDependenteLayout.createSequentialGroup()
                                            .addGap(43, 43, 43)
                                            .addComponent(txtRgDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDependenteLayout.createSequentialGroup()
                                            .addComponent(lblSexoDep)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(rdbMasculinoDep)
                                            .addGap(18, 18, 18)
                                            .addComponent(rdbFemininoDep)))))
                            .addGroup(jPanelDependenteLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCepDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarCepDep, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstadoDep, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCidadeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, 76)
                        .addComponent(lblFotoDep, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDependenteLayout.setVerticalGroup(
            jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDependenteLayout.createSequentialGroup()
                .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDependenteLayout.createSequentialGroup()
                        .addComponent(lblFotoDep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFotoDep)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanelDependenteLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25)
                                .addComponent(txtCpfDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(txtRgDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29))
                            .addComponent(cmbTipoCpfDep))
                        .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDependenteLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNomeDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSexoDep)
                                    .addComponent(rdbMasculinoDep)
                                    .addComponent(rdbFemininoDep)))
                            .addGroup(jPanelDependenteLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCepDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCepDep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(cmbEstadoDep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(cmbCidadeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEndDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel18)
                            .addComponent(txtNumDep, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBairroDep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))))
                .addGap(7, 7, 7)
                .addGroup(jPanelDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCelDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel22)
                    .addComponent(txtEmailDepen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAnimal.setBorder(javax.swing.BorderFactory.createTitledBorder("Seu Animal"));

        lblFotoAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petshop/img/animais/cachorro.png"))); // NOI18N

        btnFotoAnimal.setText("Enviar foto");

        lblNomeAnimal.setText("Nome do animal:");

        cmbCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRETO", "BRANCO", "CINZENTO", "DOURADO", "AMARELO", "CHOCOLATE", "CREME", "AZUL", "VERMELHO", " " }));

        lblCor.setText("Cor:");

        lblRaca.setText("Raça:");

        cmbRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        lblSexoAnimal.setText("Sexo:");

        buttonGroupAnimal.add(rbtMacho);
        rbtMacho.setSelected(true);
        rbtMacho.setText("Macho");

        buttonGroupAnimal.add(rbtFemea);
        rbtFemea.setText("Fêmea");

        jLabel24.setText("Observações:");

        txtAreaObsAnimal.setColumns(20);
        txtAreaObsAnimal.setRows(5);
        jScrollPane2.setViewportView(txtAreaObsAnimal);

        jLabel9.setText("Data de Nascimento:");

        try {
            txtNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Espécie:");

        cmbEspecies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEspeciesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAnimalLayout = new javax.swing.GroupLayout(jPanelAnimal);
        jPanelAnimal.setLayout(jPanelAnimalLayout);
        jPanelAnimalLayout.setHorizontalGroup(
            jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAnimalLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblSexoAnimal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAnimalLayout.createSequentialGroup()
                                .addComponent(rbtMacho)
                                .addGap(18, 18, 18)
                                .addComponent(rbtFemea))
                            .addGroup(jPanelAnimalLayout.createSequentialGroup()
                                .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCor)
                                    .addComponent(lblRaca))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAnimalLayout.createSequentialGroup()
                        .addGap(0, 115, Short.MAX_VALUE)
                        .addComponent(btnFotoAnimal)
                        .addGap(116, 116, 116))
                    .addGroup(jPanelAnimalLayout.createSequentialGroup()
                        .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAnimalLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbEspecies, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAnimalLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAnimalLayout.createSequentialGroup()
                                .addComponent(lblNomeAnimal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(16, Short.MAX_VALUE))))
            .addGroup(jPanelAnimalLayout.createSequentialGroup()
                .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAnimalLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel24))
                    .addGroup(jPanelAnimalLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lblFotoAnimal)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelAnimalLayout.setVerticalGroup(
            jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAnimalLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblFotoAnimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFotoAnimal)
                .addGap(23, 23, 23)
                .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbEspecies, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNomeAnimal)
                    .addComponent(txtNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexoAnimal)
                    .addComponent(rbtMacho)
                    .addComponent(rbtFemea))
                .addGap(18, 18, 18)
                .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRaca)
                    .addComponent(cmbRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCor)
                    .addComponent(cmbCor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnSelect.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnSelect.setText("Encontrar");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnDelete.setText("Deletar");

        btnEdit.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnUpdate.setText("Atualizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelDependente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadastar))
                    .addComponent(jPanelAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelDependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAnimal.getAccessibleContext().setAccessibleName("Seu animal\n");

        setBounds(250, 150, 1285, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here: 
        recomecar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void inserirAnimal() {
        try {//tentando inserir um animal
            AnimaisVO animalVO = new AnimaisVO();

            CodigoPessoaFisicaVO cpf = new CodigoPessoaFisicaVO();
            cpf.setCpf(txtCpf.getText());
            animalVO.setCpf(cpf);

            String resultado = (String) cmbEspecies.getSelectedItem();
            switch (resultado) {
                case "CANINA":
                    EspeciesVO especie = new EspeciesVO();
                    especie.setCod("C");
                    animalVO.setEspecie(especie);//especie
                    break;
                case "FELINA":
                    EspeciesVO especie1 = new EspeciesVO();
                    especie1.setCod("F");
                    animalVO.setEspecie(especie1);//especie
                    break;
            }

            animalVO.setNome(txtNomeAnimal.getText());//nome
            animalVO.setDataNasc(txtNasc.getText());//data nascimento

            if (rbtMacho.isSelected()) {
                animalVO.setSexoA("MACHO");
            } else {
                animalVO.setSexoA("FÊMEA");
            }

            RacasVO raca = new RacasVO();
            raca.setNome((String) cmbRaca.getSelectedItem());
            animalVO.setRaca(raca);//raça escolhida

            animalVO.setCor(cmbCor.getSelectedItem().toString());//cor
            animalVO.setObservacao(txtAreaObsAnimal.getText());//observações      

            AnimaisDAO animalDAO = new AnimaisDAO();
            animalDAO.inserir(animalVO);

            //JOptionPane.showMessageDialog(null, animalVO.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar animal! \n" + ex + JOptionPane.ERROR_MESSAGE);
        } finally {
            AnimaisDAO animalDAO = new AnimaisDAO();
            List<AnimaisVO> pegaID = animalDAO.selecionar(txtCpf.getText(), 2);
            if (!pegaID.isEmpty()) {
                for (AnimaisVO a : pegaID) {
                    ID_Animal = a.getCod();
                    JOptionPane.showMessageDialog(null, "ID Animal= " + ID_Animal);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ID não encontrado!");
            }
        }
    }

    private void inserirDependente() {
        try {//tentando inserir dependente
            DependentesVO dependentesVO = new DependentesVO();

            CodigoPessoaFisicaVO cpf = new CodigoPessoaFisicaVO();
            cpf.setCpf(txtCpfDepen.getText());
            cpf.setTipo((String) cmbTipoCpfDep.getSelectedItem());
            dependentesVO.setCpf(cpf);
            CodigoPessoaFisicaDAO cpfDAO = new CodigoPessoaFisicaDAO();
            cpfDAO.inserir(cpf);

            RegistroGeralVO rg = new RegistroGeralVO();
            rg.setRg(txtRgDepen.getText());
            dependentesVO.setRg(rg);
            RegistroGeralDAO rgDAO = new RegistroGeralDAO();
            rgDAO.inserir(rg);

            dependentesVO.setNome(txtNomeDepen.getText());

            if (rdbMasculinoDep.isSelected()) {
                dependentesVO.setSexo("MASCULINO");
            } else {
                dependentesVO.setSexo("FEMININO");
            }

            dependentesVO.setNum_resid(Integer.parseInt(txtNumDep.getText()));
            dependentesVO.setEmail(txtEmail.getText());
            dependentesVO.setCelular(txtCelular.getText());

            if (pesquisaCEP_Dep == false) {
                //endereco do dependente
                EnderecosVO enderecosVO = new EnderecosVO();
                enderecosVO.setCep(txtCepDepen.getText());
                dependentesVO.setCep(enderecosVO);
                enderecosVO.setEndereco(txtEndDepen.getText());
                enderecosVO.setBairro(txtBairroDep.getText());

                CidadesVO cidade = new CidadesVO();
                cidade.setNome((String) cmbCidadeDep.getSelectedItem());
                enderecosVO.setCidade(cidade);

                UnidadesFederaisVO estado = new UnidadesFederaisVO();
                estado.setNome((String) cmbEstadoDep.getSelectedItem());
                enderecosVO.setEstado(estado);

                EnderecosDAO enderecosDAO = new EnderecosDAO();
                enderecosDAO.insert(enderecosVO);
                /*JOptionPane.showMessageDialog(null, enderecosVO.toString());
                JOptionPane.showMessageDialog(null, dependentesVO.toString());*/
            } else if (pesquisaCEP_Dep == true) {
                EnderecosVO enderecosVO = new EnderecosVO();
                enderecosVO.setCep(txtCepDepen.getText());
                dependentesVO.setCep(enderecosVO);
                //JOptionPane.showMessageDialog(null, dependentesVO.toString());
            }
            DependentesDAO dependentesDAO = new DependentesDAO();
            dependentesDAO.insert(dependentesVO);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira apenas números no campo 'N°' \n"
                    + e.getMessage() + JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar dependente! \n" + ex
                    + JOptionPane.ERROR_MESSAGE);
        } finally {
            DependentesDAO dependenteDAO = new DependentesDAO();
            List<DependentesVO> pegaID = dependenteDAO.selecionar(txtCpfDepen.getText(), 2);
            if (!pegaID.isEmpty()) {
                for (DependentesVO d : pegaID) {
                    ID_Dependente = d.getCod();
                    JOptionPane.showMessageDialog(null, "ID Dependente= " + ID_Dependente);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ID não encontrado!");
            }
        }

    }

    private void inserirCliente() {
        try {//tentando inserir cliente
            ClientesVO clienteVO = new ClientesVO();

            //pegando ID e jogando na ClienteVO
            AnimaisVO animal = new AnimaisVO();
            animal.setCod(ID_Animal);
            clienteVO.setAnimal(animal);

            DependentesVO dependente = new DependentesVO();
            dependente.setCod(ID_Dependente);
            clienteVO.setDependente(dependente);

            //pegando cpf digitado e inserindo na tabela cpf
            CodigoPessoaFisicaVO cpf = new CodigoPessoaFisicaVO();
            cpf.setCpf(txtCpf.getText());
            cpf.setTipo((String) cmbTipoCpf.getSelectedItem());
            clienteVO.setCpf(cpf);//inserindo cpf do cliente
            CodigoPessoaFisicaDAO cpfDAO = new CodigoPessoaFisicaDAO();
            cpfDAO.inserir(cpf);

            //pegando rg digitado e inserindo na tabela rg
            RegistroGeralVO rg = new RegistroGeralVO();
            rg.setRg(txtRg.getText());
            clienteVO.setRg(rg);//inserindo rg do cliente
            RegistroGeralDAO rgDAO = new RegistroGeralDAO();
            rgDAO.inserir(rg);

            clienteVO.setNome(txtNome.getText());//nome

            if (rdbMasc.isSelected()) {//sexo
                clienteVO.setSexo("MASCULINO");
            } else {
                clienteVO.setSexo("FEMININO");
            }

            clienteVO.setTipo((String) cmbtpoCliente.getSelectedItem());//tipo
            clienteVO.setEmail(txtEmail.getText());
            clienteVO.setNum_resid(Integer.parseInt(txtNum.getText()));
            clienteVO.setTelefone(txtTelefone.getText());
            clienteVO.setCelular(txtCelular.getText());

            if (pesquisaCEP == false) {
                //endereco do cliente
                EnderecosVO enderecoVO = new EnderecosVO();
                enderecoVO.setCep(txtCep.getText());
                clienteVO.setCep(enderecoVO);//cep
                enderecoVO.setEndereco(txtEndereco.getText());
                enderecoVO.setBairro(txtBairro.getText());

                CidadesVO cidade = new CidadesVO();
                cidade.setNome((String) cmbCidade.getSelectedItem());
                enderecoVO.setCidade(cidade);

                UnidadesFederaisVO estado = new UnidadesFederaisVO();
                estado.setNome((String) cmbEstado.getSelectedItem());
                enderecoVO.setEstado(estado);

                EnderecosDAO enderecosDAO = new EnderecosDAO();
                enderecosDAO.insert(enderecoVO);
                //JOptionPane.showMessageDialog(null, enderecoVO.toString());
                //JOptionPane.showMessageDialog(null, clienteVO.toString());
            } else if (pesquisaCEP == true) {
                EnderecosVO enderecoVO = new EnderecosVO();
                enderecoVO.setCep(txtCep.getText());
                clienteVO.setCep(enderecoVO);
                //JOptionPane.showMessageDialog(null, clienteVO.toString());
            }
            ClientesDAO clientesDAO = new ClientesDAO();
            if (clientesDAO.inserir(clienteVO)) {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                limpaCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro NÃO foi feito!" + JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira apenas números inteiros no campo 'N°'.\n"
                    + e.getMessage() + JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar cliente! \n" + ex.getMessage()
                    + JOptionPane.ERROR_MESSAGE);
        } finally {
            JOptionPane.showMessageDialog(null, "ID ANIMAL= " + ID_Animal + "\n"
                    + "ID DEPENDENTE= " + ID_Dependente);
        }
    }

    private void btnCadastarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastarActionPerformed
        // TODO add your handling code here:

        EnderecosDAO enderecosDAO = new EnderecosDAO();
        if (pesquisaCEP == false) {
            if (!txtCep.getText().trim().equals("-")) {
                if (enderecosDAO.existeCep(txtCep.getText())) {
                    JOptionPane.showMessageDialog(null, "CEP já foi cadastrado!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                    txtCep.setText("");
                    txtCep.requestFocus();
                    achouCEP = true;
                } else {
                    achouCEP = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha o campo CEP. C", "ALERTA", JOptionPane.WARNING_MESSAGE);
                txtCep.requestFocus();
                achouCEP = true;
            }
        }
        EnderecosDAO enderecosDAO1 = new EnderecosDAO();
        if (pesquisaCEP_Dep == false) {
            if (!txtCepDepen.getText().trim().equals("-")) {
                if (enderecosDAO1.existeCep(txtCepDepen.getText())) {
                    JOptionPane.showMessageDialog(null, "CEP já foi cadastrado!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                    txtCepDepen.setText("");
                    txtCepDepen.requestFocus();
                    achouCEP_Dep = true;
                } else {
                    achouCEP_Dep = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha o campo CEP. D", "ALERTA", JOptionPane.WARNING_MESSAGE);
                txtCepDepen.requestFocus();
                achouCEP_Dep = true;
            }
        }
        if (achouCEP == false && achouCEP_Dep == false) {
            /* 
            inserirAnimal();
            inserirDependente();
            inserirCliente();
             */
            JOptionPane.showMessageDialog(null, "Salvando no BANCO... ", "SALVANDO", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btnCadastarActionPerformed

    private void btnFotoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoClienteActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setDialogTitle("Procurar uma imagem para o cliente ");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem", "jpg", "png", "jpeg");

        fileChooser.setFileFilter(filter);
        int retorno = fileChooser.showOpenDialog(this);

        if (retorno == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();
            lblFotoCliente.setIcon(new ImageIcon(file.getPath()));

        } else {
            return;

        }
    }//GEN-LAST:event_btnFotoClienteActionPerformed

    private void btnBuscarCepDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCepDepActionPerformed
        // TODO add your handling code here:
        EnderecosDAO enderecosDAO = new EnderecosDAO();
        List<EnderecosVO> resultado = enderecosDAO.selecionar(txtCepDepen.getText(), 1);
        if (!resultado.isEmpty()) {
            for (EnderecosVO e : resultado) {
                txtEndDepen.setText(e.getEndereco());
                txtBairroDep.setText(e.getBairro());
                cmbEstadoDep.setSelectedItem(e.getEstado().getNome());
                cmbCidadeDep.setSelectedItem(e.getCidade().getNome());
            }
            txtCepDepen.setEditable(false);
            txtEndDepen.setEditable(false);
            txtBairroDep.setEditable(false);
            cmbEstadoDep.setEnabled(false);
            cmbCidadeDep.setEnabled(false);
            pesquisaCEP_Dep = true;
            btnBuscarCepDep.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "CEP não encontrado!");
            txtCepDepen.setText("");
            txtEndDepen.setText("");
            txtBairroDep.setText("");
            pesquisaCEP_Dep = false;
        }
    }//GEN-LAST:event_btnBuscarCepDepActionPerformed

    private void cmbEstadoDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoDepActionPerformed
        // TODO add your handling code here:
        String resultado = (String) cmbEstadoDep.getSelectedItem();
        cmbCidadeDep.removeAllItems();
        EnderecosDAO dao = new EnderecosDAO();
        List<EnderecosVO> lista = dao.selecionar(resultado, 2);
        if (!lista.isEmpty()) {
            for (EnderecosVO e : lista) {
                cmbCidadeDep.addItem(e.getCidade().getNome());
            }
        } else {
            cmbCidadeDep.removeAllItems();
        }
    }//GEN-LAST:event_cmbEstadoDepActionPerformed

    private void cmbEspeciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEspeciesActionPerformed
        // TODO add your handling code here:
        String resultado = (String) cmbEspecies.getSelectedItem();
        cmbRaca.removeAllItems();
        RacasDAO dao = new RacasDAO();
        List<RacasVO> lista = dao.selecionar(resultado, 2);
        if (!lista.isEmpty()) {
            for (RacasVO r : lista) {
                cmbRaca.addItem(r.getNome());
            }
            cmbRaca.setEnabled(true);
        } else {
            cmbRaca.removeAllItems();
        }
    }//GEN-LAST:event_cmbEspeciesActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
        String resultado = (String) cmbEstado.getSelectedItem();
        cmbCidade.removeAllItems();
        EnderecosDAO dao = new EnderecosDAO();
        List<EnderecosVO> lista = dao.selecionar(resultado, 2);
        if (!lista.isEmpty()) {
            for (EnderecosVO e : lista) {
                cmbCidade.addItem(e.getCidade().getNome());
            }
        } else {
            cmbCidade.removeAllItems();
        }
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void btnBuscarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCepActionPerformed
        // TODO add your handling code here:
        EnderecosDAO enderecoDAO = new EnderecosDAO();
        List<EnderecosVO> resultado = enderecoDAO.selecionar(txtCep.getText(), 1);
        if (!resultado.isEmpty()) {
            for (EnderecosVO e : resultado) {
                txtEndereco.setText(e.getEndereco());
                txtBairro.setText(e.getBairro());
                cmbEstado.setSelectedItem(e.getEstado().getNome());
                cmbCidade.setSelectedItem(e.getCidade().getNome());
            }
            btnBuscarCep.setEnabled(false);
            pesquisaCEP = true;
            txtCep.setEditable(false);
            txtEndereco.setEditable(false);
            txtBairro.setEditable(false);
            cmbCidade.setEnabled(false);
            cmbEstado.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "CEP não encontrado!");
            txtCep.setText("");
            txtEndereco.setText("");
            txtBairro.setText("");
            pesquisaCEP = false;
        }
    }//GEN-LAST:event_btnBuscarCepActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // TODO add your handling code here:
        String tmpCpf = JOptionPane.showInputDialog("Digite o CPF do cliente: ");
        if (tmpCpf == null) {
            JOptionPane.showMessageDialog(null, "Ação cancelada");
        } else if (!tmpCpf.equals("")) {
            String mask = "###.###.###.##";
            try {
                String fmt = formatString(tmpCpf, mask);
                //JOptionPane.showMessageDialog(null, "Você digitou " + fmt);
                ClientesDAO clienteDAO = new ClientesDAO();
                List<ClientesVO> listaC = clienteDAO.selecionar(fmt);
                if (!listaC.isEmpty()) {
                    for (ClientesVO c : listaC) {
                        preencheCampos(c, null, 'C');
                    }
                    DependentesDAO dependentesDAO = new DependentesDAO();
                    List<DependentesVO> listaD = dependentesDAO.selecionar(tmpCpf, 3);
                    if (!listaD.isEmpty()) {
                        for (DependentesVO d : listaD) {
                            preencheCampos(null, d, 'D');
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Cliente foi encontrado! ", 
                            "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                    bloquearCampos();
                } else {
                    recomecar();
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado! ", "AVISO", JOptionPane.WARNING_MESSAGE);
                }

            } catch (ParseException ex) {
                recomecar();
                JOptionPane.showMessageDialog(null, "Favor digitar apenas números inteiros!\n" + ex, "ALERTA", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            recomecar();
            JOptionPane.showMessageDialog(null, "Nada foi digitado!", "AVISO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        desbloquearCampos();
        JOptionPane.showMessageDialog(null, "Agora permitido atualizar cliente. ");
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCep;
    private javax.swing.JButton btnBuscarCepDep;
    private javax.swing.JButton btnCadastar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFotoAnimal;
    private javax.swing.JButton btnFotoCliente;
    private javax.swing.JButton btnFotoDep;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroupAnimal;
    private javax.swing.ButtonGroup buttonGroupCliente;
    private javax.swing.ButtonGroup buttonGroupDep;
    private javax.swing.JComboBox<Object> cmbCidade;
    private javax.swing.JComboBox<String> cmbCidadeDep;
    private javax.swing.JComboBox<Object> cmbCor;
    private javax.swing.JComboBox<Object> cmbEspecies;
    private javax.swing.JComboBox<Object> cmbEstado;
    private javax.swing.JComboBox<Object> cmbEstadoDep;
    private javax.swing.JComboBox<Object> cmbRaca;
    private javax.swing.JComboBox<Object> cmbTipoCpf;
    private javax.swing.JComboBox<Object> cmbTipoCpfDep;
    private javax.swing.JComboBox<Object> cmbtpoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelAnimal;
    private javax.swing.JPanel jPanelContato;
    private javax.swing.JPanel jPanelDadosPessoais;
    private javax.swing.JPanel jPanelDependente;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblFotoAnimal;
    private javax.swing.JLabel lblFotoCliente;
    private javax.swing.JLabel lblFotoDep;
    private javax.swing.JLabel lblNomeAnimal;
    private javax.swing.JLabel lblRaca;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexoAnimal;
    private javax.swing.JLabel lblSexoDep;
    private javax.swing.JRadioButton rbtFemea;
    private javax.swing.JRadioButton rbtMacho;
    private javax.swing.JRadioButton rdbFem;
    private javax.swing.JRadioButton rdbFemininoDep;
    private javax.swing.JRadioButton rdbMasc;
    private javax.swing.JRadioButton rdbMasculinoDep;
    private javax.swing.JTextArea txtAreaObsAnimal;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBairroDep;
    private javax.swing.JFormattedTextField txtCelDepen;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JFormattedTextField txtCepDepen;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtCpfDepen;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailDepen;
    private javax.swing.JTextField txtEndDepen;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtNasc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeAnimal;
    private javax.swing.JTextField txtNomeDepen;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtNumDep;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JFormattedTextField txtRgDepen;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
