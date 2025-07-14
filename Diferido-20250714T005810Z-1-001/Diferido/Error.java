package Diferido;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import sun.misc.BASE64Encoder;

public class Error extends JFrame {
   Entrada en;
   DefaultTableCellRenderer tcr;
   private JButton Aceptar;
   public JTextField Chapa;
   public JTextField Chofer;
   public JTextArea Descripcion;
   private JTextField Grupo;
   private JTextField Motivo;
   public JTextField NoUser;
   private JTable Tabla;
   private JLabel User;
   private JLabel User2;
   private JLabel User3;
   private JLabel User4;
   private JLabel User5;
   public JTextField Usuario;
   private JButton jButton2;
   private JButton jButton3;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JPanel jPanel1;
   private JScrollPane jScrollPane1;
   private JScrollPane jScrollPane2;
   private JToggleButton jToggleButton1;

   public Error(Entrada en) {
      try {
         this.initComponents();
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
      } catch (MalformedURLException var4) {
         Logger.getLogger(Error.class.getName()).log(Level.SEVERE, (String)null, var4);
      }

   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.Chofer = new JTextField();
      this.NoUser = new JTextField();
      this.User = new JLabel();
      this.User2 = new JLabel();
      this.Chapa = new JTextField();
      this.Aceptar = new JButton();
      this.User3 = new JLabel();
      this.User4 = new JLabel();
      this.jToggleButton1 = new JToggleButton();
      this.jButton2 = new JButton();
      this.jButton3 = new JButton();
      this.jLabel1 = new JLabel();
      this.Grupo = new JTextField();
      this.jScrollPane2 = new JScrollPane();
      this.Tabla = new JTable();
      this.jLabel2 = new JLabel();
      this.jScrollPane1 = new JScrollPane();
      this.Descripcion = new JTextArea();
      this.jLabel3 = new JLabel();
      this.Motivo = new JTextField();
      this.User5 = new JLabel();
      this.Usuario = new JTextField();
      this.setDefaultCloseOperation(0);
      this.setTitle("Trayectoria con Error");
      this.setBackground(new Color(201, 231, 221));
      this.jPanel1.setBackground(new Color(231, 238, 246));
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.Chofer.setToolTipText("Nombre del Chofer");
      this.jPanel1.add(this.Chofer, new AbsoluteConstraints(140, 295, 220, -1));
      this.NoUser.setEditable(false);
      this.NoUser.setToolTipText("Identificador del Usuario en la BD");
      this.jPanel1.add(this.NoUser, new AbsoluteConstraints(110, 100, 70, -1));
      this.User.setFont(new Font("Tahoma", 1, 12));
      this.User.setForeground(new Color(0, 51, 51));
      this.User.setText("Chapa:");
      this.jPanel1.add(this.User, new AbsoluteConstraints(360, 73, -1, -1));
      this.User2.setFont(new Font("Tahoma", 1, 12));
      this.User2.setForeground(new Color(0, 51, 51));
      this.User2.setText("Nombre Chofer:");
      this.jPanel1.add(this.User2, new AbsoluteConstraints(30, 297, -1, -1));
      this.Chapa.setEditable(false);
      this.Chapa.setToolTipText("Chapa del Vehículo");
      this.jPanel1.add(this.Chapa, new AbsoluteConstraints(410, 70, 70, -1));
      this.Aceptar.setText("Aceptar");
      this.Aceptar.setToolTipText("Aceptar los Datos Seleccionados");
      this.Aceptar.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Error.this.AceptarMouseClicked(evt);
         }
      });
      this.jPanel1.add(this.Aceptar, new AbsoluteConstraints(180, 470, 80, 25));
      this.User3.setFont(new Font("Tahoma", 1, 12));
      this.User3.setForeground(new Color(0, 51, 51));
      this.User3.setText("Usuario:");
      this.jPanel1.add(this.User3, new AbsoluteConstraints(30, 73, -1, -1));
      this.User4.setFont(new Font("Tahoma", 1, 12));
      this.User4.setForeground(new Color(0, 51, 51));
      this.User4.setText("Causa: ");
      this.jPanel1.add(this.User4, new AbsoluteConstraints(30, 43, -1, -1));
      this.jToggleButton1.setText("Cancelar");
      this.jToggleButton1.setToolTipText("Cancelar la Operación");
      this.jToggleButton1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Error.this.jToggleButton1MouseClicked(evt);
         }
      });
      this.jPanel1.add(this.jToggleButton1, new AbsoluteConstraints(290, 470, 90, 25));
      this.jButton2.setIcon(new ImageIcon(this.getClass().getResource("/Images/Insertar.jpg")));
      this.jButton2.setToolTipText("Insertar una fila en la tabla");
      this.jButton2.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Error.this.jButton2MouseClicked(evt);
         }
      });
      this.jPanel1.add(this.jButton2, new AbsoluteConstraints(500, 190, 30, 30));
      this.jButton3.setIcon(new ImageIcon(this.getClass().getResource("/Images/Eliminar.jpg")));
      this.jButton3.setToolTipText("Eliminar una fila de la tabla");
      this.jButton3.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Error.this.jButton3MouseClicked(evt);
         }
      });
      this.jPanel1.add(this.jButton3, new AbsoluteConstraints(500, 240, 30, 30));
      this.jLabel1.setFont(new Font("Tahoma", 1, 12));
      this.jLabel1.setForeground(new Color(0, 51, 51));
      this.jLabel1.setText("Grupo:");
      this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(360, 103, -1, -1));
      this.Grupo.setEditable(false);
      this.Grupo.setToolTipText("Grupo al que pertenece el Usuario");
      this.jPanel1.add(this.Grupo, new AbsoluteConstraints(410, 100, 70, -1));
      this.jScrollPane2.addMouseListener(new MouseAdapter() {
         public void mouseExited(MouseEvent evt) {
            Error.this.jScrollPane2MouseExited(evt);
         }
      });
      this.Tabla.setModel(new DefaultTableModel(new Object[0][], new String[]{"No", "FI (D/M/A)", "HI (H:M:S)", "FF (D/M/A)", "HF (H:M:S)", "KmR"}) {
         Class[] types = new Class[]{String.class, String.class, String.class, String.class, String.class, String.class};

         public Class getColumnClass(int columnIndex) {
            return this.types[columnIndex];
         }
      });
      this.Tabla.setToolTipText("Datos de HR");
      this.Tabla.addMouseListener(new MouseAdapter() {
         public void mouseExited(MouseEvent evt) {
            Error.this.TablaMouseExited(evt);
         }
      });
      this.Tabla.addFocusListener(new FocusAdapter() {
         public void focusLost(FocusEvent evt) {
            Error.this.TablaFocusLost(evt);
         }
      });
      this.jScrollPane2.setViewportView(this.Tabla);
      if (this.Tabla.getColumnModel().getColumnCount() > 0) {
         this.Tabla.getColumnModel().getColumn(0).setResizable(false);
         this.Tabla.getColumnModel().getColumn(0).setPreferredWidth(30);
         this.Tabla.getColumnModel().getColumn(1).setResizable(false);
         this.Tabla.getColumnModel().getColumn(1).setPreferredWidth(70);
         this.Tabla.getColumnModel().getColumn(2).setResizable(false);
         this.Tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
         this.Tabla.getColumnModel().getColumn(3).setResizable(false);
         this.Tabla.getColumnModel().getColumn(3).setPreferredWidth(70);
         this.Tabla.getColumnModel().getColumn(4).setResizable(false);
         this.Tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
         this.Tabla.getColumnModel().getColumn(5).setResizable(false);
         this.Tabla.getColumnModel().getColumn(5).setPreferredWidth(30);
      }

      this.Tabla.getAccessibleContext().setAccessibleParent(this.Tabla);
      this.jPanel1.add(this.jScrollPane2, new AbsoluteConstraints(30, 180, 460, 100));
      this.jLabel2.setFont(new Font("Tahoma", 1, 12));
      this.jLabel2.setForeground(new Color(0, 51, 51));
      this.jLabel2.setText("Descripción del Error:");
      this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(30, 340, -1, -1));
      this.Descripcion.setColumns(1);
      this.Descripcion.setFont(new Font("Arial", 0, 12));
      this.Descripcion.setLineWrap(true);
      this.Descripcion.setRows(1);
      this.Descripcion.setToolTipText("Breve descripción del error ocurrido (Opcional)");
      this.jScrollPane1.setViewportView(this.Descripcion);
      this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(30, 370, 460, 90));
      this.jLabel3.setFont(new Font("Tahoma", 1, 12));
      this.jLabel3.setForeground(new Color(0, 51, 51));
      this.jLabel3.setText("Datos de Hojas de Ruta:");
      this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(30, 160, -1, -1));
      this.Motivo.setEditable(false);
      this.Motivo.setToolTipText("Causa del error ocurrido ");
      this.Motivo.setAutoscrolls(false);
      this.jPanel1.add(this.Motivo, new AbsoluteConstraints(110, 40, 200, -1));
      this.User5.setFont(new Font("Tahoma", 1, 12));
      this.User5.setForeground(new Color(0, 51, 51));
      this.User5.setText("No. Usuario:");
      this.jPanel1.add(this.User5, new AbsoluteConstraints(30, 103, -1, -1));
      this.Usuario.setEditable(false);
      this.Usuario.setToolTipText("Nombre del Usuario");
      this.jPanel1.add(this.Usuario, new AbsoluteConstraints(110, 70, 140, -1));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, 540, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, 519, 32767));
      this.pack();
   }

   private void AceptarMouseClicked(MouseEvent evt) {
      int cant_filas = this.Tabla.getRowCount();
      if (cant_filas > 0 && this.Contiene_Datos()) {
         String mensaje = "Causa del Error: " + this.Motivo.getText() + "   " + '\n' + "Usuario: " + this.Usuario.getText() + "   " + '\n' + "Grupo: " + this.Grupo.getText() + "   " + '\n' + "Número de Usuario: " + this.NoUser.getText() + "   " + '\n' + "Chapa: " + this.Chapa.getText() + "   " + '\n' + "Líneas contadas: " + this.en.numero_de_lineas + "   " + '\n' + "Líneas simplificadas: " + this.en.tramas_simplificadas + "   " + '\n' + "Nombre Chofer: " + this.Chofer.getText() + "   " + '\n' + "Descripción: " + this.Descripcion.getText() + "   " + '\n' + "-------------------------------------------------------------------" + '\n' + "Datos de Hoja de Ruta: " + '\n';
         String datos_hr = this.Buscar_Datos_HR();
         mensaje = mensaje + datos_hr;
         this.en.Crear_Carpeta("Error");
         String causa1 = "Error//Causa.txt";
         File causa_txt = new File(causa1);
         this.Insertar_fichero(mensaje, causa_txt);
         String fecha_hora = "";

         String nombre;
         try {
            fecha_hora = this.en.Fecha_Hora_Actual_Servidor();
         } catch (Exception var19) {
            nombre = "Se produjo un error intentando crear el nombre del fichero.";
            this.en.ShowMessage(nombre, "Información", "Information");
         }

         String FH = fecha_hora.substring(0, 4) + fecha_hora.substring(5, 7) + fecha_hora.substring(8, 10) + fecha_hora.substring(11, 13) + fecha_hora.substring(14, 16);
         nombre = this.Chapa.getText() + FH;
         String destino = "Error//" + nombre + ".log";
         File d = new File(destino);
         File o = null;
         if (!this.en.Kijo_en_Flash) {
            o = new File(this.en.path);
         } else {
            o = new File(this.en.por_transferir.getPath());
         }

         File o1 = new File("Error");
         File fichero_error = new File("Temp//" + nombre + ".zip");

         try {
            this.en.MoverTrayectoria(o, d);
            Comprimir c = new Comprimir(o1, fichero_error.getPath());
            c.compress();
            d.delete();
            causa_txt.delete();
            o1.delete();
         } catch (Exception var18) {
            String msg = "No se pudo comprimir el fichero de la trayectoria debido<br/>a un error. Intente enviarlo de nuevo.";
            this.en.ShowMessage(msg, "Información", "Information");
         }

         if (this.Enviar_FTP_Error(fichero_error, nombre)) {
            try {
               if (this.Construir_Insert_Error()) {
                  this.en.ShowMessage("La trayectoria se envió con éxito.", "Información", "Information");
                  fichero_error.delete();
                  causa_txt.delete();
                  System.exit(0);
               } else {
                  this.en.ShowMessage("No se pudo enviar la trayectoria.Por favor, inténtelo más tarde.", "Información", "Information");
                  fichero_error.delete();
                  causa_txt.delete();
                  System.exit(0);
               }
            } catch (IOException var17) {
               this.en.ShowMessage("No se pudo enviar la trayectoria.Por favor, inténtelo más tarde.", "Información", "Information");
               fichero_error.delete();
               causa_txt.delete();
               System.exit(0);
            }
         } else {
            this.en.ShowMessage("No se pudo enviar la trayectoria.Por favor, inténtelo más tarde.", "Información", "Information");
            fichero_error.delete();
            causa_txt.delete();
            System.exit(0);
         }
      } else {
         this.en.ShowMessage("Debe insertar los datos de hoja de ruta que faltan.", "Información", "Information");
      }

   }

   private void jToggleButton1MouseClicked(MouseEvent evt) {
      String Msg = "Aún no ha enviado la trayectoria.¿Desea enviarla  más tarde?";
      int n = JOptionPane.showConfirmDialog(this, Msg, "Mensaje de Confirmación", 0);
      if (n == 0) {
         if (this.en.Kijo_en_Flash) {
            Msg = "La trayectoria está en Salvas Originales. La aplicación se cerrará.";
         } else {
            Msg = "Esta trayectoria no se transferirá. La aplicación se cerrará.";
         }

         this.en.ShowMessage(Msg, "Información", "Information");
         this.setVisible(false);
         System.exit(0);
      }

   }

   private void jButton2MouseClicked(MouseEvent evt) {
      DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();
      model.insertRow(model.getRowCount(), new Object[]{"", "", "", "", "", ""});
   }

   private void jButton3MouseClicked(MouseEvent evt) {
      int Numero_fila = this.Tabla.getSelectedRow();
      int cantFilas = this.Tabla.getRowCount();
      if (cantFilas == 0) {
         this.en.ShowMessage("No hay elementos insertados en la Tabla.", "Error", "Error");
      } else if (Numero_fila == -1) {
         this.en.ShowMessage("Debe seleccionar una fila de la Tabla.", "Error", "Error");
      } else if (!this.Tabla.getColumnSelectionAllowed() && this.Tabla.getRowSelectionAllowed()) {
         DefaultTableModel model = (DefaultTableModel)this.Tabla.getModel();
         model.removeRow(Numero_fila);
      }

   }

   private void TablaMouseExited(MouseEvent evt) {
   }

   private void jScrollPane2MouseExited(MouseEvent evt) {
      if (this.Tabla.isEditing()) {
         this.Tabla.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
      }

   }

   private void TablaFocusLost(FocusEvent evt) {
   }

   public void Comprimir(String origen, String destino, String nombre) {
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

   public void ComprimirFTP(String origen, String destino) {
      short BUFFER = 2048;

      try {
         BufferedInputStream origin = null;
         FileOutputStream dest = new FileOutputStream(destino);
         ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
         byte[] data = new byte[BUFFER];
         File f = new File(origen);
         String[] files = f.list();

         for(int i = 0; i < files.length; ++i) {
            if (files[i].equalsIgnoreCase(this.en.SalvasOriginales) || files[i].equalsIgnoreCase("Causa.txt")) {
               FileInputStream fi = new FileInputStream(this.en.Camino_Salvas_Originales + "\\" + files[i]);
               origin = new BufferedInputStream(fi, BUFFER);
               ZipEntry entry = new ZipEntry(files[i]);
               out.putNextEntry(entry);

               int count;
               while((count = origin.read(data, 0, BUFFER)) != -1) {
                  out.write(data, 0, count);
               }

               origin.close();
            }
         }

         out.close();
      } catch (Exception var14) {
         var14.printStackTrace();
      }

   }

   public boolean Enviar_FTP_Error(File fichero_error, String nombre) {
      String port = null;
      URLConnection conn = null;
      String sitio = this.en.GetSitio();
      sitio = sitio + "/MovilWebServLet/Errores";

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
         http.setParameter(nombre, fichero_error);
         InputStream is = http.post();
         BufferedReader rd = new BufferedReader(new InputStreamReader(is));

         String line;
         String respuesta;
         for(respuesta = ""; (line = rd.readLine()) != null; respuesta = respuesta + line) {
         }

         rd.close();
         is.close();
         if (respuesta.equalsIgnoreCase("SUCCESS")) {
            System.out.print("\nFichero de puntos enviado con éxito");
            return true;
         } else {
            System.out.print("\nHubo problemas con el envío de la trayectoria");
            return false;
         }
      } catch (Exception var17) {
         return false;
      }
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

   public void Mostrar() {
      if (this.en.Motivo_Error == 1) {
         this.Motivo.setText("Análisis de la Trayectoria");
      } else if (this.en.Motivo_Error == 2) {
         this.Motivo.setText("Procesamiento de la Trayectoria");
      } else if (this.en.Motivo_Error == 3) {
         this.Motivo.setText("Pérdida del Id del GPS");
      } else {
         this.Motivo.setText("Motivo desconocido");
      }

      this.Usuario.setText(this.en.user);
      this.NoUser.setText(String.valueOf(this.en.idusuario));
      this.Chapa.setText(this.en.chapa);
      this.Grupo.setText(String.valueOf(this.en.Grupo));
      this.setLocationRelativeTo(this.en);
      this.setVisible(true);
      this.en.setVisible(false);
   }

   private boolean Construir_Insert_Error() throws IOException {
      try {
         String Fecha = this.en.Fecha_Hora_Actual_Servidor();
         String[] partes_fecha = Fecha.split(" ");
         String dia = partes_fecha[0];
         String hora = partes_fecha[1];
         int causa = this.en.Motivo_Error;
         String descripcion = this.Descripcion.getText();
         String f = "to_timestamp('" + dia + " " + hora + "'" + ",'YYYY-MM-DD HH24:MI:SS')";
         String insert_file = "INSERT INTO tray_con_error(usuario,fecha, chapa, causa,descripcion,grupo) Values(";
         insert_file = insert_file + this.en.idusuario + "," + f + "," + "'" + this.en.chapa + "'" + "," + causa + "," + "'" + descripcion + "'" + "," + this.en.Grupo + ");";
         String origen = "Temp//InsertError.txt";
         String destino = "Temp//Insert" + this.en.chapa + ".gz";
         File f_causa = new File(origen);
         this.Insertar_fichero(insert_file, f_causa);
         this.en.MakeGzipFile(origen, destino);
         File Insert = new File(destino);
         if (this.Enviar_Trayectoria(Insert)) {
            Insert.delete();
            f_causa.delete();
            return true;
         } else {
            return false;
         }
      } catch (Exception var13) {
         return false;
      }
   }

   public boolean Enviar_Trayectoria(File XML_Compactado) throws UnsupportedEncodingException {
      String port = null;
      URLConnection conn = null;
      String sitio = this.en.GetSitio();
      sitio = sitio + "/MovilWebServLet/UploadData106";
      String user = String.valueOf(this.en.idusuario);
      String service = "carga";
      sitio = sitio + "?user=" + user + "&service=carga";

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
            System.out.print("\nFichero de insert enviado con éxito");
            return true;
         } else {
            System.out.print("\nHubo problemas con el envío de la trayectoria");
            return false;
         }
      } catch (Exception var17) {
         var17.printStackTrace();
         return false;
      }
   }

   private String Buscar_Datos_HR() {
      String dhr = "";
      String No = " ";
      String fi = " ";
      String hi = " ";
      String ff = " ";
      String hf = " ";
      String km = " ";
      int cantfilas = this.Tabla.getRowCount();
      if (cantfilas == 1) {
         try {
            No = this.Tabla.getValueAt(0, 0).toString();
            fi = this.Tabla.getValueAt(0, 1).toString();
            hi = this.Tabla.getValueAt(0, 2).toString();
            ff = this.Tabla.getValueAt(0, 3).toString();
            hf = this.Tabla.getValueAt(0, 4).toString();
            km = this.Tabla.getValueAt(0, 5).toString();
         } catch (Exception var12) {
            var12.printStackTrace();
         }

         dhr = "Número: " + No + ", " + "FI: " + fi + ", " + "HI: " + hi + ", " + "FF: " + ff + ", " + "HF: " + hf + ", " + "Km Rec: " + km + '\n';
      } else {
         for(int i = 0; i < cantfilas; ++i) {
            try {
               No = this.Tabla.getValueAt(i, 0).toString();
               fi = this.Tabla.getValueAt(i, 1).toString();
               hi = this.Tabla.getValueAt(i, 2).toString();
               ff = this.Tabla.getValueAt(i, 3).toString();
               hf = this.Tabla.getValueAt(i, 4).toString();
               km = this.Tabla.getValueAt(i, 5).toString();
            } catch (Exception var11) {
               var11.printStackTrace();
            }

            dhr = dhr + i + ") Número: " + No + ", " + "FI: " + fi + ", " + "HI: " + hi + ", " + "FF: " + ff + ", " + "HF: " + hf + ", " + "Km Rec: " + km + '\n';
         }
      }

      return dhr;
   }

   private boolean Contiene_Datos() {
      int filas = this.Tabla.getRowCount();
      int col = this.Tabla.getColumnCount();
      int ban = false;

      for(int i = 0; i < filas; ++i) {
         for(int j = 0; j < col; ++j) {
            if (String.valueOf(this.Tabla.getValueAt(i, j)).equalsIgnoreCase("")) {
               return false;
            }
         }
      }

      return true;
   }
}
