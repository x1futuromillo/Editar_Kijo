package Diferido;

import java.util.Date;

public class Desconexion {
   String chapa;
   String Fecha_Conexion;
   String Fecha_Desconexion;
   int tiempo;
   double LatConn;
   double LonConn;
   double LatDesc;
   double LonDesc;
   int motivo;

   public Desconexion(String ch, String fc, String fd, double lc, double lgc, double ld, double lgd, int m) {
      this.chapa = ch;
      this.Fecha_Conexion = fc;
      this.Fecha_Desconexion = fd;
      this.LatConn = lc;
      this.LonConn = lgc;
      this.LatDesc = ld;
      this.LonDesc = lgd;
      this.motivo = m;
   }

   public long Tiempo_Desconexion() {
      int initial_day = Integer.parseInt(this.Fecha_Desconexion.substring(8, 10));
      int initial_month = Integer.parseInt(this.Fecha_Desconexion.substring(5, 7)) - 1;
      int initial_year = Integer.parseInt(this.Fecha_Desconexion.substring(0, 4)) - 1900;
      int initial_hour = Integer.parseInt(this.Fecha_Desconexion.substring(11, 13));
      int initial_min = Integer.parseInt(this.Fecha_Desconexion.substring(14, 16));
      int initial_seg = Integer.parseInt(this.Fecha_Desconexion.substring(17, 19));
      int final_day = Integer.parseInt(this.Fecha_Conexion.substring(8, 10));
      int final_month = Integer.parseInt(this.Fecha_Conexion.substring(5, 7)) - 1;
      int final_year = Integer.parseInt(this.Fecha_Conexion.substring(0, 4)) - 1900;
      int final_hour = Integer.parseInt(this.Fecha_Conexion.substring(11, 13));
      int final_min = Integer.parseInt(this.Fecha_Conexion.substring(14, 16));
      int final_seg = Integer.parseInt(this.Fecha_Conexion.substring(17, 19));
      Date f1 = new Date(final_year, final_month, final_day, final_hour, final_min, final_seg);
      Date f2 = new Date(initial_year, initial_month, initial_day, initial_hour, initial_min, initial_seg);
      long diferencia_seg = Math.abs(f2.getTime() - f1.getTime()) / 1000L;
      return diferencia_seg;
   }
}
