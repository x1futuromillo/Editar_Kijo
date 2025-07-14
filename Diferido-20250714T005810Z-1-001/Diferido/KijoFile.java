package Diferido;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class KijoFile extends RandomAccessFile {
   public boolean esFin = false;

   public KijoFile(File file, String mode) throws FileNotFoundException {
      super(file, mode);
   }

   public String KijoreadLine(int lon) throws IOException {
      if (this.esFin) {
         return null;
      } else {
         StringBuffer input = new StringBuffer();
         int c = -1;
         boolean eol = false;

         while(!eol) {
            switch(c = this.read()) {
            case -1:
            case 10:
               eol = true;
               break;
            case 0:
               eol = true;
               this.esFin = true;
               break;
            case 13:
               eol = true;
               long cur = this.getFilePointer();
               if (this.read() != 10) {
                  this.seek(cur);
               }
               break;
            default:
               input.append((char)c);
               if (input.length() == lon) {
                  eol = true;
               }
            }
         }

         if (c == -1 && input.length() == 0) {
            return null;
         } else {
            return input.toString();
         }
      }
   }
}
