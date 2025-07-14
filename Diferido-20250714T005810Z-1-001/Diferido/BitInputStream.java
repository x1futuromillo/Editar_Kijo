package Diferido;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BitInputStream extends InputStream {
   private InputStream myInput;
   private int myBitCount;
   private int myBuffer;
   private File myFile;
   private static final int[] bmask = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   private static final int BITS_PER_BYTE = 8;

   public BitInputStream(String filename) {
      this(new File(filename));
   }

   public BitInputStream(File file) {
      this.myFile = file;

      try {
         this.reset();
      } catch (IOException var3) {
         throw new RuntimeException("could not open file for reading bits " + var3);
      }
   }

   public BitInputStream(InputStream in) {
      this.myInput = in;
      this.myFile = null;
   }

   public boolean markSupported() {
      return this.myFile != null;
   }

   public void reset() throws IOException {
      if (!this.markSupported()) {
         throw new IOException("not resettable");
      } else {
         try {
            this.close();
            this.myInput = new BufferedInputStream(new FileInputStream(this.myFile));
         } catch (FileNotFoundException var2) {
            System.err.println("error opening " + this.myFile.getName() + " " + var2);
         }

         this.myBuffer = this.myBitCount = 0;
      }
   }

   public void close() {
      try {
         if (this.myInput != null) {
            this.myInput.close();
         }

      } catch (IOException var2) {
         throw new RuntimeException("error closing bit stream " + var2);
      }
   }

   public int readBits(int howManyBits) throws IOException {
      int retval = 0;
      if (this.myInput == null) {
         return -1;
      } else {
         for(; howManyBits > this.myBitCount; this.myBitCount = 8) {
            retval |= this.myBuffer << howManyBits - this.myBitCount;
            howManyBits -= this.myBitCount;

            try {
               if ((this.myBuffer = this.myInput.read()) == -1) {
                  return -1;
               }
            } catch (IOException var4) {
               throw new IOException("bitreading trouble " + var4);
            }
         }

         if (howManyBits > 0) {
            retval |= this.myBuffer >> this.myBitCount - howManyBits;
            this.myBuffer &= bmask[this.myBitCount - howManyBits];
            this.myBitCount -= howManyBits;
         }

         return retval;
      }
   }

   public int read() throws IOException {
      return this.readBits(8);
   }

   public void resetFile() {
      this.myBuffer = this.myBitCount = 0;
   }
}
