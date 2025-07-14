package Diferido;

import java.util.Date;

public class HiloAceptarHR extends Thread {
   Datos_Hoja_de_Ruta hruta;

   public HiloAceptarHR(Datos_Hoja_de_Ruta hr) {
      this.hruta = hr;
   }

   public void run() {
      this.hruta.Acepto = false;
      this.hruta.VioReporte = false;
      this.hruta.Envio = false;
      this.hruta.chofer = this.hruta.Conductor.getText();
      this.hruta.chofer_auxiliar = this.hruta.Conductor1.getText();
      boolean ordenada = true;
      this.hruta.en.insertDB = "";
      int canthr = this.hruta.ListaHr.size();
      if (this.hruta.Tabla.getRowCount() == 1) {
         this.hruta.PB.setVisible(true);
         this.hruta.PBLabel.setVisible(true);
         this.hruta.PBLabel.setText("Procesando Datos de Hoja de Ruta...");
      } else {
         this.hruta.PB.setVisible(true);
         this.hruta.PBLabel.setVisible(true);
         this.hruta.PBLabel.setText("Procesando Datos de las Hojas de Ruta...");
      }

      if (canthr > 0) {
         this.hruta.distancia_recorrida_total = 0.0D;
         this.hruta.cant_lineas_shp = 0;
         this.hruta.ListaHr.clear();
      }

      int cantfilas = this.hruta.Tabla.getRowCount();
      if (cantfilas == 0) {
         this.hruta.en.ShowMessage("Debe Insertar Datos en la Tabla.", "Error", "Error");
         this.hruta.PB.setVisible(false);
         this.hruta.PBLabel.setVisible(false);
      } else {
         int Nohr;
         String fi;
         String ff;
         String hi;
         String hf;
         String tiemp_MH;
         double kmrec;
         int i;
         int dia_inicial;
         int mes_inicial;
         int year_inicial;
         int hora_inicial;
         int minuto_inicial;
         int dia_final;
         int mes_final;
         int year_final;
         int hora_final;
         Date date_inicial;
         if (cantfilas == 1) {
            if (this.hruta.trafico.isSelected()) {
               this.hruta.genera_trafico = "Si";
            } else {
               this.hruta.genera_trafico = "No";
            }

            if (this.hruta.abastecimient.isSelected()) {
               this.hruta.genera_abastec = "Si";
            } else {
               this.hruta.genera_abastec = "No";
            }

            Nohr = Integer.parseInt(this.hruta.Tabla.getValueAt(0, 0).toString());
            fi = this.hruta.Tabla.getValueAt(0, 1).toString();
            fi = Integer.parseInt(fi.substring(6, 8)) + 2000 + "-" + fi.substring(3, 5) + "-" + fi.substring(0, 2);
            hi = this.hruta.Tabla.getValueAt(0, 2).toString();
            ff = this.hruta.Tabla.getValueAt(0, 3).toString();
            ff = Integer.parseInt(ff.substring(6, 8)) + 2000 + "-" + ff.substring(3, 5) + "-" + ff.substring(0, 2);
            hf = this.hruta.Tabla.getValueAt(0, 4).toString();
            kmrec = Double.parseDouble(this.hruta.Tabla.getValueAt(0, 5).toString());
            if (this.hruta.MotoHoras.isEnabled()) {
               tiemp_MH = this.hruta.Tabla.getValueAt(0, 6).toString();
            } else {
               tiemp_MH = "00:00";
            }

            i = Integer.parseInt(fi.substring(8, 10));
            dia_inicial = Integer.parseInt(fi.substring(5, 7)) - 1;
            mes_inicial = Integer.parseInt(fi.substring(0, 4)) - 1900;
            year_inicial = Integer.parseInt(hi.substring(0, 2));
            hora_inicial = Integer.parseInt(hi.substring(3, 5));
            minuto_inicial = Integer.parseInt(ff.substring(8, 10));
            dia_final = Integer.parseInt(ff.substring(5, 7)) - 1;
            mes_final = Integer.parseInt(ff.substring(0, 4)) - 1900;
            year_final = Integer.parseInt(hf.substring(0, 2));
            hora_final = Integer.parseInt(hf.substring(3, 5));
            Date date_inicial = new Date(mes_inicial, dia_inicial, i, year_inicial, hora_inicial);
            date_inicial = new Date(mes_final, dia_final, minuto_inicial, year_final, hora_final);
            HR hr = new HR(Nohr, fi, hi, ff, hf, kmrec, tiemp_MH);
            long date_diff = hr.DateDiff("m", date_inicial, date_inicial);
            hr.SetTiempoHR(date_diff);
            hr.CalcularTiempoAfter(date_inicial, this.hruta.en.Fecha_Final, this.hruta.en.Hora_Final);
            this.hruta.ListaHr.add(hr);
         } else if (!this.hruta.Lista_HR_Ordenada()) {
            String msg = "Debe Ordenar las Hojas de Ruta por Fecha Inicial.<br/>Haga Clic en la Columna Fecha Inicial para Ordenarlas Ascendentemente. ";
            this.hruta.en.ShowMessage(msg, "Error", "Error");
            ordenada = false;
         } else {
            if (this.hruta.trafico.isSelected()) {
               this.hruta.genera_trafico = "Si";
            } else {
               this.hruta.genera_trafico = "No";
            }

            if (this.hruta.abastecimient.isSelected()) {
               this.hruta.genera_abastec = "Si";
            } else {
               this.hruta.genera_abastec = "No";
            }

            for(i = 0; i < cantfilas; ++i) {
               Nohr = Integer.parseInt(this.hruta.Tabla.getValueAt(i, 0).toString());
               fi = this.hruta.Tabla.getValueAt(i, 1).toString();
               fi = Integer.parseInt(fi.substring(6, 8)) + 2000 + "-" + fi.substring(3, 5) + "-" + fi.substring(0, 2);
               hi = this.hruta.Tabla.getValueAt(i, 2).toString();
               ff = this.hruta.Tabla.getValueAt(i, 3).toString();
               ff = Integer.parseInt(ff.substring(6, 8)) + 2000 + "-" + ff.substring(3, 5) + "-" + ff.substring(0, 2);
               hf = this.hruta.Tabla.getValueAt(i, 4).toString();
               kmrec = Double.parseDouble(this.hruta.Tabla.getValueAt(i, 5).toString());
               if (this.hruta.MotoHoras.isEnabled()) {
                  tiemp_MH = this.hruta.Tabla.getValueAt(i, 6).toString();
               } else {
                  tiemp_MH = "00:00";
               }

               dia_inicial = Integer.parseInt(fi.substring(8, 10));
               mes_inicial = Integer.parseInt(fi.substring(5, 7)) - 1;
               year_inicial = Integer.parseInt(fi.substring(0, 4)) - 1900;
               hora_inicial = Integer.parseInt(hi.substring(0, 2));
               minuto_inicial = Integer.parseInt(hi.substring(3, 5));
               dia_final = Integer.parseInt(ff.substring(8, 10));
               mes_final = Integer.parseInt(ff.substring(5, 7)) - 1;
               year_final = Integer.parseInt(fi.substring(0, 4)) - 1900;
               hora_final = Integer.parseInt(hf.substring(0, 2));
               int minuto_final = Integer.parseInt(hf.substring(3, 5));
               date_inicial = new Date(year_inicial, mes_inicial, dia_inicial, hora_inicial, minuto_inicial);
               Date date_final = new Date(year_final, mes_final, dia_final, hora_final, minuto_final);
               HR hr = new HR(Nohr, fi, hi, ff, hf, kmrec, tiemp_MH);
               long date_diff = hr.DateDiff("m", date_inicial, date_final);
               hr.SetTiempoHR(date_diff);
               hr.CalcularTiempoAfter(date_final, this.hruta.en.Fecha_Final, this.hruta.en.Hora_Final);
               this.hruta.ListaHr.add(hr);
            }
         }

         try {
            if (ordenada) {
               this.hruta.TiemposSR();
               this.hruta.Crear_Fichero_Final();
               if (this.hruta.en.Transferencia.equalsIgnoreCase("1")) {
                  this.hruta.ProcesarHoja_de_Ruta();
               } else if (this.hruta.en.Transferencia.equalsIgnoreCase("2")) {
                  this.hruta.ProcesarHoja_de_RutaGPSE();
               } else if (this.hruta.en.Transferencia.equalsIgnoreCase("3")) {
                  this.hruta.ProcesarHoja_de_RutaTReal();
               } else if (this.hruta.en.Transferencia.equalsIgnoreCase("4")) {
                  this.hruta.ProcesarHoja_de_RutaTReal();
               } else {
                  this.hruta.ProcesarHoja_de_RutaCabv3();
               }

               this.hruta.ConstruirShapeDetenciones();
               this.hruta.ConstruirShapeDesconexiones();
               this.hruta.ConstruirShapeViolacVelc();
               this.hruta.ConstruirTiempoZona();
               this.hruta.ConstruirFicheroHR();
               if (this.hruta.genera_trafico.equalsIgnoreCase("Si")) {
                  this.hruta.ConstruirFicheroCD();
               } else {
                  this.hruta.listado_prod.clear();
               }

               if (this.hruta.genera_abastec.equalsIgnoreCase("Si")) {
                  this.hruta.ConstruirFicheroAbastec();
               } else {
                  this.hruta.listado_chip.clear();
               }

               this.hruta.ConstruirFicheroUserLog();
               this.hruta.CompactarShapeTrayectoria();
               this.hruta.Compactar_Fichero_Final();
               this.hruta.CompactarTrayectoria();
            }
         } catch (Exception var29) {
            var29.printStackTrace();
         }

         if (this.hruta.ban == 0) {
            this.hruta.Acepto = true;
            this.hruta.PB.setVisible(false);
            this.hruta.PBLabel.setVisible(false);
            this.hruta.bandera = false;
            this.stop();
         } else {
            this.hruta.ban = 0;
            this.hruta.PB.setVisible(false);
            this.hruta.PBLabel.setVisible(false);
            this.hruta.bandera = false;
            this.stop();
         }

      }
   }
}
