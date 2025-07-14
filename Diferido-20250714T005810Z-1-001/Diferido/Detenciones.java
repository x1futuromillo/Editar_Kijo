package Diferido;

public class Detenciones {
   int registro;
   String chapa;
   String Fecha1;
   String Fecha2;
   int minutos;
   double latitud;
   double longitud;
   double distancia_acumulada;
   int simiindex;

   public Detenciones(int reg, String ch, String f1, String f2, int min, double lat, double lon, double dist_acumulada, int simind) {
      this.registro = reg;
      this.chapa = ch;
      this.Fecha1 = f1;
      this.Fecha2 = f2;
      this.minutos = min;
      this.latitud = lat;
      this.longitud = lon;
      this.distancia_acumulada = dist_acumulada;
      this.simiindex = simind;
   }
}
