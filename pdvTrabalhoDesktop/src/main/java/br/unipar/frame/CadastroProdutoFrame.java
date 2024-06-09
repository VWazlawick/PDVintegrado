package br.unipar.frame;

import br.unipar.api.ProdutoAPI;
import br.unipar.exceptions.ErrorException;
import br.unipar.models.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CadastroProdutoFrame extends javax.swing.JFrame {

    public CadastroProdutoFrame() {
        initComponents();
        configurarEstiloComponentes();
        adicionarHoverEfeitos(btSalvar);
        adicionarHoverEfeitos(btCancelar);
        adicionarHoverEfeitos(btExcluir);
    }

    public CadastroProdutoFrame(Produto produto) {
        initComponents();
        tfId.setText(String.valueOf(produto.getId()));
        tfDescricao.setText(produto.getDescricao());
        tfCategoria.setText(produto.getCategoria());
        tfValor.setText(String.valueOf(produto.getValor()));

        // Aplicando estilo aos componentes
        configurarEstiloComponentes();
    }

    private void adicionarHoverEfeitos(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(120, 40, 20));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(98, 23, 8));
            }
        });
    }

    private void configurarEstiloComponentes() {
        getContentPane().setBackground(new Color(216, 226, 220));

        // Estilizando botões
        btSalvar.setBackground(new Color(98, 23, 8));
        btSalvar.setForeground(Color.WHITE);
        btSalvar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btSalvar.setFocusPainted(false);
        btSalvar.setBorder(new EmptyBorder(10, 20, 10, 20));
        btSalvar.setContentAreaFilled(false);
        btSalvar.setOpaque(true);

        btCancelar.setBackground(new Color(98, 23, 8));
        btCancelar.setForeground(Color.WHITE);
        btCancelar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btCancelar.setFocusPainted(false);
        btCancelar.setBorder(new EmptyBorder(10, 20, 10, 20));
        btCancelar.setContentAreaFilled(false);
        btCancelar.setOpaque(true);

        btExcluir.setBackground(new Color(98, 23, 8));
        btExcluir.setForeground(Color.WHITE);
        btExcluir.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btExcluir.setFocusPainted(false);
        btExcluir.setBorder(new EmptyBorder(10, 20, 10, 20));
        btExcluir.setContentAreaFilled(false);
        btExcluir.setOpaque(true);

        // Estilizando labels
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        jLabel2.setForeground(Color.BLACK);
        jLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        jLabel4.setForeground(Color.BLACK);
        jLabel4.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        jLabel5.setForeground(Color.BLACK);
        jLabel5.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Estilizando text fields
        tfId.setBackground(Color.WHITE);
        tfId.setForeground(Color.BLACK);
        tfId.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        tfDescricao.setBackground(Color.WHITE);
        tfDescricao.setForeground(Color.BLACK);
        tfDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        tfCategoria.setBackground(Color.WHITE);
        tfCategoria.setForeground(Color.BLACK);
        tfCategoria.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        tfValor.setBackground(Color.WHITE);
        tfValor.setForeground(Color.BLACK);
        tfValor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfDescricao = new javax.swing.JTextField();
        tfCategoria = new javax.swing.JTextField();
        tfValor = new javax.swing.JTextField();
        tfId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 400));

        tfDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescricaoActionPerformed(evt);
            }
        });
        tfDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescricaoKeyReleased(evt);
            }
        });

        tfCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCategoriaKeyReleased(evt);
            }
        });

        tfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfValorKeyReleased(evt);
            }
        });

        tfId.setEditable(false);

        jLabel1.setText("ID:");

        jLabel2.setText("D:escrição");

        jLabel4.setText("Categoria:");

        jLabel5.setText("Valor:");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 278, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescricaoActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        excluirProduto();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void tfDescricaoKeyReleased(java.awt.event.KeyEvent evt) {                                        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            salvarProduto();
        }
    }

    private void tfCategoriaKeyReleased(java.awt.event.KeyEvent evt) {                                        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            salvarProduto();
        }
    }

    private void tfValorKeyReleased(java.awt.event.KeyEvent evt) {                                    
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            salvarProduto();
        }
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        salvarProduto();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProdutoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfCategoria;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables

    private void salvarProduto() {
        try {
            validarCampos();

            ProdutoAPI dao = new ProdutoAPI();
            Produto produto = new Produto();

            produto.setDescricao(tfDescricao.getText());
            produto.setCategoria(tfCategoria.getText());
            produto.setValor(Double.parseDouble(tfValor.getText()));

            if (!tfId.getText().isEmpty()) {
                produto.setId(Integer.parseInt(tfId.getText()));
                dao.update(produto);
            } else {
                dao.insert(produto);
            }
            this.dispose();
        } catch (ErrorException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void excluirProduto(){
        if(tfId.getText()!=""){
            ProdutoAPI dao = new ProdutoAPI();
            dao.delete(Integer.parseInt(tfId.getText()));
            this.dispose();
        }
    }

    public void validarCampos() throws ErrorException {
        if(tfDescricao.getText().isEmpty()){
            tfDescricao.requestFocus();
            JOptionPane.showMessageDialog(this, "Informe uma descrição para o produto", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            throw new ErrorException("Informe a descrição");
        }
        if(tfCategoria.getText().isEmpty()){
            tfCategoria.requestFocus();
            JOptionPane.showMessageDialog(this, "Informe a Categoria do produto", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            throw new ErrorException("Informe a decrição");
        }
        if(tfValor.getText().isEmpty()){
            tfValor.requestFocus();
            JOptionPane.showMessageDialog(this, "Informe um valor para o produto", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            throw new ErrorException("Informe o valor");
        }
        if(!tfValor.getText().isEmpty() && tfValor.getText()=="0"){
            tfValor.requestFocus();
            JOptionPane.showMessageDialog(this,"Informe um valor maior que R$0,00", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            throw new ErrorException("Informe um valor");
        }
    }
}
