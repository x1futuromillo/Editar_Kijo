package Diferido;

public class HiloFechaTrayect extends Thread {
   Entrada en;

   public HiloFechaTrayect(Entrada en) {
      this.en = en;
   }

   public void run() {
      try {
         if (!this.en.selecciono_fechas) {
            boolean intervalo = this.en.ObtenerIntTrayectoria();
            if (intervalo) {
               FechasDTrayectoria fecha = new FechasDTrayectoria(this.en);
               fecha.MostrarDatos();
               fecha.show();
               this.en.PBLabel.setVisible(false);
               this.en.PB.setVisible(false);
               this.en.PBLabel.setText("");
            }
         }
      } catch (Exception var3) {
      }

   }
}
