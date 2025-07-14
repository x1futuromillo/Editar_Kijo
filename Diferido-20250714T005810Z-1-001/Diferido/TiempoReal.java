package Diferido;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TiempoReal {
   File mifile;
   Entrada en;

   public TiempoReal(Entrada en) {
      this.en = en;
   }

   public void LeerBinario(File binario) throws IOException, IOException {
      this.en.PB.setVisible(true);
      this.en.PBLabel.setText("Lectura del Registro Histórico...");
      this.en.PBLabel.setVisible(true);
      System.out.println("Lectura del Registro Histórico...");
      this.mifile = new File("Temp\\TextoBinario.xml");
      boolean finArchivo = false;
      FileInputStream fis = null;
      System.out.println("start");

      try {
         if (binario.length() <= 0L) {
            this.en.ShowMessage("No Fue Posible Descargar los Datos de Trayectoria para el Móvil " + this.en.Chapa.getText() + ".", "Información", "Information");
            System.exit(0);
         }

         fis = new FileInputStream(binario);
         DataInputStream dis = new DataInputStream(fis);
         System.out.println("asig");

         while(!finArchivo) {
            String iddevice = "";

            char c;
            for(c = dis.readChar(); c != ';'; c = dis.readChar()) {
               iddevice = iddevice + c;
            }

            String date = "";

            for(c = dis.readChar(); c != ';'; c = dis.readChar()) {
               date = date + c;
            }

            double lon = dis.readDouble();
            double lat = dis.readDouble();
            float speed = dis.readFloat();
            float spin = dis.readFloat();
            double km = dis.readDouble();
            String cod_alarma = "";

            for(c = dis.readChar(); c != ';'; c = dis.readChar()) {
               cod_alarma = cod_alarma + c;
            }

            String cad = iddevice + "," + date + "," + spin + "," + lat + "," + lon + "," + speed + "," + km + "," + cod_alarma + "\n";
            this.en.Insertar_fichero(cad, this.mifile);
            System.out.println(cad);
         }

         dis.close();
         System.out.println("end");
      } catch (Exception var19) {
         System.out.println("Error al leer");
         finArchivo = true;
         fis.close();
      }

   }
}
