package br.unipar.frame;

import br.unipar.api.ClienteAPI;
import br.unipar.models.Cliente;
import br.unipar.tablemodels.ClienteTableModel;
import br.unipar.updaters.ClienteUpdater;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ClienteFrame extends JFrame {

    private ClienteTableModel model;
    private List<Cliente> lista;
    private JTextField tfNmCliente;
    private JButton btConsultar, btCancelar, btAlterar, btIncluir;
    private JTable jTableClientes;
    private JScrollPane jScrollPane2;

    public ClienteFrame() {
        initComponents();
        carregarClientes();
    }

    private void initComponents() {
        setTitle("Gestão de Clientes");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(216, 226, 220));
        setLayout(new BorderLayout(10, 10));

        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelTop.setBackground(new Color(216, 226, 220));

        tfNmCliente = new JTextField(20);
        tfNmCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        btConsultar = createButton("Consultar");
        btConsultar.addActionListener(evt -> btConsultarActionPerformed(evt));



        panelTop.add(new JLabel("Nome do Cliente:"));
        panelTop.add(tfNmCliente);
        panelTop.add(btConsultar);


        add(panelTop, BorderLayout.NORTH);

        jTableClientes = new JTable();
        jTableClientes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jTableClientes.setSelectionBackground(new Color(98, 23, 8));
        jTableClientes.setSelectionForeground(Color.WHITE);
        jTableClientes.setGridColor(new Color(255, 104, 107));

        jScrollPane2 = new JScrollPane(jTableClientes);
        add(jScrollPane2, BorderLayout.CENTER);

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
        if (tfNmCliente.getText().isEmpty()) {
            carregarClientes();
        } else {
            buscarClientes(tfNmCliente.getText());
        }
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        CadastroClienteFrame frame = new CadastroClienteFrame(model.getSelectedItem(jTableClientes, lista));
        abrirFrame(frame);
    }

    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {
        CadastroClienteFrame frame = new CadastroClienteFrame();
        abrirFrame(frame);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new ClienteFrame().setVisible(true));
    }

    private void carregarClientes() {
        ClienteAPI dao = new ClienteAPI();
        lista = dao.findAll();
        model = new ClienteTableModel(lista);
        jTableClientes.setModel(model);
    }

    private void buscarClientes(String nome) {
        ClienteAPI dao = new ClienteAPI();
        lista = dao.findByNome(nome);
        model = new ClienteTableModel(lista);
        jTableClientes.setModel(model);
    }

    private void abrirFrame(JFrame frame) {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void carregarUpdater() {
        ClienteUpdater updater = new ClienteUpdater();
        CompletableFuture<List<Cliente>> future = updater.startUpdating();

        future.thenAccept(ret -> {
            SwingUtilities.invokeLater(() -> {
                if (lista == null) {
                    lista = new ArrayList<>();
                }
                lista.clear();
                lista.addAll(ret);
                System.out.println("Lista atualizada!");

                model = new ClienteTableModel(lista);
                jTableClientes.setModel(model);
            });

        }).exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        });
    }
}
