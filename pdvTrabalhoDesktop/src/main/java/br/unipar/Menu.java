package br.unipar;

import br.unipar.frame.ClienteFrame;
import br.unipar.frame.ProdutoFrame;
import br.unipar.panel.VendaPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JPanel venda;
    private JFrame cliente;
    private JFrame produto;

    public Menu() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,600);
        setLocationRelativeTo(null);

        venda = new VendaPanel();
        cliente = new ClienteFrame();
        produto = new ProdutoFrame();

        JMenuBar menuBar = new JMenuBar();

        JMenu menuVenda = new JMenu("Venda");
        JMenu menuCliente = new JMenu("Cliente");
        JMenu menuProduto = new JMenu("Produto");

        JMenuItem menuItemVenda = new JMenuItem("Venda");
        JMenuItem menuItemCliente = new JMenuItem("Cliente");
        JMenuItem menuItemProduto = new JMenuItem("Produto");

        menuItemVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPanel(venda);
            }
        });

        menuItemCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFrame(cliente);
            }
        });

        menuItemProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFrame(produto);
            }
        });
        menuVenda.add(menuItemVenda);
        menuCliente.add(menuItemCliente);
        menuProduto.add(menuItemProduto);

        menuBar.add(menuVenda);
        menuBar.add(menuCliente);
        menuBar.add(menuProduto);

        setJMenuBar(menuBar);

    }

    private void abrirPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    private void abrirFrame(JFrame frame) {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}