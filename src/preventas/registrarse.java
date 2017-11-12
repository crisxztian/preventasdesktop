/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventas;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author crisi
 */
public class registrarse extends javax.swing.JFrame {

    usuarios secre = new usuarios();
    administracion admi = new administracion();

    public registrarse() {
        initComponents();
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusunew = new javax.swing.JTextField();
        txtusudoc = new javax.swing.JTextField();
        txtusunom = new javax.swing.JTextField();
        txtapenew = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtkeynew = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txtkeynew1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro");
        setMaximumSize(new java.awt.Dimension(470, 380));
        setMinimumSize(new java.awt.Dimension(470, 380));
        setResizable(false);
        setSize(new java.awt.Dimension(470, 380));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Registrar administrativo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(139, 11, 185, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Documento");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 100, 106, 23);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombres");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 140, 106, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Usuario");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 60, 106, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Apellidos");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 180, 106, 23);

        txtusunew.setName("txtusunew"); // NOI18N
        getContentPane().add(txtusunew);
        txtusunew.setBounds(250, 60, 168, 23);

        txtusudoc.setName("txtusudoc"); // NOI18N
        getContentPane().add(txtusudoc);
        txtusudoc.setBounds(250, 100, 168, 23);

        txtusunom.setName("txtusunom"); // NOI18N
        getContentPane().add(txtusunom);
        txtusunom.setBounds(250, 140, 168, 23);

        txtapenew.setName("txtapenew"); // NOI18N
        getContentPane().add(txtapenew);
        txtapenew.setBounds(250, 180, 168, 23);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 320, 110, 23);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(80, 320, 110, 23);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Contraseña");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 220, 106, 23);
        getContentPane().add(txtkeynew);
        txtkeynew.setBounds(250, 220, 168, 23);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Confirmar contraseña");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 260, 150, 23);
        getContentPane().add(txtkeynew1);
        txtkeynew1.setBounds(250, 260, 168, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(txtusunew.getText().isEmpty() || txtusunom.getText().isEmpty() || txtusudoc.getText().isEmpty() || txtapenew.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Campos obligatorios vacios", "Error de datos", JOptionPane.ERROR_MESSAGE);
        }else{
        if (txtkeynew.getText().equals(txtkeynew1.getText())) {
            if(txtkeynew.getText().length() > 6){
            secre.setusuario(txtusunew.getText());
            secre.setnombres(txtusunom.getText());
            secre.setdocumento(txtusudoc.getText());
            secre.setapellidos(txtapenew.getText());
            secre.setprivilegios("Administrador");
            secre.setclave(txtkeynew.getText());
            try {
                secre.insert(conexion.obtener());
                JOptionPane.showMessageDialog(this, "Ha sido registrado satisfactoriamente", "Registrado", 1, admi.bien);
                jButton2ActionPerformed(evt);

            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getCause(), "Error", 0);

            }
            }else{
               JOptionPane.showMessageDialog(this, "Contraseña muy corta. Minimo 6 caracteres", "Error de datos", JOptionPane.ERROR_MESSAGE); 
            }
        } else {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error de datos", 2);
        }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtapenew;
    private javax.swing.JPasswordField txtkeynew;
    private javax.swing.JPasswordField txtkeynew1;
    private javax.swing.JTextField txtusudoc;
    private javax.swing.JTextField txtusunew;
    private javax.swing.JTextField txtusunom;
    // End of variables declaration//GEN-END:variables
}
