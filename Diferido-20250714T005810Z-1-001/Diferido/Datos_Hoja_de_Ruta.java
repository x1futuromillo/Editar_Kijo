package Diferido;

import com.sun.xml.bind.StringInputStream;
import com.toedter.calendar.JDateChooser;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.WKTWriter;
import com.vividsolutions.jts.simplify.DouglasPeuckerSimplifier;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import org.apache.xerces.parsers.DOMParser;
import org.geotools.data.FeatureReader;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sun.misc.BASE64Encoder;

public class Datos_Hoja_de_Ruta extends JFrame {
   Entrada en;
   CargaDescarga cd;
   Abastecimiento abast;
   ListadoChoferes listado;
   ArrayList listado_prod = new ArrayList();
   ArrayList ListaHr = new ArrayList();
   ArrayList ListaCD = new ArrayList();
   ArrayList Insertar_ListaCD = new ArrayList();
   ArrayList Insertar_ListaAbast = new ArrayList();
   ArrayList listado_chip = new ArrayList();
   ArrayList ListaABAST = new ArrayList();
   File final_file;
   File reporte = null;
   String chofer;
   String chofer_auxiliar;
   boolean Selec = false;
   boolean Selec1 = false;
   double distancia_recorrida_total = 0.0D;
   File para_transferir;
   int cant_puntos = 0;
   boolean Acepto = false;
   boolean VioReporte = false;
   boolean Envio = false;
   boolean Listado_Choferes_Activo = false;
   boolean CD_activo = false;
   boolean abastec_activo = false;
   Funciones func = new Funciones();
   double kmhr_total = 0.0D;
   double kmgps_total = 0.0D;
   double kmsinresp = 0.0D;
   int tiemposr = 0;
   int viajes = 0;
   int tarjeta = 0;
   boolean Trayectoria_Detenida = false;
   String genera_trafico = "";
   String genera_abastec = "";
   DefaultTableCellRenderer tcr;
   String XML_Compactado = "";
   File xmlcomp;
   int NoViajes;
   String camino_reporte = " ";
   String camino_deten = "";
   String camino_desco = "";
   String camino_violacVelc = "";
   int cant_lineas_shp = 0;
   String shp_compacto = "";
   JDateChooser FI;
   JDateChooser FF;
   SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
   Date date_inicial;
   Date date_final;
   int ban = 0;
   double total_abastecido = 0.0D;
   double desv_IConsumo = 0.0D;
   double desv_IConsumo_Tec = 0.0D;
   boolean bandera = false;
   long moto_Horas = 0L;
   public JTextField Conductor;
   public JTextField Conductor1;
   private JLabel Elim;
   private JLabel Elim1;
   private JLabel Elim2;
   private JLabel Elim3;
   private JFormattedTextField FFF;
   private JFormattedTextField FII;
   private JLabel FechaHoraFinal;
   private JLabel FechaHoraInicial;
   public JFormattedTextField HF;
   public JFormattedTextField HI;
   private JLabel ImagEnviar;
   private JLabel ImagEnviar1;
   private JLabel ImgAceptar;
   private JLabel ImgAceptar1;
   private JLabel ImgAct;
   private JLabel ImgAct1;
   private JLabel ImgAdic;
   private JLabel ImgAdic1;
   private JLabel ImgCh;
   private JLabel ImgCh1;
   private JLabel ImgChofer;
   private JLabel ImgChofer1;
   private JLabel ImgElim;
   private JLabel ImgElim1;
   private JLabel ImgReporte;
   private JLabel ImgReporte1;
   private JLabel ImgTerminar;
   private JLabel ImgTerminar1;
   public JTextField KmRec;
   public JFormattedTextField MotoHoras;
   public JTextField NoHR;
   public JLabel PB;
   public JLabel PBLabel;
   private JPanel Principal;
   public JTable Tabla;
   private JLabel User;
   private JLabel User1;
   private JLabel User2;
   private JLabel User3;
   private JLabel User4;
   private JLabel User5;
   private JLabel User6;
   private JLabel User7;
   public JCheckBox abastecimient;
   private JButton jButton2;
   private JLabel jLabel10;
   private JLabel jLabel2;
   private JLabel jLabel9;
   private JScrollPane jScrollPane1;
   private JLabel motoHoras;
   public JCheckBox trafico;

   public Datos_Hoja_de_Ruta(Entrada en) throws MalformedURLException {
      this.initComponents();
      this.ImgTerminar1.setVisible(false);
      this.ImgTerminar.setVisible(true);
      this.ImagEnviar1.setVisible(false);
      this.ImagEnviar.setVisible(true);
      this.ImgReporte1.setVisible(false);
      this.ImgReporte.setVisible(true);
      this.ImgAceptar1.setVisible(false);
      this.ImgAceptar.setVisible(true);
      this.ImgChofer.setVisible(true);
      this.ImgChofer1.setVisible(false);
      this.ImgCh1.setVisible(false);
      this.ImgCh.setVisible(true);
      this.ImgAdic1.setVisible(false);
      this.ImgAdic.setVisible(true);
      this.ImgAct1.setVisible(false);
      this.ImgAct.setVisible(true);
      this.ImgElim1.setVisible(false);
      this.ImgElim.setVisible(true);
      this.Elim.setVisible(true);
      this.Elim1.setVisible(false);
      this.Elim2.setVisible(true);
      this.Elim3.setVisible(false);
      this.jButton2.setVisible(false);
      this.FII.setVisible(false);
      this.FFF.setVisible(false);
      this.FI = new JDateChooser("dd/MM/yy", "##/##/##", '_');
      this.FF = new JDateChooser("dd/MM/yy", "##/##/##", '_');
      this.FI.setBorder(BorderFactory.createBevelBorder(1));
      this.FI.setPreferredSize(new Dimension(80, 20));
      this.Principal.add(this.FI, new AbsoluteConstraints(125, 40, 80, -1), 1);
      this.FI.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            e.consume();
         }
      });
      this.FF.setBorder(BorderFactory.createBevelBorder(1));
      this.FF.setPreferredSize(new Dimension(80, 20));
      this.Principal.add(this.FF, new AbsoluteConstraints(125, 70, 80, -1), 1);
      this.FF.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            e.consume();
         }
      });
      File dir_imagen = new File("test-data/diferido install.png");
      URL img = dir_imagen.toURI().toURL();
      this.setIconImage((new ImageIcon(img)).getImage());
      this.en = en;
      this.tcr = new DefaultTableCellRenderer();
      this.tcr.setHorizontalAlignment(0);
      this.Tabla.getColumnModel().getColumn(0).setCellRenderer(this.tcr);
      this.Tabla.getColumnModel().getColumn(1).setCellRenderer(this.tcr);
      this.Tabla.getColumnModel().getColumn(2).setCellRenderer(this.tcr);
      this.Tabla.getColumnModel().getColumn(3).setCellRenderer(this.tcr);
      this.Tabla.getColumnModel().getColumn(4).setCellRenderer(this.tcr);
      this.Tabla.getColumnModel().getColumn(5).setCellRenderer(this.tcr);
      this.Tabla.getColumnModel().getColumn(6).setCellRenderer(this.tcr);
      if (en.ConsumoTec <= 0.0D) {
         this.Tabla.getColumnModel().getColumn(6).setMaxWidth(0);
         this.Tabla.getColumnModel().getColumn(6).setMinWidth(0);
         this.Tabla.getColumnModel().getColumn(6).setPreferredWidth(0);
         this.motoHoras.setEnabled(false);
         this.MotoHoras.setEnabled(false);
      } else {
         this.motoHoras.setEnabled(true);
         this.MotoHoras.setEnabled(true);
      }

      this.PB.setVisible(false);
      this.PBLabel.setVisible(false);
   }

   public Datos_Hoja_de_Ruta(ListadoChoferes list) {
      this.initComponents();
      this.listado = list;
   }

   public void MostrarDatos() throws SAXException, IOException {
      int dia_inicial = Integer.parseInt(this.en.Fecha_Inicial.substring(0, 2));
      int mes_inicial = Integer.parseInt(this.en.Fecha_Inicial.substring(3, 5)) - 1;
      int anno_inicial = Integer.parseInt(this.en.Fecha_Inicial.substring(6, 8)) + 100;
      this.date_inicial = new Date(anno_inicial, mes_inicial, dia_inicial);
      int dia_final = Integer.parseInt(this.en.Fecha_Final.substring(0, 2));
      int mes_final = Integer.parseInt(this.en.Fecha_Final.substring(3, 5)) - 1;
      int anno_final = Integer.parseInt(this.en.Fecha_Final.substring(6, 8)) + 100;
      this.date_final = new Date(anno_final, mes_final, dia_final);
      this.FI.setSelectableDateRange(this.date_inicial, this.date_final);
      this.FF.setSelectableDateRange(this.date_inicial, this.date_final);
      this.FI.setDate(this.date_inicial);
      this.FF.setDate(this.date_final);
      this.setTitle("Datos de Hoja de Ruta - " + this.en.chapa);
      String FHI = this.en.Fecha_Inicial + " " + this.en.Hora_Inicial.substring(0, 5);
      this.FechaHoraInicial.setText(FHI);
      String FHF = this.en.Fecha_Final + " " + this.en.Hora_Final.substring(0, 5);
      this.FechaHoraFinal.setText(FHF);
      if (this.en.hay_ficheros_sin_transferir) {
         File salva = new File(this.en.Origen_File_to_Transfer);

         try {
            if (salva.exists()) {
               DOMParser parser = new DOMParser();
               parser.parse(salva.getPath());
               Document doc = parser.getDocument();
               String conductor = "";
               String conductor_aux = "";
               NodeList Lista_HR = doc.getElementsByTagName("ROW");
               int cant_hr = Lista_HR.getLength();
               NodeList Config = doc.getElementsByTagName("Trafico");
               String t = Config.item(0).getFirstChild().getNodeValue();
               NodeList Config1 = doc.getElementsByTagName("Abastecimiento");
               String a = Config1.item(0).getFirstChild().getNodeValue();
               String fecha;
               String num_tarj;
               String Num_comp;
               String Loc;
               if (t.equalsIgnoreCase("Si")) {
                  NodeList No_viajes = doc.getElementsByTagName("NoViajes");
                  this.viajes = Integer.valueOf(No_viajes.item(0).getFirstChild().getNodeValue());
                  NodeList Lista_CD = doc.getElementsByTagName("CD");
                  int cant_cd = Lista_CD.getLength();

                  for(int j = 0; j < cant_cd; ++j) {
                     fecha = Lista_CD.item(j).getAttributes().getNamedItem("Documento").getNodeValue();
                     num_tarj = Lista_CD.item(j).getAttributes().getNamedItem("Numero").getNodeValue();
                     Num_comp = Lista_CD.item(j).getAttributes().getNamedItem("Merc").getNodeValue();
                     Loc = Lista_CD.item(j).getAttributes().getNamedItem("CantM").getNodeValue();
                     Productos p = new Productos(fecha, num_tarj, Num_comp, Loc);
                     this.listado_prod.add(p);
                     String lineaxml = "<CD Documento=\"" + fecha + "\"" + " " + "Numero=" + "\"" + num_tarj + "\"" + " " + "Merc=" + "\"" + Num_comp + "\"" + " " + "CantM=" + "\"" + Loc + "\"" + "/>";
                     this.ListaCD.add(lineaxml);
                     this.trafico.setSelected(true);
                  }
               }

               if (a.equalsIgnoreCase("Si")) {
                  NodeList No_Tarjeta = doc.getElementsByTagName("NoTarjeta");
                  this.tarjeta = Integer.valueOf(No_Tarjeta.item(0).getFirstChild().getNodeValue());
                  NodeList Lista_ABAST = doc.getElementsByTagName("ABAST");
                  int cant_abast = Lista_ABAST.getLength();
                  double CantAbast = 0.0D;
                  double SaldoIni = 0.0D;
                  double SaldoFin = 0.0D;

                  for(int j = 0; j < cant_abast; ++j) {
                     fecha = Lista_ABAST.item(j).getAttributes().getNamedItem("Fecha").getNodeValue();
                     num_tarj = Lista_ABAST.item(j).getAttributes().getNamedItem("Num_tarj").getNodeValue();
                     Num_comp = Lista_ABAST.item(j).getAttributes().getNamedItem("NumComp").getNodeValue();
                     CantAbast = Double.parseDouble(Lista_ABAST.item(j).getAttributes().getNamedItem("CantAbast").getNodeValue());
                     Loc = Lista_ABAST.item(j).getAttributes().getNamedItem("Localidad").getNodeValue();
                     String Estab = Lista_ABAST.item(j).getAttributes().getNamedItem("Establecimiento").getNodeValue();
                     String tipoAbast = Lista_ABAST.item(j).getAttributes().getNamedItem("TipoAbastecimiento").getNodeValue();
                     String geom_estab = Lista_ABAST.item(j).getAttributes().getNamedItem("GeomEst").getNodeValue();
                     SaldoIni = Double.parseDouble(Lista_ABAST.item(j).getAttributes().getNamedItem("SaldoInicial").getNodeValue());
                     SaldoFin = Double.parseDouble(Lista_ABAST.item(j).getAttributes().getNamedItem("SaldoFinal").getNodeValue());
                     Integer idtarj = Integer.parseInt(Lista_ABAST.item(j).getAttributes().getNamedItem("IdTarje").getNodeValue());
                     Integer idloc = Integer.parseInt(Lista_ABAST.item(j).getAttributes().getNamedItem("IdLoc").getNodeValue());
                     Integer idEst = Integer.parseInt(Lista_ABAST.item(j).getAttributes().getNamedItem("IdEst").getNodeValue());
                     ChipCombustible chip = new ChipCombustible(fecha, num_tarj, Num_comp, CantAbast, Loc, Estab, idtarj, idloc, idEst, tipoAbast, this.en.CrearPoint(geom_estab), SaldoIni, SaldoFin);
                     this.listado_chip.add(chip);
                     String lineaxml = "<ABAST Fecha=\"" + fecha + "\"" + " " + "Num_tarj=" + "\"" + num_tarj + "\"" + " " + "NumComp=" + "\"" + Num_comp + "\"" + " " + "CantAbast=" + "\"" + CantAbast + "\"" + " " + "Localidad=" + "\"" + Loc + "\"" + " " + "Establecimiento=" + "\"" + Estab + "\"" + " " + "TipoAbastecimiento=" + "\"" + tipoAbast + "\"" + " " + "IdTarje=" + "\"" + idtarj + "\"" + " " + "IdLoc=" + "\"" + idloc + "\"" + " " + "IdEst=" + "\"" + idEst + "\"" + " " + "GeomEst=" + "\"" + geom_estab + "\"" + " " + "SaldoInicial=" + "\"" + SaldoIni + "\"" + " " + "SaldoFinal=" + "\"" + SaldoFin + "\"" + "/>";
                     this.ListaABAST.add(lineaxml);
                     this.abastecimient.setSelected(true);
                  }
               }

               DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();

               for(int i = 0; i < cant_hr; ++i) {
                  String NumHR = Lista_HR.item(i).getAttributes().getNamedItem("NoHR").getNodeValue();
                  String fi = Lista_HR.item(i).getAttributes().getNamedItem("FI").getNodeValue();
                  String hi = Lista_HR.item(i).getAttributes().getNamedItem("HI").getNodeValue();
                  String ff = Lista_HR.item(i).getAttributes().getNamedItem("FF").getNodeValue();
                  String hf = Lista_HR.item(i).getAttributes().getNamedItem("HF").getNodeValue();
                  String kmhr = Lista_HR.item(i).getAttributes().getNamedItem("KMHR").getNodeValue();
                  conductor = Lista_HR.item(i).getAttributes().getNamedItem("CONDUCTOR").getNodeValue();
                  conductor_aux = Lista_HR.item(i).getAttributes().getNamedItem("CONDUCTORAUX").getNodeValue();
                  if (this.en.ConsumoTec > 0.0D) {
                     String tiempoMH = Lista_HR.item(i).getAttributes().getNamedItem("TIEMPOMH").getNodeValue();
                     model.insertRow(model.getRowCount(), new Object[]{NumHR, fi, hi, ff, hf, kmhr, tiempoMH});
                  } else {
                     model.insertRow(model.getRowCount(), new Object[]{NumHR, fi, hi, ff, hf, kmhr});
                  }
               }

               this.Conductor.setText(conductor);
               this.Conductor1.setText(conductor_aux);
               this.chofer = conductor;
               this.chofer_auxiliar = conductor_aux;
            }
         } catch (Exception var54) {
            String msg = "Se Produjo un Error Mostrando los Datos de Hoja de Ruta.<br/>Revise la Estructura del XML que se Guarda en:<br/>" + salva.getPath() + "<br/>" + "La Aplicación se Cerrará";
            this.en.ShowMessage(msg, "Información", "Information");
            System.exit(0);
         }
      }

      this.setLocationRelativeTo((Component)null);
      this.en.setVisible(false);
      this.setVisible(true);
   }

   public void ConstruirFicheroDetenciones() {
      String logid = this.en.logid;
      Iterator it = this.en.Paradas.iterator();

      String consulta;
      for(boolean var13 = true; it.hasNext(); consulta = "") {
         Detenciones det = (Detenciones)it.next();
         String Movil = "'" + det.chapa + "'";
         String Fecha1 = "to_timestamp('" + det.Fecha1 + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
         String Fecha2 = "to_timestamp('" + det.Fecha2 + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
         int Minutos = det.minutos;
         double Lat = det.latitud;
         double Lon = det.longitud;
         String the_geom = "geomfromtext('POINT(" + Lon + " " + Lat + ")',4326)";
         String year_month = "_" + this.en.fecha_hora.substring(0, 4) + this.en.fecha_hora.substring(5, 7);
         String tabla = "detenciones" + year_month;
         String Paradas = "INSERT INTO " + tabla + "(usuario,movil, fecha1, fecha2, minutos, the_geom, logid) VALUES (";
         consulta = Paradas + this.en.idusuario + "," + Movil + "," + Fecha1 + "," + Fecha2 + "," + Minutos + "," + the_geom + "," + "'" + logid + "'" + ");";
         StringBuilder var10000 = new StringBuilder();
         Entrada var10002 = this.en;
         var10002.insertDB = var10000.append(var10002.insertDB).append(consulta).toString();
      }

   }

   public void ConstruirShapeDetenciones() {
      this.camino_deten = "Temp\\Ficheros\\Detenciones\\Detenciones.shp";
      String detenciones = "Temp\\Ficheros\\Detenciones";
      File shp_detenciones = new File(this.camino_deten);
      if (shp_detenciones.exists()) {
         this.en.BorrarDirectorio(detenciones);
      }

      try {
         this.en.shape.initFeatureWriterDetenciones(this.camino_deten);
         this.en.Crear_SHPDetenciones();
         File file_det = new File(detenciones);
         String camino = "Temp\\Trayectoria\\Detenciones.gz";
         Comprimir comp = new Comprimir(file_det, camino);
         comp.compress();
      } catch (Exception var6) {
         var6.getMessage();
      }

   }

   public void ConstruirFicheroDesconexiones() {
      String logid = this.en.logid;
      Iterator it = this.en.Desconexiones.iterator();

      String consulta;
      for(boolean var17 = true; it.hasNext(); consulta = "") {
         Desconexion desc = (Desconexion)it.next();
         String Movil = "'" + desc.chapa + "'";
         String FechaConexion = "to_timestamp('" + desc.Fecha_Conexion + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
         String FechaDesconexion = "to_timestamp('" + desc.Fecha_Desconexion + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
         double LatConn = desc.LatConn;
         double LonConn = desc.LonConn;
         double LatDesconn = desc.LatDesc;
         double LonDesconn = desc.LonDesc;
         int Motivo = desc.motivo;
         String msg = "Desde: " + desc.Fecha_Desconexion + " Hasta: " + desc.Fecha_Conexion + " Motivo: " + desc.motivo + '\n';
         String the_geom = "geomfromtext('MULTILINESTRING((" + LonDesconn + " " + LatDesconn + "," + LonConn + " " + LatConn + "))',4326)";
         String Dxn = "INSERT INTO desconexiones(usuario,movil, fecha_desc, fecha_conec, motivo, logid,the_geom) VALUES (";
         consulta = Dxn + this.en.idusuario + "," + Movil + "," + FechaDesconexion + "," + FechaConexion + "," + Motivo + "," + "'" + logid + "'" + "," + the_geom + ");";
         StringBuilder var10000 = new StringBuilder();
         Entrada var10002 = this.en;
         var10002.insertDB = var10000.append(var10002.insertDB).append(consulta).toString();
      }

   }

   public void ConstruirShapeDesconexiones() {
      this.camino_desco = "Temp\\Ficheros\\Desconexiones\\Desconexiones.shp";
      String desconexion = "Temp\\Ficheros\\Desconexiones";
      File shp_desconexion = new File(this.camino_desco);
      if (shp_desconexion.exists()) {
         this.en.BorrarDirectorio(desconexion);
      }

      try {
         this.en.shape.initFeatureWriterDesconexiones(this.camino_desco);
         this.en.Crear_SHPDesconexiones();
         File file_des = new File(desconexion);
         String camino = "Temp\\Trayectoria\\Desconexiones.gz";
         Comprimir comp = new Comprimir(file_des, camino);
         comp.compress();
      } catch (Exception var6) {
         var6.getMessage();
      }

   }

   public void ConstruirShapeViolacVelc() {
      this.camino_violacVelc = "Temp\\Ficheros\\ViolacionesVelocidad\\ViolacionesVelocidad.shp";
      String violaciones = "Temp\\Ficheros\\ViolacionesVelocidad";
      File shp_violaciones = new File(this.camino_violacVelc);
      if (shp_violaciones.exists()) {
         this.en.BorrarDirectorio(violaciones);
      }

      try {
         this.en.shape.initFeatureWriterViolaciones(this.camino_violacVelc);
         this.en.Crear_SHPViolaciones();
         File file_des = new File(violaciones);
         String camino = "Temp\\Trayectoria\\ViolacionesVelocidad.gz";
         Comprimir comp = new Comprimir(file_des, camino);
         comp.compress();
      } catch (Exception var6) {
         var6.getMessage();
      }

   }

   public void ConstruirTiempoZona() {
      Coordinate[] coordTrayect;
      LineString trayectoria;
      if (this.en.arraycoord.size() == 1) {
         coordTrayect = new Coordinate[]{new Coordinate((Coordinate)this.en.arraycoord.get(0)), null};
         double despx = 9.699509204834236E-6D;
         double despy = 9.699509204834236E-6D;
         coordTrayect[1] = new Coordinate(((Coordinate)this.en.arraycoord.get(0)).x + despx, ((Coordinate)this.en.arraycoord.get(0)).y + despy);
         trayectoria = this.en.shape.geometryFactory.createLineString(coordTrayect);
      } else {
         coordTrayect = new Coordinate[this.en.arraycoord.size()];
         coordTrayect = (Coordinate[])this.en.arraycoord.toArray(new Coordinate[this.en.arraycoord.size()]);
         trayectoria = this.en.shape.geometryFactory.createLineString(coordTrayect);
      }

      MultiPoint detenciones = this.en.shape.geometryFactory.createMultiPoint(this.en.pointdet);
      MultiPoint tiemp_deten = this.en.shape.geometryFactory.createMultiPoint(this.en.point_tiempdet);
      MultiLineString desconexiones = this.en.shape.geometryFactory.createMultiLineString(this.en.lineStringsdesc);
      MultiPoint tiemp_desc = this.en.shape.geometryFactory.createMultiPoint(this.en.point_tiempdesc);
      WKTWriter writer = new WKTWriter(3);
      String geom_trayect = "";
      if (this.en.arraycoord.size() < 4) {
         geom_trayect = "geomfromtext('" + trayectoria.toString() + "',4326)";
      } else {
         Geometry geo = DouglasPeuckerSimplifier.simplify(trayectoria, 1.0E-4D);
         geom_trayect = "geomfromtext('" + geo.toString() + "',4326)";
      }

      String geom_detenciones = "geomfromtext('" + detenciones.toString() + "',4326)";
      String geom_desconexiones = "geomfromtext('" + desconexiones.toString() + "',4326)";
      String geom_tiempo = "geomfromtext('" + tiemp_deten.toString() + "',4326)";
      String geom_tiempo1 = "geomfromtext('" + writer.write(tiemp_desc) + "',4326)";
      String con = "INSERT INTO geo_userlog (logid, trayectoria, detenciones, desconexiones,time_detenciones,time_desconexiones)VALUES(";
      String consulta = con + "'" + this.en.logid + "'" + "," + geom_trayect + "," + geom_detenciones + "," + geom_desconexiones + "," + geom_tiempo + "," + geom_tiempo1 + ");";
      StringBuilder var10000 = new StringBuilder();
      Entrada var10002 = this.en;
      var10002.insertDB = var10000.append(var10002.insertDB).append(consulta).toString();
   }

   public void ConstruirFicheroHR() {
      String logid = this.en.logid;
      double km_rec_gps = 0.0D;
      double km_rec_hr = 0.0D;
      double km_sin_resp = 0.0D;
      double km_after = 0.0D;
      double combGPS = 0.0D;
      double combHR = 0.0D;
      long tiempoHR = 0L;
      long tiempo_det_HR = 0L;
      long tiempo_SR = 0L;
      long tiempo_det_SR = 0L;
      long tiempo_MH = 0L;

      String consulta;
      for(Iterator it = this.ListaHr.iterator(); it.hasNext(); consulta = "") {
         HR hr = (HR)it.next();
         int Numero = hr.numero;
         String FechaInicio = "to_timestamp('" + hr.fi + " " + hr.hi + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
         String FechaFin = "to_timestamp('" + hr.ff + " " + hr.hf + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
         km_rec_gps = hr.km_gps;
         km_rec_hr = hr.kmrec;
         km_sin_resp = hr.km_sin_respaldo;
         km_after = hr.km_after;
         tiempoHR = hr.tiempoHR;
         tiempo_det_HR = hr.tiempo_det_HR;
         tiempo_SR = hr.tiempo_SR;
         tiempo_det_SR = hr.tiempo_det_SR;
         tiempo_MH = this.TiempoMotoHoras(hr.tiempoMH);
         this.moto_Horas += tiempo_MH;
         combHR = this.en.Redondear_Numero(hr.kmrec / this.en.Consumo, 2);
         combGPS = this.en.Redondear_Numero(hr.km_gps / 1000.0D / this.en.Consumo, 2);
         String HRGetWay = "INSERT INTO hojaruta(usuario, numero, fechainicio, fechafin, kmrecorridosgps, kmrecorridoshr,kmsinrespaldo, kmafter, tiempohr, tiempodethr, tiemposr, tiempodetsr, logid, combhr, combgps,moto_horas ) Values(";
         consulta = HRGetWay + this.en.idusuario + "," + Numero + "," + FechaInicio + "," + FechaFin + "," + km_rec_gps + "," + km_rec_hr + "," + km_sin_resp + "," + km_after + "," + tiempoHR + "," + tiempo_det_HR + "," + tiempo_SR + "," + tiempo_det_SR + "," + "'" + logid + "'" + "," + combHR + "," + combGPS + "," + tiempo_MH + ");";
         StringBuilder var10000 = new StringBuilder();
         Entrada var10002 = this.en;
         var10002.insertDB = var10000.append(var10002.insertDB).append(consulta).toString();
      }

   }

   public void ProcesarHoja_de_Ruta1() throws IOException {
      String fecha_shp_actual = "";
      long tiempo_det_HR = 0L;
      long tiempo_det_SR = 0L;
      double lon1_actual = 0.0D;
      double lat1_actual = 0.0D;
      double velocidad_actual = 0.0D;
      double rotacion_actual = 0.0D;
      double km_after = 0.0D;
      double km_gps_hr = 0.0D;
      double km_sin_resp = 0.0D;
      double distancia_recorrida = 0.0D;
      double distancia_sin_respaldo = 0.0D;
      boolean vehiculo_parado = true;
      boolean esta_dentroHR = false;
      boolean primera_linea_en_mov = false;
      boolean mov_nocturno = false;
      String fi_mov_noc = "";
      String ff_mov_noc = "";
      String fi_mov = "";
      String FechaInicio = "";
      String FechaFin = "";
      long tiempo_mov = 0L;
      Datos_Hoja_de_Ruta.anterior anterior = new Datos_Hoja_de_Ruta.anterior();
      double distancia_after = 0.0D;
      double distancia_por_gps = 0.0D;
      int ban = false;
      String consulta = "";
      if (!this.en.shp.exists()) {
         this.en.ShowMessage("No se encontró el fichero " + this.en.shp.getAbsolutePath(), "Error", "Error");
      } else {
         ShapefileDataStore fichero_shp = new ShapefileDataStore(this.en.shp.toURL());
         FeatureReader<SimpleFeatureType, SimpleFeature> ftReader = fichero_shp.getFeatureReader();
         int cant_hr = this.ListaHr.size();
         int j = 0;
         int i = false;
         String fecha_inicioHR = this.ObtenerFechaHora(j, "inicial", 2);
         String fecha_finHR = this.ObtenerFechaHora(j, "final", 2);

         while(ftReader.hasNext()) {
            try {
               ++this.cant_lineas_shp;
               List<Object> values = ((SimpleFeature)ftReader.next()).getAttributes();
               Point geometria = (Point)values.get(0);
               lon1_actual = geometria.getX();
               lat1_actual = geometria.getY();
               String fecha_temp = String.valueOf(values.get(2));
               fecha_shp_actual = fecha_temp.substring(0, 4) + "-" + fecha_temp.substring(5, 7) + "-" + fecha_temp.substring(8, 10) + " " + fecha_temp.substring(11, 19);
               velocidad_actual = (Double)values.get(3);
               if (anterior.vacio) {
                  anterior.lon2_anterior = lon1_actual;
                  anterior.lat2_anterior = lat1_actual;
                  anterior.velocidad_anterior = velocidad_actual;
                  anterior.fecha_anterior = fecha_shp_actual;
                  anterior.vacio = false;
                  if (velocidad_actual < 2.0D) {
                     vehiculo_parado = true;
                  }
               } else {
                  distancia_recorrida = this.en.Distancia(anterior.lon2_anterior, anterior.lat2_anterior, lon1_actual, lat1_actual);
                  this.distancia_recorrida_total += distancia_recorrida;
                  distancia_after += distancia_recorrida;
                  if (velocidad_actual < 2.0D) {
                     vehiculo_parado = true;
                  }

                  if (this.ComparaFecha(fecha_shp_actual)) {
                     if (velocidad_actual > 20.0D) {
                        if (fi_mov.equalsIgnoreCase("")) {
                           fi_mov = fecha_shp_actual;
                        }

                        if (fi_mov_noc.equalsIgnoreCase("")) {
                           fi_mov_noc = fecha_shp_actual;
                           mov_nocturno = true;
                        }
                     } else if (!fi_mov_noc.equalsIgnoreCase("")) {
                        ff_mov_noc = fecha_shp_actual;
                     }

                     if (!fi_mov_noc.equalsIgnoreCase("") && !ff_mov_noc.equalsIgnoreCase("")) {
                        tiempo_mov += this.Diferencia_Minutos(fi_mov_noc, ff_mov_noc, 2);
                        fi_mov_noc = "";
                        FechaFin = ff_mov_noc;
                        ff_mov_noc = "";
                        mov_nocturno = false;
                     }
                  } else if (mov_nocturno && !fi_mov_noc.equalsIgnoreCase("") && ff_mov_noc.equalsIgnoreCase("")) {
                     tiempo_mov += this.Diferencia_Minutos(fi_mov_noc, fecha_shp_actual, 2);
                     fi_mov_noc = "";
                     FechaFin = fecha_shp_actual;
                     ff_mov_noc = "";
                     mov_nocturno = false;
                  }

                  if (velocidad_actual > 2.0D && vehiculo_parado && !esta_dentroHR) {
                     primera_linea_en_mov = true;
                     tiempo_det_SR += this.Diferencia_Minutos(anterior.fecha_anterior, fecha_shp_actual, 2);
                     vehiculo_parado = false;
                  }

                  if (velocidad_actual > 2.0D && vehiculo_parado && esta_dentroHR) {
                     primera_linea_en_mov = true;
                     tiempo_det_HR += this.Diferencia_Minutos(anterior.fecha_anterior, fecha_shp_actual, 2);
                     vehiculo_parado = false;
                  }

                  int intervalo = this.Compara_LogId(fecha_inicioHR, fecha_shp_actual, 2);
                  if ((fecha_shp_actual.equalsIgnoreCase(fecha_inicioHR) || intervalo == 1) && !ban) {
                     ban = true;
                     if (intervalo == 1 && primera_linea_en_mov) {
                        long diferencia = this.Diferencia_Minutos(fecha_inicioHR, fecha_shp_actual, 2);
                        if (tiempo_det_SR == 0L) {
                           tiempo_det_SR = -1L;
                        } else {
                           tiempo_det_SR -= diferencia;
                        }

                        tiempo_det_HR += diferencia;
                     }

                     primera_linea_en_mov = false;
                     km_sin_resp = this.Redondear_Numero(distancia_sin_respaldo, 2);
                     esta_dentroHR = true;
                     if (j > 0) {
                        fecha_finHR = this.ObtenerFechaHora(j, "final", 2);
                     }
                  }

                  if (esta_dentroHR) {
                     distancia_por_gps += distancia_recorrida;
                     int intervalo1 = this.Compara_LogId(fecha_finHR, fecha_shp_actual, 2);
                     if ((fecha_shp_actual.equalsIgnoreCase(fecha_finHR) || intervalo1 == 1 || !ftReader.hasNext()) && ban) {
                        esta_dentroHR = false;
                        int bandera = false;
                        long diferencia = 0L;
                        if (intervalo1 == 1 && primera_linea_en_mov) {
                           diferencia = this.Diferencia_Minutos(fecha_finHR, fecha_shp_actual, 2);
                           if (diferencia < tiempo_det_HR) {
                              tiempo_det_HR -= diferencia;
                           }

                           bandera = true;
                        }

                        distancia_after = 0.0D;
                        km_after = 0.0D;
                        km_gps_hr = this.Redondear_Numero(distancia_por_gps, 2);
                        if (tiempo_det_SR < 0L) {
                           tiempo_det_SR = 0L;
                        }

                        this.Insertar_Datos_HR(km_gps_hr, km_sin_resp, km_after, tiempo_det_SR, tiempo_det_HR, j);
                        tiempo_det_HR = 0L;
                        tiempo_det_SR = 0L;
                        ++j;
                        if (j < cant_hr) {
                           fecha_inicioHR = this.ObtenerFechaHora(j, "inicial", 2);
                           ban = false;
                        }

                        distancia_por_gps = 0.0D;
                        distancia_sin_respaldo = 0.0D;
                     }
                  } else {
                     primera_linea_en_mov = false;
                     distancia_sin_respaldo += distancia_recorrida;
                  }

                  anterior.lon2_anterior = lon1_actual;
                  anterior.lat2_anterior = lat1_actual;
                  anterior.velocidad_anterior = velocidad_actual;
                  anterior.rotacion_anterior = rotacion_actual;
                  anterior.fecha_anterior = fecha_shp_actual;
               }
            } catch (Exception var57) {
            }
         }

         ftReader.close();
         fichero_shp.dispose();
         if (!fi_mov.equalsIgnoreCase("") && !FechaFin.equalsIgnoreCase("") && tiempo_mov > 0L) {
            FechaInicio = "to_timestamp('" + fi_mov + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
            FechaFin = "to_timestamp('" + FechaFin + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
            String mov_Noct = "INSERT INTO moviles_mov(logid, fecha_inicio, fecha_fin,minutos) Values(";
            consulta = mov_Noct + "'" + this.en.logid + "'" + "," + FechaInicio + "," + FechaFin + "," + tiempo_mov + ");";
            StringBuilder var10000 = new StringBuilder();
            Entrada var10002 = this.en;
            var10002.insertDB = var10000.append(var10002.insertDB).append(consulta).toString();
         }

         km_after = this.Redondear_Numero(distancia_after, 2);
         this.Insertar_KmAfter(km_after);
         if (this.cant_lineas_shp == 1) {
            if (km_after == 0.0D && tiempo_det_SR == 0L) {
               this.InsertarTiempoDetSR();
            }

            if (km_gps_hr == 0.0D && tiempo_det_HR == 0L) {
               this.InsertarTiempoDetHR();
            }

            this.Trayectoria_Detenida = true;
         }

      }
   }

   public void ProcesarHoja_de_Ruta() throws IOException {
      String fecha_shp_actual = "";
      long tiempo_det_HR = 0L;
      long tiempo_det_SR = 0L;
      double lon1_actual = 0.0D;
      double lat1_actual = 0.0D;
      double velocidad_actual = 0.0D;
      double rotacion_actual = 0.0D;
      double km_after = 0.0D;
      double km_gps_hr = 0.0D;
      double km_sin_resp = 0.0D;
      double distancia_recorrida = 0.0D;
      double distancia_sin_respaldo = 0.0D;
      boolean vehiculo_parado = true;
      boolean esta_dentroHR = false;
      boolean primera_linea_en_mov = false;
      boolean mov_nocturno = false;
      String fi_mov_noc = "";
      String ff_mov_noc = "";
      String fi_mov = "";
      String FechaInicio = "";
      String FechaFin = "";
      long tiempo_mov = 0L;
      Datos_Hoja_de_Ruta.anterior anterior = new Datos_Hoja_de_Ruta.anterior();
      double distancia_after = 0.0D;
      double distancia_por_gps = 0.0D;
      int ban = false;
      String consulta = "";
      if (!this.en.shp.exists()) {
         this.en.ShowMessage("No se Encontró el Fichero " + this.en.shp.getAbsolutePath(), "Error", "Error");
      } else {
         this.en.camino_trayec = "Temp\\Ficheros\\Trayectoria\\Trayectoria.shp";
         File shp1 = new File(this.en.camino_trayec);
         if (shp1.exists()) {
            this.en.BorrarDirectorio("Temp\\Ficheros\\Trayectoria");
         }

         this.en.shape.initFeatureWriter(this.en.camino_trayec);
         ShapefileDataStore fichero_shp = new ShapefileDataStore(this.en.shp.toURL());
         FeatureReader<SimpleFeatureType, SimpleFeature> ftReader = fichero_shp.getFeatureReader();
         int cant_hr = this.ListaHr.size();
         int j = 0;
         int i = false;
         String fecha_inicioHR = this.ObtenerFechaHora(j, "inicial", 2);
         String fecha_finHR = this.ObtenerFechaHora(j, "final", 2);

         while(ftReader.hasNext()) {
            try {
               ++this.cant_lineas_shp;
               List<Object> values = ((SimpleFeature)ftReader.next()).getAttributes();
               Point geometria = (Point)values.get(0);
               lon1_actual = geometria.getX();
               lat1_actual = geometria.getY();
               String fecha_temp = String.valueOf(values.get(2));
               fecha_shp_actual = fecha_temp.substring(0, 4) + "-" + fecha_temp.substring(5, 7) + "-" + fecha_temp.substring(8, 10) + " " + fecha_temp.substring(11, 19);
               velocidad_actual = (Double)values.get(3);
               rotacion_actual = (Double)values.get(4);
               int orden = (Integer)values.get(5);
               int stopidx = (Integer)values.get(6);
               if (anterior.vacio) {
                  anterior.lon2_anterior = lon1_actual;
                  anterior.lat2_anterior = lat1_actual;
                  anterior.velocidad_anterior = velocidad_actual;
                  anterior.fecha_anterior = fecha_shp_actual;
                  anterior.vacio = false;
                  if (velocidad_actual < 1.079D) {
                     vehiculo_parado = true;
                     this.en.Adicionar_Linea_de_la_Trayect_shp(lat1_actual, lon1_actual, rotacion_actual, velocidad_actual, fecha_temp, orden, stopidx, 0.0D);
                  }
               } else {
                  distancia_recorrida = this.en.Distancia(anterior.lon2_anterior, anterior.lat2_anterior, lon1_actual, lat1_actual);
                  this.distancia_recorrida_total += distancia_recorrida;
                  distancia_after += distancia_recorrida;
                  this.en.Adicionar_Linea_de_la_Trayect_shp(lat1_actual, lon1_actual, rotacion_actual, velocidad_actual, fecha_temp, orden, stopidx, this.distancia_recorrida_total);
                  if (velocidad_actual < 1.079D) {
                     vehiculo_parado = true;
                  }

                  if (this.ComparaFecha(fecha_shp_actual)) {
                     if (velocidad_actual > 20.0D) {
                        if (fi_mov.equalsIgnoreCase("")) {
                           fi_mov = fecha_shp_actual;
                        }

                        if (fi_mov_noc.equalsIgnoreCase("")) {
                           fi_mov_noc = fecha_shp_actual;
                           mov_nocturno = true;
                        }
                     } else if (!fi_mov_noc.equalsIgnoreCase("")) {
                        ff_mov_noc = fecha_shp_actual;
                     }

                     if (!fi_mov_noc.equalsIgnoreCase("") && !ff_mov_noc.equalsIgnoreCase("")) {
                        tiempo_mov += this.Diferencia_Minutos(fi_mov_noc, ff_mov_noc, 2);
                        fi_mov_noc = "";
                        FechaFin = ff_mov_noc;
                        ff_mov_noc = "";
                        mov_nocturno = false;
                     }
                  } else if (mov_nocturno && !fi_mov_noc.equalsIgnoreCase("") && ff_mov_noc.equalsIgnoreCase("")) {
                     tiempo_mov += this.Diferencia_Minutos(fi_mov_noc, fecha_shp_actual, 2);
                     fi_mov_noc = "";
                     FechaFin = fecha_shp_actual;
                     ff_mov_noc = "";
                     mov_nocturno = false;
                  }

                  if (velocidad_actual > 1.079D && vehiculo_parado && !esta_dentroHR) {
                     primera_linea_en_mov = true;
                     tiempo_det_SR += this.Diferencia_Minutos(anterior.fecha_anterior, fecha_shp_actual, 2);
                     vehiculo_parado = false;
                  }

                  if (velocidad_actual > 1.079D && vehiculo_parado && esta_dentroHR) {
                     primera_linea_en_mov = true;
                     tiempo_det_HR += this.Diferencia_Minutos(anterior.fecha_anterior, fecha_shp_actual, 2);
                     vehiculo_parado = false;
                  }

                  int intervalo = this.Compara_LogId(fecha_inicioHR, fecha_shp_actual, 2);
                  if ((fecha_shp_actual.equalsIgnoreCase(fecha_inicioHR) || intervalo == 1) && !ban) {
                     ban = true;
                     if (intervalo == 1 && primera_linea_en_mov) {
                        long diferencia = this.Diferencia_Minutos(fecha_inicioHR, fecha_shp_actual, 2);
                        if (tiempo_det_SR == 0L) {
                           tiempo_det_SR = -1L;
                        } else {
                           tiempo_det_SR -= diferencia;
                        }

                        tiempo_det_HR += diferencia;
                     }

                     km_sin_resp = this.Redondear_Numero(distancia_sin_respaldo, 2);
                     esta_dentroHR = true;
                     if (j > 0) {
                        fecha_finHR = this.ObtenerFechaHora(j, "final", 2);
                     }
                  }

                  if (esta_dentroHR) {
                     distancia_por_gps += distancia_recorrida;
                     int intervalo1 = this.Compara_LogId(fecha_finHR, fecha_shp_actual, 2);
                     if ((fecha_shp_actual.equalsIgnoreCase(fecha_finHR) || intervalo1 == 1 || !ftReader.hasNext()) && ban) {
                        esta_dentroHR = false;
                        int bandera = false;
                        long diferencia = 0L;
                        if (intervalo1 == 1 && primera_linea_en_mov) {
                           diferencia = this.Diferencia_Minutos(fecha_finHR, fecha_shp_actual, 2);
                           if (diferencia < tiempo_det_HR) {
                              tiempo_det_HR -= diferencia;
                           }

                           bandera = true;
                        }

                        distancia_after = 0.0D;
                        km_after = 0.0D;
                        km_gps_hr = this.Redondear_Numero(distancia_por_gps, 2);
                        if (tiempo_det_SR < 0L) {
                           tiempo_det_SR = 0L;
                        }

                        this.Insertar_Datos_HR(km_gps_hr, km_sin_resp, km_after, tiempo_det_SR, tiempo_det_HR, j);
                        tiempo_det_HR = 0L;
                        tiempo_det_SR = 0L;
                        ++j;
                        esta_dentroHR = false;
                        primera_linea_en_mov = false;
                        if (j < cant_hr) {
                           fecha_inicioHR = this.ObtenerFechaHora(j, "inicial", 2);
                           ban = false;
                        }

                        distancia_por_gps = 0.0D;
                        distancia_sin_respaldo = 0.0D;
                     }
                  } else {
                     distancia_sin_respaldo += distancia_recorrida;
                  }

                  anterior.lon2_anterior = lon1_actual;
                  anterior.lat2_anterior = lat1_actual;
                  anterior.velocidad_anterior = velocidad_actual;
                  anterior.rotacion_anterior = rotacion_actual;
                  anterior.fecha_anterior = fecha_shp_actual;
                  anterior.dist_anterior = distancia_recorrida;
               }
            } catch (Exception var60) {
               anterior.lon2_anterior = lon1_actual;
               anterior.lat2_anterior = lat1_actual;
               anterior.velocidad_anterior = velocidad_actual;
               anterior.rotacion_anterior = rotacion_actual;
               anterior.fecha_anterior = fecha_shp_actual;
               anterior.dist_anterior = distancia_recorrida;
               System.out.println(var60);
            }
         }

         if (j < cant_hr && !ftReader.hasNext()) {
            fecha_finHR = this.ObtenerFechaHora(j, "final", 2);
            int intervalo1 = this.Compara_LogId(fecha_finHR, fecha_shp_actual, 2);
            if (intervalo1 == 1 || intervalo1 == -1) {
               tiempo_det_HR = this.Diferencia_Minutos(fecha_inicioHR, fecha_finHR, 2);
            }

            this.Insertar_Datos_HR(km_gps_hr, km_sin_resp, km_after, tiempo_det_SR, tiempo_det_HR, j);
            tiempo_det_HR = 0L;
            tiempo_det_SR = 0L;
         }

         ftReader.close();
         fichero_shp.dispose();
         this.en.shape.closeFeatureWriter();
         if (!fi_mov.equalsIgnoreCase("") && !FechaFin.equalsIgnoreCase("") && tiempo_mov > 0L) {
            FechaInicio = "to_timestamp('" + fi_mov + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
            FechaFin = "to_timestamp('" + FechaFin + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
            String mov_Noct = "INSERT INTO moviles_mov(logid, fecha_inicio, fecha_fin,minutos) Values(";
            consulta = mov_Noct + "'" + this.en.logid + "'" + "," + FechaInicio + "," + FechaFin + "," + tiempo_mov + ");";
            StringBuilder var10000 = new StringBuilder();
            Entrada var10002 = this.en;
            var10002.insertDB = var10000.append(var10002.insertDB).append(consulta).toString();
         }

         km_after = this.Redondear_Numero(distancia_after, 2);
         this.Insertar_KmAfter(km_after);
         if (this.cant_lineas_shp == 1) {
            if (km_after == 0.0D && tiempo_det_SR == 0L) {
               this.InsertarTiempoDetSR();
            }

            if (km_gps_hr == 0.0D && tiempo_det_HR == 0L) {
               this.InsertarTiempoDetHR();
            }

            this.Trayectoria_Detenida = true;
         }

      }
   }

   public void ProcesarHoja_de_RutaGPSE() throws IOException {
      String fecha_shp_actual = "";
      long tiempo_det_HR = 0L;
      long tiempo_det_SR = 0L;
      double lon1_actual = 0.0D;
      double lat1_actual = 0.0D;
      double velocidad_actual = 0.0D;
      double rotacion_actual = 0.0D;
      double dist_actual = 0.0D;
      double km_after = 0.0D;
      double km_gps_hr = 0.0D;
      double km_sin_resp = 0.0D;
      double distancia_recorrida = 0.0D;
      double distancia_sin_respaldo = 0.0D;
      double dist_inicial = 0.0D;
      boolean vehiculo_parado = false;
      boolean esta_dentroHR = false;
      boolean primera_linea_en_mov = false;
      boolean mov_nocturno = false;
      String movimiento = "";
      String primera_shp = "";
      String fi_mov_noc = "";
      String ff_mov_noc = "";
      String fi_mov = "";
      String FechaInicio = "";
      String FechaFin = "";
      long tiempo_mov = 0L;
      Datos_Hoja_de_Ruta.anterior anterior = new Datos_Hoja_de_Ruta.anterior();
      double distancia_after = 0.0D;
      double distancia_por_gps = 0.0D;
      int ban = false;
      String consulta = "";
      this.en.camino_trayec = "Temp\\Ficheros\\Trayectoria\\Trayectoria.shp";
      File shp1 = new File(this.en.camino_trayec);
      if (!this.en.shp.exists()) {
         this.en.ShowMessage("No se Encontró el Fichero " + this.en.shp.getAbsolutePath(), "Error", "Error");
      } else {
         if (shp1.exists()) {
            this.en.BorrarDirectorio("Temp\\Ficheros\\Trayectoria");
         }

         this.en.shape.initFeatureWriter(this.en.camino_trayec);
         ShapefileDataStore fichero_shp = new ShapefileDataStore(this.en.shp.toURL());
         FeatureReader<SimpleFeatureType, SimpleFeature> ftReader = fichero_shp.getFeatureReader();
         int cant_hr = this.ListaHr.size();
         int j = 0;
         int i = false;
         String fecha_inicioHR = this.ObtenerFechaHora(j, "inicial", 2);
         String fecha_finHR = this.ObtenerFechaHora(j, "final", 2);

         while(ftReader.hasNext()) {
            try {
               ++this.cant_lineas_shp;
               List<Object> values = ((SimpleFeature)ftReader.next()).getAttributes();
               Point geometria = (Point)values.get(0);
               lon1_actual = geometria.getX();
               lat1_actual = geometria.getY();
               String fecha_temp = String.valueOf(values.get(2));
               fecha_shp_actual = fecha_temp.substring(0, 4) + "-" + fecha_temp.substring(5, 7) + "-" + fecha_temp.substring(8, 10) + " " + fecha_temp.substring(11, 19);
               velocidad_actual = (Double)values.get(3);
               rotacion_actual = (Double)values.get(4);
               int orden = (Integer)values.get(5);
               int stopidx = (Integer)values.get(6);
               movimiento = String.valueOf(values.get(7));
               dist_actual = (Double)values.get(8);
               this.en.Adicionar_Linea_de_la_Trayect_shp(lat1_actual, lon1_actual, rotacion_actual, velocidad_actual, fecha_temp, orden, stopidx, dist_actual);
               if (anterior.vacio) {
                  anterior.lon2_anterior = lon1_actual;
                  anterior.lat2_anterior = lat1_actual;
                  anterior.velocidad_anterior = velocidad_actual;
                  anterior.rotacion_anterior = rotacion_actual;
                  anterior.fecha_anterior = fecha_shp_actual;
                  anterior.mov_anterior = movimiento;
                  anterior.dist_anterior = dist_actual;
                  anterior.vacio = false;
                  if (movimiento.equalsIgnoreCase("0") && velocidad_actual == 0.0D) {
                     vehiculo_parado = true;
                     primera_linea_en_mov = false;
                  }
               } else {
                  if (this.ComparaFecha(fecha_shp_actual)) {
                     if (velocidad_actual > 20.0D) {
                        if (fi_mov.equalsIgnoreCase("")) {
                           fi_mov = fecha_shp_actual;
                        }

                        if (fi_mov_noc.equalsIgnoreCase("")) {
                           fi_mov_noc = fecha_shp_actual;
                           mov_nocturno = true;
                        }
                     } else if (!fi_mov_noc.equalsIgnoreCase("")) {
                        ff_mov_noc = fecha_shp_actual;
                     }

                     if (!fi_mov_noc.equalsIgnoreCase("") && !ff_mov_noc.equalsIgnoreCase("")) {
                        tiempo_mov += this.Diferencia_Minutos(fi_mov_noc, ff_mov_noc, 2);
                        fi_mov_noc = "";
                        FechaFin = ff_mov_noc;
                        ff_mov_noc = "";
                        mov_nocturno = false;
                     }
                  } else if (mov_nocturno && !fi_mov_noc.equalsIgnoreCase("") && ff_mov_noc.equalsIgnoreCase("")) {
                     tiempo_mov += this.Diferencia_Minutos(fi_mov_noc, fecha_shp_actual, 2);
                     fi_mov_noc = "";
                     FechaFin = fecha_shp_actual;
                     ff_mov_noc = "";
                     mov_nocturno = false;
                  }

                  distancia_recorrida = dist_actual - anterior.dist_anterior;
                  this.distancia_recorrida_total += distancia_recorrida;
                  distancia_after += distancia_recorrida;
                  if (movimiento.equalsIgnoreCase("0") && velocidad_actual == 0.0D && !vehiculo_parado) {
                     vehiculo_parado = true;
                     primera_linea_en_mov = false;
                  }

                  if (velocidad_actual > 0.0D && movimiento.equalsIgnoreCase("1") && vehiculo_parado && !esta_dentroHR) {
                     primera_linea_en_mov = true;
                     tiempo_det_SR += this.Diferencia_Minutos(anterior.fecha_anterior, fecha_shp_actual, 2);
                     vehiculo_parado = false;
                  }

                  if (velocidad_actual > 0.0D && movimiento.equalsIgnoreCase("1") && vehiculo_parado && esta_dentroHR) {
                     primera_linea_en_mov = true;
                     tiempo_det_HR += this.Diferencia_Minutos(anterior.fecha_anterior, fecha_shp_actual, 2);
                     vehiculo_parado = false;
                  }

                  int intervalo = this.Compara_LogId(fecha_inicioHR, fecha_shp_actual, 2);
                  if ((fecha_shp_actual.equalsIgnoreCase(fecha_inicioHR) || intervalo == 1) && !ban) {
                     ban = true;
                     if (intervalo == 1 && primera_linea_en_mov) {
                        long diferencia = this.Diferencia_Minutos(fecha_inicioHR, fecha_shp_actual, 2);
                        if (tiempo_det_SR == 0L) {
                           tiempo_det_SR = -1L;
                        } else {
                           tiempo_det_SR -= diferencia;
                        }

                        tiempo_det_HR += diferencia;
                     }

                     km_sin_resp = this.Redondear_Numero(distancia_sin_respaldo, 2);
                     esta_dentroHR = true;
                     if (j > 0) {
                        fecha_finHR = this.ObtenerFechaHora(j, "final", 2);
                     }
                  }

                  if (esta_dentroHR) {
                     distancia_por_gps += distancia_recorrida;
                     int intervalo1 = this.Compara_LogId(fecha_finHR, fecha_shp_actual, 2);
                     if ((fecha_shp_actual.equalsIgnoreCase(fecha_finHR) || intervalo1 == 1 || !ftReader.hasNext()) && ban) {
                        esta_dentroHR = false;
                        int bandera = false;
                        long diferencia = 0L;
                        if (intervalo1 == 1 && primera_linea_en_mov) {
                           diferencia = this.Diferencia_Minutos(fecha_finHR, fecha_shp_actual, 2);
                           if (diferencia < tiempo_det_HR) {
                              tiempo_det_HR -= diferencia;
                           }

                           bandera = true;
                        }

                        if (intervalo1 == -1 && primera_linea_en_mov) {
                           diferencia = this.Diferencia_Minutos(fecha_finHR, fecha_shp_actual, 2);
                           tiempo_det_HR += diferencia;
                        }

                        distancia_after = 0.0D;
                        km_after = 0.0D;
                        km_gps_hr = this.Redondear_Numero(distancia_por_gps, 2);
                        if (tiempo_det_SR < 0L) {
                           tiempo_det_SR = 0L;
                        }

                        this.Insertar_Datos_HR(km_gps_hr, km_sin_resp, km_after, tiempo_det_SR, tiempo_det_HR, j);
                        tiempo_det_HR = 0L;
                        tiempo_det_SR = 0L;
                        fecha_inicioHR = "";
                        fecha_finHR = "";
                        km_gps_hr = 0.0D;
                        km_sin_resp = 0.0D;
                        ++j;
                        esta_dentroHR = false;
                        primera_linea_en_mov = false;
                        if (j < cant_hr) {
                           fecha_inicioHR = this.ObtenerFechaHora(j, "inicial", 2);
                           ban = false;
                        }

                        distancia_por_gps = 0.0D;
                        distancia_sin_respaldo = 0.0D;
                     }
                  } else {
                     distancia_sin_respaldo += distancia_recorrida;
                  }

                  anterior.lon2_anterior = lon1_actual;
                  anterior.lat2_anterior = lat1_actual;
                  anterior.velocidad_anterior = velocidad_actual;
                  anterior.rotacion_anterior = rotacion_actual;
                  anterior.fecha_anterior = fecha_shp_actual;
                  anterior.mov_anterior = movimiento;
                  anterior.dist_anterior = dist_actual;
               }
            } catch (Exception var66) {
               anterior.lon2_anterior = lon1_actual;
               anterior.lat2_anterior = lat1_actual;
               anterior.velocidad_anterior = velocidad_actual;
               anterior.rotacion_anterior = rotacion_actual;
               anterior.fecha_anterior = fecha_shp_actual;
               anterior.mov_anterior = movimiento;
               anterior.dist_anterior = dist_actual;
            }
         }

         if (j < cant_hr && !ftReader.hasNext()) {
            fecha_finHR = this.ObtenerFechaHora(j, "final", 2);
            int intervalo1 = this.Compara_LogId(fecha_finHR, fecha_shp_actual, 2);
            if (intervalo1 == 1 || intervalo1 == -1) {
               tiempo_det_HR = this.Diferencia_Minutos(fecha_inicioHR, fecha_finHR, 2);
            }

            this.Insertar_Datos_HR(km_gps_hr, km_sin_resp, km_after, tiempo_det_SR, tiempo_det_HR, j);
            tiempo_det_HR = 0L;
            tiempo_det_SR = 0L;
         }

         ftReader.close();
         fichero_shp.dispose();
         this.en.shape.closeFeatureWriter();
         if (!fi_mov.equalsIgnoreCase("") && !FechaFin.equalsIgnoreCase("") && tiempo_mov > 0L) {
            FechaInicio = "to_timestamp('" + fi_mov + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
            FechaFin = "to_timestamp('" + FechaFin + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
            String mov_Noct = "INSERT INTO moviles_mov(logid, fecha_inicio, fecha_fin,minutos) Values(";
            consulta = mov_Noct + "'" + this.en.logid + "'" + "," + FechaInicio + "," + FechaFin + "," + tiempo_mov + ");";
            StringBuilder var10000 = new StringBuilder();
            Entrada var10002 = this.en;
            var10002.insertDB = var10000.append(var10002.insertDB).append(consulta).toString();
         }

         km_after = this.Redondear_Numero(distancia_after, 2);
         this.Insertar_KmAfter(km_after);
         if (this.cant_lineas_shp == 1) {
            if (km_after == 0.0D && tiempo_det_SR == 0L) {
               this.InsertarTiempoDetSR();
            }

            if (km_gps_hr == 0.0D && tiempo_det_HR == 0L) {
               this.InsertarTiempoDetHR();
            }

            this.Trayectoria_Detenida = true;
         }

         this.bandera = false;
      }
   }

   public void ProcesarHoja_de_RutaTReal() throws IOException {
      String fecha_shp_actual = "";
      long tiempo_det_HR = 0L;
      long tiempo_det_SR = 0L;
      double lon1_actual = 0.0D;
      double lat1_actual = 0.0D;
      double velocidad_actual = 0.0D;
      double rotacion_actual = 0.0D;
      double dist_actual = 0.0D;
      double km_after = 0.0D;
      double km_gps_hr = 0.0D;
      double km_sin_resp = 0.0D;
      double distancia_recorrida = 0.0D;
      double distancia_sin_respaldo = 0.0D;
      double dist_inicial = 0.0D;
      boolean vehiculo_parado = true;
      boolean esta_dentroHR = false;
      boolean primera_linea_en_mov = false;
      boolean mov_nocturno = false;
      String fi_mov_noc = "";
      String ff_mov_noc = "";
      String fi_mov = "";
      String FechaInicio = "";
      String FechaFin = "";
      long tiempo_mov = 0L;
      Datos_Hoja_de_Ruta.anterior anterior = new Datos_Hoja_de_Ruta.anterior();
      double distancia_after = 0.0D;
      double distancia_por_gps = 0.0D;
      int ban = false;
      String consulta = "";
      this.en.camino_trayec = "Temp\\Ficheros\\Trayectoria\\Trayectoria.shp";
      File shp1 = new File(this.en.camino_trayec);
      if (!this.en.shp.exists()) {
         this.en.ShowMessage("No se Encontró el Fichero " + this.en.shp.getAbsolutePath(), "Error", "Error");
      } else {
         if (shp1.exists()) {
            this.en.BorrarDirectorio("Temp\\Ficheros\\Trayectoria");
         }

         this.en.shape.initFeatureWriter(this.en.camino_trayec);
         ShapefileDataStore fichero_shp = new ShapefileDataStore(this.en.shp.toURL());
         FeatureReader<SimpleFeatureType, SimpleFeature> ftReader = fichero_shp.getFeatureReader();
         int cant_hr = this.ListaHr.size();
         int j = 0;
         int i = false;
         String fecha_inicioHR = this.ObtenerFechaHora(j, "inicial", 2);
         String fecha_finHR = this.ObtenerFechaHora(j, "final", 2);

         while(ftReader.hasNext()) {
            try {
               ++this.cant_lineas_shp;
               List<Object> values = ((SimpleFeature)ftReader.next()).getAttributes();
               Point geometria = (Point)values.get(0);
               lon1_actual = geometria.getX();
               lat1_actual = geometria.getY();
               String fecha_temp = String.valueOf(values.get(2));
               fecha_shp_actual = fecha_temp.substring(0, 4) + "-" + fecha_temp.substring(5, 7) + "-" + fecha_temp.substring(8, 10) + " " + fecha_temp.substring(11, 19);
               velocidad_actual = (Double)values.get(3);
               rotacion_actual = (Double)values.get(4);
               int orden = (Integer)values.get(5);
               int stopidx = (Integer)values.get(6);
               dist_actual = (Double)values.get(7);
               this.en.Adicionar_Linea_de_la_Trayect_shp(lat1_actual, lon1_actual, rotacion_actual, velocidad_actual, fecha_temp, orden, stopidx, dist_actual);
               if (anterior.vacio) {
                  anterior.lon2_anterior = lon1_actual;
                  anterior.lat2_anterior = lat1_actual;
                  anterior.velocidad_anterior = velocidad_actual;
                  anterior.rotacion_anterior = rotacion_actual;
                  anterior.fecha_anterior = fecha_shp_actual;
                  anterior.dist_anterior = dist_actual;
                  anterior.vacio = false;
                  if (velocidad_actual == 0.0D) {
                     vehiculo_parado = true;
                  }
               } else {
                  distancia_recorrida = dist_actual - anterior.dist_anterior;
                  this.distancia_recorrida_total += distancia_recorrida;
                  distancia_after += distancia_recorrida;
                  if (velocidad_actual == 0.0D) {
                     vehiculo_parado = true;
                     primera_linea_en_mov = false;
                  }

                  if (this.ComparaFecha(fecha_shp_actual)) {
                     if (velocidad_actual > 20.0D) {
                        if (fi_mov.equalsIgnoreCase("")) {
                           fi_mov = fecha_shp_actual;
                        }

                        if (fi_mov_noc.equalsIgnoreCase("")) {
                           fi_mov_noc = fecha_shp_actual;
                           mov_nocturno = true;
                        }
                     } else if (!fi_mov_noc.equalsIgnoreCase("")) {
                        ff_mov_noc = fecha_shp_actual;
                     }

                     if (!fi_mov_noc.equalsIgnoreCase("") && !ff_mov_noc.equalsIgnoreCase("")) {
                        tiempo_mov += this.Diferencia_Minutos(fi_mov_noc, ff_mov_noc, 2);
                        fi_mov_noc = "";
                        FechaFin = ff_mov_noc;
                        ff_mov_noc = "";
                        mov_nocturno = false;
                     }
                  } else if (mov_nocturno && !fi_mov_noc.equalsIgnoreCase("") && ff_mov_noc.equalsIgnoreCase("")) {
                     tiempo_mov += this.Diferencia_Minutos(fi_mov_noc, fecha_shp_actual, 2);
                     fi_mov_noc = "";
                     FechaFin = fecha_shp_actual;
                     ff_mov_noc = "";
                     mov_nocturno = false;
                  }

                  if (velocidad_actual > 0.0D && vehiculo_parado && !esta_dentroHR) {
                     primera_linea_en_mov = true;
                     tiempo_det_SR += this.Diferencia_Minutos(anterior.fecha_anterior, fecha_shp_actual, 2);
                     vehiculo_parado = false;
                  }

                  if (velocidad_actual > 0.0D && vehiculo_parado && esta_dentroHR) {
                     primera_linea_en_mov = true;
                     tiempo_det_HR += this.Diferencia_Minutos(anterior.fecha_anterior, fecha_shp_actual, 2);
                     vehiculo_parado = false;
                  }

                  int intervalo = this.Compara_LogId(fecha_inicioHR, fecha_shp_actual, 2);
                  if ((fecha_shp_actual.equalsIgnoreCase(fecha_inicioHR) || intervalo == 1) && !ban) {
                     ban = true;
                     if (intervalo == 1 && primera_linea_en_mov) {
                        long diferencia = this.Diferencia_Minutos(fecha_inicioHR, fecha_shp_actual, 2);
                        if (tiempo_det_SR == 0L) {
                           tiempo_det_SR = -1L;
                        } else {
                           tiempo_det_SR -= diferencia;
                        }

                        tiempo_det_HR += diferencia;
                     }

                     km_sin_resp = this.Redondear_Numero(distancia_sin_respaldo, 2);
                     esta_dentroHR = true;
                     if (j > 0) {
                        fecha_finHR = this.ObtenerFechaHora(j, "final", 2);
                     }
                  }

                  if (esta_dentroHR) {
                     distancia_por_gps += distancia_recorrida;
                     int intervalo1 = this.Compara_LogId(fecha_finHR, fecha_shp_actual, 2);
                     if ((fecha_shp_actual.equalsIgnoreCase(fecha_finHR) || intervalo1 == 1 || !ftReader.hasNext()) && ban) {
                        esta_dentroHR = false;
                        int bandera = false;
                        long diferencia = 0L;
                        if (intervalo1 == 1 && primera_linea_en_mov) {
                           diferencia = this.Diferencia_Minutos(fecha_finHR, fecha_shp_actual, 2);
                           if (diferencia < tiempo_det_HR) {
                              tiempo_det_HR -= diferencia;
                           }

                           bandera = true;
                        }

                        if (intervalo1 == -1 && primera_linea_en_mov) {
                           diferencia = this.Diferencia_Minutos(fecha_finHR, fecha_shp_actual, 2);
                           tiempo_det_HR += diferencia;
                        }

                        distancia_after = 0.0D;
                        km_after = 0.0D;
                        km_gps_hr = this.Redondear_Numero(distancia_por_gps, 2);
                        if (tiempo_det_SR < 0L) {
                           tiempo_det_SR = 0L;
                        }

                        this.Insertar_Datos_HR(km_gps_hr, km_sin_resp, km_after, tiempo_det_SR, tiempo_det_HR, j);
                        tiempo_det_HR = 0L;
                        tiempo_det_SR = 0L;
                        ++j;
                        esta_dentroHR = false;
                        primera_linea_en_mov = false;
                        if (j < cant_hr) {
                           fecha_inicioHR = this.ObtenerFechaHora(j, "inicial", 2);
                           ban = false;
                        }

                        distancia_por_gps = 0.0D;
                        distancia_sin_respaldo = 0.0D;
                     }
                  } else {
                     distancia_sin_respaldo += distancia_recorrida;
                  }

                  anterior.lon2_anterior = lon1_actual;
                  anterior.lat2_anterior = lat1_actual;
                  anterior.velocidad_anterior = velocidad_actual;
                  anterior.rotacion_anterior = rotacion_actual;
                  anterior.fecha_anterior = fecha_shp_actual;
                  anterior.dist_anterior = dist_actual;
               }
            } catch (Exception var64) {
               anterior.lon2_anterior = lon1_actual;
               anterior.lat2_anterior = lat1_actual;
               anterior.velocidad_anterior = velocidad_actual;
               anterior.rotacion_anterior = rotacion_actual;
               anterior.fecha_anterior = fecha_shp_actual;
               anterior.dist_anterior = dist_actual;
            }
         }

         if (j < cant_hr && !ftReader.hasNext()) {
            fecha_finHR = this.ObtenerFechaHora(j, "final", 2);
            int intervalo1 = this.Compara_LogId(fecha_finHR, fecha_shp_actual, 2);
            if (intervalo1 == 1 || intervalo1 == -1) {
               tiempo_det_HR = this.Diferencia_Minutos(fecha_inicioHR, fecha_finHR, 2);
            }

            this.Insertar_Datos_HR(km_gps_hr, km_sin_resp, km_after, tiempo_det_SR, tiempo_det_HR, j);
            tiempo_det_HR = 0L;
            tiempo_det_SR = 0L;
         }

         ftReader.close();
         fichero_shp.dispose();
         this.en.shape.closeFeatureWriter();
         if (!fi_mov.equalsIgnoreCase("") && !FechaFin.equalsIgnoreCase("") && tiempo_mov > 0L) {
            FechaInicio = "to_timestamp('" + fi_mov + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
            FechaFin = "to_timestamp('" + FechaFin + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
            String mov_Noct = "INSERT INTO moviles_mov(logid, fecha_inicio, fecha_fin,minutos) Values(";
            consulta = mov_Noct + "'" + this.en.logid + "'" + "," + FechaInicio + "," + FechaFin + "," + tiempo_mov + ");";
            StringBuilder var10000 = new StringBuilder();
            Entrada var10002 = this.en;
            var10002.insertDB = var10000.append(var10002.insertDB).append(consulta).toString();
         }

         km_after = this.Redondear_Numero(distancia_after, 2);
         this.Insertar_KmAfter(km_after);
         if (this.cant_lineas_shp == 1) {
            if (km_after == 0.0D && tiempo_det_SR == 0L) {
               this.InsertarTiempoDetSR();
            }

            if (km_gps_hr == 0.0D && tiempo_det_HR == 0L) {
               this.InsertarTiempoDetHR();
            }

            this.Trayectoria_Detenida = true;
         }

      }
   }

   public void ProcesarHoja_de_RutaCabv3() throws IOException {
      String fecha_shp_actual = "";
      long tiempo_det_HR = 0L;
      long tiempo_det_SR = 0L;
      double lon1_actual = 0.0D;
      double lat1_actual = 0.0D;
      double velocidad_actual = 0.0D;
      double rotacion_actual = 0.0D;
      double dist_actual = 0.0D;
      double km_after = 0.0D;
      double km_gps_hr = 0.0D;
      double km_sin_resp = 0.0D;
      double distancia_recorrida = 0.0D;
      double distancia_sin_respaldo = 0.0D;
      double dist_inicial = 0.0D;
      boolean vehiculo_parado = false;
      boolean esta_dentroHR = false;
      boolean primera_linea_en_mov = false;
      boolean mov_nocturno = false;
      String movimiento = "";
      String primera_shp = "";
      String fi_mov_noc = "";
      String ff_mov_noc = "";
      String fi_mov = "";
      String FechaInicio = "";
      String FechaFin = "";
      long tiempo_mov = 0L;
      Datos_Hoja_de_Ruta.anterior anterior = new Datos_Hoja_de_Ruta.anterior();
      double distancia_after = 0.0D;
      double distancia_por_gps = 0.0D;
      int ban = false;
      String consulta = "";
      this.en.camino_trayec = "Temp\\Ficheros\\Trayectoria\\Trayectoria.shp";
      File shp1 = new File(this.en.camino_trayec);
      if (!this.en.shp.exists()) {
         this.en.ShowMessage("No se Encontró el Fichero " + this.en.shp.getAbsolutePath(), "Error", "Error");
      } else {
         if (shp1.exists()) {
            this.en.BorrarDirectorio("Temp\\Ficheros\\Trayectoria");
         }

         this.en.shape.initFeatureWriter(this.en.camino_trayec);
         ShapefileDataStore fichero_shp = new ShapefileDataStore(this.en.shp.toURL());
         FeatureReader<SimpleFeatureType, SimpleFeature> ftReader = fichero_shp.getFeatureReader();
         int cant_hr = this.ListaHr.size();
         int j = 0;
         int i = false;
         String fecha_inicioHR = this.ObtenerFechaHora(j, "inicial", 2);
         String fecha_finHR = this.ObtenerFechaHora(j, "final", 2);

         while(ftReader.hasNext()) {
            try {
               ++this.cant_lineas_shp;
               List<Object> values = ((SimpleFeature)ftReader.next()).getAttributes();
               Point geometria = (Point)values.get(0);
               lon1_actual = geometria.getX();
               lat1_actual = geometria.getY();
               String fecha_temp = String.valueOf(values.get(2));
               fecha_shp_actual = fecha_temp.substring(0, 4) + "-" + fecha_temp.substring(5, 7) + "-" + fecha_temp.substring(8, 10) + " " + fecha_temp.substring(11, 19);
               velocidad_actual = (Double)values.get(3);
               rotacion_actual = (Double)values.get(4);
               int orden = (Integer)values.get(5);
               int stopidx = (Integer)values.get(6);
               movimiento = String.valueOf(values.get(7));
               dist_actual = (Double)values.get(8);
               this.en.Adicionar_Linea_de_la_Trayect_shp(lat1_actual, lon1_actual, rotacion_actual, velocidad_actual, fecha_temp, orden, stopidx, dist_actual);
               if (anterior.vacio) {
                  anterior.lon2_anterior = lon1_actual;
                  anterior.lat2_anterior = lat1_actual;
                  anterior.velocidad_anterior = velocidad_actual;
                  anterior.rotacion_anterior = rotacion_actual;
                  anterior.fecha_anterior = fecha_shp_actual;
                  anterior.mov_anterior = movimiento;
                  anterior.dist_anterior = dist_actual;
                  anterior.vacio = false;
                  if (movimiento.equalsIgnoreCase("0") && velocidad_actual == 0.0D) {
                     vehiculo_parado = true;
                     primera_linea_en_mov = false;
                  }
               } else {
                  if (this.ComparaFecha(fecha_shp_actual)) {
                     if (velocidad_actual > 20.0D) {
                        if (fi_mov.equalsIgnoreCase("")) {
                           fi_mov = fecha_shp_actual;
                        }

                        if (fi_mov_noc.equalsIgnoreCase("")) {
                           fi_mov_noc = fecha_shp_actual;
                           mov_nocturno = true;
                        }
                     } else if (!fi_mov_noc.equalsIgnoreCase("")) {
                        ff_mov_noc = fecha_shp_actual;
                     }

                     if (!fi_mov_noc.equalsIgnoreCase("") && !ff_mov_noc.equalsIgnoreCase("")) {
                        tiempo_mov += this.Diferencia_Minutos(fi_mov_noc, ff_mov_noc, 2);
                        fi_mov_noc = "";
                        FechaFin = ff_mov_noc;
                        ff_mov_noc = "";
                        mov_nocturno = false;
                     }
                  } else if (mov_nocturno && !fi_mov_noc.equalsIgnoreCase("") && ff_mov_noc.equalsIgnoreCase("")) {
                     tiempo_mov += this.Diferencia_Minutos(fi_mov_noc, fecha_shp_actual, 2);
                     fi_mov_noc = "";
                     FechaFin = fecha_shp_actual;
                     ff_mov_noc = "";
                     mov_nocturno = false;
                  }

                  distancia_recorrida = dist_actual - anterior.dist_anterior;
                  this.distancia_recorrida_total += distancia_recorrida;
                  distancia_after += distancia_recorrida;
                  if (movimiento.equalsIgnoreCase("0") && velocidad_actual == 0.0D && !vehiculo_parado) {
                     vehiculo_parado = true;
                  }

                  if (velocidad_actual > 0.0D && movimiento.equalsIgnoreCase("1") && vehiculo_parado && !esta_dentroHR) {
                     primera_linea_en_mov = true;
                     tiempo_det_SR += this.Diferencia_Minutos(anterior.fecha_anterior, fecha_shp_actual, 2);
                     vehiculo_parado = false;
                  }

                  if (velocidad_actual > 0.0D && movimiento.equalsIgnoreCase("1") && vehiculo_parado && esta_dentroHR) {
                     primera_linea_en_mov = true;
                     tiempo_det_HR += this.Diferencia_Minutos(anterior.fecha_anterior, fecha_shp_actual, 2);
                     vehiculo_parado = false;
                  }

                  int intervalo = this.Compara_LogId(fecha_inicioHR, fecha_shp_actual, 2);
                  if ((fecha_shp_actual.equalsIgnoreCase(fecha_inicioHR) || intervalo == 1) && !ban) {
                     ban = true;
                     if (intervalo == 1 && primera_linea_en_mov) {
                        long diferencia = this.Diferencia_Minutos(fecha_inicioHR, fecha_shp_actual, 2);
                        if (tiempo_det_SR == 0L) {
                           tiempo_det_SR = -1L;
                        } else {
                           tiempo_det_SR -= diferencia;
                        }

                        tiempo_det_HR += diferencia;
                     }

                     km_sin_resp = this.Redondear_Numero(distancia_sin_respaldo, 2);
                     esta_dentroHR = true;
                     if (j > 0) {
                        fecha_finHR = this.ObtenerFechaHora(j, "final", 2);
                     }
                  }

                  if (esta_dentroHR) {
                     distancia_por_gps += distancia_recorrida;
                     int intervalo1 = this.Compara_LogId(fecha_finHR, fecha_shp_actual, 2);
                     if ((fecha_shp_actual.equalsIgnoreCase(fecha_finHR) || intervalo1 == 1 || !ftReader.hasNext()) && ban) {
                        esta_dentroHR = false;
                        int bandera = false;
                        long diferencia = 0L;
                        if (intervalo1 == 1 && primera_linea_en_mov) {
                           diferencia = this.Diferencia_Minutos(fecha_finHR, fecha_shp_actual, 2);
                           if (diferencia < tiempo_det_HR) {
                              tiempo_det_HR -= diferencia;
                           }

                           bandera = true;
                        }

                        if (intervalo1 == -1 && primera_linea_en_mov) {
                           diferencia = this.Diferencia_Minutos(fecha_finHR, fecha_shp_actual, 2);
                           tiempo_det_HR += diferencia;
                        }

                        distancia_after = 0.0D;
                        km_after = 0.0D;
                        km_gps_hr = this.Redondear_Numero(distancia_por_gps, 2);
                        if (tiempo_det_SR < 0L) {
                           tiempo_det_SR = 0L;
                        }

                        this.Insertar_Datos_HR(km_gps_hr, km_sin_resp, km_after, tiempo_det_SR, tiempo_det_HR, j);
                        tiempo_det_HR = 0L;
                        tiempo_det_SR = 0L;
                        fecha_inicioHR = "";
                        fecha_finHR = "";
                        km_gps_hr = 0.0D;
                        km_sin_resp = 0.0D;
                        ++j;
                        esta_dentroHR = false;
                        primera_linea_en_mov = false;
                        if (j < cant_hr) {
                           fecha_inicioHR = this.ObtenerFechaHora(j, "inicial", 2);
                           ban = false;
                        }

                        distancia_por_gps = 0.0D;
                        distancia_sin_respaldo = 0.0D;
                     }
                  } else {
                     distancia_sin_respaldo += distancia_recorrida;
                  }

                  anterior.lon2_anterior = lon1_actual;
                  anterior.lat2_anterior = lat1_actual;
                  anterior.velocidad_anterior = velocidad_actual;
                  anterior.rotacion_anterior = rotacion_actual;
                  anterior.fecha_anterior = fecha_shp_actual;
                  anterior.mov_anterior = movimiento;
                  anterior.dist_anterior = dist_actual;
               }
            } catch (Exception var66) {
               anterior.lon2_anterior = lon1_actual;
               anterior.lat2_anterior = lat1_actual;
               anterior.velocidad_anterior = velocidad_actual;
               anterior.rotacion_anterior = rotacion_actual;
               anterior.fecha_anterior = fecha_shp_actual;
               anterior.mov_anterior = movimiento;
               anterior.dist_anterior = dist_actual;
            }
         }

         if (j < cant_hr && !ftReader.hasNext()) {
            fecha_finHR = this.ObtenerFechaHora(j, "final", 2);
            int intervalo1 = this.Compara_LogId(fecha_finHR, fecha_shp_actual, 2);
            if (intervalo1 == 1 || intervalo1 == -1) {
               tiempo_det_HR = this.Diferencia_Minutos(fecha_inicioHR, fecha_finHR, 2);
            }

            this.Insertar_Datos_HR(km_gps_hr, km_sin_resp, km_after, tiempo_det_SR, tiempo_det_HR, j);
            tiempo_det_HR = 0L;
            tiempo_det_SR = 0L;
         }

         ftReader.close();
         fichero_shp.dispose();
         this.en.shape.closeFeatureWriter();
         if (!fi_mov.equalsIgnoreCase("") && !FechaFin.equalsIgnoreCase("") && tiempo_mov > 0L) {
            FechaInicio = "to_timestamp('" + fi_mov + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
            FechaFin = "to_timestamp('" + FechaFin + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
            String mov_Noct = "INSERT INTO moviles_mov(logid, fecha_inicio, fecha_fin,minutos) Values(";
            consulta = mov_Noct + "'" + this.en.logid + "'" + "," + FechaInicio + "," + FechaFin + "," + tiempo_mov + ");";
            StringBuilder var10000 = new StringBuilder();
            Entrada var10002 = this.en;
            var10002.insertDB = var10000.append(var10002.insertDB).append(consulta).toString();
         }

         km_after = this.Redondear_Numero(distancia_after, 2);
         this.Insertar_KmAfter(km_after);
         if (this.cant_lineas_shp == 1) {
            if (km_after == 0.0D && tiempo_det_SR == 0L) {
               this.InsertarTiempoDetSR();
            }

            if (km_gps_hr == 0.0D && tiempo_det_HR == 0L) {
               this.InsertarTiempoDetHR();
            }

            this.Trayectoria_Detenida = true;
         }

      }
   }

   public boolean Subir_Trayectoria(String logid, File XML_Compactado) throws UnsupportedEncodingException, IOException {
      String port = null;
      URLConnection conn = null;
      String sitio = this.en.GetSitio();
      sitio = sitio + "/MovilWebServLet/Organize";
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Enviando Trayectoria Compactada...");
      this.PB.setVisible(true);

      try {
         URL url;
         if (this.en.Hay_Proxy) {
            String ip = this.en.DireccionProxy;
            port = this.en.PuertoProxy;
            String usuasriop = this.en.UsuarioProxy;
            String passp = this.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(port), sitio);
            conn = url.openConnection();
            String user_pass = usuasriop + ":" + passp;
            String encoding = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + encoding);
         } else {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         }

         ClientHttpRequest http = new ClientHttpRequest(conn);
         http.setParameter(logid, XML_Compactado);
         InputStream is = http.post();
         BufferedReader rd = new BufferedReader(new InputStreamReader(is));

         String line;
         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         is.close();
         if (respuesta.equalsIgnoreCase("SUCCESS")) {
            return true;
         } else {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            return false;
         }
      } catch (Exception var17) {
         this.PBLabel.setVisible(false);
         this.PB.setVisible(false);
         return false;
      }
   }

   public boolean Subir_Trayectoria_shp(String logid, File XML_Compactado) throws UnsupportedEncodingException, IOException {
      String port = null;
      URLConnection conn = null;
      String sitio = this.en.GetSitio();
      sitio = sitio + "/MovilWebServLet/OrganizeSHP?time=" + (new Date()).getTime();
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Enviando Trayectoria Compactada...");
      this.PB.setVisible(true);

      try {
         URL url;
         if (this.en.Hay_Proxy) {
            String ip = this.en.DireccionProxy;
            port = this.en.PuertoProxy;
            String usuasriop = this.en.UsuarioProxy;
            String passp = this.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(port), sitio);
            conn = url.openConnection();
            String user_pass = usuasriop + ":" + passp;
            String encoding = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + encoding);
         } else {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         }

         ClientHttpRequest http = new ClientHttpRequest(conn);
         http.setParameter(logid, XML_Compactado);
         InputStream is = http.post();
         BufferedReader rd = new BufferedReader(new InputStreamReader(is));

         String line;
         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         is.close();
         if (respuesta.equalsIgnoreCase("SUCCESS")) {
            return true;
         } else {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            return false;
         }
      } catch (Exception var17) {
         return false;
      }
   }

   public boolean ComparaFecha(String fi) {
      try {
         long ff_long = 0L;
         long fi_long = 0L;
         Date fecha_final = null;
         Date fecha_inicial = null;
         int initial_year = Integer.parseInt(fi.substring(0, 4).toString());
         int initial_month = Integer.parseInt(fi.substring(6, 7).toString()) - 1;
         int initial_day = Integer.parseInt(fi.substring(8, 10).toString());
         int initial_hour = Integer.parseInt(fi.substring(11, 13).toString());
         int initial_min = Integer.parseInt(fi.substring(14, 16).toString());
         int initial_seg = Integer.parseInt(fi.substring(17, 19).toString());
         fecha_inicial = new Date(initial_year, initial_month, initial_day, initial_hour, initial_min, initial_seg);
         fi_long = fecha_inicial.getTime();
         if (fecha_inicial.getHours() >= 22 && fecha_inicial.getHours() <= 24) {
            return true;
         } else {
            return fecha_inicial.getHours() >= 0 && fecha_inicial.getHours() < 4;
         }
      } catch (Exception var14) {
         return true;
      }
   }

   public boolean Lista_HR_Ordenada() {
      int cant_elem = this.Tabla.getRowCount();
      int elem = Integer.parseInt(this.Tabla.getValueAt(0, 0).toString());
      String primera_fecha = this.Tabla.getValueAt(0, 1).toString();
      String primera_hora = this.Tabla.getValueAt(0, 2).toString();
      int dia_1 = Integer.parseInt(primera_fecha.substring(0, 2));
      int mes_1 = Integer.parseInt(primera_fecha.substring(3, 5)) - 1;
      int year_1 = Integer.parseInt(primera_fecha.substring(6, 8)) + 100;
      int hora_1 = Integer.parseInt(primera_hora.substring(0, 2));
      int minuto_1 = Integer.parseInt(primera_hora.substring(3, 5));
      Date d = new Date(year_1, mes_1, dia_1, hora_1, minuto_1);
      long primera = d.getTime();

      for(int i = 1; i < cant_elem; ++i) {
         String fecha = this.Tabla.getValueAt(i, 1).toString();
         String hora = this.Tabla.getValueAt(i, 2).toString();
         int dia_2 = Integer.parseInt(fecha.substring(0, 2));
         int mes_2 = Integer.parseInt(fecha.substring(3, 5)) - 1;
         int year_2 = Integer.parseInt(fecha.substring(6, 8)) + 100;
         int hora_2 = Integer.parseInt(hora.substring(0, 2));
         int minuto_2 = Integer.parseInt(hora.substring(3, 5));
         Date d1 = new Date(year_2, mes_2, dia_2, hora_2, minuto_2);
         long segunda = d1.getTime();
         if (segunda <= primera) {
            return false;
         }

         primera = segunda;
      }

      return true;
   }

   public double Redondear_Numero(double numero, int dec) {
      return (double)Math.round(numero * Math.pow(10.0D, (double)dec)) / Math.pow(10.0D, (double)dec);
   }

   public String ObtenerFechaHora(int ind, String tipo, int tipo_diferido) {
      String fecha = null;
      String hora = null;
      String fecha_hora = null;
      Iterator it = this.ListaHr.iterator();
      int i = 0;

      while(it.hasNext()) {
         ++i;
         HR hr = (HR)it.next();
         if (i == ind + 1) {
            if (tipo.equalsIgnoreCase("inicial")) {
               fecha = hr.fi;
               hora = hr.hi;
            } else if (tipo.equalsIgnoreCase("final")) {
               fecha = hr.ff;
               hora = hr.hf;
            }
            break;
         }
      }

      String year = fecha.substring(0, 4);
      String mes = fecha.substring(5, 7);
      String dia = fecha.substring(8, 10);
      String hour = hora.substring(0, 2);
      String min = hora.substring(3, 5);
      if (tipo_diferido == 1) {
         fecha_hora = year + mes + dia + "T" + hour + ":" + min + ":00";
      }

      if (tipo_diferido == 2) {
         fecha_hora = year + "-" + mes + "-" + dia + " " + hour + ":" + min + ":00";
      } else {
         fecha_hora = year + "/" + mes + "/" + dia + " " + hour + ":" + min + ":00";
      }

      return fecha_hora;
   }

   public void Insertar_Datos_HR(double km_gps, double km_sin_respaldo, double km_after, long TiempoDetSR, long TiempoDetHR, int j) {
      Iterator it = this.ListaHr.iterator();

      for(int i = 0; it.hasNext(); ++i) {
         HR hr = (HR)it.next();
         if (i == j) {
            hr.km_gps = km_gps;
            hr.km_sin_respaldo = km_sin_respaldo;
            hr.km_after = km_after;
            if (TiempoDetSR == -1L) {
               hr.tiempo_det_SR = hr.tiempo_SR;
            } else {
               hr.tiempo_det_SR = TiempoDetSR;
            }

            hr.tiempo_det_HR = TiempoDetHR;
            break;
         }
      }

   }

   public void Insertar_KmAfter(double km_after) {
      Iterator it = this.ListaHr.iterator();
      int cant = this.ListaHr.size();

      for(int i = 1; it.hasNext(); ++i) {
         HR hr = (HR)it.next();
         if (i == cant) {
            hr.km_after = km_after;
         }
      }

   }

   public void Crear_Fichero_Final() {
      String camino = "Temp\\final.log";
      this.final_file = new File(camino);
      if (this.final_file.exists()) {
         int i = 1;

         while(true) {
            camino = "Temp\\final(" + i + ")" + ".log";
            this.final_file = new File(camino);
            if (!this.final_file.exists()) {
               break;
            }

            ++i;
         }
      }

   }

   public void Compactar_Fichero_Final() throws IOException {
      if (this.Acepto && this.xmlcomp.exists()) {
         this.xmlcomp.delete();
      }

      this.en.Insertar_fichero(this.en.insertDB, this.final_file);
      String camino = this.final_file.getPath();
      this.XML_Compactado = "Temp\\" + this.en.chapa + ".gz";
      this.xmlcomp = new File(this.XML_Compactado);
      if (this.xmlcomp.exists()) {
         this.xmlcomp.delete();
      }

      if (this.xmlcomp.exists()) {
         int i = 1;

         while(true) {
            this.XML_Compactado = "Temp\\" + this.en.chapa + "(" + i + ")" + ".gz";
            this.xmlcomp = new File(this.XML_Compactado);
            if (!this.xmlcomp.exists()) {
               break;
            }

            ++i;
         }
      }

      this.en.MakeGzipFile(camino, this.XML_Compactado);
      if (this.final_file.exists()) {
         this.final_file.delete();
      }

   }

   public void Encrypt(String clave, String respuesta) {
      try {
         try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            DESKeySpec kspec = new DESKeySpec(clave.getBytes());
            SecretKey ks = skf.generateSecret(kspec);

            try {
               Cipher cifrado = Cipher.getInstance("DES");
               cifrado.init(1, ks);
               InputStream archivo = new StringInputStream(respuesta);
               FileOutputStream fich_out = new FileOutputStream(this.final_file);
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

   }

   public void CompactarShapeTrayectoria() throws Exception {
      File trayectoria = new File("Temp\\Ficheros\\Trayectoria");
      String camino = "Temp\\Trayectoria\\Trayectoria.gz";
      Comprimir comp = new Comprimir(trayectoria, camino);
      comp.compress();
   }

   public void CompactarTrayectoria() {
      File temporal = new File("Temp\\Trayectoria");
      this.shp_compacto = "Temp\\" + this.en.logid + ".gz";
      Comprimir compri = new Comprimir(temporal, this.shp_compacto);

      try {
         compri.compress();
      } catch (Exception var4) {
         var4.getMessage();
      }

   }

   private void compressFolder(String inputFile, String compressedFile) {
      try {
         ZipFile zipFile = new ZipFile(compressedFile);
         File inputFileH = new File(inputFile);
         ZipParameters parameters = new ZipParameters();
         parameters.setCompressionMethod(8);
         parameters.setCompressionLevel(5);
         parameters.setEncryptFiles(true);
         parameters.setEncryptionMethod(0);
         parameters.setPassword(this.en.encript);
         zipFile.addFolder(inputFileH, parameters);
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   public void ConstruirFicheroCD() throws SAXException, IOException {
      if (this.trafico.isSelected()) {
         int cant = this.listado_prod.size();
         String consulta = "";
         CargaDescarga CDESC = new CargaDescarga(this, this.en);
         String id_doc = "";
         String id_merc = "";

         for(int i = 0; i < cant; ++i) {
            Productos p = (Productos)this.listado_prod.get(i);
            CDESC.Llenar_Combo_Documento();
            id_doc = CDESC.Obtener_ID_Doc(p.documento);
            CDESC.Llenar_Combo_Mercancia();
            id_merc = CDESC.Obtener_ID_Merc(p.mercancia);
            if (id_doc.equalsIgnoreCase("")) {
               this.en.ShowMessage("En Genera Tráfico no se Encuentra el Documento. Por Favor Actualíce la Lista.", "Información", "Information");
               this.ban = 1;
               break;
            }

            if (id_merc.equalsIgnoreCase("")) {
               this.en.ShowMessage("En Genera Tráfico no se Encuentra la Mercancía. Por Favor Actualíce la Lista.", "Información", "Information");
               this.ban = 1;
               break;
            }

            String cd = "INSERT INTO diferido_documentos(documento,numero_documento,producto,cantidad,logid) VALUES (";
            consulta = consulta + cd + id_doc + "," + "'" + p.numero + "'" + "," + id_merc + "," + p.cant_merc + "," + "'" + this.en.logid + "'" + ");";
         }

         StringBuilder var10000 = new StringBuilder();
         Entrada var10002 = this.en;
         var10002.insertDB = var10000.append(var10002.insertDB).append(consulta).toString();
      }

   }

   public void ConstruirFicheroAbastec() throws SAXException, IOException, ParseException {
      if (this.abastecimient.isSelected()) {
         this.total_abastecido = 0.0D;
         int cant = this.listado_chip.size();
         Abastecimiento ABAST = new Abastecimiento(this, this.en);
         String consulta = "";

         for(int i = 0; i < cant; ++i) {
            ChipCombustible chip = (ChipCombustible)this.listado_chip.get(i);
            int Abast_en_Parada = this.AbastecimientoenParada(chip.getFecha(), chip.getGeomEstablecimiento());
            String FechaHora = "to_timestamp('" + chip.getFecha() + "'" + ",'DD-MM-YY HH24:MI:SS')";
            String id_tarjeta = ABAST.Obtener_ID_Tarjeta(chip.getNumero_tarjeta());
            this.total_abastecido += chip.getCantAbastecida();
            if (id_tarjeta.equalsIgnoreCase("")) {
               this.en.ShowMessage("En Abastecimiento no se encuentra el Número de Tarjeta. Por Favor Actualíce la Lista.", "Información", "Information");
               this.ban = 1;
               break;
            }

            byte tipo;
            if (chip.getTipoAbastecimiento().equalsIgnoreCase("Desplazamiento")) {
               tipo = 1;
            } else {
               tipo = 2;
            }

            String cd = "INSERT INTO abastecimiento_diferido(fecha,numero_comprobante,cant_abastecida,id_provincia, id_establec_cupet, id_tarjeta,logid,id_tipo,en_parada,sinicial,sfinal) VALUES (";
            consulta = consulta + cd + FechaHora + "," + "'" + chip.getNoComprobante() + "'" + "," + chip.getCantAbastecida() + "," + chip.getidloc() + "," + chip.getidest() + "," + chip.getidtarjeta() + "," + "'" + this.en.logid + "'" + "," + tipo + "," + Abast_en_Parada + "," + chip.getSaldoInicial() + "," + chip.getSaldoFinal() + ");";
         }

         StringBuilder var10000 = new StringBuilder();
         Entrada var10002 = this.en;
         var10002.insertDB = var10000.append(var10002.insertDB).append(consulta).toString();
      }

   }

   public int AbastecimientoenParada(String fecha_abast, Point geom_estab) throws ParseException {
      double tolerancia = 0.0019399018409668471D;
      Point geom_det = null;
      SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      int dia_inicial = Integer.parseInt(fecha_abast.substring(0, 2));
      int mes_inicial = Integer.parseInt(fecha_abast.substring(3, 5)) - 1;
      int year_inicial = Integer.parseInt(fecha_abast.substring(6, 8)) + 100;
      int hora_inic = Integer.parseInt(fecha_abast.substring(9, 11));
      int min_inic = Integer.parseInt(fecha_abast.substring(12, 14));
      Date f1 = new Date(year_inicial, mes_inicial, dia_inicial, hora_inic, min_inic);
      String fechaAbast = f.format(f1);
      Iterator it = this.en.Paradas.iterator();

      try {
         while(it.hasNext()) {
            Detenciones det = (Detenciones)it.next();
            String fecha_inicio = det.Fecha1;
            String fecha_fin = det.Fecha2;
            double lat = det.latitud;
            double lon = det.longitud;
            geom_det = this.en.shape.geometryFactory.createPoint(new Coordinate(lon, lat));
            Date date1 = f.parse(fecha_inicio);
            Date date2 = f.parse(fecha_fin);
            Calendar cal1 = new GregorianCalendar();
            cal1.setTime(date1);
            Calendar cal2 = new GregorianCalendar();
            cal2.setTime(date2);
            Date date3 = f.parse(fechaAbast);
            Calendar cal3 = new GregorianCalendar();
            cal3.setTime(date3);
            if (cal3.after(cal1) && cal3.before(cal2)) {
               geom_estab.normalize();
               geom_det.normalize();
               if (geom_estab.equalsExact(geom_det, tolerancia)) {
                  int abastenparada = false;
                  return 0;
               }
            }
         }

         return 1;
      } catch (NumberFormatException var29) {
         Logger.getLogger(var29.getMessage());
         return 1;
      } catch (ParseException var30) {
         Logger.getLogger(var30.getMessage());
         return 1;
      }
   }

   public void ConstruirFicheroUserLog() throws SAXException, IOException {
      String Movil = "'" + this.en.chapa + "'";
      long TotalPuntos = this.en.numero_de_lineas;
      long NoValidos = this.en.tramas_no_validas;
      int Desconexiones = this.en.Desconexiones.size();
      long TotalSimplificado = (long)this.cant_lineas_shp;
      String FechaHora = "to_timestamp('" + this.en.fecha_hora + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
      String Version = this.en.version;
      String fecha1 = this.Fecha1(this.en.Fecha_Inicial, this.en.Hora_Inicial);
      String fecha2 = this.Fecha1(this.en.Fecha_Final, this.en.Hora_Final);
      String F1 = "to_timestamp('" + fecha1 + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
      String F2 = "to_timestamp('" + fecha2 + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
      int NumeroHR = this.ListaHr.size();
      long mHoras = this.moto_Horas;
      if (this.genera_abastec.equalsIgnoreCase("Si") && this.distancia_recorrida_total / 1000.0D > 0.0D) {
         double ic_real = this.distancia_recorrida_total / 1000.0D / this.total_abastecido;
         double ic_plan = this.en.Consumo;
         this.desv_IConsumo = ic_real / ic_plan * 100.0D - 100.0D;
      } else {
         this.desv_IConsumo = 0.0D;
      }

      int TiempoRecorrido = this.TiempoRecorrido();
      int CantParadas = this.en.Paradas.size();
      int cantPar = 0;
      Iterator it = this.en.Paradas.iterator();

      while(it.hasNext()) {
         Detenciones det = (Detenciones)it.next();
         long tiempo = (long)det.minutos;
         if (tiempo >= 3L) {
            ++cantPar;
         }
      }

      int TiempoDet = this.TiempoDetenido();
      double MinX = this.en.minx;
      double MinY = this.en.miny;
      double MaxX = this.en.maxx;
      double MaxY = this.en.maxy;
      String Cond = "'" + this.Conductor.getText() + "'";
      String Cond_auxiliar;
      if (this.Conductor1.getText().equalsIgnoreCase("")) {
         Cond_auxiliar = null;
         this.en.IdConductorAux = -1;
      } else {
         Cond_auxiliar = "'" + this.Conductor1.getText() + "'";
      }

      String LogId = this.en.logid;
      int CheckError = (int)this.en.chequeo_suma_fallido;
      int idcond = this.en.IdConductor;
      if (idcond == -1) {
         idcond = this.BuscarIdCond(this.Conductor.getText());
      }

      int idcond_aux = this.en.IdConductorAux;
      if (idcond_aux == -1 && !this.Conductor1.getText().equalsIgnoreCase("")) {
         idcond_aux = this.BuscarIdCond(this.Conductor1.getText());
      }

      double velocidad_max = this.Redondear_Numero(this.en.velocidad_maxima, 1);
      boolean traf;
      if (this.trafico.isSelected()) {
         traf = true;
      } else {
         traf = false;
      }

      Double consumo = this.en.Consumo;
      Double consumo_tec = this.en.ConsumoTec;
      String the_geom = "geomfromtext('MULTIPOLYGON(((" + MinX + " " + MinY + "," + MaxX + " " + MaxY + "," + MinX + " " + MinY + ")))',4326)";
      int modificado = 0;
      if (this.en.posible_alteracion) {
         modificado = 1;
      }

      double size = (double)this.en.Size / 1048576.0D;
      size = this.en.Redondear_Numero(size, 2);
      int idcomb = this.en.idcombustible;
      if (idcomb == 0) {
         idcomb = this.BuscarIDComb(this.en.chapa);
      }

      int idcomb_tec = this.en.idcombustible_Tec;
      int grupo = this.en.Grupo;
      if (grupo == 0) {
         grupo = this.BuscarGrupo();
      }

      String UL_prueba = "INSERT INTO userlog(usuario,movil, totalPuntos, novalidos, cantdesconexiones, totalsimplificado, fechahora, version, fecha1, fecha2,nohr,tiemprecorr,cantparadas,tiempdet,conductor,logid,checkerror,consumo,idcomb,the_geom,grupo,idconductor,velocmax,kmhr,kmgps,noviajes,kmsinrespaldo,tiemposinrespaldo,trafico,size,modificado,id_conductor_aux,conductor_aux,desconexiones_mas5,cantviolaciones,consumo_tecnologico,id_comb_tecnologico,moto_horas  ) VALUES (";
      String consulta_prueba = UL_prueba + this.en.idusuario + "," + Movil + "," + TotalPuntos + "," + NoValidos + "," + Desconexiones + "," + TotalSimplificado + "," + FechaHora + "," + Version + "," + F1 + "," + F2 + "," + NumeroHR + "," + TiempoRecorrido + "," + cantPar + "," + TiempoDet + "," + Cond + "," + "'" + LogId + "'" + "," + CheckError + "," + consumo + "," + idcomb + "," + the_geom + "," + grupo + "," + idcond + "," + velocidad_max + "," + this.kmhr_total + "," + this.kmgps_total + "," + this.viajes + "," + this.kmsinresp + "," + this.tiemposr + "," + traf + "," + size + "," + modificado + "," + idcond_aux + "," + Cond_auxiliar + "," + this.en.cant_dxn_may_5_min + "," + this.en.cantViolaciones + "," + consumo_tec + "," + idcomb_tec + "," + mHoras + ");";
      StringBuilder var10000 = new StringBuilder();
      Entrada var10002 = this.en;
      var10002.insertDB = var10000.append(var10002.insertDB).append(consulta_prueba).toString();
   }

   public void CompactarFicheroTrayectoria() throws Exception {
      File trayectoria = new File("Temp\\Ficheros\\Trayectoria");
      String camino = "Temp\\Trayectoria\\Trayectoria.gz";
      Comprimir comp = new Comprimir(trayectoria, camino);
      comp.compress();
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
            if (chapa.equalsIgnoreCase(Chapa)) {
               idc = Integer.parseInt(idcomb);
               break;
            }
         }

         return idc;
      } catch (Exception var12) {
         String msg = "No se Pudo Obtener el Identificador de Combustible.";
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
            if (chapa.equalsIgnoreCase(Chapa)) {
               capacidad = Integer.parseInt(capacTanque);
               break;
            }
         }

         return capacidad;
      } catch (Exception var12) {
         String msg = "No se Pudo Obtener la Capacidad del Tanque.";
         this.en.ShowMessage(msg, "Información", "Information");
         return 0;
      }
   }

   public boolean Enviar_Trayectoria(File XML_Compactado) throws UnsupportedEncodingException {
      String port = null;
      URLConnection conn = null;
      String sitio = this.en.GetSitio();
      sitio = sitio + "/MovilWebServLet/UploadData106";
      String user = String.valueOf(this.en.idusuario);
      String service = "carga";
      sitio = sitio + "?user=" + user + "&service=carga?time=" + (new Date()).getTime();
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Enviando Fichero a BD...");
      this.PB.setVisible(true);

      try {
         URL url;
         if (this.en.Hay_Proxy) {
            String ip = this.en.DireccionProxy;
            port = this.en.PuertoProxy;
            String usuasriop = this.en.UsuarioProxy;
            String passp = this.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(port), sitio);
            conn = url.openConnection();
            String user_pass = usuasriop + ":" + passp;
            String encoding = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + encoding);
         } else {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         }

         ClientHttpRequest http = new ClientHttpRequest(conn);
         http.setParameter("DATA", XML_Compactado);
         InputStream is = http.post();
         InputStreamReader isr = new InputStreamReader(is);
         BufferedReader rd = new BufferedReader(isr);

         String line;
         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         isr.close();
         is.close();
         if (respuesta.equalsIgnoreCase("OK")) {
            return true;
         } else {
            System.out.print("\nHubo Problemas con el Envío de la Trayectoria");
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            return false;
         }
      } catch (Exception var17) {
         var17.printStackTrace();
         this.PBLabel.setVisible(false);
         this.PB.setVisible(false);
         return false;
      }
   }

   public int Compara_LogId(String f1, String f2, int tipo) {
      int year1;
      int mes1;
      int dia1;
      int hora1;
      int min1;
      int seg1;
      int year2;
      int mes2;
      int dia2;
      int hora2;
      int min2;
      int seg2;
      if (tipo == 1) {
         year1 = Integer.parseInt(f1.substring(0, 4)) - 1900;
         mes1 = Integer.parseInt(f1.substring(4, 6)) - 1;
         dia1 = Integer.parseInt(f1.substring(6, 8));
         hora1 = Integer.parseInt(f1.substring(9, 11));
         min1 = Integer.parseInt(f1.substring(12, 14));
         seg1 = Integer.parseInt(f1.substring(17, 19));
         year2 = Integer.parseInt(f2.substring(0, 4)) - 1900;
         mes2 = Integer.parseInt(f2.substring(4, 6)) - 1;
         dia2 = Integer.parseInt(f2.substring(6, 8));
         hora2 = Integer.parseInt(f2.substring(9, 11));
         min2 = Integer.parseInt(f2.substring(12, 14));
         seg2 = Integer.parseInt(f2.substring(17, 19));
      } else {
         year1 = Integer.parseInt(f1.substring(0, 4)) - 1900;
         mes1 = Integer.parseInt(f1.substring(5, 7)) - 1;
         dia1 = Integer.parseInt(f1.substring(8, 10));
         hora1 = Integer.parseInt(f1.substring(11, 13));
         min1 = Integer.parseInt(f1.substring(14, 16));
         seg1 = Integer.parseInt(f1.substring(17, 19));
         year2 = Integer.parseInt(f2.substring(0, 4)) - 1900;
         mes2 = Integer.parseInt(f2.substring(5, 7)) - 1;
         dia2 = Integer.parseInt(f2.substring(8, 10));
         hora2 = Integer.parseInt(f2.substring(11, 13));
         min2 = Integer.parseInt(f2.substring(14, 16));
         seg2 = Integer.parseInt(f2.substring(17, 19));
      }

      Date datef1 = new Date(year1, mes1, dia1, hora1, min1, seg1);
      Date datef2 = new Date(year2, mes2, dia2, hora2, min2, seg2);
      long a = datef1.getTime();
      long b = datef2.getTime();
      if (b > a) {
         return 1;
      } else {
         return b == a ? 0 : -1;
      }
   }

   public long Diferencia_Minutos(String f1, String f2, int tipo) {
      int year1;
      int mes1;
      int dia1;
      int hora1;
      int min1;
      int seg1;
      int year2;
      int mes2;
      int dia2;
      int hora2;
      int min2;
      int seg2;
      if (tipo == 1) {
         year1 = Integer.parseInt(f1.substring(0, 4)) - 1900;
         mes1 = Integer.parseInt(f1.substring(4, 6)) - 1;
         dia1 = Integer.parseInt(f1.substring(6, 8));
         hora1 = Integer.parseInt(f1.substring(9, 11));
         min1 = Integer.parseInt(f1.substring(12, 14));
         seg1 = Integer.parseInt(f1.substring(15, 17));
         year2 = Integer.parseInt(f2.substring(0, 4)) - 1900;
         mes2 = Integer.parseInt(f2.substring(4, 6)) - 1;
         dia2 = Integer.parseInt(f2.substring(6, 8));
         hora2 = Integer.parseInt(f2.substring(9, 11));
         min2 = Integer.parseInt(f2.substring(12, 14));
         seg2 = Integer.parseInt(f2.substring(15, 17));
      } else {
         year1 = Integer.parseInt(f1.substring(0, 4)) - 1900;
         mes1 = Integer.parseInt(f1.substring(5, 7)) - 1;
         dia1 = Integer.parseInt(f1.substring(8, 10));
         hora1 = Integer.parseInt(f1.substring(11, 13));
         min1 = Integer.parseInt(f1.substring(14, 16));
         seg1 = Integer.parseInt(f1.substring(17, 19));
         year2 = Integer.parseInt(f2.substring(0, 4)) - 1900;
         mes2 = Integer.parseInt(f2.substring(5, 7)) - 1;
         dia2 = Integer.parseInt(f2.substring(8, 10));
         hora2 = Integer.parseInt(f2.substring(11, 13));
         min2 = Integer.parseInt(f2.substring(14, 16));
         seg2 = Integer.parseInt(f2.substring(17, 19));
      }

      Date datef1 = new Date(year1, mes1, dia1, hora1, min1, seg1);
      Date datef2 = new Date(year2, mes2, dia2, hora2, min2, seg2);
      long diferencia = Math.abs(datef1.getTime() - datef2.getTime());
      return diferencia / 60000L;
   }

   public void Insertar_TiempoSR(int j, long TiempoSR) {
      Iterator it = this.ListaHr.iterator();

      for(int i = 0; it.hasNext(); ++i) {
         HR hr = (HR)it.next();
         if (i == j) {
            hr.tiempo_SR = TiempoSR;
            break;
         }
      }

   }

   public void TiemposSR() {
      int cant_elem = this.Tabla.getRowCount();
      String fi_HR = null;
      String hi_HR = null;
      String ff_HR = null;
      String hf_HR = null;
      String fi_trayectoria = this.en.Fecha_Inicial;
      String hi_trayectoria = this.en.Hora_Inicial;
      long diferencia = 0L;

      for(int i = 0; i < cant_elem; ++i) {
         int year_table;
         int month_table;
         int day_table;
         int min_table;
         int hour_table;
         Date d;
         Date d1;
         if (i == 0) {
            int year = Integer.parseInt(fi_trayectoria.subSequence(6, 8).toString()) + 100;
            int month = Integer.parseInt(fi_trayectoria.subSequence(3, 5).toString()) - 1;
            int day = Integer.parseInt(fi_trayectoria.subSequence(0, 2).toString());
            int hour = Integer.parseInt(hi_trayectoria.subSequence(0, 2).toString());
            int min = Integer.parseInt(hi_trayectoria.subSequence(3, 5).toString());
            fi_HR = this.Tabla.getValueAt(0, 1).toString();
            hi_HR = this.Tabla.getValueAt(0, 2).toString();
            year_table = Integer.parseInt(fi_HR.subSequence(6, 8).toString()) + 100;
            month_table = Integer.parseInt(fi_HR.subSequence(3, 5).toString()) - 1;
            day_table = Integer.parseInt(fi_HR.subSequence(0, 2).toString());
            hour_table = Integer.parseInt(hi_HR.subSequence(0, 2).toString());
            min_table = Integer.parseInt(hi_HR.subSequence(3, 5).toString());
            d = new Date(year, month, day, hour, min);
            d1 = new Date(year_table, month_table, day_table, hour_table, min_table);
         } else {
            fi_HR = this.Tabla.getValueAt(i - 1, 3).toString();
            hi_HR = this.Tabla.getValueAt(i - 1, 4).toString();
            year_table = Integer.parseInt(fi_HR.subSequence(6, 8).toString()) + 100;
            month_table = Integer.parseInt(fi_HR.subSequence(3, 5).toString()) - 1;
            day_table = Integer.parseInt(fi_HR.subSequence(0, 2).toString());
            hour_table = Integer.parseInt(hi_HR.subSequence(0, 2).toString());
            min_table = Integer.parseInt(hi_HR.subSequence(3, 5).toString());
            ff_HR = this.Tabla.getValueAt(i, 1).toString();
            hf_HR = this.Tabla.getValueAt(i, 2).toString();
            int year_table1 = Integer.parseInt(ff_HR.subSequence(6, 8).toString()) + 100;
            int month_table1 = Integer.parseInt(ff_HR.subSequence(3, 5).toString()) - 1;
            int day_table1 = Integer.parseInt(ff_HR.subSequence(0, 2).toString());
            int hour_table1 = Integer.parseInt(hf_HR.subSequence(0, 2).toString());
            int min_table1 = Integer.parseInt(hf_HR.subSequence(3, 5).toString());
            d = new Date(year_table, month_table, day_table, hour_table, min_table);
            d1 = new Date(year_table1, month_table1, day_table1, hour_table1, min_table1);
         }

         diferencia = Math.abs(d.getTime() - d1.getTime());
         diferencia /= 60000L;
         this.Insertar_TiempoSR(i, diferencia);
      }

   }

   private void initComponents() {
      this.Principal = new JPanel();
      this.jLabel2 = new JLabel();
      this.FechaHoraFinal = new JLabel();
      this.NoHR = new JTextField();
      this.KmRec = new JTextField();
      this.jScrollPane1 = new JScrollPane();
      this.Tabla = new JTable();
      this.Conductor = new JTextField();
      this.FII = new JFormattedTextField();
      this.FFF = new JFormattedTextField();
      this.HI = new JFormattedTextField();
      this.HF = new JFormattedTextField();
      this.jLabel10 = new JLabel();
      this.FechaHoraInicial = new JLabel();
      this.trafico = new JCheckBox();
      this.abastecimient = new JCheckBox();
      this.PB = new JLabel();
      this.PBLabel = new JLabel();
      this.jButton2 = new JButton();
      this.Conductor1 = new JTextField();
      this.ImgChofer = new JLabel();
      this.ImgChofer1 = new JLabel();
      this.ImgCh = new JLabel();
      this.ImgCh1 = new JLabel();
      this.ImgAdic = new JLabel();
      this.ImgAdic1 = new JLabel();
      this.ImgAct = new JLabel();
      this.ImgAct1 = new JLabel();
      this.ImgElim = new JLabel();
      this.ImgElim1 = new JLabel();
      this.Elim = new JLabel();
      this.Elim1 = new JLabel();
      this.ImgAceptar = new JLabel();
      this.ImgAceptar1 = new JLabel();
      this.ImgReporte = new JLabel();
      this.ImgReporte1 = new JLabel();
      this.ImagEnviar = new JLabel();
      this.ImagEnviar1 = new JLabel();
      this.ImgTerminar = new JLabel();
      this.ImgTerminar1 = new JLabel();
      this.User = new JLabel();
      this.User1 = new JLabel();
      this.User2 = new JLabel();
      this.User3 = new JLabel();
      this.User4 = new JLabel();
      this.User5 = new JLabel();
      this.User6 = new JLabel();
      this.User7 = new JLabel();
      this.Elim2 = new JLabel();
      this.Elim3 = new JLabel();
      this.motoHoras = new JLabel();
      this.MotoHoras = new JFormattedTextField();
      this.jLabel9 = new JLabel();
      this.setDefaultCloseOperation(0);
      this.setLocationByPlatform(true);
      this.setResizable(false);
      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent evt) {
            Datos_Hoja_de_Ruta.this.formWindowClosing(evt);
         }
      });
      this.Principal.setBackground(new Color(201, 231, 221));
      this.Principal.setBorder(BorderFactory.createEtchedBorder());
      this.Principal.setLayout(new AbsoluteLayout());
      this.jLabel2.setFont(new Font("Tahoma", 0, 12));
      this.jLabel2.setForeground(new Color(0, 0, 102));
      this.jLabel2.setText("Fecha Final de Trayectoria:");
      this.Principal.add(this.jLabel2, new AbsoluteConstraints(265, 140, -1, -1));
      this.FechaHoraFinal.setFont(new Font("Tahoma", 0, 12));
      this.FechaHoraFinal.setForeground(new Color(0, 0, 102));
      this.FechaHoraFinal.setText("Fecha Final");
      this.Principal.add(this.FechaHoraFinal, new AbsoluteConstraints(425, 140, -1, -1));
      this.NoHR.setToolTipText("Número de la HR");
      this.NoHR.setAutoscrolls(false);
      this.NoHR.setBorder(BorderFactory.createBevelBorder(1));
      this.NoHR.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent evt) {
            Datos_Hoja_de_Ruta.this.NoHRKeyTyped(evt);
         }
      });
      this.Principal.add(this.NoHR, new AbsoluteConstraints(480, 40, 80, -1));
      this.KmRec.setToolTipText("Kilómetros Recorridos por HR");
      this.KmRec.setBorder(BorderFactory.createBevelBorder(1));
      this.KmRec.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent evt) {
            Datos_Hoja_de_Ruta.this.KmRecKeyTyped(evt);
         }
      });
      this.Principal.add(this.KmRec, new AbsoluteConstraints(480, 60, 80, -1));
      this.Tabla.setAutoCreateRowSorter(true);
      this.Tabla.setForeground(new Color(0, 102, 102));
      this.Tabla.setModel(new DefaultTableModel(new Object[0][], new String[]{"No.", "Fecha Inicial", "Hora Inicial", "Fecha Final", "Hora Final", "Kms Rec.", "Moto Horas"}) {
         Class[] types = new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class};
         boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false};

         public Class getColumnClass(int columnIndex) {
            return this.types[columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return this.canEdit[columnIndex];
         }
      });
      this.Tabla.setFocusCycleRoot(true);
      this.Tabla.setSelectionMode(0);
      this.Tabla.getTableHeader().setReorderingAllowed(false);
      this.Tabla.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.TablaMouseClicked(evt);
         }
      });
      this.jScrollPane1.setViewportView(this.Tabla);
      if (this.Tabla.getColumnModel().getColumnCount() > 0) {
         this.Tabla.getColumnModel().getColumn(0).setResizable(false);
         this.Tabla.getColumnModel().getColumn(0).setPreferredWidth(8);
         this.Tabla.getColumnModel().getColumn(1).setResizable(false);
         this.Tabla.getColumnModel().getColumn(1).setPreferredWidth(40);
         this.Tabla.getColumnModel().getColumn(2).setResizable(false);
         this.Tabla.getColumnModel().getColumn(2).setPreferredWidth(40);
         this.Tabla.getColumnModel().getColumn(3).setResizable(false);
         this.Tabla.getColumnModel().getColumn(3).setPreferredWidth(40);
         this.Tabla.getColumnModel().getColumn(4).setResizable(false);
         this.Tabla.getColumnModel().getColumn(4).setPreferredWidth(40);
         this.Tabla.getColumnModel().getColumn(5).setResizable(false);
         this.Tabla.getColumnModel().getColumn(5).setPreferredWidth(35);
         this.Tabla.getColumnModel().getColumn(6).setResizable(false);
      }

      this.Principal.add(this.jScrollPane1, new AbsoluteConstraints(20, 320, 560, 100));
      this.Conductor.setEditable(false);
      this.Conductor.setToolTipText("Nombre del Chofer");
      this.Conductor.setBorder(BorderFactory.createBevelBorder(1));
      this.Principal.add(this.Conductor, new AbsoluteConstraints(240, 180, 240, -1));
      this.FII.setBorder(BorderFactory.createBevelBorder(1));

      try {
         this.FII.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/##")));
      } catch (ParseException var6) {
         var6.printStackTrace();
      }

      this.FII.setToolTipText("Fecha Inicial de la HR");
      this.FII.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Datos_Hoja_de_Ruta.this.FIIActionPerformed(evt);
         }
      });
      this.Principal.add(this.FII, new AbsoluteConstraints(130, 40, 70, -1));
      this.FFF.setBorder(BorderFactory.createBevelBorder(1));

      try {
         this.FFF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/##")));
      } catch (ParseException var5) {
         var5.printStackTrace();
      }

      this.FFF.setToolTipText("Fecha Final de la HR");
      this.Principal.add(this.FFF, new AbsoluteConstraints(130, 70, 70, -1));
      this.HI.setBorder(BorderFactory.createBevelBorder(1));

      try {
         this.HI.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##")));
      } catch (ParseException var4) {
         var4.printStackTrace();
      }

      this.HI.setText("0000");
      this.HI.setToolTipText("Hora Inicial de la HR");
      this.HI.addFocusListener(new FocusAdapter() {
         public void focusLost(FocusEvent evt) {
            Datos_Hoja_de_Ruta.this.HIFocusLost(evt);
         }
      });
      this.Principal.add(this.HI, new AbsoluteConstraints(305, 40, 70, -1));
      this.HF.setBorder(BorderFactory.createBevelBorder(1));

      try {
         this.HF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##")));
      } catch (ParseException var3) {
         var3.printStackTrace();
      }

      this.HF.setText("0000 ");
      this.HF.setToolTipText("Hora Final de la HR");
      this.HF.addFocusListener(new FocusAdapter() {
         public void focusLost(FocusEvent evt) {
            Datos_Hoja_de_Ruta.this.HFFocusLost(evt);
         }
      });
      this.Principal.add(this.HF, new AbsoluteConstraints(305, 70, 70, -1));
      this.jLabel10.setFont(new Font("Tahoma", 0, 12));
      this.jLabel10.setForeground(new Color(0, 0, 102));
      this.jLabel10.setText("Fecha Inicial de Trayectoria:");
      this.Principal.add(this.jLabel10, new AbsoluteConstraints(260, 120, -1, -1));
      this.FechaHoraInicial.setFont(new Font("Tahoma", 0, 12));
      this.FechaHoraInicial.setForeground(new Color(0, 0, 102));
      this.FechaHoraInicial.setText("Fecha de Inicio");
      this.Principal.add(this.FechaHoraInicial, new AbsoluteConstraints(425, 120, -1, -1));
      this.trafico.setFont(new Font("Tahoma", 0, 12));
      this.trafico.setForeground(new Color(0, 0, 102));
      this.trafico.setToolTipText("Datos de Carga y Descarga");
      this.trafico.setLabel("Genera Tráfico");
      this.trafico.setOpaque(false);
      this.trafico.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Datos_Hoja_de_Ruta.this.traficoActionPerformed(evt);
         }
      });
      this.Principal.add(this.trafico, new AbsoluteConstraints(40, 120, -1, -1));
      this.abastecimient.setFont(new Font("Tahoma", 0, 12));
      this.abastecimient.setForeground(new Color(0, 0, 102));
      this.abastecimient.setText("Abastecimiento");
      this.abastecimient.setToolTipText("Datos de Abastecimiento");
      this.abastecimient.setOpaque(false);
      this.abastecimient.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Datos_Hoja_de_Ruta.this.abastecimientActionPerformed(evt);
         }
      });
      this.Principal.add(this.abastecimient, new AbsoluteConstraints(40, 140, -1, -1));
      this.PB.setIcon(new ImageIcon(this.getClass().getResource("/Images/sss.gif")));
      this.Principal.add(this.PB, new AbsoluteConstraints(20, 480, 100, 11));
      this.PBLabel.setForeground(new Color(0, 0, 102));
      this.PBLabel.setText("Analizando Trayectoria...");
      this.Principal.add(this.PBLabel, new AbsoluteConstraints(130, 480, -1, -1));
      this.jButton2.setText("Visor");
      this.jButton2.setToolTipText("Visor de Mapas");
      this.jButton2.setOpaque(false);
      this.jButton2.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.jButton2MouseClicked(evt);
         }
      });
      this.jButton2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Datos_Hoja_de_Ruta.this.jButton2ActionPerformed(evt);
         }
      });
      this.Principal.add(this.jButton2, new AbsoluteConstraints(520, 470, 75, 25));
      this.Conductor1.setEditable(false);
      this.Conductor1.setToolTipText("Nombre del Chofer Auxiliar");
      this.Conductor1.setBorder(BorderFactory.createBevelBorder(1));
      this.Principal.add(this.Conductor1, new AbsoluteConstraints(240, 210, 240, -1));
      this.ImgChofer.setIcon(new ImageIcon(this.getClass().getResource("/Images/chofer.png")));
      this.ImgChofer.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgChoferMouseEntered(evt);
         }
      });
      this.Principal.add(this.ImgChofer, new AbsoluteConstraints(480, 180, 20, 20));
      this.ImgChofer1.setIcon(new ImageIcon(this.getClass().getResource("/Images/chofer on.png")));
      this.ImgChofer1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgChofer1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgChofer1MouseExited(evt);
         }
      });
      this.Principal.add(this.ImgChofer1, new AbsoluteConstraints(480, 180, 20, 20));
      this.ImgCh.setIcon(new ImageIcon(this.getClass().getResource("/Images/chofer.png")));
      this.ImgCh.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgChMouseEntered(evt);
         }
      });
      this.Principal.add(this.ImgCh, new AbsoluteConstraints(480, 210, 20, 20));
      this.ImgCh1.setIcon(new ImageIcon(this.getClass().getResource("/Images/chofer on.png")));
      this.ImgCh1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgCh1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgCh1MouseExited(evt);
         }
      });
      this.Principal.add(this.ImgCh1, new AbsoluteConstraints(480, 210, 20, 20));
      this.ImgAdic.setIcon(new ImageIcon(this.getClass().getResource("/Images/adicionar.png")));
      this.ImgAdic.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgAdicMouseEntered(evt);
         }
      });
      this.Principal.add(this.ImgAdic, new AbsoluteConstraints(130, 270, 96, 32));
      this.ImgAdic1.setIcon(new ImageIcon(this.getClass().getResource("/Images/adicionar on.png")));
      this.ImgAdic1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgAdic1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgAdic1MouseExited(evt);
         }
      });
      this.Principal.add(this.ImgAdic1, new AbsoluteConstraints(130, 270, 96, 32));
      this.ImgAct.setIcon(new ImageIcon(this.getClass().getResource("/Images/actualizar.png")));
      this.ImgAct.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgActMouseEntered(evt);
         }
      });
      this.Principal.add(this.ImgAct, new AbsoluteConstraints(250, 270, 96, 32));
      this.ImgAct1.setIcon(new ImageIcon(this.getClass().getResource("/Images/actualizar on.png")));
      this.ImgAct1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgAct1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgAct1MouseExited(evt);
         }
      });
      this.Principal.add(this.ImgAct1, new AbsoluteConstraints(250, 270, 96, 32));
      this.ImgElim.setIcon(new ImageIcon(this.getClass().getResource("/Images/eliminar.png")));
      this.ImgElim.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgElimMouseEntered(evt);
         }
      });
      this.Principal.add(this.ImgElim, new AbsoluteConstraints(370, 270, 96, 32));
      this.ImgElim1.setIcon(new ImageIcon(this.getClass().getResource("/Images/eliminar on.png")));
      this.ImgElim1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgElim1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgElim1MouseExited(evt);
         }
      });
      this.Principal.add(this.ImgElim1, new AbsoluteConstraints(370, 270, 96, 32));
      this.Elim.setIcon(new ImageIcon(this.getClass().getResource("/Images/elim chofer.png")));
      this.Elim.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ElimMouseEntered(evt);
         }
      });
      this.Principal.add(this.Elim, new AbsoluteConstraints(500, 210, 20, 20));
      this.Elim1.setIcon(new ImageIcon(this.getClass().getResource("/Images/elim chofer on.png")));
      this.Elim1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.Elim1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.Elim1MouseExited(evt);
         }
      });
      this.Principal.add(this.Elim1, new AbsoluteConstraints(500, 210, 20, 20));
      this.ImgAceptar.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar.png")));
      this.ImgAceptar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgAceptarMouseEntered(evt);
         }
      });
      this.Principal.add(this.ImgAceptar, new AbsoluteConstraints(85, 435, 96, 32));
      this.ImgAceptar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/aceptar on.png")));
      this.ImgAceptar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgAceptar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgAceptar1MouseExited(evt);
         }
      });
      this.Principal.add(this.ImgAceptar1, new AbsoluteConstraints(85, 435, 96, 32));
      this.ImgReporte.setIcon(new ImageIcon(this.getClass().getResource("/Images/reporte.png")));
      this.ImgReporte.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgReporteMouseEntered(evt);
         }
      });
      this.Principal.add(this.ImgReporte, new AbsoluteConstraints(195, 435, 96, 32));
      this.ImgReporte1.setIcon(new ImageIcon(this.getClass().getResource("/Images/reporte on.png")));
      this.ImgReporte1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgReporte1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgReporte1MouseExited(evt);
         }
      });
      this.Principal.add(this.ImgReporte1, new AbsoluteConstraints(195, 435, 96, 32));
      this.ImagEnviar.setIcon(new ImageIcon(this.getClass().getResource("/Images/enviar.png")));
      this.ImagEnviar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImagEnviarMouseEntered(evt);
         }
      });
      this.Principal.add(this.ImagEnviar, new AbsoluteConstraints(305, 435, 96, 32));
      this.ImagEnviar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/enviar on.png")));
      this.ImagEnviar1.setText("ImagEnviar1");
      this.ImagEnviar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImagEnviar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImagEnviar1MouseExited(evt);
         }
      });
      this.Principal.add(this.ImagEnviar1, new AbsoluteConstraints(305, 435, 96, 32));
      this.ImgTerminar.setIcon(new ImageIcon(this.getClass().getResource("/Images/terminar.png")));
      this.ImgTerminar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgTerminarMouseEntered(evt);
         }
      });
      this.Principal.add(this.ImgTerminar, new AbsoluteConstraints(415, 435, 96, 32));
      this.ImgTerminar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/terminar on.png")));
      this.ImgTerminar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgTerminar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.ImgTerminar1MouseExited(evt);
         }
      });
      this.Principal.add(this.ImgTerminar1, new AbsoluteConstraints(415, 435, 96, 32));
      this.User.setFont(new Font("Tahoma", 0, 12));
      this.User.setForeground(new Color(0, 0, 102));
      this.User.setText("Fecha de Inicio:");
      this.Principal.add(this.User, new AbsoluteConstraints(30, 45, -1, -1));
      this.User1.setFont(new Font("Tahoma", 0, 12));
      this.User1.setForeground(new Color(0, 0, 102));
      this.User1.setText("Fecha Final:");
      this.Principal.add(this.User1, new AbsoluteConstraints(53, 75, -1, -1));
      this.User2.setFont(new Font("Tahoma", 0, 12));
      this.User2.setForeground(new Color(0, 0, 102));
      this.User2.setText("Hora de Inicio:");
      this.Principal.add(this.User2, new AbsoluteConstraints(215, 45, -1, -1));
      this.User3.setFont(new Font("Tahoma", 0, 12));
      this.User3.setForeground(new Color(0, 0, 102));
      this.User3.setText("Hora Final:");
      this.Principal.add(this.User3, new AbsoluteConstraints(237, 75, -1, -1));
      this.User4.setFont(new Font("Tahoma", 0, 12));
      this.User4.setForeground(new Color(0, 0, 102));
      this.User4.setText("Número de HR:");
      this.Principal.add(this.User4, new AbsoluteConstraints(390, 40, -1, -1));
      this.User5.setFont(new Font("Tahoma", 0, 12));
      this.User5.setForeground(new Color(0, 0, 102));
      this.User5.setText("Kms Recorridos:");
      this.Principal.add(this.User5, new AbsoluteConstraints(390, 60, -1, -1));
      this.User6.setFont(new Font("Tahoma", 0, 12));
      this.User6.setForeground(new Color(0, 0, 102));
      this.User6.setText("Nombre del Conductor Principal:");
      this.Principal.add(this.User6, new AbsoluteConstraints(53, 185, -1, -1));
      this.User7.setFont(new Font("Tahoma", 0, 12));
      this.User7.setForeground(new Color(0, 0, 102));
      this.User7.setText("Nombre del Conductor Auxiliar:");
      this.Principal.add(this.User7, new AbsoluteConstraints(58, 215, -1, -1));
      this.Elim2.setIcon(new ImageIcon(this.getClass().getResource("/Images/elim chofer.png")));
      this.Elim2.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.Elim2MouseEntered(evt);
         }
      });
      this.Principal.add(this.Elim2, new AbsoluteConstraints(500, 180, 20, 20));
      this.Elim3.setIcon(new ImageIcon(this.getClass().getResource("/Images/elim chofer on.png")));
      this.Elim3.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.Elim3MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            Datos_Hoja_de_Ruta.this.Elim3MouseExited(evt);
         }
      });
      this.Principal.add(this.Elim3, new AbsoluteConstraints(500, 180, 20, 20));
      this.motoHoras.setFont(new Font("Tahoma", 0, 12));
      this.motoHoras.setForeground(new Color(0, 0, 102));
      this.motoHoras.setText("Moto Horas:");
      this.Principal.add(this.motoHoras, new AbsoluteConstraints(390, 80, 80, -1));
      this.MotoHoras.setBorder(BorderFactory.createBevelBorder(1));

      try {
         this.MotoHoras.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##")));
      } catch (ParseException var2) {
         var2.printStackTrace();
      }

      this.MotoHoras.setText("0000");
      this.MotoHoras.setToolTipText("Moto Horas de la HR");
      this.MotoHoras.setMinimumSize(new Dimension(4, 18));
      this.MotoHoras.addFocusListener(new FocusAdapter() {
         public void focusLost(FocusEvent evt) {
            Datos_Hoja_de_Ruta.this.MotoHorasFocusLost(evt);
         }
      });
      this.Principal.add(this.MotoHoras, new AbsoluteConstraints(480, 82, 80, -1));
      this.jLabel9.setIcon(new ImageIcon(this.getClass().getResource("/Images/fondo hoja ruta1.png")));
      this.Principal.add(this.jLabel9, new AbsoluteConstraints(0, 0, 600, 499));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.Principal, -2, -1, -2));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.Principal, -2, -1, -2));
      this.pack();
   }

   private void TablaMouseClicked(MouseEvent evt) {
      if (!this.Tabla.getColumnSelectionAllowed() && this.Tabla.getRowSelectionAllowed()) {
         int Numero_fila = this.Tabla.getSelectedRow();
         this.NoHR.setText(this.Tabla.getValueAt(Numero_fila, 0).toString());
         String fi = this.Tabla.getValueAt(Numero_fila, 1).toString();
         int dia_inicial = Integer.parseInt(fi.substring(0, 2));
         int mes_inicial = Integer.parseInt(fi.substring(3, 5)) - 1;
         int anno_inicial = Integer.parseInt(fi.substring(6, 8)) + 100;
         Date date_inicial = new Date(anno_inicial, mes_inicial, dia_inicial);
         this.FI.setDate(date_inicial);
         this.HI.setText(this.Tabla.getValueAt(Numero_fila, 2).toString());
         String ff = this.Tabla.getValueAt(Numero_fila, 3).toString();
         int dia_final = Integer.parseInt(ff.substring(0, 2));
         int mes_final = Integer.parseInt(ff.substring(3, 5)) - 1;
         int anno_final = Integer.parseInt(ff.substring(6, 8)) + 100;
         Date date_final = new Date(anno_final, mes_final, dia_final);
         this.FF.setDate(date_final);
         this.HF.setText(this.Tabla.getValueAt(Numero_fila, 4).toString());
         this.KmRec.setText(this.Tabla.getValueAt(Numero_fila, 5).toString());
         if (this.MotoHoras.isEnabled()) {
            this.MotoHoras.setText(this.Tabla.getValueAt(Numero_fila, 6).toString());
         }
      }

   }

   private void traficoActionPerformed(ActionEvent evt) {
      if (this.trafico.isSelected() && !this.CD_activo) {
         try {
            this.cd = new CargaDescarga(this, this.en);
            this.cd.Mostrar();
         } catch (Exception var3) {
         }
      }

   }

   private void jButton2MouseClicked(MouseEvent evt) {
      if (!this.Envio) {
         this.en.ShowMessage("Debe Oprimir el Botón Enviar Primero.", "Información", "Information");
      } else {
         try {
            VisorDiferido visor = new VisorDiferido(this);
            visor.setVisible(true);
         } catch (Exception var3) {
            this.en.ShowMessage("No se Pudo Mostra el Visor de Mapas.", "Información", "Information");
         }
      }

   }

   private void ImgChoferMouseEntered(MouseEvent evt) {
      this.ImgChofer1.setVisible(true);
      this.ImgChofer.setVisible(false);
   }

   private void ImgChofer1MouseExited(MouseEvent evt) {
      this.ImgChofer.setVisible(true);
      this.ImgChofer1.setVisible(false);
   }

   private void ImgChofer1MouseClicked(MouseEvent evt) {
      try {
         ListadoChoferes list = new ListadoChoferes(this);
         if (!this.Listado_Choferes_Activo) {
            this.Selec = true;
            if (!this.en.abierto) {
               if (this.en.Tiene_Conexion && this.en.cambio_de_fecha) {
                  list.HacerPost();
               } else {
                  list.LlenarTabla();
               }
            } else {
               list.LlenarTabla();
            }
         }
      } catch (Exception var5) {
         try {
            ListadoChoferes list = new ListadoChoferes(this);
            list.HacerPost();
         } catch (Exception var4) {
            this.en.ShowMessage("Es Posible que no Exista Conexión. Verifíquelo, Por Favor.", "Mensaje de Alerta", "Error");
         }
      }

   }

   private void ImgChMouseEntered(MouseEvent evt) {
      this.ImgCh.setVisible(false);
      this.ImgCh1.setVisible(true);
   }

   private void ImgCh1MouseExited(MouseEvent evt) {
      this.ImgCh1.setVisible(false);
      this.ImgCh.setVisible(true);
   }

   private void ImgCh1MouseClicked(MouseEvent evt) {
      if (this.Conductor.getText().equalsIgnoreCase("")) {
         this.en.ShowMessage("Seleccione Primero el Nombre del Chofer Principal.", "Información", "Information");
      } else {
         try {
            if (!this.Listado_Choferes_Activo) {
               this.Selec1 = true;
               ListadoChoferes list = new ListadoChoferes(this);
               if (!this.en.abierto) {
                  if (this.en.Tiene_Conexion && this.en.cambio_de_fecha) {
                     list.HacerPost();
                  } else {
                     list.LlenarTabla();
                  }
               } else {
                  list.LlenarTabla();
               }
            }
         } catch (Exception var3) {
            this.en.ShowMessage("Es Posible Que no Exista Conexión. Verifíquelo, Por Favor.", "Mensaje de Alerta", "Error");
         }
      }

   }

   private void ImgAdicMouseEntered(MouseEvent evt) {
      this.ImgAdic.setVisible(false);
      this.ImgAdic1.setVisible(true);
      this.bandera = true;
   }

   private void ImgAdic1MouseExited(MouseEvent evt) {
      this.ImgAdic1.setVisible(false);
      this.ImgAdic.setVisible(true);
   }

   private void ImgAdic1MouseClicked(MouseEvent evt) {
      String fi = this.en.Fecha_Inicial;
      String ff = this.en.Fecha_Final;
      String hi = this.en.Hora_Inicial;
      String hf = this.en.Hora_Final;
      int ban1 = false;
      if (this.bandera) {
         if (this.NoHR.getText().equalsIgnoreCase("")) {
            ban1 = true;
            this.en.ShowMessage("Debe Completar el Campo del Número de la Hoja de Ruta.", "Información", "Information");
         } else if (this.KmRec.getText().equalsIgnoreCase("")) {
            ban1 = true;
            this.en.ShowMessage("Debe Completar el Campo de los Kilómetros Recorridos.", "Información", "Information");
         } else if (this.Conductor.getText().equalsIgnoreCase("")) {
            ban1 = true;
            this.en.ShowMessage("Debe Seleccionar el Nombre del Chofer.", "Información", "Information");
         } else if (this.en.ComparaFecha(this.formato.format(this.FF.getDate()), this.formato.format(this.FI.getDate()), this.HF.getText(), this.HI.getText(), 1)) {
            ban1 = true;
            this.en.ShowMessage("La Fecha Inicial que Usted está Insertando no Puede ser Mayor <br/>que la Fecha Final. Por Favor, Verifíquela.", "Error", "Error");
         } else if (this.en.ComparaFecha(this.formato.format(this.FI.getDate()), fi, this.HI.getText(), hi, 1)) {
            ban1 = true;
            this.en.ShowMessage("La Fecha Inicial que Usted está Insertando no Puede ser Menor <br/>que la Fecha Inicial de la Trayectoria. Por Favor, Verifíquela.", "Error", "Error");
         } else if (this.en.ComparaFecha(ff, this.formato.format(this.FF.getDate()), hf, this.HF.getText(), 1)) {
            ban1 = true;
            this.en.ShowMessage("La Fecha Final que Usted está insertando no Puede ser Mayor <br/>que la Fecha Final de la Trayectoria. Por Favor, Verifíquela.", "Error", "Error");
         } else if (this.TiempoMotoHoras(this.MotoHoras.getText()) > this.TiempoHR(this.formato.format(this.FI.getDate()), this.HI.getText(), this.formato.format(this.FF.getDate()), this.HF.getText())) {
            ban1 = true;
            this.en.ShowMessage("Las Moto Horas que Usted está insertando no Puede ser Mayor <br/>que el Intervalo de la Hoja de Ruta. Por Favor, Verifíquela.", "Error", "Error");
         } else {
            DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();
            int cant_elem = model.getRowCount();
            if (cant_elem == 0) {
               if (this.MotoHoras.isEnabled()) {
                  model.insertRow(model.getRowCount(), new Object[]{this.NoHR.getText(), this.formato.format(this.FI.getDate()), this.HI.getText(), this.formato.format(this.FF.getDate()), this.HF.getText(), this.KmRec.getText(), this.MotoHoras.getText()});
                  this.MotoHoras.setText("00:00");
               } else {
                  model.insertRow(model.getRowCount(), new Object[]{this.NoHR.getText(), this.formato.format(this.FI.getDate()), this.HI.getText(), this.formato.format(this.FF.getDate()), this.HF.getText(), this.KmRec.getText()});
               }

               this.bandera = false;
               this.NoHR.setText("");
               this.KmRec.setText("");
            } else {
               int NoHojaRuta = Integer.parseInt(this.NoHR.getText());
               String fechai = this.formato.format(this.FI.getDate());
               String fechaf = this.formato.format(this.FF.getDate());
               String horai = this.HI.getText();
               String horaf = this.HF.getText();

               for(int i = 0; i < cant_elem; ++i) {
                  String fi_tabla = this.Tabla.getValueAt(i, 1).toString();
                  String hi_tabla = this.Tabla.getValueAt(i, 2).toString();
                  String ff_tabla = this.Tabla.getValueAt(i, 3).toString();
                  String hf_tabla = this.Tabla.getValueAt(i, 4).toString();
                  String No = this.Tabla.getValueAt(i, 0).toString();
                  int NoHr_tabla = Integer.parseInt(No);
                  if (NoHr_tabla == NoHojaRuta) {
                     this.en.ShowMessage("El Número de Hoja de Ruta ya Existe en la Tabla.", "Información", "Information");
                     ban1 = true;
                     break;
                  }

                  if (this.en.ComparaFecha(fechai, fi_tabla, horai, hi_tabla, 1) && this.en.ComparaFecha(ff_tabla, fechaf, hf_tabla, horaf, 1)) {
                     this.en.ShowMessage("Esta Hoja de Ruta Contiene a la Hoja de Ruta Número " + NoHr_tabla + ".", "Información", "Information");
                     ban1 = true;
                     break;
                  }

                  if (this.en.ComparaFecha(fi_tabla, fechai, hi_tabla, horai, 1) && this.en.ComparaFecha(fechaf, ff_tabla, horaf, hf_tabla, 1)) {
                     this.en.ShowMessage("Esta Hoja de Ruta está Contenida Dentro de la Hoja de Ruta Número " + NoHr_tabla + ".", "Información", "Information");
                     ban1 = true;
                     break;
                  }

                  if (this.en.ComparaFecha(fi_tabla, fechai, hi_tabla, horai, 1) && this.en.ComparaFecha(fechai, ff_tabla, horai, hf_tabla, 1)) {
                     this.en.ShowMessage("La Fecha Inicial de esta Hoja de Ruta está Contenida Dentro<br/>de la Hoja de Ruta Número " + NoHr_tabla + ".", "Información", "Information");
                     ban1 = true;
                     break;
                  }

                  if (this.en.ComparaFecha(fi_tabla, fechaf, hi_tabla, horaf, 1) && this.en.ComparaFecha(fechaf, ff_tabla, horaf, hf_tabla, 1)) {
                     this.en.ShowMessage("La Fecha Final de esta Hoja de Ruta está Contenida Dentro <br/>de la Hoja de Ruta Número " + NoHr_tabla + ".", "Información", "Information");
                     ban1 = true;
                     break;
                  }
               }

               if (!ban1) {
                  String Numero = String.valueOf(NoHojaRuta);
                  if (!this.MotoHoras.isEnabled()) {
                     model.insertRow(model.getRowCount(), new Object[]{this.NoHR.getText(), this.formato.format(this.FI.getDate()), this.HI.getText(), this.formato.format(this.FF.getDate()), this.HF.getText(), this.KmRec.getText()});
                  } else {
                     model.insertRow(model.getRowCount(), new Object[]{this.NoHR.getText(), this.formato.format(this.FI.getDate()), this.HI.getText(), this.formato.format(this.FF.getDate()), this.HF.getText(), this.KmRec.getText(), this.MotoHoras.getText()});
                     this.MotoHoras.setText("00:00");
                  }

                  this.bandera = false;
                  this.NoHR.setText("");
                  this.KmRec.setText("");
               }
            }
         }
      }

   }

   private void ImgActMouseEntered(MouseEvent evt) {
      this.ImgAct.setVisible(false);
      this.ImgAct1.setVisible(true);
      this.bandera = true;
   }

   private void ImgAct1MouseExited(MouseEvent evt) {
      this.ImgAct.setVisible(true);
      this.ImgAct1.setVisible(false);
   }

   private void ImgAct1MouseClicked(MouseEvent evt) {
      String fi = this.en.Fecha_Inicial;
      String ff = this.en.Fecha_Final;
      String hi = this.en.Hora_Inicial;
      String hf = this.en.Hora_Final;
      if (this.bandera) {
         if (this.NoHR.getText().equalsIgnoreCase("")) {
            this.en.ShowMessage("Debe Completar el Campo del Número de la Hoja de Ruta.", "Información", "Information");
         } else if (this.KmRec.getText().equalsIgnoreCase("")) {
            this.en.ShowMessage("Debe Completar el Campo de los Kilómetros Recorridos.", "Información", "Information");
         } else if (this.Conductor.getText().equalsIgnoreCase("")) {
            this.en.ShowMessage("Debe Seleccionar el Nombre del Chofer.", "Información", "Information");
         } else if (this.en.ComparaFecha(this.formato.format(this.FF.getDate()), this.formato.format(this.FI.getDate()), this.HF.getText(), this.HI.getText(), 1)) {
            this.en.ShowMessage("La Fecha Inicial que Usted está Insertando no puede ser Mayor <br/>que la Fecha Final. Por Favor, Verifíquela.", "Error", "Error");
         } else if (this.en.ComparaFecha(this.formato.format(this.FI.getDate()), fi, this.HI.getText(), hi, 1)) {
            this.en.ShowMessage("La Fecha Inicial que Usted está Insertando no puede ser Menor <br/>que la Fecha Inicial de la Trayectoria. Por Favor, Verifíquela.", "Error", "Error");
         } else if (this.en.ComparaFecha(ff, this.formato.format(this.FF.getDate()), hf, this.HF.getText(), 1)) {
            this.en.ShowMessage("La Fecha Final que Usted está Insertando no puede ser Mayor <br/>que la Fecha Final de la Trayectoria. Por Favor, Verifíquela.", "Error", "Error");
         } else if (this.TiempoMotoHoras(this.MotoHoras.getText()) > this.TiempoHR(this.formato.format(this.FI.getDate()), this.HI.getText(), this.formato.format(this.FF.getDate()), this.HF.getText())) {
            this.en.ShowMessage("Las Moto Horas que Usted está insertando no Puede ser Mayor <br/>que el Intervalo de la Hoja de Ruta. Por Favor, Verifíquela.", "Error", "Error");
         } else {
            int Numero_fila = this.Tabla.getSelectedRow();
            int cantFilas = this.Tabla.getRowCount();
            if (cantFilas == 0) {
               this.en.ShowMessage("No hay Elementos Insertados en la Tabla.", "Error", "Error");
            } else if (Numero_fila == -1) {
               this.en.ShowMessage("Debe Seleccionar una Fila de la Tabla.", "Error", "Error");
            } else if (!this.Tabla.getColumnSelectionAllowed() && this.Tabla.getRowSelectionAllowed()) {
               int ban = false;
               int NoHojaRuta = Integer.parseInt(this.NoHR.getText());
               String fechai = this.formato.format(this.FI.getDate());
               String fechaf = this.formato.format(this.FF.getDate());
               String horai = this.HI.getText();
               String horaf = this.HF.getText();

               for(int i = 0; i < cantFilas; ++i) {
                  if (i != Numero_fila) {
                     String fi_tabla = (String)this.Tabla.getValueAt(i, 1);
                     String hi_tabla = (String)this.Tabla.getValueAt(i, 2);
                     String ff_tabla = (String)this.Tabla.getValueAt(i, 3);
                     String hf_tabla = (String)this.Tabla.getValueAt(i, 4);
                     int NoHr_tabla = Integer.parseInt((String)this.Tabla.getValueAt(i, 0));
                     if (this.en.ComparaFecha(fechai, fi_tabla, horai, hi_tabla, 1) && this.en.ComparaFecha(fi_tabla, fechaf, hi_tabla, horaf, 1) || this.en.ComparaFecha(fechai, ff_tabla, horai, hf_tabla, 1) && this.en.ComparaFecha(ff_tabla, fechaf, hf_tabla, horaf, 1)) {
                        this.en.ShowMessage("Hay Coincidencia en los Intervalos de Fechas en la Hoja de Ruta Número " + NoHr_tabla + ".", "Información", "Information");
                        ban = true;
                        break;
                     }

                     if (NoHr_tabla == NoHojaRuta) {
                        this.en.ShowMessage("El Número de Hoja de Ruta ya Existe en la Tabla.", "Información", "Information");
                        ban = true;
                        break;
                     }

                     if (this.en.ComparaFecha(fechai, fi_tabla, horai, hi_tabla, 1) && this.en.ComparaFecha(ff_tabla, fechaf, hf_tabla, horaf, 1)) {
                        this.en.ShowMessage("Esta Hoja de Ruta Contiene la Hoja de Ruta Número " + NoHr_tabla + ".", "Información", "Information");
                        ban = true;
                        break;
                     }
                  }
               }

               if (!ban) {
                  this.Tabla.setValueAt(this.NoHR.getText(), Numero_fila, 0);
                  this.Tabla.setValueAt(fechai, Numero_fila, 1);
                  this.Tabla.setValueAt(horai, Numero_fila, 2);
                  this.Tabla.setValueAt(fechaf, Numero_fila, 3);
                  this.Tabla.setValueAt(horaf, Numero_fila, 4);
                  this.Tabla.setValueAt(this.KmRec.getText(), Numero_fila, 5);
                  if (this.MotoHoras.isEnabled()) {
                     this.Tabla.setValueAt(this.MotoHoras.getText(), Numero_fila, 6);
                     this.MotoHoras.setText("00:00");
                  }

                  this.bandera = false;
               }
            }
         }
      }

   }

   private void ImgElimMouseEntered(MouseEvent evt) {
      this.ImgElim1.setVisible(true);
      this.ImgElim.setVisible(false);
      this.bandera = true;
   }

   private void ImgElim1MouseExited(MouseEvent evt) {
      this.ImgElim.setVisible(true);
      this.ImgElim1.setVisible(false);
   }

   private void ImgElim1MouseClicked(MouseEvent evt) {
      if (this.bandera) {
         int Numero_fila = this.Tabla.getSelectedRow();
         int cantFilas = this.Tabla.getRowCount();
         if (cantFilas == 0) {
            this.en.ShowMessage("No hay Elementos Insertados en la Tabla.", "Error", "Error");
         } else if (Numero_fila == -1) {
            this.en.ShowMessage("Debe Seleccionar una Fila de la Tabla.", "Error", "Error");
         } else if (!this.Tabla.getColumnSelectionAllowed() && this.Tabla.getRowSelectionAllowed()) {
            DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();
            model.removeRow(this.Tabla.getRowSorter().convertRowIndexToView(Numero_fila));
            this.bandera = false;
         }
      }

   }

   private void ElimMouseEntered(MouseEvent evt) {
      this.Elim1.setVisible(true);
      this.Elim.setVisible(false);
   }

   private void Elim1MouseExited(MouseEvent evt) {
      this.Elim.setVisible(true);
      this.Elim1.setVisible(false);
   }

   private void Elim1MouseClicked(MouseEvent evt) {
      this.Conductor1.setText("");
   }

   private void ImgAceptarMouseEntered(MouseEvent evt) {
      this.ImgAceptar.setVisible(false);
      this.ImgAceptar1.setVisible(true);
      this.bandera = true;
   }

   private void ImgAceptar1MouseExited(MouseEvent evt) {
      this.ImgAceptar1.setVisible(false);
      this.ImgAceptar.setVisible(true);
   }

   private void ImgAceptar1MouseClicked(MouseEvent evt) {
      HiloAceptarHR hhr = new HiloAceptarHR(this);
      if (this.bandera) {
         hhr.start();
      }

   }

   private void ImgReporteMouseEntered(MouseEvent evt) {
      this.ImgReporte.setVisible(false);
      this.ImgReporte1.setVisible(true);
   }

   private void ImgReporte1MouseExited(MouseEvent evt) {
      this.ImgReporte1.setVisible(false);
      this.ImgReporte.setVisible(true);
   }

   private void ImgReporte1MouseClicked(MouseEvent evt) {
      if (!this.Acepto) {
         this.en.ShowMessage("Debe Oprimir el Botón Aceptar.", "Información", "Information");
      } else {
         if (!this.camino_reporte.equalsIgnoreCase(" ")) {
            this.reporte.delete();
         }

         this.camino_reporte = this.en.Camino_Reporte + "\\" + this.en.logid + ".htm";
         this.reporte = new File(this.camino_reporte);
         if (this.reporte.exists()) {
            int i = 1;

            while(true) {
               this.camino_reporte = this.en.Camino_Reporte + "\\" + this.en.logid + "_" + i + ".htm";
               this.reporte = new File(this.camino_reporte);
               if (!this.reporte.exists()) {
                  break;
               }

               ++i;
            }
         }

         Reporte rep = new Reporte(this, this.en, this.cd, this.abast);

         try {
            rep.LlenarReporte();
            this.VioReporte = true;
         } catch (IOException var4) {
            this.en.ShowMessage("No se Pudo Crear el Reporte.", "Error", "Error");
         }
      }

   }

   private void ImagEnviarMouseEntered(MouseEvent evt) {
      this.ImagEnviar.setVisible(false);
      this.ImagEnviar1.setVisible(true);
      this.bandera = true;
   }

   private void ImagEnviar1MouseExited(MouseEvent evt) {
      this.ImagEnviar1.setVisible(false);
      this.ImagEnviar.setVisible(true);
   }

   private void ImagEnviar1MouseClicked(MouseEvent evt) {
      if (this.bandera) {
         HiloEnviar he = new HiloEnviar(this);
         he.start();
      }

   }

   private void ImgTerminar1MouseClicked(MouseEvent evt) {
      int cantFilas = this.Tabla.getRowCount();
      String Msg;
      int n;
      String user;
      String pass;
      if (cantFilas == 0) {
         Msg = "¿Desea Volver a Iniciar La Aplicación?";
         n = this.en.ShowMessageConfirmDialog(Msg, "Mensaje de Confirmación", "Confirmación");
         if (n == 0) {
            this.Borrar_Temporales();
            user = this.en.user;
            pass = this.en.pass;
            this.close();
            this.en = new Entrada();
            this.en.Usuario.setText(user);
            this.en.Password.setText(pass);
         } else {
            this.Borrar_Temporales();
            System.exit(0);
         }
      } else {
         try {
            if (!this.Acepto) {
               this.en.ShowMessage("Debe Oprimir el Botón Aceptar.", "Información", "Information");
            } else if (!this.VioReporte) {
               this.en.ShowMessage("Debe Ver el Reporte Rápido.", "Información", "Information");
            } else if (!this.en.Tiene_Conexion) {
               this.Guardar_Trayectoria();
               this.en.LimpiarCampos();
               this.ListaHr.clear();
               Msg = "¿Desea Volver a Iniciar La Aplicación?";
               n = this.en.ShowMessageConfirmDialog(Msg, "Mensaje de Confirmación", "Confirmación");
               if (n == 0) {
                  this.Borrar_Temporales();
                  user = this.en.user;
                  pass = this.en.pass;
                  this.close();
                  this.en = new Entrada();
                  this.en.Usuario.setText(user);
                  this.en.Password.setText(pass);
               } else {
                  this.Borrar_Temporales();
                  System.exit(0);
               }
            } else if (!this.Envio && this.en.Tiene_Conexion) {
               Msg = "La Trayectoria no se ha Enviado.¿Desea Enviarla más Tarde?";
               n = this.en.ShowMessageConfirmDialog(Msg, "Mensaje de Confirmación", "Confirmación");
               if (n == 0) {
                  this.Guardar_Trayectoria();
                  this.en.LimpiarCampos();
                  this.ListaHr.clear();
               }

               user = "¿Desea Volver a Iniciar La Aplicación?";
               int n1 = this.en.ShowMessageConfirmDialog(user, "Mensaje de Confirmación", "Confirmación");
               if (n1 == 0) {
                  this.Borrar_Temporales();
                  String user = this.en.user;
                  String pass = this.en.pass;
                  this.close();
                  this.en = new Entrada();
                  this.en.Usuario.setText(user);
                  this.en.Password.setText(pass);
               } else {
                  this.Borrar_Temporales();
                  System.exit(0);
               }
            } else {
               if (this.en.Trayectoria_Enviada) {
                  this.en.Copiar_fichero_para_Transferida(this.shp_compacto);
                  if (this.en.hay_ficheros_sin_transferir) {
                     File sav = new File(this.en.Origen_File_to_Transfer);
                     if (sav.exists()) {
                        sav.delete();
                     } else {
                        String msg = "No es Posible Encontrar el Fichero " + sav.getName();
                        this.en.ShowMessage(msg, "Error", "Error");
                     }
                  }
               }

               Msg = "¿Desea Volver a Iniciar La Aplicación?";
               n = this.en.ShowMessageConfirmDialog(Msg, "Mensaje de Confirmación", "Confirmación");
               if (n == 0) {
                  this.Borrar_Temporales();
                  user = this.en.user;
                  pass = this.en.pass;
                  this.close();
                  this.en = new Entrada();
                  this.en.Usuario.setText(user);
                  this.en.Password.setText(pass);
               } else {
                  this.Borrar_Temporales();
                  System.exit(0);
               }
            }
         } catch (Exception var9) {
            var9.printStackTrace();
         }
      }

   }

   private void ImgTerminarMouseEntered(MouseEvent evt) {
      this.ImgTerminar.setVisible(false);
      this.ImgTerminar1.setVisible(true);
   }

   private void ImgTerminar1MouseExited(MouseEvent evt) {
      this.ImgTerminar1.setVisible(false);
      this.ImgTerminar.setVisible(true);
   }

   private void Elim2MouseEntered(MouseEvent evt) {
      this.Elim3.setVisible(true);
      this.Elim2.setVisible(false);
   }

   private void Elim3MouseExited(MouseEvent evt) {
      this.Elim2.setVisible(true);
      this.Elim3.setVisible(false);
   }

   private void Elim3MouseClicked(MouseEvent evt) {
      this.Conductor.setText("");
   }

   private void jButton2ActionPerformed(ActionEvent evt) {
   }

   private void abastecimientActionPerformed(ActionEvent evt) {
      if (this.abastecimient.isSelected() && !this.abastec_activo) {
         try {
            this.abast = new Abastecimiento(this, this.en);
            this.abast.Mostrar();
         } catch (Exception var3) {
         }
      }

   }

   private void KmRecKeyTyped(KeyEvent evt) {
      char c = evt.getKeyChar();
      if ((c < '0' || c > '9') && c != '\b' && c != '.') {
         evt.consume();
      }

      if (c == '.' && (this.KmRec.getText().contains(".") || this.KmRec.getText().isEmpty())) {
         evt.consume();
      }

      if (this.KmRec.getText().contains(".") && this.KmRec.getText().length() - 2 > this.KmRec.getText().indexOf(".")) {
         evt.consume();
      }

   }

   private void NoHRKeyTyped(KeyEvent evt) {
      char c = evt.getKeyChar();
      if ((c < '0' || c > '9') && c != '\b') {
         evt.consume();
      }

   }

   private void formWindowClosing(WindowEvent evt) {
      int cantFilas = this.Tabla.getRowCount();
      String Msg;
      int n;
      String user;
      String pass;
      if (cantFilas == 0) {
         Msg = "¿Desea Volver a Iniciar La Aplicación?";
         n = this.en.ShowMessageConfirmDialog(Msg, "Mensaje de Confirmación", "Confirmación");
         if (n == 0) {
            this.Borrar_Temporales();
            user = this.en.user;
            pass = this.en.pass;
            this.close();
            this.en = new Entrada();
            this.en.Usuario.setText(user);
            this.en.Password.setText(pass);
         } else {
            this.Borrar_Temporales();
            System.exit(0);
         }
      } else {
         try {
            if (!this.Acepto) {
               this.en.ShowMessage("Debe Oprimir el Botón Aceptar.", "Información", "Information");
            } else if (!this.VioReporte) {
               this.en.ShowMessage("Debe Ver el Reporte Rápido.", "Información", "Information");
            } else if (!this.en.Tiene_Conexion) {
               this.Guardar_Trayectoria();
               this.en.LimpiarCampos();
               this.ListaHr.clear();
               Msg = "¿Desea Volver a Iniciar La Aplicación?";
               n = this.en.ShowMessageConfirmDialog(Msg, "Mensaje de Confirmación", "Confirmación");
               if (n == 0) {
                  this.Borrar_Temporales();
                  user = this.en.user;
                  pass = this.en.pass;
                  this.close();
                  this.en = new Entrada();
                  this.en.Usuario.setText(user);
                  this.en.Password.setText(pass);
               } else {
                  this.Borrar_Temporales();
                  System.exit(0);
               }
            } else if (!this.Envio && this.en.Tiene_Conexion) {
               Msg = "La Trayectoria no se ha Enviado.¿Desea Enviarla  más Tarde?";
               n = this.en.ShowMessageConfirmDialog(Msg, "Mensaje de Confirmación", "Confirmación");
               if (n == 0) {
                  this.Guardar_Trayectoria();
                  this.en.LimpiarCampos();
                  this.ListaHr.clear();
               }

               user = "¿Desea Volver a Iniciar La Aplicación?";
               int n1 = this.en.ShowMessageConfirmDialog(user, "Mensaje de Confirmación", "Confirmación");
               if (n1 == 0) {
                  this.Borrar_Temporales();
                  String user = this.en.user;
                  String pass = this.en.pass;
                  this.close();
                  this.en = new Entrada();
                  this.en.Usuario.setText(user);
                  this.en.Password.setText(pass);
               } else {
                  this.Borrar_Temporales();
                  System.exit(0);
               }
            } else {
               if (this.en.Trayectoria_Enviada) {
                  this.en.Copiar_fichero_para_Transferida(this.shp_compacto);
                  if (this.en.hay_ficheros_sin_transferir) {
                     File sav = new File(this.en.Origen_File_to_Transfer);
                     if (sav.exists()) {
                        sav.delete();
                     } else {
                        String msg = "No es Posible Encontrar el Fichero " + sav.getName();
                        this.en.ShowMessage(msg, "Error", "Error");
                     }
                  }
               }

               Msg = "¿Desea Volver a Iniciar La Aplicación?";
               n = this.en.ShowMessageConfirmDialog(Msg, "Mensaje de Confirmación", "Confirmación");
               if (n == 0) {
                  this.Borrar_Temporales();
                  user = this.en.user;
                  pass = this.en.pass;
                  this.close();
                  this.en = new Entrada();
                  this.en.Usuario.setText(user);
                  this.en.Password.setText(pass);
               } else {
                  this.Borrar_Temporales();
                  System.exit(0);
               }
            }
         } catch (Exception var9) {
            var9.printStackTrace();
         }
      }

   }

   private void FIIActionPerformed(ActionEvent evt) {
   }

   private void HIFocusLost(FocusEvent evt) {
      String pega = this.HI.getText();
      pega = pega.trim();
      if (pega.equals(":")) {
         JOptionPane.showMessageDialog((Component)null, "Digite la hora", "Operador", 0);
         this.HI.setValue("");
      } else {
         int conta_pega = pega.length();
         if (conta_pega < 5) {
            JOptionPane.showMessageDialog((Component)null, "Digite la hora", "Operador", 0);
            this.HI.setValue("");
         } else {
            String hora = pega.substring(0, 2);
            String minuto = pega.substring(3, 5);
            int conta_hora = Integer.parseInt(hora);
            int conta_minuto = Integer.parseInt(minuto);
            if (conta_hora > 23) {
               JOptionPane.showMessageDialog((Component)null, "Hora digitada inválida", "Operador", 0);
               this.HI.setValue("");
            } else {
               if (conta_minuto > 59) {
                  JOptionPane.showMessageDialog((Component)null, "Hora digitada inválida", "Operador", 0);
                  this.HI.setValue("");
               }

            }
         }
      }
   }

   private void HFFocusLost(FocusEvent evt) {
      String pega = this.HF.getText();
      pega = pega.trim();
      if (pega.equals(":")) {
         JOptionPane.showMessageDialog((Component)null, "Digite la hora", "Operador", 0);
         this.HF.setValue("");
      } else {
         int conta_pega = pega.length();
         if (conta_pega < 5) {
            JOptionPane.showMessageDialog((Component)null, "Digite la hora", "Operador", 0);
            this.HF.setValue("");
         } else {
            String hora = pega.substring(0, 2);
            String minuto = pega.substring(3, 5);
            int conta_hora = Integer.parseInt(hora);
            int conta_minuto = Integer.parseInt(minuto);
            if (conta_hora > 23) {
               JOptionPane.showMessageDialog((Component)null, "Hora digitada inválida", "Operador", 0);
               this.HF.setValue("");
            } else {
               if (conta_minuto > 59) {
                  JOptionPane.showMessageDialog((Component)null, "Hora digitada inválida", "Operador", 0);
                  this.HF.setValue("");
               }

            }
         }
      }
   }

   private void MotoHorasFocusLost(FocusEvent evt) {
   }

   public void SetConductor(String conductor) {
      if (this.Selec) {
         this.Conductor.setText(conductor);
         this.chofer = conductor;
         this.Selec = false;
      } else {
         if (this.Selec1 && !conductor.equalsIgnoreCase(this.chofer)) {
            this.Conductor1.setText(conductor);
            this.chofer_auxiliar = conductor;
            this.Selec1 = false;
         } else if (this.Selec1 && conductor.equalsIgnoreCase(this.chofer)) {
            this.en.ShowMessage("Ese Nombre ya Existe en la Hoja de Ruta. Escoja otro Nombre, Por Favor.", "Información", "Information");
            this.Selec1 = false;
            this.Selec = false;
         }

      }
   }

   public boolean DiferidoMovil() throws MalformedURLException, IOException, FileNotFoundException, SAXException {
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Comprobando Datos del Móvil...");
      this.PB.setVisible(true);
      String movil = this.en.chapa;
      String Fecha1 = this.Obtener_Fecha(this.en.Fecha_Inicial, this.en.Hora_Inicial);
      String Fecha2 = this.Obtener_Fecha(this.en.Fecha_Final, this.en.Hora_Final);
      Fecha1 = Fecha1.replace("-", "_");
      Fecha1 = Fecha1.replace(" ", "^");
      Fecha2 = Fecha2.replace("-", "_");
      Fecha2 = Fecha2.replace(" ", "^");
      String port = null;
      URLConnection conn = null;
      String sitio = this.en.GetSitio();
      sitio = sitio + "/MovilWebServLet/DiferidoMovil?movil=" + movil + "&Fecha1=" + Fecha1 + "&Fecha2=" + Fecha2;
      URL url;
      String line;
      if (this.en.Hay_Proxy) {
         String ip = this.en.DireccionProxy;
         port = this.en.PuertoProxy;
         String usuasriop = this.en.UsuarioProxy;
         String passp = this.en.PassProxy;
         url = new URL("http", ip, Integer.parseInt(port), sitio);
         conn = url.openConnection();
         String user_pass = usuasriop + ":" + passp;
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
         this.en.ShowMessage("La Chapa del Vehículo no se Encuentra Registrada.", "Error", "Error");
         this.PBLabel.setVisible(false);
         this.PB.setVisible(false);
         return false;
      } else {
         String msg;
         if (respuesta.equalsIgnoreCase("-2")) {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            msg = "En la Base de Datos Existe una Trayectoria para este Vehículo cuyos<br/>Intervalos de Fecha Coinciden con los que está Intentando Transferir. <br/>Revise la Chapa a la que le está Asignando la Trayectoria.";
            this.en.ShowMessage(msg, "Error", "Error");
            return false;
         } else if (respuesta.equalsIgnoreCase("-3")) {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            msg = "En la Base de Datos existe una Trayectoria para este Vehículo cuyos<br/>Intervalos de Fecha Incluyen los que está Intentando Transferir. <br/>Revise la Chapa a la que le está Asignando la Trayectoria.";
            this.en.ShowMessage(msg, "Error", "Error");
            this.ListaHr.clear();
            return false;
         } else {
            return true;
         }
      }
   }

   public boolean DiferidoIDGPS() throws UnsupportedEncodingException, MalformedURLException, IOException, FileNotFoundException, SAXException {
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Comprobando Identificador de GPS...");
      this.PB.setVisible(true);
      String Movil = this.en.chapa;
      String sitio = this.en.GetSitio();
      String port = null;
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/DiferidoIDGPS?movil=" + Movil;
      URL url;
      String line;
      if (this.en.Hay_Proxy) {
         String ip = this.en.DireccionProxy;
         port = this.en.PuertoProxy;
         String usuasriop = this.en.UsuarioProxy;
         String passp = this.en.PassProxy;
         url = new URL("http", ip, Integer.parseInt(port), sitio);
         conn = url.openConnection();
         String user_pass = usuasriop + ":" + passp;
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
         this.PBLabel.setVisible(false);
         this.PB.setVisible(false);
         this.en.ShowMessage("La Chapa del Vehículo no se Encuentra Registrada.", "Error", "Error");
         return false;
      } else {
         String msg;
         if (respuesta.equalsIgnoreCase("-2")) {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            msg = "El Móvil no tiene Ningún Identificador de GPS Asociado.<br/>Póngase en Contacto con el Personal de GCOM para Solucionar<br/>el Problema.";
            this.en.ShowMessage(msg, "Error", "Error");
            return false;
         } else if (respuesta.equalsIgnoreCase("-3")) {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            msg = "No fue Posible Acceder a los Datos en la Base de Datos.<br/>Inténte Subir la Trayectoria más Tarde.";
            this.en.ShowMessage(msg, "Error", "Error");
            return false;
         } else if (respuesta.equalsIgnoreCase(this.en.idgps)) {
            return true;
         } else {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            msg = "El Móvil " + this.en.chapa + " tiene Asignado un Número de GPS que no se " + "<br/>" + "Corresponde con el Escrito por el Computador de a Bordo. Póngase" + "<br/>" + "en Contacto con el Puesto de Mando de GCOM.";
            this.en.ShowMessage(msg, "Error", "Error");
            return false;
         }
      }
   }

   public boolean DiferidoIndCons() throws UnsupportedEncodingException, MalformedURLException, IOException, FileNotFoundException, SAXException {
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Comprobando Indice de Consumo...");
      this.PB.setVisible(true);
      String Movil = this.en.chapa;
      String sitio = this.en.GetSitio();
      String port = null;
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/DiferidoIC?movil=" + Movil;
      URL url;
      String line;
      if (this.en.Hay_Proxy) {
         String ip = this.en.DireccionProxy;
         port = this.en.PuertoProxy;
         String usuasriop = this.en.UsuarioProxy;
         String passp = this.en.PassProxy;
         url = new URL("http", ip, Integer.parseInt(port), sitio);
         conn = url.openConnection();
         String user_pass = usuasriop + ":" + passp;
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
      if (respuesta.equalsIgnoreCase("-2")) {
         this.PBLabel.setVisible(false);
         this.PB.setVisible(false);
         this.en.ShowMessage("La Chapa del Vehículo no se Encuentra Registrada.", "Error", "Error");
         return false;
      } else {
         String msg;
         if (respuesta.equalsIgnoreCase("-1")) {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            msg = "No Fue Posible Acceder a los Datos en la Base de Datos.\nInténte Subir la Trayectoria más Tarde.";
            this.en.ShowMessage(msg, "Error", "Error");
            return false;
         } else if (Double.valueOf(respuesta) == this.en.Consumo) {
            return true;
         } else {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            msg = "El Móvil " + this.en.chapa + " Tiene Asignado un índice de Consumo que no se " + "<br/>" + "Corresponde con el Almacenado en la BD.";
            this.en.ShowMessage(msg, "Error", "Error");
            return false;
         }
      }
   }

   public boolean DiferidoDocumento() throws UnsupportedEncodingException, MalformedURLException, IOException, FileNotFoundException, SAXException {
      String documentos = new String();
      if (this.listado_prod.size() <= 0) {
         return true;
      } else {
         this.PBLabel.setVisible(true);
         this.PBLabel.setText("Comprobando Número Documentos...");
         this.PB.setVisible(true);
         String Movil = this.en.chapa;
         String sitio = this.en.GetSitio();
         String port = null;
         URLConnection conn = null;
         int cant = this.listado_prod.size();

         for(int i = 0; i < cant; ++i) {
            Productos p = (Productos)this.listado_prod.get(i);
            if (i < cant - 1) {
               documentos = documentos + p.numero.trim() + ",";
            } else {
               documentos = documentos + p.numero.trim();
            }
         }

         sitio = sitio + "/MovilWebServLet/VerificarDocumentos?movil=" + Movil + "&doc=" + documentos;
         URL url;
         String line;
         if (this.en.Hay_Proxy) {
            String ip = this.en.DireccionProxy;
            port = this.en.PuertoProxy;
            String usuasriop = this.en.UsuarioProxy;
            String passp = this.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(port), sitio);
            conn = url.openConnection();
            String user_pass = usuasriop + ":" + passp;
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
         if (respuesta.equalsIgnoreCase("-2")) {
            this.PBLabel.setVisible(false);
            this.PB.setVisible(false);
            this.en.ShowMessage("Error de Conexión.", "Error", "Error");
            return false;
         } else {
            String msg;
            if (respuesta.equalsIgnoreCase("-3")) {
               this.PBLabel.setVisible(false);
               this.PB.setVisible(false);
               msg = "Error Recuperando los Datos";
               this.en.ShowMessage(msg, "Error", "Error");
               return false;
            } else if (respuesta.equalsIgnoreCase("-1")) {
               return true;
            } else {
               msg = "Los Números de Documentos: " + respuesta.substring(0, respuesta.length() - 1) + " ya existen" + "<br/>" + "en la Base de Datos para este móvil";
               this.en.ShowMessage(msg, "Error", "Error");
               this.PBLabel.setVisible(false);
               this.PB.setVisible(false);
               return false;
            }
         }
      }
   }

   public String Obtener_Fecha(String Fecha, String Hora) {
      String[] f = Fecha.split("/");
      int year = Integer.valueOf(f[2]) + 2000;
      String retorno = year + "-" + f[1] + "-" + f[0] + " " + Hora;
      return retorno;
   }

   public void ConformarXML(File xmlconfig) {
      String XmlConfig = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><DATAPACKET Version=\"2.0\"><VersionDiferido>" + this.en.version + "</VersionDiferido>" + "<Chapa>" + this.en.chapa + "</Chapa>" + "<Indice>" + this.en.Consumo + "</Indice>" + "<IndiceTec>" + this.en.ConsumoTec + "</IndiceTec>" + "<No>" + this.en.NumeroVehiculo + "</No>" + "<Trafico>" + this.genera_trafico + "</Trafico>" + "<Abastecimiento>" + this.genera_abastec + "</Abastecimiento>" + "<IDConductor>" + this.en.IdConductor + "</IDConductor>" + "<IDConductorAux>" + this.en.IdConductorAux + "</IDConductorAux>" + "<IDCombustible>" + this.en.idcombustible + "</IDCombustible>" + "<IDCombustibleTec>" + this.en.idcombustible_Tec + "</IDCombustibleTec>" + "<Capacidad>" + this.en.capacTanque + "</Capacidad>" + "<CapacidadTec>" + this.en.capacTanqueTec + "</CapacidadTec>" + "<OriginalS>" + this.en.Size + "</OriginalS>" + "<NoViajes>" + this.viajes + "</NoViajes>" + "<Transferencia>" + this.en.Transferencia + "</Transferencia>" + "<NoTarjeta>" + this.tarjeta + "</NoTarjeta>" + "<ROWDATA>";
      this.InsertarLineaXmlConfig(XmlConfig, xmlconfig);
   }

   public void InsertarLineaXmlConfig(String linea, File fichero) {
      try {
         FileWriter fw = new FileWriter(fichero, true);
         fw.write(linea);
         fw.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   public void Guardar_Trayectoria1() throws IOException, FileNotFoundException, SAXException {
      String XmlCerrado = "</ROWDATA></DATAPACKET>";
      String fichero = this.en.por_transferir.getName();
      fichero = fichero.replace(".log", ".xml");
      String camino = "Datos de las Trayectorias\\Por Transferir\\Config" + fichero;
      File xmlconfig = new File(camino);
      if (xmlconfig.exists()) {
         xmlconfig.delete();
      }

      if (!xmlconfig.exists()) {
         this.ConformarXML(xmlconfig);
         int cantHR = this.Tabla.getRowCount();

         String lcd;
         for(int i = 0; i < cantHR; ++i) {
            String Numero = this.Tabla.getValueAt(i, 0).toString();
            lcd = this.Tabla.getValueAt(i, 1).toString();
            String HInicial = this.Tabla.getValueAt(i, 2).toString();
            String FFinal = this.Tabla.getValueAt(i, 3).toString();
            String HFinal = this.Tabla.getValueAt(i, 4).toString();
            String KmRecorridos = this.Tabla.getValueAt(i, 5).toString();
            String cond = this.Conductor.getText();
            String cond_auxiliar = this.Conductor1.getText();
            String lineaxml = "<ROW NoHR=\"" + Numero + "\"" + " " + "FI=" + "\"" + lcd + "\"" + " " + "HI=" + "\"" + HInicial + "\"" + " " + "FF=" + "\"" + FFinal + "\"" + " " + "HF=" + "\"" + HFinal + "\"" + " " + "KMHR=" + "\"" + KmRecorridos + "\"" + " " + "CONDUCTOR=" + "\"" + cond + "\"" + " " + "CONDUCTORAUX=" + "\"" + cond_auxiliar + "\"" + "/>";
            this.InsertarLineaXmlConfig(lineaxml, xmlconfig);
         }

         if (this.ListaCD.size() > 0) {
            String CD_Xml = "</ROWDATA><CDDATA>";
            this.InsertarLineaXmlConfig(CD_Xml, xmlconfig);
            Iterator it = this.ListaCD.iterator();

            while(it.hasNext()) {
               lcd = (String)it.next();
               this.InsertarLineaXmlConfig(lcd, xmlconfig);
            }

            lcd = "</CDDATA></DATAPACKET>";
            this.InsertarLineaXmlConfig(lcd, xmlconfig);
         } else {
            this.InsertarLineaXmlConfig(XmlCerrado, xmlconfig);
         }
      }

      this.en.ShowMessage("La Trayectoria ha sido Guardada en la Carpeta Por Transferir.", "Información", "Information");
   }

   public void Guardar_Trayectoria() throws IOException, FileNotFoundException, SAXException {
      String XmlCerrado = "</DATAPACKET>";
      String fichero = this.en.por_transferir.getName();
      fichero = fichero.replace(".log", ".xml");
      String camino;
      if (this.en.Transferencia.equalsIgnoreCase("1")) {
         camino = "Datos de las Trayectorias\\Por Transferir\\Tarjeta\\Config" + fichero;
      } else if (this.en.Transferencia.equalsIgnoreCase("2")) {
         camino = "Datos de las Trayectorias\\Por Transferir\\Bluetooth\\Config" + fichero;
      } else if (this.en.Transferencia.equalsIgnoreCase("3")) {
         camino = "Datos de las Trayectorias\\Por Transferir\\TReal\\Config" + fichero;
      } else if (this.en.Transferencia.equalsIgnoreCase("4")) {
         camino = "Datos de las Trayectorias\\Por Transferir\\TReal\\Config" + fichero;
      } else {
         camino = "Datos de las Trayectorias\\Por Transferir\\Cabv3\\Config" + fichero;
      }

      File xmlconfig = new File(camino);
      if (xmlconfig.exists()) {
         xmlconfig.delete();
      }

      if (!xmlconfig.exists()) {
         this.ConformarXML(xmlconfig);
         int cantHR = this.Tabla.getRowCount();

         String ABAST_Xml;
         String lcd;
         for(int i = 0; i < cantHR; ++i) {
            ABAST_Xml = this.Tabla.getValueAt(i, 0).toString();
            String FInicial = this.Tabla.getValueAt(i, 1).toString();
            lcd = this.Tabla.getValueAt(i, 2).toString();
            String FFinal = this.Tabla.getValueAt(i, 3).toString();
            String HFinal = this.Tabla.getValueAt(i, 4).toString();
            String KmRecorridos = this.Tabla.getValueAt(i, 5).toString();
            String cond = this.Conductor.getText();
            String cond_auxiliar = this.Conductor1.getText();
            String lineaxml;
            if (this.MotoHoras.isEnabled()) {
               String tiempoMH = this.Tabla.getValueAt(i, 6).toString();
               lineaxml = "<ROW NoHR=\"" + ABAST_Xml + "\"" + " " + "FI=" + "\"" + FInicial + "\"" + " " + "HI=" + "\"" + lcd + "\"" + " " + "FF=" + "\"" + FFinal + "\"" + " " + "HF=" + "\"" + HFinal + "\"" + " " + "KMHR=" + "\"" + KmRecorridos + "\"" + " " + "CONDUCTOR=" + "\"" + cond + "\"" + " " + "CONDUCTORAUX=" + "\"" + cond_auxiliar + "\"" + " " + "TIEMPOMH=" + "\"" + tiempoMH + "\"" + "/>";
            } else {
               lineaxml = "<ROW NoHR=\"" + ABAST_Xml + "\"" + " " + "FI=" + "\"" + FInicial + "\"" + " " + "HI=" + "\"" + lcd + "\"" + " " + "FF=" + "\"" + FFinal + "\"" + " " + "HF=" + "\"" + HFinal + "\"" + " " + "KMHR=" + "\"" + KmRecorridos + "\"" + " " + "CONDUCTOR=" + "\"" + cond + "\"" + " " + "CONDUCTORAUX=" + "\"" + cond_auxiliar + "\"" + "/>";
            }

            this.InsertarLineaXmlConfig(lineaxml, xmlconfig);
         }

         String Xml = "</ROWDATA>";
         this.InsertarLineaXmlConfig(Xml, xmlconfig);
         Iterator it;
         if (this.ListaCD.size() > 0) {
            ABAST_Xml = "<CDDATA>";
            this.InsertarLineaXmlConfig(ABAST_Xml, xmlconfig);
            it = this.ListaCD.iterator();

            while(it.hasNext()) {
               lcd = (String)it.next();
               this.InsertarLineaXmlConfig(lcd, xmlconfig);
            }

            lcd = "</CDDATA>";
            this.InsertarLineaXmlConfig(lcd, xmlconfig);
         }

         if (this.ListaABAST.size() > 0) {
            ABAST_Xml = "<ABASTDATA>";
            this.InsertarLineaXmlConfig(ABAST_Xml, xmlconfig);
            it = this.ListaABAST.iterator();

            while(it.hasNext()) {
               lcd = (String)it.next();
               this.InsertarLineaXmlConfig(lcd, xmlconfig);
            }

            lcd = "</ABASTDATA></DATAPACKET>";
            this.InsertarLineaXmlConfig(lcd, xmlconfig);
         } else {
            this.InsertarLineaXmlConfig(XmlCerrado, xmlconfig);
         }
      }

      this.en.ShowMessage("La Trayectoria ha sido Guardada en la Carpeta Por Transferir.", "Información", "Information");
   }

   public String Fecha1(String Fecha_Inicial, String Hora_Inicial) {
      String[] partes = Fecha_Inicial.split("/");
      int dia = Integer.parseInt(partes[0]);
      int mes = Integer.parseInt(partes[1]) - 1;
      int year = Integer.parseInt(partes[2]) + 100;
      String[] partes_de_hora = Hora_Inicial.split(":");
      int h = Integer.parseInt(partes_de_hora[0]);
      int m = Integer.parseInt(partes_de_hora[1]);
      int s = Integer.parseInt(partes_de_hora[2]);
      Date d = new Date(year, mes, dia, h, m, s);
      DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String datestr = dateformat.format(d);
      return datestr;
   }

   public int TiempoRecorrido() {
      Iterator it = this.ListaHr.iterator();
      long tr = 0L;
      long tiempo_recorrido = 0L;
      long tiempo_recorrido_sr = 0L;
      this.kmhr_total = 0.0D;
      this.kmgps_total = 0.0D;
      this.kmsinresp = 0.0D;
      this.tiemposr = 0;
      int cant = this.ListaHr.size();
      int c = 0;

      while(it.hasNext()) {
         ++c;
         HR hr = (HR)it.next();
         tiempo_recorrido = hr.tiempoHR - hr.tiempo_det_HR;
         tiempo_recorrido_sr = hr.tiempo_SR - hr.tiempo_det_SR;
         tr += tiempo_recorrido;
         tr += tiempo_recorrido_sr;
         this.kmhr_total += hr.kmrec;
         this.kmgps_total += hr.km_gps;
         this.kmsinresp += hr.km_sin_respaldo;
         this.tiemposr = (int)((long)this.tiemposr + hr.tiempo_SR);
         if (c == cant) {
            this.kmsinresp += hr.km_after;
         }
      }

      return (int)tr;
   }

   public int TiempoDetenido() {
      Iterator it = this.ListaHr.iterator();

      long td;
      HR hr;
      for(td = 0L; it.hasNext(); td += hr.tiempo_det_HR) {
         hr = (HR)it.next();
         td += hr.tiempo_det_SR;
      }

      return (int)td;
   }

   public void Borrar_Temporales() {
      this.en.BorrarDirectorio("Temp");
      File shp_compac = new File(this.shp_compacto);
      if (shp_compac.exists()) {
         shp_compac.delete();
      }

      File logid_file = new File(this.XML_Compactado);
      if (logid_file.exists()) {
         logid_file.delete();
      }

      System.runFinalization();
      System.gc();
   }

   private void InsertarTiempoDetHR() {
      Iterator it = this.ListaHr.iterator();
      int cant = this.ListaHr.size();

      for(int i = 1; it.hasNext(); ++i) {
         HR hr = (HR)it.next();
         if (i == cant) {
            hr.tiempo_det_HR = hr.tiempoHR;
         }
      }

   }

   private void InsertarTiempoDetSR() {
      Iterator it = this.ListaHr.iterator();
      int cant = this.ListaHr.size();

      for(int i = 1; it.hasNext(); ++i) {
         HR hr = (HR)it.next();
         if (i == cant) {
            hr.tiempo_det_SR = hr.tiempo_SR;
         }
      }

   }

   private int BuscarIdCond(String Nombre) throws SAXException, IOException {
      try {
         int idc = 0;
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "choferes.xml");
         InputSource choferes = new InputSource(new StringReader(respuesta));
         parser.parse(choferes);
         Document doc = parser.getDocument();
         NodeList Lista_Choferes = doc.getElementsByTagName("ROW");
         int cant_choferes = Lista_Choferes.getLength();

         for(int i = 0; i < cant_choferes; ++i) {
            String Id = Lista_Choferes.item(i).getAttributes().getNamedItem("ID").getNodeValue();
            String Cond = Lista_Choferes.item(i).getAttributes().getNamedItem("Conductor").getNodeValue();
            if (Cond.equalsIgnoreCase(Nombre)) {
               idc = Integer.parseInt(Id);
               break;
            }
         }

         return idc;
      } catch (Exception var12) {
         String msg = "No se pudo Obtener el Identificador del Conductor.";
         this.en.ShowMessage(msg, "Información", "Information");
         return 0;
      }
   }

   private int BuscarGrupo() throws SAXException, IOException {
      try {
         DOMParser parser = new DOMParser();
         String respuesta = this.en.Decrypt(this.en.encript, "Usuario.xml");
         InputSource Usuario = new InputSource(new StringReader(respuesta));
         parser.parse(Usuario);
         Document doc = parser.getDocument();
         Node Datos_Usuario = null;
         NodeList Lista_Datos = null;
         Lista_Datos = doc.getElementsByTagName("ROW");
         String g = Lista_Datos.item(0).getAttributes().getNamedItem("Grupo").getNodeValue();
         int grupo = Integer.parseInt(g);
         return grupo;
      } catch (Exception var9) {
         String msg = "No se pudo Obtener el Identificador del Grupo.";
         this.en.ShowMessage(msg, "Información", "Information");
         return 0;
      }
   }

   public boolean Chequear_Version() {
      String sitio = this.en.GetSitio();
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/Version?numero=" + this.en.version;
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Comprobando Versión...");
      this.PB.setVisible(true);
      URL url;
      String line;
      if (this.en.Hay_Proxy) {
         try {
            String ip = this.en.DireccionProxy;
            String puerto = this.en.PuertoProxy;
            String usuariop = this.en.UsuarioProxy;
            String passp = this.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(puerto), sitio);
            conn = url.openConnection();
            String user_pass = usuariop + ":" + passp;
            line = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + line);
         } catch (Exception var12) {
            line = "Es Posible que no Tenga Conexión en este Momento. Revise \nla Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
         }
      } else {
         try {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         } catch (Exception var11) {
            line = "Es Posible que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
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
         if (respuesta.equalsIgnoreCase("OK")) {
            return true;
         }
      } catch (UnknownHostException var13) {
         this.en.Tiene_Conexion = false;
         return true;
      } catch (IOException var14) {
         this.en.Tiene_Conexion = false;
         return true;
      }

      this.PB.setVisible(false);
      this.PBLabel.setVisible(false);
      return false;
   }

   public boolean Verificar_Usuario() {
      String sitio = this.en.GetSitio();
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/VerificarUsuario?usuario=" + this.en.idusuario + "&movil=" + this.en.chapa;
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Comprobando Usuario...");
      this.PB.setVisible(true);
      URL url;
      String line;
      if (this.en.Hay_Proxy) {
         try {
            String ip = this.en.DireccionProxy;
            String puerto = this.en.PuertoProxy;
            String usuariop = this.en.UsuarioProxy;
            String passp = this.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(puerto), sitio);
            conn = url.openConnection();
            String user_pass = usuariop + ":" + passp;
            line = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + line);
         } catch (Exception var12) {
            line = "Es Posible que no Tenga Conexión en este Momento. Revise \nla Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
         }
      } else {
         try {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         } catch (Exception var11) {
            line = "Es Posible que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
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
         if (respuesta.equalsIgnoreCase("OK")) {
            return true;
         }
      } catch (UnknownHostException var13) {
         this.en.Tiene_Conexion = false;
         return true;
      } catch (IOException var14) {
         this.en.Tiene_Conexion = false;
         return true;
      }

      this.PB.setVisible(false);
      this.PBLabel.setVisible(false);
      return false;
   }

   public boolean ChequearPagodeBase() {
      String sitio = this.en.GetSitio();
      URLConnection conn = null;
      sitio = sitio + "/MovilWebServLet/Pago?grupo=" + this.en.Grupo;
      this.PBLabel.setVisible(true);
      this.PBLabel.setText("Comprobando Pago de la Base...");
      this.PB.setVisible(true);
      URL url;
      String line;
      if (this.en.Hay_Proxy) {
         try {
            String ip = this.en.DireccionProxy;
            String puerto = this.en.PuertoProxy;
            String usuariop = this.en.UsuarioProxy;
            String passp = this.en.PassProxy;
            url = new URL("http", ip, Integer.parseInt(puerto), sitio);
            conn = url.openConnection();
            String user_pass = usuariop + ":" + passp;
            line = (new BASE64Encoder()).encode(user_pass.getBytes());
            conn.setRequestProperty("Proxy-Authorization", "Basic " + line);
         } catch (Exception var12) {
            line = "Es Posible que no Tenga Conexión en este Momento. Revise \nla Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
         }
      } else {
         try {
            url = new URL(sitio);
            conn = url.openConnection();
            conn.setDoOutput(true);
         } catch (Exception var11) {
            line = "Es P que no Tenga Conexión en este Momento. Revise <br/>la Configuración del Proxy.  ";
            this.en.ShowMessage(line, "Información", "Information");
            this.en.Tiene_Conexion = false;
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
         if (respuesta.equalsIgnoreCase("OK")) {
            return true;
         }
      } catch (UnknownHostException var13) {
         this.en.Tiene_Conexion = false;
         return true;
      } catch (IOException var14) {
         this.en.Tiene_Conexion = false;
         return true;
      }

      this.PB.setVisible(false);
      this.PBLabel.setVisible(false);
      return false;
   }

   private void close() {
      this.setDefaultCloseOperation(3);
      this.setVisible(false);
      this.dispose();
   }

   public long TiempoHR(String fi, String hi, String ff, String hf) {
      int dia_inicial = Integer.parseInt(fi.substring(0, 2));
      int mes_inicial = Integer.parseInt(fi.substring(3, 5)) - 1;
      int year_inicial = Integer.parseInt(fi.substring(6, 8)) + 100;
      int hora_inicial = Integer.parseInt(hi.substring(0, 2));
      int minuto_inicial = Integer.parseInt(hi.substring(3, 5));
      int dia_final = Integer.parseInt(ff.substring(0, 2));
      int mes_final = Integer.parseInt(ff.substring(3, 5)) - 1;
      int year_final = Integer.parseInt(ff.substring(6, 8)) + 100;
      int hora_final = Integer.parseInt(hf.substring(0, 2));
      int minuto_final = Integer.parseInt(hf.substring(3, 5));
      Date date_inicial = new Date(year_inicial, mes_inicial, dia_inicial, hora_inicial, minuto_inicial);
      Date date_final = new Date(year_final, mes_final, dia_final, hora_final, minuto_final);
      long date_diff = this.DateDiff("m", date_inicial, date_final);
      return date_diff;
   }

   public long TiempoMotoHoras(String tiempo) {
      int hora_inicial = Integer.parseInt(tiempo.substring(0, 2));
      int minuto_inicial = Integer.parseInt(tiempo.substring(3, 5));
      long tiempMH = (long)(hora_inicial * 60 + minuto_inicial);
      return tiempMH;
   }

   public long DateDiff(String Interval, Date Date1, Date Date2) {
      long difference = Math.abs(Date1.getTime() - Date2.getTime());
      if (Interval.equals("s")) {
         difference /= 1000L;
      }

      if (Interval.equals("m")) {
         difference /= 60000L;
      }

      if (Interval.equals("h")) {
         difference /= 3600000L;
      }

      return difference;
   }

   class anterior {
      public double lon2_anterior;
      public double lat2_anterior;
      public double velocidad_anterior;
      public double rotacion_anterior;
      public double dist_anterior;
      public String fecha_anterior = "";
      public String mov_anterior;
      public boolean vacio = true;

      public anterior() {
      }
   }
}
