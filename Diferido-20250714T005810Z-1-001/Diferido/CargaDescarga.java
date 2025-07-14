package Diferido;

import java.awt.Color;
import java.awt.Font;
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
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import org.apache.xerces.parsers.DOMParser;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sun.misc.BASE64Encoder;

public class CargaDescarga extends JFrame {
   Datos_Hoja_de_Ruta dhr;
   Entrada en;
   JTextField inputFieldCarga = null;
   public int caretPosCarga = 0;
   boolean bandera = false;
   private JLabel ActMerc;
   private JLabel ActMerc1;
   private JLabel ActUm;
   private JLabel ActUm1;
   private JLabel ActualizarDoc;
   private JLabel ActualizarDoc1;
   public JTextField Cant;
   private JComboBox Carga;
   private JComboBox Doc;
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
   public JTextField No;
   public JTable Tabla;
   private JComboBox UMedida;
   private JLabel User;
   private JLabel User1;
   private JLabel User2;
   private JLabel User3;
   private JLabel User4;
   private JLabel User5;
   public JTextField Viajes;
   private JLabel jLabel7;
   private JPanel jPanel1;
   private JScrollPane jScrollPane1;
   static String IdDocumento = "";
   static String IdMercancia = "";
   static String IdUM = "";

   public CargaDescarga(Datos_Hoja_de_Ruta dhr, Entrada en) throws MalformedURLException {
      this.initComponents();
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
      this.ActualizarDoc1.setVisible(false);
      this.ActualizarDoc.setVisible(true);
      this.ActMerc1.setVisible(false);
      this.ActMerc.setVisible(true);
      this.ActUm.setVisible(true);
      this.ActUm1.setVisible(false);
      this.User4.setVisible(false);
      this.UMedida.setVisible(false);
      this.ActUm.setVisible(false);
      this.ActUm1.setVisible(false);
      DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
      tcr.setHorizontalAlignment(0);
      this.Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(4).setCellRenderer(tcr);
      this.Tabla.getColumnModel().getColumn(4).setMaxWidth(0);
      this.Tabla.getColumnModel().getColumn(4).setMinWidth(0);
      this.Tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.jScrollPane1 = new JScrollPane();
      this.Tabla = new JTable();
      this.ImgAceptar = new JLabel();
      this.Viajes = new JTextField();
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
      this.Doc = new JComboBox();
      this.No = new JTextField();
      this.ActualizarDoc = new JLabel();
      this.ActualizarDoc1 = new JLabel();
      this.User2 = new JLabel();
      this.User3 = new JLabel();
      this.Carga = new JComboBox();
      this.ActMerc = new JLabel();
      this.ActMerc1 = new JLabel();
      this.Cant = new JTextField();
      this.UMedida = new JComboBox();
      this.User4 = new JLabel();
      this.ActUm = new JLabel();
      this.ActUm1 = new JLabel();
      this.User5 = new JLabel();
      this.jLabel7 = new JLabel();
      this.setDefaultCloseOperation(0);
      this.setTitle("Datos Generales de la Carga");
      this.setResizable(false);
      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent evt) {
            CargaDescarga.this.formWindowClosing(evt);
         }
      });
      this.jPanel1.setBackground(new Color(201, 231, 221));
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.Tabla.setModel(new DefaultTableModel(new Object[0][], new String[]{"Documento", "Número", "Mercancía", "Cantidad", "U/M"}) {
         Class[] types = new Class[]{String.class, String.class, String.class, String.class, String.class};
         boolean[] canEdit = new boolean[]{false, false, false, true, true};

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
            CargaDescarga.this.TablaMouseClicked(evt);
         }
      });
      this.jScrollPane1.setViewportView(this.Tabla);
      if (this.Tabla.getColumnModel().getColumnCount() > 0) {
         this.Tabla.getColumnModel().getColumn(0).setResizable(false);
         this.Tabla.getColumnModel().getColumn(0).setPreferredWidth(35);
         this.Tabla.getColumnModel().getColumn(1).setResizable(false);
         this.Tabla.getColumnModel().getColumn(1).setPreferredWidth(15);
         this.Tabla.getColumnModel().getColumn(2).setResizable(false);
         this.Tabla.getColumnModel().getColumn(2).setPreferredWidth(300);
         this.Tabla.getColumnModel().getColumn(3).setResizable(false);
         this.Tabla.getColumnModel().getColumn(3).setPreferredWidth(20);
         this.Tabla.getColumnModel().getColumn(4).setResizable(false);
         this.Tabla.getColumnModel().getColumn(4).setPreferredWidth(20);
      }

      this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(20, 220, 620, 100));
      this.ImgAceptar.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar.png")));
      this.ImgAceptar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            CargaDescarga.this.ImgAceptarMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImgAceptar, new AbsoluteConstraints(230, 340, 96, 32));
      this.Viajes.setBorder(BorderFactory.createBevelBorder(1));
      this.Viajes.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent evt) {
            CargaDescarga.this.ViajesKeyTyped(evt);
         }
      });
      this.jPanel1.add(this.Viajes, new AbsoluteConstraints(120, 155, 60, -1));
      this.ImgAceptar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar on.png")));
      this.ImgAceptar1.setText("jLabel8");
      this.ImgAceptar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            CargaDescarga.this.ImgAceptar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            CargaDescarga.this.ImgAceptar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgAceptar1, new AbsoluteConstraints(230, 340, 96, 32));
      this.ImgCancelar.setIcon(new ImageIcon(this.getClass().getResource("/Images/cancelar.png")));
      this.ImgCancelar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            CargaDescarga.this.ImgCancelarMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImgCancelar, new AbsoluteConstraints(350, 340, 96, 32));
      this.ImgCancelar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/cancelar on.png")));
      this.ImgCancelar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            CargaDescarga.this.ImgCancelar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            CargaDescarga.this.ImgCancelar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgCancelar1, new AbsoluteConstraints(350, 340, 96, 32));
      this.ImgAdicionar.setIcon(new ImageIcon(this.getClass().getResource("/Images/adicionar.png")));
      this.ImgAdicionar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            CargaDescarga.this.ImgAdicionarMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImgAdicionar, new AbsoluteConstraints(200, 150, 96, 32));
      this.ImgAdicionar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/adicionar on.png")));
      this.ImgAdicionar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            CargaDescarga.this.ImgAdicionar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            CargaDescarga.this.ImgAdicionar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgAdicionar1, new AbsoluteConstraints(200, 150, 96, 32));
      this.ImgAct.setIcon(new ImageIcon(this.getClass().getResource("/Images/actualizar.png")));
      this.ImgAct.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            CargaDescarga.this.ImgActMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImgAct, new AbsoluteConstraints(310, 150, 96, 32));
      this.ImgAct1.setIcon(new ImageIcon(this.getClass().getResource("/Images/actualizar on.png")));
      this.ImgAct1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            CargaDescarga.this.ImgAct1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            CargaDescarga.this.ImgAct1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgAct1, new AbsoluteConstraints(310, 150, 96, 32));
      this.ImgEliminar.setIcon(new ImageIcon(this.getClass().getResource("/Images/eliminar.png")));
      this.ImgEliminar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            CargaDescarga.this.ImgEliminarMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImgEliminar, new AbsoluteConstraints(420, 150, 96, 32));
      this.ImgEliminar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/eliminar on.png")));
      this.ImgEliminar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            CargaDescarga.this.ImgEliminar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            CargaDescarga.this.ImgEliminar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgEliminar1, new AbsoluteConstraints(420, 150, 96, 32));
      this.User.setFont(new Font("Tahoma", 0, 12));
      this.User.setForeground(new Color(0, 0, 102));
      this.User.setText("Cantidad:");
      this.jPanel1.add(this.User, new AbsoluteConstraints(295, 85, -1, -1));
      this.User1.setFont(new Font("Tahoma", 0, 12));
      this.User1.setForeground(new Color(0, 0, 102));
      this.User1.setText("Documento:");
      this.jPanel1.add(this.User1, new AbsoluteConstraints(40, 50, -1, -1));
      this.Doc.setBorder(BorderFactory.createBevelBorder(0));
      this.jPanel1.add(this.Doc, new AbsoluteConstraints(120, 40, 100, 25));
      this.No.setBorder(BorderFactory.createBevelBorder(1));
      this.No.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent evt) {
            CargaDescarga.this.NoKeyTyped(evt);
         }
      });
      this.jPanel1.add(this.No, new AbsoluteConstraints(120, 80, 100, -1));
      this.ActualizarDoc.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh.png")));
      this.ActualizarDoc.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            CargaDescarga.this.ActualizarDocMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ActualizarDoc, new AbsoluteConstraints(235, 45, 20, 20));
      this.ActualizarDoc1.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh on1.png")));
      this.ActualizarDoc1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            CargaDescarga.this.ActualizarDoc1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            CargaDescarga.this.ActualizarDoc1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ActualizarDoc1, new AbsoluteConstraints(225, 35, -1, -1));
      this.User2.setFont(new Font("Tahoma", 0, 12));
      this.User2.setForeground(new Color(0, 0, 102));
      this.User2.setText("Número:");
      this.jPanel1.add(this.User2, new AbsoluteConstraints(60, 85, -1, -1));
      this.User3.setFont(new Font("Tahoma", 0, 12));
      this.User3.setForeground(new Color(0, 0, 102));
      this.User3.setText("Mercancía:");
      this.jPanel1.add(this.User3, new AbsoluteConstraints(290, 50, -1, -1));
      this.Carga.setBorder(BorderFactory.createBevelBorder(0));
      this.jPanel1.add(this.Carga, new AbsoluteConstraints(360, 40, 230, 25));
      this.ActMerc.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh.png")));
      this.ActMerc.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            CargaDescarga.this.ActMercMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ActMerc, new AbsoluteConstraints(605, 45, 20, 20));
      this.ActMerc1.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh on1.png")));
      this.ActMerc1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            CargaDescarga.this.ActMerc1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            CargaDescarga.this.ActMerc1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ActMerc1, new AbsoluteConstraints(595, 35, -1, -1));
      this.Cant.setBorder(BorderFactory.createBevelBorder(1));
      this.Cant.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent evt) {
            CargaDescarga.this.CantKeyTyped(evt);
         }
      });
      this.jPanel1.add(this.Cant, new AbsoluteConstraints(360, 80, 90, -1));
      this.UMedida.setBorder(BorderFactory.createBevelBorder(0));
      this.jPanel1.add(this.UMedida, new AbsoluteConstraints(510, 75, 80, 25));
      this.User4.setFont(new Font("Tahoma", 0, 12));
      this.User4.setForeground(new Color(0, 0, 102));
      this.User4.setText("U/M:");
      this.jPanel1.add(this.User4, new AbsoluteConstraints(475, 85, -1, -1));
      this.ActUm.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh.png")));
      this.ActUm.setText("jLabel8");
      this.ActUm.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            CargaDescarga.this.ActUmMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ActUm, new AbsoluteConstraints(605, 80, 20, 20));
      this.ActUm1.setIcon(new ImageIcon(this.getClass().getResource("/Images/refresh on1.png")));
      this.ActUm1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            CargaDescarga.this.ActUm1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            CargaDescarga.this.ActUm1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ActUm1, new AbsoluteConstraints(595, 70, 40, 40));
      this.User5.setFont(new Font("Tahoma", 0, 12));
      this.User5.setForeground(new Color(0, 0, 102));
      this.User5.setText("No. Viajes:");
      this.jPanel1.add(this.User5, new AbsoluteConstraints(50, 160, -1, -1));
      this.jLabel7.setIcon(new ImageIcon(this.getClass().getResource("/Images/fondo datos carga1.png")));
      this.jPanel1.add(this.jLabel7, new AbsoluteConstraints(0, 0, 661, 406));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, 406, -2).addGap(0, 0, 32767)));
      this.pack();
   }

   private void TablaMouseClicked(MouseEvent evt) {
      if (!this.Tabla.getColumnSelectionAllowed() && this.Tabla.getRowSelectionAllowed()) {
         int Numero_fila = this.Tabla.getSelectedRow();
         this.Doc.setSelectedItem(this.Tabla.getValueAt(Numero_fila, 0).toString());
         this.No.setText(this.Tabla.getValueAt(Numero_fila, 1).toString());
         this.Carga.setSelectedItem(this.Tabla.getValueAt(Numero_fila, 2).toString());
         this.Cant.setText(this.Tabla.getValueAt(Numero_fila, 3).toString());
      }

   }

   public void Post_Documento() throws SAXException, IOException {
      String user = this.en.user;
      String password = this.en.pass;
      String sitio = this.en.GetSitio();
      String port = null;
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/DocumType";
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
            String encoding = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + encoding);
         } catch (Exception var18) {
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
         } catch (Exception var17) {
            line = "Es Posible que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
            return;
         }
      }

      try {
         BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         this.en.Tiene_Conexion = true;
         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            File doc = new File("Tipo_Documento.xml");
            if (doc.exists() && !doc.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(doc.getAbsolutePath());
            }

            this.en.Encrypt(this.en.encript, "Tipo_Documento.xml", respuesta);
            this.Llenar_Combo_Documento();
         } else {
            this.en.ShowMessage("Nombre de Usuario y Contraseña no Válidos.", "Información", "Information");
         }
      } catch (UnknownHostException var19) {
         line = "Usted no Tiene Conexión en este Momento.";
         this.en.ShowMessage(line, "Información", "Information");
         this.Llenar_Combo_Documento();
      } catch (Exception var20) {
         line = "Se Produjo un Error Tratando de Descargar la Lista de Documentos.";
         this.en.ShowMessage(line, "Información", "Information");
      }
   }

   public void Post_Mercancia() throws SAXException, IOException {
      String user = this.en.user;
      String password = this.en.pass;
      String sitio = this.en.GetSitio();
      String port = null;
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/GoodsType?grupo=" + this.en.Grupo;
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
            String encoding = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + encoding);
         } catch (Exception var18) {
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
         } catch (Exception var17) {
            line = "Es Posible que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
            return;
         }
      }

      try {
         BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         this.en.Tiene_Conexion = true;
         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            File merc = new File("Tipo_Mercancia.xml");
            if (merc.exists() && !merc.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(merc.getAbsolutePath());
            }

            this.en.Encrypt(this.en.encript, "Tipo_Mercancia.xml", respuesta);
            this.Llenar_Combo_Mercancia();
         } else {
            this.en.ShowMessage("Se Produjo un Error Tratando de Descargar la Lista de Mercancías.", "Información", "Information");
         }
      } catch (UnknownHostException var19) {
         line = "Usted no Tiene Conexión en este Momento.";
         this.en.ShowMessage(line, "Información", "Information");
         this.Llenar_Combo_Mercancia();
      } catch (Exception var20) {
         line = "Se Produjo un Error Tratando de Descargar la Lista de Mercancías.";
         this.en.ShowMessage(line, "Información", "Information");
      }
   }

   public void Post_UM() throws SAXException, IOException {
      String user = this.en.user;
      String password = this.en.pass;
      String sitio = this.en.GetSitio();
      String port = null;
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/UnitType";
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
            String encoding = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + encoding);
         } catch (Exception var18) {
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
         } catch (Exception var17) {
            line = "Es Posible que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
            return;
         }
      }

      try {
         BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         this.en.Tiene_Conexion = true;
         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            File um = new File("Tipo_UM.xml");
            if (um.exists() && !um.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(um.getAbsolutePath());
            }

            this.en.Encrypt(this.en.encript, "Tipo_UM.xml", respuesta);
            this.Llenar_Combo_UM();
         } else {
            this.en.ShowMessage("Se Produjo un Error Tratando de Descargar la Lista de Unidades de Medida.", "Información", "Information");
         }
      } catch (UnknownHostException var19) {
         line = "Usted no Tiene Conexión en este Momento.";
         this.en.ShowMessage(line, "Información", "Information");
         this.Llenar_Combo_UM();
         this.en.Tiene_Conexion = false;
      } catch (Exception var20) {
         line = "Se Produjo un Error Tratando de Descargar la Lista de Unidades de Medida.";
         this.en.ShowMessage(line, "Información", "Information");
      }
   }

   private void formWindowClosing(WindowEvent evt) {
      this.setVisible(false);
      this.dhr.CD_activo = false;
      if (this.Tabla.getRowCount() == 0) {
         this.dhr.trafico.setSelected(false);
      } else {
         this.dhr.trafico.setSelected(true);
      }

      this.dhr.setVisible(true);
   }

   private void ImgAceptar1MouseClicked(MouseEvent evt) {
      int cant = this.Tabla.getRowCount();
      if (cant > 0) {
         String consulta = "";
         String fila = "";
         this.dhr.ListaCD.clear();
         this.dhr.Insertar_ListaCD.clear();
         this.dhr.listado_prod.clear();
         this.dhr.viajes = Integer.valueOf(this.Viajes.getText());

         for(int i = 0; i < cant; ++i) {
            String id_doc = this.Obtener_ID_Doc(this.Tabla.getValueAt(i, 0).toString());
            String Num_doc = this.Tabla.getValueAt(i, 1).toString();
            String id_merc = this.Obtener_ID_Merc(this.Tabla.getValueAt(i, 2).toString());
            String cant_m = this.Tabla.getValueAt(i, 3).toString();
            String cd_insert = id_doc + "," + Num_doc + "," + id_merc + "," + cant_m;
            this.dhr.Insertar_ListaCD.add(cd_insert);
            Productos p = new Productos(this.Tabla.getValueAt(i, 0).toString(), this.Tabla.getValueAt(i, 1).toString(), this.Tabla.getValueAt(i, 2).toString(), this.Tabla.getValueAt(i, 3).toString());
            this.dhr.listado_prod.add(p);
            String lineaxml = "<CD Documento=\"" + this.Tabla.getValueAt(i, 0).toString() + "\"" + " " + "Numero=" + "\"" + Num_doc + "\"" + " " + "Merc=" + "\"" + this.Tabla.getValueAt(i, 2).toString() + "\"" + " " + "CantM=" + "\"" + cant_m + "\"" + "/>";
            this.dhr.ListaCD.add(lineaxml);
         }
      }

      if (this.Tabla.getRowCount() == 0) {
         this.dhr.trafico.setSelected(false);
      } else {
         this.dhr.trafico.setSelected(true);
         this.dhr.CD_activo = false;
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
      this.dhr.CD_activo = false;
      if (this.Tabla.getRowCount() == 0) {
         this.dhr.trafico.setSelected(false);
      } else {
         this.dhr.trafico.setSelected(true);
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
      if (this.bandera) {
         int ban = false;
         if (this.No.getText().equalsIgnoreCase("")) {
            this.en.ShowMessage("Debe Completar el Campo Número de Documento.", "Información", "Information");
         } else if (this.Cant.getText().equalsIgnoreCase("")) {
            this.en.ShowMessage("Debe Completar el Campo Cantidad de Mercancía Transportada.", "Información", "Information");
         } else if (this.Viajes.getText().equalsIgnoreCase("")) {
            this.en.ShowMessage("Debe Completar el Campo Número de Viajes.", "Información", "Information");
         } else {
            DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();
            int cant_elem = model.getRowCount();
            String doc;
            String Numero;
            String mercancia;
            String cant;
            if (cant_elem == 0) {
               doc = String.valueOf(this.Doc.getSelectedItem());
               Numero = String.valueOf(this.No.getText());
               mercancia = String.valueOf(this.Carga.getSelectedItem());
               cant = String.valueOf(this.Cant.getText());
               model.insertRow(model.getRowCount(), new Object[]{doc, Numero, mercancia, cant});
               this.No.setText("");
               this.Cant.setText("");
               this.bandera = false;
            } else {
               doc = String.valueOf(this.Doc.getSelectedItem());
               Numero = this.No.getText();
               mercancia = String.valueOf(this.Carga.getSelectedItem());
               cant = String.valueOf(this.Cant.getText());

               for(int i = 0; i < cant_elem; ++i) {
                  String numero = this.Tabla.getValueAt(i, 1).toString();
                  if (Numero.equalsIgnoreCase(numero)) {
                     this.en.ShowMessage("El Número de Documento ya Existe en la Tabla.", "Información", "Information");
                     ban = true;
                     break;
                  }
               }

               if (!ban) {
                  model.insertRow(model.getRowCount(), new Object[]{doc, Numero, mercancia, cant});
                  this.No.setText("");
                  this.Cant.setText("");
                  this.bandera = false;
               }
            }
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
      if (this.bandera) {
         int Numero_fila = this.Tabla.getSelectedRow();
         int cantFilas = this.Tabla.getRowCount();
         if (cantFilas == 0) {
            this.en.ShowMessage("No hay Elementos Insertados en la Tabla.", "Error", "Error");
         } else if (Numero_fila == -1) {
            this.en.ShowMessage("Debe Seleccionar una Fila de la Tabla.", "Error", "Error");
         } else if (!this.Tabla.getColumnSelectionAllowed() && this.Tabla.getRowSelectionAllowed()) {
            int ban = false;
            String doc = String.valueOf(this.Doc.getSelectedItem());
            String numero = String.valueOf(this.No.getText());
            String mercancia = String.valueOf(this.Carga.getSelectedItem());
            String cant = String.valueOf(this.Cant.getText());

            for(int i = 0; i < cantFilas; ++i) {
               if (i != Numero_fila) {
                  String Numero = this.Tabla.getValueAt(i, 1).toString();
                  if (Numero.equalsIgnoreCase(numero)) {
                     this.en.ShowMessage("El Número de Documento ya Existe en la Tabla.", "Información", "Information");
                     ban = true;
                     break;
                  }
               }
            }

            if (!ban) {
               this.Tabla.setValueAt(doc, Numero_fila, 0);
               this.Tabla.setValueAt(this.No.getText(), Numero_fila, 1);
               this.Tabla.setValueAt(mercancia, Numero_fila, 2);
               this.Tabla.setValueAt(cant, Numero_fila, 3);
               this.bandera = false;
            }
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

   private void ActUmMouseEntered(MouseEvent evt) {
      this.ActUm1.setVisible(true);
      this.ActUm.setVisible(false);
   }

   private void ActUm1MouseExited(MouseEvent evt) {
      this.ActUm.setVisible(true);
      this.ActUm1.setVisible(false);
   }

   private void ActUm1MouseClicked(MouseEvent evt) {
      try {
         this.Post_UM();
      } catch (SAXException var3) {
         Logger.getLogger(CargaDescarga.class.getName()).log(Level.SEVERE, (String)null, var3);
      } catch (IOException var4) {
         Logger.getLogger(CargaDescarga.class.getName()).log(Level.SEVERE, (String)null, var4);
      }

   }

   private void ActMercMouseEntered(MouseEvent evt) {
      this.ActMerc.setVisible(false);
      this.ActMerc1.setVisible(true);
   }

   private void ActMerc1MouseExited(MouseEvent evt) {
      this.ActMerc1.setVisible(false);
      this.ActMerc.setVisible(true);
   }

   private void ActMerc1MouseClicked(MouseEvent evt) {
      try {
         this.Post_Mercancia();
      } catch (SAXException var3) {
         Logger.getLogger(CargaDescarga.class.getName()).log(Level.SEVERE, (String)null, var3);
      } catch (IOException var4) {
         Logger.getLogger(CargaDescarga.class.getName()).log(Level.SEVERE, (String)null, var4);
      }

   }

   private void ActualizarDoc1MouseExited(MouseEvent evt) {
      this.ActualizarDoc1.setVisible(false);
      this.ActualizarDoc.setVisible(true);
   }

   private void ActualizarDoc1MouseClicked(MouseEvent evt) {
      try {
         this.Post_Documento();
      } catch (SAXException var3) {
         Logger.getLogger(CargaDescarga.class.getName()).log(Level.SEVERE, (String)null, var3);
      } catch (IOException var4) {
         Logger.getLogger(CargaDescarga.class.getName()).log(Level.SEVERE, (String)null, var4);
      }

   }

   private void ActualizarDocMouseEntered(MouseEvent evt) {
      this.ActualizarDoc.setVisible(false);
      this.ActualizarDoc1.setVisible(true);
   }

   private void CantKeyTyped(KeyEvent evt) {
      char c = evt.getKeyChar();
      if ((c < '0' || c > '9') && c != '\b' && c != '.') {
         evt.consume();
      }

      if (c == '.' && (this.Cant.getText().contains(".") || this.Cant.getText().isEmpty())) {
         evt.consume();
      }

      if (this.Cant.getText().contains(".") && this.Cant.getText().length() - 2 > this.Cant.getText().indexOf(".")) {
         evt.consume();
      }

   }

   private void NoKeyTyped(KeyEvent evt) {
      char c = evt.getKeyChar();
      if (c == ' ' || this.No.getText().length() >= 10) {
         evt.consume();
      }

   }

   private void ViajesKeyTyped(KeyEvent evt) {
      char c = evt.getKeyChar();
      if ((c < '0' || c > '9') && c != '\b') {
         evt.consume();
      }

   }

   public void Llenar_Combo_Documento() throws SAXException, IOException {
      try {
         IdDocumento = "";
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "Tipo_Documento.xml");
         InputSource Tipo_Documento = new InputSource(new StringReader(respuesta));
         parser.parse(Tipo_Documento);
         Document doc = parser.getDocument();
         NodeList Lista_Documentos = doc.getElementsByTagName("ROW");
         int cant_doc = Lista_Documentos.getLength();
         this.Doc.removeAllItems();

         for(int i = 0; i < cant_doc; ++i) {
            String Id = Lista_Documentos.item(i).getAttributes().getNamedItem("ID").getNodeValue();
            String Documento = Lista_Documentos.item(i).getAttributes().getNamedItem("Documento").getNodeValue();
            if (Id.equalsIgnoreCase("")) {
               Id = "No";
            }

            if (i == 0) {
               IdDocumento = IdDocumento + Id + " " + Documento;
            } else {
               IdDocumento = IdDocumento + "," + Id + " " + Documento;
            }

            this.Doc.addItem(Documento);
         }
      } catch (Exception var10) {
         if (!this.en.Tiene_Conexion) {
            return;
         }

         this.Post_Documento();
      }

   }

   public void Llenar_Combo_Mercancia() throws SAXException, IOException {
      try {
         IdMercancia = "";
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "Tipo_Mercancia.xml");
         InputSource Tipo_Mercancia = new InputSource(new StringReader(respuesta));
         parser.parse(Tipo_Mercancia);
         Document doc = parser.getDocument();
         NodeList Lista_Mercancia = doc.getElementsByTagName("ROW");
         int cant_m = Lista_Mercancia.getLength();
         this.Carga.removeAllItems();

         for(int i = 0; i < cant_m; ++i) {
            String Id = Lista_Mercancia.item(i).getAttributes().getNamedItem("ID").getNodeValue();
            String Mercancia = Lista_Mercancia.item(i).getAttributes().getNamedItem("Mercancia").getNodeValue();
            if (Id.equalsIgnoreCase("")) {
               Id = "No";
            }

            if (i == 0) {
               IdMercancia = IdMercancia + Id + " " + Mercancia;
            } else {
               IdMercancia = IdMercancia + "*" + Id + " " + Mercancia;
            }

            this.Carga.addItem(Mercancia);
         }
      } catch (Exception var10) {
         if (!this.en.Tiene_Conexion) {
            return;
         }

         this.Post_Mercancia();
      }

   }

   public void Llenar_Combo_UM() throws SAXException, IOException {
      try {
         IdUM = "";
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "Tipo_UM.xml");
         InputSource Tipo_UM = new InputSource(new StringReader(respuesta));
         parser.parse(Tipo_UM);
         Document doc = parser.getDocument();
         NodeList Lista_UM = doc.getElementsByTagName("ROW");
         int cant_doc = Lista_UM.getLength();
         this.UMedida.removeAllItems();
         int i = 0;
         if (i < cant_doc) {
            String Id = Lista_UM.item(i).getAttributes().getNamedItem("ID").getNodeValue();
            String UM = Lista_UM.item(i).getAttributes().getNamedItem("Unidad").getNodeValue();
            if (Id.equalsIgnoreCase("")) {
               Id = "No";
            }

            if (i == 0) {
               IdUM = IdUM + Id + " " + UM;
            } else {
               IdUM = IdUM + "," + Id + " " + UM;
            }

            this.UMedida.addItem(UM);
         }
      } catch (Exception var10) {
         if (!this.en.Tiene_Conexion) {
            return;
         }

         this.Post_UM();
      }

   }

   public void Mostrar() throws SAXException, IOException {
      try {
         this.dhr.CD_activo = true;
         int size = this.dhr.listado_prod.size();
         if (size > 0) {
            DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();
            String[] partes = null;

            for(int i = 0; i < size; ++i) {
               Productos p = (Productos)this.dhr.listado_prod.get(i);
               this.Viajes.setText(String.valueOf(this.dhr.viajes));
               model.insertRow(model.getRowCount(), new Object[]{p.documento, p.numero, p.mercancia, p.cant_merc});
            }
         }

         if (!this.en.cambio_de_fecha) {
            this.Llenar_Combo_Documento();
            this.Llenar_Combo_Mercancia();
            this.Llenar_Combo_UM();
         } else if (this.en.cambio_de_fecha && this.dhr.en.Tiene_Conexion) {
            this.Post_Documento();
            this.Post_Mercancia();
            this.Post_UM();
         }

         this.setLocationRelativeTo(this.dhr);
         this.setVisible(true);
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   public String Obtener_ID_Doc(String Documento) {
      String[] partes = IdDocumento.split(",");
      String id = "";

      for(int i = 0; i < partes.length; ++i) {
         if (partes[i].contains(Documento)) {
            String[] idd = partes[i].split(" ");
            id = idd[0];
         }
      }

      return id;
   }

   public String Obtener_ID_Merc(String Mercancia) {
      String[] partes = IdMercancia.split("\\*");
      String id = "";

      for(int i = 0; i < partes.length; ++i) {
         if (partes[i].contains(Mercancia)) {
            String[] idd = partes[i].split(" ");
            id = idd[0];
         }
      }

      return id;
   }

   public String Obtener_ID_UM(String um) {
      String[] partes = IdUM.split(",");
      String id = "";

      for(int i = 0; i < partes.length; ++i) {
         if (partes[i].contains(um)) {
            String[] idd = partes[i].split(" ");
            id = idd[0];
         }
      }

      return id;
   }

   public void setSelectedIndex(int index) {
      this.Carga.setSelectedIndex(index);
      this.inputFieldCarga.setText(this.Carga.getItemAt(index).toString());
      this.inputFieldCarga.setSelectionEnd(this.caretPosCarga + this.inputFieldCarga.getText().length());
      this.inputFieldCarga.moveCaretPosition(this.caretPosCarga);
   }

   public void setEditorMercancia(ComboBoxEditor editor) {
      this.Carga.setEditor(editor);
      if (editor.getEditorComponent() instanceof JTextField) {
         this.inputFieldCarga = (JTextField)editor.getEditorComponent();
         this.inputFieldCarga.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
               super.keyTyped(e);
            }

            public void keyReleased(KeyEvent ev) {
               char key = ev.getKeyChar();
               if (Character.isLetterOrDigit(key) || Character.isSpaceChar(key)) {
                  CargaDescarga.this.Carga.showPopup();
                  CargaDescarga.this.caretPosCarga = CargaDescarga.this.inputFieldCarga.getCaretPosition();
                  String text = "";

                  try {
                     text = CargaDescarga.this.inputFieldCarga.getText(0, CargaDescarga.this.caretPosCarga);
                  } catch (BadLocationException var6) {
                     var6.printStackTrace();
                  }

                  for(int i = 0; i < CargaDescarga.this.Carga.getItemCount(); ++i) {
                     String element = (String)CargaDescarga.this.Carga.getItemAt(i);
                     if (element.startsWith(text)) {
                        CargaDescarga.this.setSelectedIndex(i);
                        return;
                     }
                  }

               }
            }
         });
      }

   }
}
