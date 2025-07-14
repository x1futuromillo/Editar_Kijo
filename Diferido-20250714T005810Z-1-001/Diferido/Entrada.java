package Diferido;

import Diferido.CrearXML.XML;
import com.ice.jni.registry.NoSuchValueException;
import com.ice.jni.registry.Registry;
import com.ice.jni.registry.RegistryException;
import com.ice.jni.registry.RegistryKey;
import com.ice.jni.registry.RegistryValue;
import com.sun.xml.bind.StringInputStream;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.WKTReader;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import org.apache.xerces.parsers.DOMParser;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.opengis.feature.simple.SimpleFeature;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sun.misc.BASE64Encoder;

public final class Entrada extends JFrame {
   int idusuario = -1;
   String nombUsuario;
   int IdConductor = -1;
   String encript = "Diferido2013*";
   int IdConductorAux = -1;
   int Grupo = 0;
   double VelocLimite = 0.0D;
   int idcombustible = 0;
   int idcombustible_Tec = -1;
   int capacTanque = 0;
   double ConsumoTec = -1.0D;
   int capacTanqueTec = 0;
   long OriginalSize = 0L;
   boolean cambio_de_fecha = false;
   boolean existe_fichero_configuracion = true;
   String version = "12.76";
   String SalvasOriginales = "";
   String Camino_Salvas_Originales = "";
   String Camino_Reporte = "";
   String user = null;
   String pass = null;
   String proxy = "";
   String port = "";
   String userproxy = null;
   String passproxy = null;
   String dirproxy = null;
   String portproxy = null;
   String SitioMovilWeb = "";
   String Fecha_Inicial = "";
   String Fecha_Final = "";
   String Hora_Inicial = "";
   String Hora_Final = "";
   String fecha_hora = "";
   String path = null;
   String Fichero_a_Transferir;
   String logid;
   double lat_transformada = 0.0D;
   double lat_transformada1 = 0.0D;
   double lon_transformada = 0.0D;
   double lon_transformada1 = 0.0D;
   double lat_ant = 0.0D;
   double lon_ant = 0.0D;
   double velocidad_maxima = 0.0D;
   double velocidad_promedio = 0.0D;
   double distancia_recorrida_total = 0.0D;
   double filtrar_vel = 120.0D;
   ArrayList Desconexiones = new ArrayList();
   ArrayList Paradas = new ArrayList();
   ArrayList Detalles = new ArrayList();
   ArrayList ViolacionesVelc = new ArrayList();
   boolean extraible;
   boolean posible_alteracion = false;
   boolean HorarioVerano = true;
   String Transferencia = "";
   boolean hay_ficheros_sin_transferir = false;
   boolean Listo_para_Transferir = false;
   boolean Listado_Vehiculos_Activo = false;
   boolean Hay_Proxy = false;
   String DireccionProxy = "";
   String PuertoProxy = "";
   String UsuarioProxy = "";
   String PassProxy = "";
   boolean indice0 = false;
   boolean hilo_analisis = false;
   double Consumo = 1.0D;
   String chapa = "";
   String NumeroVehiculo = null;
   String FechaActualLocal = "";
   long cant_dxn_may_5_min = 0L;
   long numero_de_lineas = 0L;
   long tramas_no_validas = 0L;
   long tramas_V_al_inicio = 0L;
   long tramas_V_al_final = 0L;
   long tramas_validas = 0L;
   long tramas_simplificadas = 0L;
   long chequeo_suma_fallido = 0L;
   long lineas_nulas = 0L;
   long total_bytes = 0L;
   long Size = 0L;
   long tiempo_total_paradas = 0L;
   double minx = 0.0D;
   double miny = 0.0D;
   double maxx = 0.0D;
   double maxy = 0.0D;
   String idgps = "";
   File por_transferir = null;
   File transferido = null;
   int Motivo_Error = 0;
   int NoParada = 0;
   boolean Tiene_Conexion = false;
   boolean en_ejecucion = false;
   boolean apreto_moviles = false;
   boolean selecciono_moviles = false;
   boolean abierto = false;
   boolean Kijo_en_Flash = false;
   boolean Kijo_en_PS = false;
   boolean Trayectoria_Enviada = false;
   String Origen_File_to_Transfer = null;
   boolean continuar = true;
   CrearShape shape;
   String camino_trayec = "";
   File shp;
   Cabv3 cabv3;
   TiempoReal real;
   ParserHexadecimal parserHexadecimal;
   PuertoSerie puertoSerie;
   LineString[] lineStringsdesc;
   LineString[] lineStringsviolac;
   int cantViolaciones = 0;
   Point[] pointdet;
   Point[] point_tiempdet;
   Point[] point_tiempdesc;
   Point[] point_tiempviolac;
   ArrayList<Coordinate> arraycoord = new ArrayList();
   String insertDB = new String();
   XML x;
   String FI_Intervalo;
   String FF_Intervalo;
   String FF;
   boolean apreto_fechas = false;
   boolean selecciono_fechas = false;
   String tiemp_almacenamiento;
   String fechaservidorinicial = "";
   int banconf = 0;
   private JLabel Ayuda;
   private JLabel Ayuda1;
   public JTextField Chapa;
   private JLabel ChapaCarro;
   private JLabel Contras;
   private JLabel Contras4;
   private JLabel ImgAceptar;
   private JLabel ImgAceptar1;
   public JTextField Indice;
   private JLabel IndiceConsumo;
   private JLabel Moviles;
   private JLabel Moviles1;
   public JTextField Numero;
   private JLabel NumeroChapa;
   private JLabel Opciones;
   private JLabel Opciones1;
   public JLabel PB;
   public JLabel PBLabel;
   private JPanel PanelPrincipal;
   public JPasswordField Password;
   private JLabel User;
   public JTextField Usuario;
   private JLabel VersionLabel;
   private JLabel jLabel1;
   private JLabel jLabel2;

   public Entrada() {
      try {
         this.initComponents();
         this.Moviles1.setVisible(false);
         this.Moviles.setVisible(true);
         this.ImgAceptar1.setVisible(false);
         this.ImgAceptar.setVisible(true);
         this.PB.setVisible(false);
         this.PBLabel.setVisible(false);
         this.Opciones1.setVisible(false);
         this.Ayuda1.setVisible(false);
         this.shape = new CrearShape();
         this.parserHexadecimal = new ParserHexadecimal(this);
         this.puertoSerie = new PuertoSerie(this);
         this.VersionLabel.setText(this.version);
         this.setTitle("Aplicación Diferido " + this.version);
         this.real = new TiempoReal(this);
         this.x = new XML();
         this.cabv3 = new Cabv3(this);
         this.InicializarComponentes();
         File dir_imagen;
         URL img;
         if (!this.existe_fichero_configuracion) {
            this.Usuario.setEnabled(false);
            this.Password.setEnabled(false);
            dir_imagen = new File("test-data/diferido install.png");
            img = dir_imagen.toURI().toURL();
            this.setIconImage((new ImageIcon(img)).getImage());
            this.setLocationRelativeTo((Component)null);
            this.setVisible(true);
            this.banconf = 1;
         } else {
            this.BorrarDirectorio("Temp");
            this.Crear_Carpeta("Temp");
            this.Crear_Carpeta("Reportes");
            this.Crear_Carpeta("Temp\\Trayectoria");
            this.Crear_Carpeta("Temp\\SHPTemporal");
            this.Crear_Carpeta("Temp\\Ficheros\\");
            this.Crear_Carpeta("Temp\\Ficheros\\Detenciones");
            this.Crear_Carpeta("Temp\\Ficheros\\Desconexiones");
            this.Crear_Carpeta("Temp\\Ficheros\\Trayectoria");
            this.Crear_Carpeta("Temp\\Ficheros\\ViolacionesVelocidad");
            this.Camino_Reporte = "Reportes\\" + this.fechaservidorinicial.substring(8, 10) + "_" + this.fechaservidorinicial.substring(5, 7) + "_" + this.fechaservidorinicial.substring(0, 4);
            this.Crear_Carpeta(this.Camino_Reporte);
            this.RevisarPorTransferir();
            if (this.cambio_de_fecha) {
               this.Borrar15Dias("Datos de las Trayectorias\\Salvas Originales", this.tiemp_almacenamiento);
               this.Borrar15Dias("Datos de las Trayectorias\\Transferidas", this.tiemp_almacenamiento);
               this.Borrar15Dias("Reportes", this.tiemp_almacenamiento);
            }

            this.Usuario.requestFocus();
            dir_imagen = new File("test-data/diferido install.png");
            img = dir_imagen.toURI().toURL();
            this.setIconImage((new ImageIcon(img)).getImage());
            this.setLocationRelativeTo((Component)null);
            this.setVisible(true);
            this.ChequearProxy();
            this.ChequearPorTransferir();
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public void Formatear() throws IOException, AWTException, InterruptedException {
      Process p = Runtime.getRuntime().exec("FormatApp.exe");
   }

   public void CrearPar(String torre) throws IOException {
      String camino = torre + ":" + "/Kijo.par";
      File par = new File(camino);
      if (!par.exists()) {
         par.createNewFile();
      }

      String linea = "Kijo, , ,0";
      FileWriter fw = new FileWriter(par, true);
      fw.write(linea);
      fw.close();
   }

   void InicializarComponentes() throws SAXException, IOException {
      File config = new File("Configuracion.xml");
      if (config.exists()) {
         this.existe_fichero_configuracion = true;

         try {
            DOMParser parser = new DOMParser();
            String respuesta = this.Decrypt(this.encript, "Configuracion.xml");
            InputSource Configuracion = new InputSource(new StringReader(respuesta));
            parser.parse(Configuracion);
            Document doc = parser.getDocument();
            NodeList Options = doc.getElementsByTagName("Horario");
            String horario = Options.item(0).getAttributes().getNamedItem("Tipo").getNodeValue();
            if (horario.equalsIgnoreCase("Normal")) {
               this.HorarioVerano = false;
            } else {
               this.HorarioVerano = true;
            }

            Options = doc.getElementsByTagName("Transferencia");
            String transferencia = Options.item(0).getAttributes().getNamedItem("Tipo").getNodeValue();
            if (transferencia.equalsIgnoreCase("Tarjeta")) {
               this.Transferencia = "1";
            } else if (transferencia.equalsIgnoreCase("Bluetooth")) {
               this.Transferencia = "2";
            } else if (transferencia.equalsIgnoreCase("TR Servidor")) {
               this.Transferencia = "3";
            } else if (transferencia.equalsIgnoreCase("TR Local")) {
               this.Transferencia = "4";
            } else {
               this.Transferencia = "5";
            }

            Options = doc.getElementsByTagName("Sitio");
            this.SitioMovilWeb = Options.item(0).getAttributes().getNamedItem("Url").getNodeValue();
            Options = doc.getElementsByTagName("Almacenamiento");
            this.tiemp_almacenamiento = Options.item(0).getAttributes().getNamedItem("Tiempo").getNodeValue();
            Options = doc.getElementsByTagName("Check");
            String ch = Options.item(0).getAttributes().getNamedItem("cheq").getNodeValue();
            Options = doc.getElementsByTagName("Velocidad");
            this.filtrar_vel = new Double(Options.item(0).getAttributes().getNamedItem("value").getNodeValue());
            if (ch.equalsIgnoreCase("Si")) {
               this.Hay_Proxy = true;
               Options = doc.getElementsByTagName("Direccion");
               this.DireccionProxy = Options.item(0).getAttributes().getNamedItem("dir").getNodeValue();
               Options = doc.getElementsByTagName("Puerto");
               this.PuertoProxy = Options.item(0).getAttributes().getNamedItem("port").getNodeValue();
               Options = doc.getElementsByTagName("UserProxy");
               this.UsuarioProxy = Options.item(0).getAttributes().getNamedItem("usuario").getNodeValue();
               Options = doc.getElementsByTagName("PassProxy");
               this.PassProxy = Options.item(0).getAttributes().getNamedItem("pass").getNodeValue();
            }

            Options = doc.getElementsByTagName("FechaActual");
            String fechactual = Options.item(0).getAttributes().getNamedItem("Fecha").getNodeValue();
            this.fechaservidorinicial = this.Fecha_Hora_Actual_Servidor().substring(0, 10);
            if (!fechactual.equalsIgnoreCase(this.fechaservidorinicial)) {
               this.cambio_de_fecha = true;
               if (!config.delete()) {
                  Funciones f = new Funciones();
                  f.BorrarTrayectoria(config.getAbsolutePath());
               }

               Configuracion conf = new Configuracion(this);
               conf.CrearXmlConfiguracion(config, this.SitioMovilWeb, horario, this.fechaservidorinicial, this.DireccionProxy, this.PuertoProxy, this.UsuarioProxy, this.PassProxy, ch, transferencia, this.tiemp_almacenamiento);
            }
         } catch (Exception var12) {
            config.delete();
            this.existe_fichero_configuracion = false;
         }
      } else {
         this.existe_fichero_configuracion = false;
         String m = "No Existe el Fichero de Configuración. Debe Crearlo para Continuar.";
         this.ShowMessage(m, "Error", "Error");
      }

      this.Fecha_Inicial = "";
      this.Fecha_Final = "";
      this.Hora_Inicial = "";
      this.Hora_Final = "";
      this.path = null;
      this.indice0 = false;
      this.Desconexiones.clear();
      this.Detalles.clear();
      this.Paradas.clear();
      this.lat_transformada = 0.0D;
      this.lat_transformada1 = 0.0D;
      this.lon_transformada = 0.0D;
      this.lon_transformada1 = 0.0D;
      this.posible_alteracion = false;
      this.numero_de_lineas = 0L;
      this.tramas_no_validas = 0L;
      this.tramas_V_al_inicio = 0L;
      this.tramas_V_al_final = 0L;
      this.tramas_validas = 0L;
      this.tramas_simplificadas = 0L;
      this.chequeo_suma_fallido = 0L;
      this.lineas_nulas = 0L;
      this.total_bytes = 0L;
      this.Size = 0L;
      this.tiempo_total_paradas = 0L;
      this.minx = 0.0D;
      this.miny = 0.0D;
      this.maxx = 0.0D;
      this.maxy = 0.0D;
      this.idgps = "";
      this.NoParada = 0;
      this.Tiene_Conexion = true;
      this.Kijo_en_Flash = false;
   }

   public String Fecha_Actual() {
      DateFormat dateformat = new SimpleDateFormat("dd_MM_yyyy");
      Date date = new Date();
      String datestr = dateformat.format(date);
      return datestr;
   }

   public void Copiar_para_Transferida() throws FileNotFoundException, IOException, Throwable {
      String Carpeta_fecha = this.fechaservidorinicial.substring(8, 10) + "_" + this.fechaservidorinicial.substring(5, 7) + "_" + this.fechaservidorinicial.substring(0, 4);
      String dir = "Datos de las Trayectorias\\Transferidas\\" + Carpeta_fecha;
      File destino = new File(dir);
      if (!destino.exists()) {
         destino.mkdir();
      }

      String name_file = this.por_transferir.getName();
      dir = dir + "\\" + name_file;
      File nuevo = new File(dir);
      Funciones f = new Funciones();
      if (!this.por_transferir.renameTo(nuevo)) {
         this.MoverTrayectoria(this.por_transferir, nuevo);
         String Por_Transferir = this.por_transferir.getAbsolutePath();
         f.BorrarTrayectoria(Por_Transferir);
      }

      if (this.por_transferir.exists()) {
         this.por_transferir.delete();
      }

   }

   public String Fecha_Hora_Actual() {
      DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      Date date = new Date();
      String datestr = dateformat.format(date);
      return datestr;
   }

   public String Fecha_Hora_Actual_Servidor() throws IOException {
      try {
         URLConnection conn = null;
         String sitio = this.GetSitio();
         sitio = sitio + "/MovilWebServLet/GetServerDateTime";
         URL url;
         String line;
         if (this.Hay_Proxy) {
            url = new URL("http", this.DireccionProxy, Integer.parseInt(this.PuertoProxy), sitio);
            conn = url.openConnection();
            String user_pass = this.UsuarioProxy + ":" + this.PassProxy;
            line = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + line);
         } else {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         }

         BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         return !respuesta.equalsIgnoreCase("") ? respuesta : this.Fecha_Hora_Actual();
      } catch (Exception var7) {
         return this.Fecha_Hora_Actual();
      }
   }

   public boolean Crear_Carpeta(String camino) {
      File carpeta_fecha = new File(camino);
      if (carpeta_fecha.exists()) {
         return true;
      } else {
         carpeta_fecha.mkdir();
         return false;
      }
   }

   public void ShowMessage(String msg, String titulo, String tipo) {
      if (tipo.equalsIgnoreCase("Information")) {
         JOptionPane.showMessageDialog(new JOptionPane(), "<html><font color=black>" + msg + "</font>", titulo, 1);
      } else {
         JOptionPane.showMessageDialog(new JOptionPane(), "<html><font color=black>" + msg + "</font>", titulo, 0);
      }

   }

   public int ShowMessageConfirmDialog(String msg, String titulo, String tipo) {
      int n = 0;
      if (tipo.equalsIgnoreCase("Confirmación")) {
         n = JOptionPane.showConfirmDialog(new JOptionPane(), "<html> <font color=black>" + msg + "</font>", titulo, 0);
      }

      return n;
   }

   public boolean AnalizarTrayectoria() throws FileNotFoundException, IOException, SAXException, AWTException, InterruptedException {
      this.Motivo_Error = 1;
      this.PBLabel.setText("Analizando Trayectoria...");
      this.PB.setVisible(true);
      this.PBLabel.setVisible(true);
      String camino = "Datos de las Trayectorias\\Por Transferir\\Tarjeta\\" + this.chapa + ".log";
      this.por_transferir = new File(camino);
      boolean existe = false;
      this.Fichero_a_Transferir = this.chapa + ".log";
      if (this.por_transferir.exists()) {
         int i = 1;
         existe = true;

         while(true) {
            String nuevo_fichero = "Datos de las Trayectorias\\Por Transferir\\Tarjeta\\" + this.chapa + "(" + i + ")" + ".log";
            this.por_transferir = new File(nuevo_fichero);
            if (!this.por_transferir.exists()) {
               this.Fichero_a_Transferir = this.chapa + "(" + i + ")" + ".log";
               break;
            }

            ++i;
         }
      }

      Funciones f = new Funciones();
      File origen = new File(this.path);
      this.total_bytes = f.Fin_Fichero(origen);
      long tb = origen.length();
      String msg;
      if (this.total_bytes == 5L) {
         msg = "Esta Trayectoria no se puede Transferir porque no Contiene Datos.";
         this.ShowMessage(msg, "Error", "Error");
         this.PBLabel.setVisible(false);
         this.PB.setVisible(false);
         this.LimpiarCampos();
         this.InicializarComponentes();
         return false;
      } else if (this.total_bytes == 0L) {
         msg = "Esta Trayectoria no se puede Transferir porque está en Blanco.";
         this.ShowMessage(msg, "Error", "Error");
         this.PBLabel.setVisible(false);
         this.PB.setVisible(false);
         this.LimpiarCampos();
         this.InicializarComponentes();
         return false;
      } else {
         if (this.total_bytes <= tb + 150L && this.total_bytes >= tb - 150L) {
            this.MoverTrayectoria(origen, this.por_transferir);
         } else {
            f.CopiarPorTransferir(origen, this.por_transferir, (int)this.total_bytes);
         }

         if (this.Size < 127875072L) {
            this.posible_alteracion = true;
         }

         if (this.Size > 128000000L && this.Size < 253591552L) {
            this.posible_alteracion = true;
         }

         if (this.extraible) {
            try {
               this.Formatear();
            } catch (Exception var9) {
               String msg = "No se Encontró el Ejecutable para Formatear o está Corrupto.";
               this.ShowMessage(msg, "Error", "Error");
            }
         }

         return true;
      }
   }

   public boolean AnalizarTrayectoriaGPSE() throws FileNotFoundException, IOException, SAXException, AWTException, InterruptedException {
      this.Motivo_Error = 1;
      this.PBLabel.setText("Analizando Trayectoria...");
      this.PB.setVisible(true);
      this.PBLabel.setVisible(true);
      String camino = "Datos de las Trayectorias\\Por Transferir\\Bluetooth\\" + this.chapa + ".log";
      this.por_transferir = new File(camino);
      boolean existe = false;
      this.Fichero_a_Transferir = this.chapa + ".log";
      if (this.por_transferir.exists()) {
         int i = 1;
         existe = true;

         while(true) {
            String nuevo_fichero = "Datos de las Trayectorias\\Por Transferir\\Bluetooth\\" + this.chapa + "(" + i + ")" + ".log";
            this.por_transferir = new File(nuevo_fichero);
            if (!this.por_transferir.exists()) {
               this.Fichero_a_Transferir = this.chapa + "(" + i + ")" + ".log";
               break;
            }

            ++i;
         }
      }

      File origen = new File(this.path);

      try {
         this.MoverTrayectoria(origen, this.por_transferir);
         return true;
      } catch (Exception var5) {
         return false;
      }
   }

   public boolean AnalizarTrayectoriaTReal() throws FileNotFoundException, IOException, SAXException, AWTException, InterruptedException {
      this.Motivo_Error = 1;
      System.out.print("\nComenzando Análisis de Trayectoria");
      this.PBLabel.setText("Analizando Trayectoria...");
      this.PB.setVisible(true);
      this.PBLabel.setVisible(true);
      String camino = "Datos de las Trayectorias\\Por Transferir\\TReal\\" + this.chapa + ".log";
      this.por_transferir = new File(camino);
      boolean existe = false;
      this.Fichero_a_Transferir = this.chapa + ".log";
      if (this.por_transferir.exists()) {
         int i = 1;
         existe = true;

         while(true) {
            String nuevo_fichero = "Datos de las Trayectorias\\Por Transferir\\TReal\\" + this.chapa + "(" + i + ")" + ".log";
            this.por_transferir = new File(nuevo_fichero);
            if (!this.por_transferir.exists()) {
               this.Fichero_a_Transferir = this.chapa + "(" + i + ")" + ".log";
               break;
            }

            ++i;
         }
      }

      try {
         File origen = new File(this.path);
         this.MoverTrayectoria(origen, this.por_transferir);
      } catch (Exception var5) {
      }

      System.out.print("\nTrayectoria Analizada");
      return true;
   }

   public boolean AnalizarTrayectoriaCabv3() throws FileNotFoundException, IOException, SAXException, AWTException, InterruptedException {
      this.Motivo_Error = 1;
      this.PBLabel.setText("Analizando Trayectoria...");
      this.PB.setVisible(true);
      this.PBLabel.setVisible(true);
      String camino = "Datos de las Trayectorias\\Por Transferir\\Cabv3\\" + this.chapa + ".log";
      this.por_transferir = new File(camino);
      boolean existe = false;
      this.Fichero_a_Transferir = this.chapa + ".log";
      if (this.por_transferir.exists()) {
         int i = 1;
         existe = true;

         while(true) {
            String nuevo_fichero = "Datos de las Trayectorias\\Por Transferir\\Cabv3\\" + this.chapa + "(" + i + ")" + ".log";
            this.por_transferir = new File(nuevo_fichero);
            if (!this.por_transferir.exists()) {
               this.Fichero_a_Transferir = this.chapa + "(" + i + ")" + ".log";
               break;
            }

            ++i;
         }
      }

      Funciones f = new Funciones();
      File origen = new File(this.path);
      this.total_bytes = f.Fin_Fichero(origen);
      long tb = origen.length();
      String msg;
      if (this.total_bytes == 5L) {
         msg = "Esta trayectoria no se puede transferir porque no contiene datos.";
         this.ShowMessage(msg, "Error", "Error");
         this.PBLabel.setVisible(false);
         this.PB.setVisible(false);
         this.LimpiarCampos();
         this.InicializarComponentes();
         return false;
      } else if (this.total_bytes == 0L) {
         msg = "Esta trayectoria no se puede transferir porque está en blanco.";
         this.ShowMessage(msg, "Error", "Error");
         this.PBLabel.setVisible(false);
         this.PB.setVisible(false);
         this.LimpiarCampos();
         this.InicializarComponentes();
         return false;
      } else {
         if (this.total_bytes <= tb + 150L && this.total_bytes >= tb - 150L) {
            this.MoverTrayectoria(origen, this.por_transferir);
         } else {
            f.CopiarPorTransferir(origen, this.por_transferir, (int)this.total_bytes);
         }

         return true;
      }
   }

   public void BoundingBox(double lon_actual, double lat_actual) {
      if (this.minx == 0.0D && this.maxx == 0.0D) {
         this.minx = this.maxx = lon_actual;
      } else if (lon_actual > this.maxx) {
         this.maxx = lon_actual;
      } else if (lon_actual < this.minx) {
         this.minx = lon_actual;
      }

      if (this.miny == 0.0D && this.maxy == 0.0D) {
         this.miny = this.maxy = lat_actual;
      } else if (lat_actual > this.maxy) {
         this.maxy = lat_actual;
      } else if (lat_actual < this.miny) {
         this.miny = lat_actual;
      }

   }

   public void ChequearPorTransferir() throws FileNotFoundException, IOException, SAXException {
      File f;
      if (this.Transferencia.equalsIgnoreCase("1")) {
         f = new File("Datos de las Trayectorias\\Por Transferir\\Tarjeta");
      } else if (this.Transferencia.equalsIgnoreCase("2")) {
         f = new File("Datos de las Trayectorias\\Por Transferir\\Bluetooth");
      } else if (this.Transferencia.equalsIgnoreCase("3")) {
         f = new File("Datos de las Trayectorias\\Por Transferir\\TReal");
      } else if (this.Transferencia.equalsIgnoreCase("4")) {
         f = new File("Datos de las Trayectorias\\Por Transferir\\TReal");
      } else {
         f = new File("Datos de las Trayectorias\\Por Transferir\\Cabv3");
      }

      if (f.isDirectory()) {
         File[] files = f.listFiles();
         int cant = files.length / 2;
         if (cant > 0) {
            String Msg = "Existen " + cant + " Trayectorias sin Transferir por " + f.getName() + "." + "<br/>" + "¿Desea Transferirlas ahora?";
            String Msg1 = "Existe una Trayectoria sin Transferir de " + f.getName() + "." + "<br/>" + "¿Desea Transferirla ahora?";
            int n;
            if (cant == 1) {
               n = this.ShowMessageConfirmDialog(Msg1, "Mensaje de Confirmación", "Confirmación");
            } else {
               n = this.ShowMessageConfirmDialog(Msg, "Mensaje de Confirmación", "Confirmación");
            }

            if (n == 0) {
               this.hay_ficheros_sin_transferir = true;
               JFileChooser fileChooser = new JFileChooser();
               fileChooser.setCurrentDirectory(f);
               fileChooser.setFileFilter(new LogFilter());
               int seleccion = fileChooser.showOpenDialog(this);
               if (seleccion == 0) {
                  File File_to_Transfer = fileChooser.getSelectedFile();
                  String name = File_to_Transfer.getName();
                  if (name.contains(".log")) {
                     name = name.replace(".log", ".xml");
                     name = "Config" + name;
                     if (this.Transferencia.equalsIgnoreCase("1")) {
                        this.Origen_File_to_Transfer = "Datos de las Trayectorias\\Por Transferir\\Tarjeta\\" + name;
                     } else if (this.Transferencia.equalsIgnoreCase("2")) {
                        this.Origen_File_to_Transfer = "Datos de las Trayectorias\\Por Transferir\\Bluetooth\\" + name;
                     } else if (this.Transferencia.equalsIgnoreCase("3")) {
                        this.Origen_File_to_Transfer = "Datos de las Trayectorias\\Por Transferir\\TReal\\" + name;
                     } else if (this.Transferencia.equalsIgnoreCase("4")) {
                        this.Origen_File_to_Transfer = "Datos de las Trayectorias\\Por Transferir\\TReal\\" + name;
                     } else {
                        this.Origen_File_to_Transfer = "Datos de las Trayectorias\\Por Transferir\\Cabv3\\" + name;
                     }

                     File salva = new File(this.Origen_File_to_Transfer);
                     if (salva.exists()) {
                        try {
                           DOMParser parser = new DOMParser();
                           parser.parse(salva.getPath());
                           Document doc = parser.getDocument();
                           Node Ver = null;
                           Node Ch = null;
                           Node IndConsumo = null;
                           Node IndConsumoTec = null;
                           Node No = null;
                           Node IDC = null;
                           Node IDCA = null;
                           Node IDComb = null;
                           Node IDCombTec = null;
                           Node Capac = null;
                           Node CapacTec = null;
                           Node OS = null;
                           Node Trasf = null;
                           NodeList Parametros = doc.getElementsByTagName("VersionDiferido");
                           Ver = Parametros.item(0);
                           String vers = Ver.getFirstChild().getNodeValue();
                           if (!vers.equalsIgnoreCase(this.version)) {
                              String msg = "El Fichero de Configuración de esta Trayectoria no se puede Cargar con esta<br/>Versión de Diferido. Utilice la Versión " + vers + " " + "para cargar los Datos de" + "<br/>" + "la misma. La Aplicación se Cerrará.";
                              this.ShowMessage(msg, "Error", "Error");
                              System.exit(0);
                           }

                           Parametros = doc.getElementsByTagName("Chapa");
                           Ch = Parametros.item(0);
                           String movil = Ch.getFirstChild().getNodeValue();
                           Parametros = doc.getElementsByTagName("No");
                           No = Parametros.item(0);
                           String num = No.getFirstChild().getNodeValue();
                           Parametros = doc.getElementsByTagName("Indice");
                           IndConsumo = Parametros.item(0);
                           String Ind = IndConsumo.getFirstChild().getNodeValue();
                           Parametros = doc.getElementsByTagName("IndiceTec");
                           IndConsumoTec = Parametros.item(0);
                           String IndTec = IndConsumoTec.getFirstChild().getNodeValue();
                           Parametros = doc.getElementsByTagName("IDConductor");
                           IDC = Parametros.item(0);
                           String IDCond = IDC.getFirstChild().getNodeValue();
                           Parametros = doc.getElementsByTagName("IDConductorAux");
                           IDCA = Parametros.item(0);
                           String IDCondAux = IDCA.getFirstChild().getNodeValue();
                           Parametros = doc.getElementsByTagName("IDCombustible");
                           IDComb = Parametros.item(0);
                           String IDCombustible = IDComb.getFirstChild().getNodeValue();
                           Parametros = doc.getElementsByTagName("IDCombustibleTec");
                           IDCombTec = Parametros.item(0);
                           String IDCombustibleTec = IDCombTec.getFirstChild().getNodeValue();
                           Parametros = doc.getElementsByTagName("Capacidad");
                           Capac = Parametros.item(0);
                           String Capacidad = Capac.getFirstChild().getNodeValue();
                           Parametros = doc.getElementsByTagName("CapacidadTec");
                           CapacTec = Parametros.item(0);
                           String CapacidadTec = CapacTec.getFirstChild().getNodeValue();
                           Parametros = doc.getElementsByTagName("OriginalS");
                           OS = Parametros.item(0);
                           String OriginalS = OS.getFirstChild().getNodeValue();
                           Parametros = doc.getElementsByTagName("Transferencia");
                           Trasf = Parametros.item(0);
                           String Transf = Trasf.getFirstChild().getNodeValue();
                           Configuracion conf = new Configuracion(this);
                           if (Transf.equalsIgnoreCase("1")) {
                              this.Transferencia = "1";
                              conf.Tarjeta.setSelected(true);
                              conf.Bluetooth.setSelected(false);
                              conf.TRServidor.setSelected(false);
                              conf.TRLocal.setSelected(false);
                              conf.Cabv3.setSelected(false);
                           } else if (Transf.equalsIgnoreCase("2")) {
                              this.Transferencia = "2";
                              conf.Tarjeta.setSelected(false);
                              conf.Bluetooth.setSelected(true);
                              conf.TRServidor.setSelected(false);
                              conf.TRLocal.setSelected(false);
                              conf.Cabv3.setSelected(false);
                           } else if (Transf.equalsIgnoreCase("3")) {
                              this.Transferencia = "3";
                              conf.Tarjeta.setSelected(false);
                              conf.Bluetooth.setSelected(false);
                              conf.TRServidor.setSelected(true);
                              conf.TRLocal.setSelected(false);
                              conf.Cabv3.setSelected(false);
                           } else if (Transf.equalsIgnoreCase("4")) {
                              this.Transferencia = "4";
                              conf.Tarjeta.setSelected(false);
                              conf.Bluetooth.setSelected(false);
                              conf.TRServidor.setSelected(false);
                              conf.TRLocal.setSelected(true);
                              conf.Cabv3.setSelected(false);
                           } else {
                              this.Transferencia = "5";
                              conf.Tarjeta.setSelected(false);
                              conf.Bluetooth.setSelected(false);
                              conf.TRServidor.setSelected(false);
                              conf.TRLocal.setSelected(false);
                              conf.Cabv3.setSelected(true);
                           }

                           this.Chapa.setText(movil);
                           this.Numero.setText(num);
                           this.Indice.setText(Ind);
                           this.chapa = movil;
                           this.Consumo = Double.parseDouble(Ind);
                           this.ConsumoTec = Double.parseDouble(IndTec);
                           this.NumeroVehiculo = num;
                           this.IdConductor = Integer.parseInt(IDCond);
                           this.IdConductorAux = Integer.parseInt(IDCondAux);
                           this.idcombustible = Integer.parseInt(IDCombustible);
                           this.idcombustible_Tec = Integer.parseInt(IDCombustibleTec);
                           this.capacTanque = Integer.parseInt(Capacidad);
                           this.capacTanqueTec = Integer.parseInt(CapacidadTec);
                           this.OriginalSize = Long.parseLong(OriginalS);
                           this.Fichero_a_Transferir = movil + ".log";
                           String camino = File_to_Transfer.getPath();
                           this.path = File_to_Transfer.getPath();
                           this.por_transferir = new File(camino);
                           int cambio = false;
                           if (Double.parseDouble(this.Indice.getText()) == -1.0D) {
                              if (!this.Cambio_de_Indice(this.Chapa.getText(), this.Numero.getText())) {
                                 String msg = "Esta Trayectoria no se puede Transferir. El Indice de Consumo <br/>no se ha Establecido.Póngase en Contacto con el Jefe de <br/>Grupo Provincial.";
                                 this.ShowMessage(msg, "Error", "Error");
                              } else {
                                 cambio = true;
                              }
                           }

                           if (Double.parseDouble(this.Indice.getText()) > 0.0D || cambio) {
                              this.Listo_para_Transferir = true;
                              this.selecciono_moviles = true;
                           }
                        } catch (Exception var45) {
                           String msg = "El Fichero de Configuración de esta Trayectoria no se puede cargar con esta<br/>Versión de Diferido. Utilice una Versión anterior para cargar los datos de<br/>la misma. La Aplicación se Cerrará.";
                           this.ShowMessage(msg, "Error", "Error");
                           System.exit(0);
                        }
                     } else {
                        String msg = "No es posible Encontrar el Fichero " + salva.getAbsolutePath() + "<br/>" + "Es posible que haya sido Borrado o Eliminado. Póngase en Contacto con el Jefe " + "<br/>" + "de Grupo para Solucionar este Problema.";
                        this.ShowMessage(msg, "Error", "Error");
                        this.PB.setVisible(false);
                        this.PBLabel.setVisible(false);
                     }
                  } else {
                     String msg = "Formato de Fichero Incorrecto. El Fichero debe tener<br/>la estructuta: chapa.log";
                     this.ShowMessage(msg, "Error", "Error");
                     this.ChequearPorTransferir();
                  }
               }
            } else {
               this.Chapa.setText("");
               this.Numero.setText("");
               this.Indice.setText("");
            }
         } else {
            this.hay_ficheros_sin_transferir = false;
         }
      }

   }

   public boolean Cambio_de_Indice(String ch, String num) throws SAXException, IOException {
      try {
         DOMParser parser = new DOMParser();
         String respuesta = this.Decrypt(this.encript, "TableID.xml");
         InputSource TableID = new InputSource(new StringReader(respuesta));
         parser.parse(TableID);
         Document doc = parser.getDocument();
         Node Datos_Carro = null;
         String Chapaxml = null;
         String Numeroxml = null;
         String Consumoxml = null;
         NodeList Lista_Carros = doc.getElementsByTagName("ROW");
         int cant_carros = Lista_Carros.getLength();

         for(int i = 0; i < cant_carros; ++i) {
            Chapaxml = Lista_Carros.item(i).getAttributes().getNamedItem("CHAPA").getNodeValue();
            Numeroxml = Lista_Carros.item(i).getAttributes().getNamedItem("Numero").getNodeValue();
            Consumoxml = Lista_Carros.item(i).getAttributes().getNamedItem("Consumo").getNodeValue();
            if (Chapaxml.equalsIgnoreCase(ch) && Numeroxml.equalsIgnoreCase(num) && Double.parseDouble(Consumoxml) > 0.0D) {
               return true;
            }
         }
      } catch (Exception var14) {
         this.ShowMessage("Se Produjo un Error Accediendo a la Lista de Vehículos.<br/> Por favor, inténtelo de nuevo.", "Error", "Error");
      }

      return false;
   }

   public boolean ComprimirTrayectoria() {
      File FilePath = null;
      File[] roots = File.listRoots();
      int ban = false;

      for(int i = 0; i < roots.length; ++i) {
         String dir = roots[i].toString();
         this.path = dir + "kijo.log";
         if (!this.path.equalsIgnoreCase("A:\\kijo.log") && !this.path.equalsIgnoreCase("C:\\kijo.log") && !this.path.equalsIgnoreCase("D:\\kijo.log")) {
            FilePath = new File(this.path);
            if (FilePath.exists()) {
               this.Kijo_en_Flash = true;
               ban = true;
               this.extraible = true;
               break;
            }
         }
      }

      if (!ban) {
         this.PB.setVisible(false);
         this.PBLabel.setVisible(false);
         this.Kijo_en_Flash = false;
         this.path = null;
         this.extraible = false;
         File f = new File("Datos de las Trayectorias");
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setCurrentDirectory(f);
         fileChooser.setFileFilter(new LogFilter());
         int seleccion = fileChooser.showOpenDialog(this);
         if (seleccion != 0) {
            this.PB.setVisible(false);
            this.PBLabel.setVisible(false);
            this.en_ejecucion = false;
            return false;
         }

         this.path = fileChooser.getSelectedFile().getAbsolutePath();
         FilePath = new File(this.path);
      }

      if (this.path == null) {
         return false;
      } else {
         if (FilePath.exists()) {
            this.Size = FilePath.length();
            String fecha = this.fechaservidorinicial.substring(8, 10) + "_" + this.fechaservidorinicial.substring(5, 7) + "_" + this.fechaservidorinicial.substring(0, 4);
            this.Crear_Carpeta("Datos de las Trayectorias");
            this.Crear_Carpeta("Datos de las Trayectorias\\Salvas Originales");
            this.Crear_Carpeta("Datos de las Trayectorias\\Transferidas");
            this.Crear_Carpeta("Datos de las Trayectorias\\Por Transferir");
            this.Crear_Carpeta("Datos de las Trayectorias\\Por Transferir\\Tarjeta");
            this.Camino_Salvas_Originales = "Datos de las Trayectorias\\Salvas Originales\\" + fecha;
            if (this.Kijo_en_Flash) {
               this.PBLabel.setText("Comprimiendo Trayectoria...");
               this.PB.setVisible(true);
               this.PBLabel.setVisible(true);
               int existe = false;
               if (this.chapa.equalsIgnoreCase("")) {
                  this.chapa = this.Chapa.getText();
               }

               String fichero;
               if (this.Crear_Carpeta(this.Camino_Salvas_Originales) && ban) {
                  fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + ".zip";
                  File sfichero = new File(fichero);
                  if (sfichero.exists()) {
                     existe = true;
                     int i = 1;

                     while(true) {
                        String nuevo_fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + "(" + i + ")" + ".zip";
                        File nuevo_fich = new File(nuevo_fichero);
                        if (!nuevo_fich.exists()) {
                           try {
                              nuevo_fich.createNewFile();
                              this.Comprimir(this.path, nuevo_fichero, "Kijo.log");
                              this.SalvasOriginales = this.chapa + "(" + i + ")" + ".zip";
                           } catch (IOException var14) {
                              this.ShowMessage("No fue Posible Crear el Fichero.", "Información", "Information");
                           }
                           break;
                        }

                        ++i;
                     }
                  } else {
                     try {
                        sfichero.createNewFile();
                        this.Comprimir(this.path, fichero, "Kijo.log");
                        this.SalvasOriginales = this.chapa;
                     } catch (IOException var13) {
                        this.ShowMessage("No fue Posible Crear el Fichero.", "Información", "Information");
                     }
                  }
               } else {
                  try {
                     fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + ".zip";
                     this.Comprimir(this.path, fichero, "Kijo.log");
                     this.SalvasOriginales = this.chapa;
                  } catch (Exception var12) {
                     this.ShowMessage("No fue Posible Comprimir el Fichero.", "Información", "Information");
                  }
               }
            }
         }

         return true;
      }
   }

   public boolean ComprimirTrayectoriaGPSE() {
      File FilePath = null;
      int ban = false;
      if (!ban) {
         this.Kijo_en_PS = false;
         this.path = null;
         this.PB.setVisible(false);
         this.PBLabel.setVisible(false);
         File f = new File("Datos de las Trayectorias");
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setCurrentDirectory(f);
         fileChooser.setFileFilter(new LogFilter());
         int seleccion = fileChooser.showOpenDialog(this);
         if (seleccion != 0) {
            this.PB.setVisible(false);
            this.PBLabel.setVisible(false);
            this.en_ejecucion = false;
            return false;
         }

         this.path = fileChooser.getSelectedFile().getAbsolutePath();
         FilePath = new File(this.path);
      }

      if (this.path == null) {
         return false;
      } else {
         if (FilePath.exists()) {
            this.Size = FilePath.length();
            String fecha = this.fechaservidorinicial.substring(8, 10) + "_" + this.fechaservidorinicial.substring(5, 7) + "_" + this.fechaservidorinicial.substring(0, 4);
            this.Crear_Carpeta("Datos de las Trayectorias");
            this.Crear_Carpeta("Datos de las Trayectorias\\Salvas Originales");
            this.Crear_Carpeta("Datos de las Trayectorias\\Transferidas");
            this.Crear_Carpeta("Datos de las Trayectorias\\Por Transferir");
            this.Crear_Carpeta("Datos de las Trayectorias\\Por Transferir\\Bluetooth");
            this.Camino_Salvas_Originales = "Datos de las Trayectorias\\Salvas Originales\\" + fecha;
            if (this.Kijo_en_PS) {
               this.PBLabel.setText("Comprimiendo Trayectoria...");
               this.PB.setVisible(true);
               this.PBLabel.setVisible(true);
               int existe = false;
               if (this.chapa.equalsIgnoreCase("")) {
                  this.chapa = this.Chapa.getText();
               }

               String fichero;
               if (this.Crear_Carpeta(this.Camino_Salvas_Originales) && ban) {
                  fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + ".zip";
                  File sfichero = new File(fichero);
                  if (sfichero.exists()) {
                     existe = true;
                     int i = 1;

                     while(true) {
                        String nuevo_fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + "(" + i + ")" + ".zip";
                        File nuevo_fich = new File(nuevo_fichero);
                        if (!nuevo_fich.exists()) {
                           try {
                              nuevo_fich.createNewFile();
                              this.Comprimir(this.path, nuevo_fichero, "Kijo.log");
                              this.SalvasOriginales = this.chapa + "(" + i + ")" + ".zip";
                           } catch (IOException var13) {
                              this.ShowMessage("No fue Posible Crear el Fichero.", "Información", "Information");
                           }
                           break;
                        }

                        ++i;
                     }
                  } else {
                     try {
                        sfichero.createNewFile();
                        this.Comprimir(this.path, fichero, "Kijo.log");
                        this.SalvasOriginales = this.chapa;
                     } catch (IOException var12) {
                        this.ShowMessage("No fue Posible Crear el Fichero.", "Información", "Information");
                     }
                  }
               } else {
                  try {
                     fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + ".zip";
                     this.Comprimir(this.path, fichero, "Kijo.log");
                     this.SalvasOriginales = this.chapa;
                  } catch (Exception var11) {
                     this.ShowMessage("No fue Posible Comprimir el Fichero.", "Información", "Information");
                  }
               }
            }
         }

         return true;
      }
   }

   public boolean ComprimirTrayectoriaTReal() {
      int ban = false;
      if (ban) {
         this.ShowMessage("Existen Trayectorias por Eliminar para el Móvil " + this.chapa + "<br/>" + " Intente la Transferencia más Tarde.", "Información", "Information");
         System.exit(0);
         return false;
      } else {
         boolean descargaTReal = this.Descargar_Trayectoria_gz();
         if (descargaTReal) {
            String fecha = this.fechaservidorinicial.substring(8, 10) + "_" + this.fechaservidorinicial.substring(5, 7) + "_" + this.fechaservidorinicial.substring(0, 4);
            this.Crear_Carpeta("Datos de las Trayectorias");
            this.Crear_Carpeta("Datos de las Trayectorias\\Salvas Originales");
            this.Crear_Carpeta("Datos de las Trayectorias\\Transferidas");
            this.Crear_Carpeta("Datos de las Trayectorias\\Por Transferir");
            this.Crear_Carpeta("Datos de las Trayectorias\\Por Transferir\\TReal");
            this.Camino_Salvas_Originales = "Datos de las Trayectorias\\Salvas Originales\\" + fecha;
            this.PBLabel.setText("Comprimiendo Trayectoria...");
            this.PB.setVisible(true);
            this.PBLabel.setVisible(true);
            int existe = false;
            if (this.chapa.equalsIgnoreCase("")) {
               this.chapa = this.Chapa.getText();
            }

            String fichero;
            if (this.Crear_Carpeta(this.Camino_Salvas_Originales)) {
               fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + ".zip";
               File sfichero = new File(fichero);
               if (sfichero.exists()) {
                  existe = true;
                  int i = 1;

                  while(true) {
                     String nuevo_fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + "(" + i + ")" + ".zip";
                     File nuevo_fich = new File(nuevo_fichero);
                     if (!nuevo_fich.exists()) {
                        try {
                           nuevo_fich.createNewFile();
                           System.out.print("\nComenzando Compresión");
                           this.Comprimir(this.path, nuevo_fichero, "Kijo.log");
                           this.SalvasOriginales = this.chapa + "(" + i + ")" + ".zip";
                           System.out.print("\nCompresión Finalizada con éxito");
                        } catch (IOException var13) {
                           this.ShowMessage("No fue posible crear el Fichero.", "Información", "Information");
                        }
                        break;
                     }

                     ++i;
                  }
               } else {
                  try {
                     sfichero.createNewFile();
                     System.out.print("\nComenzando Compresión");
                     this.Comprimir(this.path, fichero, "Kijo.log");
                     this.SalvasOriginales = this.chapa;
                     System.out.print("\nCompresión Finalizada con éxito");
                  } catch (IOException var12) {
                     this.ShowMessage("No fue posible crear el Fichero.", "Información", "Information");
                  }
               }
            } else {
               try {
                  fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + ".zip";
                  this.Comprimir(this.path, fichero, "Kijo.log");
                  this.SalvasOriginales = this.chapa;
               } catch (Exception var11) {
                  this.ShowMessage("No fue posible Comprimir el Fichero.", "Información", "Information");
               }
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public boolean ComprimirTrayectoriaTRLocal() {
      File FilePath = null;
      int ban = false;
      if (!ban) {
         this.Kijo_en_PS = false;
         this.path = null;
         this.PB.setVisible(false);
         this.PBLabel.setVisible(false);
         File f = new File("Datos de las Trayectorias");
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setCurrentDirectory(f);
         fileChooser.setFileFilter(new LogFilter());
         int seleccion = fileChooser.showOpenDialog(this);
         if (seleccion != 0) {
            this.PB.setVisible(false);
            this.PBLabel.setVisible(false);
            this.en_ejecucion = false;
            return false;
         }

         this.path = fileChooser.getSelectedFile().getAbsolutePath();
         FilePath = new File(this.path);
      }

      if (this.path != null) {
         if (FilePath.exists()) {
            String fecha = this.fechaservidorinicial.substring(8, 10) + "_" + this.fechaservidorinicial.substring(5, 7) + "_" + this.fechaservidorinicial.substring(0, 4);
            this.Crear_Carpeta("Datos de las Trayectorias");
            this.Crear_Carpeta("Datos de las Trayectorias\\Salvas Originales");
            this.Crear_Carpeta("Datos de las Trayectorias\\Transferidas");
            this.Crear_Carpeta("Datos de las Trayectorias\\Por Transferir");
            this.Crear_Carpeta("Datos de las Trayectorias\\Por Transferir\\TReal");
            this.Camino_Salvas_Originales = "Datos de las Trayectorias\\Salvas Originales\\" + fecha;
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean ComprimirTrayectoriaCabv3() {
      File FilePath = null;
      int ban = false;
      if (!ban) {
         this.Kijo_en_PS = false;
         this.path = null;
         this.PB.setVisible(false);
         this.PBLabel.setVisible(false);
         File f = new File("Datos de las Trayectorias");
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setCurrentDirectory(f);
         fileChooser.setFileFilter(new LogFilter());
         int seleccion = fileChooser.showOpenDialog(this);
         if (seleccion != 0) {
            this.PB.setVisible(false);
            this.PBLabel.setVisible(false);
            this.en_ejecucion = false;
            return false;
         }

         this.path = fileChooser.getSelectedFile().getAbsolutePath();
         FilePath = new File(this.path);
      }

      if (this.path == null) {
         return false;
      } else {
         if (FilePath.exists()) {
            this.Size = FilePath.length();
            String fecha = this.fechaservidorinicial.substring(8, 10) + "_" + this.fechaservidorinicial.substring(5, 7) + "_" + this.fechaservidorinicial.substring(0, 4);
            this.Crear_Carpeta("Datos de las Trayectorias");
            this.Crear_Carpeta("Datos de las Trayectorias\\Salvas Originales");
            this.Crear_Carpeta("Datos de las Trayectorias\\Transferidas");
            this.Crear_Carpeta("Datos de las Trayectorias\\Por Transferir");
            this.Crear_Carpeta("Datos de las Trayectorias\\Por Transferir\\Cabv3");
            this.Camino_Salvas_Originales = "Datos de las Trayectorias\\Salvas Originales\\" + fecha;
            if (this.Kijo_en_PS) {
               this.PBLabel.setText("Comprimiendo Trayectoria...");
               this.PB.setVisible(true);
               this.PBLabel.setVisible(true);
               int existe = false;
               if (this.chapa.equalsIgnoreCase("")) {
                  this.chapa = this.Chapa.getText();
               }

               String fichero;
               if (this.Crear_Carpeta(this.Camino_Salvas_Originales) && ban) {
                  fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + ".zip";
                  File sfichero = new File(fichero);
                  if (sfichero.exists()) {
                     existe = true;
                     int i = 1;

                     while(true) {
                        String nuevo_fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + "(" + i + ")" + ".zip";
                        File nuevo_fich = new File(nuevo_fichero);
                        if (!nuevo_fich.exists()) {
                           try {
                              nuevo_fich.createNewFile();
                              this.Comprimir(this.path, nuevo_fichero, "Kijo.log");
                              this.SalvasOriginales = this.chapa + "(" + i + ")" + ".zip";
                           } catch (IOException var13) {
                              this.ShowMessage("No fue Posible Crear el Fichero.", "Información", "Information");
                           }
                           break;
                        }

                        ++i;
                     }
                  } else {
                     try {
                        sfichero.createNewFile();
                        this.Comprimir(this.path, fichero, "Kijo.log");
                        this.SalvasOriginales = this.chapa;
                     } catch (IOException var12) {
                        this.ShowMessage("No fue Posible Crear el Fichero.", "Información", "Information");
                     }
                  }
               } else {
                  try {
                     fichero = this.Camino_Salvas_Originales + "\\" + this.chapa + ".zip";
                     this.Comprimir(this.path, fichero, "Kijo.log");
                     this.SalvasOriginales = this.chapa;
                  } catch (Exception var11) {
                     this.ShowMessage("No fue Posible Comprimir el Fichero.", "Información", "Information");
                  }
               }
            }
         }

         return true;
      }
   }

   public boolean ComprobarVelocidad(double velocidad) {
      return velocidad * 1.852D > 2.0D;
   }

   public void MoverTrayectoria(File origen, File destino) throws FileNotFoundException, IOException {
      FileInputStream fis = new FileInputStream(origen);
      FileOutputStream fos = new FileOutputStream(destino);
      FileChannel canalorigen = fis.getChannel();
      FileChannel canaldestino = fos.getChannel();
      canalorigen.transferTo(0L, canalorigen.size(), canaldestino);
      fis.close();
      fos.close();
   }

   public double Distancia(double lon1, double lat1, double lon2, double lat2) {
      double DG = Math.abs(lon2 - lon1);
      double DL = Math.abs(lat2 - lat1);
      double term1 = 111.08956D * (DL + 1.0E-6D);
      double term2 = Math.cos((lat1 + DL / 2.0D) * 3.141592653589793D / 180.0D);
      double term3 = (DG + 1.0E-6D) / (DL + 1.0E-6D);
      double dist = term1 / Math.cos(Math.atan(term2 * term3)) * 1000.0D;
      return dist;
   }

   public void Insertar_fichero(String linea, File fichero) {
      try {
         FileWriter fw = new FileWriter(fichero, true);
         fw.write(linea);
         fw.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   public void ComprobarFechaHora(String FI, String HI, int tipo) {
      int h = Integer.parseInt(HI.substring(0, 2));
      String min = HI.substring(3, 5);
      String seg = HI.substring(6, 8);
      if (this.Transferencia.compareTo("3") != 0 && this.Transferencia.compareTo("4") != 0) {
         if (this.HorarioVerano) {
            h -= 4;
         } else {
            h -= 5;
         }
      }

      if (h < 0) {
         h += 24;
         int d = Integer.parseInt(FI.substring(0, 2));
         int m = Integer.parseInt(FI.substring(3, 5)) - 1;
         int y = Integer.parseInt(FI.substring(6, 8)) + 100;
         Date fi = new Date(y, m, d);
         long diferencia = fi.getTime();
         diferencia -= 86400000L;
         Date date = new Date(diferencia);
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
         String s5 = formato.format(date);
         d = Integer.parseInt(s5.substring(0, 2));
         String mes = s5.substring(3, 5);
         String year = s5.substring(6, 8);
         if (tipo == 1) {
            if (d < 10) {
               this.Fecha_Inicial = "0" + d + "/" + mes + "/" + year;
            } else {
               this.Fecha_Inicial = d + "/" + mes + "/" + year;
            }
         } else if (tipo == 2) {
            if (d < 10) {
               this.Fecha_Final = "0" + d + "/" + mes + "/" + year;
            } else {
               this.Fecha_Final = d + "/" + mes + "/" + year;
            }
         }
      }

      if (tipo == 1) {
         if (h < 10) {
            this.Hora_Inicial = "0" + h + ":" + min + ":" + seg;
         } else {
            this.Hora_Inicial = h + ":" + min + ":" + seg;
         }
      } else if (tipo == 2) {
         if (h < 10) {
            this.Hora_Final = "0" + h + ":" + min + ":" + seg;
         } else {
            this.Hora_Final = h + ":" + min + ":" + seg;
         }
      }

   }

   private double Convertir_Coordenadas(String c, int tipo) {
      String gg;
      String min;
      String seg;
      if (tipo == 1) {
         gg = c.substring(0, 2);
         min = c.substring(2, 4);
         seg = "0." + c.substring(5, c.length());
      } else {
         gg = c.substring(0, 3);
         min = c.substring(3, 5);
         seg = "0." + c.substring(6, c.length());
      }

      double g = (double)Integer.parseInt(gg);
      double m = (double)Integer.parseInt(min);
      double s = (double)Float.parseFloat(seg);
      return g > 0.0D ? g + (m + s) / 60.0D : g - (m + s) / 60.0D;
   }

   public void Copiar_fichero_para_Transferida(String shp_compacto) throws FileNotFoundException, IOException {
      String Carpeta_fecha = this.fechaservidorinicial.substring(8, 10) + "_" + this.fechaservidorinicial.substring(5, 7) + "_" + this.fechaservidorinicial.substring(0, 4);
      String dir = "Datos de las Trayectorias\\Transferidas\\" + Carpeta_fecha;
      File destino = new File(dir);
      destino.mkdir();
      File shp = new File(shp_compacto);
      String nuevadir = dir + "\\" + this.logid + ".gz";
      File nuevo = new File(nuevadir);
      String nuevo_fichero = "";
      boolean existe = false;
      new Funciones();
      if (!nuevo.exists()) {
         nuevo.createNewFile();
         if (!shp.renameTo(nuevo)) {
            this.MoverTrayectoria(shp, nuevo);
         }

         String Por_Transferir = this.por_transferir.getAbsolutePath();
         if (this.por_transferir.exists()) {
            this.por_transferir.delete();
         }
      }

   }

   public int Falta_de_Tramas(String dia_actual, String hora_actual, String dia_anterior, String Hora_Anterior) {
      if (!hora_actual.equalsIgnoreCase("235957") && !Hora_Anterior.equalsIgnoreCase("235957") && !hora_actual.equalsIgnoreCase("235958") && !Hora_Anterior.equalsIgnoreCase("235958") && !hora_actual.equalsIgnoreCase("235959") && !Hora_Anterior.equalsIgnoreCase("235959") && !hora_actual.equalsIgnoreCase("000000") && !Hora_Anterior.equalsIgnoreCase("000000") && !hora_actual.equalsIgnoreCase("000001") && !Hora_Anterior.equalsIgnoreCase("000001") && !hora_actual.equalsIgnoreCase("000002") && !Hora_Anterior.equalsIgnoreCase("000002")) {
         if (Hora_Anterior.equalsIgnoreCase("")) {
            return 1;
         } else {
            int d1 = Integer.parseInt(dia_actual.substring(0, 2));
            int m1 = Integer.parseInt(dia_actual.substring(2, 4)) - 1;
            int y1 = Integer.parseInt(dia_actual.substring(4, 6)) + 100;
            int h_act = Integer.parseInt(hora_actual.substring(0, 2));
            int min_act = Integer.parseInt(hora_actual.substring(2, 4));
            int seg_act = Integer.parseInt(hora_actual.substring(4, 6));
            Date actual = new Date(y1, m1, d1, h_act, min_act, seg_act);
            int d2 = Integer.parseInt(dia_anterior.substring(0, 2));
            int m2 = Integer.parseInt(dia_anterior.substring(2, 4)) - 1;
            int y2 = Integer.parseInt(dia_anterior.substring(4, 6)) + 100;
            int h = Integer.parseInt(Hora_Anterior.substring(0, 2));
            int min = Integer.parseInt(Hora_Anterior.substring(2, 4));
            int seg = Integer.parseInt(Hora_Anterior.substring(4, 6));
            Date anterior = new Date(y2, m2, d2, h, min, seg);
            long actuallong = actual.getTime();
            long anteriorlong = anterior.getTime();
            long diferencia = (actuallong - anteriorlong) / 1000L;
            if (diferencia >= 0L && diferencia <= 60L) {
               return 1;
            } else {
               return diferencia < 0L ? -1 : 0;
            }
         }
      } else {
         return 1;
      }
   }

   public int Falta_de_TramasGPSE(String dia_actual, String hora_actual, String dia_anterior, String Hora_Anterior) {
      if (!hora_actual.equalsIgnoreCase("235957") && !Hora_Anterior.equalsIgnoreCase("235957") && !hora_actual.equalsIgnoreCase("235958") && !Hora_Anterior.equalsIgnoreCase("235958") && !hora_actual.equalsIgnoreCase("235959") && !Hora_Anterior.equalsIgnoreCase("235959") && !hora_actual.equalsIgnoreCase("000000") && !Hora_Anterior.equalsIgnoreCase("000000") && !hora_actual.equalsIgnoreCase("000001") && !Hora_Anterior.equalsIgnoreCase("000001") && !hora_actual.equalsIgnoreCase("000002") && !Hora_Anterior.equalsIgnoreCase("000002")) {
         if (Hora_Anterior.equalsIgnoreCase("")) {
            return 1;
         } else {
            int d1 = Integer.parseInt(dia_actual.substring(0, 2));
            int m1 = Integer.parseInt(dia_actual.substring(2, 4)) - 1;
            int y1 = Integer.parseInt(dia_actual.substring(4, 6)) + 100;
            int h_act = Integer.parseInt(hora_actual.substring(0, 2));
            int min_act = Integer.parseInt(hora_actual.substring(2, 4));
            int seg_act = Integer.parseInt(hora_actual.substring(4, 6));
            Date actual = new Date(y1, m1, d1, h_act, min_act, seg_act);
            int d2 = Integer.parseInt(dia_anterior.substring(0, 2));
            int m2 = Integer.parseInt(dia_anterior.substring(2, 4)) - 1;
            int y2 = Integer.parseInt(dia_anterior.substring(4, 6)) + 100;
            int h = Integer.parseInt(Hora_Anterior.substring(0, 2));
            int min = Integer.parseInt(Hora_Anterior.substring(2, 4));
            int seg = Integer.parseInt(Hora_Anterior.substring(4, 6));
            Date anterior = new Date(y2, m2, d2, h, min, seg);
            long actuallong = actual.getTime();
            long anteriorlong = anterior.getTime();
            long diferencia = (actuallong - anteriorlong) / 1000L;
            if (diferencia >= 0L && diferencia <= 300L) {
               return 1;
            } else {
               return diferencia < 0L ? -1 : 0;
            }
         }
      } else {
         return 1;
      }
   }

   public int Falta_de_TramasTReal(String dia_actual, String hora_actual, String dia_anterior, String Hora_Anterior) {
      if (!hora_actual.equalsIgnoreCase("235957") && !Hora_Anterior.equalsIgnoreCase("235957") && !hora_actual.equalsIgnoreCase("235958") && !Hora_Anterior.equalsIgnoreCase("235958") && !hora_actual.equalsIgnoreCase("235959") && !Hora_Anterior.equalsIgnoreCase("235959") && !hora_actual.equalsIgnoreCase("000000") && !Hora_Anterior.equalsIgnoreCase("000000") && !hora_actual.equalsIgnoreCase("000001") && !Hora_Anterior.equalsIgnoreCase("000001") && !hora_actual.equalsIgnoreCase("000002") && !Hora_Anterior.equalsIgnoreCase("000002")) {
         if (Hora_Anterior.equalsIgnoreCase("")) {
            return 1;
         } else {
            int d1 = Integer.parseInt(dia_actual.substring(0, 2));
            int m1 = Integer.parseInt(dia_actual.substring(2, 4)) - 1;
            int y1 = Integer.parseInt(dia_actual.substring(4, 6)) + 100;
            int h_act = Integer.parseInt(hora_actual.substring(0, 2));
            int min_act = Integer.parseInt(hora_actual.substring(2, 4));
            int seg_act = Integer.parseInt(hora_actual.substring(4, 6));
            Date actual = new Date(y1, m1, d1, h_act, min_act, seg_act);
            int d2 = Integer.parseInt(dia_anterior.substring(0, 2));
            int m2 = Integer.parseInt(dia_anterior.substring(2, 4)) - 1;
            int y2 = Integer.parseInt(dia_anterior.substring(4, 6)) + 100;
            int h = Integer.parseInt(Hora_Anterior.substring(0, 2));
            int min = Integer.parseInt(Hora_Anterior.substring(2, 4));
            int seg = Integer.parseInt(Hora_Anterior.substring(4, 6));
            Date anterior = new Date(y2, m2, d2, h, min, seg);
            long actuallong = actual.getTime();
            long anteriorlong = anterior.getTime();
            long diferencia = (actuallong - anteriorlong) / 1000L;
            if (diferencia >= 0L && diferencia <= 300L) {
               return 1;
            } else {
               return diferencia < 0L ? -1 : 0;
            }
         }
      } else {
         return 1;
      }
   }

   public void LeerTrayectoria() throws FileNotFoundException, IOException, SAXException, ParseException, AWTException, InterruptedException, Exception {
      String Msg = "";
      if (this.AnalizarTrayectoria() && !this.indice0) {
         if (this.Transferir_Fichero(this.por_transferir)) {
            this.ComprobarFechaHora(this.Fecha_Final, this.Hora_Final, 2);
            this.PB.setVisible(false);
            this.PBLabel.setVisible(false);
            Datos_Hoja_de_Ruta hr = new Datos_Hoja_de_Ruta(this);
            hr.MostrarDatos();
         } else {
            this.LimpiarCampos();
         }
      }

   }

   public void LeerTrayectoriaGPSE() throws FileNotFoundException, IOException, SAXException, ParseException, AWTException, InterruptedException, Exception {
      String Msg = "";
      if (this.AnalizarTrayectoriaGPSE() && !this.indice0) {
         if (this.Transferir_FicheroGPSE(this.por_transferir)) {
            Datos_Hoja_de_Ruta hr;
            if (!this.isActualDate(this.Fecha_Final, this.Hora_Final, this.fecha_hora)) {
               this.ShowMessage("La Fecha Final de la Trayectoria es Mayor que la Fecha Actual.<br/>Verifíquela", "Información", "Information");
               this.ComprobarFechaHora(this.Fecha_Final, this.Hora_Final, 2);
               this.PB.setVisible(false);
               this.PBLabel.setVisible(false);
               hr = new Datos_Hoja_de_Ruta(this);
               hr.MostrarDatos();
            }

            this.ComprobarFechaHora(this.Fecha_Final, this.Hora_Final, 2);
            this.PB.setVisible(false);
            this.PBLabel.setVisible(false);
            hr = new Datos_Hoja_de_Ruta(this);
            hr.MostrarDatos();
         } else {
            this.LimpiarCampos();
         }
      }

   }

   public void LeerTrayectoriaTReal() throws FileNotFoundException, IOException, SAXException, ParseException, AWTException, InterruptedException, Exception {
      String Msg = "";
      if (this.AnalizarTrayectoriaTReal()) {
         if (this.Transferir_FicheroTReal(this.por_transferir)) {
            Datos_Hoja_de_Ruta hr;
            if (!this.isActualDate(this.Fecha_Final, this.Hora_Final, this.fecha_hora)) {
               this.ShowMessage("La Fecha Final de la Trayectoria es Mayor que la Fecha Actual.<br/>Verifíquela", "Información", "Information");
               this.ComprobarFechaHora(this.Fecha_Final, this.Hora_Final, 2);
               this.PB.setVisible(false);
               this.PBLabel.setVisible(false);
               hr = new Datos_Hoja_de_Ruta(this);
               hr.MostrarDatos();
            }

            this.ComprobarFechaHora(this.Fecha_Final, this.Hora_Final, 2);
            this.PB.setVisible(false);
            this.PBLabel.setVisible(false);
            hr = new Datos_Hoja_de_Ruta(this);
            hr.MostrarDatos();
         } else {
            this.LimpiarCampos();
         }
      }

   }

   public void LeerTrayectoriaCabv3() throws FileNotFoundException, IOException, SAXException, ParseException, AWTException, InterruptedException, Exception {
      String Msg = "";
      if (this.AnalizarTrayectoriaCabv3() && !this.indice0) {
         if (this.Transferir_FicheroCabv3(this.por_transferir)) {
            Datos_Hoja_de_Ruta hr;
            if (!this.isActualDate(this.Fecha_Final, this.Hora_Final, this.fecha_hora)) {
               this.ShowMessage("La Fecha Final de la Trayectoria es Mayor que la Fecha Actual.<br/>Verifíquela", "Información", "Information");
               this.ComprobarFechaHora(this.Fecha_Final, this.Hora_Final, 2);
               this.PB.setVisible(false);
               this.PBLabel.setVisible(false);
               hr = new Datos_Hoja_de_Ruta(this);
               hr.MostrarDatos();
            }

            this.ComprobarFechaHora(this.Fecha_Final, this.Hora_Final, 2);
            this.PB.setVisible(false);
            this.PBLabel.setVisible(false);
            hr = new Datos_Hoja_de_Ruta(this);
            hr.MostrarDatos();
         } else {
            this.LimpiarCampos();
         }
      }

   }

   public boolean SumaControl(String[] partes, int tipo) {
      try {
         String lineasuma = "";
         int Suma = 71;
         int hex;
         int i;
         if (tipo == 22) {
            hex = Integer.parseInt(partes[21].substring(1, 3), 16);

            for(i = 10; i <= 19; ++i) {
               lineasuma = lineasuma + partes[i];
               if (i < 19) {
                  lineasuma = lineasuma + ",";
               }
            }
         } else {
            hex = Integer.parseInt(partes[22].substring(2, 4), 16);

            for(i = 10; i <= 22; ++i) {
               lineasuma = lineasuma + partes[i];
               if (i < 22) {
                  lineasuma = lineasuma + ",";
               }
            }

            i = lineasuma.length();
            lineasuma = lineasuma.substring(0, i - 6);
         }

         int cant = lineasuma.length();

         for(int j = 2; j < cant; ++j) {
            char caracter = lineasuma.charAt(j);
            Suma ^= caracter;
         }

         return Suma == hex;
      } catch (Exception var9) {
         return false;
      }
   }

   public boolean ValidarFecha(String fechax) {
      if (fechax.length() != 6) {
         return false;
      } else {
         try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("ddMMyy");
            formatoFecha.parse(fechax);
            return true;
         } catch (Exception var4) {
            return false;
         }
      }
   }

   public boolean ValidarHora(String hora) {
      try {
         return hora.length() >= 6;
      } catch (Exception var3) {
         return false;
      }
   }

   public int Linea_Cierta(String cierto) {
      if (cierto.equalsIgnoreCase("A")) {
         return 1;
      } else {
         return cierto.equalsIgnoreCase("V") ? 2 : 3;
      }
   }

   public double Redondear_Numero(double numero, int dec) {
      return (double)Math.round(numero * Math.pow(10.0D, (double)dec)) / Math.pow(10.0D, (double)dec);
   }

   public void Crear_Fichero_Salida() {
      String camino = "Temp\\" + this.chapa + ".xml";
      this.transferido = new File(camino);
      if (this.transferido.exists()) {
         int i = 1;

         while(true) {
            camino = "Temp\\" + this.chapa + "(" + i + ")" + ".xml";
            this.transferido = new File(camino);
            if (!this.transferido.exists()) {
               break;
            }

            ++i;
         }
      }

   }

   public long Fin_Fichero(File fichero) throws FileNotFoundException, IOException {
      long longitud = fichero.length();
      long mitad = longitud / 2L;
      long inicio = 0L;
      String linea = "";
      String linea1 = "";
      RandomAccessFile rafile = new RandomAccessFile(fichero, "rw");
      rafile.seek(mitad);
      linea = rafile.readLine();
      rafile.seek(rafile.getFilePointer());
      linea = rafile.readLine();
      if (linea.length() > 150) {
         mitad /= 2L;
      }

      return 2L;
   }

   public long miDate(String fi) {
      long ff_long = 0L;
      long fi_long = 0L;
      Date fecha_final = null;
      Date fecha_inicial = null;
      int initial_year = Integer.parseInt(fi.substring(0, 4).toString()) - 1900;
      int initial_month = Integer.parseInt(fi.substring(6, 7).toString()) - 1;
      int initial_day = Integer.parseInt(fi.substring(8, 10).toString());
      int initial_hour = Integer.parseInt(fi.substring(11, 13).toString());
      int initial_min = Integer.parseInt(fi.substring(14, 16).toString());
      int initial_seg = Integer.parseInt(fi.substring(17, 19).toString());
      fecha_inicial = new Date(initial_year, initial_month, initial_day, initial_hour, initial_min, initial_seg);
      fi_long = fecha_inicial.getTime();
      return fi_long;
   }

   public void Adicionar_Linea_de_la_Trayect_shp(double lat_transformada, double lon_transformada, double pin, double v, String fechahora, int orden, int stopidx, double dist) throws Exception {
      Point point1 = this.shape.geometryFactory.createPoint(new Coordinate(lon_transformada, lat_transformada));
      this.shape.featureBuilder.add(point1);
      this.shape.featureBuilder.add(this.logid);
      this.shape.featureBuilder.add(fechahora);
      this.shape.featureBuilder.add(v);
      this.shape.featureBuilder.add(pin);
      this.shape.featureBuilder.add(orden);
      this.shape.featureBuilder.add(stopidx);
      this.shape.featureBuilder.add(dist);
      this.arraycoord.add(point1.getCoordinate());
      SimpleFeature feature = this.shape.featureBuilder.buildFeature((String)null);
      this.shape.saveFeature(feature);
   }

   public void Adicionar_Linea_shpTarjeta(double lat_transformada, double lon_transformada, double pin, double v, String fechahora, int orden, int stopidx) throws Exception {
      Point point = this.shape.geometryFactory.createPoint(new Coordinate(lon_transformada, lat_transformada));
      this.shape.featureBuilderTarjeta.add(point);
      this.shape.featureBuilderTarjeta.add(this.logid);
      this.shape.featureBuilderTarjeta.add(fechahora);
      this.shape.featureBuilderTarjeta.add(v);
      this.shape.featureBuilderTarjeta.add(pin);
      this.shape.featureBuilderTarjeta.add(orden);
      this.shape.featureBuilderTarjeta.add(stopidx);
      SimpleFeature feature = this.shape.featureBuilderTarjeta.buildFeature((String)null);
      this.shape.saveFeature1(feature);
   }

   public void Adicionar_Linea_shpGPSE(double lat_transformada, double lon_transformada, double pin, double v, String fechahora, int orden, int stopidx, String movim, double dist) throws Exception {
      Point point = this.shape.geometryFactory.createPoint(new Coordinate(lon_transformada, lat_transformada));
      this.shape.featureBuilderGPSE.add(point);
      this.shape.featureBuilderGPSE.add(this.logid);
      this.shape.featureBuilderGPSE.add(fechahora);
      this.shape.featureBuilderGPSE.add(v);
      this.shape.featureBuilderGPSE.add(pin);
      this.shape.featureBuilderGPSE.add(orden);
      this.shape.featureBuilderGPSE.add(stopidx);
      this.shape.featureBuilderGPSE.add(movim);
      this.shape.featureBuilderGPSE.add(dist);
      SimpleFeature feature = this.shape.featureBuilderGPSE.buildFeature((String)null);
      this.shape.saveFeature1(feature);
   }

   public void Adicionar_Linea_shpTReal(double lat_transformada, double lon_transformada, double pin, double v, String fechahora, int orden, int stopidx, double dist) throws Exception {
      Point point = this.shape.geometryFactory.createPoint(new Coordinate(lon_transformada, lat_transformada));
      this.shape.featureBuilderTReal.add(point);
      this.shape.featureBuilderTReal.add(this.logid);
      this.shape.featureBuilderTReal.add(fechahora);
      this.shape.featureBuilderTReal.add(v);
      this.shape.featureBuilderTReal.add(pin);
      this.shape.featureBuilderTReal.add(orden);
      this.shape.featureBuilderTReal.add(stopidx);
      this.shape.featureBuilderTReal.add(dist);
      SimpleFeature feature = this.shape.featureBuilderTReal.buildFeature((String)null);
      this.shape.saveFeature1(feature);
   }

   public void Adicionar_Linea_shpCabv3(double lat_transformada, double lon_transformada, double pin, double v, String fechahora, int orden, int stopidx, String movim, double dist) throws Exception {
      Point point = this.shape.geometryFactory.createPoint(new Coordinate(lon_transformada, lat_transformada));
      this.shape.featureBuilderCabv3.add(point);
      this.shape.featureBuilderCabv3.add(this.logid);
      this.shape.featureBuilderCabv3.add(fechahora);
      this.shape.featureBuilderCabv3.add(v);
      this.shape.featureBuilderCabv3.add(pin);
      this.shape.featureBuilderCabv3.add(orden);
      this.shape.featureBuilderCabv3.add(stopidx);
      this.shape.featureBuilderCabv3.add(movim);
      this.shape.featureBuilderCabv3.add(dist);
      SimpleFeature feature = this.shape.featureBuilderCabv3.buildFeature((String)null);
      this.shape.saveFeature1(feature);
   }

   public void Crear_SHPDetenciones() throws IOException {
      double dist_entre_paradas = 0.0D;
      ArrayList<Point> arraypoint = new ArrayList();
      ArrayList<Point> arraypointdet = new ArrayList();
      this.pointdet = new Point[this.Paradas.size()];
      this.point_tiempdet = new Point[this.Paradas.size()];

      try {
         Iterator it = this.Paradas.iterator();
         double disAnt = -1.0D;

         while(it.hasNext()) {
            Detenciones det = (Detenciones)it.next();
            dist_entre_paradas = disAnt == -1.0D ? 0.0D : det.distancia_acumulada - disAnt;
            disAnt = dist_entre_paradas;
            String chap = det.chapa;
            String fecha_inicio = det.Fecha1;
            String fecha_fin = det.Fecha2;
            long tiempo = (long)det.minutos;
            double distancia = this.Redondear_Numero(det.distancia_acumulada, 2);
            int num_parada = det.registro;
            int simiindex = det.simiindex;
            double lat = det.latitud;
            double lon = det.longitud;
            Point point = this.shape.geometryFactory.createPoint(new Coordinate(lon, lat));
            long fi = this.miDate(fecha_inicio);
            Date f1 = new Date(fi);
            long ff = this.miDate(fecha_fin);
            Date f2 = new Date(ff);
            long diferencia_seg = Math.abs(f2.getTime() - f1.getTime());
            Point point_det = this.shape.geometryFactory.createPoint(new Coordinate((double)f1.getTime(), (double)diferencia_seg));
            arraypoint.add(point);
            arraypointdet.add(point_det);
            this.shape.featureBuilderDet.add(point);
            this.shape.featureBuilderDet.add(this.idusuario);
            this.shape.featureBuilderDet.add(chap);
            this.shape.featureBuilderDet.add(fecha_inicio);
            this.shape.featureBuilderDet.add(fecha_fin);
            this.shape.featureBuilderDet.add(tiempo);
            this.shape.featureBuilderDet.add(this.logid);
            this.shape.featureBuilderDet.add(distancia);
            this.shape.featureBuilderDet.add(num_parada);
            this.shape.featureBuilderDet.add(simiindex);
            SimpleFeature feature = this.shape.featureBuilderDet.buildFeature((String)null);
            this.shape.saveFeature(feature);
         }
      } catch (Exception var33) {
         Logger.getLogger(var33.getMessage());
         var33.printStackTrace();
      }

      this.pointdet = (Point[])arraypoint.toArray(new Point[arraypoint.size()]);
      this.point_tiempdet = (Point[])arraypointdet.toArray(new Point[arraypointdet.size()]);
      this.shape.closeFeatureWriter();
   }

   public void Crear_SHPDesconexiones() throws IOException {
      long fi = 0L;
      long ff = 0L;
      long diferencia_seg = 0L;
      this.cant_dxn_may_5_min = 0L;
      Coordinate[] points = new Coordinate[2];
      ArrayList<LineString> arrayline = new ArrayList();
      ArrayList<Point> arraypointdesc = new ArrayList();
      this.lineStringsdesc = new LineString[this.Desconexiones.size()];
      this.point_tiempdesc = new Point[this.Desconexiones.size()];

      try {
         Iterator it = this.Desconexiones.iterator();

         label50:
         while(true) {
            Date f1;
            Date f2;
            Point point_desc;
            LineString line;
            String chap;
            String fecha_con;
            String fecha_desc;
            int motivo;
            double lat_con;
            double lon_con;
            double lat_des;
            double lon_des;
            SimpleFeature feature;
            do {
               if (!it.hasNext()) {
                  break label50;
               }

               Desconexion descon = (Desconexion)it.next();
               chap = descon.chapa;
               fecha_con = descon.Fecha_Conexion;
               fecha_desc = descon.Fecha_Desconexion;
               long tiempo_des = 0L;
               motivo = descon.motivo;
               lat_con = descon.LatConn;
               lon_con = descon.LonConn;
               lat_des = descon.LatDesc;
               lon_des = descon.LonDesc;
               tiempo_des = this.Tiempo_de_Desconexion(fecha_desc, fecha_con);
               if (tiempo_des / 60L >= 5L) {
                  ++this.cant_dxn_may_5_min;
               }

               if ((motivo == 1 || motivo == 5 || motivo == 6) && tiempo_des / 60L >= 5L) {
                  points[0] = new Coordinate(lon_des, lat_des);
                  points[1] = new Coordinate(lon_con, lat_con);
                  line = this.shape.geometryFactory.createLineString(points);
                  fi = this.miDate(fecha_desc);
                  f1 = new Date(fi);
                  ff = this.miDate(fecha_con);
                  f2 = new Date(ff);
                  diferencia_seg = Math.abs(f2.getTime() - f1.getTime());
                  point_desc = this.shape.geometryFactory.createPoint(new Coordinate((double)f1.getTime(), (double)diferencia_seg, (double)motivo));
                  arraypointdesc.add(point_desc);
                  arrayline.add(line);
                  this.shape.featureBuilderDesc.add(line);
                  this.shape.featureBuilderDesc.add(this.idusuario);
                  this.shape.featureBuilderDesc.add(chap);
                  this.shape.featureBuilderDesc.add(fecha_con);
                  this.shape.featureBuilderDesc.add(fecha_desc);
                  this.shape.featureBuilderDesc.add(motivo);
                  this.shape.featureBuilderDesc.add(this.logid);
                  feature = this.shape.featureBuilderDesc.buildFeature((String)null);
                  this.shape.saveFeature(feature);
               }
            } while(motivo != 0 && motivo != 3 && motivo != 7 && motivo != 8 && motivo != 9);

            points[0] = new Coordinate(lon_des, lat_des);
            points[1] = new Coordinate(lon_con, lat_con);
            line = this.shape.geometryFactory.createLineString(points);
            fi = this.miDate(fecha_desc);
            f1 = new Date(fi);
            ff = this.miDate(fecha_con);
            f2 = new Date(ff);
            diferencia_seg = Math.abs(f2.getTime() - f1.getTime());
            point_desc = this.shape.geometryFactory.createPoint(new Coordinate((double)f1.getTime(), (double)diferencia_seg, (double)motivo));
            arraypointdesc.add(point_desc);
            arrayline.add(line);
            this.shape.featureBuilderDesc.add(line);
            this.shape.featureBuilderDesc.add(this.idusuario);
            this.shape.featureBuilderDesc.add(chap);
            this.shape.featureBuilderDesc.add(fecha_con);
            this.shape.featureBuilderDesc.add(fecha_desc);
            this.shape.featureBuilderDesc.add(motivo);
            this.shape.featureBuilderDesc.add(this.logid);
            feature = this.shape.featureBuilderDesc.buildFeature((String)null);
            this.shape.saveFeature(feature);
         }
      } catch (Exception var31) {
         Logger.getLogger(var31.getMessage());
         var31.printStackTrace();
      }

      this.lineStringsdesc = (LineString[])arrayline.toArray(new LineString[arrayline.size()]);
      this.point_tiempdesc = (Point[])arraypointdesc.toArray(new Point[arraypointdesc.size()]);
      this.shape.closeFeatureWriter();
   }

   public void Crear_SHPViolaciones() throws IOException {
      long fi = 0L;
      long ff = 0L;
      long diferencia_seg = 0L;
      this.cantViolaciones = 0;
      Coordinate[] points = new Coordinate[2];
      ArrayList<LineString> arrayline = new ArrayList();
      ArrayList<Point> arraypointviolac = new ArrayList();
      this.lineStringsviolac = new LineString[this.ViolacionesVelc.size()];
      this.point_tiempviolac = new Point[this.ViolacionesVelc.size()];

      try {
         Iterator it = this.ViolacionesVelc.iterator();
         long tiempo_violacion = 0L;

         while(it.hasNext()) {
            ViolacionVelocidad violacion = (ViolacionVelocidad)it.next();
            String fecha_inc = violacion.FI_Violacion;
            String fecha_fin = violacion.FF_Violacion;
            double lat_con = violacion.LatFinViolacion;
            double lon_con = violacion.LonFinViolacion;
            double lat_des = violacion.LatInicioViolacion;
            double lon_des = violacion.LonInicioViolacion;
            tiempo_violacion = this.Tiempo_de_Desconexion(fecha_inc, fecha_fin);
            double dist = violacion.distancia;
            double velcMax = violacion.velcMax;
            if (tiempo_violacion / 60L >= 1L) {
               ++this.cantViolaciones;
               points[0] = new Coordinate(lon_des, lat_des);
               points[1] = new Coordinate(lon_con, lat_con);
               LineString line = this.shape.geometryFactory.createLineString(points);
               fi = this.miDate(fecha_inc);
               Date f1 = new Date(fi);
               ff = this.miDate(fecha_fin);
               Date f2 = new Date(ff);
               diferencia_seg = Math.abs(f2.getTime() - f1.getTime());
               Point point_desc = this.shape.geometryFactory.createPoint(new Coordinate((double)f1.getTime(), (double)diferencia_seg));
               arraypointviolac.add(point_desc);
               arrayline.add(line);
               this.shape.featureBuilderViolaciones.add(line);
               this.shape.featureBuilderViolaciones.add(this.idusuario);
               this.shape.featureBuilderViolaciones.add(this.chapa);
               this.shape.featureBuilderViolaciones.add(fecha_inc);
               this.shape.featureBuilderViolaciones.add(fecha_fin);
               this.shape.featureBuilderViolaciones.add(tiempo_violacion);
               this.shape.featureBuilderViolaciones.add(this.logid);
               this.shape.featureBuilderViolaciones.add(dist);
               this.shape.featureBuilderViolaciones.add(velcMax);
               SimpleFeature feature = this.shape.featureBuilderViolaciones.buildFeature((String)null);
               this.shape.saveFeature(feature);
            }
         }
      } catch (Exception var33) {
         Logger.getLogger(var33.getMessage());
         var33.printStackTrace();
      }

      this.lineStringsviolac = (LineString[])arrayline.toArray(new LineString[arrayline.size()]);
      this.point_tiempviolac = (Point[])arraypointviolac.toArray(new Point[arraypointviolac.size()]);
      this.shape.closeFeatureWriter();
   }

   public boolean Transferir_Fichero(File por_transferir) throws FileNotFoundException, IOException, ParseException, Exception {
      String camino = "Temp\\SHPTemporal\\Trayectoria.shp";
      this.shp = new File(camino);
      if (this.shp.exists()) {
         this.BorrarDirectorio("Temp\\SHPTemporal");
      }

      this.shape.initFeatureWriterTarjeta(camino);
      BufferedReader reader = new BufferedReader(new FileReader(por_transferir));
      String linea = "";
      String[] partes_de_linea = new String[22];
      boolean Desconexion_de_Kijo = false;
      boolean Desconexion_de_Tarjeta_por_Corriente = false;
      boolean Desconexion_por_Falta_de_Tramas = false;
      boolean Desconexion_datos_no_validos_posicion = false;
      boolean Desconexion_datos_no_validos_satelite = false;
      boolean Desconexion_por_Alterac_de_Voltaj = false;
      boolean vehiculo_detenido = false;
      boolean tramas_no_validas_al_inicio = false;
      boolean tramas_no_validas_al_final = false;
      boolean trama_inicial = false;
      boolean datosV = false;
      boolean salto_posicion = false;
      double v = 0.0D;
      double pin = 0.0D;
      String lon = "";
      String lat = "";
      String dia = "";
      String hora = "";
      String fecha_de_parada = "";
      String hora_de_parada = "";
      double vel_actual = 0.0D;
      double veloc = 0.0D;
      double suma_vel = 0.0D;
      int contador = 0;
      double pin_actual = 0.0D;
      String lon_actual = "";
      String lat_actual = "";
      String dia_actual = "";
      String hora_actual = "";
      String Hora_Anterior = "";
      String Dia_Anterior = "";
      String fecha_desconexion = "";
      String hora_desconexion = "";
      String q = null;
      boolean secuencia_suma_control_fallida = false;
      boolean desconexion_existente = false;
      int trama1 = false;
      String f = "";
      String h = "";
      String fh = "";
      int se_desconecto = false;
      double dist = 0.0D;
      double vel = 0.0D;
      double ang = 0.0D;
      boolean trama_significativa = false;
      boolean salto_fecha = false;
      boolean cambio_estado_desc = false;
      int lc = false;
      int indice_trama = 0;
      double dist_acumulada = 0.0D;
      int stopidx = true;
      int orden = -1;
      boolean violacion = false;
      String fi_violacion = "";
      String ff_violacion = "";
      double velcMaxViolacion = 0.0D;
      String latInicioViolac = "";
      String lonInicioViolac = "";
      double distInicioViolac = 0.0D;
      double distFinViolac = 0.0D;
      this.PBLabel.setText("Procesando Trayectoria...");
      this.PB.setVisible(true);
      this.PBLabel.setVisible(true);
      this.Motivo_Error = 2;
      this.fecha_hora = this.Fecha_Hora_Actual_Servidor();
      String FH = this.fecha_hora.substring(0, 4) + this.fecha_hora.substring(5, 7) + this.fecha_hora.substring(8, 10) + this.fecha_hora.substring(11, 13) + this.fecha_hora.substring(14, 16);
      this.logid = this.Chapa.getText() + FH;
      String var81 = this.Chapa.getText();

      String Mensaje;
      String fcon;
      String fechahora;
      while((linea = reader.readLine()) != null) {
         try {
            ++this.numero_de_lineas;
            if (!linea.equalsIgnoreCase("") && (!linea.equalsIgnoreCase("KIJO00") && !linea.equalsIgnoreCase("KIJO02") && !linea.equalsIgnoreCase("KIJO03") || this.numero_de_lineas >= 10L)) {
               if (this.numero_de_lineas == 2754L) {
                  q = "Quieto";
               }

               int longitud_de_linea = linea.length();
               if (longitud_de_linea != 6 && !linea.equalsIgnoreCase("")) {
                  if (longitud_de_linea > 6 && longitud_de_linea < 130) {
                     partes_de_linea = linea.split(",");
                     if (!trama1 && !trama_inicial) {
                        this.idgps = partes_de_linea[1];
                        dia_actual = this.Asignar(partes_de_linea[19]);
                        hora_actual = this.Asignar(partes_de_linea[11].substring(0, 6));
                        lon_actual = this.Asignar(partes_de_linea[15]);
                        lat_actual = this.Asignar(partes_de_linea[13]);
                        if (dia_actual.length() != 6 || hora_actual.length() != 6) {
                           dia_actual = "";
                           hora_actual = "";
                           ++this.tramas_V_al_inicio;
                           ++this.tramas_simplificadas;
                           continue;
                        }

                        this.Fecha_Inicial = dia_actual.substring(0, 2) + "/" + dia_actual.substring(2, 4) + "/" + dia_actual.substring(4, 6);
                        this.Hora_Inicial = hora_actual.substring(0, 2) + ":" + hora_actual.substring(2, 4) + ":" + hora_actual.substring(4, 6);
                        if (!this.isActualDate(this.Fecha_Inicial, this.Hora_Inicial, this.fecha_hora)) {
                           ++this.tramas_simplificadas;
                           continue;
                        }

                        this.ComprobarFechaHora(this.Fecha_Inicial, this.Hora_Inicial, 1);
                        trama1 = true;
                        this.idgps = partes_de_linea[1];
                        if (this.idgps.contains("\u0000")) {
                           Mensaje = "Esta Trayectoria no se Puede Transferir. Existe una Pérdida<br/>de id del GPS. Póngase en Contacto con el Personal de GCOM<br/>o con el Puesto de Mando de GEOCUBA para Arreglar la Situación.<br/>¿Desea Enviar la Trayectoria para el FTP para que el PAT la Analice?";
                           int n = this.ShowMessageConfirmDialog(Mensaje, "Mensaje de Confirmación", "Confirmación");
                           if (n == 0) {
                              this.Motivo_Error = 3;
                              Error e = new Error(this);
                              e.Mostrar();
                           } else {
                              System.exit(0);
                           }
                        }

                        trama1 = true;
                        trama_inicial = true;
                     }

                     if (hora_actual.equalsIgnoreCase(partes_de_linea[11].substring(0, 6)) && !trama_inicial) {
                        ++this.tramas_simplificadas;
                     } else {
                        int cant_partes = partes_de_linea.length;
                        if ((cant_partes == 22 || cant_partes == 23) && partes_de_linea[0].equalsIgnoreCase("KIJO05")) {
                           if (partes_de_linea[11].substring(0, partes_de_linea[11].lastIndexOf(".")).length() == 6 && partes_de_linea[19].length() == 6) {
                              this.lineas_nulas = 0L;
                              int lc = this.Linea_Cierta(partes_de_linea[12]);
                              f = partes_de_linea[19].substring(0, 2) + "/" + partes_de_linea[19].substring(2, 4) + "/" + partes_de_linea[19].substring(4, 6);
                              h = partes_de_linea[11].substring(0, 2) + ":" + partes_de_linea[11].substring(2, 4) + ":" + partes_de_linea[11].substring(4, 6);
                              fh = f + " " + h;
                              if (!this.isDate(fh)) {
                                 if (lc == 2) {
                                    Desconexion_datos_no_validos_posicion = true;
                                    ++this.tramas_no_validas;
                                 }

                                 ++this.tramas_simplificadas;
                              } else {
                                 if (this.ComparaFecha(this.Fecha_Final, f, this.Hora_Final, h, 2)) {
                                    this.Fecha_Final = f;
                                    this.Hora_Final = h;
                                    if (Desconexion_por_Falta_de_Tramas && salto_fecha) {
                                       Desconexion_por_Falta_de_Tramas = false;
                                    }

                                    salto_fecha = false;
                                 } else {
                                    salto_fecha = true;
                                 }

                                 double latitud_desconexion;
                                 double lon_desconexion;
                                 double latitud_conexion;
                                 double lon_conexion;
                                 Desconexion dk;
                                 String fdesc;
                                 if (Desconexion_de_Kijo) {
                                    if (Desconexion_por_Falta_de_Tramas) {
                                       Desconexion_por_Falta_de_Tramas = false;
                                    }

                                    if (partes_de_linea[13].equalsIgnoreCase("") && partes_de_linea[15].equalsIgnoreCase("")) {
                                       Desconexion_de_Tarjeta_por_Corriente = false;
                                       cambio_estado_desc = true;
                                       ++this.tramas_simplificadas;
                                       continue;
                                    }

                                    fdesc = this.ObtenerFecha(dia_actual, hora_actual, 1);
                                    fcon = this.ObtenerFecha(partes_de_linea[19], partes_de_linea[11].substring(0, 6), 1);
                                    latitud_desconexion = this.Convertir_Coordenadas(lat_actual, 1);
                                    lon_desconexion = -1.0D * this.Convertir_Coordenadas(lon_actual, 2);
                                    latitud_conexion = this.Convertir_Coordenadas(partes_de_linea[13], 1);
                                    lon_conexion = -1.0D * this.Convertir_Coordenadas(partes_de_linea[15], 2);
                                    dk = new Desconexion(this.chapa, fcon, fdesc, latitud_conexion, lon_conexion, latitud_desconexion, lon_desconexion, 0);
                                    this.Desconexiones.add(dk);
                                    Desconexion_de_Kijo = false;
                                    if (Desconexion_de_Tarjeta_por_Corriente) {
                                       dk = new Desconexion(this.chapa, fcon, fdesc, latitud_conexion, lon_conexion, latitud_desconexion, lon_desconexion, 3);
                                       this.Desconexiones.add(dk);
                                       Desconexion_de_Tarjeta_por_Corriente = false;
                                       se_desconecto = true;
                                       cambio_estado_desc = true;
                                    }

                                    if (Desconexion_por_Alterac_de_Voltaj) {
                                       dk = new Desconexion(this.chapa, fcon, fdesc, latitud_conexion, lon_conexion, latitud_desconexion, lon_desconexion, 7);
                                       this.Desconexiones.add(dk);
                                       Desconexion_por_Alterac_de_Voltaj = false;
                                       se_desconecto = true;
                                       cambio_estado_desc = true;
                                    }

                                    dia_actual = this.Asignar(partes_de_linea[19]);
                                    hora_actual = this.Asignar(partes_de_linea[11].substring(0, 6));
                                    lon_actual = this.Asignar(partes_de_linea[15]);
                                    lat_actual = this.Asignar(partes_de_linea[13]);
                                    se_desconecto = true;
                                    cambio_estado_desc = true;
                                 }

                                 if (Desconexion_de_Tarjeta_por_Corriente) {
                                    if (Desconexion_por_Falta_de_Tramas) {
                                       Desconexion_por_Falta_de_Tramas = false;
                                    }

                                    if (lat_actual.equalsIgnoreCase("") && lon_actual.equalsIgnoreCase("")) {
                                       Desconexion_de_Tarjeta_por_Corriente = false;
                                       cambio_estado_desc = true;
                                       ++this.tramas_simplificadas;
                                       continue;
                                    }

                                    fdesc = this.ObtenerFecha(dia_actual, hora_actual, 1);
                                    fcon = this.ObtenerFecha(partes_de_linea[19], partes_de_linea[11].substring(0, 6), 1);
                                    latitud_desconexion = this.Convertir_Coordenadas(lat_actual, 1);
                                    lon_desconexion = -1.0D * this.Convertir_Coordenadas(lon_actual, 2);
                                    latitud_conexion = this.Convertir_Coordenadas(partes_de_linea[13], 1);
                                    lon_conexion = -1.0D * this.Convertir_Coordenadas(partes_de_linea[15], 2);
                                    dk = new Desconexion(this.chapa, fcon, fdesc, latitud_conexion, lon_conexion, latitud_desconexion, lon_desconexion, 3);
                                    this.Desconexiones.add(dk);
                                    Desconexion_de_Tarjeta_por_Corriente = false;
                                    se_desconecto = true;
                                    cambio_estado_desc = true;
                                 }

                                 if (Desconexion_por_Alterac_de_Voltaj) {
                                    if (Desconexion_por_Falta_de_Tramas) {
                                       Desconexion_por_Falta_de_Tramas = false;
                                    }

                                    if (lat_actual.equalsIgnoreCase("") && lon_actual.equalsIgnoreCase("")) {
                                       Desconexion_por_Alterac_de_Voltaj = false;
                                       cambio_estado_desc = true;
                                       ++this.tramas_simplificadas;
                                       continue;
                                    }

                                    fdesc = this.ObtenerFecha(dia_actual, hora_actual, 1);
                                    fcon = this.ObtenerFecha(partes_de_linea[19], partes_de_linea[11].substring(0, 6), 1);
                                    latitud_desconexion = this.Convertir_Coordenadas(lat_actual, 1);
                                    lon_desconexion = -1.0D * this.Convertir_Coordenadas(lon_actual, 2);
                                    latitud_conexion = this.Convertir_Coordenadas(partes_de_linea[13], 1);
                                    lon_conexion = -1.0D * this.Convertir_Coordenadas(partes_de_linea[15], 2);
                                    dk = new Desconexion(this.chapa, fcon, fdesc, latitud_conexion, lon_conexion, latitud_desconexion, lon_desconexion, 7);
                                    this.Desconexiones.add(dk);
                                    Desconexion_por_Alterac_de_Voltaj = false;
                                    se_desconecto = true;
                                    cambio_estado_desc = true;
                                 }

                                 long time;
                                 if (Desconexion_por_Falta_de_Tramas && !salto_fecha) {
                                    fdesc = this.ObtenerFecha(fecha_desconexion, hora_desconexion, 1);
                                    fcon = this.ObtenerFecha(dia_actual, hora_actual, 1);
                                    time = this.Tiempo_de_Desconexion(fdesc, fcon);
                                    if (time >= 30L) {
                                       Desconexion ft = new Desconexion(this.chapa, fcon, fdesc, this.lat_transformada1, this.lon_transformada1, this.lat_transformada, this.lon_transformada, 5);
                                       this.Desconexiones.add(ft);
                                       Desconexion_por_Falta_de_Tramas = false;
                                       desconexion_existente = false;
                                       fecha_desconexion = "";
                                       hora_desconexion = "";
                                    }
                                 } else {
                                    if (this.Linea_Cierta(partes_de_linea[12]) == 1) {
                                       if (Desconexion_datos_no_validos_posicion || Desconexion_datos_no_validos_satelite) {
                                          if (!se_desconecto) {
                                             if (tramas_no_validas_al_inicio) {
                                                fdesc = this.ObtenerFecha(dia, hora, 1);
                                             } else {
                                                fdesc = this.ObtenerFecha(dia, hora, 1);
                                             }

                                             fcon = this.ObtenerFecha(partes_de_linea[19], partes_de_linea[11].substring(0, 6), 1);

                                             try {
                                                latitud_desconexion = this.Convertir_Coordenadas(partes_de_linea[13], 1);
                                                lon_desconexion = -1.0D * this.Convertir_Coordenadas(partes_de_linea[15], 2);
                                                latitud_conexion = this.Convertir_Coordenadas(partes_de_linea[13], 1);
                                                lon_conexion = -1.0D * this.Convertir_Coordenadas(partes_de_linea[15], 2);
                                                if (Desconexion_datos_no_validos_satelite) {
                                                   dk = new Desconexion(this.chapa, fcon, fdesc, latitud_conexion, lon_conexion, latitud_desconexion, lon_desconexion, 6);
                                                } else {
                                                   dk = new Desconexion(this.chapa, fcon, fdesc, latitud_conexion, lon_conexion, latitud_desconexion, lon_desconexion, 1);
                                                }

                                                this.Desconexiones.add(dk);
                                                Desconexion_datos_no_validos_posicion = false;
                                                Desconexion_datos_no_validos_satelite = false;
                                                cambio_estado_desc = true;
                                                this.Asignar(partes_de_linea[19]);
                                                this.Asignar(partes_de_linea[11].substring(0, 6));
                                                this.Asignar(partes_de_linea[15]);
                                                this.Asignar(partes_de_linea[13]);
                                                se_desconecto = true;
                                             } catch (Exception var96) {
                                                trama_inicial = false;
                                                ++this.tramas_validas;
                                                tramas_no_validas_al_inicio = false;
                                                tramas_no_validas_al_final = false;
                                                this.tramas_V_al_final = 0L;
                                                Desconexion_datos_no_validos_satelite = true;
                                                ++this.tramas_simplificadas;
                                                continue;
                                             }
                                          } else {
                                             Desconexion_datos_no_validos_posicion = false;
                                             Desconexion_datos_no_validos_satelite = false;
                                             cambio_estado_desc = true;
                                          }
                                       }

                                       ++this.tramas_validas;
                                       tramas_no_validas_al_inicio = false;
                                       tramas_no_validas_al_final = false;
                                       this.tramas_V_al_final = 0L;
                                       vel_actual = Double.parseDouble(partes_de_linea[17]);
                                       veloc = vel_actual * 1.853D;
                                       if (this.ValidarPin(partes_de_linea[18])) {
                                          if (partes_de_linea[18].equalsIgnoreCase("")) {
                                             pin_actual = -1.0D;
                                          } else {
                                             pin_actual = Double.parseDouble(partes_de_linea[18]);
                                          }
                                       } else {
                                          pin_actual = -1.0D;
                                       }

                                       dia_actual = this.Asignar(partes_de_linea[19]);
                                       hora_actual = this.Asignar(partes_de_linea[11].substring(0, 6));
                                       lon_actual = this.Asignar(partes_de_linea[15]);
                                       lat_actual = this.Asignar(partes_de_linea[13]);
                                       boolean SC = false;
                                       if (cant_partes == 22) {
                                          SC = this.SumaControl(partes_de_linea, 22);
                                       } else if (cant_partes == 23) {
                                          SC = this.SumaControl(partes_de_linea, 23);
                                       }

                                       if (SC) {
                                          if (this.ValidarHora(partes_de_linea[11]) && this.ValidarFecha(dia_actual)) {
                                             if (!trama_inicial && this.Fecha_Inicial.equalsIgnoreCase("")) {
                                                this.Fecha_Inicial = dia_actual.substring(0, 2) + "/" + dia_actual.substring(2, 4) + "/" + dia_actual.substring(4, 6);
                                                this.Hora_Inicial = hora_actual.substring(0, 2) + ":" + hora_actual.substring(2, 4);
                                                this.ComprobarFechaHora(this.Fecha_Inicial, this.Hora_Inicial, 1);
                                             }

                                             int diferencia = this.Falta_de_Tramas(dia_actual, hora_actual, Dia_Anterior, Hora_Anterior);
                                             if (diferencia == 0 && !datosV && !secuencia_suma_control_fallida && !se_desconecto) {
                                                Desconexion_por_Falta_de_Tramas = true;
                                                desconexion_existente = true;
                                                fecha_desconexion = Dia_Anterior;
                                                hora_desconexion = Hora_Anterior;
                                             }

                                             Dia_Anterior = dia_actual;
                                             Hora_Anterior = hora_actual;
                                             secuencia_suma_control_fallida = false;
                                             if (!trama_inicial) {
                                                vel = Math.abs(vel_actual - v) * 1.853D;
                                                ang = Math.abs(pin_actual - pin);
                                                if (lat.equalsIgnoreCase("") || lon.equalsIgnoreCase("")) {
                                                   lat = lat_actual;
                                                   lon = lon_actual;
                                                }

                                                this.lat_transformada = this.Convertir_Coordenadas(lat, 1);
                                                this.lon_transformada = -1.0D * this.Convertir_Coordenadas(lon, 2);
                                                this.lat_transformada1 = this.Convertir_Coordenadas(lat_actual, 1);
                                                this.lon_transformada1 = -1.0D * this.Convertir_Coordenadas(lon_actual, 2);
                                                if (!this.ComprobarBB(this.lat_transformada1, this.lon_transformada1)) {
                                                   ++this.tramas_simplificadas;
                                                   continue;
                                                }

                                                dist = this.Distancia(this.lon_transformada, this.lat_transformada, this.lon_transformada1, this.lat_transformada1);
                                                dist = Math.abs(dist);
                                                if ((vel > 10.0D || ang > 5.0D) && dist < 2000.0D) {
                                                   trama_significativa = true;
                                                } else if (dist > 2000.0D && this.Tiempo_entre_Tramas(dia, dia_actual, hora, hora_actual) > 60L && !salto_fecha) {
                                                   trama_significativa = true;
                                                }
                                             } else {
                                                trama_significativa = true;
                                                if (this.lat_transformada1 == 0.0D || this.lon_transformada1 == 0.0D) {
                                                   this.lat_transformada1 = this.Convertir_Coordenadas(lat_actual, 1);
                                                   this.lon_transformada1 = -1.0D * this.Convertir_Coordenadas(lon_actual, 2);
                                                }
                                             }

                                             ViolacionVelocidad violacVelc;
                                             if (veloc < 2.0D && !vehiculo_detenido) {
                                                if (violacion) {
                                                   ff_violacion = this.ObtenerFecha(dia, hora, 1);
                                                   violacVelc = new ViolacionVelocidad(fi_violacion, ff_violacion, Double.valueOf(latInicioViolac), Double.valueOf(lonInicioViolac), Double.valueOf(lat_actual), Double.valueOf(lon_actual), dist_acumulada - distInicioViolac, velcMaxViolacion);
                                                   this.ViolacionesVelc.add(violacVelc);
                                                   violacion = false;
                                                   fi_violacion = "";
                                                   ff_violacion = "";
                                                   latInicioViolac = "";
                                                   lonInicioViolac = "";
                                                   velcMaxViolacion = 0.0D;
                                                   distInicioViolac = 0.0D;
                                                   distFinViolac = 0.0D;
                                                }

                                                v = vel_actual;
                                                pin = pin_actual;
                                                lon = lon_actual;
                                                lat = lat_actual;
                                                dia = dia_actual;
                                                hora = hora_actual;
                                                vehiculo_detenido = true;
                                                fecha_de_parada = dia_actual;
                                                hora_de_parada = hora_actual;
                                                if (trama_inicial) {
                                                   this.lat_transformada = this.Convertir_Coordenadas(lat_actual, 1);
                                                   this.lon_transformada = -1.0D * this.Convertir_Coordenadas(lon_actual, 2);
                                                   this.lon_ant = this.lon_transformada;
                                                   this.lat_ant = this.lat_transformada;
                                                }

                                                this.BoundingBox(this.lon_transformada, this.lat_transformada);
                                                int stopidx = this.NoParada;
                                                ++orden;
                                                fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                                                this.Adicionar_Linea_shpTarjeta(this.lat_transformada1, this.lon_transformada1, pin_actual, vel_actual, fechahora, orden, stopidx);
                                                dist_acumulada += this.Distancia(this.lon_ant, this.lat_ant, this.lon_transformada1, this.lat_transformada1);
                                                this.lon_ant = this.lon_transformada1;
                                                this.lat_ant = this.lat_transformada1;
                                                ++indice_trama;
                                             } else {
                                                byte stopidx;
                                                if (veloc > 2.0D && vehiculo_detenido && trama_significativa) {
                                                   String f1;
                                                   if (fecha_de_parada.equalsIgnoreCase("") && hora_de_parada.equalsIgnoreCase("")) {
                                                      f1 = this.ObtenerFecha(dia, hora, 1);
                                                      time = this.Tiempo_entre_Tramas(dia, dia_actual, hora, hora_actual);
                                                      this.tiempo_total_paradas += time;
                                                   } else {
                                                      f1 = this.ObtenerFecha(fecha_de_parada, hora_de_parada, 1);
                                                      time = this.Tiempo_entre_Tramas(fecha_de_parada, dia_actual, hora_de_parada, hora_actual);
                                                      this.tiempo_total_paradas += time;
                                                   }

                                                   String f2 = this.ObtenerFecha(dia_actual, hora_actual, 1);
                                                   if (time > 60L) {
                                                      int tiempo = (int)(time / 60L);
                                                      Detenciones det = new Detenciones(this.NoParada, this.Chapa.getText(), f1, f2, tiempo, this.lat_transformada1, this.lon_transformada1, dist_acumulada, orden);
                                                      this.Paradas.add(det);
                                                      ++this.NoParada;
                                                   }

                                                   if (vel_actual * 1.853D >= this.VelocLimite && !violacion) {
                                                      violacion = true;
                                                      fi_violacion = this.ObtenerFecha(dia_actual, hora_actual, 1);
                                                      latInicioViolac = lat_actual;
                                                      lonInicioViolac = lon_actual;
                                                      velcMaxViolacion = vel_actual;
                                                      distInicioViolac = dist_acumulada;
                                                   }

                                                   fecha_de_parada = "";
                                                   hora_de_parada = "";
                                                   vehiculo_detenido = false;
                                                   v = vel_actual;
                                                   pin = pin_actual;
                                                   lon = lon_actual;
                                                   lat = lat_actual;
                                                   dia = dia_actual;
                                                   hora = hora_actual;
                                                   stopidx = -1;
                                                   this.BoundingBox(this.lon_transformada1, this.lat_transformada1);
                                                   String fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                                                   ++orden;
                                                   this.Adicionar_Linea_shpTarjeta(this.lat_transformada1, this.lon_transformada1, pin_actual, vel_actual, fechahora, orden, stopidx);
                                                   dist_acumulada += this.Distancia(this.lon_ant, this.lat_ant, this.lon_transformada1, this.lat_transformada1);
                                                   this.lon_ant = this.lon_transformada1;
                                                   this.lat_ant = this.lat_transformada1;
                                                   ++indice_trama;
                                                } else if (veloc > 2.0D && trama_significativa) {
                                                   try {
                                                      if (veloc > this.velocidad_maxima && veloc < 160.0D) {
                                                         this.velocidad_maxima = veloc;
                                                      }

                                                      if (veloc > 2.0D && veloc < 160.0D) {
                                                         suma_vel += veloc;
                                                         ++contador;
                                                      } else if (veloc > 160.0D) {
                                                         salto_posicion = true;
                                                      }

                                                      if (violacion) {
                                                         if (vel_actual * 1.853D >= this.VelocLimite) {
                                                            if (velcMaxViolacion < vel_actual) {
                                                               velcMaxViolacion = vel_actual;
                                                            }
                                                         } else {
                                                            ff_violacion = this.ObtenerFecha(dia, hora, 1);
                                                            violacVelc = new ViolacionVelocidad(fi_violacion, ff_violacion, Double.valueOf(latInicioViolac), Double.valueOf(lonInicioViolac), Double.valueOf(lat_actual), Double.valueOf(lon_actual), dist_acumulada - distInicioViolac, velcMaxViolacion);
                                                            this.ViolacionesVelc.add(violacVelc);
                                                            violacion = false;
                                                            fi_violacion = "";
                                                            ff_violacion = "";
                                                            latInicioViolac = "";
                                                            lonInicioViolac = "";
                                                            velcMaxViolacion = 0.0D;
                                                            distInicioViolac = 0.0D;
                                                            distFinViolac = 0.0D;
                                                         }
                                                      } else if (vel_actual * 1.853D >= this.VelocLimite) {
                                                         violacion = true;
                                                         fi_violacion = this.ObtenerFecha(dia_actual, hora_actual, 1);
                                                         latInicioViolac = lat_actual;
                                                         lonInicioViolac = lon_actual;
                                                         velcMaxViolacion = vel_actual;
                                                         distInicioViolac = dist_acumulada;
                                                      } else {
                                                         violacion = false;
                                                         fi_violacion = "";
                                                         ff_violacion = "";
                                                         latInicioViolac = "";
                                                         lonInicioViolac = "";
                                                         velcMaxViolacion = 0.0D;
                                                         distInicioViolac = 0.0D;
                                                         distFinViolac = 0.0D;
                                                      }

                                                      if (!salto_posicion && !salto_fecha) {
                                                         v = vel_actual;
                                                         pin = pin_actual;
                                                         lon = lon_actual;
                                                         lat = lat_actual;
                                                         dia = dia_actual;
                                                         hora = hora_actual;
                                                         stopidx = -1;
                                                         this.BoundingBox(this.lon_transformada, this.lat_transformada);
                                                         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                                                         ++orden;
                                                         this.Adicionar_Linea_shpTarjeta(this.lat_transformada1, this.lon_transformada1, pin_actual, vel_actual, fechahora, orden, stopidx);
                                                         dist_acumulada += this.Distancia(this.lon_ant, this.lat_ant, this.lon_transformada1, this.lat_transformada1);
                                                         this.lon_ant = this.lon_transformada1;
                                                         this.lat_ant = this.lat_transformada1;
                                                         ++indice_trama;
                                                      } else if (!salto_posicion && salto_fecha && cambio_estado_desc) {
                                                         v = vel_actual;
                                                         pin = pin_actual;
                                                         lon = lon_actual;
                                                         lat = lat_actual;
                                                         dia = dia_actual;
                                                         hora = hora_actual;
                                                         stopidx = -1;
                                                         this.BoundingBox(this.lon_transformada, this.lat_transformada);
                                                         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                                                         ++orden;
                                                         this.Adicionar_Linea_shpTarjeta(this.lat_transformada1, this.lon_transformada1, pin_actual, vel_actual, fechahora, orden, stopidx);
                                                         dist_acumulada += this.Distancia(this.lon_ant, this.lat_ant, this.lon_transformada1, this.lat_transformada1);
                                                         this.lon_ant = this.lon_transformada1;
                                                         this.lat_ant = this.lat_transformada1;
                                                         ++indice_trama;
                                                         cambio_estado_desc = false;
                                                         this.Fecha_Final = f;
                                                         this.Hora_Final = h;
                                                      }
                                                   } catch (Exception var97) {
                                                      ++this.tramas_simplificadas;
                                                      continue;
                                                   }
                                                } else {
                                                   ++this.tramas_simplificadas;
                                                   if (!vehiculo_detenido) {
                                                      fecha_de_parada = dia;
                                                      hora_de_parada = hora;
                                                   }

                                                   if (salto_fecha && vehiculo_detenido) {
                                                      this.Fecha_Final = f;
                                                      this.Hora_Final = h;
                                                   }

                                                   if (trama_significativa) {
                                                      v = vel_actual;
                                                      pin = pin_actual;
                                                      dia = dia_actual;
                                                      hora = hora_actual;
                                                      lon = lon_actual;
                                                      lat = lat_actual;
                                                      this.Fecha_Final = f;
                                                      this.Hora_Final = h;
                                                   }
                                                }
                                             }
                                          }
                                       } else {
                                          ++this.chequeo_suma_fallido;
                                          ++this.tramas_simplificadas;
                                          secuencia_suma_control_fallida = true;
                                       }

                                       datosV = false;
                                    } else {
                                       if (lc == 3) {
                                          ++this.tramas_simplificadas;
                                          continue;
                                       }

                                       ++this.tramas_no_validas;
                                       if (trama_inicial) {
                                          ++this.tramas_V_al_inicio;
                                          tramas_no_validas_al_inicio = true;
                                          Desconexion_datos_no_validos_posicion = true;
                                          desconexion_existente = true;
                                          if (!datosV) {
                                             datosV = true;
                                             dia = partes_de_linea[19];
                                             hora = partes_de_linea[11].substring(0, 6);
                                          }
                                       } else if (this.numero_de_lineas > 5L) {
                                          if (partes_de_linea[13].equalsIgnoreCase("") && partes_de_linea[15].equalsIgnoreCase("")) {
                                             Desconexion_datos_no_validos_satelite = true;
                                          } else {
                                             Desconexion_datos_no_validos_posicion = true;

                                             try {
                                                dia_actual = this.Asignar(partes_de_linea[19]);
                                                hora_actual = this.Asignar(partes_de_linea[11].substring(0, 6));
                                                lon_actual = this.Asignar(partes_de_linea[15]);
                                                lat_actual = this.Asignar(partes_de_linea[13]);
                                             } catch (Exception var95) {
                                                ++this.tramas_simplificadas;
                                                continue;
                                             }
                                          }

                                          desconexion_existente = true;
                                          ++this.tramas_V_al_final;
                                          tramas_no_validas_al_final = true;
                                          if (!datosV) {
                                             datosV = true;
                                             dia = this.Asignar(partes_de_linea[19]);
                                             hora = this.Asignar(partes_de_linea[11].substring(0, 6));
                                          }
                                       }
                                    }

                                    salto_posicion = false;
                                    se_desconecto = false;
                                    trama_significativa = false;
                                    if (!tramas_no_validas_al_inicio) {
                                       trama_inicial = false;
                                    }

                                    cambio_estado_desc = false;
                                 }
                              }
                           } else {
                              ++this.tramas_simplificadas;
                           }
                        } else {
                           ++this.tramas_simplificadas;
                        }
                     }
                  }
               } else if (this.numero_de_lineas > 10L && linea.equalsIgnoreCase("KIJO02") && trama1) {
                  Desconexion_de_Kijo = true;
                  desconexion_existente = true;
                  if (Desconexion_por_Falta_de_Tramas) {
                     desconexion_existente = false;
                  }
               } else if (this.numero_de_lineas > 10L && linea.equalsIgnoreCase("KIJO00") && trama1) {
                  Desconexion_de_Tarjeta_por_Corriente = true;
                  desconexion_existente = true;
                  if (Desconexion_por_Falta_de_Tramas) {
                     desconexion_existente = false;
                  }
               } else if (this.numero_de_lineas > 10L && linea.equalsIgnoreCase("KIJO03") && trama1) {
                  Desconexion_por_Alterac_de_Voltaj = true;
                  desconexion_existente = true;
                  if (Desconexion_por_Falta_de_Tramas) {
                     desconexion_existente = false;
                  }
               }
            }
         } catch (Exception var98) {
            try {
               if (partes_de_linea[12].equalsIgnoreCase("V")) {
                  if (trama1) {
                     Desconexion_datos_no_validos_posicion = true;
                  }

                  ++this.tramas_no_validas;
                  if (!datosV) {
                     datosV = true;
                     dia = dia_actual;
                     hora = hora_actual;
                  }

                  if (!trama1 && !trama_inicial) {
                     ++this.tramas_V_al_inicio;
                     if (!dia_actual.equalsIgnoreCase("") && !hora_actual.equalsIgnoreCase("")) {
                        this.Fecha_Inicial = dia_actual.substring(0, 2) + "/" + dia_actual.substring(2, 4) + "/" + dia_actual.substring(4, 6);
                        this.Hora_Inicial = hora_actual.substring(0, 2) + ":" + hora_actual.substring(2, 4) + ":" + hora_actual.substring(4, 6);
                        this.ComprobarFechaHora(this.Fecha_Inicial, this.Hora_Inicial, 1);
                        trama_inicial = true;
                        trama1 = true;
                        dia = dia_actual;
                        hora = hora_actual;
                        Desconexion_datos_no_validos_satelite = true;
                     }
                  }

                  ++this.tramas_simplificadas;
               } else {
                  ++this.tramas_simplificadas;
               }
            } catch (Exception var94) {
               ++this.tramas_simplificadas;
            }
         }
      }

      if (this.numero_de_lineas - this.tramas_no_validas <= 4L) {
         Mensaje = "Esta Trayectoria no tiene Tramas Válidas, informe a GCOM.<br/> de la situación, la Aplicación se Cerrará";
         this.ShowMessage(Mensaje, "Información", "Information");
         System.exit(0);
      }

      this.velocidad_promedio = suma_vel / (double)contador;
      if (!this.ComprobarVelocidad(vel_actual) && vehiculo_detenido) {
         long time;
         if (fecha_de_parada.equalsIgnoreCase("") && hora_de_parada.equalsIgnoreCase("")) {
            fcon = this.ObtenerFecha(dia, hora, 1);
            time = this.Tiempo_entre_Tramas(dia, dia_actual, hora, hora_actual);
            this.tiempo_total_paradas += time;
         } else {
            fcon = this.ObtenerFecha(fecha_de_parada, hora_de_parada, 1);
            time = this.Tiempo_entre_Tramas(fecha_de_parada, dia_actual, hora_de_parada, hora_actual);
            this.tiempo_total_paradas += time;
         }

         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         this.lat_transformada = this.Convertir_Coordenadas(lat_actual, 1);
         this.lon_transformada = -1.0D * this.Convertir_Coordenadas(lon_actual, 2);
         int tiempo = (int)(time / 60L);
         Detenciones det = new Detenciones(this.NoParada, this.Chapa.getText(), fcon, fechahora, tiempo, this.lat_transformada, this.lon_transformada, dist_acumulada, orden);
         this.Paradas.add(det);
         ++this.NoParada;
         fecha_de_parada = "";
         hora_de_parada = "";
      }

      reader.close();
      this.shape.closeFeatureWriter1();
      return true;
   }

   public boolean Transferir_FicheroGPSE(File por_transferir) throws IOException, ParseException, ParseException, Exception {
      String camino = "Temp\\SHPTemporal\\Trayectoria.shp";
      this.shp = new File(camino);
      if (this.shp.exists()) {
         this.BorrarDirectorio("Temp\\SHPTemporal");
      }

      this.shape.initFeatureWriterGPSE(camino);
      this.Crear_Fichero_Salida();
      this.parserHexadecimal.replaceAllNull(por_transferir);
      BufferedReader reader = new BufferedReader(new FileReader(this.parserHexadecimal.mifile));
      String linea = "";
      String[] partes_de_linea = new String[22];
      boolean vehiculo_detenido = false;
      String fecha_de_parada = "";
      String hora_de_parada = "";
      String lat_parada = "";
      String lon_parada = "";
      double dis_parada = 0.0D;
      double vel_actual = 0.0D;
      String lon_actual = "";
      String lat_actual = "";
      String dia_actual = "";
      String hora_actual = "";
      String mov_actual = "";
      String est_conect = "";
      double dist_actual = 0.0D;
      double dist_inicial = 0.0D;
      double dist_final = 0.0D;
      String numSat_actual = "";
      String rumbo_actual = "";
      String edadPos_actual = "";
      String codAlarm_actual = "";
      String pin_actual = "";
      double suma_vel = 0.0D;
      int contador = 0;
      boolean Desconexion_por_Falta_de_Tramas = false;
      boolean Desconexion_AlimentacExterna_Ausente = false;
      boolean Desconexion_de_Antena = false;
      boolean Desconexion_Tiemp_sin_Satelite = false;
      boolean Desconexion_ahorro_de_energia = false;
      String fecha_desconexion = "";
      String hora_desconexion = "";
      String fecha_desAlimentac = "";
      String hora_desAlimentac = "";
      String lat_desAlimentac = "";
      String lon_desAlimentac = "";
      String fecha_desAntena = "";
      String hora_desAntena = "";
      String lat_desAntena = "";
      String lon_desAntena = "";
      String fecha_desTiemSinSat = "";
      String hora_desTiemSinSat = "";
      String lat_desTiemSinSat = "";
      String lon_desTiemSinSat = "";
      String fecha_desIgnicion = "";
      String hora_desIgnicion = "";
      String lat_desIgnicion = "";
      String lon_desIgnicion = "";
      String fecha_ahorr_energ = "";
      String hora_ahorr_energ = "";
      String lat_des_ahorr_energ = "";
      String lon_des_ahorr_energ = "";
      String latitud_desconexion = "";
      String lon_desconexion = "";
      String latitud_conexion = "";
      String lon_conexion = "";
      boolean trama_significativa = false;
      boolean salto_fecha = false;
      boolean se_desconecto = false;
      boolean se_movio = false;
      String q = null;
      int trama1 = false;
      String f = "";
      String h = "";
      String fh = "";
      double dist = 0.0D;
      double vel = 0.0D;
      double ang = 0.0D;
      int indice_trama = 0;
      double dist_acumulada = 0.0D;
      int stopidx = -1;
      int orden = -1;
      Entrada.anterior anterior = new Entrada.anterior();
      boolean violacion = false;
      String fi_violacion = "";
      String ff_violacion = "";
      double velcMaxViolacion = 0.0D;
      String latInicioViolac = "";
      String lonInicioViolac = "";
      double distInicioViolac = 0.0D;
      double distFinViolac = 0.0D;
      this.PBLabel.setText("Procesando Trayectoria...");
      this.PB.setVisible(true);
      this.PBLabel.setVisible(true);
      this.Motivo_Error = 2;
      this.fecha_hora = this.Fecha_Hora_Actual_Servidor();
      String FH = this.fecha_hora.substring(0, 4) + this.fecha_hora.substring(5, 7) + this.fecha_hora.substring(8, 10) + this.fecha_hora.substring(11, 13) + this.fecha_hora.substring(14, 16);
      this.logid = this.Chapa.getText() + FH;

      String fechahora;
      String fdesc;
      String f2;
      int tiempo;
      Detenciones det;
      String fechahora;
      String f1;
      while((linea = reader.readLine()) != null) {
         try {
            ++this.numero_de_lineas;
            if (!linea.equalsIgnoreCase("")) {
               if (this.numero_de_lineas == 9794L) {
                  q = "Quieto";
               }

               int longitud_de_linea = linea.length();
               if (longitud_de_linea > 6 && longitud_de_linea < 130) {
                  partes_de_linea = linea.split(",");
                  this.idgps = partes_de_linea[0].trim();
                  dia_actual = partes_de_linea[1].trim();
                  hora_actual = partes_de_linea[2].trim();
                  pin_actual = partes_de_linea[3].trim();
                  edadPos_actual = partes_de_linea[4].trim();
                  lat_actual = partes_de_linea[5].trim();
                  lon_actual = partes_de_linea[6].trim();
                  vel_actual = Double.valueOf(partes_de_linea[7].trim());
                  dist_actual = Double.valueOf(partes_de_linea[8].trim());
                  codAlarm_actual = partes_de_linea[9].trim();
                  mov_actual = partes_de_linea[10].trim();
                  if (anterior.vacio) {
                     anterior.dia = dia_actual;
                     anterior.hora = hora_actual;
                     anterior.lon = Double.valueOf(lon_actual);
                     anterior.lat = Double.valueOf(lat_actual);
                     anterior.velocidad = vel_actual;
                     anterior.dis = dist_actual;
                     anterior.codAlarm = codAlarm_actual;
                     anterior.pin = Double.valueOf(pin_actual);
                     anterior.moviendo = mov_actual;
                     if (dia_actual.length() == 6 && hora_actual.length() == 6) {
                        this.Fecha_Inicial = dia_actual.substring(0, 2) + "/" + dia_actual.substring(2, 4) + "/" + dia_actual.substring(4, 6);
                        this.Hora_Inicial = hora_actual.substring(0, 2) + ":" + hora_actual.substring(2, 4) + ":" + hora_actual.substring(4, 6);
                        if (!this.isActualDate(this.Fecha_Inicial, this.Hora_Inicial, this.fecha_hora)) {
                           ++this.tramas_simplificadas;
                        } else {
                           this.ComprobarFechaHora(this.Fecha_Inicial, this.Hora_Inicial, 1);
                           if (this.idgps.contains("\u0000")) {
                              fechahora = "Esta Trayectoria no se puede Transferir. Existe una pérdida<br/>de id del GPS. Póngase en contacto con el personal de GCOM<br/>o con el Puesto de Mando de GEOCUBA para arreglar la situación.<br/>¿Desea enviar la Trayectoria para el ftp para que el PAT la analice?";
                              int n = JOptionPane.showConfirmDialog(this, fechahora, "Mensaje de Confirmación", 0);
                              if (n == 0) {
                                 this.Motivo_Error = 3;
                                 Error e = new Error(this);
                                 e.Mostrar();
                              } else {
                                 System.exit(0);
                              }
                           }

                           trama1 = true;
                           anterior.vacio = false;
                           if (mov_actual.equalsIgnoreCase("0")) {
                              fecha_de_parada = dia_actual;
                              hora_de_parada = hora_actual;
                              lat_parada = lat_actual;
                              lon_parada = lon_actual;
                              vehiculo_detenido = true;
                              dis_parada = this.distancia_recorrida_total;
                           }

                           this.BoundingBox(Double.valueOf(lon_actual), Double.valueOf(lat_actual));
                           stopidx = this.NoParada;
                           ++orden;
                           fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                           this.Adicionar_Linea_shpGPSE(Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(pin_actual), vel_actual * 1.94384D, fechahora, orden, stopidx, mov_actual, 0.0D);
                           ++indice_trama;
                        }
                        continue;
                     }

                     dia_actual = "";
                     hora_actual = "";
                     ++this.tramas_simplificadas;
                     continue;
                  }

                  if (hora_actual.equalsIgnoreCase(anterior.hora)) {
                     ++this.tramas_simplificadas;
                     continue;
                  }

                  f = dia_actual.substring(0, 2) + "/" + dia_actual.substring(2, 4) + "/" + dia_actual.substring(4, 6);
                  h = hora_actual.substring(0, 2) + ":" + hora_actual.substring(2, 4) + ":" + hora_actual.substring(4, 6);
                  fh = f + " " + h;
                  if (!this.ComprobarBB(Double.valueOf(lat_actual), Double.valueOf(lon_actual))) {
                     ++this.tramas_simplificadas;
                     continue;
                  }

                  if (!this.isDate(fh)) {
                     ++this.tramas_simplificadas;
                     continue;
                  }

                  if (!this.isActualDate(f, h, this.fecha_hora)) {
                     ++this.tramas_simplificadas;
                     continue;
                  }

                  if (this.ComparaFecha(this.Fecha_Final, f, this.Hora_Final, h, 2)) {
                     this.Fecha_Final = f;
                     this.Hora_Final = h;
                  }

                  if (dist_actual > anterior.dis) {
                     this.distancia_recorrida_total += dist_actual - anterior.dis;
                  } else if (dist_actual == 0.0D || dist_actual == anterior.dis) {
                     this.distancia_recorrida_total += 0.0D;
                  }

                  int diferencia = this.Falta_de_TramasGPSE(dia_actual, hora_actual, anterior.dia, anterior.hora);
                  Desconexion dk;
                  if (diferencia == 0 && anterior.moviendo.equalsIgnoreCase("1") && !Desconexion_ahorro_de_energia && codAlarm_actual.equalsIgnoreCase("0") && mov_actual.equalsIgnoreCase("1")) {
                     Desconexion_por_Falta_de_Tramas = true;
                     fecha_desconexion = anterior.dia;
                     hora_desconexion = anterior.hora;
                     latitud_desconexion = String.valueOf(anterior.lat);
                     lon_desconexion = String.valueOf(anterior.lon);
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     fdesc = this.ObtenerFecha(fecha_desconexion, hora_desconexion, 1);
                     dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(latitud_desconexion), Double.valueOf(lon_desconexion), 5);
                     this.Desconexiones.add(dk);
                     fecha_desconexion = "";
                     hora_desconexion = "";
                     latitud_desconexion = "";
                     lon_desconexion = "";
                     latitud_conexion = "";
                     lon_desconexion = "";
                     Desconexion_por_Falta_de_Tramas = false;
                  }

                  if (codAlarm_actual.equalsIgnoreCase("3")) {
                     fecha_desAlimentac = dia_actual;
                     hora_desAlimentac = hora_actual;
                     lat_desAlimentac = String.valueOf(lat_actual);
                     lon_desAlimentac = String.valueOf(lon_actual);
                     Desconexion_AlimentacExterna_Ausente = true;
                  }

                  if ((codAlarm_actual.equalsIgnoreCase("4") || codAlarm_actual.equalsIgnoreCase("10")) && Desconexion_AlimentacExterna_Ausente) {
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     fdesc = this.ObtenerFecha(fecha_desAlimentac, hora_desAlimentac, 1);
                     dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAlimentac), Double.valueOf(lon_desAlimentac), 3);
                     this.Desconexiones.add(dk);
                     fecha_desAlimentac = "";
                     hora_desAlimentac = "";
                     lat_desAlimentac = "";
                     lon_desAlimentac = "";
                     latitud_conexion = "";
                     lon_desconexion = "";
                     Desconexion_AlimentacExterna_Ausente = false;
                  }

                  if (codAlarm_actual.equalsIgnoreCase("144") && !Desconexion_de_Antena) {
                     Desconexion_de_Antena = true;
                     fecha_desAntena = dia_actual;
                     hora_desAntena = hora_actual;
                     lat_desAntena = String.valueOf(lat_actual);
                     lon_desAntena = String.valueOf(lon_actual);
                  }

                  if (codAlarm_actual.equalsIgnoreCase("145") && Desconexion_de_Antena) {
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     fdesc = this.ObtenerFecha(fecha_desAntena, hora_desAntena, 1);
                     dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAntena), Double.valueOf(lon_desAntena), 8);
                     this.Desconexiones.add(dk);
                     fecha_desAntena = "";
                     hora_desAntena = "";
                     lat_desAntena = "";
                     lon_desAntena = "";
                     latitud_conexion = "";
                     lon_desconexion = "";
                     Desconexion_de_Antena = false;
                  }

                  if (codAlarm_actual.equalsIgnoreCase("146") && !Desconexion_de_Antena) {
                     Desconexion_Tiemp_sin_Satelite = true;
                     fecha_desTiemSinSat = dia_actual;
                     hora_desTiemSinSat = hora_actual;
                     lat_desTiemSinSat = String.valueOf(lat_actual);
                     lon_desTiemSinSat = String.valueOf(lon_actual);
                  }

                  if (codAlarm_actual.equalsIgnoreCase("147") && Desconexion_Tiemp_sin_Satelite) {
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     fdesc = this.ObtenerFecha(fecha_desTiemSinSat, hora_desTiemSinSat, 1);
                     dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desTiemSinSat), Double.valueOf(lon_desTiemSinSat), 6);
                     this.Desconexiones.add(dk);
                     fecha_desTiemSinSat = "";
                     hora_desTiemSinSat = "";
                     lat_desTiemSinSat = "";
                     lon_desTiemSinSat = "";
                     latitud_conexion = "";
                     lon_desconexion = "";
                     Desconexion_Tiemp_sin_Satelite = false;
                  }

                  if (codAlarm_actual.equalsIgnoreCase("10") && Desconexion_ahorro_de_energia) {
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     fdesc = this.ObtenerFecha(fecha_ahorr_energ, hora_ahorr_energ, 1);
                     dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_des_ahorr_energ), Double.valueOf(lon_des_ahorr_energ), 3);
                     this.Desconexiones.add(dk);
                     fecha_ahorr_energ = "";
                     hora_ahorr_energ = "";
                     lat_des_ahorr_energ = "";
                     lon_des_ahorr_energ = "";
                     latitud_conexion = "";
                     lon_desconexion = "";
                     Desconexion_ahorro_de_energia = false;
                     Desconexion_por_Falta_de_Tramas = false;
                  }

                  if (codAlarm_actual.equalsIgnoreCase("12") && fecha_ahorr_energ.equalsIgnoreCase("") && hora_ahorr_energ.equalsIgnoreCase("")) {
                     Desconexion_ahorro_de_energia = true;
                     fecha_ahorr_energ = dia_actual;
                     hora_ahorr_energ = hora_actual;
                     lat_des_ahorr_energ = String.valueOf(lat_actual);
                     lon_des_ahorr_energ = String.valueOf(lon_actual);
                  }

                  ViolacionVelocidad violacVelc;
                  if (dist_actual == anterior.dis && vel_actual == 0.0D && mov_actual.equalsIgnoreCase("0") && !vehiculo_detenido) {
                     if (violacion) {
                        ff_violacion = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
                        violacVelc = new ViolacionVelocidad(fi_violacion, ff_violacion, Double.valueOf(latInicioViolac), Double.valueOf(lonInicioViolac), Double.valueOf(lat_actual), Double.valueOf(lon_actual), this.distancia_recorrida_total - distInicioViolac, velcMaxViolacion * 1.94384D);
                        this.ViolacionesVelc.add(violacVelc);
                        violacion = false;
                        fi_violacion = "";
                        ff_violacion = "";
                        latInicioViolac = "";
                        lonInicioViolac = "";
                        velcMaxViolacion = 0.0D;
                        distInicioViolac = 0.0D;
                        distFinViolac = 0.0D;
                     }

                     vehiculo_detenido = true;
                     fecha_de_parada = anterior.dia;
                     hora_de_parada = anterior.hora;
                     lat_parada = String.valueOf(anterior.lat);
                     lon_parada = String.valueOf(anterior.lon);
                     dis_parada = this.distancia_recorrida_total;
                     this.BoundingBox(Double.valueOf(lon_actual), Double.valueOf(lat_actual));
                     stopidx = this.NoParada;
                     ++orden;
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     this.Adicionar_Linea_shpGPSE(Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(pin_actual), vel_actual * 1.94384D, fechahora, orden, stopidx, mov_actual, this.distancia_recorrida_total);
                     ++indice_trama;
                     anterior.dia = dia_actual;
                     anterior.hora = hora_actual;
                     anterior.lon = Double.valueOf(lon_actual);
                     anterior.lat = Double.valueOf(lat_actual);
                     anterior.velocidad = vel_actual;
                     anterior.dis = dist_actual;
                     anterior.pin = Double.valueOf(pin_actual);
                     anterior.moviendo = mov_actual;
                     continue;
                  }

                  if (dist_actual > anterior.dis && vel_actual > 0.0D && mov_actual.equalsIgnoreCase("1") && vehiculo_detenido) {
                     long time;
                     if (fecha_de_parada.equalsIgnoreCase("") && hora_de_parada.equalsIgnoreCase("")) {
                        f1 = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        time = this.Tiempo_entre_Tramas(anterior.dia, dia_actual, anterior.hora, hora_actual);
                        this.tiempo_total_paradas += time;
                     } else {
                        f1 = this.ObtenerFecha(fecha_de_parada, hora_de_parada, 1);
                        time = this.Tiempo_entre_Tramas(fecha_de_parada, anterior.dia, hora_de_parada, anterior.hora);
                        this.tiempo_total_paradas += time;
                     }

                     f2 = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
                     if (time >= 60L) {
                        tiempo = (int)(time / 60L);
                        det = new Detenciones(this.NoParada, this.Chapa.getText(), f1, f2, tiempo, Double.valueOf(lat_parada), Double.valueOf(lon_parada), dis_parada, orden);
                        this.Paradas.add(det);
                        ++this.NoParada;
                     }

                     if (vel_actual / 1000.0D * 3600.0D >= this.VelocLimite && !violacion) {
                        violacion = true;
                        fi_violacion = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        latInicioViolac = lat_actual;
                        lonInicioViolac = lon_actual;
                        velcMaxViolacion = vel_actual;
                        distInicioViolac = this.distancia_recorrida_total;
                     }

                     fecha_de_parada = "";
                     hora_de_parada = "";
                     lat_parada = "";
                     lon_parada = "";
                     vehiculo_detenido = false;
                     dis_parada = 0.0D;
                  }

                  if (dist_actual > anterior.dis && vel_actual > 0.0D && mov_actual.equalsIgnoreCase("1") && !vehiculo_detenido) {
                     if (this.velocidad_maxima < vel_actual) {
                        this.velocidad_maxima = vel_actual;
                     }

                     if (violacion) {
                        if (vel_actual / 1000.0D * 3600.0D >= this.VelocLimite) {
                           if (velcMaxViolacion < vel_actual) {
                              velcMaxViolacion = vel_actual;
                           }

                           distFinViolac = this.distancia_recorrida_total;
                        } else {
                           ff_violacion = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
                           violacVelc = new ViolacionVelocidad(fi_violacion, ff_violacion, Double.valueOf(latInicioViolac), Double.valueOf(lonInicioViolac), Double.valueOf(lat_actual), Double.valueOf(lon_actual), this.distancia_recorrida_total - distInicioViolac, velcMaxViolacion * 1.94384D);
                           this.ViolacionesVelc.add(violacVelc);
                           violacion = false;
                           fi_violacion = "";
                           ff_violacion = "";
                           latInicioViolac = "";
                           lonInicioViolac = "";
                           velcMaxViolacion = 0.0D;
                           distInicioViolac = 0.0D;
                           distFinViolac = 0.0D;
                        }
                     } else if (vel_actual / 1000.0D * 3600.0D >= this.VelocLimite) {
                        violacion = true;
                        fi_violacion = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        latInicioViolac = lat_actual;
                        lonInicioViolac = lon_actual;
                        velcMaxViolacion = vel_actual;
                        distInicioViolac = this.distancia_recorrida_total;
                     } else {
                        violacion = false;
                        fi_violacion = "";
                        ff_violacion = "";
                        latInicioViolac = "";
                        lonInicioViolac = "";
                        velcMaxViolacion = 0.0D;
                        distInicioViolac = 0.0D;
                        distFinViolac = 0.0D;
                     }

                     suma_vel += vel_actual;
                     ++contador;
                     this.BoundingBox(Double.valueOf(lon_actual), Double.valueOf(lat_actual));
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     ++orden;
                     this.Adicionar_Linea_shpGPSE(Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(pin_actual), vel_actual * 1.94384D, fechahora, orden, stopidx, mov_actual, this.distancia_recorrida_total);
                     ++indice_trama;
                  }
               }

               anterior.dia = dia_actual;
               anterior.hora = hora_actual;
               anterior.lon = Double.valueOf(lon_actual);
               anterior.lat = Double.valueOf(lat_actual);
               anterior.velocidad = vel_actual;
               anterior.dis = dist_actual;
               anterior.pin = Double.valueOf(pin_actual);
               anterior.moviendo = mov_actual;
            }
         } catch (Exception var107) {
            var107.printStackTrace();
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, (String)null, var107);
         }
      }

      this.velocidad_promedio = suma_vel / (double)contador;
      this.velocidad_promedio = this.velocidad_promedio / 1000.0D * 3600.0D;
      this.velocidad_maxima = this.velocidad_maxima / 1000.0D * 3600.0D;
      Desconexion dk;
      if (Desconexion_AlimentacExterna_Ausente) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_desAlimentac, hora_desAlimentac, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAlimentac), Double.valueOf(lon_desAlimentac), 3);
         this.Desconexiones.add(dk);
         fecha_desAlimentac = "";
         hora_desAlimentac = "";
         lat_desAlimentac = "";
         lon_desAlimentac = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_AlimentacExterna_Ausente = false;
      }

      if (Desconexion_de_Antena) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_desAntena, hora_desAntena, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAntena), Double.valueOf(lon_desAntena), 8);
         this.Desconexiones.add(dk);
         fecha_desAntena = "";
         hora_desAntena = "";
         lat_desAntena = "";
         lon_desAntena = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_de_Antena = false;
      }

      if (Desconexion_Tiemp_sin_Satelite) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_desTiemSinSat, hora_desTiemSinSat, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desTiemSinSat), Double.valueOf(lon_desTiemSinSat), 6);
         this.Desconexiones.add(dk);
         fecha_desTiemSinSat = "";
         hora_desTiemSinSat = "";
         lat_desTiemSinSat = "";
         lon_desTiemSinSat = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_Tiemp_sin_Satelite = false;
      }

      if (Desconexion_ahorro_de_energia) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_ahorr_energ, hora_ahorr_energ, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_des_ahorr_energ), Double.valueOf(lon_des_ahorr_energ), 3);
         this.Desconexiones.add(dk);
         fecha_ahorr_energ = "";
         hora_ahorr_energ = "";
         lat_des_ahorr_energ = "";
         lon_des_ahorr_energ = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_ahorro_de_energia = false;
         Desconexion_por_Falta_de_Tramas = false;
      }

      if (dist_actual == anterior.dis && vehiculo_detenido) {
         ++contador;
         this.BoundingBox(Double.valueOf(lon_actual), Double.valueOf(lat_actual));
         f2 = this.ObtenerFecha(dia_actual, hora_actual, 1);
         ++orden;
         this.Adicionar_Linea_shpGPSE(Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(pin_actual), vel_actual * 1.94384D, f2, orden, stopidx, mov_actual, this.distancia_recorrida_total);
         long time;
         if (fecha_de_parada.equalsIgnoreCase("") && hora_de_parada.equalsIgnoreCase("")) {
            fdesc = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
            time = this.Tiempo_entre_Tramas(anterior.dia, dia_actual, anterior.hora, hora_actual);
            this.tiempo_total_paradas += time;
         } else {
            fdesc = this.ObtenerFecha(fecha_de_parada, hora_de_parada, 1);
            time = this.Tiempo_entre_Tramas(fecha_de_parada, dia_actual, hora_de_parada, hora_actual);
            this.tiempo_total_paradas += time;
         }

         f1 = this.ObtenerFecha(dia_actual, hora_actual, 1);
         tiempo = (int)(time / 60L);
         det = new Detenciones(this.NoParada, this.Chapa.getText(), fdesc, f1, tiempo, Double.valueOf(lat_parada), Double.valueOf(lon_parada), dis_parada, orden);
         this.Paradas.add(det);
         ++this.NoParada;
         fecha_de_parada = "";
         hora_de_parada = "";
         lat_parada = "";
         lon_parada = "";
      }

      this.shape.closeFeatureWriter1();
      reader.close();
      return true;
   }

   public boolean Transferir_FicheroTReal(File por_transferir) throws IOException, ParseException, ParseException, Exception {
      String camino = "Temp\\SHPTemporal\\Trayectoria.shp";
      this.shp = new File(camino);
      if (this.shp.exists()) {
         this.BorrarDirectorio("Temp\\SHPTemporal");
      }

      this.shape.initFeatureWriterTReal(camino);
      this.Crear_Fichero_Salida();
      this.real.LeerBinario(por_transferir);
      BufferedReader reader = new BufferedReader(new FileReader(this.real.mifile));
      String linea = "";
      String[] partes_de_linea = new String[22];
      boolean vehiculo_detenido = false;
      String fecha_de_parada = "";
      String hora_de_parada = "";
      String lat_parada = "";
      String lon_parada = "";
      double vel_actual = 0.0D;
      String lon_actual = "";
      String lat_actual = "";
      String dia_actual = "";
      String hora_actual = "";
      double dist_actual = 0.0D;
      String codAlarm_actual = "";
      double dist_inicial = 0.0D;
      double dist_final = 0.0D;
      String rumbo_actual = "";
      String pin_actual = "";
      double suma_vel = 0.0D;
      int contador = 0;
      boolean Desconexion_por_Falta_de_Tramas = false;
      boolean Desconexion_AlimentacExterna_Ausente = false;
      boolean Desconexion_de_Antena = false;
      boolean Desconexion_Tiemp_sin_Satelite = false;
      boolean Desconexion_de_Ignicion = false;
      boolean Desconexion_ahorro_de_energia = false;
      String fecha_desconexion = "";
      String hora_desconexion = "";
      String fecha_desAlimentac = "";
      String hora_desAlimentac = "";
      String lat_desAlimentac = "";
      String lon_desAlimentac = "";
      String fecha_desAntena = "";
      String hora_desAntena = "";
      String lat_desAntena = "";
      String lon_desAntena = "";
      String fecha_desTiemSinSat = "";
      String hora_desTiemSinSat = "";
      String lat_desTiemSinSat = "";
      String lon_desTiemSinSat = "";
      String fecha_desIgnicion = "";
      String hora_desIgnicion = "";
      String lat_desIgnicion = "";
      String lon_desIgnicion = "";
      String fecha_ahorr_energ = "";
      String hora_ahorr_energ = "";
      String lat_des_ahorr_energ = "";
      String lon_des_ahorr_energ = "";
      String latitud_desconexion = "";
      String lon_desconexion = "";
      String latitud_conexion = "";
      String lon_conexion = "";
      boolean trama_significativa = false;
      boolean salto_fecha = false;
      boolean se_desconecto = false;
      boolean se_movio = false;
      String q = null;
      int trama1 = false;
      String f = "";
      String h = "";
      String fh = "";
      double dist = 0.0D;
      double vel = 0.0D;
      double ang = 0.0D;
      int indice_trama = 0;
      int stopidx = -1;
      int orden = -1;
      Entrada.anterior anterior = new Entrada.anterior();
      boolean violacion = false;
      String fi_violacion = "";
      String ff_violacion = "";
      double velcMaxViolacion = 0.0D;
      String latInicioViolac = "";
      String lonInicioViolac = "";
      double distInicioViolac = 0.0D;
      double distFinViolac = 0.0D;
      System.out.print("\nProcesando Tramas");
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Procesando Trayectoria...");
      this.PB.setVisible(true);
      this.Motivo_Error = 2;
      this.fecha_hora = this.Fecha_Hora_Actual_Servidor();
      String FH = this.fecha_hora.substring(0, 4) + this.fecha_hora.substring(5, 7) + this.fecha_hora.substring(8, 10) + this.fecha_hora.substring(11, 13) + this.fecha_hora.substring(14, 16);
      this.logid = this.Chapa.getText() + FH;

      String fechahora;
      String fdesc;
      String fechahora;
      String f1;
      while((linea = reader.readLine()) != null) {
         try {
            ++this.numero_de_lineas;
            if (!linea.equalsIgnoreCase("")) {
               if (this.numero_de_lineas == 647L) {
                  q = "Quieto";
               }

               int longitud_de_linea = linea.length();
               if (longitud_de_linea > 6 && longitud_de_linea < 130) {
                  partes_de_linea = linea.split(",");
                  this.idgps = partes_de_linea[0].trim();
                  dia_actual = partes_de_linea[1].trim();
                  hora_actual = partes_de_linea[2].trim();
                  pin_actual = partes_de_linea[3].trim();
                  lat_actual = partes_de_linea[4].trim();
                  lon_actual = partes_de_linea[5].trim();
                  vel_actual = Double.valueOf(partes_de_linea[6].trim());
                  dist_actual = Double.valueOf(partes_de_linea[7].trim());
                  codAlarm_actual = partes_de_linea[8].trim();
                  if (anterior.vacio) {
                     anterior.dia = dia_actual;
                     anterior.hora = hora_actual;
                     anterior.lon = Double.valueOf(lon_actual);
                     anterior.lat = Double.valueOf(lat_actual);
                     anterior.velocidad = vel_actual;
                     anterior.dis = dist_actual;
                     anterior.codAlarm = codAlarm_actual;
                     anterior.pin = Double.valueOf(pin_actual);
                     if (dia_actual.length() == 6 && hora_actual.length() == 6) {
                        this.Fecha_Inicial = dia_actual.substring(0, 2) + "/" + dia_actual.substring(2, 4) + "/" + dia_actual.substring(4, 6);
                        this.Hora_Inicial = hora_actual.substring(0, 2) + ":" + hora_actual.substring(2, 4) + ":" + hora_actual.substring(4, 6);
                        if (!this.isActualDate(this.Fecha_Inicial, this.Hora_Inicial, this.fecha_hora)) {
                           ++this.tramas_simplificadas;
                        } else {
                           this.ComprobarFechaHora(this.Fecha_Inicial, this.Hora_Inicial, 1);
                           trama1 = true;
                           if (this.idgps.contains("\u0000")) {
                              fechahora = "Esta Trayectoria no se puede Transferir. Existe una pérdida<br/>de id del GPS. Póngase en contacto con el personal de GCOM<br/>o con el Puesto de Mando de GEOCUBA para arreglar la situación.";
                              this.ShowMessage(fechahora, "Error", "Error");
                              System.exit(0);
                           }

                           trama1 = true;
                           anterior.vacio = false;
                           if (vel_actual == 0.0D && dist_actual == anterior.dis) {
                              fecha_de_parada = anterior.dia;
                              hora_de_parada = anterior.hora;
                              lat_parada = String.valueOf(anterior.lat);
                              lon_parada = String.valueOf(anterior.lon);
                              vehiculo_detenido = true;
                           }

                           this.BoundingBox(Double.valueOf(lon_actual), Double.valueOf(lat_actual));
                           stopidx = this.NoParada;
                           ++orden;
                           fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                           this.Adicionar_Linea_shpTReal(Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(pin_actual), vel_actual / 1.853D, fechahora, orden, stopidx, 0.0D);
                           ++indice_trama;
                           System.out.println("\n " + dia_actual + "," + hora_actual);
                        }
                        continue;
                     }

                     dia_actual = "";
                     hora_actual = "";
                     ++this.tramas_simplificadas;
                     continue;
                  }

                  if (hora_actual.equalsIgnoreCase(anterior.hora)) {
                     ++this.tramas_simplificadas;
                     continue;
                  }

                  f = dia_actual.substring(0, 2) + "/" + dia_actual.substring(2, 4) + "/" + dia_actual.substring(4, 6);
                  h = hora_actual.substring(0, 2) + ":" + hora_actual.substring(2, 4) + ":" + hora_actual.substring(4, 6);
                  fh = f + " " + h;
                  if (!this.ComprobarBB(Double.valueOf(lat_actual), Double.valueOf(lon_actual))) {
                     ++this.tramas_simplificadas;
                     continue;
                  }

                  if (!this.isDate(fh)) {
                     ++this.tramas_simplificadas;
                     continue;
                  }

                  if (!this.isActualDate(f, h, this.fecha_hora)) {
                     ++this.tramas_simplificadas;
                     continue;
                  }

                  if (this.ComparaFecha(this.Fecha_Final, f, this.Hora_Final, h, 2)) {
                     this.Fecha_Final = f;
                     this.Hora_Final = h;
                  }

                  if (dist_actual > anterior.dis) {
                     this.distancia_recorrida_total += dist_actual - anterior.dis;
                  } else if (dist_actual == 0.0D || dist_actual == anterior.dis) {
                     this.distancia_recorrida_total += 0.0D;
                  }

                  int diferencia = this.Falta_de_TramasGPSE(dia_actual, hora_actual, anterior.dia, anterior.hora);
                  Desconexion dk;
                  if (diferencia == 0 && !vehiculo_detenido && !Desconexion_ahorro_de_energia && codAlarm_actual.equalsIgnoreCase("00")) {
                     Desconexion_por_Falta_de_Tramas = true;
                     fecha_desconexion = anterior.dia;
                     hora_desconexion = anterior.hora;
                     latitud_desconexion = String.valueOf(anterior.lat);
                     lon_desconexion = String.valueOf(anterior.lon);
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     fdesc = this.ObtenerFecha(fecha_desconexion, hora_desconexion, 1);
                     dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(latitud_desconexion), Double.valueOf(lon_desconexion), 5);
                     this.Desconexiones.add(dk);
                     fecha_desconexion = "";
                     hora_desconexion = "";
                     latitud_desconexion = "";
                     lon_desconexion = "";
                     latitud_conexion = "";
                     lon_desconexion = "";
                     Desconexion_por_Falta_de_Tramas = false;
                  }

                  if (codAlarm_actual.equalsIgnoreCase("03")) {
                     fecha_desAlimentac = dia_actual;
                     hora_desAlimentac = hora_actual;
                     lat_desAlimentac = String.valueOf(lat_actual);
                     lon_desAlimentac = String.valueOf(lon_actual);
                     Desconexion_AlimentacExterna_Ausente = true;
                  }

                  if ((codAlarm_actual.equalsIgnoreCase("04") || codAlarm_actual.equalsIgnoreCase("10") || codAlarm_actual.equalsIgnoreCase("0A")) && Desconexion_AlimentacExterna_Ausente) {
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     fdesc = this.ObtenerFecha(fecha_desAlimentac, hora_desAlimentac, 1);
                     dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAlimentac), Double.valueOf(lon_desAlimentac), 3);
                     this.Desconexiones.add(dk);
                     fecha_desAlimentac = "";
                     hora_desAlimentac = "";
                     lat_desAlimentac = "";
                     lon_desAlimentac = "";
                     latitud_conexion = "";
                     lon_desconexion = "";
                     Desconexion_AlimentacExterna_Ausente = false;
                  }

                  if ((codAlarm_actual.equalsIgnoreCase("144") || codAlarm_actual.equalsIgnoreCase("90")) && !Desconexion_de_Antena) {
                     Desconexion_de_Antena = true;
                     fecha_desAntena = dia_actual;
                     hora_desAntena = hora_actual;
                     lat_desAntena = String.valueOf(lat_actual);
                     lon_desAntena = String.valueOf(lon_actual);
                  }

                  if ((codAlarm_actual.equalsIgnoreCase("145") || codAlarm_actual.equalsIgnoreCase("91")) && Desconexion_de_Antena) {
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     fdesc = this.ObtenerFecha(fecha_desAntena, hora_desAntena, 1);
                     dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAntena), Double.valueOf(lon_desAntena), 8);
                     this.Desconexiones.add(dk);
                     fecha_desAntena = "";
                     hora_desAntena = "";
                     lat_desAntena = "";
                     lon_desAntena = "";
                     latitud_conexion = "";
                     lon_desconexion = "";
                     Desconexion_de_Antena = false;
                  }

                  if ((codAlarm_actual.equalsIgnoreCase("146") || codAlarm_actual.equalsIgnoreCase("92")) && !Desconexion_de_Antena) {
                     Desconexion_Tiemp_sin_Satelite = true;
                     fecha_desTiemSinSat = dia_actual;
                     hora_desTiemSinSat = hora_actual;
                     lat_desTiemSinSat = String.valueOf(lat_actual);
                     lon_desTiemSinSat = String.valueOf(lon_actual);
                  }

                  if ((codAlarm_actual.equalsIgnoreCase("147") || codAlarm_actual.equalsIgnoreCase("93")) && Desconexion_Tiemp_sin_Satelite) {
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     fdesc = this.ObtenerFecha(fecha_desTiemSinSat, hora_desTiemSinSat, 1);
                     dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desTiemSinSat), Double.valueOf(lon_desTiemSinSat), 6);
                     this.Desconexiones.add(dk);
                     fecha_desTiemSinSat = "";
                     hora_desTiemSinSat = "";
                     lat_desTiemSinSat = "";
                     lon_desTiemSinSat = "";
                     latitud_conexion = "";
                     lon_desconexion = "";
                     Desconexion_Tiemp_sin_Satelite = false;
                  }

                  if ((codAlarm_actual.equalsIgnoreCase("10") || codAlarm_actual.equalsIgnoreCase("0A")) && Desconexion_ahorro_de_energia) {
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     fdesc = this.ObtenerFecha(fecha_ahorr_energ, hora_ahorr_energ, 1);
                     dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_des_ahorr_energ), Double.valueOf(lon_des_ahorr_energ), 3);
                     this.Desconexiones.add(dk);
                     fecha_ahorr_energ = "";
                     hora_ahorr_energ = "";
                     lat_des_ahorr_energ = "";
                     lon_des_ahorr_energ = "";
                     latitud_conexion = "";
                     lon_desconexion = "";
                     Desconexion_ahorro_de_energia = false;
                     Desconexion_por_Falta_de_Tramas = false;
                  }

                  if ((codAlarm_actual.equalsIgnoreCase("12") || codAlarm_actual.equalsIgnoreCase("0C")) && fecha_ahorr_energ.equalsIgnoreCase("") && hora_ahorr_energ.equalsIgnoreCase("")) {
                     Desconexion_ahorro_de_energia = true;
                     fecha_ahorr_energ = dia_actual;
                     hora_ahorr_energ = hora_actual;
                     lat_des_ahorr_energ = String.valueOf(lat_actual);
                     lon_des_ahorr_energ = String.valueOf(lon_actual);
                  }

                  ViolacionVelocidad violacVelc;
                  if (vel_actual == 0.0D && dist_actual == anterior.dis && !vehiculo_detenido) {
                     if (violacion) {
                        ff_violacion = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
                        violacVelc = new ViolacionVelocidad(fi_violacion, ff_violacion, Double.valueOf(latInicioViolac), Double.valueOf(lonInicioViolac), Double.valueOf(lat_actual), Double.valueOf(lon_actual), (this.distancia_recorrida_total - distInicioViolac) * 1000.0D, velcMaxViolacion / 0.853D);
                        this.ViolacionesVelc.add(violacVelc);
                        violacion = false;
                        fi_violacion = "";
                        ff_violacion = "";
                        latInicioViolac = "";
                        lonInicioViolac = "";
                        velcMaxViolacion = 0.0D;
                        distInicioViolac = 0.0D;
                        distFinViolac = 0.0D;
                     }

                     vehiculo_detenido = true;
                     fecha_de_parada = anterior.dia;
                     hora_de_parada = anterior.hora;
                     lat_parada = String.valueOf(anterior.lat);
                     lon_parada = String.valueOf(anterior.lon);
                     this.BoundingBox(Double.valueOf(lon_actual), Double.valueOf(lat_actual));
                     stopidx = this.NoParada;
                     ++orden;
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     this.Adicionar_Linea_shpTReal(Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(pin_actual), vel_actual / 1.853D, fechahora, orden, stopidx, this.distancia_recorrida_total * 1000.0D);
                     ++indice_trama;
                  }

                  if (vel_actual > 0.0D && dist_actual > anterior.dis && vehiculo_detenido) {
                     long time;
                     if (fecha_de_parada.equalsIgnoreCase("") && hora_de_parada.equalsIgnoreCase("")) {
                        f1 = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        time = this.Tiempo_entre_Tramas(anterior.dia, dia_actual, anterior.hora, hora_actual);
                        this.tiempo_total_paradas += time;
                     } else {
                        f1 = this.ObtenerFecha(fecha_de_parada, hora_de_parada, 1);
                        time = this.Tiempo_entre_Tramas(fecha_de_parada, anterior.dia, hora_de_parada, anterior.hora);
                        this.tiempo_total_paradas += time;
                     }

                     String f2 = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
                     if (time >= 60L) {
                        int tiempo = (int)(time / 60L);
                        Detenciones det = new Detenciones(this.NoParada, this.Chapa.getText(), f1, f2, tiempo, Double.valueOf(lat_parada), Double.valueOf(lon_parada), this.distancia_recorrida_total * 1000.0D, orden);
                        this.Paradas.add(det);
                        ++this.NoParada;
                     }

                     if (vel_actual >= this.VelocLimite && !violacion) {
                        violacion = true;
                        fi_violacion = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        latInicioViolac = lat_actual;
                        lonInicioViolac = lon_actual;
                        velcMaxViolacion = vel_actual;
                        distInicioViolac = this.distancia_recorrida_total;
                     }

                     fecha_de_parada = "";
                     hora_de_parada = "";
                     lat_parada = "";
                     lon_parada = "";
                     vehiculo_detenido = false;
                  }

                  if (vel_actual > 0.0D && dist_actual > anterior.dis && !vehiculo_detenido) {
                     if (this.velocidad_maxima < vel_actual) {
                        this.velocidad_maxima = vel_actual;
                     }

                     if (violacion) {
                        if (vel_actual >= this.VelocLimite) {
                           if (velcMaxViolacion < vel_actual) {
                              velcMaxViolacion = vel_actual;
                           }

                           distFinViolac = this.distancia_recorrida_total;
                        } else {
                           ff_violacion = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
                           violacVelc = new ViolacionVelocidad(fi_violacion, ff_violacion, Double.valueOf(latInicioViolac), Double.valueOf(lonInicioViolac), Double.valueOf(lat_actual), Double.valueOf(lon_actual), (this.distancia_recorrida_total - distInicioViolac) * 1000.0D, velcMaxViolacion / 0.853D);
                           this.ViolacionesVelc.add(violacVelc);
                           violacion = false;
                           fi_violacion = "";
                           ff_violacion = "";
                           latInicioViolac = "";
                           lonInicioViolac = "";
                           velcMaxViolacion = 0.0D;
                           distInicioViolac = 0.0D;
                           distFinViolac = 0.0D;
                        }
                     } else if (vel_actual >= this.VelocLimite) {
                        violacion = true;
                        fi_violacion = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        latInicioViolac = lat_actual;
                        lonInicioViolac = lon_actual;
                        velcMaxViolacion = vel_actual;
                        distInicioViolac = this.distancia_recorrida_total;
                     } else {
                        violacion = false;
                        fi_violacion = "";
                        ff_violacion = "";
                        latInicioViolac = "";
                        lonInicioViolac = "";
                        velcMaxViolacion = 0.0D;
                        distInicioViolac = 0.0D;
                        distFinViolac = 0.0D;
                     }

                     suma_vel += vel_actual;
                     ++contador;
                     this.BoundingBox(Double.valueOf(lon_actual), Double.valueOf(lat_actual));
                     fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                     ++orden;
                     this.Adicionar_Linea_shpTReal(Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(pin_actual), vel_actual / 1.853D, fechahora, orden, stopidx, this.distancia_recorrida_total * 1000.0D);
                     ++indice_trama;
                     fecha_de_parada = "";
                     hora_de_parada = "";
                     lat_parada = "";
                     lon_parada = "";
                     vehiculo_detenido = false;
                  }
               }

               anterior.dia = dia_actual;
               anterior.hora = hora_actual;
               anterior.lon = Double.valueOf(lon_actual);
               anterior.lat = Double.valueOf(lat_actual);
               anterior.velocidad = vel_actual;
               anterior.dis = dist_actual;
               anterior.pin = Double.valueOf(pin_actual);
            }
         } catch (Exception var100) {
            var100.printStackTrace();
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, (String)null, var100);
         }
      }

      this.velocidad_promedio = suma_vel / (double)contador;
      Desconexion dk;
      if (Desconexion_AlimentacExterna_Ausente) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_desAlimentac, hora_desAlimentac, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAlimentac), Double.valueOf(lon_desAlimentac), 3);
         this.Desconexiones.add(dk);
         fecha_desAlimentac = "";
         hora_desAlimentac = "";
         lat_desAlimentac = "";
         lon_desAlimentac = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_AlimentacExterna_Ausente = false;
      }

      if (Desconexion_de_Antena) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_desAntena, hora_desAntena, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAntena), Double.valueOf(lon_desAntena), 8);
         this.Desconexiones.add(dk);
         fecha_desAntena = "";
         hora_desAntena = "";
         lat_desAntena = "";
         lon_desAntena = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_de_Antena = false;
      }

      if (Desconexion_Tiemp_sin_Satelite) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_desTiemSinSat, hora_desTiemSinSat, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desTiemSinSat), Double.valueOf(lon_desTiemSinSat), 6);
         this.Desconexiones.add(dk);
         fecha_desTiemSinSat = "";
         hora_desTiemSinSat = "";
         lat_desTiemSinSat = "";
         lon_desTiemSinSat = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_Tiemp_sin_Satelite = false;
      }

      if (Desconexion_ahorro_de_energia) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_ahorr_energ, hora_ahorr_energ, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_des_ahorr_energ), Double.valueOf(lon_des_ahorr_energ), 3);
         this.Desconexiones.add(dk);
         fecha_ahorr_energ = "";
         hora_ahorr_energ = "";
         lat_des_ahorr_energ = "";
         lon_des_ahorr_energ = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_ahorro_de_energia = false;
         Desconexion_por_Falta_de_Tramas = false;
      }

      if (vel_actual == 0.0D && dist_actual == anterior.dis && vehiculo_detenido) {
         long time;
         if (fecha_de_parada.equalsIgnoreCase("") && hora_de_parada.equalsIgnoreCase("")) {
            fdesc = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
            time = this.Tiempo_entre_Tramas(anterior.dia, dia_actual, anterior.hora, hora_actual);
            this.tiempo_total_paradas += time;
         } else {
            fdesc = this.ObtenerFecha(fecha_de_parada, hora_de_parada, 1);
            time = this.Tiempo_entre_Tramas(fecha_de_parada, dia_actual, hora_de_parada, hora_actual);
            this.tiempo_total_paradas += time;
         }

         f1 = this.ObtenerFecha(dia_actual, hora_actual, 1);
         int tiempo = (int)(time / 60L);
         Detenciones det = new Detenciones(this.NoParada, this.Chapa.getText(), fdesc, f1, tiempo, Double.valueOf(lat_parada), Double.valueOf(lon_parada), this.distancia_recorrida_total * 1000.0D, orden);
         this.Paradas.add(det);
         ++this.NoParada;
         fecha_de_parada = "";
         hora_de_parada = "";
         lat_parada = "";
         lon_parada = "";
      }

      this.shape.closeFeatureWriter1();
      reader.close();
      return true;
   }

   public boolean Transferir_FicheroCabv3(File por_transferir) throws IOException, ParseException, ParseException, Exception {
      String camino = "Temp\\SHPTemporal\\Trayectoria.shp";
      this.shp = new File(camino);
      if (this.shp.exists()) {
         this.BorrarDirectorio("Temp\\SHPTemporal");
      }

      this.shape.initFeatureWriterCabv3(camino);
      this.Crear_Fichero_Salida();
      this.cabv3.LeerCabv3(por_transferir);
      BufferedReader reader = new BufferedReader(new FileReader(this.cabv3.mifilecabv3));
      String linea = "";
      String[] partes_de_linea = new String[22];
      boolean vehiculo_detenido = false;
      String fecha_de_parada = "";
      String hora_de_parada = "";
      String lat_parada = "";
      String lon_parada = "";
      double dis_parada = 0.0D;
      double vel_actual = 0.0D;
      String lon_actual = "";
      String lat_actual = "";
      String dia_actual = "";
      String hora_actual = "";
      String status = "";
      String altura = "";
      String mov_actual = "";
      String est_conect = "";
      double odometro_actual = 0.0D;
      double dist_actual = 0.0D;
      double dist_inicial = 0.0D;
      double dist_final = 0.0D;
      String numSat_actual = "";
      String rumbo_actual = "";
      String edadPos_actual = "";
      String codAlarm_actual = "";
      String pin_actual = "";
      String entradas_discretas = "";
      int cant_analogicas = false;
      String entradas_analogicas = "";
      double suma_vel = 0.0D;
      int contador = 0;
      boolean Desconexion_por_Falta_de_Tramas = false;
      boolean Desconexion_AlimentacExterna_Ausente = false;
      boolean Desconexion_de_Antena = false;
      boolean Desconexion_Tiemp_sin_Satelite = false;
      boolean Desconexion_ahorro_de_energia = false;
      String fecha_desconexion = "";
      String hora_desconexion = "";
      String fecha_desAlimentac = "";
      String hora_desAlimentac = "";
      String lat_desAlimentac = "";
      String lon_desAlimentac = "";
      String fecha_desAntena = "";
      String hora_desAntena = "";
      String lat_desAntena = "";
      String lon_desAntena = "";
      String fecha_desTiemSinSat = "";
      String hora_desTiemSinSat = "";
      String lat_desTiemSinSat = "";
      String lon_desTiemSinSat = "";
      String fecha_desIgnicion = "";
      String hora_desIgnicion = "";
      String lat_desIgnicion = "";
      String lon_desIgnicion = "";
      String fecha_ahorr_energ = "";
      String hora_ahorr_energ = "";
      String lat_des_ahorr_energ = "";
      String lon_des_ahorr_energ = "";
      String latitud_desconexion = "";
      String lon_desconexion = "";
      String latitud_conexion = "";
      String lon_conexion = "";
      boolean trama_significativa = false;
      boolean salto_fecha = false;
      boolean se_desconecto = false;
      boolean se_movio = false;
      String q = null;
      int trama1 = false;
      String f = "";
      String h = "";
      String fh = "";
      double dist = 0.0D;
      double vel = 0.0D;
      double ang = 0.0D;
      int indice_trama = 0;
      double dist_acumulada = 0.0D;
      int stopidx = -1;
      int orden = -1;
      Entrada.anterior anterior = new Entrada.anterior();
      boolean violacion = false;
      String fi_violacion = "";
      String ff_violacion = "";
      double velcMaxViolacion = 0.0D;
      String latInicioViolac = "";
      String lonInicioViolac = "";
      double distInicioViolac = 0.0D;
      double distFinViolac = 0.0D;
      this.PBLabel.setText("Procesando Trayectoria...");
      this.PB.setVisible(true);
      this.PBLabel.setVisible(true);
      this.Motivo_Error = 2;
      this.fecha_hora = this.Fecha_Hora_Actual_Servidor();
      String FH = this.fecha_hora.substring(0, 4) + this.fecha_hora.substring(5, 7) + this.fecha_hora.substring(8, 10) + this.fecha_hora.substring(11, 13) + this.fecha_hora.substring(14, 16);
      this.logid = this.Chapa.getText() + FH;

      String fechahora;
      String fdesc;
      String fechahora;
      String f1;
      while((linea = reader.readLine()) != null) {
         try {
            ++this.numero_de_lineas;
            if (!linea.equalsIgnoreCase("")) {
               if (this.numero_de_lineas == 3167L) {
                  q = "Quieto";
               }

               int longitud_de_linea = linea.length();
               if (this.numero_de_lineas == 1L) {
                  this.idgps = linea.trim();
               } else {
                  if (longitud_de_linea >= 28 && longitud_de_linea < 130) {
                     partes_de_linea = linea.split(",");
                     dia_actual = partes_de_linea[0].trim();
                     hora_actual = partes_de_linea[1].trim();
                     status = partes_de_linea[2].trim();
                     lat_actual = partes_de_linea[3].trim();
                     lon_actual = partes_de_linea[4].trim();
                     altura = partes_de_linea[5].trim();
                     if (altura.equalsIgnoreCase("")) {
                        altura = "0";
                     }

                     vel_actual = Double.valueOf(partes_de_linea[6].trim());
                     pin_actual = partes_de_linea[7].trim();
                     if (pin_actual.equalsIgnoreCase("")) {
                        pin_actual = "0";
                     }

                     dist_actual = Double.valueOf(partes_de_linea[8].trim());
                     entradas_discretas = partes_de_linea[9].trim();
                     int cant_analogicas = Integer.parseInt(partes_de_linea[10].trim());
                     codAlarm_actual = this.cabv3.getStare(status);
                     if (codAlarm_actual.substring(15, 16).equalsIgnoreCase("1")) {
                        ++this.tramas_no_validas;
                        continue;
                     }

                     if (codAlarm_actual.substring(14, 15).equalsIgnoreCase("1")) {
                        mov_actual = "0";
                     } else {
                        mov_actual = "1";
                     }

                     if (anterior.vacio) {
                        anterior.dia = dia_actual;
                        anterior.hora = hora_actual;
                        anterior.lon = Double.valueOf(lon_actual);
                        anterior.lat = Double.valueOf(lat_actual);
                        anterior.altura = Double.valueOf(altura);
                        anterior.velocidad = vel_actual;
                        anterior.dis = dist_actual;
                        anterior.codAlarm = codAlarm_actual;
                        anterior.pin = Double.valueOf(pin_actual);
                        anterior.moviendo = mov_actual;
                        anterior.entradas_discretas = entradas_discretas;
                        anterior.cant_analogicas = cant_analogicas;
                        if (dia_actual.length() == 6 && hora_actual.length() == 6) {
                           this.Fecha_Inicial = dia_actual.substring(0, 2) + "/" + dia_actual.substring(2, 4) + "/" + dia_actual.substring(4, 6);
                           this.Hora_Inicial = hora_actual.substring(0, 2) + ":" + hora_actual.substring(2, 4) + ":" + hora_actual.substring(4, 6);
                           if (!this.isActualDate(this.Fecha_Inicial, this.Hora_Inicial, this.fecha_hora)) {
                              ++this.tramas_simplificadas;
                           } else {
                              this.ComprobarFechaHora(this.Fecha_Inicial, this.Hora_Inicial, 1);
                              if (this.idgps.contains("\u0000")) {
                                 fechahora = "Esta Trayectoria no se puede Transferir. Existe una pérdida<br/>de id del GPS. Póngase en contacto con el personal de GCOM<br/>o con el Puesto de Mando de GEOCUBA para arreglar la situación.<br/>¿Desea enviar la Trayectoria para el ftp para que el PAT la analice?";
                                 int n = JOptionPane.showConfirmDialog(this, fechahora, "Mensaje de Confirmación", 0);
                                 if (n == 0) {
                                    this.Motivo_Error = 3;
                                    Error e = new Error(this);
                                    e.Mostrar();
                                 } else {
                                    System.exit(0);
                                 }
                              }

                              trama1 = true;
                              anterior.vacio = false;
                              if (mov_actual.equalsIgnoreCase("0")) {
                                 fecha_de_parada = dia_actual;
                                 hora_de_parada = hora_actual;
                                 lat_parada = lat_actual;
                                 lon_parada = lon_actual;
                                 vehiculo_detenido = true;
                                 dis_parada = this.distancia_recorrida_total;
                              }

                              this.BoundingBox(Double.valueOf(lon_actual), Double.valueOf(lat_actual));
                              stopidx = this.NoParada;
                              ++orden;
                              fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                              this.Adicionar_Linea_shpCabv3(Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(pin_actual), vel_actual / 1.853D, fechahora, orden, stopidx, mov_actual, 0.0D);
                              ++indice_trama;
                           }
                           continue;
                        }

                        dia_actual = "";
                        hora_actual = "";
                        ++this.tramas_simplificadas;
                        continue;
                     }

                     if (hora_actual.equalsIgnoreCase(anterior.hora)) {
                        ++this.tramas_simplificadas;
                        continue;
                     }

                     f = dia_actual.substring(0, 2) + "/" + dia_actual.substring(2, 4) + "/" + dia_actual.substring(4, 6);
                     h = hora_actual.substring(0, 2) + ":" + hora_actual.substring(2, 4) + ":" + hora_actual.substring(4, 6);
                     fh = f + " " + h;
                     if (!this.ComprobarBB(Double.valueOf(lat_actual), Double.valueOf(lon_actual))) {
                        ++this.tramas_simplificadas;
                        continue;
                     }

                     if (!this.isDate(fh)) {
                        ++this.tramas_simplificadas;
                        continue;
                     }

                     if (!this.isActualDate(f, h, this.fecha_hora)) {
                        ++this.tramas_simplificadas;
                        continue;
                     }

                     if (this.ComparaFecha(this.Fecha_Final, f, this.Hora_Final, h, 2)) {
                        this.Fecha_Final = f;
                        this.Hora_Final = h;
                     }

                     if (dist_actual > anterior.dis) {
                        this.distancia_recorrida_total += dist_actual - anterior.dis;
                     } else if (dist_actual == 0.0D || dist_actual == anterior.dis) {
                        this.distancia_recorrida_total += 0.0D;
                     }

                     int diferencia = this.Falta_de_TramasGPSE(dia_actual, hora_actual, anterior.dia, anterior.hora);
                     Desconexion dk;
                     if (diferencia == 0 && anterior.moviendo.equalsIgnoreCase("1")) {
                        Desconexion_por_Falta_de_Tramas = true;
                        fecha_desconexion = anterior.dia;
                        hora_desconexion = anterior.hora;
                        latitud_desconexion = String.valueOf(anterior.lat);
                        lon_desconexion = String.valueOf(anterior.lon);
                        fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        fdesc = this.ObtenerFecha(fecha_desconexion, hora_desconexion, 1);
                        dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(latitud_desconexion), Double.valueOf(lon_desconexion), 5);
                        this.Desconexiones.add(dk);
                        fecha_desconexion = "";
                        hora_desconexion = "";
                        latitud_desconexion = "";
                        lon_desconexion = "";
                        latitud_conexion = "";
                        lon_desconexion = "";
                        Desconexion_por_Falta_de_Tramas = false;
                     }

                     if (codAlarm_actual.substring(5, 6).equalsIgnoreCase("1") && !Desconexion_AlimentacExterna_Ausente) {
                        fecha_desAlimentac = dia_actual;
                        hora_desAlimentac = hora_actual;
                        lat_desAlimentac = String.valueOf(lat_actual);
                        lon_desAlimentac = String.valueOf(lon_actual);
                        Desconexion_AlimentacExterna_Ausente = true;
                     }

                     if (codAlarm_actual.substring(5, 6).equalsIgnoreCase("0") && Desconexion_AlimentacExterna_Ausente) {
                        fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        fdesc = this.ObtenerFecha(fecha_desAlimentac, hora_desAlimentac, 1);
                        dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAlimentac), Double.valueOf(lon_desAlimentac), 3);
                        this.Desconexiones.add(dk);
                        fecha_desAlimentac = "";
                        hora_desAlimentac = "";
                        lat_desAlimentac = "";
                        lon_desAlimentac = "";
                        latitud_conexion = "";
                        lon_desconexion = "";
                        Desconexion_AlimentacExterna_Ausente = false;
                     }

                     if (codAlarm_actual.substring(6, 7).contentEquals("0")) {
                        Desconexion_de_Antena = true;
                        fecha_desAntena = dia_actual;
                        hora_desAntena = hora_actual;
                        lat_desAntena = String.valueOf(lat_actual);
                        lon_desAntena = String.valueOf(lon_actual);
                     }

                     if (codAlarm_actual.substring(6, 7).contentEquals("1") && Desconexion_de_Antena) {
                        fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        fdesc = this.ObtenerFecha(fecha_desAntena, hora_desAntena, 1);
                        dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAntena), Double.valueOf(lon_desAntena), 8);
                        this.Desconexiones.add(dk);
                        fecha_desAntena = "";
                        hora_desAntena = "";
                        lat_desAntena = "";
                        lon_desAntena = "";
                        latitud_conexion = "";
                        lon_desconexion = "";
                        Desconexion_de_Antena = false;
                     }

                     if (codAlarm_actual.substring(15, 16).equalsIgnoreCase("1") && !Desconexion_Tiemp_sin_Satelite) {
                        Desconexion_Tiemp_sin_Satelite = true;
                        fecha_desTiemSinSat = dia_actual;
                        hora_desTiemSinSat = hora_actual;
                        lat_desTiemSinSat = String.valueOf(lat_actual);
                        lon_desTiemSinSat = String.valueOf(lon_actual);
                     }

                     if (codAlarm_actual.substring(15, 16).equalsIgnoreCase("0") && Desconexion_Tiemp_sin_Satelite) {
                        fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        fdesc = this.ObtenerFecha(fecha_desTiemSinSat, hora_desTiemSinSat, 1);
                        dk = new Desconexion(this.chapa, fechahora, fdesc, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desTiemSinSat), Double.valueOf(lon_desTiemSinSat), 6);
                        this.Desconexiones.add(dk);
                        fecha_desTiemSinSat = "";
                        hora_desTiemSinSat = "";
                        lat_desTiemSinSat = "";
                        lon_desTiemSinSat = "";
                        latitud_conexion = "";
                        lon_desconexion = "";
                        Desconexion_Tiemp_sin_Satelite = false;
                     }

                     ViolacionVelocidad violacVelc;
                     if (dist_actual == anterior.dis && vel_actual == 0.0D && mov_actual.equalsIgnoreCase("0") && !vehiculo_detenido) {
                        if (violacion) {
                           ff_violacion = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
                           violacVelc = new ViolacionVelocidad(fi_violacion, ff_violacion, Double.valueOf(latInicioViolac), Double.valueOf(lonInicioViolac), Double.valueOf(lat_actual), Double.valueOf(lon_actual), this.distancia_recorrida_total - distInicioViolac, velcMaxViolacion / 0.853D);
                           this.ViolacionesVelc.add(violacVelc);
                           violacion = false;
                           fi_violacion = "";
                           ff_violacion = "";
                           latInicioViolac = "";
                           lonInicioViolac = "";
                           velcMaxViolacion = 0.0D;
                           distInicioViolac = 0.0D;
                           distFinViolac = 0.0D;
                        }

                        vehiculo_detenido = true;
                        fecha_de_parada = anterior.dia;
                        hora_de_parada = anterior.hora;
                        lat_parada = String.valueOf(anterior.lat);
                        lon_parada = String.valueOf(anterior.lon);
                        dis_parada = this.distancia_recorrida_total;
                        this.BoundingBox(Double.valueOf(lon_actual), Double.valueOf(lat_actual));
                        stopidx = this.NoParada;
                        ++orden;
                        fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        this.Adicionar_Linea_shpCabv3(Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(pin_actual), vel_actual / 1.853D, fechahora, orden, stopidx, mov_actual, this.distancia_recorrida_total);
                        ++indice_trama;
                        anterior.dia = dia_actual;
                        anterior.hora = hora_actual;
                        anterior.lon = Double.valueOf(lon_actual);
                        anterior.lat = Double.valueOf(lat_actual);
                        anterior.altura = Double.valueOf(altura);
                        anterior.velocidad = vel_actual;
                        anterior.dis = dist_actual;
                        anterior.codAlarm = codAlarm_actual;
                        anterior.pin = Double.valueOf(pin_actual);
                        anterior.moviendo = mov_actual;
                        anterior.entradas_discretas = entradas_discretas;
                        anterior.cant_analogicas = cant_analogicas;
                        continue;
                     }

                     if (dist_actual > anterior.dis && vel_actual > 0.0D && mov_actual.equalsIgnoreCase("1") && vehiculo_detenido) {
                        long time;
                        if (fecha_de_parada.equalsIgnoreCase("") && hora_de_parada.equalsIgnoreCase("")) {
                           f1 = this.ObtenerFecha(dia_actual, hora_actual, 1);
                           time = this.Tiempo_entre_Tramas(anterior.dia, dia_actual, anterior.hora, hora_actual);
                           this.tiempo_total_paradas += time;
                        } else {
                           f1 = this.ObtenerFecha(fecha_de_parada, hora_de_parada, 1);
                           time = this.Tiempo_entre_Tramas(fecha_de_parada, anterior.dia, hora_de_parada, anterior.hora);
                           this.tiempo_total_paradas += time;
                        }

                        String f2 = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
                        if (time >= 60L) {
                           int tiempo = (int)(time / 60L);
                           Detenciones det = new Detenciones(this.NoParada, this.Chapa.getText(), f1, f2, tiempo, Double.valueOf(lat_parada), Double.valueOf(lon_parada), dis_parada, orden);
                           this.Paradas.add(det);
                           ++this.NoParada;
                        }

                        if (vel_actual >= this.VelocLimite && !violacion) {
                           violacion = true;
                           fi_violacion = this.ObtenerFecha(dia_actual, hora_actual, 1);
                           latInicioViolac = lat_actual;
                           lonInicioViolac = lon_actual;
                           velcMaxViolacion = vel_actual;
                           distInicioViolac = this.distancia_recorrida_total;
                        }

                        fecha_de_parada = "";
                        hora_de_parada = "";
                        lat_parada = "";
                        lon_parada = "";
                        vehiculo_detenido = false;
                        dis_parada = 0.0D;
                     }

                     if (dist_actual > anterior.dis && vel_actual > 0.0D && mov_actual.equalsIgnoreCase("1") && !vehiculo_detenido) {
                        if (this.velocidad_maxima < vel_actual) {
                           this.velocidad_maxima = vel_actual;
                        }

                        if (violacion) {
                           if (vel_actual >= this.VelocLimite) {
                              if (velcMaxViolacion < vel_actual) {
                                 velcMaxViolacion = vel_actual;
                              }

                              distFinViolac = this.distancia_recorrida_total;
                           } else {
                              ff_violacion = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
                              violacVelc = new ViolacionVelocidad(fi_violacion, ff_violacion, Double.valueOf(latInicioViolac), Double.valueOf(lonInicioViolac), Double.valueOf(lat_actual), Double.valueOf(lon_actual), this.distancia_recorrida_total - distInicioViolac, velcMaxViolacion / 0.853D);
                              this.ViolacionesVelc.add(violacVelc);
                              violacion = false;
                              fi_violacion = "";
                              ff_violacion = "";
                              latInicioViolac = "";
                              lonInicioViolac = "";
                              velcMaxViolacion = 0.0D;
                              distInicioViolac = 0.0D;
                              distFinViolac = 0.0D;
                           }
                        } else if (vel_actual >= this.VelocLimite) {
                           violacion = true;
                           fi_violacion = this.ObtenerFecha(dia_actual, hora_actual, 1);
                           latInicioViolac = lat_actual;
                           lonInicioViolac = lon_actual;
                           velcMaxViolacion = vel_actual;
                           distInicioViolac = this.distancia_recorrida_total;
                        } else {
                           violacion = false;
                           fi_violacion = "";
                           ff_violacion = "";
                           latInicioViolac = "";
                           lonInicioViolac = "";
                           velcMaxViolacion = 0.0D;
                           distInicioViolac = 0.0D;
                           distFinViolac = 0.0D;
                        }

                        suma_vel += vel_actual;
                        ++contador;
                        this.BoundingBox(Double.valueOf(lon_actual), Double.valueOf(lat_actual));
                        fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
                        ++orden;
                        this.Adicionar_Linea_shpCabv3(Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(pin_actual), vel_actual / 1.853D, fechahora, orden, stopidx, mov_actual, this.distancia_recorrida_total);
                        ++indice_trama;
                     }
                  }

                  anterior.dia = dia_actual;
                  anterior.hora = hora_actual;
                  anterior.lon = Double.valueOf(lon_actual);
                  anterior.lat = Double.valueOf(lat_actual);
                  anterior.velocidad = vel_actual;
                  anterior.dis = dist_actual;
                  anterior.pin = Double.valueOf(pin_actual);
                  anterior.moviendo = mov_actual;
               }
            }
         } catch (Exception var114) {
            var114.printStackTrace();
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, (String)null, var114);
         }
      }

      this.velocidad_promedio = suma_vel / (double)contador;
      Desconexion dk;
      if (Desconexion_AlimentacExterna_Ausente) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_desAlimentac, hora_desAlimentac, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAlimentac), Double.valueOf(lon_desAlimentac), 3);
         this.Desconexiones.add(dk);
         fecha_desAlimentac = "";
         hora_desAlimentac = "";
         lat_desAlimentac = "";
         lon_desAlimentac = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_AlimentacExterna_Ausente = false;
      }

      if (Desconexion_de_Antena) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_desAntena, hora_desAntena, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desAntena), Double.valueOf(lon_desAntena), 8);
         this.Desconexiones.add(dk);
         fecha_desAntena = "";
         hora_desAntena = "";
         lat_desAntena = "";
         lon_desAntena = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_de_Antena = false;
      }

      if (Desconexion_Tiemp_sin_Satelite) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_desTiemSinSat, hora_desTiemSinSat, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_desTiemSinSat), Double.valueOf(lon_desTiemSinSat), 6);
         this.Desconexiones.add(dk);
         fecha_desTiemSinSat = "";
         hora_desTiemSinSat = "";
         lat_desTiemSinSat = "";
         lon_desTiemSinSat = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_Tiemp_sin_Satelite = false;
      }

      if (Desconexion_ahorro_de_energia) {
         fechahora = this.ObtenerFecha(dia_actual, hora_actual, 1);
         fechahora = this.ObtenerFecha(fecha_ahorr_energ, hora_ahorr_energ, 1);
         dk = new Desconexion(this.chapa, fechahora, fechahora, Double.valueOf(lat_actual), Double.valueOf(lon_actual), Double.valueOf(lat_des_ahorr_energ), Double.valueOf(lon_des_ahorr_energ), 3);
         this.Desconexiones.add(dk);
         fecha_ahorr_energ = "";
         hora_ahorr_energ = "";
         lat_des_ahorr_energ = "";
         lon_des_ahorr_energ = "";
         latitud_conexion = "";
         lon_desconexion = "";
         Desconexion_ahorro_de_energia = false;
         Desconexion_por_Falta_de_Tramas = false;
      }

      if (dist_actual == anterior.dis && vehiculo_detenido) {
         long time;
         if (fecha_de_parada.equalsIgnoreCase("") && hora_de_parada.equalsIgnoreCase("")) {
            fdesc = this.ObtenerFecha(anterior.dia, anterior.hora, 1);
            time = this.Tiempo_entre_Tramas(anterior.dia, dia_actual, anterior.hora, hora_actual);
            this.tiempo_total_paradas += time;
         } else {
            fdesc = this.ObtenerFecha(fecha_de_parada, hora_de_parada, 1);
            time = this.Tiempo_entre_Tramas(fecha_de_parada, dia_actual, hora_de_parada, hora_actual);
            this.tiempo_total_paradas += time;
         }

         f1 = this.ObtenerFecha(dia_actual, hora_actual, 1);
         int tiempo = (int)(time / 60L);
         Detenciones det = new Detenciones(this.NoParada, this.Chapa.getText(), fdesc, f1, tiempo, Double.valueOf(lat_parada), Double.valueOf(lon_parada), dis_parada, orden);
         this.Paradas.add(det);
         ++this.NoParada;
         fecha_de_parada = "";
         hora_de_parada = "";
         lat_parada = "";
         lon_parada = "";
      }

      this.shape.closeFeatureWriter1();
      reader.close();
      return true;
   }

   public static double getAngle(Point2D p1, Point2D p2) {
      double dx = p2.getX() - p1.getX();
      double dy = p2.getY() - p1.getY();
      double ang = Math.atan2(dy, dx);
      if (ang > 0.0D) {
         ang = 1.5707963267948966D - ang;
      } else if (ang > -1.5707963267948966D) {
         ang = 1.5707963267948966D - ang;
      } else {
         ang = -1.5707963267948966D - (ang + 3.141592653589793D);
      }

      double grad = Math.toDegrees(ang);
      return grad;
   }

   public long Tiempo_entre_Tramas(String dia, String dia_actual, String hora, String hora_actual) {
      int initial_day = Integer.parseInt(dia.subSequence(0, 2).toString());
      int initial_month = Integer.parseInt(dia.subSequence(2, 4).toString()) - 1;
      int initial_year = Integer.parseInt(dia.subSequence(4, 6).toString()) + 100;
      int final_day = Integer.parseInt(dia_actual.subSequence(0, 2).toString());
      int final_month = Integer.parseInt(dia_actual.subSequence(2, 4).toString()) - 1;
      int final_year = Integer.parseInt(dia_actual.subSequence(4, 6).toString()) + 100;
      int initial_hour = Integer.parseInt(hora.subSequence(0, 2).toString());
      int initial_min = Integer.parseInt(hora.subSequence(2, 4).toString());
      int initial_seg = Integer.parseInt(hora.subSequence(4, 6).toString());
      int final_min = Integer.parseInt(hora_actual.subSequence(2, 4).toString());
      int final_hour = Integer.parseInt(hora_actual.subSequence(0, 2).toString());
      int final_seg = Integer.parseInt(hora_actual.subSequence(4, 6).toString());
      Date f1 = new Date(final_year, final_month, final_day, final_hour, final_min, final_seg);
      Date f2 = new Date(initial_year, initial_month, initial_day, initial_hour, initial_min, initial_seg);
      long diferencia_seg = Math.abs(f1.getTime() - f2.getTime()) / 1000L;
      return diferencia_seg;
   }

   public boolean ValidarPin(String pin) {
      try {
         double var2 = Double.parseDouble(pin);
         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   public String ObtenerFecha(String dia, String hora, int formatofecha) throws ParseException {
      int dia_inicial = Integer.parseInt(dia.substring(0, 2));
      int mes_inicial = Integer.parseInt(dia.substring(2, 4)) - 1;
      int year_inicial = Integer.parseInt(dia.substring(4, 6)) + 100;
      int hora_inic = Integer.parseInt(hora.substring(0, 2));
      int min_inic = Integer.parseInt(hora.substring(2, 4));
      int seg_inic = Integer.parseInt(hora.substring(4, 6));
      long diferencia = 0L;
      SimpleDateFormat formato = null;
      if (formatofecha == 1) {
         formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      } else if (formatofecha == 2) {
         formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      }

      Date f1 = new Date(year_inicial, mes_inicial, dia_inicial, hora_inic, min_inic, seg_inic);
      diferencia = f1.getTime();
      if (this.Transferencia.compareTo("3") != 0 && this.Transferencia.compareTo("4") != 0) {
         if (this.HorarioVerano) {
            diferencia -= 14400000L;
         } else {
            diferencia -= 18000000L;
         }
      }

      Date f2 = new Date(diferencia);
      String fecha = formato.format(f2);
      return fecha;
   }

   private void initComponents() {
      this.PanelPrincipal = new JPanel();
      this.PBLabel = new JLabel();
      this.User = new JLabel();
      this.Contras = new JLabel();
      this.Usuario = new JTextField();
      this.Password = new JPasswordField();
      this.NumeroChapa = new JLabel();
      this.IndiceConsumo = new JLabel();
      this.Contras4 = new JLabel();
      this.Numero = new JTextField();
      this.Indice = new JTextField();
      this.Chapa = new JTextField();
      this.Opciones = new JLabel();
      this.Opciones1 = new JLabel();
      this.Ayuda = new JLabel();
      this.Ayuda1 = new JLabel();
      this.PB = new JLabel();
      this.Moviles = new JLabel();
      this.ImgAceptar = new JLabel();
      this.Moviles1 = new JLabel();
      this.VersionLabel = new JLabel();
      this.jLabel1 = new JLabel();
      this.ImgAceptar1 = new JLabel();
      this.ChapaCarro = new JLabel();
      this.jLabel2 = new JLabel();
      this.setDefaultCloseOperation(3);
      this.setTitle("Aplicación Diferido  12.66");
      this.setBackground(new Color(175, 205, 194));
      this.setCursor(new Cursor(0));
      this.setFocusable(false);
      this.setResizable(false);
      this.PanelPrincipal.setBackground(new Color(153, 153, 153));
      this.PanelPrincipal.setBorder(BorderFactory.createTitledBorder((Border)null, "", 0, 0, new Font("Tahoma", 1, 14), new Color(255, 0, 0)));
      this.PanelPrincipal.setAlignmentX(0.0F);
      this.PanelPrincipal.setAlignmentY(0.0F);
      this.PanelPrincipal.setFocusCycleRoot(true);
      this.PanelPrincipal.setLayout(new AbsoluteLayout());
      this.PBLabel.setForeground(new Color(0, 0, 102));
      this.PBLabel.setText("Analizando Trayectoria...");
      this.PanelPrincipal.add(this.PBLabel, new AbsoluteConstraints(120, 400, -1, -1));
      this.User.setFont(new Font("Tahoma", 0, 12));
      this.User.setForeground(new Color(0, 0, 102));
      this.User.setText("Usuario:");
      this.PanelPrincipal.add(this.User, new AbsoluteConstraints(80, 135, -1, -1));
      this.Contras.setFont(new Font("Tahoma", 0, 12));
      this.Contras.setForeground(new Color(0, 0, 102));
      this.Contras.setText("Contraseña:");
      this.PanelPrincipal.add(this.Contras, new AbsoluteConstraints(60, 165, -1, -1));
      this.Usuario.setToolTipText("Login del usuario");
      this.Usuario.setBorder(BorderFactory.createBevelBorder(1));
      this.Usuario.setVerifyInputWhenFocusTarget(false);
      this.Usuario.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent evt) {
            Entrada.this.UsuarioKeyPressed(evt);
         }
      });
      this.PanelPrincipal.add(this.Usuario, new AbsoluteConstraints(150, 130, 130, -1));
      this.Password.setBorder(BorderFactory.createBevelBorder(1));
      this.Password.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent evt) {
            Entrada.this.PasswordKeyPressed(evt);
         }
      });
      this.PanelPrincipal.add(this.Password, new AbsoluteConstraints(150, 160, 130, -1));
      this.NumeroChapa.setFont(new Font("Tahoma", 0, 12));
      this.NumeroChapa.setForeground(new Color(0, 0, 102));
      this.NumeroChapa.setText("Número:");
      this.PanelPrincipal.add(this.NumeroChapa, new AbsoluteConstraints(80, 255, -1, -1));
      this.IndiceConsumo.setFont(new Font("Tahoma", 0, 12));
      this.IndiceConsumo.setForeground(new Color(0, 0, 102));
      this.IndiceConsumo.setText("I/C:");
      this.PanelPrincipal.add(this.IndiceConsumo, new AbsoluteConstraints(110, 285, -1, -1));
      this.Contras4.setFont(new Font("Tahoma", 0, 12));
      this.Contras4.setForeground(new Color(0, 0, 102));
      this.Contras4.setText("km/litro");
      this.PanelPrincipal.add(this.Contras4, new AbsoluteConstraints(240, 285, -1, -1));
      this.Numero.setEditable(false);
      this.Numero.setToolTipText("Número del vehículo seleccionado");
      this.Numero.setBorder(BorderFactory.createBevelBorder(1));
      this.Numero.setVerifyInputWhenFocusTarget(false);
      this.PanelPrincipal.add(this.Numero, new AbsoluteConstraints(150, 250, 130, -1));
      this.Indice.setEditable(false);
      this.Indice.setToolTipText("Índice de Consumo del vehículo seleccionado");
      this.Indice.setBorder(BorderFactory.createBevelBorder(1));
      this.Indice.setVerifyInputWhenFocusTarget(false);
      this.PanelPrincipal.add(this.Indice, new AbsoluteConstraints(150, 280, 70, -1));
      this.Chapa.setEditable(false);
      this.Chapa.setToolTipText("Chapa del vehículo seleccionado");
      this.Chapa.setBorder(BorderFactory.createBevelBorder(1));
      this.PanelPrincipal.add(this.Chapa, new AbsoluteConstraints(150, 220, 130, -1));
      this.Chapa.getAccessibleContext().setAccessibleName("");
      this.Opciones.setIcon(new ImageIcon(this.getClass().getResource("/Images/config.png")));
      this.Opciones.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Entrada.this.OpcionesMouseEntered(evt);
         }
      });
      this.PanelPrincipal.add(this.Opciones, new AbsoluteConstraints(305, 135, 48, 45));
      this.Opciones1.setIcon(new ImageIcon(this.getClass().getResource("/Images/config on1.png")));
      this.Opciones1.setToolTipText("Opciones de Configuración ");
      this.Opciones1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Entrada.this.Opciones1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Entrada.this.Opciones1MouseExited(evt);
         }
      });
      this.PanelPrincipal.add(this.Opciones1, new AbsoluteConstraints(295, 125, 68, 65));
      this.Ayuda.setIcon(new ImageIcon(this.getClass().getResource("/Images/help.png")));
      this.Ayuda.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Entrada.this.AyudaMouseEntered(evt);
         }
      });
      this.PanelPrincipal.add(this.Ayuda, new AbsoluteConstraints(308, 370, 40, 40));
      this.Ayuda1.setIcon(new ImageIcon(this.getClass().getResource("/Images/help on1.png")));
      this.Ayuda1.setToolTipText("Ayuda Diferido");
      this.Ayuda1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Entrada.this.Ayuda1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Entrada.this.Ayuda1MouseExited(evt);
         }
      });
      this.PanelPrincipal.add(this.Ayuda1, new AbsoluteConstraints(298, 360, 60, 60));
      this.PB.setIcon(new ImageIcon(this.getClass().getResource("/Images/sss.gif")));
      this.PanelPrincipal.add(this.PB, new AbsoluteConstraints(10, 400, 100, 11));
      this.Moviles.setIcon(new ImageIcon(this.getClass().getResource("/Images/moviles.png")));
      this.Moviles.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Entrada.this.MovilesMouseEntered(evt);
         }
      });
      this.PanelPrincipal.add(this.Moviles, new AbsoluteConstraints(90, 350, 96, 32));
      this.ImgAceptar.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar.png")));
      this.ImgAceptar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Entrada.this.ImgAceptarMouseEntered(evt);
         }
      });
      this.PanelPrincipal.add(this.ImgAceptar, new AbsoluteConstraints(190, 350, 96, 32));
      this.Moviles1.setIcon(new ImageIcon(this.getClass().getResource("/Images/moviles on.png")));
      this.Moviles1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Entrada.this.Moviles1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Entrada.this.Moviles1MouseExited(evt);
         }
      });
      this.PanelPrincipal.add(this.Moviles1, new AbsoluteConstraints(90, 350, 96, 32));
      this.VersionLabel.setFont(new Font("Tahoma", 1, 24));
      this.VersionLabel.setForeground(new Color(209, 30, 30));
      this.VersionLabel.setText("12.6");
      this.PanelPrincipal.add(this.VersionLabel, new AbsoluteConstraints(285, 30, 90, 30));
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/Images/Cabecera 12.6.jpg")));
      this.PanelPrincipal.add(this.jLabel1, new AbsoluteConstraints(0, 0, 382, 100));
      this.ImgAceptar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar on.png")));
      this.ImgAceptar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Entrada.this.ImgAceptar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Entrada.this.ImgAceptar1MouseExited(evt);
         }
      });
      this.PanelPrincipal.add(this.ImgAceptar1, new AbsoluteConstraints(190, 350, 96, 32));
      this.ChapaCarro.setFont(new Font("Tahoma", 0, 12));
      this.ChapaCarro.setForeground(new Color(0, 0, 102));
      this.ChapaCarro.setText("Chapa:");
      this.PanelPrincipal.add(this.ChapaCarro, new AbsoluteConstraints(90, 225, 50, -1));
      this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/Images/fondo ventana principal1.png")));
      this.PanelPrincipal.add(this.jLabel2, new AbsoluteConstraints(0, 100, 382, 320));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.PanelPrincipal, -2, -1, -2));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.PanelPrincipal, -2, -1, -2));
      this.getAccessibleContext().setAccessibleName("Diferido MovilWeb 10.5");
      this.pack();
   }

   public int DiferidoLogin() throws UnsupportedEncodingException, MalformedURLException, IOException, BackingStoreException, NoSuchValueException, RegistryException, SAXException {
      HttpURLConnection conn = null;
      StringBuilder postData = new StringBuilder();
      Map<String, Object> params = new LinkedHashMap();
      String sitio = this.GetSitio();
      sitio = sitio + "/MovilWebServLet/DiferidoLogin106";
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Comprobando Usuario...");
      this.PB.setVisible(true);
      params.put("Usuario", this.user);
      params.put("Password", this.pass);
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
      if (this.Hay_Proxy) {
         String ip = this.DireccionProxy;
         this.port = this.PuertoProxy;
         String usuasriop = this.UsuarioProxy;
         String passp = this.PassProxy;
         url = new URL("http", ip, Integer.parseInt(this.port), sitio);
         conn = (HttpURLConnection)url.openConnection();
         String user_pass = usuasriop + ":" + passp;
         line = (new BASE64Encoder()).encode(user_pass.getBytes());
         conn.setRequestProperty("Proxy-Authorization", "Basic " + line);
      } else {
         url = new URL(sitio);
         conn = (HttpURLConnection)url.openConnection();
         conn.setDoOutput(true);
      }

      conn.setReadTimeout(30000);
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
      conn.setDoOutput(true);
      conn.getOutputStream().write(postDataBytes);
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
      line = "";

      String respuesta;
      for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
      }

      rd.close();
      if (respuesta.equalsIgnoreCase("-1")) {
         return -1;
      } else if (respuesta.equalsIgnoreCase("-2")) {
         return -3;
      } else if (respuesta.equalsIgnoreCase("")) {
         return -2;
      } else {
         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            File f = new File("Usuario.xml");
            if (f.exists() && !f.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(f.getAbsolutePath());
            }

            DOMParser parser = new DOMParser();
            InputSource Usuario = new InputSource(new StringReader(respuesta));
            parser.parse(Usuario);
            Document doc = parser.getDocument();
            Node Datos_Usuario = null;
            NodeList Lista_Datos = null;
            Lista_Datos = doc.getElementsByTagName("ROW");
            String ID = Lista_Datos.item(0).getAttributes().getNamedItem("ID").getNodeValue();
            String g = Lista_Datos.item(0).getAttributes().getNamedItem("Grupo").getNodeValue();
            String nombre = Lista_Datos.item(0).getAttributes().getNamedItem("Nombre").getNodeValue();
            String veloc_limite = Lista_Datos.item(0).getAttributes().getNamedItem("Velocidad").getNodeValue();
            this.idusuario = Integer.parseInt(ID);
            this.Grupo = Integer.parseInt(g);
            this.nombUsuario = nombre;
            this.VelocLimite = Double.parseDouble(veloc_limite) + 1.0D;
            this.Tiene_Conexion = true;
            this.Encrypt(this.encript, "Usuario.xml", respuesta);
         }

         this.PBLabel.setVisible(false);
         this.PBLabel.setText("");
         return this.idusuario;
      }
   }

   public int DiferidoLogin1() throws UnsupportedEncodingException, MalformedURLException, IOException, BackingStoreException, NoSuchValueException, RegistryException, SAXException {
      URLConnection conn = null;
      String sitio = this.GetSitio();
      sitio = sitio + "/MovilWebServLet/DiferidoLogin106?Usuario=" + this.user + "&Password=" + this.pass;
      this.PB.setVisible(true);
      this.PBLabel.setText("Comprobando usuario...");
      this.PBLabel.setVisible(true);
      URL url;
      String line;
      if (this.Hay_Proxy) {
         String ip = this.DireccionProxy;
         this.port = this.PuertoProxy;
         String usuasriop = this.UsuarioProxy;
         String passp = this.PassProxy;
         url = new URL("http", ip, Integer.parseInt(this.port), sitio);
         conn = url.openConnection();
         String user_pass = usuasriop + ":" + passp;
         line = (new BASE64Encoder()).encode(user_pass.getBytes());
         conn.setRequestProperty("Proxy-Authorization", "Basic " + line);
      } else {
         url = new URL(sitio);
         conn = url.openConnection();
         conn.setDoOutput(true);
      }

      conn.setReadTimeout(30000);
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      line = "";

      String respuesta;
      for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
      }

      rd.close();
      if (respuesta.equalsIgnoreCase("-1")) {
         return -1;
      } else if (respuesta.equalsIgnoreCase("-2")) {
         return -3;
      } else if (respuesta.equalsIgnoreCase("")) {
         return -2;
      } else {
         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            File f = new File("Usuario.xml");
            if (f.exists() && !f.delete()) {
               Funciones func = new Funciones();
               func.BorrarTrayectoria(f.getAbsolutePath());
            }

            DOMParser parser = new DOMParser();
            InputSource Usuario = new InputSource(new StringReader(respuesta));
            parser.parse(Usuario);
            Document doc = parser.getDocument();
            Node Datos_Usuario = null;
            NodeList Lista_Datos = null;
            Lista_Datos = doc.getElementsByTagName("ROW");
            String ID = Lista_Datos.item(0).getAttributes().getNamedItem("ID").getNodeValue();
            String g = Lista_Datos.item(0).getAttributes().getNamedItem("Grupo").getNodeValue();
            String nombre = Lista_Datos.item(0).getAttributes().getNamedItem("Nombre").getNodeValue();
            String veloc_limite = Lista_Datos.item(0).getAttributes().getNamedItem("Velocidad").getNodeValue();
            this.idusuario = Integer.parseInt(ID);
            this.Grupo = Integer.parseInt(g);
            this.nombUsuario = nombre;
            this.VelocLimite = Double.parseDouble(veloc_limite) + 1.0D;
            this.Tiene_Conexion = true;
            this.Encrypt(this.encript, "Usuario.xml", respuesta);
         }

         this.PBLabel.setVisible(false);
         this.PBLabel.setText("");
         return this.idusuario;
      }
   }

   public boolean Descargar_Trayectoria_gz() {
      URLConnection conn = null;
      String sitio = this.GetSitio();
      sitio = sitio + "/MovilWebServLet/DownloadTrajectoryTR?movil=" + this.chapa + "&fecha=" + this.FF + "&version=" + this.version;
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Descargando Trayectoria Compactada...");
      this.PB.setVisible(true);

      try {
         URL url;
         String nombre;
         if (this.Hay_Proxy) {
            url = new URL("http", this.DireccionProxy, Integer.parseInt(this.PuertoProxy), sitio);
            conn = url.openConnection();
            String user_pass = this.UsuarioProxy + ":" + this.PassProxy;
            nombre = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + nombre);
         } else {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         }

         InputStream in = conn.getInputStream();

         try {
            nombre = this.Fecha_Actual();
            File file = new File("Temp\\" + nombre + ".zip");
            file.createNewFile();
            if (file.exists()) {
               file.delete();
            }

            file = new File("Temp\\" + nombre + ".zip");
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buf = new byte[1024];

            int len;
            while((len = in.read(buf)) > 0) {
               fos.write(buf, 0, len);
            }

            fos.flush();
            fos.close();
            in.close();
            this.path = "Temp\\" + nombre + ".xml";
            this.Descomprimir(file.getPath(), this.path);
         } catch (IOException var10) {
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, (String)null, var10);
         }

         return true;
      } catch (Exception var11) {
         this.PBLabel.setVisible(false);
         this.PBLabel.setText("");
         this.PB.setVisible(false);
         return false;
      }
   }

   public boolean ObtenerIntTrayectoria() {
      String users = this.user;
      String password = this.pass;
      String sitio = this.GetSitio();
      String port = null;
      URLConnection conn = null;
      this.PBLabel.setVisible(true);
      this.PB.setVisible(true);
      this.PBLabel.setText("Buscando Intervalo de Fechas para TR...");
      sitio = sitio + "/MovilWebServLet/GetTrayectoryRangeTR?movil=" + this.Chapa.getText().toString();
      URL url;
      String line;
      String respuesta;
      if (this.Hay_Proxy) {
         try {
            url = new URL("http", this.DireccionProxy, Integer.parseInt(this.PuertoProxy), sitio);
            conn = url.openConnection();
            line = this.UsuarioProxy + ":" + this.PassProxy;
            respuesta = (new BASE64Encoder()).encode(line.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + respuesta);
         } catch (Exception var21) {
            respuesta = "Es posible que no tenga Conexión en este momento. Revise <br/>la Configuración del Proxy.  ";
            this.ShowMessage(respuesta, "Información", "Information");
            this.Tiene_Conexion = false;
            return false;
         }
      } else {
         try {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         } catch (Exception var20) {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            this.PBLabel.setText("");
            respuesta = "Es posible que no tenga Conexión en este momento. Revise <br/>la Configuración del Proxy.  ";
            this.ShowMessage(respuesta, "Información", "Information");
            this.Tiene_Conexion = false;
            return false;
         }
      }

      this.Tiene_Conexion = true;

      try {
         respuesta = "";

         BufferedReader rd;
         for(rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         if (respuesta.equalsIgnoreCase("-1")) {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            this.PBLabel.setText("");
            this.en_ejecucion = false;
            this.ShowMessage("No Fue Posible Acceder a los Datos en la Base de Datos.<br/>Inténte Obtener el Intervalo de Fechas más Tarde", "Información", "Information");
            return false;
         }

         if (respuesta.equalsIgnoreCase("-3")) {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            this.PBLabel.setText("");
            this.en_ejecucion = false;
            this.ShowMessage("No Hay Intervalo de Fechas Disponible para el Móvil " + this.Chapa.getText() + "." + "<br/>" + "Seleccione otro Por Favor.", "Información", "Information");
            return false;
         }

         if (respuesta.contains("<DATAPACKET Version=\"2.0\">")) {
            DOMParser parser = new DOMParser();
            InputSource Intervalo = new InputSource(new StringReader(respuesta));
            parser.parse(Intervalo);
            Document doc = parser.getDocument();
            Node Datos_Intervalo = null;
            NodeList Lista_Datos = null;
            Lista_Datos = doc.getElementsByTagName("ROW");
            String FI_interv = Lista_Datos.item(0).getAttributes().getNamedItem("FechaInicial").getNodeValue();
            String FF_interv = Lista_Datos.item(0).getAttributes().getNamedItem("FechaFinal").getNodeValue();
            this.FI_Intervalo = FI_interv;
            this.FF_Intervalo = FF_interv;
            return true;
         }
      } catch (Exception var22) {
      }

      return true;
   }

   public boolean NecesitaProxy() throws BackingStoreException, NoSuchValueException, RegistryException {
      try {
         RegistryKey regkey = Registry.HKEY_CURRENT_USER;
         RegistryKey Clave = Registry.openSubkey(regkey, "Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings", 4);
         RegistryValue Registro = Clave.getValue("ProxyEnable");
         String valor = Clave.getStringValue(Registro.getName());
         int msg = Registro.getType();
         return valor.equalsIgnoreCase("\u0001");
      } catch (Exception var6) {
         String msg = "Error en la Clase";
         this.ShowMessage(msg, "Error", "Error");
         return false;
      }
   }

   public String ProxyServer() throws NoSuchValueException, RegistryException {
      RegistryKey regkey = Registry.HKEY_CURRENT_USER;
      RegistryKey Clave = Registry.openSubkey(regkey, "Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings", 4);
      RegistryValue Registro = Clave.getValue("ProxyServer");
      String valor = Clave.getStringValue(Registro.getName());
      return valor;
   }

   public void GuardarXml(String XML) throws IOException {
      FileWriter fichero = new FileWriter("Usuario.xml");
      fichero.write(XML);
      fichero.close();
   }

   private void OpcionesMouseEntered(MouseEvent evt) {
      this.Opciones.setVisible(false);
      this.Opciones1.setVisible(true);
   }

   private void Opciones1MouseClicked(MouseEvent evt) {
      try {
         this.Opciones.setVisible(true);
         this.Opciones1.setVisible(false);
         Configuracion conf = new Configuracion(this);
         conf.MostrarCampos();
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   private void Opciones1MouseExited(MouseEvent evt) {
      this.Opciones.setVisible(true);
      this.Opciones1.setVisible(false);
   }

   private void AyudaMouseEntered(MouseEvent evt) {
      this.Ayuda.setVisible(false);
      this.Ayuda1.setVisible(true);
   }

   private void Ayuda1MouseClicked(MouseEvent evt) {
      this.Ayuda.setVisible(true);
      this.Ayuda1.setVisible(false);
      File ayuda = new File("AyudaDiferido\\AyudaDiferido.html");
      if (ayuda.exists()) {
         try {
            String camino = ayuda.getPath();
            String Comando = "cmd /c " + camino;
            Process var5 = Runtime.getRuntime().exec(Comando);
         } catch (Exception var6) {
            this.ShowMessage("Se produjo un error al Cargar el Fichero de Ayuda.", "Error", "Error");
         }
      } else {
         this.ShowMessage("No se encontró el Fichero de Ayuda.", "Inforamación", "Information");
      }

   }

   private void Ayuda1MouseExited(MouseEvent evt) {
      this.Ayuda.setVisible(true);
      this.Ayuda1.setVisible(false);
   }

   private void AceptarActionPerformed(ActionEvent evt) {
   }

   private void MovilesMouseEntered(MouseEvent evt) {
      this.Moviles.setVisible(false);
      this.Moviles1.setVisible(true);
   }

   private void Moviles1MouseExited(MouseEvent evt) {
      this.Moviles1.setVisible(false);
      this.Moviles.setVisible(true);
   }

   private void Moviles1MouseClicked(MouseEvent evt) {
      this.selecciono_moviles = false;
      if (!this.apreto_moviles) {
         this.apreto_moviles = true;
         Hilo1 h1 = new Hilo1(this);
         h1.start();
      }

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
      if (this.selecciono_moviles && !this.en_ejecucion) {
         this.en_ejecucion = true;
         if (this.Transferencia.equalsIgnoreCase("3")) {
            HiloFechaTrayect f = new HiloFechaTrayect(this);
            f.start();
         } else {
            Hilo h = new Hilo(this);
            h.start();
         }
      }

   }

   private void PasswordKeyPressed(KeyEvent evt) {
      if (evt.getKeyCode() == 10) {
         if (!this.Listo_para_Transferir) {
            this.selecciono_moviles = false;
            if (!this.apreto_moviles) {
               this.apreto_moviles = true;
               Hilo1 h1 = new Hilo1(this);
               h1.start();
            }
         } else if (this.selecciono_moviles && !this.en_ejecucion) {
            this.en_ejecucion = true;
            Hilo h = new Hilo(this);
            h.start();
         }
      }

   }

   private void UsuarioKeyPressed(KeyEvent evt) {
      if (evt.getKeyCode() == 10 && evt.getKeyCode() == 10) {
         if (!this.Listo_para_Transferir) {
            this.selecciono_moviles = false;
            if (!this.apreto_moviles) {
               this.apreto_moviles = true;
               Hilo1 h1 = new Hilo1(this);
               h1.start();
            }
         } else if (this.selecciono_moviles && !this.en_ejecucion) {
            this.en_ejecucion = true;
            Hilo h = new Hilo(this);
            h.start();
         }
      }

   }

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
               new Entrada();
            } catch (Exception var2) {
               var2.printStackTrace();
            }

         }
      });
   }

   public void LimpiarCampos() {
      this.Chapa.setText("");
      this.Numero.setText("");
      this.Indice.setText("");
      this.PB.setVisible(false);
      this.PBLabel.setVisible(false);
   }

   public String GetSitio() {
      return this.SitioMovilWeb;
   }

   public void Show_Selection(String ch, String num, String ind) throws SAXException, IOException {
      this.Chapa.setText(ch);
      this.Numero.setText(num);
      this.Indice.setText(ind);
   }

   public void BorrarDirectorio(String directorio) {
      File f = new File(directorio);
      if (f.exists()) {
         File[] ficheros = f.listFiles();

         for(int x = 0; x < ficheros.length; ++x) {
            if (ficheros[x].isDirectory()) {
               this.BorrarDirectorio(ficheros[x].getAbsolutePath());
            }

            ficheros[x].delete();
         }
      }

   }

   public void RevisarPorTransferir() {
      File f;
      if (this.Transferencia.equalsIgnoreCase("1")) {
         f = new File("Datos de las Trayectorias\\Por Transferir\\Tarjeta");
      } else if (this.Transferencia.equalsIgnoreCase("2")) {
         f = new File("Datos de las Trayectorias\\Por Transferir\\Bluetooth");
      } else if (this.Transferencia.equalsIgnoreCase("3")) {
         f = new File("Datos de las Trayectorias\\Por Transferir\\TReal");
      } else if (this.Transferencia.equalsIgnoreCase("4")) {
         f = new File("Datos de las Trayectorias\\Por Transferir\\TReal");
      } else {
         f = new File("Datos de las Trayectorias\\Por Transferir\\Cabv3");
      }

      if (f.isDirectory()) {
         File[] files = f.listFiles();
         int cant = files.length;

         for(int i = 0; i < cant; ++i) {
            if (files[i].getName().length() <= 14) {
               String nombrefichero = files[i].getName();
               String nombre_xml = "Config" + nombrefichero;
               nombre_xml = nombre_xml.replace(".log", ".xml");
               String new_path;
               if (this.Transferencia.equalsIgnoreCase("1")) {
                  new_path = "Datos de las Trayectorias\\Por Transferir\\Tarjeta\\" + nombre_xml;
               } else if (this.Transferencia.equalsIgnoreCase("2")) {
                  new_path = "Datos de las Trayectorias\\Por Transferir\\Bluetooth\\" + nombre_xml;
               } else if (this.Transferencia.equalsIgnoreCase("3")) {
                  new_path = "Datos de las Trayectorias\\Por Transferir\\TReal\\" + nombre_xml;
               } else if (this.Transferencia.equalsIgnoreCase("4")) {
                  new_path = "Datos de las Trayectorias\\Por Transferir\\TReal\\" + nombre_xml;
               } else {
                  new_path = "Datos de las Trayectorias\\Por Transferir\\Cabv3\\" + nombre_xml;
               }

               File fich_xml = new File(new_path);
               if (!fich_xml.exists()) {
                  files[i].delete();
               }
            }
         }
      }

   }

   private void ChequearProxy() throws NoSuchValueException, RegistryException, SAXException, IOException, BackingStoreException {
      boolean necesitaproxy = this.NecesitaProxy();

      String config_proxy;
      try {
         String config_proxy;
         if (necesitaproxy && !this.Hay_Proxy) {
            config_proxy = "Usted está usando Diferido a través de un Proxy.<br/>Debe configurar los datos del mismo en las Opciones<br/>de Configuración.";
            this.ShowMessage(config_proxy, "Error", "Error");
            config_proxy = this.ProxyServer();
            String[] partes = config_proxy.split(":");
            this.proxy = partes[0];
            this.port = partes[1];
         } else if (necesitaproxy) {
            config_proxy = this.ProxyServer();
            String[] partes = config_proxy.split(":");
            this.proxy = partes[0];
            this.port = partes[1];
         }
      } catch (Exception var5) {
         config_proxy = "Revise la Configuración del Proxy. Es posible que<br/>tenga problemas.";
         this.ShowMessage(config_proxy, "Error", "Error");
      }

   }

   public boolean isDate(String fechax) {
      try {
         SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm:ss", Locale.getDefault());
         formatoFecha.setLenient(false);
         formatoFecha.parse(fechax);
         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   public void Comprimir(String origen, String destino, String nombre) throws FileNotFoundException, IOException {
      try {
         FileInputStream in = new FileInputStream(origen);
         ZipOutputStream out = new ZipOutputStream(new FileOutputStream(destino));
         byte[] buf = new byte[1024];
         ZipEntry z = new ZipEntry(nombre);
         out.putNextEntry(z);

         int len;
         while((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
         }

         in.close();
         out.finish();
         out.close();
      } catch (Exception var9) {
         var9.printStackTrace();
      }

   }

   public void Descomprimir(String origen, String destino) throws FileNotFoundException, IOException {
      try {
         ZipInputStream in = new ZipInputStream(new FileInputStream(origen));
         FileOutputStream out = new FileOutputStream(destino);
         byte[] buf = new byte[1024];
         ZipEntry var7 = in.getNextEntry();

         int len;
         while((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
         }

         out.close();
         in.closeEntry();
         out.close();
      } catch (Exception var8) {
         var8.printStackTrace();
      }

   }

   public void MakeGzipFile(String from, String to) throws IOException {
      FileInputStream in = new FileInputStream(from);
      GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(to));
      byte[] buffer = new byte[8192];

      int bytesRead;
      while((bytesRead = in.read(buffer)) != -1) {
         out.write(buffer, 0, bytesRead);
      }

      out.close();
      in.close();
   }

   private void Borrar15Dias(String camino, String tiemp_almacenamiento) {
      File f = new File(camino);
      long diferencia = 0L;
      if (f.exists()) {
         int d = Integer.valueOf(this.fechaservidorinicial.substring(8, 10));
         int m = Integer.valueOf(this.fechaservidorinicial.substring(5, 7)) - 1;
         int y = Integer.valueOf(this.fechaservidorinicial.substring(0, 4)) - 1900;
         Date date = new Date(y, m, d);
         long hoy = date.getTime();
         File[] files = f.listFiles();

         for(int i = 0; i < files.length; ++i) {
            String dia = files[i].getName();
            d = Integer.valueOf(dia.substring(0, 2));
            m = Integer.valueOf(dia.substring(3, 5)) - 1;
            y = Integer.valueOf(dia.substring(6, 10)) - 1900;
            Date carpeta = new Date(y, m, d);
            diferencia = hoy - carpeta.getTime();
            if (diferencia / 86400000L >= (long)Integer.parseInt(tiemp_almacenamiento)) {
               this.BorrarDirectorio(files[i].getPath());
               files[i].delete();
            }
         }
      }

   }

   private boolean isActualDate(String fecha, String hora, String fh) {
      try {
         int ya = Integer.valueOf(fh.substring(0, 4)) - 1900;
         int ma = Integer.valueOf(fh.substring(5, 7)) - 1;
         int da = Integer.valueOf(fh.substring(8, 10)) + 1;
         int ha = Integer.valueOf(fh.substring(11, 13));
         int mina = Integer.valueOf(fh.substring(14, 16));
         Date actual = new Date(ya, ma, da, ha, mina);
         long actualms = actual.getTime();
         int d = Integer.valueOf(fecha.substring(0, 2));
         int m = Integer.valueOf(fecha.substring(3, 5)) - 1;
         int y = Integer.valueOf(fecha.substring(6, 8)) + 100;
         int h = Integer.valueOf(hora.substring(0, 2));
         int min = Integer.valueOf(hora.substring(3, 5));
         int seg = Integer.valueOf(hora.substring(6, 8));
         Date f = new Date(y, m, d, h, min);
         long fms = f.getTime();
         if (this.Transferencia.compareTo("3") != 0 && this.Transferencia.compareTo("4") != 0) {
            if (this.HorarioVerano) {
               fms -= 14400000L;
            } else {
               fms -= 18000000L;
            }
         }

         return actualms - fms >= 0L;
      } catch (Exception var21) {
         return false;
      }
   }

   public boolean ComparaFecha(String fi, String ff, String hi, String hf, int tipo) {
      try {
         long ff_long = 0L;
         long fi_long = 0L;
         Date fecha_final = null;
         Date fecha_inicial = null;
         int final_year = Integer.parseInt(ff.subSequence(6, 8).toString()) + 100;
         int final_month = Integer.parseInt(ff.subSequence(3, 5).toString()) - 1;
         int final_day = Integer.parseInt(ff.subSequence(0, 2).toString());
         int final_hour = Integer.parseInt(hf.subSequence(0, 2).toString());
         int final_min = Integer.parseInt(hf.subSequence(3, 5).toString());
         int initial_year = Integer.parseInt(fi.subSequence(6, 8).toString()) + 100;
         int initial_month = Integer.parseInt(fi.subSequence(3, 5).toString()) - 1;
         int initial_day = Integer.parseInt(fi.subSequence(0, 2).toString());
         int initial_hour = Integer.parseInt(hi.subSequence(0, 2).toString());
         int initial_min = Integer.parseInt(hi.subSequence(3, 5).toString());
         if (tipo == 1) {
            fecha_final = new Date(final_year, final_month, final_day, final_hour, final_min);
            ff_long = fecha_final.getTime();
            fecha_inicial = new Date(initial_year, initial_month, initial_day, initial_hour, initial_min);
            fi_long = fecha_inicial.getTime();
         } else {
            int final_seg = Integer.parseInt(hf.subSequence(6, 8).toString());
            fecha_final = new Date(final_year, final_month, final_day, final_hour, final_min, final_seg);
            ff_long = fecha_final.getTime();
            int initial_seg = Integer.parseInt(hi.subSequence(6, 8).toString());
            fecha_inicial = new Date(initial_year, initial_month, initial_day, initial_hour, initial_min, initial_seg);
            fi_long = fecha_inicial.getTime();
         }

         if (tipo != 1) {
            long diferencia = ff_long - fi_long;
            diferencia /= 86400000L;
            return diferencia >= 0L;
         } else {
            return ff_long >= fi_long;
         }
      } catch (Exception var24) {
         return true;
      }
   }

   private String Asignar(String valor) {
      double v = Double.parseDouble(valor);
      return valor;
   }

   public void Encrypt(String clave, String camino, String respuesta) {
      File f = new File(camino);

      try {
         try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            DESKeySpec kspec = new DESKeySpec(clave.getBytes());
            SecretKey ks = skf.generateSecret(kspec);

            try {
               Cipher cifrado = Cipher.getInstance("DES");
               cifrado.init(1, ks);
               InputStream archivo = new StringInputStream(respuesta);
               FileOutputStream fich_out = new FileOutputStream(f.getName());
               byte[] buffer = new byte[1024];
               String textoCifrado = new String();
               int fin_archivo = -1;

               byte[] bloque_cifrado;
               for(int leidos = archivo.read(buffer); leidos != fin_archivo; leidos = archivo.read(buffer)) {
                  bloque_cifrado = cifrado.update(buffer, 0, leidos);
                  textoCifrado = textoCifrado + new String(bloque_cifrado, "ISO-8859-1");
               }

               archivo.close();
               bloque_cifrado = cifrado.doFinal();
               textoCifrado = textoCifrado + new String(bloque_cifrado, "ISO-8859-1");
               fich_out.write(textoCifrado.getBytes("ISO-8859-1"));
               fich_out.close();
            } catch (NoSuchPaddingException var16) {
            } catch (IllegalBlockSizeException var17) {
            } catch (BadPaddingException var18) {
            }
         } catch (InvalidKeyException var19) {
         } catch (InvalidKeySpecException var20) {
         } catch (NoSuchAlgorithmException var21) {
         }
      } catch (IOException var22) {
      }

   }

   public String Decrypt(String clave, String camino) {
      File f1 = new File(camino);
      String textoCifrado = null;

      try {
         try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            DESKeySpec kspec = new DESKeySpec(clave.getBytes());
            SecretKey ks = skf.generateSecret(kspec);

            try {
               Cipher cifrado = Cipher.getInstance("DES");
               cifrado.init(2, ks);
               FileInputStream archivo = new FileInputStream(f1);
               byte[] buffer = new byte[1024];
               textoCifrado = new String();
               int fin_archivo = -1;

               byte[] bloque_cifrado;
               for(int leidos = archivo.read(buffer); leidos != fin_archivo; leidos = archivo.read(buffer)) {
                  bloque_cifrado = cifrado.update(buffer, 0, leidos);
                  textoCifrado = textoCifrado + new String(bloque_cifrado, "ISO-8859-1");
               }

               archivo.close();
               bloque_cifrado = cifrado.doFinal();
               textoCifrado = textoCifrado + new String(bloque_cifrado, "ISO-8859-1");
            } catch (NoSuchPaddingException var14) {
            } catch (IllegalBlockSizeException var15) {
            } catch (BadPaddingException var16) {
            }
         } catch (InvalidKeyException var17) {
         } catch (InvalidKeySpecException var18) {
         } catch (NoSuchAlgorithmException var19) {
         }
      } catch (IOException var20) {
      }

      return textoCifrado;
   }

   private long Tiempo_de_Desconexion(String Fecha_Desconexion, String Fecha_Conexion) {
      int dia_desc = Integer.parseInt(Fecha_Desconexion.subSequence(8, 10).toString());
      int mes_desc = Integer.parseInt(Fecha_Desconexion.subSequence(5, 7).toString()) - 1;
      int year_desc = Integer.parseInt(Fecha_Desconexion.subSequence(0, 4).toString()) - 1900;
      int dia_con = Integer.parseInt(Fecha_Conexion.subSequence(8, 10).toString());
      int mes_con = Integer.parseInt(Fecha_Conexion.subSequence(5, 7).toString()) - 1;
      int year_con = Integer.parseInt(Fecha_Conexion.subSequence(0, 4).toString()) - 1900;
      int hora_desc = Integer.parseInt(Fecha_Desconexion.subSequence(11, 13).toString());
      int min_desc = Integer.parseInt(Fecha_Desconexion.subSequence(14, 16).toString());
      int seg_desc = Integer.parseInt(Fecha_Desconexion.subSequence(17, 19).toString());
      int hora_con = Integer.parseInt(Fecha_Conexion.subSequence(11, 13).toString());
      int min_con = Integer.parseInt(Fecha_Conexion.subSequence(14, 16).toString());
      int seg_con = Integer.parseInt(Fecha_Conexion.subSequence(17, 19).toString());
      Date f1 = new Date(year_desc, mes_desc, dia_desc, hora_desc, min_desc, seg_desc);
      Date f2 = new Date(year_con, mes_con, dia_con, hora_con, min_con, seg_con);
      long diferencia_seg = Math.abs(f1.getTime() - f2.getTime()) / 1000L;
      return diferencia_seg;
   }

   private boolean ComprobarBB(double lat_transformada1, double lon_transformada1) {
      return lon_transformada1 >= -84.8D && lon_transformada1 <= -73.9D && lat_transformada1 >= 19.7D && lat_transformada1 <= 23.3D;
   }

   public boolean EnviarFechaTReal(String idgps, String Fecha2) throws MalformedURLException, IOException, FileNotFoundException, SAXException {
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Enviando Fecha Final de la Trayectoria...");
      this.PB.setVisible(true);
      Fecha2 = Fecha2.replace("-", "_");
      Fecha2 = Fecha2.replace(" ", "^");
      URLConnection conn = null;
      String sitio = this.GetSitio();
      sitio = sitio + "/MovilWebServLet/DeleteTrajectoryTR?idgps=" + idgps + "&fecha=" + Fecha2;
      URL url;
      String line;
      if (this.Hay_Proxy) {
         url = new URL("http", this.DireccionProxy, Integer.parseInt(this.PuertoProxy), sitio);
         conn = url.openConnection();
         String user_pass = this.UsuarioProxy + ":" + this.PassProxy;
         line = (new BASE64Encoder()).encode(user_pass.getBytes());
         conn.setRequestProperty("Proxy-Authorization", "Basic " + line);
      } else {
         url = new URL(sitio);
         conn = url.openConnection();
         conn.setDoOutput(true);
      }

      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

      String respuesta;
      for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
      }

      rd.close();
      if (respuesta.equalsIgnoreCase("-1")) {
         this.ShowMessage("No se pudo eliminar la Trayectoria del Movil: " + this.chapa + ".", "Error", "Error");
         this.PBLabel.setVisible(false);
         this.PB.setVisible(false);
         return false;
      } else if (respuesta.equalsIgnoreCase("-2")) {
         this.PBLabel.setVisible(false);
         this.PB.setVisible(false);
         String msg = "Existen problemas de Conexion";
         this.ShowMessage(msg, "Error", "Error");
         this.setVisible(false);
         this.setVisible(true);
         return false;
      } else {
         return true;
      }
   }

   public Point CrearPoint(String point) throws com.vividsolutions.jts.io.ParseException {
      Point p = null;
      WKTReader reader = new WKTReader(this.shape.geometryFactory);
      p = (Point)reader.read(point);
      double lon = p.getX();
      double lat = p.getY();
      return p;
   }

   public MultiPolygon CrearMultiPolygon(String MultiPolygon) throws com.vividsolutions.jts.io.ParseException {
      MultiPolygon p = null;
      WKTReader reader = new WKTReader(this.shape.geometryFactory);
      p = (MultiPolygon)reader.read(MultiPolygon);
      return p;
   }

   class anterior {
      public double lon;
      public double lat;
      public double velocidad;
      public double dis;
      public double pin;
      public double altura;
      public String fecha_anterior = "";
      public String dia = "";
      public String hora = "";
      public boolean vacio = true;
      public int cant_analogicas;
      public String moviendo = "";
      public String conectado = "";
      public String numSat = "";
      public String edadPos = "";
      public String codAlarm = "";
      public String entradas_discretas = "";

      public anterior() {
      }
   }
}
