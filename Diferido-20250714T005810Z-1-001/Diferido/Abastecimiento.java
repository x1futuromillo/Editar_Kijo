package Diferido;

import com.toedter.calendar.JDateChooser;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import org.apache.xerces.parsers.DOMParser;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sun.misc.BASE64Encoder;

public class Abastecimiento extends JFrame {
   Datos_Hoja_de_Ruta dhr;
   Entrada en;
   String id_prov = "";
   JDateChooser Fecha;
   SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
   JTextField inputFieldTarj = null;
   public int caretPosTarj = 0;
   JTextField inputFieldEst = null;
   public int caretPosEst = 0;
   boolean bandera = false;
   private JLabel ActualizarEstab;
   private JLabel ActualizarEstab1;
   private JLabel ActualizarLoc;
   private JLabel ActualizarLoc1;
   private JLabel ActualizarTarj;
   private JLabel ActualizarTarj1;
   private JLabel ActualizarTipoDoc;
   private JLabel ActualizarTipoDoc1;
   private JTextField CantAbastecida;
   public JRadioButton Desplazamiento;
   private JComboBox Establecimiento;
   public JFormattedTextField Hora;
   private JLabel ImgAceptar;
   private JLabel ImgAceptar1;
   private JLabel ImgAct;
   private JLabel ImgAct1;
   private JLabel ImgAdicionar;
   private JLabel ImgAdicionar1;
   private JLabel ImgCancelar;
   private JLabel ImgCancelar1;
   private JLabel ImgEliminar;
   private JLabel ImgEliminar1;
   private JComboBox Localidad;
   public JTextField NoComprobante;
   private JComboBox NoTarjet;
   private JTextField Saldo_Final;
   private JTextField Saldo_Inic;
   public JTable Tabla;
   public JRadioButton Tecnologico;
   private JComboBox TipoDocumento;
   private JLabel User;
   private JLabel User1;
   private JLabel User2;
   private JLabel User3;
   private JLabel User4;
   private JLabel User5;
   private JLabel User6;
   private JLabel User7;
   private JLabel User8;
   private JLabel User9;
   private JLabel jLabel7;
   private JPanel jPanel1;
   private JScrollPane jScrollPane1;
   private JLabel tipo_abast;
   static String IdLocalidad = "";
   static String IdEstablecimiento = "";
   static String IdTarjeta = "";
   static String IdProvincia = "";

   public Abastecimiento(Datos_Hoja_de_Ruta dhr, Entrada en) throws MalformedURLException, SAXException, IOException {
      this.initComponents();
      this.setEditorTarjeta(new BasicComboBoxEditor());
      this.NoTarjet.setEditable(true);
      this.Establecimiento.setEditable(true);
      this.TipoDocumento.setVisible(false);
      this.ActualizarTipoDoc.setVisible(false);
      this.ActualizarTipoDoc1.setVisible(false);
      this.User7.setVisible(false);
      File dir_imagen = new File("test-data/diferido install.png");
      URL img = dir_imagen.toURI().toURL();
      this.setIconImage((new ImageIcon(img)).getImage());
      this.dhr = dhr;
      this.en = en;
      this.ImgAceptar.setVisible(true);
      this.ImgAceptar1.setVisible(false);
      this.ImgCancelar.setVisible(true);
      this.ImgCancelar1.setVisible(false);
      this.ImgAdicionar.setVisible(true);
      this.ImgAdicionar1.setVisible(false);
      this.ImgAct.setVisible(true);
      this.ImgAct1.setVisible(false);
      this.ImgEliminar1.setVisible(false);
      this.ImgEliminar.setVisible(true);
      this.ActualizarTarj1.setVisible(false);
      this.ActualizarTarj.setVisible(true);
      this.ActualizarEstab1.setVisible(false);
      this.ActualizarEstab.setVisible(true);
      this.ActualizarLoc.setVisible(true);
      this.ActualizarLoc1.setVisible(false);
      DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
      tcr.setHorizontalAlignment(0);
      this.Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
      this.Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(1).setPreferredWidth(10);
      this.Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(2).setPreferredWidth(5);
      this.Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(3).setPreferredWidth(5);
      this.Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(4).setPreferredWidth(10);
      this.Tabla.getColumnModel().getColumn(5).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(5).setPreferredWidth(5);
      this.Tabla.getColumnModel().getColumn(6).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(6).setPreferredWidth(25);
      this.Llenar_Combo_Tarjeta();
      this.Fecha = new JDateChooser("dd-MM-yy", "##/##/##", '_');
      this.Fecha.setBorder(BorderFactory.createBevelBorder(1));
      this.Fecha.setPreferredSize(new Dimension(80, 20));
      this.jPanel1.add(this.Fecha, new AbsoluteConstraints(75, 50, 80, -1), 1);
      this.Fecha.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            e.consume();
         }
      });
      int dia_inicial = Integer.parseInt(en.Fecha_Inicial.substring(0, 2));
      int mes_inicial = Integer.parseInt(en.Fecha_Inicial.substring(3, 5)) - 1;
      int anno_inicial = Integer.parseInt(en.Fecha_Inicial.substring(6, 8)) + 100;
      Date date_inicial = new Date(anno_inicial, mes_inicial, dia_inicial);
      int dia_final = Integer.parseInt(en.Fecha_Final.substring(0, 2));
      int mes_final = Integer.parseInt(en.Fecha_Final.substring(3, 5)) - 1;
      int anno_final = Integer.parseInt(en.Fecha_Final.substring(6, 8)) + 100;
      Date date_final = new Date(anno_final, mes_final, dia_final);
      this.Fecha.setSelectableDateRange(date_inicial, date_final);
      this.Fecha.setDate(date_inicial);
      if (en.ConsumoTec <= 0.0D) {
         this.Tecnologico.setEnabled(false);
      } else {
         this.Tecnologico.setEnabled(true);
      }

   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.ImgAceptar = new JLabel();
      this.ImgAceptar1 = new JLabel();
      this.ImgCancelar = new JLabel();
      this.ImgCancelar1 = new JLabel();
      this.ImgAdicionar = new JLabel();
      this.ImgAdicionar1 = new JLabel();
      this.ImgAct = new JLabel();
      this.ImgAct1 = new JLabel();
      this.ImgEliminar = new JLabel();
      this.ImgEliminar1 = new JLabel();
      this.User = new JLabel();
      this.User1 = new JLabel();
      this.NoTarjet = new JComboBox();
      this.NoComprobante = new JTextField();
      this.ActualizarTarj = new JLabel();
      this.ActualizarTarj1 = new JLabel();
      this.User2 = new JLabel();
      this.User3 = new JLabel();
      this.Establecimiento = new JComboBox();
      this.ActualizarEstab = new JLabel();
      this.ActualizarEstab1 = new JLabel();
      this.CantAbastecida = new JTextField();
      this.Localidad = new JComboBox();
      this.User4 = new JLabel();
      this.ActualizarLoc = new JLabel();
      this.ActualizarLoc1 = new JLabel();
      this.User5 = new JLabel();
      this.Hora = new JFormattedTextField();
      this.User6 = new JLabel();
      this.jScrollPane1 = new JScrollPane();
      this.Tabla = new JTable();
      this.TipoDocumento = new JComboBox();
      this.ActualizarTipoDoc = new JLabel();
      this.ActualizarTipoDoc1 = new JLabel();
      this.User7 = new JLabel();
      this.tipo_abast = new JLabel();
      this.Desplazamiento = new JRadioButton();
      this.Tecnologico = new JRadioButton();
      this.Saldo_Inic = new JTextField();
      this.User8 = new JLabel();
      this.Saldo_Final = new JTextField();
      this.User9 = new JLabel();
      this.jLabel7 = new JLabel();
      this.setDefaultCloseOperation(0);
      this.setTitle("Datos de Abastecimiento");
      this.setResizable(false);
      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent evt) {
            Abastecimiento.this.formWindowClosing(evt);
         }
      });
      this.jPanel1.setBackground(new Color(201, 231, 221));
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.ImgAceptar.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar.png")));
      this.ImgAceptar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Abastecimiento.this.ImgAceptarMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImgAceptar, new AbsoluteConstraints(230, 340, 96, 32));
      this.ImgAceptar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar on.png")));
      this.ImgAceptar1.setText("jLabel8");
      this.ImgAceptar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Abastecimiento.this.ImgAceptar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Abastecimiento.this.ImgAceptar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgAceptar1, new AbsoluteConstraints(230, 340, 96, 32));
      this.ImgCancelar.setIcon(new ImageIcon(this.getClass().getResource("/Images/cancelar.png")));
      this.ImgCancelar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Abastecimiento.this.ImgCancelarMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImgCancelar, new AbsoluteConstraints(350, 340, 96, 32));
      this.ImgCancelar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/cancelar on.png")));
      this.ImgCancelar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Abastecimiento.this.ImgCancelar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Abastecimiento.this.ImgCancelar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgCancelar1, new AbsoluteConstraints(350, 340, 96, 32));
      this.ImgAdicionar.setIcon(new ImageIcon(this.getClass().getResource("/Images/adicionar.png")));
      this.ImgAdicionar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Abastecimiento.this.ImgAdicionarMouseEntered(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Abastecimiento.this.ImgAdicionarMouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgAdicionar, new AbsoluteConstraints(170, 170, 96, 32));
      this.ImgAdicionar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/adicionar on.png")));
      this.ImgAdicionar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Abastecimiento.this.ImgAdicionar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Abastecimiento.this.ImgAdicionar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgAdicionar1, new AbsoluteConstraints(170, 170, 96, 32));
      this.ImgAct.setIcon(new ImageIcon(this.getClass().getResource("/Images/actualizar.png")));
      this.ImgAct.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Abastecimiento.this.ImgActMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImgAct, new AbsoluteConstraints(280, 170, 96, 32));
      this.ImgAct1.setIcon(new ImageIcon(this.getClass().getResource("/Images/actualizar on.png")));
      this.ImgAct1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Abastecimiento.this.ImgAct1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Abastecimiento.this.ImgAct1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgAct1, new AbsoluteConstraints(280, 170, 96, 32));
      this.ImgEliminar.setIcon(new ImageIcon(this.getClass().getResource("/Images/eliminar.png")));
      this.ImgEliminar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Abastecimiento.this.ImgEliminarMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImgEliminar, new AbsoluteConstraints(390, 170, 96, 32));
      this.ImgEliminar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/eliminar on.png")));
      this.ImgEliminar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Abastecimiento.this.ImgEliminar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Abastecimiento.this.ImgEliminar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgEliminar1, new AbsoluteConstraints(390, 170, 96, 32));
      this.User.setFont(new Font("Tahoma", 0, 12));
      this.User.setForeground(new Color(0, 0, 102));
      this.User.setText("Cant. Abastecida:");
      this.jPanel1.add(this.User, new AbsoluteConstraints(480, 50, -1, -1));
      this.User1.setFont(new Font("Tahoma", 0, 12));
      this.User1.setForeground(new Color(0, 0, 102));
      this.User1.setText("Tarjeta:");
      this.jPanel1.add(this.User1, new AbsoluteConstraints(310, 140, -1, -1));
      this.NoTarjet.setEditable(true);
      this.NoTarjet.setToolTipText("");
      this.NoTarjet.setBorder(BorderFactory.createBevelBorder(0));
      this.NoTarjet.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Abastecimiento.this.NoTarjetActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.NoTarjet, new AbsoluteConstraints(360, 130, 230, 25));
      this.NoComprobante.setBorder(BorderFactory.createBevelBorder(1));
      this.NoComprobante.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent evt) {
            Abastecimiento.this.NoComprobanteKeyTyped(evt);
         }
      });
      this.jPanel1.add(this.NoComprobante, new AbsoluteConstraints(390, 50, 70, -1));
      this.ActualizarTarj.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh.png")));
      this.ActualizarTarj.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Abastecimiento.this.ActualizarTarjMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ActualizarTarj, new AbsoluteConstraints(600, 130, 20, 20));
      this.ActualizarTarj1.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh on1.png")));
      this.ActualizarTarj1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Abastecimiento.this.ActualizarTarj1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Abastecimiento.this.ActualizarTarj1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ActualizarTarj1, new AbsoluteConstraints(590, 120, -1, -1));
      this.User2.setFont(new Font("Tahoma", 0, 12));
      this.User2.setForeground(new Color(0, 0, 102));
      this.User2.setText("Hora:");
      this.jPanel1.add(this.User2, new AbsoluteConstraints(170, 50, -1, -1));
      this.User3.setFont(new Font("Tahoma", 0, 12));
      this.User3.setForeground(new Color(0, 0, 102));
      this.User3.setText("Establecimiento:");
      this.jPanel1.add(this.User3, new AbsoluteConstraints(260, 85, -1, -1));
      this.Establecimiento.setBorder(BorderFactory.createBevelBorder(0));
      this.Establecimiento.setEnabled(false);
      this.jPanel1.add(this.Establecimiento, new AbsoluteConstraints(360, 80, 230, 25));
      this.ActualizarEstab.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh.png")));
      this.ActualizarEstab.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Abastecimiento.this.ActualizarEstabMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ActualizarEstab, new AbsoluteConstraints(600, 80, 20, 20));
      this.ActualizarEstab1.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh on1.png")));
      this.ActualizarEstab1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Abastecimiento.this.ActualizarEstab1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Abastecimiento.this.ActualizarEstab1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ActualizarEstab1, new AbsoluteConstraints(590, 70, -1, -1));
      this.CantAbastecida.setBorder(BorderFactory.createBevelBorder(1));
      this.CantAbastecida.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent evt) {
            Abastecimiento.this.CantAbastecidaKeyTyped(evt);
         }
      });
      this.jPanel1.add(this.CantAbastecida, new AbsoluteConstraints(580, 50, 50, -1));
      this.Localidad.setBorder(BorderFactory.createBevelBorder(0));
      this.Localidad.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent evt) {
            Abastecimiento.this.LocalidadItemStateChanged(evt);
         }
      });
      this.Localidad.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Abastecimiento.this.LocalidadActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Localidad, new AbsoluteConstraints(100, 80, 100, 25));
      this.User4.setFont(new Font("Tahoma", 0, 12));
      this.User4.setForeground(new Color(0, 0, 102));
      this.User4.setText("Localidad:");
      this.jPanel1.add(this.User4, new AbsoluteConstraints(30, 85, 60, -1));
      this.ActualizarLoc.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh.png")));
      this.ActualizarLoc.setText("jLabel8");
      this.ActualizarLoc.setMaximumSize(new Dimension(34, 14));
      this.ActualizarLoc.setMinimumSize(new Dimension(34, 14));
      this.ActualizarLoc.setPreferredSize(new Dimension(34, 14));
      this.ActualizarLoc.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Abastecimiento.this.ActualizarLocMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ActualizarLoc, new AbsoluteConstraints(210, 80, 20, 20));
      this.ActualizarLoc1.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh on1.png")));
      this.ActualizarLoc1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Abastecimiento.this.ActualizarLoc1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Abastecimiento.this.ActualizarLoc1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ActualizarLoc1, new AbsoluteConstraints(200, 70, 40, 40));
      this.User5.setFont(new Font("Tahoma", 0, 12));
      this.User5.setForeground(new Color(0, 0, 102));
      this.User5.setText("Fecha:");
      this.jPanel1.add(this.User5, new AbsoluteConstraints(30, 50, -1, -1));
      this.Hora.setBorder(BorderFactory.createBevelBorder(1));

      try {
         this.Hora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##")));
      } catch (ParseException var2) {
         var2.printStackTrace();
      }

      this.Hora.setText("0000");
      this.Hora.setToolTipText("Hora Inicial de la HR");
      this.Hora.addFocusListener(new FocusAdapter() {
         public void focusLost(FocusEvent evt) {
            Abastecimiento.this.HoraFocusLost(evt);
         }
      });
      this.jPanel1.add(this.Hora, new AbsoluteConstraints(210, 50, 50, -1));
      this.User6.setFont(new Font("Tahoma", 0, 12));
      this.User6.setForeground(new Color(0, 0, 102));
      this.User6.setText("No. Comprobante:");
      this.jPanel1.add(this.User6, new AbsoluteConstraints(280, 50, -1, -1));
      this.Tabla.setModel(new DefaultTableModel(new Object[0][], new String[]{"Fecha-Hora", "Tarjeta", "Comprobante", "Saldo_Inic", "Abastecido (L)", "Saldo_Fin", "Localidad", "Establecimiento", "Tipo_Abastecimiento"}) {
         Class[] types = new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
         boolean[] canEdit = new boolean[]{false, false, true, false, true, false, false, false, false};

         public Class getColumnClass(int columnIndex) {
            return this.types[columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return this.canEdit[columnIndex];
         }
      });
      this.Tabla.setSelectionMode(0);
      this.Tabla.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Abastecimiento.this.TablaMouseClicked(evt);
         }
      });
      this.jScrollPane1.setViewportView(this.Tabla);
      this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(20, 220, 620, 100));
      this.TipoDocumento.setBorder(BorderFactory.createBevelBorder(0));
      this.TipoDocumento.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent evt) {
            Abastecimiento.this.TipoDocumentoItemStateChanged(evt);
         }
      });
      this.TipoDocumento.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Abastecimiento.this.TipoDocumentoActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.TipoDocumento, new AbsoluteConstraints(90, 340, 100, 25));
      this.ActualizarTipoDoc.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh.png")));
      this.ActualizarTipoDoc.setText("jLabel8");
      this.ActualizarTipoDoc.setMaximumSize(new Dimension(34, 14));
      this.ActualizarTipoDoc.setMinimumSize(new Dimension(34, 14));
      this.ActualizarTipoDoc.setPreferredSize(new Dimension(34, 14));
      this.ActualizarTipoDoc.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Abastecimiento.this.ActualizarTipoDocMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ActualizarTipoDoc, new AbsoluteConstraints(200, 340, 20, 20));
      this.ActualizarTipoDoc1.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh on1.png")));
      this.ActualizarTipoDoc1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Abastecimiento.this.ActualizarTipoDoc1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Abastecimiento.this.ActualizarTipoDoc1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ActualizarTipoDoc1, new AbsoluteConstraints(190, 330, 40, 40));
      this.User7.setFont(new Font("Tahoma", 0, 12));
      this.User7.setForeground(new Color(0, 0, 102));
      this.User7.setText("Tipo de Doc.:");
      this.jPanel1.add(this.User7, new AbsoluteConstraints(10, 350, 80, -1));
      this.tipo_abast.setFont(new Font("Tahoma", 0, 12));
      this.tipo_abast.setForeground(new Color(0, 0, 102));
      this.tipo_abast.setText("Tipo Abastecimiento:");
      this.jPanel1.add(this.tipo_abast, new AbsoluteConstraints(20, 10, 120, -1));
      this.Desplazamiento.setBackground(new Color(237, 243, 248));
      this.Desplazamiento.setFont(new Font("Tahoma", 0, 12));
      this.Desplazamiento.setForeground(new Color(0, 0, 102));
      this.Desplazamiento.setSelected(true);
      this.Desplazamiento.setText("Por Desplazamiento");
      this.Desplazamiento.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Abastecimiento.this.DesplazamientoActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Desplazamiento, new AbsoluteConstraints(150, 0, -1, 30));
      this.Tecnologico.setBackground(new Color(237, 243, 248));
      this.Tecnologico.setFont(new Font("Tahoma", 0, 12));
      this.Tecnologico.setForeground(new Color(0, 0, 102));
      this.Tecnologico.setText("Tecnológico");
      this.Tecnologico.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Abastecimiento.this.TecnologicoActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Tecnologico, new AbsoluteConstraints(300, 0, -1, 30));
      this.Saldo_Inic.setBorder(BorderFactory.createBevelBorder(1));
      this.Saldo_Inic.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent evt) {
            Abastecimiento.this.Saldo_InicKeyTyped(evt);
         }
      });
      this.jPanel1.add(this.Saldo_Inic, new AbsoluteConstraints(100, 130, 50, -1));
      this.User8.setFont(new Font("Tahoma", 0, 12));
      this.User8.setForeground(new Color(0, 0, 102));
      this.User8.setText("Saldo Inicial $:");
      this.jPanel1.add(this.User8, new AbsoluteConstraints(20, 130, -1, -1));
      this.Saldo_Final.setBorder(BorderFactory.createBevelBorder(1));
      this.Saldo_Final.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent evt) {
            Abastecimiento.this.Saldo_FinalKeyTyped(evt);
         }
      });
      this.jPanel1.add(this.Saldo_Final, new AbsoluteConstraints(100, 160, 50, -1));
      this.User9.setFont(new Font("Tahoma", 0, 12));
      this.User9.setForeground(new Color(0, 0, 102));
      this.User9.setText("Saldo Final $:");
      this.jPanel1.add(this.User9, new AbsoluteConstraints(20, 160, -1, -1));
      this.jLabel7.setIcon(new ImageIcon(this.getClass().getResource("/Images/fondo datos carga1.png")));
      this.jPanel1.add(this.jLabel7, new AbsoluteConstraints(0, 0, 661, 406));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, 406, -2).addGap(0, 0, 32767)));
      this.pack();
   }

   public void Post_Localidad() throws SAXException, IOException {
      String user = this.en.user;
      String password = this.en.pass;
      String sitio = this.en.GetSitio();
      String port = null;
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/ListadoProvincias";
      URL url;
      String msg;
      if (this.en.Hay_Proxy) {
         try {
            String ip = this.en.DireccionProxy;
            port = this.en.PuertoProxy;
            String usuariop = this.en.UsuarioProxy;
            String passp = this.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(port), sitio);
            conn = url.openConnection();
            String user_pass = usuariop + ":" + passp;
            String encoding = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + encoding);
         } catch (Exception var19) {
            msg = "Es Posible que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(msg, "Información", "Information");
            this.en.Tiene_Conexion = false;
            return;
         }
      } else {
         try {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         } catch (Exception var18) {
            msg = "Es Posible que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.";
            this.en.ShowMessage(msg, "Información", "Information");
            this.en.Tiene_Conexion = false;
            return;
         }
      }

      try {
         InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
         BufferedReader rd = new BufferedReader(isr);

         String line;
         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         this.en.Tiene_Conexion = true;
         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            File doc = new File("Tipo_Localidad.xml");
            if (doc.exists() && !doc.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(doc.getAbsolutePath());
            }

            this.en.Encrypt(this.en.encript, "Tipo_Localidad.xml", respuesta);
            this.Llenar_Combo_Localidad();
         } else {
            this.en.ShowMessage("Nombre de Usuario y Contraseña no Válidos.", "Información", "Information");
         }
      } catch (UnknownHostException var20) {
         msg = "Usted no Tiene Conexión en este Momento.";
         this.en.ShowMessage(msg, "Información", "Information");
         this.Llenar_Combo_Localidad();
      } catch (Exception var21) {
         msg = "Se Produjo un Error Tratando de Descargar la Lista de Provincias.";
         this.en.ShowMessage(msg, "Información", "Information");
      }
   }

   public void Post_Tarjeta() throws SAXException, IOException {
      String user = this.en.user;
      String password = this.en.pass;
      String sitio = this.en.GetSitio();
      String port = null;
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/ListadoTarjetas?Grupo=" + this.en.Grupo;
      URL url;
      String msg;
      if (this.en.Hay_Proxy) {
         try {
            String ip = this.en.DireccionProxy;
            port = this.en.PuertoProxy;
            String usuariop = this.en.UsuarioProxy;
            String passp = this.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(port), sitio);
            conn = url.openConnection();
            String user_pass = usuariop + ":" + passp;
            String encoding = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + encoding);
         } catch (Exception var19) {
            msg = "Es Posible que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(msg, "Información", "Information");
            this.en.Tiene_Conexion = false;
            return;
         }
      } else {
         try {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         } catch (Exception var18) {
            msg = "Es Posible que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.";
            this.en.ShowMessage(msg, "Información", "Information");
            this.en.Tiene_Conexion = false;
            return;
         }
      }

      try {
         InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
         BufferedReader rd = new BufferedReader(isr);

         String line;
         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         this.en.Tiene_Conexion = true;
         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            File um = new File("Tipo_Tarjeta.xml");
            if (!um.exists() && !um.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(um.getAbsolutePath());
            }

            this.en.Encrypt(this.en.encript, "Tipo_Tarjeta.xml", respuesta);
            this.Llenar_Combo_Tarjeta();
         } else {
            this.en.ShowMessage("Se Produjo un Error Tratando de Descargar la Lista de Tarjetas.", "Información", "Information");
         }
      } catch (UnknownHostException var20) {
         msg = "Usted no Tiene Conexión en este Momento.";
         this.en.ShowMessage(msg, "Información", "Information");
         this.Llenar_Combo_Tarjeta();
         this.en.Tiene_Conexion = false;
      } catch (Exception var21) {
         msg = "Se Produjo un Error Tratando de Descargar la Lista de Tarjetas.";
         this.en.ShowMessage(msg, "Información", "Information");
      }
   }

   private void formWindowClosing(WindowEvent evt) {
      this.setVisible(false);
      this.dhr.abastec_activo = false;
      if (this.Tabla.getRowCount() == 0) {
         this.dhr.abastecimient.setSelected(false);
      } else {
         this.dhr.abastecimient.setSelected(true);
      }

      this.dhr.setVisible(true);
   }

   private void ImgAceptar1MouseClicked(MouseEvent evt) {
      boolean ban = true;
      int cant = this.Tabla.getRowCount();
      if (cant > 0) {
         String fecha = "";
         String tarjeta = "";
         String no_comp = "";
         String cant_abast = "";
         String loc = "";
         String estab = "";
         String tipoAbast = "";
         String saldo_inic = "";
         String saldo_final = "";
         String id_loc = "";
         String id_estab = "";
         String id_tarjeta = "";
         Point geomEstab = null;
         this.dhr.ListaABAST.clear();
         this.dhr.Insertar_ListaAbast.clear();
         this.dhr.listado_chip.clear();

         for(int i = 0; i < cant; ++i) {
            fecha = this.Tabla.getValueAt(i, 0).toString();
            tarjeta = this.Tabla.getValueAt(i, 1).toString();
            no_comp = this.Tabla.getValueAt(i, 2).toString();
            saldo_inic = this.Tabla.getValueAt(i, 3).toString();
            cant_abast = this.Tabla.getValueAt(i, 4).toString();
            saldo_final = this.Tabla.getValueAt(i, 5).toString();
            loc = this.Tabla.getValueAt(i, 6).toString();
            estab = this.Tabla.getValueAt(i, 7).toString();
            tipoAbast = this.Tabla.getValueAt(i, 8).toString();
            id_tarjeta = this.Obtener_ID_Tarjeta(String.valueOf(tarjeta));
            id_loc = this.Obtener_ID_Loc(loc);
            id_estab = this.Obtener_ID_Establecimiento(estab, id_loc);

            try {
               geomEstab = this.Obtener_Geom_Establecimiento(estab, id_loc);
            } catch (com.vividsolutions.jts.io.ParseException var21) {
               Logger.getLogger(Abastecimiento.class.getName()).log(Level.SEVERE, (String)null, var21);
            }

            String abast_insert = fecha + "," + no_comp + "," + cant_abast + "," + loc + "," + estab + "," + tipoAbast + "," + saldo_inic + "," + saldo_final;
            this.dhr.Insertar_ListaAbast.add(abast_insert);
            ChipCombustible chip = new ChipCombustible(fecha, tarjeta, no_comp, Double.valueOf(cant_abast), loc, estab, Integer.valueOf(id_tarjeta), Integer.valueOf(id_loc), Integer.valueOf(id_estab), tipoAbast, geomEstab, Double.valueOf(saldo_inic), Double.valueOf(saldo_final));
            this.dhr.listado_chip.add(chip);
            String lineaxml = "<ABAST Fecha=\"" + fecha + "\"" + " " + "Num_tarj=" + "\"" + tarjeta + "\"" + " " + "NumComp=" + "\"" + no_comp + "\"" + " " + "CantAbast=" + "\"" + cant_abast + "\"" + " " + "Localidad=" + "\"" + loc + "\"" + " " + "Establecimiento=" + "\"" + estab + "\"" + " " + "TipoAbastecimiento=" + "\"" + tipoAbast + "\"" + " " + "IdTarje=" + "\"" + id_tarjeta + "\"" + " " + "IdLoc=" + "\"" + id_loc + "\"" + " " + "IdEst=" + "\"" + id_estab + "\"" + " " + "GeomEst=" + "\"" + geomEstab + "\"" + " " + "SaldoInicial=" + "\"" + saldo_inic + "\"" + " " + "SaldoFinal=" + "\"" + saldo_final + "\"" + "/>";
            this.dhr.ListaABAST.add(lineaxml);
            ban = true;
         }
      }

      if (this.Tabla.getRowCount() == 0) {
         this.dhr.abastecimient.setSelected(false);
      } else {
         this.dhr.abastecimient.setSelected(true);
         this.dhr.abastec_activo = false;
         this.dispose();
      }

   }

   private void ImgAceptarMouseEntered(MouseEvent evt) {
      this.ImgAceptar1.setVisible(true);
      this.ImgAceptar.setVisible(false);
   }

   private void ImgAceptar1MouseExited(MouseEvent evt) {
      this.ImgAceptar.setVisible(true);
      this.ImgAceptar1.setVisible(false);
   }

   private void ImgCancelar1MouseClicked(MouseEvent evt) {
      this.setVisible(false);
      this.dhr.abastec_activo = false;
      if (this.Tabla.getRowCount() == 0) {
         this.dhr.abastecimient.setSelected(false);
      } else {
         this.dhr.abastecimient.setSelected(true);
      }

      this.dhr.setVisible(true);
   }

   private void ImgCancelarMouseEntered(MouseEvent evt) {
      this.ImgCancelar.setVisible(false);
      this.ImgCancelar1.setVisible(true);
   }

   private void ImgCancelar1MouseExited(MouseEvent evt) {
      this.ImgCancelar.setVisible(true);
      this.ImgCancelar1.setVisible(false);
   }

   private void ImgAdicionar1MouseExited(MouseEvent evt) {
      this.ImgAdicionar.setVisible(true);
      this.ImgAdicionar1.setVisible(false);
   }

   private void ImgAdicionarMouseEntered(MouseEvent evt) {
      this.ImgAdicionar1.setVisible(true);
      this.ImgAdicionar.setVisible(false);
      this.bandera = true;
   }

   private void ImgAdicionar1MouseClicked(MouseEvent evt) {
      String fila = "";
      String tipoAbast = "";
      String cant_abastec = "";
      String cant_abastecTec = "";
      String saldo_inic = "";
      String saldo_final = "";
      String fi = this.en.Fecha_Inicial;
      String ff = this.en.Fecha_Final;
      String hi = this.en.Hora_Inicial;
      String hf = this.en.Hora_Final;
      if (this.bandera) {
         if (this.Fecha.getDate() == null) {
            this.en.ShowMessage("Debe Completar el Campo Fecha.", "Información", "Information");
         } else if (this.Hora.getText().equalsIgnoreCase("  :  ")) {
            this.en.ShowMessage("Debe Completar el Campo Hora.", "Información", "Information");
         } else if (this.NoComprobante.getText().equalsIgnoreCase("")) {
            this.en.ShowMessage("Debe Completar el Campo Número de Comprobante.", "Información", "Information");
         } else if (this.CantAbastecida.getText().equalsIgnoreCase("")) {
            this.en.ShowMessage("Debe Completar el Campo Cantidad Abastecida.", "Información", "Information");
         } else if (this.NoTarjet.getSelectedIndex() != -1 && this.NoTarjet.getSelectedIndex() != 0) {
            if (this.Localidad.getSelectedIndex() != -1 && this.Localidad.getSelectedIndex() != 0) {
               if (this.Establecimiento.getSelectedIndex() != -1 && this.Establecimiento.getSelectedIndex() != 0) {
                  if (this.en.ComparaFecha(this.formato.format(this.Fecha.getDate()), fi, this.Hora.getText(), hi, 1)) {
                     this.en.ShowMessage("La Fecha del Abastecimiento es Menor que la Fecha Inicial de la Trayectoria.", "Información", "Information");
                  } else if (this.en.ComparaFecha(ff, this.formato.format(this.Fecha.getDate()), hf, this.Hora.getText(), 1)) {
                     this.en.ShowMessage("La Fecha del Abastecimiento es Mayor que la Fecha Final de la Trayectoria.", "Información", "Information");
                  } else if (this.Saldo_Inic.getText().equalsIgnoreCase("")) {
                     this.en.ShowMessage("Debe Completar el Campo Saldo Inicial.", "Información", "Information");
                  } else if (this.Saldo_Final.getText().equalsIgnoreCase("")) {
                     this.en.ShowMessage("Debe Completar el Campo Saldo Final.", "Información", "Information");
                  } else {
                     DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();
                     if (this.Desplazamiento.isSelected()) {
                        tipoAbast = "Desplazamiento";
                     } else {
                        tipoAbast = "Tecnológico";
                     }

                     String fechahora = this.formato.format(this.Fecha.getDate()) + " " + this.Hora.getText();
                     String tarjeta = String.valueOf(this.NoTarjet.getSelectedItem());
                     String no_comprobante = String.valueOf(this.NoComprobante.getText());
                     if (tipoAbast.equalsIgnoreCase("Desplazamiento")) {
                        cant_abastec = String.valueOf(this.CantAbastecida.getText());
                     } else {
                        cant_abastecTec = String.valueOf(this.CantAbastecida.getText());
                     }

                     String localidad = String.valueOf(this.Localidad.getSelectedItem());
                     String estab = String.valueOf(this.Establecimiento.getSelectedItem());
                     saldo_inic = String.valueOf(this.Saldo_Inic.getText());
                     saldo_final = String.valueOf(this.Saldo_Final.getText());
                     int cant_elem = model.getRowCount();
                     int ban = false;
                     if (cant_elem == 0) {
                        if (tipoAbast.equalsIgnoreCase("Desplazamiento")) {
                           model.insertRow(model.getRowCount(), new Object[]{fechahora, tarjeta, no_comprobante, saldo_inic, cant_abastec, saldo_final, localidad, estab, tipoAbast});
                        } else {
                           model.insertRow(model.getRowCount(), new Object[]{fechahora, tarjeta, no_comprobante, saldo_inic, cant_abastecTec, saldo_final, localidad, estab, tipoAbast});
                        }

                        if (!ban) {
                           this.NoComprobante.setText("");
                           this.CantAbastecida.setText("");
                           this.Hora.setText("00:00");
                           this.Localidad.setSelectedIndex(0);
                           this.Establecimiento.setSelectedIndex(0);
                           this.Establecimiento.setEnabled(false);
                           this.Saldo_Inic.setText("");
                           this.Saldo_Final.setText("");
                           this.bandera = false;
                        }
                     } else {
                        for(int i = 0; i < cant_elem; ++i) {
                           String no_comprob = this.Tabla.getValueAt(i, 2).toString();
                           String FH = this.Tabla.getValueAt(i, 0).toString();
                           String Tipo_Abast = this.Tabla.getValueAt(i, 8).toString();
                           if (no_comprobante.equalsIgnoreCase(no_comprob)) {
                              this.en.ShowMessage("El Número de Comprobante ya Existe en la Tabla.", "Información", "Information");
                              ban = true;
                              break;
                           }

                           if (fechahora.equalsIgnoreCase(FH)) {
                              this.en.ShowMessage("La Fecha Hora ya Existe en la Tabla.Verifíquela", "Información", "Information");
                              ban = true;
                              break;
                           }
                        }

                        if (!ban) {
                           if (tipoAbast.equalsIgnoreCase("Desplazamiento")) {
                              model.insertRow(model.getRowCount(), new Object[]{fechahora, tarjeta, no_comprobante, saldo_inic, cant_abastec, saldo_final, localidad, estab, tipoAbast});
                           } else {
                              model.insertRow(model.getRowCount(), new Object[]{fechahora, tarjeta, no_comprobante, saldo_inic, cant_abastecTec, saldo_final, localidad, estab, tipoAbast});
                           }

                           this.NoComprobante.setText("");
                           this.CantAbastecida.setText("");
                           this.Hora.setText("00:00");
                           this.Localidad.setSelectedIndex(0);
                           this.Establecimiento.setSelectedIndex(0);
                           this.Establecimiento.setEnabled(false);
                           this.Saldo_Inic.setText("");
                           this.Saldo_Final.setText("");
                           this.bandera = false;
                        }
                     }
                  }
               } else {
                  this.en.ShowMessage("Debe Escoger un Establecimiento.", "Información", "Information");
               }
            } else {
               this.en.ShowMessage("Debe Escoger una Localidad.", "Información", "Information");
            }
         } else {
            this.en.ShowMessage("Debe Escoger una Tarjeta.", "Información", "Information");
         }
      }

   }

   private void ImgActMouseEntered(MouseEvent evt) {
      this.ImgAct1.setVisible(true);
      this.ImgAct.setVisible(false);
      this.bandera = true;
   }

   private void ImgAct1MouseExited(MouseEvent evt) {
      this.ImgAct.setVisible(true);
      this.ImgAct1.setVisible(false);
   }

   private void ImgAct1MouseClicked(MouseEvent evt) {
      String fila = "";
      String tipoAbast = "";
      String cant_abastec = "";
      String cant_abastecTec = "";
      String saldo_inic = "";
      String saldo_final = "";
      String fi = this.en.Fecha_Inicial;
      String ff = this.en.Fecha_Final;
      String hi = this.en.Hora_Inicial;
      String hf = this.en.Hora_Final;
      if (this.bandera) {
         if (this.Fecha.getDate() == null) {
            this.en.ShowMessage("Debe Completar el Campo Fecha.", "Información", "Information");
         } else if (this.Hora.getText().equalsIgnoreCase("  :  ")) {
            this.en.ShowMessage("Debe Completar el Campo Hora.", "Información", "Information");
         } else if (this.NoComprobante.getText().equalsIgnoreCase("")) {
            this.en.ShowMessage("Debe Completar el Campo Número de Comprobante.", "Información", "Information");
         } else if (this.CantAbastecida.getText().equalsIgnoreCase("")) {
            this.en.ShowMessage("Debe Completar el Campo Cantidad Abastecida.", "Información", "Information");
         } else if (this.NoTarjet.getSelectedIndex() != -1 && this.NoTarjet.getSelectedIndex() != 0) {
            if (this.Localidad.getSelectedIndex() != -1 && this.Localidad.getSelectedIndex() != 0) {
               if (this.Establecimiento.getSelectedIndex() != -1 && this.Establecimiento.getSelectedIndex() != 0) {
                  if (this.en.ComparaFecha(this.formato.format(this.Fecha.getDate()), fi, this.Hora.getText(), hi, 1)) {
                     this.en.ShowMessage("La Fecha del Abastecimiento es Menor que la Fecha Inicial de la Trayectoria.", "Información", "Information");
                  } else if (this.en.ComparaFecha(ff, this.formato.format(this.Fecha.getDate()), hf, this.Hora.getText(), 1)) {
                     this.en.ShowMessage("La Fecha del Abastecimiento es Mayor que la Fecha Final de la Trayectoria.", "Información", "Information");
                  } else if (this.Saldo_Inic.getText().equalsIgnoreCase("")) {
                     this.en.ShowMessage("Debe Completar el Campo Saldo Inicial.", "Información", "Information");
                  } else if (this.Saldo_Final.getText().equalsIgnoreCase("")) {
                     this.en.ShowMessage("Debe Completar el Campo Saldo Final.", "Información", "Information");
                  } else {
                     int Numero_fila = this.Tabla.getSelectedRow();
                     int cantFilas = this.Tabla.getRowCount();
                     if (cantFilas == 0) {
                        this.en.ShowMessage("No hay Elementos Insertados en la Tabla.", "Error", "Error");
                     } else if (Numero_fila == -1) {
                        this.en.ShowMessage("Debe Seleccionar una Fila de la Tabla.", "Error", "Error");
                     } else if (!this.Tabla.getColumnSelectionAllowed() && this.Tabla.getRowSelectionAllowed()) {
                        int ban = false;
                        if (this.Desplazamiento.isSelected()) {
                           tipoAbast = "Desplazamiento";
                        } else {
                           tipoAbast = "Tecnológico";
                        }

                        String fechahora = this.formato.format(this.Fecha.getDate()) + " " + this.Hora.getText();
                        String no_comprobante = String.valueOf(this.NoComprobante.getText());
                        if (tipoAbast.equalsIgnoreCase("Desplazamiento")) {
                           cant_abastec = String.valueOf(this.CantAbastecida.getText());
                        } else {
                           cant_abastecTec = String.valueOf(this.CantAbastecida.getText());
                        }

                        String tarjeta = String.valueOf(this.NoTarjet.getSelectedItem());
                        String localidad = String.valueOf(this.Localidad.getSelectedItem());
                        String estab = String.valueOf(this.Establecimiento.getSelectedItem());
                        saldo_inic = String.valueOf(this.Saldo_Inic.getText());
                        saldo_final = String.valueOf(this.Saldo_Final.getText());

                        for(int i = 0; i < cantFilas; ++i) {
                           if (i != Numero_fila) {
                              String fh_tabla = (String)this.Tabla.getValueAt(i, 0);
                              String noComp_tabla = (String)this.Tabla.getValueAt(i, 2);
                              if (no_comprobante.equalsIgnoreCase(noComp_tabla)) {
                                 this.en.ShowMessage("El Número de Comprobante ya Existe en la Tabla.", "Información", "Information");
                                 ban = true;
                                 break;
                              }

                              if (this.Hora.getText().equalsIgnoreCase("  :  ")) {
                                 this.en.ShowMessage("Actualice la Hora Correctamente.", "Información", "Information");
                                 ban = true;
                                 break;
                              }

                              if (fechahora.equalsIgnoreCase(fh_tabla)) {
                                 this.en.ShowMessage("La Fecha Hora ya Existe en la Tabla.Verifíquela", "Información", "Information");
                                 ban = true;
                                 break;
                              }
                           }
                        }

                        if (!ban) {
                           this.Tabla.setValueAt(fechahora, Numero_fila, 0);
                           this.Tabla.setValueAt(tarjeta, Numero_fila, 1);
                           this.Tabla.setValueAt(no_comprobante, Numero_fila, 2);
                           this.Tabla.setValueAt(saldo_inic, Numero_fila, 3);
                           this.Tabla.setValueAt(cant_abastec, Numero_fila, 4);
                           this.Tabla.setValueAt(saldo_final, Numero_fila, 5);
                           this.Tabla.setValueAt(localidad, Numero_fila, 6);
                           this.Tabla.setValueAt(estab, Numero_fila, 7);
                           this.Tabla.setValueAt(tipoAbast, Numero_fila, 8);
                           this.bandera = false;
                        }
                     }
                  }
               } else {
                  this.en.ShowMessage("Debe Escoger un Establecimiento.", "Información", "Information");
               }
            } else {
               this.en.ShowMessage("Debe Escoger una Localidad.", "Información", "Information");
            }
         } else {
            this.en.ShowMessage("Debe Escoger una Tarjeta.", "Información", "Information");
         }
      }

   }

   private void ImgEliminarMouseEntered(MouseEvent evt) {
      this.ImgEliminar.setVisible(false);
      this.ImgEliminar1.setVisible(true);
      this.bandera = true;
   }

   private void ImgEliminar1MouseExited(MouseEvent evt) {
      this.ImgEliminar1.setVisible(false);
      this.ImgEliminar.setVisible(true);
   }

   private void ImgEliminar1MouseClicked(MouseEvent evt) {
      if (this.bandera) {
         int Numero_fila = this.Tabla.getSelectedRow();
         int cantFilas = this.Tabla.getRowCount();
         if (cantFilas == 0) {
            this.en.ShowMessage("No hay Elementos Insertados en la Tabla.", "Error", "Error");
         } else if (Numero_fila == -1) {
            this.en.ShowMessage("Debe Seleccionar una Fila de la Tabla.", "Error", "Error");
         } else if (!this.Tabla.getColumnSelectionAllowed() && this.Tabla.getRowSelectionAllowed()) {
            DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();
            model.removeRow(Numero_fila);
            this.bandera = false;
         }
      }

   }

   private void ActualizarLocMouseEntered(MouseEvent evt) {
      this.ActualizarLoc1.setVisible(true);
      this.ActualizarLoc.setVisible(false);
   }

   private void ActualizarLoc1MouseExited(MouseEvent evt) {
      this.ActualizarLoc.setVisible(true);
      this.ActualizarLoc1.setVisible(false);
   }

   private void ActualizarLoc1MouseClicked(MouseEvent evt) {
      try {
         this.Post_Localidad();
      } catch (SAXException var3) {
         Logger.getLogger(Abastecimiento.class.getName()).log(Level.SEVERE, (String)null, var3);
      } catch (IOException var4) {
         Logger.getLogger(Abastecimiento.class.getName()).log(Level.SEVERE, (String)null, var4);
      }

   }

   private void ActualizarEstabMouseEntered(MouseEvent evt) {
      this.ActualizarEstab.setVisible(false);
      this.ActualizarEstab1.setVisible(true);
   }

   private void ActualizarEstab1MouseExited(MouseEvent evt) {
      this.ActualizarEstab1.setVisible(false);
      this.ActualizarEstab.setVisible(true);
   }

   private void ActualizarEstab1MouseClicked(MouseEvent evt) {
      this.Post_Establecimiento();
   }

   private void ActualizarTarj1MouseExited(MouseEvent evt) {
      this.ActualizarTarj1.setVisible(false);
      this.ActualizarTarj.setVisible(true);
   }

   private void ActualizarTarj1MouseClicked(MouseEvent evt) {
      try {
         this.Post_Tarjeta();
      } catch (SAXException var3) {
         Logger.getLogger(Abastecimiento.class.getName()).log(Level.SEVERE, (String)null, var3);
      } catch (IOException var4) {
         Logger.getLogger(Abastecimiento.class.getName()).log(Level.SEVERE, (String)null, var4);
      }

   }

   private void ActualizarTarjMouseEntered(MouseEvent evt) {
      this.ActualizarTarj.setVisible(false);
      this.ActualizarTarj1.setVisible(true);
   }

   private void CantAbastecidaKeyTyped(KeyEvent evt) {
      char c = evt.getKeyChar();
      if ((c < '0' || c > '9') && c != '\b' && c != '.') {
         evt.consume();
      }

      if (c == '.' && (this.CantAbastecida.getText().contains(".") || this.CantAbastecida.getText().isEmpty())) {
         evt.consume();
      }

      if (this.CantAbastecida.getText().contains(".") && this.CantAbastecida.getText().length() - 2 > this.CantAbastecida.getText().indexOf(".")) {
         evt.consume();
      }

   }

   private void LocalidadActionPerformed(ActionEvent evt) {
   }

   private void TablaMouseClicked(MouseEvent evt) {
      if (!this.Tabla.getColumnSelectionAllowed() && this.Tabla.getRowSelectionAllowed()) {
         int Numero_fila = this.Tabla.getSelectedRow();
         this.NoTarjet.setSelectedItem(this.Tabla.getValueAt(Numero_fila, 1).toString());
         this.NoComprobante.setText(this.Tabla.getValueAt(Numero_fila, 2).toString());
         this.Saldo_Inic.setText(this.Tabla.getValueAt(Numero_fila, 3).toString());
         this.CantAbastecida.setText(this.Tabla.getValueAt(Numero_fila, 4).toString());
         this.Saldo_Final.setText(this.Tabla.getValueAt(Numero_fila, 5).toString());
         this.Localidad.setSelectedItem(this.Tabla.getValueAt(Numero_fila, 6).toString());
         this.Establecimiento.setSelectedItem(this.Tabla.getValueAt(Numero_fila, 7).toString());
         String tipoAbast = this.Tabla.getValueAt(Numero_fila, 8).toString();
         if (tipoAbast.equalsIgnoreCase("Desplazamiento")) {
            this.Desplazamiento.setSelected(true);
            this.Tecnologico.setSelected(false);
         } else {
            this.Desplazamiento.setSelected(false);
            this.Tecnologico.setSelected(true);
         }

         String fechahora = this.Tabla.getValueAt(Numero_fila, 0).toString();
         String hora = fechahora.substring(9, 14);
         int dia_inicial = Integer.parseInt(fechahora.substring(0, 2));
         int mes_inicial = Integer.parseInt(fechahora.substring(3, 5)) - 1;
         int anno_inicial = Integer.parseInt(fechahora.substring(6, 8)) + 100;
         Date date = new Date(anno_inicial, mes_inicial, dia_inicial);
         this.Fecha.setDate(date);
         this.Hora.setText(hora);
      }

   }

   private void LocalidadItemStateChanged(ItemEvent evt) {
      if (this.Localidad.getSelectedItem() != "") {
         this.id_prov = this.Obtener_Id_Prov(this.Localidad.getSelectedItem().toString());
         this.Llenar_Combo_Establecimientos();
         this.setEditorEstablecimiento(new BasicComboBoxEditor());
         this.Establecimiento.setEnabled(true);
      }

   }

   private void NoComprobanteKeyTyped(KeyEvent evt) {
      char c = evt.getKeyChar();
      if ((c < '0' || c > '9') && c != '\b') {
         evt.consume();
      }

      if (this.NoComprobante.getText().length() >= 10) {
         evt.consume();
      }

   }

   private void TipoDocumentoItemStateChanged(ItemEvent evt) {
   }

   private void TipoDocumentoActionPerformed(ActionEvent evt) {
   }

   private void ActualizarTipoDocMouseEntered(MouseEvent evt) {
   }

   private void ActualizarTipoDoc1MouseClicked(MouseEvent evt) {
   }

   private void ActualizarTipoDoc1MouseExited(MouseEvent evt) {
   }

   private void ImgAdicionarMouseExited(MouseEvent evt) {
   }

   private void HoraFocusLost(FocusEvent evt) {
      String pega = this.Hora.getText();
      pega = pega.trim();
      if (pega.equals(":")) {
         JOptionPane.showMessageDialog((Component)null, "Digite la hora", "Operador", 0);
         this.Hora.setValue("");
      } else {
         int conta_pega = pega.length();
         if (conta_pega < 5) {
            JOptionPane.showMessageDialog((Component)null, "Digite la hora", "Operador", 0);
            this.Hora.setValue("");
         } else {
            String hora = pega.substring(0, 2);
            String minuto = pega.substring(3, 5);
            int conta_hora = Integer.parseInt(hora);
            int conta_minuto = Integer.parseInt(minuto);
            if (conta_hora > 23) {
               JOptionPane.showMessageDialog((Component)null, "Hora digitada inválida", "Operador", 0);
               this.Hora.setValue("");
            } else {
               if (conta_minuto > 59) {
                  JOptionPane.showMessageDialog((Component)null, "Hora digitada inválida", "Operador", 0);
                  this.Hora.setValue("");
               }

            }
         }
      }
   }

   private void DesplazamientoActionPerformed(ActionEvent evt) {
      this.Desplazamiento.setSelected(true);
      this.Tecnologico.setSelected(false);
   }

   private void TecnologicoActionPerformed(ActionEvent evt) {
      this.Desplazamiento.setSelected(false);
      this.Tecnologico.setSelected(true);
   }

   private void NoTarjetActionPerformed(ActionEvent evt) {
   }

   private void Saldo_InicKeyTyped(KeyEvent evt) {
      char c = evt.getKeyChar();
      if ((c < '0' || c > '9') && c != '\b' && c != '.') {
         evt.consume();
      }

      if (c == '.' && (this.Saldo_Inic.getText().contains(".") || this.Saldo_Inic.getText().isEmpty())) {
         evt.consume();
      }

      if (this.Saldo_Inic.getText().contains(".") && this.Saldo_Inic.getText().length() - 2 > this.Saldo_Inic.getText().indexOf(".")) {
         evt.consume();
      }

   }

   private void Saldo_FinalKeyTyped(KeyEvent evt) {
      char c = evt.getKeyChar();
      if ((c < '0' || c > '9') && c != '\b' && c != '.') {
         evt.consume();
      }

      if (c == '.' && (this.Saldo_Final.getText().contains(".") || this.Saldo_Final.getText().isEmpty())) {
         evt.consume();
      }

      if (this.Saldo_Final.getText().contains(".") && this.Saldo_Final.getText().length() - 2 > this.Saldo_Final.getText().indexOf(".")) {
         evt.consume();
      }

   }

   public void Llenar_Combo_Localidad() throws SAXException, IOException {
      try {
         IdLocalidad = "";
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "Tipo_Localidad.xml");
         InputSource Tipo_Localidad = new InputSource(new StringReader(respuesta));
         parser.parse(Tipo_Localidad);
         Document doc = parser.getDocument();
         NodeList Lista_Documentos = doc.getElementsByTagName("ROW");
         int cant_doc = Lista_Documentos.getLength();
         this.Localidad.removeAllItems();

         for(int i = 0; i < cant_doc; ++i) {
            String Id = Lista_Documentos.item(i).getAttributes().getNamedItem("ID").getNodeValue();
            String Provincia = Lista_Documentos.item(i).getAttributes().getNamedItem("Nombre").getNodeValue();
            if (Id.equalsIgnoreCase("")) {
               Id = "No";
            }

            if (i == 0) {
               this.Localidad.addItem("");
               IdLocalidad = IdLocalidad + Id + "-" + Provincia;
            } else {
               IdLocalidad = IdLocalidad + "," + Id + "-" + Provincia;
            }

            this.Localidad.addItem(Provincia);
         }
      } catch (Exception var10) {
         if (!this.en.Tiene_Conexion) {
            return;
         }

         this.Post_Localidad();
      }

   }

   public void Llenar_Combo_Tarjeta() throws SAXException, IOException {
      try {
         IdTarjeta = "";
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "Tipo_Tarjeta.xml");
         InputSource Tipo_Tarjeta = new InputSource(new StringReader(respuesta));
         parser.parse(Tipo_Tarjeta);
         Document doc = parser.getDocument();
         NodeList Lista_Tarjeta = doc.getElementsByTagName("ROW");
         int cant_doc = Lista_Tarjeta.getLength();
         this.NoTarjet.removeAllItems();

         for(int i = 0; i < cant_doc; ++i) {
            String Id = Lista_Tarjeta.item(i).getAttributes().getNamedItem("ID").getNodeValue();
            String Nro = Lista_Tarjeta.item(i).getAttributes().getNamedItem("Nro").getNodeValue();
            if (Id.equalsIgnoreCase("")) {
               Id = "No";
            }

            if (i == 0) {
               this.NoTarjet.addItem("");
               IdTarjeta = IdTarjeta + Id + " " + Nro;
            } else {
               IdTarjeta = IdTarjeta + "," + Id + " " + Nro;
            }

            this.NoTarjet.addItem(Nro);
         }
      } catch (Exception var10) {
         if (!this.en.Tiene_Conexion) {
            return;
         }

         this.Post_Tarjeta();
      }

   }

   public void Mostrar() throws SAXException, IOException {
      try {
         this.dhr.abastec_activo = true;
         int size = this.dhr.listado_chip.size();
         if (size > 0) {
            DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();
            String[] partes = null;

            for(int i = 0; i < size; ++i) {
               ChipCombustible chip = (ChipCombustible)this.dhr.listado_chip.get(i);
               this.NoTarjet.setSelectedItem(String.valueOf(this.dhr.tarjeta));
               model.insertRow(model.getRowCount(), new Object[]{chip.getFecha(), chip.getNumero_tarjeta(), chip.getNoComprobante(), chip.getSaldoInicial(), chip.getCantAbastecida(), chip.getSaldoFinal(), chip.getLocalidad(), chip.getEstablecimiento(), chip.getTipoAbastecimiento()});
            }
         }

         if (!this.en.cambio_de_fecha) {
            this.Llenar_Combo_Tarjeta();
            this.Llenar_Combo_Localidad();
         } else if (this.en.cambio_de_fecha && this.dhr.en.Tiene_Conexion) {
            this.Post_Tarjeta();
            this.Post_Localidad();
            this.Llenar_Combo_Establecimientos();
         }

         this.setLocationRelativeTo(this.dhr);
         this.setVisible(true);
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   public String Obtener_ID_Loc(String Provincia) {
      String[] partes = IdLocalidad.split(",");
      String id = "";

      for(int i = 0; i < partes.length; ++i) {
         if (partes[i].contains(Provincia)) {
            String[] idd = partes[i].split("-");
            id = idd[0];
            break;
         }
      }

      return id;
   }

   public String Obtener_ID_Tarjeta(String Tarjeta) {
      String[] partes = IdTarjeta.split(",");
      String id = "";

      for(int i = 0; i < partes.length; ++i) {
         if (partes[i].contains(Tarjeta)) {
            String[] idd = partes[i].split(" ");
            id = idd[0];
         }
      }

      return id;
   }

   public String Obtener_ID_Establecimiento(String Establecimiento, String id_prov) {
      String[] partes = IdEstablecimiento.split("\\*");
      String id = "";

      for(int i = 0; i < partes.length; ++i) {
         String[] idd = partes[i].split("\\;");
         if (idd[1].equalsIgnoreCase(Establecimiento) && idd[2].equalsIgnoreCase(id_prov)) {
            id = idd[0];
         }
      }

      return id;
   }

   public Point Obtener_Geom_Establecimiento(String Establecimiento, String id_prov) throws com.vividsolutions.jts.io.ParseException {
      String[] partes = IdEstablecimiento.split("\\*");
      String geom = "";
      Point point = null;

      for(int i = 0; i < partes.length; ++i) {
         String[] idd = partes[i].split("\\;");
         if (idd[1].equalsIgnoreCase(Establecimiento) && idd[2].equalsIgnoreCase(id_prov)) {
            geom = idd[3];
            point = this.en.CrearPoint(geom);
         }
      }

      return point;
   }

   public void Llenar_Combo_Establecimientos() {
      try {
         IdEstablecimiento = "";
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "Establecimientos_CUPET.xml");
         InputSource Establ = new InputSource(new StringReader(respuesta));
         parser.parse(Establ);
         Document doc = parser.getDocument();
         NodeList Lista_Establecimientos = doc.getElementsByTagName("ROW");
         int cant_est = Lista_Establecimientos.getLength();
         this.Establecimiento.removeAllItems();

         for(int i = 0; i < cant_est; ++i) {
            String Id = Lista_Establecimientos.item(i).getAttributes().getNamedItem("ID").getNodeValue();
            String Nombre = Lista_Establecimientos.item(i).getAttributes().getNamedItem("Nombre").getNodeValue();
            String Provincia = Lista_Establecimientos.item(i).getAttributes().getNamedItem("Provincia").getNodeValue();
            String Y = Lista_Establecimientos.item(i).getAttributes().getNamedItem("Y").getNodeValue();
            String X = Lista_Establecimientos.item(i).getAttributes().getNamedItem("X").getNodeValue();
            Point point = this.en.shape.geometryFactory.createPoint(new Coordinate(Double.valueOf(X), Double.valueOf(Y)));
            if (i == 0) {
               IdEstablecimiento = IdEstablecimiento + Id + ";" + Nombre + ";" + Provincia + ";" + point;
               this.Establecimiento.addItem("");
            } else {
               IdEstablecimiento = IdEstablecimiento + "*" + Id + ";" + Nombre + ";" + Provincia + ";" + point;
            }

            if (this.id_prov.equalsIgnoreCase(Provincia)) {
               this.Establecimiento.addItem(Nombre);
            }
         }
      } catch (Exception var14) {
         if (!this.en.Tiene_Conexion) {
            return;
         }

         this.Post_Establecimiento();
      }

   }

   private void Post_Establecimiento() {
      String sitio = this.en.GetSitio();
      String port = null;
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/ListadoEstablecimientos?version=" + this.en.version;
      URL url;
      String line;
      if (this.en.Hay_Proxy) {
         try {
            String ip = this.en.DireccionProxy;
            port = this.en.PuertoProxy;
            String usuariop = this.en.UsuarioProxy;
            String passp = this.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(port), sitio);
            conn = url.openConnection();
            String user_pass = usuariop + ":" + passp;
            line = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + line);
         } catch (Exception var14) {
            line = "Es Posible que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
            return;
         }
      } else {
         try {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         } catch (Exception var13) {
            line = "Es Posible que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
            return;
         }
      }

      this.en.Tiene_Conexion = true;

      try {
         conn.setReadTimeout(30000);
         BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            File f = new File("Establecimientos_CUPET.xml");
            if (f.exists() && !f.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(f.getAbsolutePath());
            }

            this.en.Encrypt(this.en.encript, "Establecimientos_CUPET.xml", respuesta);
            this.Llenar_Combo_Establecimientos();
         }

      } catch (SocketTimeoutException var15) {
         line = "La Conexión está Tardando más de lo Normal.<br/>Se Cargará la Lista Local de Establecimientos.";
         this.en.ShowMessage(line, "Información", "Information");
         this.en.Tiene_Conexion = false;
      } catch (UnknownHostException var16) {
         this.en.ShowMessage("Usted no Tiene Conexión en este momento.", "Información", "Information");
         this.en.Tiene_Conexion = false;
      } catch (IOException var17) {
         this.en.ShowMessage("Se Produjo un Error Descargando el Listado de Establecimientos.", "Información", "Information");
         this.en.Tiene_Conexion = false;
      }
   }

   private String Obtener_Id_Prov(String provincia) {
      String[] id_provincia = IdLocalidad.split(",");

      for(int i = 0; i < id_provincia.length; ++i) {
         String prov = id_provincia[i].split("-")[1];
         String id = id_provincia[i].split("-")[0];
         if (prov.equalsIgnoreCase(provincia)) {
            return id_provincia[i].split("-")[0];
         }
      }

      return "";
   }

   public void setSelectedIndex(int index) {
      this.NoTarjet.setSelectedIndex(index);
      this.inputFieldTarj.setText(this.NoTarjet.getItemAt(index).toString());
      this.inputFieldTarj.setSelectionEnd(this.caretPosTarj + this.inputFieldTarj.getText().length());
      this.inputFieldTarj.moveCaretPosition(this.caretPosTarj);
   }

   public final void setEditorTarjeta(ComboBoxEditor editor) {
      this.NoTarjet.setEditor(editor);
      if (editor.getEditorComponent() instanceof JTextField) {
         this.inputFieldTarj = (JTextField)editor.getEditorComponent();
         this.inputFieldTarj.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
               super.keyTyped(e);
               char key = e.getKeyChar();
               if ((key < '0' || key > '9') && key != '\b') {
                  e.consume();
               }

            }

            public void keyReleased(KeyEvent ev) {
               char key = ev.getKeyChar();
               if (Character.isLetterOrDigit(key) || Character.isSpaceChar(key)) {
                  Abastecimiento.this.NoTarjet.showPopup();
                  Abastecimiento.this.caretPosTarj = Abastecimiento.this.inputFieldTarj.getCaretPosition();
                  String text = "";

                  try {
                     text = Abastecimiento.this.inputFieldTarj.getText(0, Abastecimiento.this.caretPosTarj);
                  } catch (BadLocationException var6) {
                     var6.printStackTrace();
                  }

                  for(int i = 0; i < Abastecimiento.this.NoTarjet.getItemCount(); ++i) {
                     String element = (String)Abastecimiento.this.NoTarjet.getItemAt(i);
                     if (element.startsWith(text)) {
                        Abastecimiento.this.setSelectedIndex(i);
                        return;
                     }
                  }

               }
            }
         });
      }

   }

   public void setSelectedIndex1(int index) {
      this.Establecimiento.setSelectedIndex(index);
      this.inputFieldEst.setText(this.Establecimiento.getItemAt(index).toString());
      this.inputFieldEst.setSelectionEnd(this.caretPosEst + this.inputFieldEst.getText().length());
      this.inputFieldEst.moveCaretPosition(this.caretPosEst);
   }

   public void setEditorEstablecimiento(ComboBoxEditor editor) {
      this.Establecimiento.setEditor(editor);
      if (editor.getEditorComponent() instanceof JTextField) {
         this.inputFieldEst = (JTextField)editor.getEditorComponent();
         this.inputFieldEst.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
               super.keyTyped(e);
            }

            public void keyReleased(KeyEvent ev) {
               char key = ev.getKeyChar();
               if (Character.isLetterOrDigit(key) || Character.isSpaceChar(key)) {
                  Abastecimiento.this.Establecimiento.showPopup();
                  Abastecimiento.this.caretPosEst = Abastecimiento.this.inputFieldEst.getCaretPosition();
                  String text = "";

                  try {
                     text = Abastecimiento.this.inputFieldEst.getText(0, Abastecimiento.this.caretPosEst);
                  } catch (BadLocationException var6) {
                     var6.printStackTrace();
                  }

                  for(int i = 0; i < Abastecimiento.this.Establecimiento.getItemCount(); ++i) {
                     String element = (String)Abastecimiento.this.Establecimiento.getItemAt(i);
                     if (element.startsWith(text)) {
                        Abastecimiento.this.setSelectedIndex1(i);
                        return;
                     }
                  }

               }
            }
         });
      }

   }
}
