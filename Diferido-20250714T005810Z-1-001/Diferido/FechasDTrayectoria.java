package Diferido;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class FechasDTrayectoria extends JFrame {
   Entrada en;
   JDateChooser fecha;
   SimpleDateFormat formato;
   private JLabel FF;
   private JLabel FI;
   public JFormattedTextField Hora;
   private JLabel ImagEnviar;
   private JLabel ImagEnviar1;
   private JFormattedTextField fecha1;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel5;
   private JLabel jLabel6;
   private JLabel jLabel7;
   private JPanel jPanel1;

   public FechasDTrayectoria(Entrada en) throws MalformedURLException {
      this.initComponents();
      File dir_imagen = new File("test-data/diferido install.png");
      URL img = dir_imagen.toURI().toURL();
      this.setIconImage((new ImageIcon(img)).getImage());
      this.setLocationRelativeTo((Component)null);
      this.fecha1.setVisible(false);
      this.formato = new SimpleDateFormat("dd/MM/yy");
      this.fecha = new JDateChooser("dd/MM/yy", "##/##/##", '_');
      this.fecha.setBorder(BorderFactory.createBevelBorder(1));
      this.fecha.setPreferredSize(new Dimension(80, 20));
      this.jPanel1.add(this.fecha, new AbsoluteConstraints(120, 140, 80, -1), 1);
      this.fecha.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            e.consume();
         }
      });
      this.en = en;
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.jLabel1 = new JLabel();
      this.jLabel2 = new JLabel();
      this.FI = new JLabel();
      this.FF = new JLabel();
      this.jLabel5 = new JLabel();
      this.jLabel6 = new JLabel();
      this.fecha1 = new JFormattedTextField();
      this.Hora = new JFormattedTextField();
      this.jLabel7 = new JLabel();
      this.ImagEnviar = new JLabel();
      this.ImagEnviar1 = new JLabel();
      this.setDefaultCloseOperation(2);
      this.setTitle("Intervalo de Trayectoria");
      this.setResizable(false);
      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent evt) {
            FechasDTrayectoria.this.formWindowClosing(evt);
         }
      });
      this.jPanel1.setBackground(new Color(231, 238, 246));
      this.jPanel1.setLayout(new AbsoluteLayout());
      this.jLabel1.setFont(new Font("Tahoma", 0, 12));
      this.jLabel1.setForeground(new Color(0, 0, 102));
      this.jLabel1.setText("Ultima Fecha Transferida:");
      this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(20, 30, 150, -1));
      this.jLabel2.setFont(new Font("Tahoma", 0, 12));
      this.jLabel2.setForeground(new Color(0, 0, 102));
      this.jLabel2.setText("Fecha Final de Trayectoria:");
      this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(20, 50, -1, -1));
      this.FI.setFont(new Font("Tahoma", 0, 12));
      this.FI.setForeground(new Color(0, 0, 102));
      this.FI.setText("Fecha de Inicio");
      this.jPanel1.add(this.FI, new AbsoluteConstraints(170, 30, -1, -1));
      this.FF.setFont(new Font("Tahoma", 0, 12));
      this.FF.setForeground(new Color(0, 0, 102));
      this.FF.setText("Fecha Final");
      this.jPanel1.add(this.FF, new AbsoluteConstraints(170, 50, -1, -1));
      this.jLabel5.setFont(new Font("Tahoma", 0, 12));
      this.jLabel5.setForeground(new Color(0, 0, 102));
      this.jLabel5.setText("Fecha Final:");
      this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(50, 140, -1, -1));
      this.jLabel6.setFont(new Font("Tahoma", 0, 12));
      this.jLabel6.setForeground(new Color(0, 0, 102));
      this.jLabel6.setText("Hora Final:");
      this.jPanel1.add(this.jLabel6, new AbsoluteConstraints(210, 140, -1, -1));

      try {
         this.fecha1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/##")));
      } catch (ParseException var3) {
         var3.printStackTrace();
      }

      this.jPanel1.add(this.fecha1, new AbsoluteConstraints(120, 140, 60, -1));

      try {
         this.Hora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##")));
      } catch (ParseException var2) {
         var2.printStackTrace();
      }

      this.Hora.addFocusListener(new FocusAdapter() {
         public void focusLost(FocusEvent evt) {
            FechasDTrayectoria.this.HoraFocusLost(evt);
         }
      });
      this.jPanel1.add(this.Hora, new AbsoluteConstraints(270, 140, 60, -1));
      this.jLabel7.setFont(new Font("Tahoma", 0, 12));
      this.jLabel7.setForeground(new Color(0, 0, 102));
      this.jLabel7.setText("Fecha Final de la Trayectoria a descargar:");
      this.jPanel1.add(this.jLabel7, new AbsoluteConstraints(20, 100, 360, -1));
      this.ImagEnviar.setIcon(new ImageIcon(this.getClass().getResource("/Images/enviar.png")));
      this.ImagEnviar.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            FechasDTrayectoria.this.ImagEnviarMouseEntered(evt);
         }
      });
      this.jPanel1.add(this.ImagEnviar, new AbsoluteConstraints(160, 180, 96, 32));
      this.ImagEnviar1.setIcon(new ImageIcon(this.getClass().getResource("/Images/enviar on.png")));
      this.ImagEnviar1.setText("ImagEnviar1");
      this.ImagEnviar1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            FechasDTrayectoria.this.ImagEnviar1MouseClicked(evt);
         }

         public void mouseExited(MouseEvent evt) {
            FechasDTrayectoria.this.ImagEnviar1MouseExited(evt);
         }
      });
      this.jPanel1.add(this.ImagEnviar1, new AbsoluteConstraints(160, 180, 96, 32));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, 401, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, 285, 32767));
      this.pack();
   }

   private void ImagEnviarMouseEntered(MouseEvent evt) {
      this.ImagEnviar.setVisible(false);
      this.ImagEnviar1.setVisible(true);
   }

   private void ImagEnviar1MouseClicked(MouseEvent evt) {
      if (this.formato.format(this.fecha.getDate()).equalsIgnoreCase("/  /")) {
         this.en.ShowMessage("Debe especificar la Fecha Final de la Trayectoria.", "Error", "Error");
         this.en.selecciono_fechas = false;
         this.en.en_ejecucion = false;
      } else if (this.Hora.getText().trim().equalsIgnoreCase(":")) {
         this.en.ShowMessage("Debe especificar la Hora Final de la Trayectoria.", "Error", "Error");
         this.en.selecciono_fechas = false;
         this.en.en_ejecucion = false;
      } else {
         String fechainic = this.FI.getText().substring(0, 8).trim();
         String horainic = this.FI.getText().substring(9, 14).trim();
         String fechafin = this.FF.getText().substring(0, 8).trim();
         String horafin = this.FF.getText().substring(9, 14).trim();
         if (!this.en.ComparaFecha(fechainic, this.formato.format(this.fecha.getDate()), horainic, this.Hora.getText(), 1)) {
            this.en.ShowMessage("La fecha que usted está insertando no puede ser menor <br/>que la fecha inicial de la trayectoria. Por favor, verifíquela.", "Error", "Error");
            this.Hora.setText("");
            this.en.selecciono_fechas = false;
            this.en.en_ejecucion = false;
         } else if (!this.en.ComparaFecha(this.formato.format(this.fecha.getDate()), fechafin, this.Hora.getText(), horafin, 1)) {
            this.en.ShowMessage("La fecha que usted está insertando no puede ser mayor <br/>que la fecha final de la trayectoria. Por favor, verifíquela.", "Error", "Error");
            this.Hora.setText("");
            this.en.selecciono_fechas = false;
            this.en.en_ejecucion = false;
         } else {
            this.en.selecciono_fechas = true;
            this.en.en_ejecucion = true;
            String Fecha1 = this.Obtener_Fecha(this.formato.format(this.fecha.getDate()), this.Hora.getText());
            Fecha1 = Fecha1.replace("-", "_");
            Fecha1 = Fecha1.replace(" ", "^");
            this.en.FF = Fecha1;
            this.setVisible(false);
            Hilo h = new Hilo(this.en);
            h.start();
         }
      }

   }

   private void ImagEnviar1MouseExited(MouseEvent evt) {
      this.ImagEnviar1.setVisible(false);
      this.ImagEnviar.setVisible(true);
   }

   private void formWindowClosing(WindowEvent evt) {
      this.en.selecciono_fechas = false;
      this.en.en_ejecucion = false;
      this.dispose();
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

   public void MostrarDatos() {
      this.FI.setText(this.en.FI_Intervalo);
      this.FF.setText(this.en.FF_Intervalo);
      int dia_inicial = Integer.parseInt(this.en.FI_Intervalo.substring(0, 2));
      int mes_inicial = Integer.parseInt(this.en.FI_Intervalo.substring(3, 5)) - 1;
      int anno_inicial = Integer.parseInt(this.en.FI_Intervalo.substring(6, 8)) + 100;
      Date date_inicial = new Date(anno_inicial, mes_inicial, dia_inicial);
      int dia_final = Integer.parseInt(this.en.FF_Intervalo.substring(0, 2));
      int mes_final = Integer.parseInt(this.en.FF_Intervalo.substring(3, 5)) - 1;
      int anno_final = Integer.parseInt(this.en.FF_Intervalo.substring(6, 8)) + 100;
      Date date_final = new Date(anno_final, mes_final, dia_final);
      this.fecha.setSelectableDateRange(date_inicial, date_final);
      this.fecha.setDate(date_final);
   }

   public String Obtener_Fecha(String Fecha, String Hora) {
      String[] f = Fecha.split("/");
      int year = Integer.valueOf(f[2]) + 2000;
      String retorno = year + "-" + f[1] + "-" + f[0] + " " + Hora;
      return retorno;
   }
}
