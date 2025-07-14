package Diferido.CrearXML;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {
   Document dom;

   public Trayectoria CargarDatos(String path) {
      this.parseXmlFile(path);
      return this.parseDocument();
   }

   private void parseXmlFile(String path) {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      try {
         DocumentBuilder db = dbf.newDocumentBuilder();
         this.dom = db.parse(path);
      } catch (ParserConfigurationException var4) {
         var4.printStackTrace();
      } catch (SAXException var5) {
         var5.printStackTrace();
      } catch (IOException var6) {
         var6.printStackTrace();
      }

   }

   private Trayectoria parseDocument() {
      Element xmlEle = this.dom.getDocumentElement();
      Trayectoria xml = new Trayectoria();
      ArrayList<DescripcionTrayectoria> TrayectoriaList = new ArrayList();
      NodeList nTms = xmlEle.getElementsByTagName("TrayectoriaEnviada");
      if (nTms != null && nTms.getLength() > 0) {
         for(int i = 0; i < nTms.getLength(); ++i) {
            TrayectoriaList.add(this.getTrayectoriaEnviada((Element)nTms.item(i)));
         }
      }

      xml.setDescripcion_Trayec_list(TrayectoriaList);
      return xml;
   }

   private DescripcionTrayectoria getTrayectoriaEnviada(Element el) {
      DescripcionTrayectoria descripcionTrayectoria = new DescripcionTrayectoria();
      descripcionTrayectoria.setIDGPS(this.getTextValue(el, "IDGPS"));
      descripcionTrayectoria.setChapa(this.getTextValue(el, "Chapa"));
      descripcionTrayectoria.setFechaFin(this.getTextValue(el, "FechaFin"));
      return descripcionTrayectoria;
   }

   private String getTextValue(Element ele, String tagName) {
      String textVal = null;
      NodeList nl = ele.getElementsByTagName(tagName);
      if (nl != null && nl.getLength() > 0) {
         Element el = (Element)nl.item(0);
         textVal = el.getFirstChild().getNodeValue();
      }

      return textVal;
   }

   private int getIntValue(Element ele, String tagName) {
      return Integer.parseInt(this.getTextValue(ele, tagName));
   }
}
