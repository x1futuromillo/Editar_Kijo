package Diferido;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

public class Hilo1 extends Thread {
   Entrada en;

   public Hilo1(Entrada en) {
      this.en = en;
   }

   public void run() {
      String msg;
      String msg;
      ListadoVehiculos conf;
      try {
         if (this.en.Usuario.getText().equalsIgnoreCase("")) {
            this.en.PB.setVisible(false);
            this.en.PBLabel.setVisible(false);
            this.en.ShowMessage("Debe especificar el nombre del usuario.", "Error", "Error");
            this.en.selecciono_moviles = false;
            this.en.apreto_moviles = false;
            this.stop();
         } else if (this.en.Password.getText().equalsIgnoreCase("")) {
            this.en.PBLabel.setVisible(false);
            this.en.PB.setVisible(false);
            this.en.ShowMessage("Debe especificar la contraseña del usuario.", "Error", "Error");
            this.en.selecciono_moviles = false;
            this.en.apreto_moviles = false;
            this.stop();
         } else if (!this.en.existe_fichero_configuracion) {
            String msg = "No existe el fichero de Configuración del Diferido.Debe hacer clic<br/>en las Opciones de Configuración para crearlo.";
            this.en.PBLabel.setVisible(false);
            this.en.PB.setVisible(false);
            this.en.ShowMessage(msg, "Error", "Error");
            this.en.selecciono_moviles = false;
            this.en.apreto_moviles = false;
            this.stop();
         } else if (!this.en.Listado_Vehiculos_Activo) {
            this.en.user = this.en.Usuario.getText();
            this.en.pass = this.en.Password.getText();
            ListadoVehiculos conf = new ListadoVehiculos(this.en);
            int n = this.en.DiferidoLogin();
            this.en.PBLabel.setVisible(false);
            this.en.PB.setVisible(false);
            if (n == -1) {
               this.en.PBLabel.setVisible(false);
               this.en.PB.setVisible(false);
               this.en.ShowMessage("Nombre de Usuario o Contraseña no válidos.", "Error", "Error");
               this.en.selecciono_moviles = false;
               this.en.apreto_moviles = false;
               this.en.Usuario.setText("");
               this.en.Password.setText("");
               this.stop();
            } else if (n == -3) {
               msg = "No se pudo acceder al Servidor de MovilWeb. Es posible que existan<br/>problemas de conexión.";
               this.en.ShowMessage(msg, "Información", "Information");
               this.en.Tiene_Conexion = false;
               this.en.PBLabel.setVisible(false);
               this.en.PB.setVisible(false);
               conf.Llenar_Tabla();
               this.en.apreto_moviles = false;
            } else if (n == -2) {
               msg = "Usted no tiene conexión en este momento. Se ejecutará Diferido<br/>sin conexión. Es posible que los datos de los móviles estén <br/>desactualizados.";
               this.en.ShowMessage(msg, "Información", "Information");
               this.en.Tiene_Conexion = false;
               this.en.PBLabel.setVisible(false);
               this.en.PB.setVisible(false);
               conf.Llenar_Tabla();
               this.en.apreto_moviles = false;
            } else {
               try {
                  if (!this.en.abierto && this.en.cambio_de_fecha) {
                     this.en.PBLabel.setVisible(true);
                     this.en.PBLabel.setText("Descargando lista de móviles...");
                     this.en.PB.setVisible(true);
                     conf.HacerPost();
                     this.en.PBLabel.setVisible(false);
                     this.en.PB.setVisible(false);
                  } else if (!this.en.Tiene_Conexion || this.en.abierto || !this.en.cambio_de_fecha) {
                     conf.Llenar_Tabla();
                     this.en.apreto_moviles = false;
                  }
               } catch (Exception var8) {
                  conf.HacerPost();
               }
            }
         }
      } catch (SocketTimeoutException var9) {
         msg = "La Conexión con el Servidor está tardando más de lo normal. Se <br/>ejecutará Diferido sin Conexión. Es posible que los datos de los Móviles <br/>estén desactualizados.";
         this.en.ShowMessage(msg, "Información", "Information");
         this.en.Tiene_Conexion = false;
         this.en.PBLabel.setVisible(false);
         this.en.PB.setVisible(false);

         try {
            conf = new ListadoVehiculos(this.en);
            conf.Llenar_Tabla();
            this.en.apreto_moviles = false;
         } catch (Exception var7) {
            this.en.ShowMessage("Se produjo un error haciendo la petición.", "Información", "Information");
         }
      } catch (ConnectException var10) {
         msg = "La Conexión con el Servidor está tardando más de lo normal. Se <br/>ejecutará Diferido sin Conexión. Es posible que los datos de los Móviles <br/>estén desactualizados.";
         this.en.ShowMessage(msg, "Información", "Information");
         this.en.Tiene_Conexion = false;
         this.en.PBLabel.setVisible(false);
         this.en.PB.setVisible(false);

         try {
            conf = new ListadoVehiculos(this.en);
            conf.Llenar_Tabla();
            this.en.apreto_moviles = false;
         } catch (Exception var6) {
            this.en.ShowMessage("Se produjo un error haciendo la petición.", "Información", "Information");
         }
      } catch (Exception var11) {
         ListadoVehiculos conf = new ListadoVehiculos(this.en);
         this.en.PB.setVisible(false);
         this.en.PBLabel.setVisible(false);
         msg = "Usted no tiene Conexión en este momento. Se ejecutará Diferido<br/>sin Conexión. Es posible que los datos de los Móviles estén <br/>desactualizados.";
         this.en.ShowMessage(msg, "Información", "Information");
         this.en.Tiene_Conexion = false;
         this.en.PBLabel.setVisible(false);
         this.en.PB.setVisible(false);

         try {
            conf.Llenar_Tabla();
            this.en.apreto_moviles = false;
         } catch (Exception var5) {
            this.en.ShowMessage("No se pudo cargar la Lista de Móviles.", "Información", "Information");
            this.en.selecciono_moviles = false;
            this.en.apreto_moviles = false;
         }
      }

   }
}
