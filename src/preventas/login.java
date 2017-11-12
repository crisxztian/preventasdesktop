/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventas;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.shaper.StandardButtonShaper;

/**
 *
 * @author crisi
 */
public class login extends javax.swing.JFrame {

    usuarios sec = new usuarios();

    public login() {
        initComponents();
          this.btning.putClientProperty( SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtdoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtkey = new javax.swing.JPasswordField();
        btning = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 340));
        setMinimumSize(new java.awt.Dimension(400, 340));
        setPreferredSize(new java.awt.Dimension(400, 340));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(169, 11, 56, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(133, 71, 127, 17);

        txtdoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdocKeyTyped(evt);
            }
        });
        getContentPane().add(txtdoc);
        txtdoc.setBounds(133, 106, 127, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Contraseña");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(133, 155, 127, 17);

        txtkey.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtkeyKeyTyped(evt);
            }
        });
        getContentPane().add(txtkey);
        txtkey.setBounds(133, 190, 127, 20);

        btning.setText("Ingresar");
        btning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningActionPerformed(evt);
            }
        });
        getContentPane().add(btning);
        btning.setBounds(114, 242, 166, 41);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningActionPerformed
        String l;
        try {
            l = sec.selectadmin(conexion.obtener(), txtdoc.getText());
            if (l == null) {
                JOptionPane.showMessageDialog(this, "Usuario inexistente o sin privilegios de administrador", "Sesión", 0);
            } else {
                if (l.equals(txtkey.getText())) {
                    administracion ad = new administracion();
                    ad.docusu(txtdoc.getText());
                    ad.setVisible(true);
                    ad.jMenuusu.setText(txtdoc.getText());
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "Sesión", 0);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getCause(), "Error", 0);
        }

    }//GEN-LAST:event_btningActionPerformed

    private void txtdocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocKeyTyped
        char cTeclaPresionada = evt.getKeyChar();

        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btning.doClick();
        }
    }//GEN-LAST:event_txtdocKeyTyped

    private void txtkeyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkeyKeyTyped
        char cTeclaPresionada = evt.getKeyChar();

        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btning.doClick();
        }
    }//GEN-LAST:event_txtkeyKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.NebulaSkin");
                new login().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtdoc;
    private javax.swing.JPasswordField txtkey;
    // End of variables declaration//GEN-END:variables
}
