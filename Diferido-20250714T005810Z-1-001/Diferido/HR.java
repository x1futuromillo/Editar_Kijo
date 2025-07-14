package Diferido;

import java.util.Date;

public class HR {
   int numero;
   String fi;
   String ff;
   String hi;
   String hf;
   double kmrec;
   String tiempoMH;
   double km_sin_respaldo;
   double km_after;
   double km_gps;
   long tiempoHR;
   long tiempo_det_HR;
   long tiempo_SR;
   long tiempo_det_SR;
   long tiempo_after;

   public HR(int n, String fechai, String horai, String fechaf, String horaf, double km, String tiempMH) {
      this.numero = n;
      this.fi = fechai;
      this.hi = horai;
      this.ff = fechaf;
      this.hf = horaf;
      this.kmrec = km;
      this.tiempoMH = tiempMH;
   }

   public long DateDiff(String Interval, Date Date1, Date Date2) {
      long difference = Math.abs(Date1.getTime() - Date2.getTime());
      if (Interval.equals("s")) {
         difference /= 1000L;
      }

      if (Interval.equals("m")) {
         difference /= 60000L;
      }

      if (Interval.equals("h")) {
         difference /= 3600000L;
      }

      return difference;
   }

   public void SetTiempoHR(long time) {
      this.tiempoHR = time;
   }

   public void CalcularTiempoAfter(Date date_final, String Fecha_Final, String Hora_Final) {
      String[] fecha = Fecha_Final.split("/");
      String[] hora = Hora_Final.split(":");
      int year = Integer.parseInt(fecha[2]) + 100;
      int mes = Integer.parseInt(fecha[1]) - 1;
      int dia = Integer.parseInt(fecha[0]);
      int h = Integer.parseInt(hora[0]);
      int m = Integer.parseInt(hora[1]);
      int s = 0;
      Date fin_trayectoria = new Date(year, mes, dia, h, m, s);
      long diferencia_en_min = Math.abs(fin_trayectoria.getTime() - date_final.getTime()) / 60000L;
      this.tiempo_after = diferencia_en_min;
   }
}
