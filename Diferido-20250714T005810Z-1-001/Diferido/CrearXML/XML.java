package Diferido.CrearXML;

import java.io.File;
import java.util.ArrayList;

public class XML {
   public Trayectoria trayectoria = new Trayectoria();
   public ArrayList<DescripcionTrayectoria> descripcion = new ArrayList();
   public File fichero = new File("SalvaTReal.xml");

   public void GuardarDatosTrayecTReal(ArrayList<DescripcionTrayectoria> Trayectoria1) {
      for(int i = 0; i < Trayectoria1.size(); ++i) {
         this.descripcion.add(Trayectoria1.get(i));
      }

      this.trayectoria.setDescripcion_Trayec_list(this.descripcion);
      WriteXML xml = new WriteXML(this.trayectoria);
      xml.createDocument();
      xml.createDOMTree();
      xml.printToFile(this.fichero);
   }

   public void GuardarFechaTReal(DescripcionTrayectoria Trayectoria1) {
      this.trayectoria.getDescripcion_Trayec_list().add(Trayectoria1);
      WriteXML xml = new WriteXML(this.trayectoria);
      xml.createDocument();
      xml.createDOMTree();
      xml.printToFile(this.fichero);
   }

   public void leerXML() {
      XMLParser xmlparser = new XMLParser();
      this.trayectoria = xmlparser.CargarDatos(this.fichero.getAbsolutePath());
   }
}
