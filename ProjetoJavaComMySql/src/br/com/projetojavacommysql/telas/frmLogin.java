/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetojavacommysql.telas;
import br.com.projetojavacommysql.dao.ModuloConexao;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Marques
 */
public class frmLogin extends javax.swing.JFrame {

  Connection conexao = null;
  PreparedStatement pst = null;
  ResultSet rs = null;
  
   public void logar(){
            String sql = "select * from tbusuarios where login = ? and senha = ? ";
            
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txt_usuario.getText());
                pst.setString(2, txt_senha.getText());
                
                // executar a query - consulta
                rs = pst.executeQuery();
                if (rs.next()) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    this.dispose();
                    conexao.close();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario ou Senha inválido");
                }
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e);
            }
        }

    /**
     * Creates new form frmLogin
     */
    
       /**
     * TESTE DE PULL 26/02/2022
     */
    
      /**
     * TESTE DE COMMIT  26/02/2022 19:03
     */
    
   public frmLogin() {
        initComponents();
        
        conexao = ModuloConexao.conector();
     //   System.out.println(conexao);
     if(conexao != null) {
         lb_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projetojavamysql/img/dbok.png")));
     } else {
          lb_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projetojavamysql/img/dberro.png")));
     }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_senha = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        lb_status = new javax.swing.JLabel();
        lb_fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("USUUÁRIO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 170, 80, 14);

        jLabel2.setText("SENHA:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(230, 240, 80, 14);
        getContentPane().add(txt_usuario);
        txt_usuario.setBounds(210, 160, 340, 40);
        getContentPane().add(txt_senha);
        txt_senha.setBounds(210, 220, 340, 50);

        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projetojavamysql/img/cadeado icone 40x40.png"))); // NOI18N
        btn_login.setText("LOGIN");
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login);
        btn_login.setBounds(340, 280, 210, 50);

        lb_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projetojavamysql/img/dberro.png"))); // NOI18N
        getContentPane().add(lb_status);
        lb_status.setBounds(38, 64, 100, 40);

        lb_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projetojavamysql/img/login.jpg"))); // NOI18N
        lb_fundo.setPreferredSize(new java.awt.Dimension(581, 397));
        getContentPane().add(lb_fundo);
        lb_fundo.setBounds(30, 0, 540, 400);

        setSize(new java.awt.Dimension(581, 397));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        logar();
    }//GEN-LAST:event_btn_loginActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb_fundo;
    private javax.swing.JLabel lb_status;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
