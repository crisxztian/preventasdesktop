/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventas;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.api.SubstanceConstants;
import org.jvnet.substance.shaper.StandardButtonShaper;

/**
 *
 * @author crisi
 */
public class prevender extends javax.swing.JFrame {

    DefaultTableModel modelopre = new DefaultTableModel();
    DefaultTableModel modelocli = new DefaultTableModel();
    List<String> prod = new ArrayList<>();
    List<String> clien = new ArrayList<>();
    productos produ = new productos();
    clientes cli = new clientes();
    pedidos pedi = new pedidos();
    usuarios usua = new usuarios();
    detallepedido deta = new detallepedido();
    administracion admi = new administracion();
    String usuario;
    

    public prevender() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            prod = produ.selectdes(conexion.obtener());
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        actualizarclientes(comboclientes);
        for (int i = 0; i < prod.size(); i++) {
            comboproductos.addItem(prod.get(i));
        }
        tablaclientes();
        this.btnreg.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.btnreg.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.LEFT);
        this.btnreg.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.LEFT);
        this.btnupcli.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.btnupcli.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.LEFT);
        this.btnupcli.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.LEFT);
        this.btndelete.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.btndelete.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.LEFT);
        this.btndelete.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.LEFT);
        this.bntend.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.bntend.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.bntend.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        intnewemp = new javax.swing.JInternalFrame();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtclidoc = new javax.swing.JTextField();
        txtclinom = new javax.swing.JTextField();
        txtclidir = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboclientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboproductos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtcanti = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btndelete = new javax.swing.JButton();
        btnclinw = new javax.swing.JButton();
        bntend = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        infraupcli = new javax.swing.JInternalFrame();
        jLabel10 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablecli = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnreg = new javax.swing.JButton();
        btnupcli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de preventas");
        setMinimumSize(new java.awt.Dimension(720, 450));
        setPreferredSize(new java.awt.Dimension(720, 450));
        setResizable(false);
        setSize(new java.awt.Dimension(720, 450));
        getContentPane().setLayout(null);

        intnewemp.setVisible(false);
        intnewemp.getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cliente nuevo");
        intnewemp.getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 0, 140, 22);

        jLabel6.setText("Documento");
        intnewemp.getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 40, 90, 20);

        jLabel7.setText("Nombre");
        intnewemp.getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 80, 90, 20);

        jLabel8.setText("Direccion");
        intnewemp.getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 120, 100, 20);
        intnewemp.getContentPane().add(txtclidoc);
        txtclidoc.setBounds(120, 40, 180, 23);
        intnewemp.getContentPane().add(txtclinom);
        txtclinom.setBounds(120, 80, 180, 23);
        intnewemp.getContentPane().add(txtclidir);
        txtclidir.setBounds(120, 120, 180, 23);

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        intnewemp.getContentPane().add(jButton5);
        jButton5.setBounds(50, 170, 90, 23);

        jButton6.setText("Guardar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        intnewemp.getContentPane().add(jButton6);
        jButton6.setBounds(200, 170, 90, 23);

        getContentPane().add(intnewemp);
        intnewemp.setBounds(200, 60, 360, 260);

        jTabbedPane2.setMinimumSize(new java.awt.Dimension(720, 450));
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(720, 450));

        jPanel1.setMinimumSize(new java.awt.Dimension(720, 450));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nueva venta");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(270, 10, 140, 20);

        jPanel1.add(comboclientes);
        comboclientes.setBounds(20, 80, 140, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cliente");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 60, 50, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Producto");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 150, 60, 17);

        jPanel1.add(comboproductos);
        comboproductos.setBounds(20, 180, 140, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 220, 70, 17);
        jPanel1.add(txtcanti);
        txtcanti.setBounds(20, 240, 140, 25);

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(80, 290, 80, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setModel(modelopre);
        modelopre.addColumn("ID");
        modelopre.addColumn("Descripción");
        modelopre.addColumn("Precio unitario");
        modelopre.addColumn("Cantidad");
        modelopre.addColumn("Precio total");
        jTable1.setDefaultEditor(Object.class, null);

        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(180, 40, 450, 270);

        btndelete.setText("Borrar");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete);
        btndelete.setBounds(630, 40, 63, 23);

        btnclinw.setText("Nuevo");
        btnclinw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclinwActionPerformed(evt);
            }
        });
        jPanel1.add(btnclinw);
        btnclinw.setBounds(90, 110, 70, 23);

        bntend.setText("Finalizar");
        bntend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntendActionPerformed(evt);
            }
        });
        jPanel1.add(bntend);
        bntend.setBounds(530, 310, 100, 23);

        jTabbedPane2.addTab("Preventa", jPanel1);

        jPanel2.setMinimumSize(new java.awt.Dimension(720, 450));
        jPanel2.setLayout(null);

        infraupcli.setVisible(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Dirección");

        jButton8.setText("Cancelar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Guardar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infraupcliLayout = new javax.swing.GroupLayout(infraupcli.getContentPane());
        infraupcli.getContentPane().setLayout(infraupcliLayout);
        infraupcliLayout.setHorizontalGroup(
            infraupcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infraupcliLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infraupcliLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(infraupcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(infraupcliLayout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        infraupcliLayout.setVerticalGroup(
            infraupcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infraupcliLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(infraupcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(32, 32, 32))
        );

        jPanel2.add(infraupcli);
        infraupcli.setBounds(200, 90, 360, 220);

        jTablecli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablecli.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTablecli.setModel(modelocli);
        modelocli.addColumn("ID");
        modelocli.addColumn("Documento");
        modelocli.addColumn("Nombre");
        modelocli.addColumn("Dirección");
        jTablecli.setDefaultEditor(Object.class, null);
        jScrollPane2.setViewportView(jTablecli);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(40, 30, 452, 340);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Clientes registrados");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(200, 10, 130, 17);

        btnreg.setText("Registrar");
        btnreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregActionPerformed(evt);
            }
        });
        jPanel2.add(btnreg);
        btnreg.setBounds(490, 30, 90, 23);

        btnupcli.setText("Actualizar");
        btnupcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupcliActionPerformed(evt);
            }
        });
        jPanel2.add(btnupcli);
        btnupcli.setBounds(490, 60, 90, 23);

        jTabbedPane2.addTab("Clientes", jPanel2);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(0, 0, 720, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] productos, produs2;
        comboclientes.setEnabled(false);
        btnclinw.setEnabled(false);
        try {
            int cn = Integer.parseInt(txtcanti.getText());
            produ.setdescripcion(String.valueOf(comboproductos.getSelectedItem()));
            productos = produ.selectnuevo(conexion.obtener());
            if (Integer.parseInt(productos[3]) < cn) {
                JOptionPane.showMessageDialog(this, "El numero de unidades que intenta vender es superior al almacenado en el inventario", "Stock insuficiente", 0);
            } else {
                if(Integer.parseInt(productos[3]) - cn <= 30 ){
                    JOptionPane.showMessageDialog(this, "El limite minimo de stock será superado", "Actualizar stock", 2);
                }
                int pre = Integer.parseInt(productos[2]);
                produs2 = new String[]{productos[0], productos[1], productos[2], txtcanti.getText(), String.valueOf(cn * pre)};
                modelopre.addRow(produs2);
            }
        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex.getCause(), "Error", 0);
            if (jTable1.getRowCount() == 0) {
                comboclientes.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        if (jTable1.getSelectedRow() != -1) {
            modelopre.removeRow(jTable1.getSelectedRow());
            jTable1.repaint();
            if (jTable1.getRowCount() == 0) {
                comboclientes.setEnabled(true);
                btnclinw.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para borrar","Error de selección",0);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void bntendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntendActionPerformed
        if (jTable1.getRowCount() > 0) {
            try {
                pedi.setfecha(getfechaactual());
                pedi.setHora(gethoraactual());
                pedi.settotal(0);
                int tot = 0;
                pedi.setusuarios_id(usua.selectid(conexion.obtener(), usuario));
                pedi.setclientes_id(cli.selectid(conexion.obtener(), String.valueOf(comboclientes.getSelectedItem())));
                pedi.insert(conexion.obtener());
                int idped = pedi.selectid(conexion.obtener());
                deta.setpedidos_id(idped);
                while (jTable1.getRowCount() > 0) {
                    int cantstock = Integer.parseInt(jTable1.getValueAt(0, 3).toString());
                    deta.setcantidad(cantstock);
                    produ.setdescripcion(jTable1.getValueAt(0, 1).toString());
                    int idpro=produ.selectid(conexion.obtener());
                    deta.setproductos_id(idpro);
                    deta.insert(conexion.obtener());
                    produ.setid(idpro);
                    int stock = produ.selectstock(conexion.obtener()) - cantstock;
                    produ.setstock(stock);
                    produ.updatestock(conexion.obtener());
                    tot = tot + Integer.parseInt(jTable1.getValueAt(0, 4).toString());
                    modelopre.removeRow(0);
                }
                pedi.setid(idped);
                pedi.settotal(tot);
                pedi.update(conexion.obtener());
                JOptionPane.showMessageDialog(this, "Venta ingresada satisfactoriamnte", "Venta registrada", 1, admi.bien);
                comboclientes.setEnabled(true);
                btnclinw.setEnabled(true);
                txtcanti.setText("");
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getCause(), "Error", 0);
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Sin registros que insertar", "Error en los datos", 0);
        }
    }//GEN-LAST:event_bntendActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        intnewemp.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnclinwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclinwActionPerformed
        intnewemp.show();
    }//GEN-LAST:event_btnclinwActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            cli.setdocumento(txtclidoc.getText());
            cli.setnombre(txtclinom.getText());
            cli.setdireccion(txtclidir.getText());
            cli.insert(conexion.obtener());
            actualizarclientes(comboclientes);
            tablaclientes();
            intnewemp.dispose();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getCause(), "Error", 0);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregActionPerformed
       intnewemp.show();
    }//GEN-LAST:event_btnregActionPerformed

    private void btnupcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupcliActionPerformed
        if (jTablecli.getSelectedRow() != -1) {
            infraupcli.show();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente", "Sin empleado", 2);
        }
    }//GEN-LAST:event_btnupcliActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       infraupcli.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        cli.setid(Integer.parseInt(String.valueOf(jTablecli.getValueAt(jTablecli.getSelectedRow(), 0))));
        cli.setdireccion(txtdireccion.getText());
        try {
            cli.update(conexion.obtener());
            JOptionPane.showMessageDialog(this, "Cliente actualizado satisfactoriamnte", "Actualización", 1, admi.bien);
            tablaclientes();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getCause(), "Error", 0);
        }
        infraupcli.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    public String getfechaactual() {
        String fechac;
        Calendar c1 = Calendar.getInstance();
        Date fe = c1.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        fechac = formato.format(fe);
        return fechac;
    }
    
    public String gethoraactual() {
        String horac;
        Calendar c1 = Calendar.getInstance();
        Date fe = c1.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        horac = formato.format(fe);
        return horac;
    }

    public void getlogin(String usuario) {
        this.usuario = usuario;
    }

    public void actualizarclientes(JComboBox combo) {
        try {
            combo.removeAllItems();
            clien = cli.selectdoc(conexion.obtener());
            for (int i = 0; i < clien.size(); i++) {
                combo.addItem(clien.get(i));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getCause(), "Error", 0);
        }
    }
    
    public void tablaclientes(){
         List<String[]> filas = new ArrayList<>();
         modelocli.setRowCount(0);
        try {
            filas = cli.selecttodo(conexion.obtener());
            for (String[] campo : filas) {
                modelocli.addRow(campo);
            }
            jTablecli.repaint();
            jTablecli.setDefaultEditor(Object.class, null);

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
   /*     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prevender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new prevender().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntend;
    private javax.swing.JButton btnclinw;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnreg;
    private javax.swing.JButton btnupcli;
    private javax.swing.JComboBox<String> comboclientes;
    private javax.swing.JComboBox<String> comboproductos;
    private javax.swing.JInternalFrame infraupcli;
    private javax.swing.JInternalFrame intnewemp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTablecli;
    private javax.swing.JTextField txtcanti;
    private javax.swing.JTextField txtclidir;
    private javax.swing.JTextField txtclidoc;
    private javax.swing.JTextField txtclinom;
    private javax.swing.JTextField txtdireccion;
    // End of variables declaration//GEN-END:variables
}
