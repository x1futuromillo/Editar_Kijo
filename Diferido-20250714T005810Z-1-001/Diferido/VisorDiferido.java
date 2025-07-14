package Diferido;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.xml.parsers.ParserConfigurationException;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.geotools.ows.ServiceException;
import org.geotools.swing.StatusBar;
import org.geotools.swing.action.PanAction;
import org.geotools.swing.action.ResetAction;
import org.geotools.swing.action.ZoomInAction;
import org.geotools.swing.action.ZoomOutAction;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.xml.sax.SAXException;

public class VisorDiferido extends JFrame {
   boolean toolAdd = false;
   StatusBar status;
   MapFrame mapFrame = null;
   private ReferencedEnvelope fullExtent;
   Datos_Hoja_de_Ruta hruta;
   private JPanel jPanel1;
   private JPanel jPanel2;
   private JTabbedPane jTabbedPane1;
   private JToolBar jToolBar1;
   private JPanel mainPanel;
   private JMenuBar menuBar;

   public VisorDiferido(Datos_Hoja_de_Ruta hruta) throws ParserConfigurationException, SAXException, IOException {
      this.initComponents();
      File dir_imagen = new File("test-data/diferido install.png");
      URL img = dir_imagen.toURI().toURL();
      this.setIconImage((new ImageIcon(img)).getImage());
      this.hruta = hruta;
      this.setLocationRelativeTo((Component)null);
      File shape_base = new File("shapebase/ProvinciasCuba.shp");
      this.mapPaint(shape_base);
      this.fullExtent = new ReferencedEnvelope(this.hruta.en.minx, this.hruta.en.maxx, this.hruta.en.miny, this.hruta.en.maxy, this.mapFrame.map.getCoordinateReferenceSystem());
      this.mapFrame.map.setAreaOfInterest(this.fullExtent);
      File munic = new File("shapebase/MunicipiosCuba.shp");
      File sldmunic = new File("sldbase/MunicipiosCuba.sld");
      File poblados = new File("shapebase/PuntosPoblados.shp");
      File sldpoblados = new File("sldbase/PuntosPoblados.sld");
      File manzanas = new File("shapebase/ManzanasCuba.shp");
      File sldmanzanas = new File("sldbase/manzanas.sld");
      File sldtrayec = new File("sldbase/sldMW.sld");
      File shapefile_trayec = new File(this.hruta.en.camino_trayec);
      File shapefile_detenc = new File(this.hruta.camino_deten);
      File shapefile_desc = new File(this.hruta.camino_desco);
      this.mapFrame.addLayer(munic, sldmunic);
      this.mapFrame.addLayer(poblados, sldpoblados);
      this.mapFrame.addLayer(manzanas, sldmanzanas);
      this.mapFrame.addLayer(shapefile_trayec, sldtrayec);
      this.mapFrame.addLayerDetenciones(shapefile_detenc);
      this.mapFrame.addLayerDesconexion(shapefile_desc);
      this.status = new StatusBar(this.mapFrame.mp);
      this.status.setPreferredSize(new Dimension(200, 20));
      this.status.setBackground(new Color(201, 231, 221));
      this.status.getComponent(1).setVisible(false);
      this.status.getComponent(2).setVisible(false);
      this.toolbarConfig();
   }

   private void mapPaint(File file) throws FileNotFoundException, MalformedURLException, IOException, ServiceException {
      this.mapFrame = new MapFrame(file);
      this.jPanel2.removeAll();
      this.mapFrame.mp.setSize(this.jPanel2.getWidth(), this.jPanel2.getHeight());
      this.jPanel2.add(this.mapFrame.mp, "Center");
      this.jPanel2.doLayout();
      this.jPanel2.repaint();
   }

   private void toolbarConfig() {
      if (!this.toolAdd) {
         ZoomInAction ZoomIn = new ZoomInAction(this.mapFrame.mp);
         ZoomIn.putValue("ShortDescription", "Aumentar el Mapa");
         JButton zIn = new JButton(ZoomIn);
         zIn.setText("Aumentar");
         zIn.setBackground(new Color(201, 231, 221));
         ZoomOutAction ZoomOut = new ZoomOutAction(this.mapFrame.mp);
         ZoomOut.putValue("ShortDescription", "Disminuir el Mapa");
         JButton zOut = new JButton(ZoomOut);
         zOut.setText("Disminuir");
         zOut.setBackground(new Color(201, 231, 221));
         PanAction pan = new PanAction(this.mapFrame.mp);
         pan.putValue("ShortDescription", "Mover el Mapa");
         JButton p = new JButton(pan);
         p.setText("Mover");
         p.setBackground(new Color(201, 231, 221));
         ResetAction reset = new ResetAction(this.mapFrame.mp);
         reset.putValue("ShortDescription", "Ver Todo el Mapa");
         JButton r = new JButton(reset);
         r.setText("VerTodo");
         r.setBackground(new Color(201, 231, 221));
         this.jToolBar1.add(zIn);
         this.jToolBar1.addSeparator();
         this.jToolBar1.add(zOut);
         this.jToolBar1.addSeparator();
         this.jToolBar1.add(p);
         this.jToolBar1.addSeparator();
         this.jToolBar1.add(r);
         this.jToolBar1.addSeparator();
         this.jToolBar1.add(this.status);
         this.toolAdd = true;
      }

   }

   private void initComponents() {
      this.mainPanel = new JPanel();
      this.jTabbedPane1 = new JTabbedPane();
      this.jPanel1 = new JPanel();
      this.jToolBar1 = new JToolBar();
      this.jPanel2 = new JPanel();
      this.menuBar = new JMenuBar();
      this.setTitle("VisorDiferido");
      this.setBackground(new Color(201, 231, 221));
      this.setResizable(false);
      this.addWindowListener(new WindowAdapter() {
         public void windowClosed(WindowEvent evt) {
            VisorDiferido.this.formWindowClosed(evt);
         }
      });
      this.getContentPane().setLayout(new AbsoluteLayout());
      this.mainPanel.setBackground(new Color(201, 231, 221));
      this.mainPanel.setPreferredSize(new Dimension(850, 654));
      this.mainPanel.addComponentListener(new ComponentAdapter() {
         public void componentResized(ComponentEvent evt) {
            VisorDiferido.this.mainPanelComponentResized(evt);
         }
      });
      this.mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            VisorDiferido.this.mainPanelMouseMoved(evt);
         }
      });
      this.jTabbedPane1.setBackground(new Color(201, 231, 221));
      this.jTabbedPane1.setAlignmentX(0.0F);
      this.jTabbedPane1.setAlignmentY(0.0F);
      this.jTabbedPane1.setPreferredSize(new Dimension(830, 400));
      this.jPanel1.setBackground(new Color(201, 231, 221));
      this.jPanel1.setPreferredSize(new Dimension(830, 627));
      this.jToolBar1.setBackground(new Color(201, 231, 221));
      this.jToolBar1.setRollover(true);
      this.jPanel2.setBackground(new Color(255, 255, 255));
      this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
      this.jPanel2.setAlignmentX(0.0F);
      this.jPanel2.setAlignmentY(0.0F);
      this.jPanel2.setAutoscrolls(true);
      this.jPanel2.setPreferredSize(new Dimension(800, 412));
      GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
      this.jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGap(0, 914, 32767));
      jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGap(0, 582, 32767));
      GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
      this.jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jToolBar1, -2, 797, -2).addComponent(this.jPanel2, -1, 918, 32767)).addContainerGap()));
      jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jToolBar1, -2, 30, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jPanel2, -1, 586, 32767).addContainerGap()));
      this.jTabbedPane1.addTab("Visor de Mapa", this.jPanel1);
      GroupLayout mainPanelLayout = new GroupLayout(this.mainPanel);
      this.mainPanel.setLayout(mainPanelLayout);
      mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -2, 943, -2).addContainerGap(17, 32767)));
      mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -1, 658, 32767).addContainerGap()));
      this.getContentPane().add(this.mainPanel, new AbsoluteConstraints(0, 0, 970, 680));
      this.menuBar.setBackground(new Color(201, 231, 221));
      this.setJMenuBar(this.menuBar);
      this.pack();
   }

   private void mainPanelComponentResized(ComponentEvent evt) {
      if (this.mapFrame != null) {
         this.mapFrame.mp.setSize(this.jPanel2.getWidth(), this.jPanel2.getHeight());
         this.mapFrame.mp.repaint();
      }

   }

   private void mainPanelMouseMoved(MouseEvent evt) {
   }

   private void formWindowClosed(WindowEvent evt) {
   }
}
