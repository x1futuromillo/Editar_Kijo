package Diferido;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.GroupLayout.Alignment;
import org.apache.xerces.parsers.DOMParser;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Configuracion extends JFrame {
   Entrada en;
   public JRadioButton Bluetooth;
   public JRadioButton Cabv3;
   private JLabel ImgAceptar;
   private JLabel ImgAceptar1;
   private JLabel ImgCancelar;
   private JLabel ImgCancelar1;
   private JRadioButton Normal;
   private JTextField Sitio;
   public JRadioButton TRLocal;
   public JRadioButton TRServidor;
   public JRadioButton Tarjeta;
   private JLabel User;
   private JLabel User1;
   private JLabel User2;
   private JLabel User3;
   private JLabel User4;
   private JLabel User5;
   private JLabel User6;
   private JRadioButton Verano;
   public JCheckBox checkproxy;
   public JPasswordField claveproxy;
   private JLabel dir;
   public JTextField direccion;
   private JLabel jLabel1;
   private JPanel jPanel1;
   private JPanel jPanel2;
   private JSpinner jSpinner1;
   private JLabel passp;
   private JLabel port;
   public JTextField puerto;
   private JLabel userp;
   public JTextField userproxy;

   public Configuracion(Entrada en) throws MalformedURLException {
      this.initComponents();
      this.en = en;
      this.ImgAceptar1.setVisible(false);
      this.ImgAceptar.setVisible(true);
      this.ImgCancelar1.setVisible(false);
      this.ImgCancelar.setVisible(true);
      File dir_imagen = new File("test-data/diferido install.png");
      URL img = dir_imagen.toURI().toURL();
      this.setIconImage((new ImageIcon(img)).getImage());
   }

   public Configuracion() {
      this.initComponents();
   }

   public void CrearXmlConfiguracion(File config, String sitio, String horario, String fechactual, String dirproxy, String portproxy, String ususrioproxy, String passproxy, String chequeo, String transferencia, String tiempoAlmacenamiento) throws IOException {
      String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><DATAPACKET Version=\"2.0\">    <Opciones_de_Configuracion>        <Horario Tipo = \"" + horario + "\" />" + "       <Transferencia Tipo = \"" + transferencia + "\" />" + "       <Almacenamiento Tiempo = \"" + tiempoAlmacenamiento + "\" />" + "       <FechaActual Fecha = \"" + fechactual + "\" />" + "       <Sitio Url = \"" + sitio + "\" />" + "       <Direccion dir  = \"" + dirproxy + "\" />" + "       <Puerto port  = \"" + portproxy + "\" />" + "       <UserProxy usuario  = \"" + ususrioproxy + "\" />" + "       <PassProxy pass  = \"" + passproxy + "\" />" + "       <Check cheq  = \"" + chequeo + "\" />" + "      <Velocidad value  = \"" + this.en.filtrar_vel + "\" />" + "    </Opciones_de_Configuracion>" + "</DATAPACKET>";
      xml.trim();
      this.en.Encrypt(this.en.encript, "Configuracion.xml", xml);
   }

   public void MostrarCampos() throws SAXException, IOException {
      File config = new File("Configuracion.xml");
      if (config.exists()) {
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "Configuracion.xml");
         InputSource Configuracion = new InputSource(new StringReader(respuesta));
         parser.parse(Configuracion);
         Document doc = parser.getDocument();
         NodeList Opciones = doc.getElementsByTagName("Horario");
         String horario = Opciones.item(0).getAttributes().getNamedItem("Tipo").getNodeValue();
         Opciones = doc.getElementsByTagName("Transferencia");
         String transferencia = Opciones.item(0).getAttributes().getNamedItem("Tipo").getNodeValue();
         Opciones = doc.getElementsByTagName("Almacenamiento");
         String tiempo = Opciones.item(0).getAttributes().getNamedItem("Tiempo").getNodeValue();
         Opciones = doc.getElementsByTagName("Sitio");
         String url = Opciones.item(0).getAttributes().getNamedItem("Url").getNodeValue();
         Opciones = doc.getElementsByTagName("Direccion");
         String Address = Opciones.item(0).getAttributes().getNamedItem("dir").getNodeValue();
         Opciones = doc.getElementsByTagName("Puerto");
         String Puerto = Opciones.item(0).getAttributes().getNamedItem("port").getNodeValue();
         Opciones = doc.getElementsByTagName("UserProxy");
         String Usuario = Opciones.item(0).getAttributes().getNamedItem("usuario").getNodeValue();
         Opciones = doc.getElementsByTagName("PassProxy");
         String Pass = Opciones.item(0).getAttributes().getNamedItem("pass").getNodeValue();
         Opciones = doc.getElementsByTagName("Check");
         String ch = Opciones.item(0).getAttributes().getNamedItem("cheq").getNodeValue();
         Opciones = doc.getElementsByTagName("Velocidad");
         this.en.filtrar_vel = new Double(Opciones.item(0).getAttributes().getNamedItem("value").getNodeValue());
         this.direccion.setText(Address);
         this.puerto.setText(Puerto);
         this.userproxy.setText(Usuario);
         this.claveproxy.setText(Pass);
         if (ch.equalsIgnoreCase("Si")) {
            this.checkproxy.setSelected(true);
            this.dir.setEnabled(true);
            this.direccion.setEnabled(true);
            this.port.setEnabled(true);
            this.puerto.setEnabled(true);
            this.userp.setEnabled(true);
            this.userproxy.setEnabled(true);
            this.passp.setEnabled(true);
            this.claveproxy.setEnabled(true);
         } else {
            this.checkproxy.setSelected(false);
            this.dir.setEnabled(false);
            this.direccion.setEnabled(false);
            this.port.setEnabled(false);
            this.puerto.setEnabled(false);
            this.userp.setEnabled(false);
            this.userproxy.setEnabled(false);
            this.passp.setEnabled(false);
            this.claveproxy.setEnabled(false);
         }

         if (transferencia.equalsIgnoreCase("Tarjeta")) {
            this.Tarjeta.setSelected(true);
            this.Bluetooth.setSelected(false);
            this.TRServidor.setSelected(false);
            this.TRLocal.setSelected(false);
            this.Cabv3.setSelected(false);
         } else if (transferencia.equalsIgnoreCase("Bluetooth")) {
            this.Tarjeta.setSelected(false);
            this.Bluetooth.setSelected(true);
            this.TRServidor.setSelected(false);
            this.TRLocal.setSelected(false);
            this.Cabv3.setSelected(false);
         } else if (transferencia.equalsIgnoreCase("TR Servidor")) {
            this.Tarjeta.setSelected(false);
            this.Bluetooth.setSelected(false);
            this.TRServidor.setSelected(true);
            this.TRLocal.setSelected(false);
            this.Cabv3.setSelected(false);
         } else if (transferencia.equalsIgnoreCase("TR Local")) {
            this.Tarjeta.setSelected(false);
            this.Bluetooth.setSelected(false);
            this.TRServidor.setSelected(false);
            this.TRLocal.setSelected(true);
            this.Cabv3.setSelected(false);
         } else {
            this.Tarjeta.setSelected(false);
            this.Bluetooth.setSelected(false);
            this.TRServidor.setSelected(false);
            this.TRLocal.setSelected(false);
            this.Cabv3.setSelected(true);
         }

         if (horario.equalsIgnoreCase("Normal")) {
            this.Normal.setSelected(true);
            this.Verano.setSelected(false);
         } else {
            this.Verano.setSelected(true);
            this.Normal.setSelected(false);
         }

         this.jSpinner1.setValue(Integer.parseInt(tiempo));
         this.Sitio.setText(url);
      }

      this.setLocationRelativeTo(this.en);
      this.en.setVisible(false);
      this.setVisible(true);
   }

   private void initComponents() {
      this.jPanel2 = new JPanel();
      this.jPanel1 = new JPanel();
      this.checkproxy = new JCheckBox();
      this.ImgAceptar = new JLabel();
      this.ImgAceptar1 = new JLabel();
      this.ImgCancelar = new JLabel();
      this.ImgCancelar1 = new JLabel();
      this.User = new JLabel();
      this.Normal = new JRadioButton();
      this.Verano = new JRadioButton();
      this.User1 = new JLabel();
      this.User2 = new JLabel();
      this.Sitio = new JTextField();
      this.User3 = new JLabel();
      this.dir = new JLabel();
      this.port = new JLabel();
      this.userp = new JLabel();
      this.passp = new JLabel();
      this.direccion = new JTextField();
      this.puerto = new JTextField();
      this.userproxy = new JTextField();
      this.claveproxy = new JPasswordField();
      this.User4 = new JLabel();
      this.Tarjeta = new JRadioButton();
      this.Bluetooth = new JRadioButton();
      this.TRServidor = new JRadioButton();
      this.User6 = new JLabel();
      this.User5 = new JLabel();
      this.jSpinner1 = new JSpinner();
      this.TRLocal = new JRadioButton();
      this.Cabv3 = new JRadioButton();
      this.jLabel1 = new JLabel();
      GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
      this.jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGap(0, 100, 32767));
      jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGap(0, 100, 32767));
      this.setDefaultCloseOperation(2);
      this.setTitle("Opciones de Configuración");
      this.setBackground(new Color(201, 231, 221));
      this.setMinimumSize(new Dimension(321, 516));
      this.setResizable(false);
      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent evt) {
            Configuracion.this.formWindowClosing(evt);
         }
      });
      this.getContentPane().setLayout(new AbsoluteLayout());
      this.jPanel1.setBackground(new Color(201, 231, 221));
      this.jPanel1.setAlignmentX(0.0F);
      this.jPanel1.setAlignmentY(0.0F);
      this.jPanel1.setMinimumSize(new Dimension(321, 516));
      this.jPanel1.setPreferredSize(new Dimension(321, 516));
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.checkproxy.setFont(new Font("Tahoma", 1, 12));
      this.checkproxy.setForeground(new Color(0, 0, 102));
      this.checkproxy.setText("Proxy");
      this.checkproxy.setOpaque(false);
      this.checkproxy.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Configuracion.this.checkproxyActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.checkproxy, new AbsoluteConstraints(30, 270, -1, -1));
      this.ImgAceptar.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar.png")));
      this.ImgAceptar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Configuracion.this.ImgAceptarMouseEntered(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Configuracion.this.ImgAceptarMouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgAceptar, new AbsoluteConstraints(60, 470, 96, 32));
      this.ImgAceptar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar on.png")));
      this.ImgAceptar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Configuracion.this.ImgAceptar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Configuracion.this.ImgAceptar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgAceptar1, new AbsoluteConstraints(60, 470, 96, 32));
      this.ImgCancelar.setIcon(new ImageIcon(this.getClass().getResource("/Images/cancelar.png")));
      this.ImgCancelar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Configuracion.this.ImgCancelarMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImgCancelar, new AbsoluteConstraints(170, 470, 96, 32));
      this.ImgCancelar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/cancelar on.png")));
      this.ImgCancelar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Configuracion.this.ImgCancelar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Configuracion.this.ImgCancelar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgCancelar1, new AbsoluteConstraints(170, 470, 96, 32));
      this.User.setFont(new Font("Tahoma", 1, 12));
      this.User.setForeground(new Color(0, 0, 102));
      this.User.setText("Guardar Trayectorias");
      this.jPanel1.add(this.User, new AbsoluteConstraints(175, 15, -1, -1));
      this.Normal.setBackground(new Color(237, 243, 248));
      this.Normal.setForeground(new Color(0, 0, 102));
      this.Normal.setSelected(true);
      this.Normal.setText("Normal");
      this.Normal.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Configuracion.this.NormalMouseClicked(evt);
         }
      });
      this.Normal.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Configuracion.this.NormalActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Normal, new AbsoluteConstraints(20, 30, -1, -1));
      this.Verano.setBackground(new Color(237, 243, 248));
      this.Verano.setForeground(new Color(0, 0, 102));
      this.Verano.setText("De Verano");
      this.Verano.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Configuracion.this.VeranoMouseClicked(evt);
         }
      });
      this.Verano.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Configuracion.this.VeranoActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Verano, new AbsoluteConstraints(20, 50, -1, -1));
      this.User1.setFont(new Font("Tahoma", 1, 12));
      this.User1.setForeground(new Color(0, 0, 102));
      this.User1.setText("URL Servicio de Trayectorias");
      this.jPanel1.add(this.User1, new AbsoluteConstraints(20, 112, -1, -1));
      this.User2.setFont(new Font("Tahoma", 0, 12));
      this.User2.setForeground(new Color(0, 0, 102));
      this.User2.setText("Días:");
      this.jPanel1.add(this.User2, new AbsoluteConstraints(180, 50, -1, -1));
      this.Sitio.setText("http://service.movilweb.transnet.cu");
      this.Sitio.setBorder(BorderFactory.createBevelBorder(1));
      this.Sitio.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Configuracion.this.SitioActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Sitio, new AbsoluteConstraints(90, 140, 200, -1));
      this.User3.setFont(new Font("Tahoma", 1, 12));
      this.User3.setForeground(new Color(0, 0, 102));
      this.User3.setText("Datos del Proxy");
      this.jPanel1.add(this.User3, new AbsoluteConstraints(20, 300, -1, -1));
      this.dir.setFont(new Font("Tahoma", 0, 12));
      this.dir.setForeground(new Color(0, 0, 102));
      this.dir.setText("Dirección:");
      this.dir.setEnabled(false);
      this.jPanel1.add(this.dir, new AbsoluteConstraints(30, 330, -1, -1));
      this.port.setFont(new Font("Tahoma", 0, 12));
      this.port.setForeground(new Color(0, 0, 102));
      this.port.setText("Puerto:");
      this.port.setEnabled(false);
      this.jPanel1.add(this.port, new AbsoluteConstraints(40, 360, -1, -1));
      this.userp.setFont(new Font("Tahoma", 0, 12));
      this.userp.setForeground(new Color(0, 0, 102));
      this.userp.setText("Usuario:");
      this.userp.setEnabled(false);
      this.jPanel1.add(this.userp, new AbsoluteConstraints(30, 390, -1, -1));
      this.passp.setFont(new Font("Tahoma", 0, 12));
      this.passp.setForeground(new Color(0, 0, 102));
      this.passp.setText("Clave:");
      this.passp.setEnabled(false);
      this.jPanel1.add(this.passp, new AbsoluteConstraints(40, 420, -1, -1));
      this.direccion.setBorder(BorderFactory.createBevelBorder(1));
      this.direccion.setEnabled(false);
      this.jPanel1.add(this.direccion, new AbsoluteConstraints(100, 330, 100, -1));
      this.puerto.setBorder(BorderFactory.createBevelBorder(1));
      this.puerto.setEnabled(false);
      this.puerto.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent evt) {
            Configuracion.this.puertoKeyTyped(evt);
         }
      });
      this.jPanel1.add(this.puerto, new AbsoluteConstraints(100, 360, 50, -1));
      this.userproxy.setBorder(BorderFactory.createBevelBorder(1));
      this.userproxy.setEnabled(false);
      this.jPanel1.add(this.userproxy, new AbsoluteConstraints(100, 390, 100, -1));
      this.claveproxy.setBorder(BorderFactory.createBevelBorder(1));
      this.claveproxy.setEnabled(false);
      this.jPanel1.add(this.claveproxy, new AbsoluteConstraints(100, 420, 100, -1));
      this.User4.setFont(new Font("Tahoma", 1, 12));
      this.User4.setForeground(new Color(0, 0, 102));
      this.User4.setText("Tipo de Transferencia");
      this.jPanel1.add(this.User4, new AbsoluteConstraints(20, 190, -1, -1));
      this.Tarjeta.setBackground(new Color(231, 238, 246));
      this.Tarjeta.setFont(new Font("Tahoma", 0, 12));
      this.Tarjeta.setForeground(new Color(0, 0, 102));
      this.Tarjeta.setText("Tarjeta");
      this.Tarjeta.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Configuracion.this.TarjetaMouseClicked(evt);
         }
      });
      this.Tarjeta.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Configuracion.this.TarjetaActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Tarjeta, new AbsoluteConstraints(20, 210, -1, -1));
      this.Bluetooth.setBackground(new Color(231, 238, 246));
      this.Bluetooth.setFont(new Font("Tahoma", 0, 12));
      this.Bluetooth.setForeground(new Color(0, 0, 102));
      this.Bluetooth.setText("Bluetooth");
      this.Bluetooth.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Configuracion.this.BluetoothMouseClicked(evt);
         }
      });
      this.Bluetooth.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Configuracion.this.BluetoothActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Bluetooth, new AbsoluteConstraints(90, 210, -1, -1));
      this.TRServidor.setBackground(new Color(231, 238, 246));
      this.TRServidor.setFont(new Font("Tahoma", 0, 12));
      this.TRServidor.setForeground(new Color(0, 0, 102));
      this.TRServidor.setSelected(true);
      this.TRServidor.setText("TR Servidor");
      this.TRServidor.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Configuracion.this.TRServidorMouseClicked(evt);
         }
      });
      this.TRServidor.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Configuracion.this.TRServidorActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.TRServidor, new AbsoluteConstraints(200, 210, -1, -1));
      this.User6.setFont(new Font("Tahoma", 0, 12));
      this.User6.setForeground(new Color(0, 0, 102));
      this.User6.setText("Dirección:");
      this.jPanel1.add(this.User6, new AbsoluteConstraints(20, 140, -1, -1));
      this.User5.setFont(new Font("Tahoma", 1, 12));
      this.User5.setForeground(new Color(0, 0, 102));
      this.User5.setText("Horario Actual");
      this.jPanel1.add(this.User5, new AbsoluteConstraints(20, 15, -1, -1));
      this.jSpinner1.setModel(new SpinnerNumberModel(15, 15, 365, 5));
      this.jPanel1.add(this.jSpinner1, new AbsoluteConstraints(220, 45, 60, -1));
      this.TRLocal.setBackground(new Color(231, 238, 246));
      this.TRLocal.setFont(new Font("Tahoma", 0, 12));
      this.TRLocal.setForeground(new Color(0, 0, 102));
      this.TRLocal.setText("TR Local");
      this.TRLocal.setActionCommand(" TR Local");
      this.TRLocal.setMaximumSize(new Dimension(89, 23));
      this.TRLocal.setMinimumSize(new Dimension(89, 23));
      this.TRLocal.setPreferredSize(new Dimension(89, 23));
      this.TRLocal.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Configuracion.this.TRLocalMouseClicked(evt);
         }
      });
      this.TRLocal.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Configuracion.this.TRLocalActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.TRLocal, new AbsoluteConstraints(200, 230, -1, -1));
      this.Cabv3.setBackground(new Color(231, 238, 246));
      this.Cabv3.setFont(new Font("Tahoma", 0, 12));
      this.Cabv3.setForeground(new Color(0, 0, 102));
      this.Cabv3.setText("Cab v3");
      this.Cabv3.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Configuracion.this.Cabv3MouseClicked(evt);
         }
      });
      this.Cabv3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Configuracion.this.Cabv3ActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.Cabv3, new AbsoluteConstraints(90, 230, -1, -1));
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/Images/fondo_conf.jpg")));
      this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(0, 0, 321, 516));
      this.getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 321, 516));
      this.pack();
   }

   private void formWindowClosing(WindowEvent evt) {
      this.setVisible(false);
      this.en.setVisible(true);
   }

   private void NormalMouseClicked(MouseEvent evt) {
      this.Normal.setSelected(true);
      this.Verano.setSelected(false);
   }

   private void VeranoMouseClicked(MouseEvent evt) {
      this.Verano.setSelected(true);
      this.Normal.setSelected(false);
   }

   private void checkproxyActionPerformed(ActionEvent evt) {
      if (this.checkproxy.isSelected()) {
         this.dir.setEnabled(true);
         this.direccion.setEnabled(true);
         this.port.setEnabled(true);
         this.puerto.setEnabled(true);
         this.userp.setEnabled(true);
         this.userproxy.setEnabled(true);
         this.passp.setEnabled(true);
         this.claveproxy.setEnabled(true);
         this.en.Hay_Proxy = true;
      } else {
         this.dir.setEnabled(false);
         this.direccion.setEnabled(false);
         this.port.setEnabled(false);
         this.puerto.setEnabled(false);
         this.userp.setEnabled(false);
         this.userproxy.setEnabled(false);
         this.passp.setEnabled(false);
         this.claveproxy.setEnabled(false);
         this.en.Hay_Proxy = false;
      }

   }

   private void NormalActionPerformed(ActionEvent evt) {
      this.Verano.setSelected(false);
      this.Normal.setSelected(true);
   }

   private void VeranoActionPerformed(ActionEvent evt) {
      this.Verano.setSelected(true);
      this.Normal.setSelected(false);
   }

   private void ImgAceptarMouseEntered(MouseEvent evt) {
      this.ImgAceptar.setVisible(false);
      this.ImgAceptar1.setVisible(true);
   }

   private void ImgAceptar1MouseExited(MouseEvent evt) {
      this.ImgAceptar1.setVisible(false);
      this.ImgAceptar.setVisible(true);
   }

   private void ImgAceptar1MouseClicked(MouseEvent evt) {
      int ban = false;
      if (!this.checkproxy.isSelected()) {
         this.direccion.setText("");
         this.puerto.setText("");
         this.userproxy.setText("");
         this.claveproxy.setText("");
      }

      String sitio = this.Sitio.getText();
      this.en.SitioMovilWeb = sitio;
      String tiempoAlmacenamiento = this.jSpinner1.getValue().toString();
      this.en.tiemp_almacenamiento = tiempoAlmacenamiento;
      String check;
      if (this.checkproxy.isSelected()) {
         check = "Si";
      } else {
         check = "No";
      }

      String transferencia;
      if (this.Tarjeta.isSelected()) {
         transferencia = "Tarjeta";
      } else if (this.Bluetooth.isSelected()) {
         transferencia = "Bluetooth";
      } else if (this.TRServidor.isSelected()) {
         transferencia = "TR Servidor";
      } else if (this.TRLocal.isSelected()) {
         transferencia = "TR Local";
      } else {
         transferencia = "Cab v3";
      }

      String horario;
      if (this.Normal.isSelected()) {
         horario = "Normal";
      } else {
         horario = "Verano";
      }

      String dirproxy = this.direccion.getText();
      String portproxy = this.puerto.getText();
      String ususrioproxy = this.userproxy.getText();
      String passproxy = this.claveproxy.getText();
      File config;
      Funciones f;
      String msg;
      if (this.checkproxy.isSelected()) {
         config = new File("Configuracion.xml");
         if (!config.exists()) {
            try {
               this.CrearXmlConfiguracion(config, sitio, horario, this.en.fechaservidorinicial, dirproxy, portproxy, ususrioproxy, passproxy, check, transferencia, tiempoAlmacenamiento);
               this.en.InicializarComponentes();
               this.setVisible(false);
               this.en.setVisible(true);
            } catch (Exception var18) {
               msg = "Ocurrió un Error Creando el Fichero de Configuración. Cierre<br/>la Aplicación e Intente Abrirla de Nuevo.";
               this.en.ShowMessage(msg, "Error", "Error");
            }
         } else {
            try {
               if (!config.delete()) {
                  f = new Funciones();
                  f.BorrarTrayectoria(config.getAbsolutePath());
               }

               this.CrearXmlConfiguracion(config, sitio, horario, this.en.fechaservidorinicial, dirproxy, portproxy, ususrioproxy, passproxy, check, transferencia, tiempoAlmacenamiento);
               this.en.InicializarComponentes();
               this.setVisible(false);
               this.en.setVisible(true);
               this.en.ChequearPorTransferir();
            } catch (Exception var17) {
               msg = "Ocurrió un error actualizando el fichero de Configuración. Cierre<br/>la aplicación e intente abrirla de nuevo.";
               this.en.ShowMessage(msg, "Error", "Error");
            }
         }

         ban = true;
      }

      if (!ban) {
         config = new File("Configuracion.xml");
         if (!config.exists()) {
            try {
               this.CrearXmlConfiguracion(config, sitio, horario, this.en.fechaservidorinicial, dirproxy, portproxy, ususrioproxy, passproxy, check, transferencia, tiempoAlmacenamiento);
               this.en.InicializarComponentes();
            } catch (Exception var16) {
               var16.printStackTrace();
            }
         } else {
            try {
               if (!config.delete()) {
                  f = new Funciones();
                  f.BorrarTrayectoria(config.getAbsolutePath());
               }

               this.CrearXmlConfiguracion(config, sitio, horario, this.en.fechaservidorinicial, dirproxy, portproxy, ususrioproxy, passproxy, check, transferencia, tiempoAlmacenamiento);
               this.en.InicializarComponentes();
            } catch (Exception var15) {
               msg = "Ocurrió un Error Actualizando el Fichero de Configuración. Cierre<br/>la Aplicación e Intente Abrirla de Nuevo.";
               this.en.ShowMessage(msg, "Error", "Error");
            }
         }

         this.setVisible(false);
         if (this.en.banconf == 1) {
            this.en = new Entrada();
         } else {
            this.en.setVisible(true);
         }
      }

   }

   private void ImgCancelar1MouseExited(MouseEvent evt) {
      this.ImgCancelar1.setVisible(false);
      this.ImgCancelar.setVisible(true);
   }

   private void ImgCancelar1MouseClicked(MouseEvent evt) {
      this.setVisible(false);
      this.en.setVisible(true);
   }

   private void ImgCancelarMouseEntered(MouseEvent evt) {
      this.ImgCancelar.setVisible(false);
      this.ImgCancelar1.setVisible(true);
   }

   private void TarjetaMouseClicked(MouseEvent evt) {
      this.Tarjeta.setSelected(true);
      this.Bluetooth.setSelected(false);
      this.TRServidor.setSelected(false);
      this.TRLocal.setSelected(false);
      this.Cabv3.setSelected(false);
   }

   private void TarjetaActionPerformed(ActionEvent evt) {
      this.Bluetooth.setSelected(false);
      this.Tarjeta.setSelected(true);
      this.TRServidor.setSelected(false);
      this.TRLocal.setSelected(false);
      this.Cabv3.setSelected(false);
   }

   private void BluetoothMouseClicked(MouseEvent evt) {
      this.Tarjeta.setSelected(false);
      this.Bluetooth.setSelected(true);
      this.TRServidor.setSelected(false);
      this.TRLocal.setSelected(false);
      this.Cabv3.setSelected(false);
   }

   private void BluetoothActionPerformed(ActionEvent evt) {
      this.Tarjeta.setSelected(false);
      this.Bluetooth.setSelected(true);
      this.TRServidor.setSelected(false);
      this.TRLocal.setSelected(false);
      this.Cabv3.setSelected(false);
   }

   private void TRServidorMouseClicked(MouseEvent evt) {
      this.Tarjeta.setSelected(false);
      this.Bluetooth.setSelected(false);
      this.TRServidor.setSelected(true);
      this.TRLocal.setSelected(false);
      this.Cabv3.setSelected(false);
   }

   private void TRServidorActionPerformed(ActionEvent evt) {
      this.Tarjeta.setSelected(false);
      this.Bluetooth.setSelected(false);
      this.TRServidor.setSelected(true);
      this.TRLocal.setSelected(false);
      this.Cabv3.setSelected(false);
   }

   private void TRLocalMouseClicked(MouseEvent evt) {
      this.Tarjeta.setSelected(false);
      this.Bluetooth.setSelected(false);
      this.TRServidor.setSelected(false);
      this.TRLocal.setSelected(true);
      this.Cabv3.setSelected(false);
   }

   private void TRLocalActionPerformed(ActionEvent evt) {
      this.Tarjeta.setSelected(false);
      this.Bluetooth.setSelected(false);
      this.TRServidor.setSelected(false);
      this.TRLocal.setSelected(true);
      this.Cabv3.setSelected(false);
   }

   private void puertoKeyTyped(KeyEvent evt) {
      char c = evt.getKeyChar();
      if ((c < '0' || c > '9') && c != '\b') {
         evt.consume();
      }

      if (this.puerto.getText().length() >= 4) {
         evt.consume();
      }

   }

   private void ImgAceptarMouseExited(MouseEvent evt) {
   }

   private void Cabv3ActionPerformed(ActionEvent evt) {
      this.Tarjeta.setSelected(false);
      this.Bluetooth.setSelected(false);
      this.TRServidor.setSelected(false);
      this.TRLocal.setSelected(false);
      this.Cabv3.setSelected(true);
   }

   private void Cabv3MouseClicked(MouseEvent evt) {
      this.Tarjeta.setSelected(false);
      this.Bluetooth.setSelected(false);
      this.TRServidor.setSelected(false);
      this.TRLocal.setSelected(false);
      this.Cabv3.setSelected(true);
   }

   private void SitioActionPerformed(ActionEvent evt) {
   }
}
