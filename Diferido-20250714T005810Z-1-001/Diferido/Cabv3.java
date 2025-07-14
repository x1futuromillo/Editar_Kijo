package Diferido;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.bind.DatatypeConverter;

public class Cabv3 {
   File mifilecabv3;
   Entrada en;

   public Cabv3(Entrada en) {
      this.en = en;
   }

   public String Descodificar_Fichero(File origen) throws FileNotFoundException, IOException {
      FileReader fr = new FileReader(origen);
      BufferedReader br = new BufferedReader(fr);

      try {
         String linea;
         String linea_decodificada;
         for(linea_decodificada = ""; (linea = br.readLine()) != null; linea_decodificada = linea_decodificada + this.Base64_Decode(linea)) {
         }

         br.close();
         fr.close();
         return linea_decodificada;
      } catch (Exception var6) {
         var6.printStackTrace();
         br.close();
         fr.close();
         return null;
      }
   }

   public void LeerCabv3(File cabv3) throws FileNotFoundException, IOException {
      this.mifilecabv3 = new File("Temp\\TextoBase64.xml");
      FileReader fr = new FileReader(cabv3);
      BufferedReader br = new BufferedReader(fr);

      try {
         String linea_decodificada = "";

         String linea;
         while((linea = br.readLine()) != null) {
            linea_decodificada = this.Base64_Decode(linea);
            this.en.Insertar_fichero(linea_decodificada, this.mifilecabv3);
         }

         br.close();
         fr.close();
      } catch (IOException var6) {
         br.close();
         fr.close();
      }

   }

   public String Base64_Encode(String value) {
      String encoded = DatatypeConverter.printBase64Binary(value.getBytes());
      return encoded;
   }

   public String Base64_Decode(String value) {
      String decoded = new String(DatatypeConverter.parseBase64Binary(value));
      return decoded;
   }

   public String getStare(String state) {
      String bin = this.concatCero(Integer.toBinaryString(Integer.parseInt(state, 16)), 16);
      return bin;
   }

   private String concatCero(String stringvalue, int lenght) {
      String start = "";

      for(int i = stringvalue.length(); i < lenght; ++i) {
         start = start.concat("0");
      }

      return start.concat(stringvalue);
   }
}
