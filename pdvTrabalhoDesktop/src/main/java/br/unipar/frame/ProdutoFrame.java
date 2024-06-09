package br.unipar.frame;

import br.unipar.api.ProdutoAPI;
import br.unipar.models.Produto;
import br.unipar.tablemodels.ProdutoTableModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class ProdutoFrame extends JFrame {

    private List<Produto> lista;
    private ProdutoTableModel model;
    private JTextField tfProduto;
    private JButton btConsultar, btCancelar, btAlterar, btIncluir;
    private JTable jTableProdutos;
    private JComboBox<String> jComboBox1;
    private JScrollPane jScrollPane1;
    private JSpinner spCategoria;

    public ProdutoFrame() {
        initComponents();
        carregarProdutos();
        configurarComboBox();
    }

    private void initComponents() {
        setTitle("Gestão de Produtos");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(216, 226, 220));
        setLayout(new BorderLayout(10, 10));

        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelTop.setBackground(new Color(216, 226, 220));

        tfProduto = new JTextField(20);
        tfProduto.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        btConsultar = createButton("Consultar");
        btConsultar.addActionListener(evt -> btConsultarActionPerformed(evt));

        btCancelar = createButton("Cancelar");
        btCancelar.addActionListener(evt -> btCancelarActionPerformed(evt));

        jComboBox1 = new JComboBox<>();
        jComboBox1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jComboBox1.setBackground(new Color(98, 23, 8));
        jComboBox1.setForeground(Color.WHITE);

        panelTop.add(new JLabel("Pesquisar por:"));
        panelTop.add(jComboBox1);
        panelTop.add(tfProduto);
        panelTop.add(btConsultar);
        panelTop.add(btCancelar);

        add(panelTop, BorderLayout.NORTH);

        jTableProdutos = new JTable();
        jTableProdutos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jTableProdutos.setSelectionBackground(new Color(98, 23, 8));
        jTableProdutos.setSelectionForeground(Color.WHITE);
        jTableProdutos.setGridColor(new Color(255, 104, 107));

        jScrollPane1 = new JScrollPane(jTableProdutos);
        add(jScrollPane1, BorderLayout.CENTER);

        JPanel panelBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panelBottom.setBackground(new Color(216, 226, 220));

        btIncluir = createButton("Incluir");
        btIncluir.addActionListener(evt -> btIncluirActionPerformed(evt));
        panelBottom.add(btIncluir);

        btAlterar = createButton("Alterar");
        btAlterar.addActionListener(evt -> btAlterarActionPerformed(evt));
        panelBottom.add(btAlterar);

        btCancelar = createButton("Cancelar");
        btCancelar.addActionListener(evt -> btCancelarActionPerformed(evt));
        panelBottom.add(btCancelar);

        add(panelBottom, BorderLayout.SOUTH);

        pack();
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(98, 23, 8));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(10, 20, 10, 20));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(120, 40, 20));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(98, 23, 8));
            }
        });
        return button;
    }

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {
        if (tfProduto.getText().isEmpty()) {
            carregarProdutos();
        } else {
            buscarProdutos(tfProduto.getText());
        }
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        CadastroProdutoFrame frame = new CadastroProdutoFrame(model.getSelectedItem(jTableProdutos, lista));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {
        CadastroProdutoFrame frame = new CadastroProdutoFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new ProdutoFrame().setVisible(true));
    }

    private void carregarProdutos() {
        ProdutoAPI dao = new ProdutoAPI();
        lista = dao.findAll();
        model = new ProdutoTableModel(lista);
        jTableProdutos.setModel(model);
    }

    private void buscarProdutos(String busca) {
        ProdutoAPI dao = new ProdutoAPI();
        if (jComboBox1.getSelectedItem().equals("Descrição")) {
            lista = dao.findByDescricao(busca);
        } else if (jComboBox1.getSelectedItem().equals("Categoria")) {
            lista = dao.findByCategoria(busca);
        }
        model = new ProdutoTableModel(lista);
        jTableProdutos.setModel(model);
    }

    private void configurarComboBox() {
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Descrição");
        jComboBox1.addItem("Categoria");
    }
}
