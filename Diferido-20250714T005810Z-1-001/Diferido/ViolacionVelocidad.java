package Diferido;

public class ViolacionVelocidad {
   String FI_Violacion;
   String FF_Violacion;
   double LatInicioViolacion;
   double LonInicioViolacion;
   double LatFinViolacion;
   double LonFinViolacion;
   double distancia;
   double velcMax;

   public ViolacionVelocidad(String fi, String ff, double latIV, double lonIV, double latFV, double lonFV, double d, double vmax) {
      this.FI_Violacion = fi;
      this.FF_Violacion = ff;
      this.LatInicioViolacion = latIV;
      this.LonInicioViolacion = lonIV;
      this.LatFinViolacion = latFV;
      this.LonFinViolacion = lonFV;
      this.distancia = d;
      this.velcMax = vmax;
   }
}
