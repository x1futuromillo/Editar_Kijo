package Diferido;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Comprimir {
   private String m_basePath = null;
   private File m_dir = null;
   private String m_OutputFileName;

   public Comprimir(File directory, String outputFileName) {
      this.m_dir = directory;
      this.m_OutputFileName = outputFileName;
   }

   public void compress() throws Exception {
      try {
         FileOutputStream zipFilename = new FileOutputStream(this.m_OutputFileName);
         ZipOutputStream zipoutputstream = new ZipOutputStream(zipFilename);
         this.m_basePath = this.m_dir.getPath();
         this.CompressDir(this.m_dir, zipoutputstream);
         zipoutputstream.setMethod(8);
         zipoutputstream.close();
         zipFilename.close();
      } catch (Exception var3) {
         throw new Exception("Ocurrió un error durante la compresión: " + var3);
      }
   }

   private void CompressDir(File f, ZipOutputStream zipoutputstream) {
      if (f.isDirectory()) {
         File[] files = f.listFiles();

         for(int i = 0; i < files.length; ++i) {
            if (files[i].isDirectory()) {
            }

            if (files[i].isFile()) {
               this.addOneFile(files[i], zipoutputstream);
            }
         }
      }

   }

   private void addOneFile(File file, ZipOutputStream zipoutputstream) {
      ZipEntry zipentry = new ZipEntry(file.getPath().substring(this.m_basePath.length() + 1));
      CRC32 crc32 = new CRC32();
      byte[] rgb = new byte[1024];

      FileInputStream fileinputstream;
      int n;
      try {
         fileinputstream = new FileInputStream(file);

         while((n = fileinputstream.read(rgb)) > -1) {
            crc32.update(rgb, 0, n);
         }

         fileinputstream.close();
      } catch (Exception var10) {
         System.out.println("Error in computing CRC:");
         var10.printStackTrace();
      }

      zipentry.setSize(file.length());
      zipentry.setTime(file.lastModified());
      zipentry.setCrc(crc32.getValue());

      try {
         zipoutputstream.putNextEntry(zipentry);
         fileinputstream = new FileInputStream(file);

         while((n = fileinputstream.read(rgb)) > -1) {
            zipoutputstream.write(rgb, 0, n);
         }

         fileinputstream.close();
         zipoutputstream.closeEntry();
      } catch (Exception var9) {
         System.out.println("Error in writing data:");
         var9.printStackTrace();
      }

   }
}
