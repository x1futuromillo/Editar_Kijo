package Diferido;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import org.apache.xerces.parsers.DOMParser;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sun.misc.BASE64Encoder;

public class ListadoChoferes extends JFrame {
   Datos_Hoja_de_Ruta hr;
   Error e;
   private JTextField seleccion;
   private JLabel Export;
   private JLabel Export1;
   private JLabel ImgAceptar;
   private JLabel ImgAceptar1;
   private JTable Tabla;
   private JLabel jLabel1;
   private JPanel jPanel1;
   private JScrollPane jScrollPane1;
   private BindingGroup bindingGroup;

   public ListadoChoferes(Datos_Hoja_de_Ruta hr) throws MalformedURLException {
      File dir_imagen = new File("test-data/diferido install.png");
      URL img = dir_imagen.toURI().toURL();
      this.setIconImage((new ImageIcon(img)).getImage());
      this.initComponents();
      this.ImgAceptar.setVisible(true);
      this.ImgAceptar1.setVisible(false);
      this.Export.setVisible(true);
      this.Export1.setVisible(false);
      this.hr = hr;
   }

   public void HacerPost() throws UnsupportedEncodingException, MalformedURLException, IOException, SAXException {
      String user = this.hr.en.user;
      String password = this.hr.en.pass;
      OutputStreamWriter wr = null;
      String port = null;
      HttpURLConnection conn = null;
      StringBuilder postData = new StringBuilder();
      Map<String, Object> params = new LinkedHashMap();
      String sitio = this.hr.en.GetSitio();
      sitio = sitio + "/MovilWebServLet/Choferes";
      params.put("Usuario", user);
      params.put("Clave", password);
      Iterator i$ = params.entrySet().iterator();

      while(i$.hasNext()) {
         Entry<String, Object> param = (Entry)i$.next();
         if (postData.length() != 0) {
         }

         postData.append('&');
         postData.append(URLEncoder.encode((String)param.getKey(), "UTF-8"));
         postData.append('=');
         postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
      }

      byte[] postDataBytes = postData.toString().getBytes("UTF-8");
      URL url;
      String line;
      if (this.hr.en.Hay_Proxy) {
         try {
            String ip = this.hr.en.DireccionProxy;
            port = this.hr.en.PuertoProxy;
            String usuasriop = this.hr.en.UsuarioProxy;
            String passp = this.hr.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(port), sitio);
            conn = (HttpURLConnection)url.openConnection();
            String user_pass = usuasriop + ":" + passp;
            line = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + line);
         } catch (Exception var21) {
            line = "Es posible que no tenga Conexión en este momento. Revise <br/>la Configuración del Proxy.  ";
            this.hr.en.ShowMessage(line, "Información", "Information");
            this.hr.en.Tiene_Conexion = false;
            this.LlenarTabla();
            return;
         }
      } else {
         try {
            url = new URL(sitio);
            conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
         } catch (Exception var20) {
            line = "Es posible que no tenga Conexión en este momento. Revise <br/>la Configuración del Proxy.  ";
            this.hr.en.ShowMessage(line, "Información", "Information");
            this.hr.en.Tiene_Conexion = false;
            this.LlenarTabla();
            return;
         }
      }

      this.hr.en.Tiene_Conexion = true;

      try {
         conn.setReadTimeout(30000);
         conn.setRequestMethod("POST");
         conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
         conn.setDoOutput(true);
         conn.getOutputStream().write(postDataBytes);
         BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
         String respuesta = "";

         for(boolean var17 = true; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            File f = new File("choferes.xml");
            if (f.exists() && !f.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(f.getAbsolutePath());
            }

            this.hr.en.Encrypt(this.hr.en.encript, "choferes.xml", respuesta);
            this.LlenarTabla();
         }

      } catch (SocketTimeoutException var22) {
         line = "La Conexión está tardando algo más de lo habituado.<br/>Se cargará la Lista local de Vehículos.";
         this.hr.en.ShowMessage(line, "Información", "Information");
         this.LlenarTabla();
         this.hr.en.Tiene_Conexion = false;
      } catch (UnknownHostException var23) {
         this.hr.en.ShowMessage("Usted no tiene Conexión en este momento.", "Información", "Information");
         this.LlenarTabla();
         this.hr.en.Tiene_Conexion = false;
      } catch (IOException var24) {
         this.hr.en.ShowMessage("Se produjo un Error descargando la Lista de Choferes.", "Información", "Information");
         this.LlenarTabla();
         this.hr.en.Tiene_Conexion = false;
      }
   }

   public void HacerPost1() throws UnsupportedEncodingException, MalformedURLException, IOException, SAXException {
      String user = this.hr.en.user;
      String password = this.hr.en.pass;
      OutputStreamWriter wr = null;
      String port = null;
      URLConnection conn = null;
      String sitio = this.hr.en.GetSitio();
      sitio = sitio + "/MovilWebServLet/Choferes?Usuario=" + user + "&Clave=" + password;
      URL url;
      String msg;
      if (this.hr.en.Hay_Proxy) {
         try {
            String ip = this.hr.en.DireccionProxy;
            port = this.hr.en.PuertoProxy;
            String usuasriop = this.hr.en.UsuarioProxy;
            String passp = this.hr.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(port), sitio);
            conn = url.openConnection();
            String user_pass = usuasriop + ":" + passp;
            msg = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + msg);
         } catch (Exception var19) {
            msg = "Es posible que no tenga Conexión en este momento. Revise <br/>la Configuración del Proxy.  ";
            this.hr.en.ShowMessage(msg, "Información", "Information");
            this.hr.en.Tiene_Conexion = false;
            this.LlenarTabla();
            return;
         }
      } else {
         try {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         } catch (Exception var18) {
            msg = "Es posible que no tenga Conexión en este momento. Revise <br/>la Configuración del Proxy.  ";
            this.hr.en.ShowMessage(msg, "Información", "Information");
            this.hr.en.Tiene_Conexion = false;
            this.LlenarTabla();
            return;
         }
      }

      this.hr.en.Tiene_Conexion = true;

      try {
         conn.setReadTimeout(30000);
         InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
         BufferedReader rd = new BufferedReader(isr);
         String respuesta = "";

         String line;
         for(boolean var15 = true; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            File f = new File("choferes.xml");
            if (f.exists() && !f.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(f.getAbsolutePath());
            }

            this.hr.en.Encrypt(this.hr.en.encript, "choferes.xml", respuesta);
            this.LlenarTabla();
         }

      } catch (SocketTimeoutException var20) {
         msg = "La Conexión está tardando algo más de lo habituado.<br/>Se cargará la Lista local de Vehículos.";
         this.hr.en.ShowMessage(msg, "Información", "Information");
         this.LlenarTabla();
         this.hr.en.Tiene_Conexion = false;
      } catch (UnknownHostException var21) {
         this.hr.en.ShowMessage("Usted no tiene Conexión en este momento.", "Información", "Information");
         this.LlenarTabla();
         this.hr.en.Tiene_Conexion = false;
      } catch (IOException var22) {
         this.hr.en.ShowMessage("Se produjo un Error descargando la Lista de Choferes.", "Información", "Information");
         this.LlenarTabla();
         this.hr.en.Tiene_Conexion = false;
      }
   }

   public void LlenarTabla(JTextField seleccion) throws SAXException, IOException {
      this.seleccion = seleccion;
      this.LlenarTabla();
   }

   public void LlenarTabla() throws SAXException, IOException {
      this.hr.Listado_Choferes_Activo = true;
      DOMParser parser = new DOMParser();
      String respuesta = this.hr.en.Decrypt(this.hr.en.encript, "choferes.xml");
      InputSource choferes = new InputSource(new StringReader(respuesta));
      parser.parse(choferes);
      Document doc = parser.getDocument();
      Node Datos_Chofer = null;
      NodeList Lista_Choferes = doc.getElementsByTagName("ROW");
      int cant_choferes = Lista_Choferes.getLength();
      DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();

      for(int i = 0; i < cant_choferes; ++i) {
         String Id = Lista_Choferes.item(i).getAttributes().getNamedItem("ID").getNodeValue();
         String Conductor = Lista_Choferes.item(i).getAttributes().getNamedItem("Conductor").getNodeValue();
         model.insertRow(model.getRowCount(), new Object[]{Id, Conductor});
      }

      this.setLocationRelativeTo((Component)null);
      this.setVisible(true);
   }

   public void GuardarXml(String XML) throws IOException {
      OutputStreamWriter fichero = new OutputStreamWriter(new FileOutputStream("choferes.xml"), "ISO-8859-1");
      fichero.write(XML);
      fichero.close();
   }

   private void initComponents() {
      this.bindingGroup = new BindingGroup();
      this.jPanel1 = new JPanel();
      this.jScrollPane1 = new JScrollPane();
      this.Tabla = new JTable();
      this.ImgAceptar = new JLabel();
      this.ImgAceptar1 = new JLabel();
      this.Export = new JLabel();
      this.Export1 = new JLabel();
      this.jLabel1 = new JLabel();
      this.setTitle("Listado de Choferes");
      this.setResizable(false);
      this.addWindowListener(new WindowAdapter() {
         public void windowClosed(WindowEvent evt) {
            ListadoChoferes.this.formWindowClosed(evt);
         }

         public void windowClosing(WindowEvent evt) {
            ListadoChoferes.this.formWindowClosing(evt);
         }
      });
      this.jPanel1.setBackground(new Color(201, 231, 221));
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.Tabla.setModel(new DefaultTableModel(new Object[0][], new String[]{"Id", "Nombre del Conductor"}) {
         Class[] types = new Class[]{String.class, String.class};
         boolean[] canEdit = new boolean[]{false, false};

         public Class getColumnClass(int columnIndex) {
            return this.types[columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return this.canEdit[columnIndex];
         }
      });
      this.Tabla.setFillsViewportHeight(true);
      this.Tabla.getTableHeader().setReorderingAllowed(false);
      Binding binding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, this.Tabla, ELProperty.create("true"), this.Tabla, BeanProperty.create("autoCreateRowSorter"));
      this.bindingGroup.addBinding(binding);
      this.Tabla.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            ListadoChoferes.this.TablaMouseClicked(evt);
         }
      });
      this.jScrollPane1.setViewportView(this.Tabla);
      this.Tabla.getColumnModel().getColumn(0).setResizable(false);
      this.Tabla.getColumnModel().getColumn(0).setPreferredWidth(10);
      this.Tabla.getColumnModel().getColumn(1).setResizable(false);
      this.Tabla.getColumnModel().getColumn(1).setPreferredWidth(270);
      this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(0, 0, 365, 343));
      this.ImgAceptar.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar.png")));
      this.ImgAceptar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            ListadoChoferes.this.ImgAceptarMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImgAceptar, new AbsoluteConstraints(140, 360, 96, 32));
      this.ImgAceptar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar on.png")));
      this.ImgAceptar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            ListadoChoferes.this.ImgAceptar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            ListadoChoferes.this.ImgAceptar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImgAceptar1, new AbsoluteConstraints(140, 360, 96, 32));
      this.Export.setIcon(new ImageIcon(this.getClass().getResource("/Images/Refrescar.png")));
      this.Export.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            ListadoChoferes.this.ExportMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.Export, new AbsoluteConstraints(310, 365, 25, 25));
      this.Export1.setIcon(new ImageIcon(this.getClass().getResource("/Images/Refrescar1.png")));
      this.Export1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            ListadoChoferes.this.Export1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            ListadoChoferes.this.Export1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.Export1, new AbsoluteConstraints(300, 355, 45, 45));
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/Images/fondo choferes.png")));
      this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(0, 344, 365, 69));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      this.bindingGroup.bind();
      this.pack();
   }

   private void formWindowClosed(WindowEvent evt) {
      this.hr.Listado_Choferes_Activo = false;
   }

   private void TablaMouseClicked(MouseEvent evt) {
      this.Tabla.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
               int Numero_fila = ListadoChoferes.this.Tabla.getSelectedRow();
               if (!ListadoChoferes.this.Tabla.getColumnSelectionAllowed() && ListadoChoferes.this.Tabla.getRowSelectionAllowed()) {
                  String var10000 = (String)ListadoChoferes.this.Tabla.getValueAt(Numero_fila, 0);
                  String Conductor = (String)ListadoChoferes.this.Tabla.getValueAt(Numero_fila, 1);
                  ListadoChoferes.this.hr.SetConductor(Conductor);
                  ListadoChoferes.this.hr.Listado_Choferes_Activo = false;
                  ListadoChoferes.this.dispose();
               }
            }

         }
      });
   }

   private void formWindowClosing(WindowEvent evt) {
      this.hr.Listado_Choferes_Activo = false;
   }

   private void ImgAceptarMouseEntered(MouseEvent evt) {
      this.ImgAceptar.setVisible(false);
      this.ImgAceptar1.setVisible(true);
   }

   private void ImgAceptar1MouseClicked(MouseEvent evt) {
      int Numero_fila = this.Tabla.getSelectedRow();
      if (Numero_fila == -1) {
         this.hr.en.ShowMessage("Debe seleccionar una Fila de la Tabla.", "Información", "Information");
      } else if (!this.Tabla.getColumnSelectionAllowed() && this.Tabla.getRowSelectionAllowed()) {
         String Id = (String)this.Tabla.getValueAt(Numero_fila, 0);
         String Conductor = (String)this.Tabla.getValueAt(Numero_fila, 1);
         this.hr.SetConductor(Conductor);
         this.hr.Listado_Choferes_Activo = false;
         this.dispose();
      }

   }

   private void ImgAceptar1MouseExited(MouseEvent evt) {
      this.ImgAceptar.setVisible(true);
      this.ImgAceptar1.setVisible(false);
   }

   private void ExportMouseEntered(MouseEvent evt) {
      this.Export.setVisible(false);
      this.Export1.setVisible(true);
   }

   private void Export1MouseClicked(MouseEvent evt) {
      try {
         DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();
         int cant_filas = model.getRowCount();

         for(int i = 0; i < cant_filas; ++i) {
            model.removeRow(0);
         }

         this.HacerPost();
      } catch (Exception var5) {
         String msg = "Se produjo un Error haciendo la petición.Es posible que  <br/>no tenga Conexión en este momento. Revise la Configuración <br/>del Proxy.";
         this.hr.en.ShowMessage(msg, "Información", "Information");
      }

   }

   private void Export1MouseExited(MouseEvent evt) {
      this.Export1.setVisible(false);
      this.Export.setVisible(true);
   }
}
