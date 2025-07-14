package Diferido;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.Hints;
import org.geotools.map.DefaultMapContext;
import org.geotools.map.MapContext;
import org.geotools.renderer.lite.StreamingRenderer;
import org.geotools.styling.ExternalGraphic;
import org.geotools.styling.FeatureTypeStyle;
import org.geotools.styling.Fill;
import org.geotools.styling.Graphic;
import org.geotools.styling.LineSymbolizer;
import org.geotools.styling.Mark;
import org.geotools.styling.PointSymbolizer;
import org.geotools.styling.PolygonSymbolizer;
import org.geotools.styling.Rule;
import org.geotools.styling.SLD;
import org.geotools.styling.SLDParser;
import org.geotools.styling.Style;
import org.geotools.styling.StyleFactory;
import org.geotools.swing.JMapPane;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.FeatureType;
import org.opengis.filter.FilterFactory;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

public class MapFrame {
   static StyleFactory styleFactory = CommonFactoryFinder.getStyleFactory((Hints)null);
   static FilterFactory filterFactory = CommonFactoryFinder.getFilterFactory((Hints)null);
   public MapContext map;
   public JMapPane mp;
   FeatureSource featureBase;
   FeatureSource featureSource;

   public MapFrame(File file) throws FileNotFoundException, MalformedURLException, IOException {
      ShapefileDataStore shapebase = new ShapefileDataStore(file.toURL());
      this.featureBase = shapebase.getFeatureSource();
      FeatureType schemabase = this.featureBase.getSchema();
      CoordinateReferenceSystem crs = schemabase.getCoordinateReferenceSystem();
      this.map = new DefaultMapContext(crs);
      File sldFile = new File("sldbase/ProvinciasCuba.sld");
      Style styleBase = createFromSLD(sldFile);
      this.map.addLayer(this.featureBase, styleBase);
      this.showMap(this.map);
   }

   public void addLayer(File Layer) throws MalformedURLException, IOException {
      ShapefileDataStore shapeLayer = new ShapefileDataStore(Layer.toURL());
      this.featureSource = shapeLayer.getFeatureSource();
      Style style = createPointStyle();
      if (this.map.getLayerCount() > 1) {
         this.map.removeLayer(1);
      }

      this.map.addLayer(this.featureSource, style);
   }

   public void addLayer(File Layer, File Sld) throws MalformedURLException, IOException {
      ShapefileDataStore shapeLayer = new ShapefileDataStore(Layer.toURL());
      this.featureSource = shapeLayer.getFeatureSource();
      Style style = createFromSLD(Sld);
      this.map.addLayer(this.featureSource, style);
   }

   public void addLayerDetenciones(File Layer) throws MalformedURLException, IOException {
      ShapefileDataStore shapeLayer = new ShapefileDataStore(Layer.toURL());
      this.featureSource = shapeLayer.getFeatureSource();
      Style style = externalGraphicStyle();
      this.map.addLayer(this.featureSource, style);
   }

   public void addLayerDesconexion(File Layer) throws MalformedURLException, IOException {
      ShapefileDataStore shapeLayer = new ShapefileDataStore(Layer.toURL());
      this.featureSource = shapeLayer.getFeatureSource();
      Style style = createLineStyle();
      this.map.addLayer(this.featureSource, style);
   }

   private static Style createStyle(File file, SimpleFeatureType schema) throws MalformedURLException {
      File sld = toSLDFile(file);
      if (sld.exists()) {
         return createFromSLD(sld);
      } else {
         Class type = schema.getBinding();
         if (!type.isAssignableFrom(Polygon.class) && !type.isAssignableFrom(MultiPolygon.class)) {
            return !type.isAssignableFrom(LineString.class) && !type.isAssignableFrom(MultiLineString.class) ? createPointStyle() : createLineStyle();
         } else {
            return createPolygonStyle();
         }
      }
   }

   public static Style createFromSLD(File sld) {
      try {
         SLDParser stylereader = new SLDParser(styleFactory, sld.toURL());
         Style[] style = stylereader.readXML();
         return style[0];
      } catch (Exception var3) {
         JOptionPane.showMessageDialog((Component)null, var3.getMessage());
         System.exit(0);
         return null;
      }
   }

   private static Style createPointStyle() {
      Graphic gr = styleFactory.createDefaultGraphic();
      Mark mk = styleFactory.getTriangleMark();
      mk.setStroke(styleFactory.createStroke(filterFactory.literal("#000000"), filterFactory.literal(1)));
      mk.setFill(styleFactory.createFill(filterFactory.literal("#000000")));
      gr.setMarks(new Mark[]{mk});
      PointSymbolizer sym = styleFactory.createPointSymbolizer(gr, (String)null);
      sym.getGraphic().setSize(filterFactory.literal(10));
      Rule rule = styleFactory.createRule();
      rule.symbolizers().add(sym);
      FeatureTypeStyle fts = styleFactory.createFeatureTypeStyle();
      fts.setRules(new Rule[]{rule});
      Style style = styleFactory.createStyle();
      style.addFeatureTypeStyle(fts);
      return style;
   }

   public static Style externalGraphicStyle() throws MalformedURLException {
      Mark mk = styleFactory.createMark();
      PointSymbolizer symbolizer = styleFactory.createPointSymbolizer();
      File imagen = new File("test-data/");
      URL url = imagen.toURI().toURL();
      ExternalGraphic eg = styleFactory.createExternalGraphic(url + "detenciones_globe_red.png", "image/png");
      symbolizer.getGraphic().addExternalGraphic(eg);
      symbolizer.getGraphic().setSize(filterFactory.literal(18));
      Rule rule = styleFactory.createRule();
      rule.symbolizers().add(symbolizer);
      FeatureTypeStyle fts = styleFactory.createFeatureTypeStyle();
      fts.setRules(new Rule[]{rule});
      Style style = styleFactory.createStyle();
      style.addFeatureTypeStyle(fts);
      return style;
   }

   private static Style createPointStyleTrayect() {
      Graphic gr = styleFactory.createDefaultGraphic();
      Mark mk = styleFactory.getTriangleMark();
      mk.setStroke(styleFactory.createStroke(filterFactory.literal("#0000ff"), filterFactory.literal(1)));
      mk.setFill(styleFactory.createFill(filterFactory.literal("#0000ff")));
      gr.setMarks(new Mark[]{mk});
      PointSymbolizer sym = styleFactory.createPointSymbolizer(gr, (String)null);
      sym.getGraphic().setSize(filterFactory.literal(1));
      Rule rule = styleFactory.createRule();
      rule.symbolizers().add(sym);
      FeatureTypeStyle fts = styleFactory.createFeatureTypeStyle();
      fts.setRules(new Rule[]{rule});
      Style style = styleFactory.createStyle();
      style.addFeatureTypeStyle(fts);
      return style;
   }

   private static Style createLineStyle() {
      LineSymbolizer symbolizer = styleFactory.createLineSymbolizer();
      SLD.setLineColour(symbolizer, Color.RED);
      symbolizer.getStroke().setWidth(filterFactory.literal(3));
      symbolizer.getStroke().setWidth(filterFactory.literal(3));
      symbolizer.getStroke().setColor(filterFactory.literal("#ff0000"));
      Rule rule = styleFactory.createRule();
      rule.symbolizers().add(symbolizer);
      FeatureTypeStyle fts = styleFactory.createFeatureTypeStyle();
      fts.setRules(new Rule[]{rule});
      Style style = styleFactory.createStyle();
      style.addFeatureTypeStyle(fts);
      return style;
   }

   private static Style createPolygonStyle() {
      PolygonSymbolizer symbolizer = styleFactory.createPolygonSymbolizer();
      Fill fill = styleFactory.createFill(filterFactory.literal("#FFAA00"), filterFactory.literal(0.5D));
      symbolizer.setFill(fill);
      symbolizer.setStroke(styleFactory.createStroke(filterFactory.literal("#000000"), filterFactory.literal(1)));
      Rule rule = styleFactory.createRule();
      rule.symbolizers().add(symbolizer);
      FeatureTypeStyle fts = styleFactory.createFeatureTypeStyle();
      fts.setRules(new Rule[]{rule});
      Style style = styleFactory.createStyle();
      style.addFeatureTypeStyle(fts);
      return style;
   }

   private void showMap(MapContext map) throws IOException {
      this.mp = new JMapPane(new StreamingRenderer(), map);
      this.mp.setMapContext(map);
      this.mp.setBackground(Color.WHITE);
   }

   public static File toSLDFile(File file) {
      String filename = file.getAbsolutePath();
      if (!filename.endsWith(".shp") && !filename.endsWith(".dbf") && !filename.endsWith(".shx")) {
         if (filename.endsWith(".SLD") || filename.endsWith(".SLD") || filename.endsWith(".SLD")) {
            filename = filename.substring(0, filename.length() - 4);
            filename = filename + ".SLD";
         }
      } else {
         filename = filename.substring(0, filename.length() - 4);
         filename = filename + ".sld";
      }

      return new File(filename);
   }

   public void setCRS(CoordinateReferenceSystem crs) {
      this.mp.getMapContext().setAreaOfInterest(this.mp.getMapContext().getAreaOfInterest(), crs);
      this.mp.reset();
      this.mp.repaint();
   }
}
