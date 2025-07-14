package Diferido;

import java.util.Iterator;

public class TablaReporteHR {
   Reporte rep;
   String After = "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"1\" class=\"textrep\"><tr><td width=\"65%\">Kms recorridos despu&eacute;s de cerrada la &uacute;ltima Hoja de Ruta seg&uacute;n GPS:<b><#KmAfter></b></td><td width=\"35%\">Tiempo empleado:<b><#TAfter></b></td></tr></table>";
   String After1 = "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"1\" class=\"textrep\"><tr><td width=\"65%\">Kms recorridos despu&eacute;s de cerrada la Hoja de Ruta seg&uacute;n GPS:<b><#KmAfter></b></td><td width=\"35%\">Tiempo empleado:<b><#TAfter></b></td></tr></table>";
   String HojaRuta = "<table width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" border=\"1\" class=\"textrep\"><tr><td colspan=\"2\">Hoja de Ruta No: <b><#No></b></td><td colspan=\"2\">Fecha de Inicio: <b><#FI></b></td><td colspan=\"3\">Fecha Final: <b><#FF></b></td></tr><tr><td width=\"12%\">Km HR:<b><#KmHR></b> </td><td width=\"15%\">Comb. HR:<b><#CombHR></b> </td><td width=\"14%\">Km GPS: <b><#KmGPS></b></td><td width=\"15%\">Comb. GPS:<b><#CombGPS></b> </td><td width=\"13%\">Km S/R:<b><#KmSR></b> </td><td width=\"16%\">Comb. S/R:<b><#CombSR></b> </td><td width=\"15%\">Comb. MH:<b><#CombMH></b> </td></tr><tr><td>Tiempo HR:<b><#THR></b></td><td>Tiempo Det:<b><#TDet></b></td><td>Tiempo Mov:<b><#TMov></b></td><td>Tiempo S/R:<b><#TSR></b></td><td>Tiempo Det S/R:<b><#TDSR></b></td><td>Tiempo Mov S/R:<b><#TMSR></b></td><td>Tiempo MH:<b><#TMH></b> </td></tr></table>";

   public TablaReporteHR(Reporte r) {
      this.rep = r;
   }

   public String LlenarTabla() {
      String combMH = "";
      String Reporte = "";
      String HRuta = "";
      int cant_hr = this.rep.dhr.ListaHr.size();
      int c = 0;
      Iterator it = this.rep.dhr.ListaHr.iterator();

      while(true) {
         while(it.hasNext()) {
            ++c;
            HR hr = (HR)it.next();
            String NoHR = String.valueOf(hr.numero);
            String fi = hr.fi + " " + hr.hi;
            String ff = hr.ff + " " + hr.hf;
            String kmHR = String.valueOf(this.rep.dhr.Redondear_Numero(hr.kmrec, 2));
            String combHR = String.valueOf(this.rep.dhr.Redondear_Numero(hr.kmrec / this.rep.en.Consumo, 2));
            String kmGPS = String.valueOf(this.rep.dhr.Redondear_Numero(hr.km_gps / 1000.0D, 2));
            String combGPS = String.valueOf(this.rep.dhr.Redondear_Numero(hr.km_gps / 1000.0D / this.rep.en.Consumo, 2));
            String kmSR = String.valueOf(this.rep.dhr.Redondear_Numero(hr.km_sin_respaldo / 1000.0D, 2));
            String combSR = String.valueOf(this.rep.dhr.Redondear_Numero(hr.km_sin_respaldo / 1000.0D / this.rep.en.Consumo, 2));
            String[] MH = hr.tiempoMH.split(":");
            double h = Double.parseDouble(MH[0]) * this.rep.en.ConsumoTec;
            double min = Double.parseDouble(MH[1]) / 60.0D;
            double tmh = h + min * this.rep.en.ConsumoTec;
            combMH = String.valueOf(this.rep.dhr.Redondear_Numero(tmh, 2));
            String TiempoHR = this.rep.ConvertirTiempo(hr.tiempoHR);
            String TiempoDet = this.rep.ConvertirTiempo(hr.tiempo_det_HR);
            String TiempoMov = this.rep.ConvertirTiempo(hr.tiempoHR, hr.tiempo_det_HR);
            String TiempoSR = this.rep.ConvertirTiempo(hr.tiempo_SR);
            String TiempoDetSR = this.rep.ConvertirTiempo(hr.tiempo_det_SR);
            String TiempoMovSR = this.rep.ConvertirTiempo(hr.tiempo_SR, hr.tiempo_det_SR);
            String TiempoMH = hr.tiempoMH;
            String kmAfter = String.valueOf(this.rep.dhr.Redondear_Numero(hr.km_after / 1000.0D, 2));
            String TiempoAfter = this.rep.ConvertirTiempo(hr.tiempo_after);
            HRuta = this.HojaRuta;
            HRuta = HRuta.replace("<#No>", NoHR);
            HRuta = HRuta.replace("<#FI>", fi);
            HRuta = HRuta.replace("<#FF>", ff);
            HRuta = HRuta.replace("<#KmHR>", kmHR);
            HRuta = HRuta.replace("<#CombHR>", combHR);
            HRuta = HRuta.replace("<#KmGPS>", kmGPS);
            HRuta = HRuta.replace("<#CombGPS>", combGPS);
            HRuta = HRuta.replace("<#KmSR>", kmSR);
            HRuta = HRuta.replace("<#CombSR>", combSR);
            HRuta = HRuta.replace("<#CombMH>", combMH);
            HRuta = HRuta.replace("<#THR>", TiempoHR);
            HRuta = HRuta.replace("<#TDet>", TiempoDet);
            HRuta = HRuta.replace("<#TMov>", TiempoMov);
            HRuta = HRuta.replace("<#TSR>", TiempoSR);
            HRuta = HRuta.replace("<#TDSR>", TiempoDetSR);
            HRuta = HRuta.replace("<#TMSR>", TiempoMovSR);
            HRuta = HRuta.replace("<#TMH>", TiempoMH);
            if (c == 1 && c == cant_hr) {
               this.After1 = this.After1.replace("<#KmAfter>", kmAfter);
               this.After1 = this.After1.replace("<#TAfter>", TiempoAfter);
               Reporte = HRuta + this.After1;
            } else if (c == cant_hr) {
               this.After = this.After.replace("<#KmAfter>", kmAfter);
               this.After = this.After.replace("<#TAfter>", TiempoAfter);
               Reporte = Reporte + "<br>" + HRuta + this.After;
            } else if (c == 1) {
               Reporte = HRuta;
            } else {
               Reporte = Reporte + "<br>" + HRuta;
            }
         }

         return Reporte;
      }
   }
}
