package Diferido.CrearXML;

import java.util.ArrayList;

public class Trayectoria {
   private ArrayList<DescripcionTrayectoria> descripcion_Trayec_list = new ArrayList();

   public ArrayList<DescripcionTrayectoria> getDescripcion_Trayec_list() {
      return this.descripcion_Trayec_list;
   }

   public void setDescripcion_Trayec_list(ArrayList<DescripcionTrayectoria> descripcion_Trayec_list) {
      this.descripcion_Trayec_list = descripcion_Trayec_list;
   }
}
