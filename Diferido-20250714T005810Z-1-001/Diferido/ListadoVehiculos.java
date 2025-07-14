package Diferido;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sun.misc.BASE64Encoder;

public class ListadoVehiculos extends JFrame {
   Entrada en;
   private JLabel Export;
   private JLabel Export1;
   private JLabel ImgAceptar;
   private JLabel ImgAceptar1;
   private JPanel Panel;
   private JTable Tabla;
   private JLabel guif;
   private JLabel jLabel1;
   private JScrollPane jScrollPane1;
   private BindingGroup bindingGroup;
   static String Idgps = "";

   public ListadoVehiculos(Entrada en) {
      try {
         this.initComponents();
         File dir_imagen = new File("test-data/diferido install.png");
         URL img = dir_imagen.toURI().toURL();
         this.setIconImage((new ImageIcon(img)).getImage());
         this.en = en;
         this.ImgAceptar.setVisible(true);
         this.ImgAceptar1.setVisible(false);
         this.Export.setVisible(true);
         this.Export1.setVisible(false);
         this.guif.setVisible(false);
      } catch (MalformedURLException var4) {
         Logger.getLogger(ListadoVehiculos.class.getName()).log(Level.SEVERE, (String)null, var4);
      }

   }

   public void GuardarXml(String XML) throws IOException {
      FileWriter fichero = new FileWriter("TableID.xml");
      fichero.write(XML);
      fichero.close();
   }

   public void HacerPost() throws SAXException, IOException {
      String user = this.en.user;
      String password = this.en.pass;
      String sitio = this.en.GetSitio();
      String port = null;
      HttpURLConnection conn = null;
      StringBuilder postData = new StringBuilder();
      Map<String, Object> params = new LinkedHashMap();
      sitio = sitio + "/MovilWebServLet/MovilID106";
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
      if (this.en.Hay_Proxy) {
         try {
            String ip = this.en.DireccionProxy;
            port = this.en.PuertoProxy;
            String usuariop = this.en.UsuarioProxy;
            String passp = this.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(port), sitio);
            conn = (HttpURLConnection)url.openConnection();
            String user_pass = usuariop + ":" + passp;
            line = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + line);
         } catch (Exception var19) {
            line = "Es posible que no tenga Conexión en este momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
            this.Llenar_Tabla();
            this.en.apreto_moviles = false;
            return;
         }
      } else {
         try {
            url = new URL(sitio);
            conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
         } catch (Exception var18) {
            line = "Es posible que no tenga Conexión en este momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
            this.Llenar_Tabla();
            this.en.apreto_moviles = false;
            return;
         }
      }

      this.en.Tiene_Conexion = true;

      try {
         conn.setReadTimeout(30000);
         conn.setRequestMethod("POST");
         conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
         conn.setDoOutput(true);
         conn.getOutputStream().write(postDataBytes);
         BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            File f = new File("TableID.xml");
            if (f.exists() && !f.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(f.getAbsolutePath());
            }

            this.en.Encrypt(this.en.encript, "TableID.xml", respuesta);
            this.Llenar_Tabla();
            this.en.apreto_moviles = false;
         } else {
            this.en.ShowMessage("Nombre de Usuario y Contraseña no válidos.", "Información", "Information");
         }
      } catch (SocketTimeoutException var20) {
         line = "La Conexión está Tardando más de lo normal.<br/>Se cargará la lista local de Vehículos.";
         this.en.ShowMessage(line, "Información", "Information");
         this.Llenar_Tabla();
         this.en.apreto_moviles = false;
         this.en.Tiene_Conexion = false;
      } catch (UnknownHostException var21) {
         this.en.ShowMessage("Usted no tiene Conexión en este momento.", "Información", "Information");
         this.Llenar_Tabla();
         this.en.apreto_moviles = false;
         this.en.Tiene_Conexion = false;
      } catch (IOException var22) {
         this.en.ShowMessage("Se Produjo un Error Descargando la Lista de Vehículos.", "Información", "Information");
         this.Llenar_Tabla();
         this.en.apreto_moviles = false;
         this.en.Tiene_Conexion = false;
      }
   }

   public void HacerPost1() throws SAXException, IOException {
      String user = this.en.user;
      String password = this.en.pass;
      String sitio = this.en.GetSitio();
      String port = null;
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/MovilID106?Usuario=" + user + "&Clave=" + password;
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
         } catch (Exception var16) {
            line = "Es posible que no tenga Conexión en este momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
            this.Llenar_Tabla();
            this.en.apreto_moviles = false;
            return;
         }
      } else {
         try {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         } catch (Exception var15) {
            line = "Es posible que no tenga Conexión en este momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
            this.Llenar_Tabla();
            this.en.apreto_moviles = false;
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
            File f = new File("TableID.xml");
            if (f.exists() && !f.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(f.getAbsolutePath());
            }

            this.en.Encrypt(this.en.encript, "TableID.xml", respuesta);
            this.Llenar_Tabla();
            this.en.apreto_moviles = false;
         } else {
            this.en.ShowMessage("Nombre de Usuario y Contraseña no válidos.", "Información", "Information");
         }
      } catch (SocketTimeoutException var17) {
         line = "La Conexión está Tardando más de lo normal.<br/>Se cargará la lista local de Vehículos.";
         this.en.ShowMessage(line, "Información", "Information");
         this.Llenar_Tabla();
         this.en.apreto_moviles = false;
         this.en.Tiene_Conexion = false;
      } catch (UnknownHostException var18) {
         this.en.ShowMessage("Usted no tiene Conexión en este momento.", "Información", "Information");
         this.Llenar_Tabla();
         this.en.apreto_moviles = false;
         this.en.Tiene_Conexion = false;
      } catch (IOException var19) {
         this.en.ShowMessage("Se Produjo un Error Descargando la Lista de Vehículos.", "Información", "Information");
         this.Llenar_Tabla();
         this.en.apreto_moviles = false;
         this.en.Tiene_Conexion = false;
      }
   }

   private void initComponents() {
      this.bindingGroup = new BindingGroup();
      this.Panel = new JPanel();
      this.jScrollPane1 = new JScrollPane();
      this.Tabla = new JTable();
      this.ImgAceptar = new JLabel();
      this.ImgAceptar1 = new JLabel();
      this.Export = new JLabel();
      this.Export1 = new JLabel();
      this.guif = new JLabel();
      this.jLabel1 = new JLabel();
      this.setDefaultCloseOperation(2);
      this.setTitle("Listado de Vehículos");
      this.setResizable(false);
      this.addWindowListener(new WindowAdapter() {
         public void windowClosed(WindowEvent evt) {
            ListadoVehiculos.this.formWindowClosed(evt);
         }

         public void windowClosing(WindowEvent evt) {
            ListadoVehiculos.this.formWindowClosing(evt);
         }
      });
      this.Panel.setBackground(new Color(201, 231, 221));
      this.Panel.setLayout(new AbsoluteLayout());
      this.Tabla.setModel(new DefaultTableModel(new Object[0][], new String[]{"CHAPA", "Número", "Consumo", "Consumo Tec"}) {
         Class[] types = new Class[]{String.class, String.class, String.class, String.class};
         boolean[] canEdit = new boolean[]{false, false, false, false};

         public Class getColumnClass(int columnIndex) {
            return this.types[columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return this.canEdit[columnIndex];
         }
      });
      this.Tabla.setFillsViewportHeight(true);
      this.Tabla.setSelectionMode(0);
      this.Tabla.getTableHeader().setReorderingAllowed(false);
      Binding binding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, this.Tabla, ELProperty.create("true"), this.Tabla, BeanProperty.create("autoCreateRowSorter"));
      this.bindingGroup.addBinding(binding);
      this.Tabla.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            ListadoVehiculos.this.TablaMouseClicked(evt);
         }

         public void mouseEntered(MouseEvent evt) {
            ListadoVehiculos.this.TablaMouseEntered(evt);
         }
      });
      this.jScrollPane1.setViewportView(this.Tabla);
      if (this.Tabla.getColumnModel().getColumnCount() > 0) {
         this.Tabla.getColumnModel().getColumn(0).setResizable(false);
         this.Tabla.getColumnModel().getColumn(0).setPreferredWidth(25);
         this.Tabla.getColumnModel().getColumn(1).setResizable(false);
         this.Tabla.getColumnModel().getColumn(1).setPreferredWidth(10);
         this.Tabla.getColumnModel().getColumn(2).setResizable(false);
         this.Tabla.getColumnModel().getColumn(2).setPreferredWidth(10);
      }

      this.Panel.add(this.jScrollPane1, new AbsoluteConstraints(0, 0, 302, 360));
      this.ImgAceptar.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar.png")));
      this.ImgAceptar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            ListadoVehiculos.this.ImgAceptarMouseEntered(evt);
         }
      });
      this.Panel.add(this.ImgAceptar, new AbsoluteConstraints(112, 380, 96, 32));
      this.ImgAceptar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar on.png")));
      this.ImgAceptar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            ListadoVehiculos.this.ImgAceptar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            ListadoVehiculos.this.ImgAceptar1MouseExited(evt);
         }
      });
      this.Panel.add(this.ImgAceptar1, new AbsoluteConstraints(112, 380, 96, 32));
      this.Export.setIcon(new ImageIcon(this.getClass().getResource("/Images/Refrescar.png")));
      this.Export.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            ListadoVehiculos.this.ExportMouseEntered(evt);
         }
      });
      this.Panel.add(this.Export, new AbsoluteConstraints(255, 385, 25, 25));
      this.Export1.setIcon(new ImageIcon(this.getClass().getResource("/Images/Refrescar1.png")));
      this.Export1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            ListadoVehiculos.this.Export1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            ListadoVehiculos.this.Export1MouseExited(evt);
         }
      });
      this.Panel.add(this.Export1, new AbsoluteConstraints(245, 375, 45, 45));
      this.Panel.add(this.guif, new AbsoluteConstraints(20, 380, -1, -1));
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/Images/fondo listado Veh.png")));
      this.Panel.add(this.jLabel1, new AbsoluteConstraints(0, 360, 301, 69));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.Panel, -2, -1, -2));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.Panel, -1, -1, 32767));
      this.bindingGroup.bind();
      this.pack();
   }

   private void formWindowClosed(WindowEvent evt) {
      this.en.Listado_Vehiculos_Activo = false;
   }

   private void TablaMouseClicked(MouseEvent evt) {
      this.Tabla.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
               int Numero_fila = ListadoVehiculos.this.Tabla.getSelectedRow();
               if (!ListadoVehiculos.this.Tabla.getColumnSelectionAllowed() && ListadoVehiculos.this.Tabla.getRowSelectionAllowed()) {
                  String Chapa = (String)ListadoVehiculos.this.Tabla.getValueAt(Numero_fila, 0);
                  String Numero = (String)ListadoVehiculos.this.Tabla.getValueAt(Numero_fila, 1);
                  String Consumo = (String)ListadoVehiculos.this.Tabla.getValueAt(Numero_fila, 2);
                  String var10000 = (String)ListadoVehiculos.this.Tabla.getValueAt(Numero_fila, 3);
                  ListadoVehiculos.this.en.Listado_Vehiculos_Activo = false;

                  try {
                     ListadoVehiculos.this.BuscarInformacion_delMovil(Chapa);
                  } catch (SAXException var8) {
                     Logger.getLogger(ListadoVehiculos.class.getName()).log(Level.SEVERE, (String)null, var8);
                  } catch (IOException var9) {
                     Logger.getLogger(ListadoVehiculos.class.getName()).log(Level.SEVERE, (String)null, var9);
                  }

                  ListadoVehiculos.this.en.selecciono_moviles = true;
                  ListadoVehiculos.this.en.apreto_moviles = false;
                  ListadoVehiculos.this.dispose();

                  try {
                     String msg;
                     if (Double.parseDouble(Consumo) <= 0.0D) {
                        ListadoVehiculos.this.en.Chapa.setText("");
                        ListadoVehiculos.this.en.Numero.setText("");
                        ListadoVehiculos.this.en.Indice.setText("");
                        ListadoVehiculos.this.en.apreto_moviles = false;
                        msg = "Verifique que el Índice de Consumo sea correcto para el Móvil " + Chapa + "." + "<br/>" + "Consulte con el Grupo Provincial e informe al Puesto de Mando de GEOCUBA" + "<br/>" + "para arreglar la situación.";
                        ListadoVehiculos.this.en.ShowMessage(msg, "Información", "Information");
                     } else if (ListadoVehiculos.this.en.idcombustible == 0) {
                        ListadoVehiculos.this.en.Chapa.setText("");
                        ListadoVehiculos.this.en.Numero.setText("");
                        ListadoVehiculos.this.en.Indice.setText("");
                        ListadoVehiculos.this.en.apreto_moviles = false;
                     } else if (ListadoVehiculos.this.en.capacTanque == 0) {
                        ListadoVehiculos.this.en.Chapa.setText("");
                        ListadoVehiculos.this.en.Numero.setText("");
                        ListadoVehiculos.this.en.Indice.setText("");
                        ListadoVehiculos.this.en.apreto_moviles = false;
                        msg = "No se pudo obtener la Capacidad del Tanque para el Móvil " + Chapa + "." + "<br/>" + "Consulte con el Grupo Provincial e informe al Puesto de Mando de GEOCUBA" + "<br/>" + "para arreglar la situación.";
                        ListadoVehiculos.this.en.ShowMessage(msg, "Información", "Information");
                     } else {
                        if (Numero.equalsIgnoreCase("") || Numero.equalsIgnoreCase("0")) {
                           Numero = "No";
                        }

                        ListadoVehiculos.this.en.Show_Selection(Chapa, Numero, Consumo);
                     }
                  } catch (Exception var10) {
                     var10.printStackTrace();
                  }
               }
            }

         }
      });
   }

   private void formWindowClosing(WindowEvent evt) {
      this.en.selecciono_moviles = false;
      this.en.apreto_moviles = false;
      this.dispose();
   }

   private void ImgAceptarMouseEntered(MouseEvent evt) {
      this.ImgAceptar.setVisible(false);
      this.ImgAceptar1.setVisible(true);
   }

   private void ImgAceptar1MouseClicked(MouseEvent evt) {
      int Numero_fila = this.Tabla.getSelectedRow();
      if (Numero_fila == -1) {
         this.en.ShowMessage("Debe Seleccionar una Fila de la Tabla.", "Información", "Information");
      } else {
         try {
            if (!this.Tabla.getColumnSelectionAllowed() && this.Tabla.getRowSelectionAllowed()) {
               String Chapa = (String)this.Tabla.getValueAt(Numero_fila, 0);
               String Numero = (String)this.Tabla.getValueAt(Numero_fila, 1);
               String Consumo = (String)this.Tabla.getValueAt(Numero_fila, 2);
               String Consumo_tec = (String)this.Tabla.getValueAt(Numero_fila, 3);
               this.en.Listado_Vehiculos_Activo = false;

               try {
                  this.BuscarInformacion_delMovil(Chapa);
               } catch (SAXException var8) {
                  Logger.getLogger(ListadoVehiculos.class.getName()).log(Level.SEVERE, (String)null, var8);
               } catch (IOException var9) {
                  Logger.getLogger(ListadoVehiculos.class.getName()).log(Level.SEVERE, (String)null, var9);
               }

               this.en.selecciono_moviles = true;
               this.en.apreto_moviles = false;
               this.dispose();

               try {
                  String msg;
                  if (Double.parseDouble(Consumo) <= 0.0D) {
                     this.en.Chapa.setText("");
                     this.en.Numero.setText("");
                     this.en.Indice.setText("");
                     this.en.apreto_moviles = false;
                     msg = "Verifique que el Índice de Consumo sea correcto para el Móvil " + Chapa + "." + "<br/>" + "Consulte con el Grupo Provincial e informe al Puesto de Mando de GEOCUBA" + "<br/>" + "para arreglar la situación.";
                     this.en.ShowMessage(msg, "Información", "Information");
                  } else if (this.en.idcombustible == 0) {
                     this.en.Chapa.setText("");
                     this.en.Numero.setText("");
                     this.en.Indice.setText("");
                     this.en.apreto_moviles = false;
                  } else if (this.en.capacTanque == 0) {
                     this.en.Chapa.setText("");
                     this.en.Numero.setText("");
                     this.en.Indice.setText("");
                     this.en.apreto_moviles = false;
                     msg = "No se pudo obtener la Capacidad del Tanque para el Móvil " + Chapa + "." + "<br/>" + "Consulte con el Grupo Provincial e informe al Puesto de Mando de GEOCUBA" + "<br/>" + "para arreglar la situación.";
                     this.en.ShowMessage(msg, "Información", "Information");
                  } else {
                     if (Numero.equalsIgnoreCase("") || Numero.equalsIgnoreCase("0")) {
                        Numero = "No";
                     }

                     this.en.Show_Selection(Chapa, Numero, Consumo);
                  }
               } catch (Exception var10) {
               }
            }
         } catch (Exception var11) {
         }
      }

      this.en.apreto_moviles = false;
   }

   private void ImgAceptar1MouseExited(MouseEvent evt) {
      this.ImgAceptar1.setVisible(false);
      this.ImgAceptar.setVisible(true);
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
         this.en.ShowMessage(msg, "Información", "Information");
      }

   }

   private void ExportMouseEntered(MouseEvent evt) {
      this.Export.setVisible(false);
      this.Export1.setVisible(true);
   }

   private void Export1MouseExited(MouseEvent evt) {
      this.Export1.setVisible(false);
      this.Export.setVisible(true);
   }

   private void TablaMouseEntered(MouseEvent evt) {
   }

   public void Llenar_Tabla() throws SAXException, IOException {
      this.en.Listado_Vehiculos_Activo = true;
      DOMParser parser = new DOMParser();
      String respuesta = this.en.Decrypt(this.en.encript, "TableID.xml");
      InputSource TableID = new InputSource(new StringReader(respuesta));
      parser.parse(TableID);
      Document doc = parser.getDocument();
      NodeList Lista_Carros = doc.getElementsByTagName("ROW");
      int cant_carros = Lista_Carros.getLength();
      DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();

      for(int i = 0; i < cant_carros; ++i) {
         String Chapa = Lista_Carros.item(i).getAttributes().getNamedItem("CHAPA").getNodeValue();
         String Numero = Lista_Carros.item(i).getAttributes().getNamedItem("Numero").getNodeValue();
         String Consumo = Lista_Carros.item(i).getAttributes().getNamedItem("Consumo").getNodeValue();
         String Capacidad = Lista_Carros.item(i).getAttributes().getNamedItem("Capacidad").getNodeValue();
         String Consumo_tec = Lista_Carros.item(i).getAttributes().getNamedItem("Consumo_Tec").getNodeValue();
         String Capacidad_tec = Lista_Carros.item(i).getAttributes().getNamedItem("Capacidad_Tec").getNodeValue();
         model.insertRow(model.getRowCount(), new Object[]{Chapa, Numero, Consumo, Consumo_tec});
      }

      this.setLocationRelativeTo((Component)null);
      this.setVisible(true);
   }

   private int BuscarIDComb(String Chapa) throws SAXException, IOException {
      try {
         int idc = 0;
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "TableID.xml");
         InputSource TableID = new InputSource(new StringReader(respuesta));
         parser.parse(TableID);
         Document doc = parser.getDocument();
         NodeList Lista_Moviles = doc.getElementsByTagName("ROW");
         int cant_moviles = Lista_Moviles.getLength();

         for(int i = 0; i < cant_moviles; ++i) {
            String chapa = Lista_Moviles.item(i).getAttributes().getNamedItem("CHAPA").getNodeValue();
            String idcomb = Lista_Moviles.item(i).getAttributes().getNamedItem("IdCombustible").getNodeValue();
            String idcomb_tec = Lista_Moviles.item(i).getAttributes().getNamedItem("IdCombustible_Tec").getNodeValue();
            if (chapa.equalsIgnoreCase(Chapa)) {
               idc = Integer.parseInt(idcomb);
               break;
            }
         }

         return idc;
      } catch (Exception var13) {
         String msg = "No se pudo obtener el identificador de Combustible para el Móvil " + Chapa + "." + "<br/>" + "Consulte con el Grupo Provincial e informe al Puesto de Mando de GEOCUBA" + "<br/>" + "para arreglar la situación.";
         this.en.ShowMessage(msg, "Información", "Information");
         return 0;
      }
   }

   private int BuscarCapacidadTanque(String Chapa) throws SAXException, IOException {
      try {
         int capacidad = 0;
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "TableID.xml");
         InputSource TableID = new InputSource(new StringReader(respuesta));
         parser.parse(TableID);
         Document doc = parser.getDocument();
         NodeList Lista_Moviles = doc.getElementsByTagName("ROW");
         int cant_moviles = Lista_Moviles.getLength();

         for(int i = 0; i < cant_moviles; ++i) {
            String chapa = Lista_Moviles.item(i).getAttributes().getNamedItem("CHAPA").getNodeValue();
            String capacTanque = Lista_Moviles.item(i).getAttributes().getNamedItem("Capacidad").getNodeValue();
            String capacTanqueTec = Lista_Moviles.item(i).getAttributes().getNamedItem("Capacidad_Tec").getNodeValue();
            if (chapa.equalsIgnoreCase(Chapa)) {
               capacidad = Integer.parseInt(capacTanque);
               break;
            }
         }

         return capacidad;
      } catch (Exception var13) {
         return 0;
      }
   }

   private void BuscarInformacion_delMovil(String Chapa) throws SAXException, IOException {
      try {
         int capacidad = false;
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "TableID.xml");
         InputSource TableID = new InputSource(new StringReader(respuesta));
         parser.parse(TableID);
         Document doc = parser.getDocument();
         NodeList Lista_Moviles = doc.getElementsByTagName("ROW");
         int cant_moviles = Lista_Moviles.getLength();

         for(int i = 0; i < cant_moviles; ++i) {
            String chapa = Lista_Moviles.item(i).getAttributes().getNamedItem("CHAPA").getNodeValue();
            String idcomb = Lista_Moviles.item(i).getAttributes().getNamedItem("IdCombustible").getNodeValue();
            String idcomb_tec = Lista_Moviles.item(i).getAttributes().getNamedItem("IdCombustible_Tec").getNodeValue();
            String Consumo = Lista_Moviles.item(i).getAttributes().getNamedItem("Consumo").getNodeValue();
            String consumo_tec = Lista_Moviles.item(i).getAttributes().getNamedItem("Consumo_Tec").getNodeValue();
            String capacTanque = Lista_Moviles.item(i).getAttributes().getNamedItem("Capacidad").getNodeValue();
            String capacTanqueTec = Lista_Moviles.item(i).getAttributes().getNamedItem("Capacidad_Tec").getNodeValue();
            if (chapa.equalsIgnoreCase(Chapa)) {
               this.en.idcombustible = Integer.parseInt(idcomb);
               this.en.idcombustible_Tec = Integer.parseInt(idcomb_tec);
               this.en.capacTanque = Integer.parseInt(capacTanque);
               this.en.capacTanqueTec = Integer.parseInt(capacTanqueTec);
               this.en.Consumo = Double.valueOf(Consumo);
               this.en.ConsumoTec = Double.valueOf(consumo_tec);
               break;
            }
         }
      } catch (Exception var17) {
      }

   }
}
