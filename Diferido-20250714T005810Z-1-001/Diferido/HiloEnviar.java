package Diferido;

import bsh.ParseException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HiloEnviar extends Thread {
   Datos_Hoja_de_Ruta hruta;

   public HiloEnviar(Datos_Hoja_de_Ruta hruta) {
      this.hruta = hruta;
   }

   public void run() {
      String msg;
      try {
         if (!this.hruta.en.abierto) {
            this.hruta.en.abierto = true;
            if (!this.hruta.Acepto) {
               this.hruta.en.ShowMessage("Debe oprimir el botón Aceptar antes de enviar la trayectoria", "Información", "Information");
            } else {
               String msg;
               if (!this.hruta.en.Tiene_Conexion) {
                  msg = "Usted no tiene conexión en este momento. Debe oprimir el botón Terminar<br/>para guardar los datos en la carpeta Por Transferir";
                  this.hruta.en.ShowMessage(msg, "Información", "Information");
               } else if (!this.hruta.VioReporte) {
                  this.hruta.en.ShowMessage("Debe ver el Reporte Rápido primero.", "Información", "Information");
               } else {
                  try {
                     if (this.hruta.Chequear_Version()) {
                        if (this.hruta.Verificar_Usuario()) {
                           if (this.hruta.DiferidoIndCons()) {
                              if (!this.hruta.DiferidoDocumento()) {
                                 msg = "Debe Cambiar los Números de Documentos";
                                 this.hruta.en.ShowMessage(msg, "Información", "Information");
                              } else if (this.hruta.DiferidoMovil() && this.hruta.DiferidoIDGPS()) {
                                 msg = this.hruta.en.logid;
                                 File shp_trayect = new File(this.hruta.shp_compacto);
                                 boolean subio_shp = this.hruta.Subir_Trayectoria_shp(msg, shp_trayect);
                                 if (subio_shp) {
                                    File trayectoria1 = new File(this.hruta.XML_Compactado);
                                    boolean subio_BD = this.hruta.Enviar_Trayectoria(trayectoria1);
                                    String Fecha2;
                                    if (subio_BD) {
                                       Fecha2 = "";
                                       this.hruta.PB.setVisible(false);
                                       this.hruta.PBLabel.setVisible(false);
                                       this.hruta.en.ShowMessage("La Trayectoria se envió con éxito.", "Información", "Information");
                                       this.hruta.en.Trayectoria_Enviada = true;
                                       this.hruta.Envio = true;
                                       this.hruta.bandera = false;
                                    } else {
                                       this.hruta.PB.setVisible(false);
                                       this.hruta.PBLabel.setVisible(false);
                                       Fecha2 = "Se produjo un error durante el envío de la Trayectoria. Es posible<br/>que existan problemas en el Servidor de Bases de Datos de MovilWeb. <br/>Póngase en contacto con el PAT para solucionar este problema.";
                                       this.hruta.en.ShowMessage(Fecha2, "Información", "Information");
                                    }
                                 } else {
                                    this.hruta.PB.setVisible(false);
                                    this.hruta.PBLabel.setVisible(false);
                                    String msg = "Se produjo un error durante el envío de la Trayectoria.Es posible<br/>que se haya caído la conexión realizando esta operación o que exista<br/>algún problema en los servidores de MovilWeb.Póngase en contacto con el<br/>PAT para solucionar este problema.";
                                    this.hruta.en.ShowMessage(msg, "Información", "Information");
                                 }
                              } else {
                                 this.hruta.PB.setVisible(false);
                                 this.hruta.PBLabel.setVisible(false);
                                 msg = "Presione el botón Terminar para continuar.";
                                 this.hruta.en.ShowMessage(msg, "Información", "Information");
                              }
                           } else {
                              this.hruta.PB.setVisible(false);
                              this.hruta.PBLabel.setVisible(false);
                              msg = "Actualice la Tabla Móviles cuando inicie la Aplicación.";
                              this.hruta.en.ShowMessage(msg, "Información", "Information");
                              this.hruta.en.LimpiarCampos();
                              this.hruta.ListaHr.clear();
                           }
                        } else {
                           this.hruta.PB.setVisible(false);
                           this.hruta.PBLabel.setVisible(false);
                           msg = "El Móvil seleccionado no pertenece a la Base del Usuario Autenticado en Diferido. <br/>Actualice la Tabla Móviles cuando inicie la Aplicación.";
                           this.hruta.en.ShowMessage(msg, "Información", "Information");
                           this.hruta.en.LimpiarCampos();
                           this.hruta.ListaHr.clear();
                        }
                     } else {
                        this.hruta.PB.setVisible(false);
                        this.hruta.PBLabel.setVisible(false);
                        msg = "La versión de Diferido que usted está utilizando está desactualizada. <br/>Póngase en contacto con su administrador para instalar la nueva versión.";
                        this.hruta.en.ShowMessage(msg, "Información", "Information");
                        this.hruta.en.LimpiarCampos();
                        this.hruta.ListaHr.clear();
                     }

                     this.hruta.PBLabel.setVisible(false);
                     this.hruta.PB.setVisible(false);
                  } catch (Exception var7) {
                     this.hruta.PB.setVisible(false);
                     this.hruta.PBLabel.setVisible(false);
                     msg = "Se produjo un error durante el envío de la trayectoria.Póngase en contacto<br/> con el PAT para solucionar este problema.";
                     this.hruta.en.ShowMessage(msg, "Información", "Information");
                  }
               }
            }

            this.hruta.en.abierto = false;
         }
      } catch (Exception var8) {
         this.hruta.PB.setVisible(false);
         this.hruta.PBLabel.setVisible(false);
         msg = "En este momento no tiene conectividad, es posible que no pueda transferir.";
         this.hruta.en.ShowMessage(msg, "Información", "Information");
      }

   }

   public String SumarFecha(String dia, String hora, int formatofecha) throws ParseException {
      int dia_inicial = Integer.parseInt(dia.substring(0, 2));
      int mes_inicial = Integer.parseInt(dia.substring(3, 5)) - 1;
      int year_inicial = Integer.parseInt(dia.substring(6, 8)) + 100;
      int hora_inic = Integer.parseInt(hora.substring(0, 2));
      int min_inic = Integer.parseInt(hora.substring(3, 5));
      int seg_inic = Integer.parseInt(hora.substring(6, 8));
      long diferencia = 0L;
      SimpleDateFormat formato = null;
      if (formatofecha == 1) {
         formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      } else if (formatofecha == 2) {
         formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      }

      Date f1 = new Date(year_inicial, mes_inicial, dia_inicial, hora_inic, min_inic, seg_inic);
      diferencia = f1.getTime();
      Date f2 = new Date(diferencia);
      String fecha = formato.format(f2);
      return fecha;
   }

   public String Obtener_Fecha(String Fecha) {
      int y = Integer.valueOf(Fecha.substring(6, 10));
      int m = Integer.valueOf(Fecha.substring(3, 5));
      int d = Integer.valueOf(Fecha.substring(0, 2));
      String retorno = y + "-" + m + "-" + d + " " + Fecha.substring(11, 19);
      return retorno;
   }
}
