package Diferido;

import app.Com;
import app.Parameters;
import core.SerialPort;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PuertoSerie {
   SerialPort puerto;
   String regist;
   Com comBase;
   Entrada en;
   double dist_recorrida;

   public PuertoSerie(Entrada en) throws Exception {
      this.en = en;
      this.puerto = new SerialPort();
   }

   public boolean MiPuerto() throws Exception {
      int i = 0;
      int v = 0;
      String c = "";
      String recibido = "";
      String caracter = "";
      String idGPS = "";
      recibido = recibido.trim();
      idGPS = idGPS.trim();
      boolean com = this.ComOcupado();
      if (!com) {
         this.comBase.close();
         return false;
      } else {
         caracter = this.comBase.receiveSingleString();

         while(!caracter.equals("#") || i < 12) {
            caracter = this.comBase.receiveSingleString();
            if (!caracter.equalsIgnoreCase("")) {
               if (caracter.equalsIgnoreCase("#")) {
                  v = 0;
                  ++i;
                  c = c + caracter;
                  if (i > 5) {
                     this.en.PB.setVisible(true);
                     this.en.PBLabel.setVisible(true);
                     this.en.PBLabel.setText("Se Estableció Conexión Bluetooth...");
                  }
               } else {
                  i = 0;
               }
            } else {
               ++v;
               if (v > 25 && i == 0) {
                  this.en.PB.setVisible(true);
                  this.en.PBLabel.setVisible(true);
                  this.en.PBLabel.setText("Conecte Dispositivo Bluetooth...");
               }
            }
         }

         this.regist = this.BuscarRegistro();
         this.DetenerGrabacion();
         if (caracter.equalsIgnoreCase("#")) {
            int reg = Integer.parseInt(this.BuscarNumRegistros());
            if (reg < 16) {
               int n = this.en.ShowMessageConfirmDialog("El Histórico Está Vacío.<br/>Desea Cargar Histórico de la PC", "Mensaje de Confirmación", "Confirmación");
               if (n == 0) {
                  this.ReanudarGrabacion();
                  this.comBase.close();
                  return false;
               }

               this.ReanudarGrabacion();
               this.comBase.close();
               System.exit(0);
            }

            for(caracter = this.comBase.receiveSingleString(); !caracter.equalsIgnoreCase("#"); caracter = this.comBase.receiveSingleString()) {
            }

            this.BuscarDistancia();
            this.DescargarHistorico();
         }

         return true;
      }
   }

   public void Formatear() {
      try {
         String caracter;
         for(caracter = this.comBase.receiveSingleString(); !caracter.equals("#"); caracter = this.comBase.receiveSingleString()) {
         }

         this.comBase.sendString(">F701<", 0);
         caracter = this.comBase.receiveSingleString();
         this.en.PB.setVisible(true);
         this.en.PBLabel.setText("Borrando Histórico...");
         this.en.PBLabel.setVisible(true);

         while(!caracter.equals("#")) {
            caracter = this.comBase.receiveSingleString();
         }
      } catch (Exception var3) {
         String m = "Error Borrando Histórico.";
         this.en.ShowMessage(m, "Information", "Error");
      }

   }

   public String BuscarIdGPS() {
      String idgps = "";
      boolean inicio = false;
      idgps = idgps.trim();
      int id = 0;

      try {
         String caracter;
         for(caracter = this.comBase.receiveSingleString(); !caracter.equals("#"); caracter = this.comBase.receiveSingleString()) {
         }

         if (caracter.equalsIgnoreCase("#")) {
            this.comBase.sendString(">32?1<", 0);

            while(caracter.equalsIgnoreCase("#")) {
               caracter = this.comBase.receiveSingleString();
            }

            while(true) {
               while(id != 20) {
                  caracter = this.comBase.receiveSingleString();
                  ++id;
                  if (caracter.equals("=")) {
                     inicio = true;
                  } else if (inicio && !idgps.endsWith("<")) {
                     idgps = idgps + caracter;
                  } else {
                     inicio = false;
                  }
               }

               return idgps.substring(1, idgps.length() - 1);
            }
         }
      } catch (Exception var6) {
         String m = "Error Buscando IdGPS.";
         this.en.ShowMessage(m, "Information", "Error");
      }

      return idgps.substring(1, idgps.length() - 1);
   }

   public String BuscarNumRegistros() {
      this.en.PB.setVisible(false);
      this.en.PBLabel.setVisible(false);
      String num_registros = "";
      boolean inicio = false;
      num_registros = num_registros.trim();
      int reg = 0;

      String registro;
      try {
         String caracter;
         for(caracter = this.comBase.receiveSingleString(); !caracter.equals("#"); caracter = this.comBase.receiveSingleString()) {
         }

         if (caracter.equalsIgnoreCase("#")) {
            this.comBase.sendString(">11?<", 0);

            while(caracter.equalsIgnoreCase("#")) {
               caracter = this.comBase.receiveSingleString();
            }

            label40:
            while(true) {
               while(true) {
                  if (reg == 20) {
                     break label40;
                  }

                  caracter = this.comBase.receiveSingleString();
                  ++reg;
                  if (caracter.equals("=")) {
                     inicio = true;
                  } else if (inicio && !num_registros.endsWith("<")) {
                     num_registros = num_registros + caracter;
                  } else {
                     inicio = false;
                  }
               }
            }
         }
      } catch (Exception var6) {
         registro = "Error Buscando Número de Registros.";
         this.en.ShowMessage(registro, "Error", "Error");
      }

      String[] partes = num_registros.split(",");
      registro = partes[0];
      return registro;
   }

   public void CambiarEstadLed(String comando) {
      try {
         String caracter;
         for(caracter = this.comBase.receiveSingleString(); !caracter.equals("#"); caracter = this.comBase.receiveSingleString()) {
         }

         if (caracter.equalsIgnoreCase("#")) {
            this.comBase.sendString(comando, 0);
         }
      } catch (Exception var4) {
         String m = "Error Cambiando Estado del LED.";
         this.en.ShowMessage(m, "Information", "Error");
      }

   }

   public List LisPuertoCOM() {
      List portsFree = null;

      try {
         portsFree = this.puerto.getFreeSerialPort();
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return portsFree;
   }

   public boolean ComOcupado() {
      String name = "";
      int ban = 0;
      name = name.trim();
      String ENTER = Character.toString('\r');
      boolean ocupado = false;
      List listaPuertos = this.LisPuertoCOM();

      try {
         Parameters settings = new Parameters();
         int i;
         if (listaPuertos.size() > 0) {
            this.en.PB.setVisible(true);
            this.en.PBLabel.setVisible(true);
            this.en.PBLabel.setText("Buscando LM048 en Puerto COM...");

            for(i = 0; i < listaPuertos.size(); ++i) {
               settings.setPort((String)listaPuertos.get(i));
               settings.setBaudRate("19200");
               settings.setByteSize("8");
               settings.setStopBits("1");
               settings.setParity("N");
               this.comBase = new Com(settings);
               this.comBase.sendString("AT+VER" + ENTER, 0);
               String caracter = this.comBase.receiveSingleString();

               while(caracter.equals("")) {
                  caracter = this.comBase.receiveSingleString();
                  ++ban;
                  if (ban > 35) {
                     if (i == listaPuertos.size() - 1) {
                        ocupado = false;
                     }

                     ban = 0;
                     break;
                  }
               }

               if (!caracter.equalsIgnoreCase("")) {
                  if (caracter.equalsIgnoreCase("#")) {
                     ocupado = true;
                  } else {
                     for(name = name + caracter; ban != 35; name = name + caracter) {
                        ++ban;
                        caracter = this.comBase.receiveSingleString();
                     }

                     if (name.endsWith("OK\r\n") || name.startsWith("AT+VER")) {
                        ocupado = true;
                     }
                  }
                  break;
               }
            }
         } else {
            this.en.PB.setVisible(false);
            this.en.PBLabel.setText("");
            this.en.PBLabel.setVisible(false);
            i = this.en.ShowMessageConfirmDialog("No Hay Puertos COM Libres.<br/>Desea Cargar Histórico de la PC", "Mensaje de Confirmación", "Confirmación");
            if (i == 0) {
               return false;
            }

            System.exit(0);
         }
      } catch (Exception var9) {
      }

      return ocupado;
   }

   public void DetenerGrabacion() {
      String comando = ">0C000000864007F0000000000000S<";

      try {
         String caracter;
         for(caracter = this.comBase.receiveSingleString(); !caracter.equals("#"); caracter = this.comBase.receiveSingleString()) {
         }

         if (caracter.equalsIgnoreCase("#")) {
            this.comBase.sendString(comando, 0);
         }
      } catch (Exception var4) {
         String m = "Error Deteniendo la Grabación del Histórico.";
         this.en.ShowMessage(m, "Information", "Error");
      }

   }

   public void ReanudarGrabacion() {
      String comando = ">0C000000864007F0060000000000S<";

      try {
         String caracter;
         for(caracter = this.comBase.receiveSingleString(); !caracter.equals("#"); caracter = this.comBase.receiveSingleString()) {
         }

         if (caracter.equalsIgnoreCase("#")) {
            this.comBase.sendString(comando, 0);
         }
      } catch (Exception var4) {
         String m = "Error Reanudando la Grabación del Histórico.";
         this.en.ShowMessage(m, "Information", "Error");
      }

   }

   public String BuscarRegistro() {
      String registro = ">0C0";
      boolean inicio = false;
      registro = registro.trim();
      int var3 = 0;

      try {
         String caracter;
         for(caracter = this.comBase.receiveSingleString(); !caracter.equals("#"); caracter = this.comBase.receiveSingleString()) {
         }

         if (caracter.equalsIgnoreCase("#")) {
            this.comBase.sendString(">0C?<", 0);

            while(caracter.equalsIgnoreCase("#")) {
               caracter = this.comBase.receiveSingleString();
            }

            label48:
            while(true) {
               while(true) {
                  if (caracter.equalsIgnoreCase("#")) {
                     break label48;
                  }

                  caracter = this.comBase.receiveSingleString();
                  ++var3;
                  if (caracter.equals("=")) {
                     inicio = true;
                  } else if (inicio && !registro.endsWith("<")) {
                     registro = registro + caracter;
                  } else {
                     inicio = false;
                  }
               }
            }
         }
      } catch (Exception var6) {
         String m = "Error Buscando el Registro.";
         this.en.ShowMessage(m, "Information", "Error");
      }

      if (registro.endsWith("0000000000000M") || registro.endsWith("0000000000000S")) {
         registro = ">0C000000864007F0060000000000S<";
      }

      return registro;
   }

   public String Fecha_Actual() {
      DateFormat dateformat = new SimpleDateFormat("MMddHHmm");
      Date date = new Date();
      String datestr = dateformat.format(date);
      return datestr;
   }

   public double BuscarDistancia() {
      String dist = "";
      boolean inicio = false;
      dist = dist.trim();
      int id = 0;

      try {
         String caracter;
         for(caracter = this.comBase.receiveSingleString(); !caracter.equals("#"); caracter = this.comBase.receiveSingleString()) {
         }

         if (caracter.equalsIgnoreCase("#")) {
            this.comBase.sendString(">E7?1<", 0);

            while(caracter.equalsIgnoreCase("#")) {
               caracter = this.comBase.receiveSingleString();
            }

            label40:
            while(true) {
               while(true) {
                  if (id == 20) {
                     break label40;
                  }

                  caracter = this.comBase.receiveSingleString();
                  ++id;
                  if (caracter.equals("=")) {
                     inicio = true;
                  } else if (inicio && !dist.endsWith("<")) {
                     dist = dist + caracter;
                  } else {
                     inicio = false;
                  }
               }
            }
         }
      } catch (Exception var6) {
         String m = "Error Buscando IdGPS.";
         this.en.ShowMessage(m, "Information", "Error");
      }

      this.dist_recorrida = Double.valueOf(dist.substring(1, dist.length() - 1));
      return this.dist_recorrida;
   }

   public void ResetDistancia() {
      try {
         String caracter;
         for(caracter = this.comBase.receiveSingleString(); !caracter.equals("#"); caracter = this.comBase.receiveSingleString()) {
         }

         if (caracter.equalsIgnoreCase("#")) {
            this.comBase.sendString(">E701<", 0);
         }
      } catch (Exception var3) {
         String m = "Reset Distancia.";
         this.en.ShowMessage(m, "Information", "Error");
      }

   }

   public void DescargarHistorico() throws Exception {
      String[] partes = new String[754];
      StringBuilder lastSix = new StringBuilder();
      StringBuilder fullContent = new StringBuilder();
      this.en.PB.setVisible(true);
      this.en.PBLabel.setVisible(true);
      this.en.PBLabel.setText("Recuperando Registro Histórico...");

      while(this.comBase.receiveSingleString().compareTo("#") != 0) {
         Thread.sleep(1000L);
      }

      this.comBase.sendString(">70<", 0);

      String system;
      while(lastSix.toString().compareTo("******") != 0) {
         char ch = this.comBase.receiveSingleChar();
         if (lastSix.length() == 6) {
            lastSix.deleteCharAt(0);
         }

         if (lastSix.toString().compareTo("DISCO") == 0) {
            this.en.PB.setVisible(true);
            this.en.PBLabel.setVisible(true);
            this.en.PBLabel.setText("Desconexión del Bluetooth...");
            system = System.getProperty("java.io.tmpdir");
            this.en.Insertar_fichero("\nDesconexion del Bluetooth Descargando Histórico a las: " + this.en.Fecha_Hora_Actual() + '\n', new File(system + "DesconexionBluetooth.txt"));
            break;
         }

         lastSix.append(ch);
         fullContent.append(ch);
      }

      try {
         fullContent = fullContent.replace(0, fullContent.indexOf("***"), "");
         system = fullContent.toString().replace("***", "").trim();
         partes = system.split("#");
         int p = (partes.length - 1) / 2;
         String num_trama = partes[0];
         int numero = Integer.parseInt(num_trama.substring(5, num_trama.length()));
         if (numero == p) {
            this.en.PB.setVisible(true);
            this.en.PBLabel.setVisible(true);
            this.en.PBLabel.setText("Salvando Histórico...");
            String nombre = this.en.Fecha_Actual();
            File file = new File("Temp\\" + nombre + ".log");
            if (file.exists()) {
               file.delete();
            }

            file = new File("Temp\\" + nombre + ".log");
            this.en.Insertar_fichero(fullContent.toString(), file);
            this.en.path = file.getPath();
            this.ReanudarGrabacion();
            this.Formatear();
            this.ResetDistancia();
            this.CambiarEstadLed(">7602<");
            this.comBase.close();
         } else {
            this.ReanudarGrabacion();
            this.en.PB.setVisible(false);
            this.en.PBLabel.setText("");
            this.en.PBLabel.setVisible(false);
            int n1 = this.en.ShowMessageConfirmDialog("Ocurrio un Error Descargando la Información.<br/>Desea Volver a Intentar la Descarga del Histórico.", "Mensaje de Confirmación", "Confirmación");
            if (n1 == 0) {
               this.CambiarEstadLed(">7602<");
               this.DescargarHistorico();
            } else {
               this.comBase.close();
            }
         }
      } catch (Exception var11) {
         this.ReanudarGrabacion();
         this.en.PB.setVisible(false);
         this.en.PBLabel.setText("");
         this.en.PBLabel.setVisible(false);
      }

   }
}
