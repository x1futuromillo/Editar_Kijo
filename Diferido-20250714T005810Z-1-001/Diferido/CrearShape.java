package Diferido;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.geotools.data.FeatureWriter;
import org.geotools.data.Transaction;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.Hints;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

public class CrearShape {
   GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory((Hints)null);
   SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(this.createFeatureType());
   SimpleFeatureBuilder featureBuilderTarjeta = new SimpleFeatureBuilder(this.createFeatureTypeTarjeta());
   SimpleFeatureBuilder featureBuilderGPSE = new SimpleFeatureBuilder(this.createFeatureTypeGPSE());
   SimpleFeatureBuilder featureBuilderTReal = new SimpleFeatureBuilder(this.createFeatureTypeTReal());
   SimpleFeatureBuilder featureBuilderCabv3 = new SimpleFeatureBuilder(this.createFeatureTypeCabv3());
   SimpleFeatureBuilder featureBuilderDet = new SimpleFeatureBuilder(this.createFeatureTypeDetenciones());
   SimpleFeatureBuilder featureBuilderDesc = new SimpleFeatureBuilder(this.createFeatureTypeDesconexiones());
   SimpleFeatureBuilder featureBuilderViolaciones = new SimpleFeatureBuilder(this.createFeatureTypeViolacionesVeloc());
   FeatureWriter outFeatureWriter;
   ShapefileDataStore outStore;
   FeatureWriter outFeatureWriter1;
   ShapefileDataStore outStore1;

   public void initFeatureWriter(String shpURL) throws MalformedURLException {
      try {
         this.outStore = new ShapefileDataStore((new File(shpURL)).toURI().toURL());
         this.outStore.createSchema(this.createFeatureType());
         this.outFeatureWriter = this.outStore.getFeatureWriter(this.outStore.getTypeNames()[0], Transaction.AUTO_COMMIT);
      } catch (Exception var3) {
         var3.getMessage();
      }

   }

   public void initFeatureWriterTarjeta(String shpURL) throws MalformedURLException {
      try {
         this.outStore1 = new ShapefileDataStore((new File(shpURL)).toURI().toURL());
         this.outStore1.createSchema(this.createFeatureTypeTarjeta());
         this.outFeatureWriter1 = this.outStore1.getFeatureWriter(this.outStore1.getTypeNames()[0], Transaction.AUTO_COMMIT);
      } catch (Exception var3) {
         var3.getMessage();
      }

   }

   public void initFeatureWriterGPSE(String shpURL) throws MalformedURLException {
      try {
         this.outStore1 = new ShapefileDataStore((new File(shpURL)).toURI().toURL());
         this.outStore1.createSchema(this.createFeatureTypeGPSE());
         this.outFeatureWriter1 = this.outStore1.getFeatureWriter(this.outStore1.getTypeNames()[0], Transaction.AUTO_COMMIT);
      } catch (Exception var3) {
         var3.getMessage();
      }

   }

   public void initFeatureWriterTReal(String shpURL) throws MalformedURLException {
      try {
         this.outStore1 = new ShapefileDataStore((new File(shpURL)).toURI().toURL());
         this.outStore1.createSchema(this.createFeatureTypeTReal());
         this.outFeatureWriter1 = this.outStore1.getFeatureWriter(this.outStore1.getTypeNames()[0], Transaction.AUTO_COMMIT);
      } catch (Exception var3) {
         var3.getMessage();
      }

   }

   public void initFeatureWriterCabv3(String shpURL) throws MalformedURLException {
      try {
         this.outStore1 = new ShapefileDataStore((new File(shpURL)).toURI().toURL());
         this.outStore1.createSchema(this.createFeatureTypeCabv3());
         this.outFeatureWriter1 = this.outStore1.getFeatureWriter(this.outStore1.getTypeNames()[0], Transaction.AUTO_COMMIT);
      } catch (Exception var3) {
         var3.getMessage();
      }

   }

   public void initFeatureWriterDetenciones(String shpURL) throws MalformedURLException {
      try {
         this.outStore = new ShapefileDataStore((new File(shpURL)).toURI().toURL());
         this.outStore.createSchema(this.createFeatureTypeDetenciones());
         this.outFeatureWriter = this.outStore.getFeatureWriter(this.outStore.getTypeNames()[0], Transaction.AUTO_COMMIT);
      } catch (Exception var3) {
         var3.getMessage();
      }

   }

   public void initFeatureWriterViolaciones(String shpURL) throws MalformedURLException {
      try {
         this.outStore = new ShapefileDataStore((new File(shpURL)).toURI().toURL());
         this.outStore.createSchema(this.createFeatureTypeViolacionesVeloc());
         this.outFeatureWriter = this.outStore.getFeatureWriter(this.outStore.getTypeNames()[0], Transaction.AUTO_COMMIT);
      } catch (Exception var3) {
         var3.getMessage();
      }

   }

   public void initFeatureWriterDesconexiones(String shpURL) throws MalformedURLException {
      try {
         this.outStore = new ShapefileDataStore((new File(shpURL)).toURI().toURL());
         this.outStore.createSchema(this.createFeatureTypeDesconexiones());
         this.outFeatureWriter = this.outStore.getFeatureWriter(this.outStore.getTypeNames()[0], Transaction.AUTO_COMMIT);
      } catch (Exception var3) {
         var3.getMessage();
      }

   }

   public void closeFeatureWriter() {
      try {
         this.outFeatureWriter.close();
         this.outFeatureWriter = null;
         this.outStore.dispose();
         this.outStore = null;
         System.gc();
      } catch (IOException var2) {
         var2.getMessage();
      }

   }

   public void closeFeatureWriter1() {
      try {
         this.outFeatureWriter1.close();
         this.outFeatureWriter1 = null;
         this.outStore1.dispose();
         this.outStore1 = null;
         System.gc();
      } catch (IOException var2) {
         var2.getMessage();
      }

   }

   public void saveFeature(SimpleFeature feature) {
      try {
         SimpleFeature writeFeature = null;

         try {
            writeFeature = (SimpleFeature)this.outFeatureWriter.next();
         } catch (IOException var5) {
            var5.getMessage();
         }

         List<Object> att = feature.getAttributes();

         for(int n = 0; n < att.size(); ++n) {
            writeFeature.setAttribute(n, att.get(n));
         }

         this.outFeatureWriter.write();
      } catch (IOException var6) {
         var6.getMessage();
      }

   }

   public void saveFeature1(SimpleFeature feature) {
      try {
         SimpleFeature writeFeature = null;

         try {
            writeFeature = (SimpleFeature)this.outFeatureWriter1.next();
         } catch (IOException var5) {
            var5.getMessage();
         }

         List<Object> att = feature.getAttributes();

         for(int n = 0; n < att.size(); ++n) {
            writeFeature.setAttribute(n, att.get(n));
         }

         this.outFeatureWriter1.write();
      } catch (IOException var6) {
         var6.getMessage();
      }

   }

   public SimpleFeatureType createFeatureType() {
      SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
      builder.setName("the_geom");
      builder.setCRS(DefaultGeographicCRS.WGS84);
      builder.add("the_geom", Point.class);
      builder.add("logid", String.class);
      builder.add("fechahora", String.class);
      builder.add("velocidad", Double.class);
      builder.add("rotacion", Double.class);
      builder.add("orden", Integer.class);
      builder.add("stopidx", Integer.class);
      builder.add("distance", Double.class);
      SimpleFeatureType LOCATION = builder.buildFeatureType();
      return LOCATION;
   }

   public SimpleFeatureType createFeatureTypeTarjeta() {
      SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
      builder.setName("the_geom");
      builder.setCRS(DefaultGeographicCRS.WGS84);
      builder.add("the_geom", Point.class);
      builder.add("logid", String.class);
      builder.add("fechahora", String.class);
      builder.add("velocidad", Double.class);
      builder.add("rotacion", Double.class);
      builder.add("orden", Integer.class);
      builder.add("stopidx", Integer.class);
      SimpleFeatureType LOCATION = builder.buildFeatureType();
      return LOCATION;
   }

   public SimpleFeatureType createFeatureTypeGPSE() {
      SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
      builder.setName("the_geom");
      builder.setCRS(DefaultGeographicCRS.WGS84);
      builder.add("the_geom", Point.class);
      builder.add("logid", String.class);
      builder.add("fechahora", String.class);
      builder.add("velocidad", Double.class);
      builder.add("rotacion", Double.class);
      builder.add("orden", Integer.class);
      builder.add("stopidx", Integer.class);
      builder.add("movim", String.class);
      builder.add("dist", Double.class);
      SimpleFeatureType LOCATION = builder.buildFeatureType();
      return LOCATION;
   }

   public SimpleFeatureType createFeatureTypeCabv3() {
      SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
      builder.setName("the_geom");
      builder.setCRS(DefaultGeographicCRS.WGS84);
      builder.add("the_geom", Point.class);
      builder.add("logid", String.class);
      builder.add("fechahora", String.class);
      builder.add("velocidad", Double.class);
      builder.add("rotacion", Double.class);
      builder.add("orden", Integer.class);
      builder.add("stopidx", Integer.class);
      builder.add("movim", String.class);
      builder.add("dist", Double.class);
      SimpleFeatureType LOCATION = builder.buildFeatureType();
      return LOCATION;
   }

   public SimpleFeatureType createFeatureTypeTReal() {
      SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
      builder.setName("the_geom");
      builder.setCRS(DefaultGeographicCRS.WGS84);
      builder.add("the_geom", Point.class);
      builder.add("logid", String.class);
      builder.add("fechahora", String.class);
      builder.add("velocidad", Double.class);
      builder.add("rotacion", Double.class);
      builder.add("orden", Integer.class);
      builder.add("stopidx", Integer.class);
      builder.add("dist", Double.class);
      SimpleFeatureType LOCATION = builder.buildFeatureType();
      return LOCATION;
   }

   public SimpleFeatureType createFeatureTypeDetenciones() {
      SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
      builder.setName("the_geom");
      builder.setCRS(DefaultGeographicCRS.WGS84);
      builder.add("the_geom", Point.class);
      builder.add("usuario", Integer.class);
      builder.add("movil", String.class);
      builder.add("fecha1", String.class);
      builder.add("fecha2", String.class);
      builder.add("minutos", Long.class);
      builder.add("logid", String.class);
      builder.add("distance", Double.class);
      builder.add("orden", Integer.class);
      builder.add("simindex", Integer.class);
      SimpleFeatureType LOCATION = builder.buildFeatureType();
      return LOCATION;
   }

   public SimpleFeatureType createFeatureTypeViolacionesVeloc() {
      SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
      builder.setName("the_geom");
      builder.setCRS(DefaultGeographicCRS.WGS84);
      builder.add("the_geom", LineString.class);
      builder.add("usuario", Integer.class);
      builder.add("movil", String.class);
      builder.add("fecha1", String.class);
      builder.add("fecha2", String.class);
      builder.add("tiempo", Long.class);
      builder.add("logid", String.class);
      builder.add("distance", Double.class);
      builder.add("VelocMax", Double.class);
      SimpleFeatureType LOCATION = builder.buildFeatureType();
      return LOCATION;
   }

   public SimpleFeatureType createFeatureTypeDesconexiones() {
      SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
      builder.setName("the_geom");
      builder.setCRS(DefaultGeographicCRS.WGS84);
      builder.add("the_geom", LineString.class);
      builder.add("usuario", Integer.class);
      builder.add("movil", String.class);
      builder.add("fecha_cone", String.class);
      builder.add("fecha_desc", String.class);
      builder.add("motivo", Integer.class);
      builder.add("logid", String.class);
      SimpleFeatureType LOCATION = builder.buildFeatureType();
      return LOCATION;
   }
}
