/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Model;

import Dados.MetodoValidaCPF;
import Model.TelaLogin;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ryan
 */
public class TelaCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaCadastro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEMAIL = new javax.swing.JTextField();
        txtSENHA = new javax.swing.JPasswordField();
        BtnRealizarCadastro = new javax.swing.JButton();
        BtnCadastrar = new javax.swing.JButton();
        txtCPF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEMAIL.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txtEMAIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEMAILActionPerformed(evt);
            }
        });
        getContentPane().add(txtEMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 200, 30));

        txtSENHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSENHAActionPerformed(evt);
            }
        });
        getContentPane().add(txtSENHA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 272, 200, 30));

        BtnRealizarCadastro.setContentAreaFilled(false);
        BtnRealizarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(BtnRealizarCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 160, 40));

        BtnCadastrar.setContentAreaFilled(false);
        BtnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 160, 50));

        txtCPF.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });
        getContentPane().add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 200, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/TelaCadastro.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 669, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEMAILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEMAILActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEMAILActionPerformed

    private void txtSENHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSENHAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSENHAActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void BtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarActionPerformed
     
        String url = "jdbc:mysql://localhost:3306/IngressosDB"; 
        String usuario = "root"; 
        String senhaDB = "gabi240505";
        
        String cpf = txtCPF.getText();
        String email = txtEMAIL.getText();
        String senha = txtSENHA.getText();
        
        //insere os dados do usuario no banco de dados
        try (Connection conexao = DriverManager.getConnection(url, usuario, senhaDB)) {
        String query = "INSERT INTO clientes (cpf, email, senha) VALUES (?, ?, ?)";
    PreparedStatement statement = conexao.prepareStatement(query);
    statement.setString(1, cpf);
    statement.setString(2, email);
    statement.setString(3, senha);
    statement.executeUpdate();
    JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + ex.getMessage());
}
       //verifica se os campos foram preenchidos 
       if(cpf.isEmpty() || email.isEmpty() || senha.isEmpty()){
           JOptionPane.showMessageDialog(this, "Todos os campos precisam ser preenchidos");
       }else{
           MetodoValidaCPF validator = new MetodoValidaCPF(cpf);
        TelaLogin telaLogin = new TelaLogin();
        
        //verifica se o CPF é valido ou não
        if (validator.validaCPF()) {
            telaLogin.setVisible(true);         
        } else {
            JOptionPane.showMessageDialog(this, "CPF inválido!");
            telaLogin.setVisible(false);
        }
       }              
    }//GEN-LAST:event_BtnCadastrarActionPerformed
                                             

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastrar;
    private javax.swing.JButton BtnRealizarCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtEMAIL;
    private javax.swing.JPasswordField txtSENHA;
    // End of variables declaration//GEN-END:variables
}
