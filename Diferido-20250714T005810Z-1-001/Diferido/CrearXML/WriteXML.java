package Diferido.CrearXML;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXML {
   private Document dom;
   Trayectoria xml;

   public WriteXML(Trayectoria xmlE) {
      this.xml = xmlE;
   }

   public void createDocument() {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      try {
         DocumentBuilder db = dbf.newDocumentBuilder();
         this.dom = db.newDocument();
      } catch (ParserConfigurationException var3) {
         System.out.println("Error while trying to instantiate DocumentBuilder " + var3);
         System.exit(1);
      }

   }

   public void createDOMTree() {
      Element rootEle = this.dom.createElement("TrayectoriasTReal");
      this.dom.appendChild(rootEle);
      Iterator it = this.xml.getDescripcion_Trayec_list().iterator();

      while(it.hasNext()) {
         DescripcionTrayectoria t = (DescripcionTrayectoria)it.next();
         Element clEle = this.createElement(t);
         rootEle.appendChild(clEle);
      }

   }

   private Element createElement(DescripcionTrayectoria Trayectoria) {
      Element colEle = this.dom.createElement("TrayectoriaEnviada");
      Element iDgpsEle = this.dom.createElement("IDGPS");
      iDgpsEle.appendChild(this.dom.createTextNode(Trayectoria.getIDGPS()));
      Element chapaEle = this.dom.createElement("Chapa");
      chapaEle.appendChild(this.dom.createTextNode(Trayectoria.getChapa()));
      Element fechaFinEle = this.dom.createElement("FechaFin");
      fechaFinEle.appendChild(this.dom.createTextNode(Trayectoria.getFechaFin()));
      colEle.appendChild(iDgpsEle);
      colEle.appendChild(chapaEle);
      colEle.appendChild(fechaFinEle);
      return colEle;
   }

   public void printToFile(File f) {
      try {
         OutputFormat format = new OutputFormat(this.dom);
         format.setIndenting(true);
         XMLSerializer serializer = new XMLSerializer(new FileOutputStream(f), format);
         serializer.serialize(this.dom);
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }
}
