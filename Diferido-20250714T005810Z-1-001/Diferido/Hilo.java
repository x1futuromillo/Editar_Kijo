package Diferido;

import java.net.SocketTimeoutException;

public class Hilo extends Thread {
   Entrada en;

   public Hilo(Entrada en) {
      this.en = en;
   }

   public void run() {
      this.en.PBLabel.setVisible(false);
      this.en.PB.setVisible(false);
      String m;
      if (this.en.Listo_para_Transferir) {
         try {
            if (this.en.Usuario.getText().equalsIgnoreCase("")) {
               this.en.ShowMessage("Debe especificar el Nombre del Usuario.", "Error", "Error");
               this.en.en_ejecucion = false;
            } else if (this.en.Password.getText().equalsIgnoreCase("")) {
               this.en.ShowMessage("Debe especificar la Contraseña del Usuario.", "Error", "Error");
               this.en.en_ejecucion = false;
            } else {
               this.en.user = this.en.Usuario.getText();
               this.en.pass = this.en.Password.getText();
               int n = this.en.DiferidoLogin();
               this.en.PBLabel.setVisible(false);
               this.en.PB.setVisible(false);
               if (n == -1) {
                  this.en.ShowMessage("Nombre de Usuario o Contraseña no válidos.", "Error", "Error");
                  this.en.PBLabel.setVisible(false);
                  this.en.PB.setVisible(false);
                  this.en.continuar = false;
                  this.en.en_ejecucion = false;
               } else if (n == -3) {
                  m = "No se pudo acceder al Servidor de MovilWeb. Es posible que existan<br/>problemas de Conexión";
                  this.en.ShowMessage(m, "Información", "Information");
                  this.en.Tiene_Conexion = false;
                  this.en.PBLabel.setVisible(false);
                  this.en.PB.setVisible(false);
                  this.en.Listo_para_Transferir = false;
                  this.en.hay_ficheros_sin_transferir = false;
                  this.en.en_ejecucion = false;
               } else if (n == -2) {
                  m = "Usted no tiene Conexión en este momento. Intente enviar la<br/>Trayectoria más tarde.";
                  this.en.ShowMessage(m, "Información", "Information");
                  this.en.Tiene_Conexion = false;
                  this.en.PBLabel.setVisible(false);
                  this.en.PB.setVisible(false);
                  this.en.Listo_para_Transferir = false;
                  this.en.hay_ficheros_sin_transferir = false;
                  this.en.en_ejecucion = false;
               } else {
                  this.en.PB.setVisible(true);
                  this.en.PBLabel.setVisible(true);
                  this.en.Size = this.en.OriginalSize;
                  if (this.en.Size < 127875072L) {
                     this.en.posible_alteracion = true;
                  }

                  if (this.en.Size > 128000000L && this.en.Size < 253591552L) {
                     this.en.posible_alteracion = true;
                  }

                  if (this.en.Transferencia.equalsIgnoreCase("1")) {
                     if (this.en.Transferir_Fichero(this.en.por_transferir)) {
                        this.en.ComprobarFechaHora(this.en.Fecha_Final, this.en.Hora_Final, 2);
                     }
                  } else if (this.en.Transferencia.equalsIgnoreCase("2")) {
                     if (this.en.Transferir_FicheroGPSE(this.en.por_transferir)) {
                        this.en.ComprobarFechaHora(this.en.Fecha_Final, this.en.Hora_Final, 2);
                     }
                  } else if (this.en.Transferencia.equalsIgnoreCase("3")) {
                     if (this.en.Transferir_FicheroTReal(this.en.por_transferir)) {
                        this.en.ComprobarFechaHora(this.en.Fecha_Final, this.en.Hora_Final, 2);
                     }
                  } else if (this.en.Transferencia.equalsIgnoreCase("4")) {
                     if (this.en.Transferir_FicheroTReal(this.en.por_transferir)) {
                        this.en.ComprobarFechaHora(this.en.Fecha_Final, this.en.Hora_Final, 2);
                     }
                  } else if (this.en.Transferir_FicheroCabv3(this.en.por_transferir)) {
                     this.en.ComprobarFechaHora(this.en.Fecha_Final, this.en.Hora_Final, 2);
                  }

                  this.en.PB.setVisible(false);
                  this.en.PBLabel.setVisible(false);
                  Datos_Hoja_de_Ruta hr = new Datos_Hoja_de_Ruta(this.en);
                  hr.MostrarDatos();
               }
            }
         } catch (SocketTimeoutException var10) {
            if (this.en.Listo_para_Transferir) {
               m = "La Conexión con el Servidor está tardando más de lo normal.<br/>Intente la Transferencia más tarde, la Aplicación se Cerrara.";
               this.en.ShowMessage(m, "Información", "Information");
               System.exit(0);
            } else {
               m = "La Conexión con el Servidor está tardando más de lo normal. Se <br/>ejecutará Diferido sin Conexión. Es posible que los Datos de los Móviles <br/>estén desactualizados.";
               this.en.ShowMessage(m, "Información", "Information");
               this.en.Tiene_Conexion = false;

               try {
                  ListadoVehiculos conf = new ListadoVehiculos(this.en);
                  conf.Llenar_Tabla();
               } catch (Exception var8) {
                  this.en.ShowMessage("Se produjo un error haciendo la petición.", "Información", "Information");
               }
            }
         } catch (Exception var11) {
            m = "Es posible que haya fallado la Conexión al Servidor. Póngase<br/>en contacto con el PAT para solucionar este problema.";
            this.en.ShowMessage(m, "Información", "Information");
            this.en.PBLabel.setVisible(false);
            this.en.PB.setVisible(false);
            this.en.continuar = false;
         }
      } else if (this.en.Chapa.getText().equalsIgnoreCase("")) {
         this.en.ShowMessage("Faltan los datos de la Chapa del Carro.", "Información", "Information");
      } else if (this.en.Indice.getText().equalsIgnoreCase("")) {
         this.en.ShowMessage("Faltan los datos del índice de Consumo del Carro.", "Información", "Information");
      } else {
         if (!this.en.hay_ficheros_sin_transferir) {
            this.en.Consumo = Double.parseDouble(this.en.Indice.getText());
            this.en.chapa = this.en.Chapa.getText();
            this.en.NumeroVehiculo = this.en.Numero.getText();
         }

         if (this.en.Consumo == 0.0D) {
            this.en.indice0 = true;
         }

         boolean comprimir = false;
         this.en.PB.setVisible(true);
         this.en.PBLabel.setVisible(true);
         if (this.en.Transferencia.equalsIgnoreCase("1")) {
            comprimir = this.en.ComprimirTrayectoria();
         } else if (this.en.Transferencia.equalsIgnoreCase("2")) {
            comprimir = this.en.ComprimirTrayectoriaGPSE();
         } else if (this.en.Transferencia.equalsIgnoreCase("3")) {
            comprimir = this.en.ComprimirTrayectoriaTReal();
         } else if (this.en.Transferencia.equalsIgnoreCase("4")) {
            comprimir = this.en.ComprimirTrayectoriaTRLocal();
         } else {
            comprimir = this.en.ComprimirTrayectoriaCabv3();
         }

         String msg1;
         if (this.en.indice0) {
            m = "Esta Trayectoria no se puede Transferir. El índice de Consumo no puede<br/>ser igual a 0. Póngase en contacto con el Jefe de Grupo Provincial. Se <br/>guardará la Trayectoria en Salvas Originales y se formateará la Tarjeta.";
            msg1 = "Esta Trayectoria no se puede Transferir. El índice de Consumo no puede<br/>ser igual a 0. Póngase en contacto con el Jefe de Grupo Provincial o <br/>con el PAT para solucionar este problema.";
            if (this.en.Kijo_en_Flash) {
               this.en.ShowMessage(m, "Information", "Error");

               try {
                  this.en.Formatear();
                  System.exit(0);
               } catch (Exception var7) {
                  String m = "Ocurrió un error durante el Formateo de la Tarjeta.";
                  this.en.ShowMessage(m, "Information", "Error");
               }
            }
         } else {
            this.en.user = this.en.Usuario.getText();
            this.en.pass = this.en.Password.getText();
            if (comprimir) {
               try {
                  if (this.en.Transferencia.equalsIgnoreCase("1")) {
                     this.en.LeerTrayectoria();
                  } else if (this.en.Transferencia.equalsIgnoreCase("2")) {
                     this.en.LeerTrayectoriaGPSE();
                  } else if (this.en.Transferencia.equalsIgnoreCase("3")) {
                     this.en.LeerTrayectoriaTReal();
                  } else if (this.en.Transferencia.equalsIgnoreCase("4")) {
                     this.en.LeerTrayectoriaTReal();
                  } else {
                     this.en.LeerTrayectoriaCabv3();
                  }
               } catch (Exception var9) {
                  msg1 = "";
                  String msg = "";
                  this.en.PBLabel.setVisible(false);
                  this.en.PB.setVisible(false);
                  this.en.continuar = false;
                  if (this.en.numero_de_lineas - this.en.tramas_simplificadas < 6L) {
                     if (this.en.Kijo_en_Flash) {
                        msg1 = "Esta Trayectoria tiene problemas en todas sus tramas.<br/>Póngase en contacto con el personal de GCOM para solucionar<br/>el problema. Esta Trayectoria no se va a Transferir. Los Datos<br/>fueron guardados en la carpeta \"Salvas Originales\".";
                     } else {
                        msg1 = "Esta Trayectoria tiene problemas en todas sus tramas.<br/>Póngase en contacto con el personal de GCOM para solucionar<br/>el problema. Esta trayectoria no se va a transferir.";
                     }

                     this.en.ShowMessage(msg1, "Information", "Error");
                     System.exit(0);
                  } else {
                     msg = "Se produjo un error en el análisis de la Trayectoria.¿Desea enviar<br/>la trayectoria para el ftp para que el PAT la analice?";
                     int n = this.en.ShowMessageConfirmDialog(msg, "Mensaje de Confirmación", "Confirmación");
                     if (n == 0) {
                        Error e = null;
                        e = new Error(this.en);
                        e.Mostrar();
                     } else {
                        System.exit(0);
                     }
                  }
               }
            } else if (this.en.Transferencia.equalsIgnoreCase("3")) {
               m = "No se Pudo Descargar La Trayectoria de Tiempo Real del Servidor.";
               this.en.ShowMessage(m, "Information", "Error");
               System.exit(0);
            }
         }
      }

   }
}
