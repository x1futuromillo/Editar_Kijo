package Diferido;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class LogFilter extends FileFilter {
   public boolean accept(File f) {
      return f.isDirectory() || f.getName().toLowerCase().endsWith(".log");
   }

   public String getDescription() {
      return "Log files";
   }
}
