package br.unipar.frame;

import br.unipar.api.ClienteAPI;
import br.unipar.exceptions.ErrorException;
import br.unipar.models.Cliente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CadastroClienteFrame extends javax.swing.JFrame {

    public CadastroClienteFrame(Cliente cliente) {
        initComponents();
        tfId.setText(String.valueOf(cliente.getId()));
        tfNome.setText(cliente.getNome());
        tfTelefone.setText(cliente.getTelefone());
        tfEmail.setText(cliente.getEmail());

        // Aplicando estilo aos componentes
        configurarEstiloComponentes();
    }

    public CadastroClienteFrame() {
        initComponents();
        configurarEstiloComponentes();
        adicionarHoverEfeitos(btSalvar);
        adicionarHoverEfeitos(btCancelar);
        adicionarHoverEfeitos(btExcluir);
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

        tfNome.setBackground(Color.WHITE);
        tfNome.setForeground(Color.BLACK);
        tfNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        tfTelefone.setBackground(Color.WHITE);
        tfTelefone.setForeground(Color.BLACK);
        tfTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        tfEmail.setBackground(Color.WHITE);
        tfEmail.setForeground(Color.BLACK);
        tfEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 400));

        jLabel1.setText("ID:");

        tfId.setEditable(false);

        jLabel2.setText("Nome:");

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNomeKeyReleased(evt);
            }
        });

        jLabel4.setText("Telefone:");

        tfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTelefoneKeyReleased(evt);
            }
        });

        jLabel5.setText("Email:");

        tfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfEmailKeyReleased(evt);
            }
        });

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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 284, Short.MAX_VALUE)))
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
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeKeyReleased(java.awt.event.KeyEvent evt) {                                   
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            salvarCadastro();
        }
    }

    private void tfTelefoneKeyReleased(java.awt.event.KeyEvent evt) {                                       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            salvarCadastro();
        }
    }

    private void tfEmailKeyReleased(java.awt.event.KeyEvent evt) {                                    
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            salvarCadastro();
        }
    }

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {                                          
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {                                          
        excluirCliente();
    }

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
            validarCampos();
            salvarCadastro();
        } catch (ErrorException e) {
            throw new RuntimeException(e);
        }

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
            java.util.logging.Logger.getLogger(CadastroClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroClienteFrame().setVisible(true);
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
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables

    private void salvarCadastro() {
        ClienteAPI dao = new ClienteAPI();
        Cliente cliente = new Cliente();

        cliente.setNome(tfNome.getText());
        cliente.setTelefone(tfTelefone.getText());
        cliente.setEmail(tfEmail.getText());

        if(!tfId.getText().isEmpty()){
            cliente.setId(Integer.parseInt(tfId.getText()));
            dao.update(cliente);
        }
        else{
            dao.insert(cliente);
        }

        this.dispose();
    }

    private void excluirCliente() {
        if(tfId.getText()!=""){
           ClienteAPI dao = new ClienteAPI();
           dao.delete(Integer.parseInt(tfId.getText()));
           this.dispose();
        }
    }

    private void validarCampos() throws ErrorException {
        if(tfNome.getText().isEmpty()){
            tfNome.requestFocus();
            JOptionPane.showMessageDialog(this, "Preencha o campo nome","Atenção", JOptionPane.INFORMATION_MESSAGE);
            throw new ErrorException("Informe um nome!");
        }
        if(tfNome.getText().length()<3 || tfNome.getText().length()>128){
            tfNome.requestFocus();
            JOptionPane.showMessageDialog(this, "Número de caracteres inválido(Minimo=3 e Máximo=128)", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            throw new ErrorException("Nome Inválido!");
        }
        if(!tfTelefone.getText().isEmpty() && tfTelefone.getText().length()<8 || tfTelefone.getText().length()>14){
            tfTelefone.requestFocus();
            JOptionPane.showMessageDialog(this, "Número de caracteres inválido(Minimo=8 e Máximo=14)", "Atenção",JOptionPane.INFORMATION_MESSAGE);
            throw new ErrorException("Telefone inválido");
        }
        if(!tfEmail.getText().isEmpty() && tfEmail.getText().length()>128){
            tfEmail.requestFocus();
            JOptionPane.showMessageDialog(this, "Número de caracteres inválido(Max=128)", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            throw new ErrorException("Email Inválido");
        }
    }
}
