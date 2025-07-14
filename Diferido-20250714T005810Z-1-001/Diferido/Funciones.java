package Diferido;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class Funciones {
   boolean fichero_procesado = false;

   public long Fin_Fichero(File fichero) throws FileNotFoundException, IOException {
      KijoFile rafile = new KijoFile(fichero, "rw");
      long inicio = 0L;
      long fin = 100000L;
      long contador = 100000L;
      long puntero = 0L;
      String linea = "";
      String q = "";
      short lon = 140;

      while(true) {
         try {
            rafile.seek(fin);
            rafile.KijoreadLine(lon);
            rafile.seek(rafile.getFilePointer());
            linea = rafile.KijoreadLine(lon);
            if (linea.length() < 150) {
               inicio = fin;
               fin += contador;
            } else if (linea.length() > 150) {
               rafile.seek(inicio);
               rafile.KijoreadLine(lon);
               rafile.seek(rafile.getFilePointer());
               linea = rafile.KijoreadLine(lon);

               while(linea.length() < 150) {
                  linea = rafile.KijoreadLine(lon);
                  rafile.seek(rafile.getFilePointer());
               }

               puntero = rafile.getFilePointer();
               rafile.close();
               return puntero;
            }
         } catch (NullPointerException var17) {
            rafile.esFin = false;
            rafile.seek(inicio);
            rafile.KijoreadLine(lon);
            rafile.seek(rafile.getFilePointer());
            linea = rafile.KijoreadLine(lon);

            try {
               while(linea.length() < 400) {
                  linea = rafile.KijoreadLine(lon);
                  rafile.seek(rafile.getFilePointer());
               }

               puntero = rafile.getFilePointer();
               rafile.close();
               return puntero;
            } catch (Exception var16) {
               puntero = rafile.getFilePointer();
               rafile.close();
               return puntero;
            }
         }
      }
   }

   public void CopiarPorTransferir(File origen, File destino, int cant) throws FileNotFoundException, IOException {
      byte[] bytes = new byte[4096];
      OutputStream os = new FileOutputStream(destino);
      InputStream content = new FileInputStream(origen);
      int lecturas = cant / 4096;
      int resto = cant % 4096;

      for(int i = 0; i < lecturas; ++i) {
         int len = content.read(bytes);
         os.write(bytes, 0, len);
      }

      if (resto > 0) {
         RandomAccessFile rafileorigen = new RandomAccessFile(origen, "rw");
         RandomAccessFile rafiledestino = new RandomAccessFile(destino, "rw");
         int pos = cant - resto;
         rafileorigen.seek((long)pos);
         rafiledestino.seek((long)pos);

         byte b;
         while((b = rafileorigen.readByte()) > 0 && b <= 255 && resto > 0) {
            --resto;
            rafiledestino.writeByte(b);
         }

         rafileorigen.close();
         rafiledestino.close();
      }

      os.close();
      content.close();
   }

   public void CortarTrayectoria(String origen, String destino) {
      try {
         String Comando = "cmd /c move " + origen + " " + destino;
         Process var4 = Runtime.getRuntime().exec(Comando);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }

   public void BorrarTrayectoria(String camino) throws IOException {
      try {
         String Comando = "cmd /c del /Q" + camino;
         Process var3 = Runtime.getRuntime().exec(Comando);
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   public void CrearPlantilla(String directorio, long total_bytes) throws FileNotFoundException, IOException {
      File f = new File(directorio);
      RandomAccessFile rafile = new RandomAccessFile(f, "rw");
      rafile.seek(0L);
      byte[] bytes = new byte[512];
      bytes[511] = 13;
      long len = 0L;

      while(len < total_bytes) {
         rafile.write(bytes);
         len = rafile.getFilePointer();
         rafile.seek(len);
      }

      rafile.close();
   }

   public void MoverTrayectoria(String desdePor_Transferir, String para_Transferida) {
      try {
         String Comando = "cmd /c move " + desdePor_Transferir + " " + para_Transferida;
         Process var4 = Runtime.getRuntime().exec(Comando);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }
}
