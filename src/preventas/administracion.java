/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventas;

import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.Box;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.api.SubstanceConstants;
import org.jvnet.substance.shaper.StandardButtonShaper;

/**
 *
 * @author crisi
 */
public class administracion extends javax.swing.JFrame {

    public Icon bien = new ImageIcon(getClass().getResource("/preventas/chulo.png"));
    public DefaultTableModel modelopro = new DefaultTableModel();
    DefaultTableModel modeloemp = new DefaultTableModel();
    public DefaultTableModel modeloped = new DefaultTableModel();
    DefaultTableModel modelodeta;
    DefaultComboBoxModel modcom = new DefaultComboBoxModel();
    productos pro = new productos();
    usuarios usu = new usuarios();
    pedidos ped = new pedidos();
    clientes cli = new clientes();
    detallepedido det = new detallepedido();
    String d, fechaglobal;
    JMenu jMenuusu;
    List<Integer> cambios;

    public administracion() {
        initComponents();
        JMenuItem sesionclose = new JMenuItem();
        sesionclose.setText("Cerrar sesión");
        sesionclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login log = new login();
                log.setVisible(true);
                administracion.this.dispose();
            }
        });
        jMenuusu = new JMenu();
        jMenuusu.setText(" ");
        jMenuusu.setSize(50, 19);
        jMenuusu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuusu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/preventas/avataricon.jpg")));
        jMenuusu.add(sesionclose);
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuusu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        jMenuBar1.add(jMenuusu);
        
 /*       jTableped.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = jTableped.columnAtPoint(e.getPoint());
              //  String name = jTableped.getColumnName(col);
              
            }         
}); */

        guistart();
    }

    public void guistart() {
        this.btnpro.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.btnpro.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btnpro.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btninpro.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.btninpro.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btninpro.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btnacpro.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.btnacpro.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btnacpro.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btninem.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.btninem.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btninem.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btnacem.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.btnacem.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btnacem.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btnelem.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.btnelem.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btnelem.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.TOP);
        this.btncambios.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.btncambios.putClientProperty(SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, SubstanceConstants.Side.LEFT);
        this.btncambios.putClientProperty(SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, SubstanceConstants.Side.LEFT);
        setLocationRelativeTo(null);
        actualizartablapro(modelopro);
        actualizartablaemp(modeloemp);
        Calendar c1 = Calendar.getInstance();
        Date fe = c1.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        fechaglobal = formato.format(fe);
        try {
            fe = formato.parse(fechaglobal);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
        datfech.setDate(fe);
        btnconsf.doClick();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        newpro = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnewsoc = new javax.swing.JButton();
        txtstock = new javax.swing.JTextField();
        txtpre = new javax.swing.JTextField();
        txtdes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        newemp = new javax.swing.JInternalFrame();
        jLabel15 = new javax.swing.JLabel();
        txtnwdoc = new javax.swing.JTextField();
        txtnwnom = new javax.swing.JTextField();
        txtnwape = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtcan = new javax.swing.JButton();
        txtgua = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        infrauppro = new javax.swing.JInternalFrame();
        jLabel9 = new javax.swing.JLabel();
        txtupstock = new javax.swing.JTextField();
        btnuppro = new javax.swing.JButton();
        btnguapro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtuppre = new javax.swing.JTextField();
        infraupemp = new javax.swing.JInternalFrame();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtupcon = new javax.swing.JPasswordField();
        txtupcon1 = new javax.swing.JPasswordField();
        jifractclave = new javax.swing.JInternalFrame();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPasscont = new javax.swing.JPasswordField();
        jPassnew = new javax.swing.JPasswordField();
        jPassconf = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btninpro = new javax.swing.JButton();
        btnacpro = new javax.swing.JButton();
        btnpro = new javax.swing.JButton();
        btninem = new javax.swing.JButton();
        btnacem = new javax.swing.JButton();
        btnelem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableped = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnconsf = new javax.swing.JButton();
        datfech = new com.toedter.calendar.JDateChooser();
        datfech.setDateFormatString("yyyy/MM/dd");
        datfech.getDateEditor().setEnabled(false);
        jLabel10 = new javax.swing.JLabel();
        comboclien = new javax.swing.JComboBox<>();
        rbfecha = new javax.swing.JRadioButton();
        rbcliente = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabledeta = new javax.swing.JTable();
        ;
        btnpasar = new javax.swing.JButton();
        lblpedi = new javax.swing.JLabel();
        lblp = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        String twoLines = "Aplicar\ncambios";
        btncambios = new javax.swing.JButton("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>");
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmnpassword = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        nuevapreventa = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor de preventas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1300, 850));
        setSize(new java.awt.Dimension(1300, 850));

        jScrollPane5.setToolTipText("");
        jScrollPane5.setMinimumSize(new java.awt.Dimension(1300, 850));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(1300, 850));

        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 850));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 850));
        jPanel1.setLayout(null);

        newpro.setVisible(false);
        newpro.getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nuevo producto");
        newpro.getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 0, 126, 22);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        newpro.getContentPane().add(jButton1);
        jButton1.setBounds(60, 200, 90, 23);

        btnewsoc.setText("Guardar");
        btnewsoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnewsocActionPerformed(evt);
            }
        });
        newpro.getContentPane().add(btnewsoc);
        btnewsoc.setBounds(190, 200, 90, 23);
        newpro.getContentPane().add(txtstock);
        txtstock.setBounds(90, 140, 175, 23);
        newpro.getContentPane().add(txtpre);
        txtpre.setBounds(90, 90, 175, 23);

        txtdes.setVerifyInputWhenFocusTarget(false);
        newpro.getContentPane().add(txtdes);
        txtdes.setBounds(90, 40, 175, 23);

        jLabel2.setText("Descripción");
        newpro.getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 40, 70, 23);

        jLabel3.setText("Precio");
        newpro.getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 90, 60, 23);

        jLabel4.setText("Stock");
        newpro.getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 140, 60, 23);

        jPanel1.add(newpro);
        newpro.setBounds(460, 290, 350, 270);

        newemp.setVisible(false);
        newemp.getContentPane().setLayout(null);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Nuevo empleado");
        newemp.getContentPane().add(jLabel15);
        jLabel15.setBounds(90, 0, 150, 22);
        newemp.getContentPane().add(txtnwdoc);
        txtnwdoc.setBounds(160, 60, 169, 23);
        newemp.getContentPane().add(txtnwnom);
        txtnwnom.setBounds(160, 100, 169, 23);
        newemp.getContentPane().add(txtnwape);
        txtnwape.setBounds(160, 140, 169, 23);

        jLabel16.setText("Documento");
        newemp.getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 60, 110, 23);

        jLabel17.setText("Nombres");
        newemp.getContentPane().add(jLabel17);
        jLabel17.setBounds(10, 100, 100, 23);

        txtcan.setText("Cancelar");
        txtcan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcanActionPerformed(evt);
            }
        });
        newemp.getContentPane().add(txtcan);
        txtcan.setBounds(50, 210, 100, 23);

        txtgua.setText("Guardar");
        txtgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtguaActionPerformed(evt);
            }
        });
        newemp.getContentPane().add(txtgua);
        txtgua.setBounds(200, 210, 100, 23);

        jLabel28.setText("Apellidos");
        newemp.getContentPane().add(jLabel28);
        jLabel28.setBounds(10, 140, 140, 23);

        jPanel1.add(newemp);
        newemp.setBounds(480, 270, 370, 280);

        infrauppro.setVisible(false);
        infrauppro.getContentPane().setLayout(null);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Stock");
        infrauppro.getContentPane().add(jLabel9);
        jLabel9.setBounds(80, 10, 118, 20);
        infrauppro.getContentPane().add(txtupstock);
        txtupstock.setBounds(90, 40, 120, 23);

        btnuppro.setText("Cancelar");
        btnuppro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupproActionPerformed(evt);
            }
        });
        infrauppro.getContentPane().add(btnuppro);
        btnuppro.setBounds(30, 160, 90, 23);

        btnguapro.setText("Guardar");
        btnguapro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguaproActionPerformed(evt);
            }
        });
        infrauppro.getContentPane().add(btnguapro);
        btnguapro.setBounds(150, 160, 100, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("+");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infrauppro.getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 40, 13, 23);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Precio");
        infrauppro.getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 80, 130, 14);
        infrauppro.getContentPane().add(txtuppre);
        txtuppre.setBounds(70, 100, 150, 23);

        jPanel1.add(infrauppro);
        infrauppro.setBounds(510, 330, 300, 250);

        infraupemp.setVisible(false);
        infraupemp.getContentPane().setLayout(null);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nueva contraseña");
        infraupemp.getContentPane().add(jLabel11);
        jLabel11.setBounds(80, 0, 140, 23);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Confirmar contraseña");
        infraupemp.getContentPane().add(jLabel12);
        jLabel12.setBounds(80, 60, 130, 23);

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        infraupemp.getContentPane().add(jButton3);
        jButton3.setBounds(28, 132, 86, 23);

        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        infraupemp.getContentPane().add(jButton4);
        jButton4.setBounds(175, 132, 86, 23);
        infraupemp.getContentPane().add(txtupcon);
        txtupcon.setBounds(70, 30, 160, 23);
        infraupemp.getContentPane().add(txtupcon1);
        txtupcon1.setBounds(70, 90, 160, 23);

        jPanel1.add(infraupemp);
        infraupemp.setBounds(500, 320, 320, 220);

        jifractclave.setVisible(false);
        jifractclave.getContentPane().setLayout(null);

        jLabel14.setText("Contraseña actual");
        jifractclave.getContentPane().add(jLabel14);
        jLabel14.setBounds(10, 30, 110, 20);

        jLabel21.setText("Nueva contraseña");
        jifractclave.getContentPane().add(jLabel21);
        jLabel21.setBounds(10, 70, 110, 20);

        jLabel22.setText("Confirmar contraseña");
        jifractclave.getContentPane().add(jLabel22);
        jLabel22.setBounds(10, 108, 110, 20);
        jifractclave.getContentPane().add(jPasscont);
        jPasscont.setBounds(134, 29, 130, 23);
        jifractclave.getContentPane().add(jPassnew);
        jPassnew.setBounds(134, 67, 130, 23);
        jifractclave.getContentPane().add(jPassconf);
        jPassconf.setBounds(132, 105, 130, 23);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jifractclave.getContentPane().add(jButton2);
        jButton2.setBounds(30, 160, 75, 23);

        jButton5.setText("Aceptar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jifractclave.getContentPane().add(jButton5);
        jButton5.setBounds(170, 160, 80, 23);

        jPanel1.add(jifractclave);
        jifractclave.setBounds(520, 320, 290, 240);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRequestFocusEnabled(false);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setModel(modelopro);
        modelopro.addColumn("ID");
        modelopro.addColumn("Descripción");
        modelopro.addColumn("Precio");
        modelopro.addColumn("Stock");

        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 570, 610, 170);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Consultar Pedidos");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(230, 30, 170, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Empleados");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(910, 550, 140, 20);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 200));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.setModel(modeloemp);
        modeloemp.addColumn("ID");
        modeloemp.addColumn("Identificación");
        modeloemp.addColumn("Usuario");
        modeloemp.addColumn("Apellidos");
        modeloemp.addColumn("Nombres");
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(650, 570, 610, 170);

        btninpro.setText("Nuevo");
        btninpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninproActionPerformed(evt);
            }
        });
        jPanel1.add(btninpro);
        btninpro.setBounds(30, 740, 110, 25);

        btnacpro.setText("Actualizar");
        btnacpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnacproActionPerformed(evt);
            }
        });
        jPanel1.add(btnacpro);
        btnacpro.setBounds(140, 740, 110, 25);

        btnpro.setText("Retirar");
        btnpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproActionPerformed(evt);
            }
        });
        jPanel1.add(btnpro);
        btnpro.setBounds(250, 740, 110, 25);

        btninem.setText("Nuevo");
        btninem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninemActionPerformed(evt);
            }
        });
        jPanel1.add(btninem);
        btninem.setBounds(650, 740, 110, 25);

        btnacem.setText("Cambiar clave");
        btnacem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnacemActionPerformed(evt);
            }
        });
        jPanel1.add(btnacem);
        btnacem.setBounds(760, 740, 110, 25);

        btnelem.setText("Borrar");
        btnelem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelemActionPerformed(evt);
            }
        });
        jPanel1.add(btnelem);
        btnelem.setBounds(870, 740, 110, 25);

        jTableped.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableped.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableped.setModel(modeloped);
        modeloped.addColumn("ID");
        modeloped.addColumn("Fecha");
        modeloped.addColumn("Hora");
        modeloped.addColumn("Empleado");
        modeloped.addColumn("Cliente");
        modeloped.addColumn("Total");
        modeloped.addColumn("Estado");
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(modeloped);
        jTableped.setRowSorter(elQueOrdena);

        jScrollPane3.setViewportView(jTableped);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(40, 50, 560, 320);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Productos");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(290, 550, 110, 20);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Fecha");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(140, 380, 70, 25);

        btnconsf.setText("Buscar");
        btnconsf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsrod(evt);
            }
        });
        jPanel1.add(btnconsf);
        btnconsf.setBounds(470, 400, 70, 25);
        jPanel1.add(datfech);
        datfech.setBounds(240, 380, 210, 25);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Cliente");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(140, 420, 70, 25);

        comboclien.setEnabled(false);
        jPanel1.add(comboclien);
        comboclien.setBounds(240, 420, 210, 25);

        rbfecha.setSelected(true);
        rbfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbfechaActionPerformed(evt);
            }
        });
        jPanel1.add(rbfecha);
        rbfecha.setBounds(70, 380, 30, 30);

        rbcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbclienteActionPerformed(evt);
            }
        });
        jPanel1.add(rbcliente);
        rbcliente.setBounds(70, 420, 30, 30);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(18, 520, 10, 270);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(18, 790, 1250, 10);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(1270, 520, 10, 270);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Panel de pedidos");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(50, 10, 160, 22);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(240, 520, 1030, 10);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(18, 520, 30, 10);
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(190, 20, 1080, 10);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator7);
        jSeparator7.setBounds(1270, 20, 10, 450);
        jPanel1.add(jSeparator8);
        jSeparator8.setBounds(18, 470, 1250, 10);

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator9);
        jSeparator9.setBounds(18, 20, 10, 450);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Panel de administración ");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(50, 510, 210, 22);
        jPanel1.add(jSeparator10);
        jSeparator10.setBounds(18, 20, 30, 10);

        jTabledeta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTabledeta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jScrollPane4.setViewportView(jTabledeta);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(740, 50, 430, 402);

        btnpasar.setText(">>");
        btnpasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpasarActionPerformed(evt);
            }
        });
        jPanel1.add(btnpasar);
        btnpasar.setBounds(620, 180, 100, 30);

        lblpedi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblpedi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblpedi.setText("Detalles Pedido:");
        jPanel1.add(lblpedi);
        lblpedi.setBounds(840, 30, 130, 20);

        lblp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblp);
        lblp.setBounds(950, 30, 90, 20);

        jButton7.setText("Confirmar entrega");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(610, 300, 120, 30);

        jButton8.setText("Cancelar pedido");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(610, 340, 120, 30);

        btncambios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambiosActionPerformed(evt);
            }
        });
        jPanel1.add(btncambios);
        btncambios.setBounds(1170, 50, 90, 30);

        jScrollPane5.setViewportView(jPanel1);

        getContentPane().add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Archivo");

        jmnpassword.setText("Cambiar contraseña");
        jmnpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateclave(evt);
            }
        });
        jMenu1.add(jmnpassword);

        jMenuItem2.setText("Nuevo usuario");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newusu(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(null);
        jMenu2.setText("Ventas");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        nuevapreventa.setText("Nueva venta");
        nuevapreventa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nuevapreventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevapreventaActionPerformed(evt);
            }
        });
        jMenu2.add(nuevapreventa);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem3.setText("Refrescar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnewsocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnewsocActionPerformed
        try {
            pro.setdescripcion(txtdes.getText());
            pro.setprecio(Integer.parseInt(txtpre.getText()));
            pro.setstock(Integer.parseInt(txtstock.getText()));
            pro.insert(conexion.obtener());
            JOptionPane.showMessageDialog(this, "Producto ingresado", "Registro exitoso", 1, bien);
            newpro.dispose();
            modelopro.setRowCount(0);
            actualizartablapro(modelopro);
            jTable1.repaint();
        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_btnewsocActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        newpro.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btninproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninproActionPerformed
        newpro.setVisible(true);
    }//GEN-LAST:event_btninproActionPerformed

    private void btnacproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnacproActionPerformed
        if (jTable1.getSelectedRow() != -1) {
            infrauppro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto", "Sin producto", 2);
        }

    }//GEN-LAST:event_btnacproActionPerformed

    private void btninemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninemActionPerformed
        newemp.setVisible(true);
    }//GEN-LAST:event_btninemActionPerformed

    private void txtguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtguaActionPerformed
        try {
            usu.setdocumento(txtnwdoc.getText());
            usu.setnombres(txtnwnom.getText());
            usu.setapellidos(txtnwape.getText());
            String usua = txtnwnom.getText() + "-" + txtnwape.getText();
            String key = txtnwdoc.getText().substring(txtnwdoc.getText().length() - 6, txtnwdoc.getText().length());
            usu.setusuario(usua);
            usu.setclave(key);
            usu.setprivilegios("Basico");
            usu.insert(conexion.obtener());
            JOptionPane.showMessageDialog(this, "Empleado ingresado", "Registro exitoso", 1, bien);
            newemp.dispose();
            modeloemp.setRowCount(0);
            actualizartablaemp(modeloemp);
            jTable2.repaint();
        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_txtguaActionPerformed

    private void btnupproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupproActionPerformed
        infrauppro.dispose();
    }//GEN-LAST:event_btnupproActionPerformed

    private void btnguaproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguaproActionPerformed
        int sto = 0;
        try {
            pro.setid(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
            sto = pro.selectstock(conexion.obtener());
            if (txtuppre.getText().isEmpty() && txtupstock.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Los campos estan vacios", "Error", 0);
            } else if (!txtuppre.getText().isEmpty() && !txtupstock.getText().isEmpty()) {
                pro.setstock(Integer.parseInt(txtupstock.getText()) + sto);
                pro.setprecio(Integer.parseInt(txtuppre.getText()));
            } else if (txtuppre.getText().isEmpty() && !txtupstock.getText().isEmpty()) {
                pro.setprecio(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()));
                pro.setstock(Integer.parseInt(txtupstock.getText()) + sto);
            } else if (!txtuppre.getText().isEmpty() && txtupstock.getText().isEmpty()) {
                pro.setprecio(Integer.parseInt(txtuppre.getText()));
                pro.setstock(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()));
            }
            pro.update(conexion.obtener());
            JOptionPane.showMessageDialog(this, "Producto actualizado", "Actualizacion exitosa", 1, bien);
            infrauppro.dispose();
            modelopro.setRowCount(0);
            actualizartablapro(modelopro);
            jTable1.repaint();
        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_btnguaproActionPerformed

    private void btnproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproActionPerformed
        if (jTable1.getSelectedRow() != 1) {
            int op = JOptionPane.showConfirmDialog(this, "¿Desea borrar este producto?", "Remover producto", JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                pro.setid(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
                try {
                    pro.delete(conexion.obtener());
                    JOptionPane.showMessageDialog(this, "Producto removido", "Remocion exitosa", 1, bien);
                    modelopro.setRowCount(0);
                    actualizartablapro(modelopro);
                    jTable1.repaint();
                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos que retirar", "Advertencia", 2);
        }
    }//GEN-LAST:event_btnproActionPerformed

    private void btnacemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnacemActionPerformed
        if (jTable2.getSelectedRow() != -1) {
            infraupemp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado", "Sin empleado", 2);
        }

    }//GEN-LAST:event_btnacemActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        infraupemp.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTable2.getSelectedRow() != -1) {
            usu.setid(Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString()));
            try {
                usu.update(conexion.obtener());
                JOptionPane.showMessageDialog(this, "Contraseña actualizada", "Actualización exitosa", 1, bien);
                modeloemp.setRowCount(0);
                infraupemp.dispose();
                actualizartablaemp(modeloemp);
                jTable2.repaint();
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione empleado a actualizar", "Advertencia", 2);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnelemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelemActionPerformed
        if (jTable2.getSelectedRow() != -1) {
            int op = JOptionPane.showConfirmDialog(this, "¿Desea borrar este empleado?", "Remover empleado", JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                usu.setid(Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString()));
                try {
                    usu.delete(conexion.obtener());
                    JOptionPane.showMessageDialog(this, "Empleado removido", "Remocion exitosa", 1, bien);
                    modeloemp.setRowCount(0);
                    actualizartablaemp(modeloemp);
                    jTable2.repaint();
                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione empleado que retirar", "Advertencia", 2);
        }
    }//GEN-LAST:event_btnelemActionPerformed


    private void txtcanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcanActionPerformed
        newemp.dispose();
    }//GEN-LAST:event_txtcanActionPerformed

    private void updateclave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateclave
        jifractclave.setVisible(true);
    }//GEN-LAST:event_updateclave

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (jPassnew.getText().equals(jPassconf.getText())) {
            if(jPassconf.getText().length()> 6){
            try {
                String actual = usu.selectadmin(conexion.obtener(), d);
                if (actual.equals(jPasscont.getText())) {
                    usu.setusuario(d);
                    usu.setclave(jPassnew.getText());
                    usu.update(conexion.obtener());
                    JOptionPane.showMessageDialog(this, "Contraseña actualizada correctamente", "Transacción exitosa", 1, bien);
                    jifractclave.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Las contraseña actual es incorrecta", "Error de entrada", 0);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
            }
            }else{
                JOptionPane.showMessageDialog(this, "La contraseña debe contener minimo 6 caracteres", "Error de entrada", 0);
            jPassconf.selectAll();
            jPassconf.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error de entrada", 0);
            jPassconf.selectAll();
            jPassconf.requestFocus();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jifractclave.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void newusu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newusu
        registrarse reg = new registrarse();
        reg.setVisible(true);
    }//GEN-LAST:event_newusu

    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        System.exit(0);
    }//GEN-LAST:event_salir

    private void btnconsrod(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsrod
        List<String[]> filas = new ArrayList<>();
        modeloped.setRowCount(0);
        if (rbfecha.isSelected()) {
            ped.setfecha(datfech.getCalendar().get(Calendar.YEAR) + "-" + (datfech.getCalendar().get(Calendar.MONTH) + 1) + "-" + datfech.getCalendar().get(Calendar.DAY_OF_MONTH));
            try {
                filas = ped.selectquery(conexion.obtener());
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
            }
        } else if (rbcliente.isSelected()) {
            try {
                ped.setclientes_id(cli.selectid(conexion.obtener(), String.valueOf(comboclien.getSelectedItem())));
                filas = ped.selectporcliente(conexion.obtener());
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
            }

        }
        for (String[] campo : filas) {
            modeloped.addRow(campo);
        }
        jTableped.setDefaultEditor(Object.class, null);
        jTableped.repaint();
    }//GEN-LAST:event_btnconsrod

    private void nuevapreventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevapreventaActionPerformed
        prevender preve = new prevender();
        preve.getlogin(d);
        preve.setVisible(true);
    }//GEN-LAST:event_nuevapreventaActionPerformed

    private void rbclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbclienteActionPerformed
        rbfecha.setSelected(false);
        datfech.setEnabled(false);
        comboclien.setEnabled(true);
        actualizarclientes();

    }//GEN-LAST:event_rbclienteActionPerformed

    private void rbfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbfechaActionPerformed
        rbcliente.setSelected(false);
        comboclien.setEnabled(false);
        datfech.setEnabled(true);
    }//GEN-LAST:event_rbfechaActionPerformed

    private void btnpasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpasarActionPerformed
        if (jTableped.getSelectedRow() != -1) {
            if (!jTableped.getValueAt(jTableped.getSelectedRow(), 5).equals("Pendiente")) {
                jTabledeta.setModel(modelodeta = new DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                            "ID", "Descripción", "Precio unitario", "Cantidad"
                        }
                ) {
                    boolean[] canEdit = new boolean[]{
                        false, false, false, false
                    };

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            } else {
                jTabledeta.setModel(modelodeta = new DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                            "ID", "Descripción", "Precio unitario", "Cantidad"
                        }
                ) {
                    boolean[] canEdit = new boolean[]{
                        false, false, false, true
                    };

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
                btncambios.setEnabled(true);
                det.setpedidos_id(Integer.parseInt(String.valueOf(jTableped.getValueAt(jTableped.getSelectedRow(), 0))));
                try {
                    cambios = det.selectiddetalles(conexion.obtener());
                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
                }
            }
            List<String[]> filasdetalles = new ArrayList<>();
            modelodeta.setRowCount(0);
            try {
                int idped = Integer.parseInt(String.valueOf(jTableped.getValueAt(jTableped.getSelectedRow(), 0)));
                det.setpedidos_id(idped);
                filasdetalles = det.selectdetalles(conexion.obtener());
                for (String[] campo : filasdetalles) {
                    modelodeta.addRow(campo);
                }
                jTabledeta.repaint();
                lblp.setText(String.valueOf(idped));
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un pedido", "Sin pedido", 2);
        }
    }//GEN-LAST:event_btnpasarActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int idped = Integer.parseInt(String.valueOf(jTableped.getValueAt(jTableped.getSelectedRow(), 0)));
        ped.setid(idped);
        try {
            if (ped.selectestado(conexion.obtener()).equals("Pendiente")) {
                det.setpedidos_id(idped);
                List<String[]> pedi = new ArrayList<>();
                pedi = det.selectcancel(conexion.obtener());
                for (int i = 0; i < pedi.size(); i++) {
                    String[] fila;
                    fila = pedi.get(i);
                    pro.setid(Integer.parseInt(fila[0]));
                    int can = pro.selectstock(conexion.obtener());
                    can = can + Integer.parseInt(fila[1]);
                    pro.setstock(can);
                    pro.updatestock(conexion.obtener());
                }
                ped.updateestado(conexion.obtener(), "Cancelado");
                JOptionPane.showMessageDialog(this, "Estado actualizado a cancelado correctamente", "Pedido cancelado", 1, bien);
                jMenuItem3.doClick();
            } else {
                JOptionPane.showMessageDialog(this, "El pedido seleccionado ya fue entregado o cancelado", "Error", 0);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ped.setid(Integer.parseInt(String.valueOf(jTableped.getValueAt(jTableped.getSelectedRow(), 0))));
        try {
            ped.updateestado(conexion.obtener(), "Entregado");
            JOptionPane.showMessageDialog(this, "Estado actualizado a entregado correctamente", "Pedido entregado", 1, bien);
            btnconsf.doClick();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        actualizartablapro(modelopro);
        btnconsf.doClick();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btncambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiosActionPerformed
        int suma = 0;
        for (int i = 0; i < cambios.size(); i++) {
            int cn = Integer.parseInt(String.valueOf(jTabledeta.getValueAt(i, 3)));
            if (cn >= 0) {
                int id = Integer.parseInt(String.valueOf(jTabledeta.getValueAt(i, 0)));
                int[] es = comprobarstock(cn, id);
                if (es[0] == 0) {
                    JOptionPane.showMessageDialog(this, "El valor ingresado para " + String.valueOf(jTabledeta.getValueAt(i, 1)) + " excede al stock actual", "Error", 0);
                } else {
                    if (es[0] == 1) {
                        JOptionPane.showMessageDialog(this, "El valor ingresado para " + String.valueOf(jTabledeta.getValueAt(i, 1)) + " excede el limite inferior de stock", "Actualizar stock", 2);
                    }
                    det.setid(cambios.get(i));
                    det.setcantidad(cn);
                    try {
                        int dif = cn - det.selectcantidad(conexion.obtener());
                        pro.setid(id);
                        int sto = es[1] - dif;
                        pro.setstock(sto);
                        pro.updatestock(conexion.obtener());
                        suma = suma + (dif * pro.selectprecio(conexion.obtener()));
                        det.update(conexion.obtener());
                    } catch (SQLException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
                    }                    
                }
            } else {
                JOptionPane.showMessageDialog(this, "El valor ingresado para " + String.valueOf(jTabledeta.getValueAt(i, 1)) + " no es valido", "Error", 0);
            }
        }
        int idped = Integer.parseInt(String.valueOf(jTableped.getValueAt(jTableped.getSelectedRow(), 0)));
        ped.setid(idped);
        try {
            ped.settotal(ped.selecttotal(conexion.obtener()) + suma);
            ped.update(conexion.obtener());
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
        actualizartablapro(modelopro);
        int index = jTableped.getSelectedRow();
        btnconsf.doClick();
        jTableped.changeSelection(index, 1, false, false);
        btnpasar.doClick();
    }//GEN-LAST:event_btncambiosActionPerformed

    public int[] comprobarstock(int cantidad, int idproducto) {
        int des[] = new int[2];
        des[0] = 0;
        try {
            pro.setid(idproducto);
            des[1] = pro.selectstock(conexion.obtener());
            if (des[1] > cantidad) {
                des[0] = 2;
                if (des[1] - cantidad <= 30) {
                    des[0] = 1;
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
        return des;
    }

    public void actualizartablapro(DefaultTableModel modelo) {
        List<String[]> filas = new ArrayList<>();
        modelo.setRowCount(0);
        try {
            filas = pro.selecttodo(conexion.obtener());
            for (String[] campo : filas) {
                modelo.addRow(campo);
            }
            jTable1.repaint();
            jTable1.setDefaultEditor(Object.class, null);

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }

    public void actualizartablaemp(DefaultTableModel modelo) {
        List<String[]> filas = new ArrayList<>();
        try {
            filas = usu.selecttodo(conexion.obtener());
            for (String[] campo : filas) {
                modelo.addRow(campo);
            }
            jTable2.repaint();
            jTable2.setDefaultEditor(Object.class, null);

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }

    public void actualizarclientes() {
        List<String> clien = new ArrayList<>();
        try {
            comboclien.removeAllItems();
            clien = cli.selectdoc(conexion.obtener());
            for (int i = 0; i < clien.size(); i++) {
                comboclien.addItem(clien.get(i));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getCause(), "Error", 0);
        }
    }

    public void docusu(String d) {
        this.d = d;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new administracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnacem;
    private javax.swing.JButton btnacpro;
    private javax.swing.JButton btncambios;
    public javax.swing.JButton btnconsf;
    private javax.swing.JButton btnelem;
    private javax.swing.JButton btnewsoc;
    private javax.swing.JButton btnguapro;
    private javax.swing.JButton btninem;
    private javax.swing.JButton btninpro;
    private javax.swing.JButton btnpasar;
    private javax.swing.JButton btnpro;
    private javax.swing.JButton btnuppro;
    private javax.swing.JComboBox<String> comboclien;
    private com.toedter.calendar.JDateChooser datfech;
    private javax.swing.JInternalFrame infraupemp;
    private javax.swing.JInternalFrame infrauppro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassconf;
    private javax.swing.JPasswordField jPasscont;
    private javax.swing.JPasswordField jPassnew;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTabledeta;
    private javax.swing.JTable jTableped;
    private javax.swing.JInternalFrame jifractclave;
    private javax.swing.JMenuItem jmnpassword;
    private javax.swing.JLabel lblp;
    private javax.swing.JLabel lblpedi;
    private javax.swing.JInternalFrame newemp;
    private javax.swing.JInternalFrame newpro;
    private javax.swing.JMenuItem nuevapreventa;
    private javax.swing.JRadioButton rbcliente;
    private javax.swing.JRadioButton rbfecha;
    private javax.swing.JButton txtcan;
    private javax.swing.JTextField txtdes;
    private javax.swing.JButton txtgua;
    private javax.swing.JTextField txtnwape;
    private javax.swing.JTextField txtnwdoc;
    private javax.swing.JTextField txtnwnom;
    private javax.swing.JTextField txtpre;
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txtupcon;
    private javax.swing.JTextField txtupcon1;
    private javax.swing.JTextField txtuppre;
    private javax.swing.JTextField txtupstock;
    // End of variables declaration//GEN-END:variables
}
