package Diferido;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class Reporte {
   int cant_desconexiones;
   int desc_kijo = 0;
   int desc_corriente = 0;
   int desc_faltaT = 0;
   int desc_DatosV = 0;
   int desc_DatosVSAT = 0;
   int desc_voltaje = 0;
   int desc_antena = 0;
   int desc_sinSat = 0;
   int desc_ignicion = 0;
   int desc_ahorro_energia = 0;
   int desc_aliment_externa = 0;
   String t_desc_gps = "";
   String t_desc_V = "";
   String t_desc_datosVSAT = "";
   String t_desc_faltat = "";
   String t_desc_corr = "";
   String t_desc_volt = "";
   String t_desc_antena = "";
   String t_desc_sinSat = "";
   String t_desc_ignicion = "";
   String t_desc_ahorro = "";
   String t_desc_aliment_externa = "";
   String HR = "<table width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" border=\"1\" class=\"textrep\"><tr><td colspan=\"2\">Hoja de Ruta No: <b><#No></b></td><td colspan=\"2\">Fecha de Inicio: <b><#FI></b></td><td colspan=\"3\">Fecha Final: <b><#FF></b></td></tr><tr><td width=\"12%\">Km HR:<b><#KmHR></b> </td><td width=\"15%\">Comb. HR:<b><#CombHR></b> </td><td width=\"14%\">Km GPS: <b><#KmGPS></b></td><td width=\"15%\">Comb. GPS:<b><#CombGPS></b> </td><td width=\"13%\">Km S/R:<b><#KmSR></b> </td><td width=\"16%\">Comb. S/R:<b><#CombSR></b> </td><td width=\"15%\">Comb. MH:<b><#CombMH></b> </td></tr><tr><td>Tiempo HR:<b><#THR></b> </td><td>Tiempo Det:<b><#TDet></b> </td><td>Tiempo Mov:<b><#TMov></b> </td><td>Tiempo S/R:<b><#TSR></b> </td><td>Tiempo Det S/R:<b><#TDSR></b> </td><td>Tiempo Mov S/R:<b><#TMSR></b> </td><td>Tiempo MH:<b><#TMH></b> </td></tr><tr><td colspan=\"4\">Kms recorridos después de cerrada la última Hoja de Ruta según GPS:<b><#KmAfter></b> </td><td colspan=\"2\">Tiempo empleado:<b><#TAfter></b> </td></tr></table>";
   String Reporte = "<html><head><meta http-equiv=\"Content-Language\" content=\"en-us\"><meta name=\"GENERATOR\" content=\"Microsoft FrontPage 5.0\"><meta name=\"ProgId\" content=\"FrontPage.Editor.Document\"><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><title>Reporte R&aacute;pido de MovilWEB</title><style type=\"text/css\"><!--.t1rep {font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;font-weight : bold;font-size: 14px;}.t2rep {font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;font-weight : bold;font-size: 16px;}.textrep {font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;font-size: 12px;}.textrepempty {font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;font-size: 5px;}--></style></head><body><div class=\"t1rep\" align=\"center\" style=\"100%; background-color:#EDF3F8\"><p><img src=\"..\\..\\AyudaDiferido\\reporte.jpg\" width=\"100%\" height=\"66\"></p></div><table class=\"textrep\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"1\"><tr><td colspan=\"4\"bgcolor=\"#EDF3F8\"><span class=\"t1rep\" style=\"background-color:#EDF3F8; border: 1px solid #330000\"><strong>Versi&oacute;n Diferido:<b><#VERS></strong></b></td></tr></table><br><table class=\"textrep\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"1\"><tr><td height=\"17\" bgcolor=\"#EDF3F8\"><span class=\"t1rep\" style=\"width:100%; background-color:#EDF3F8; border: 1px solid #330000\">Fecha Actual</span></td><td height=\"17\" colspan=\"2\" bgcolor=\"#EDF3F8\"><span class=\"t1rep\" style=\"width:100%; background-color:#EDF3F8; border: 1px solid #330000\">Per&iacute;odo de Evaluaci&oacute;n </span></td></tr><tr><td width=\"44%\" height=\"16\">&nbsp;<strong><#FECHA></strong></td><td width=\"30%\">Desde:&nbsp;<strong><#DESDE></strong></td><td width=\"26%\">&nbsp;Hasta:&nbsp;<b><#HASTA></b></td></tr></table><br><table class=\"textrep\" cellSpacing=\"0\" cellPadding=\"0\" width=\"100%\" border=\"1\"><tr><td colspan=\"3\" bgcolor=\"#EDF3F8\"><span class=\"t1rep\" style=\"width:100%; background-color:#EDF3F8; border: 1px solid #330000\">Datos Generales del M&oacute;vil</span></td></tr><tr><td width=\"30%\">Chapa: <b><#CHAPA></b></td><td width=\"35%\">Indice de Consumo: <b><#INDICE></b> km/lts</td><td width=\"35%\">Indice de Consumo Tec: <b><#INDICETEC></b> L/h</td></tr><tr><td>N&uacute;mero: <b><#NUMERO></b></td><td>Desv. Indice de Consumo: <b><#DESVINDICE></b> %</td></tr><tr><td colspan=\"4\">Conductor(es): <b><#CONDUCTOR></b> </td></tr></table><br><table class=\"textrep\" cellSpacing=\"0\" cellPadding=\"0\" width=\"100%\" border=\"1\"><tr><td width=\"100%\" bgcolor=\"#EDF3F8\"><span class=\"t1rep\" style=\"background-color:#EDF3F8; border: 1px solid #330000\">Datos de Hoja de Ruta:(Cantidad de Hojas de Ruta: <b><#CANTHR></b>)</span></td></tr></table><#HRDETAIL><br><table width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" border=\"1\" class=\"textrep\"><tr><td colspan=\"2\" bgcolor=\"#EDF3F8\"><span class=\"t1rep\" style=\"background-color:#EDF3F8; border: 1px solid #330000\">Resumen de Distancias</span></td></tr><tr><td width=\"44%\">Distancia total recorrida seg&uacute;n GPS (km): <b><#DISTANCIA></b></td><td width=\"56%\">Combustible total consumido seg&uacute;n GPS (litros): <b><#CONSUMO></b></td></tr><tr><td width=\"44%\">Distancia de HR recorrida seg&uacute;n GPS (km): <b><#DISTANCIAGPSHR></b></td><td width=\"56%\">Combustible de HR consumido seg&uacute;n GPS (litros): <b><#CONSUMOGPSHR></b></td></tr><tr><td width=\"44%\">Distancia Total sin Respaldo (km): <b><#DISTANCIASResp></b></td><td width=\"56%\">Combustible Total consumido sin Respaldo (litros): <b><#CONSUMOSResp></b></td></tr><tr><td>Distancia recorrida seg&uacute;n HR (km): <b><#DISTANCIAHR></b></td><td>Combustible consumido seg&uacute;n HR (litros): <b><#CONSUMOHR></b></td></tr><tr><td>Distancia recorrida sin Respaldo (km): <b><#DISTANCIASR></b></td><td>Combustible consumido sin Respaldo (litros): <b><#CONSUMOSR></b></td></tr><tr><td>Diferencia de Recorrido GPS-HR (km): <b><#DISTANCIADIFF></b></td><td>Diferencia de Combustible GPS-HR (litros): <b><#CONSUMODIFF></b></td></tr><tr><td>Velocidad M&aacute;xima Alcanzada (km/h): <b><#MAXVEL></b></td><td>Velocidad Promedio (km/h): <b><#VELPROM></b></td></tr></table><br><table width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" border=\"1\" class=\"textrep\"><tr><td colspan=\"5\" bgcolor=\"#EDF3F8\"><span class=\"t1rep\" style=\"background-color:#EDF3F8; border: 1px solid #330000\">Resumen de Tiempos (H:M:S)</span></td></tr><tr><td>Detenciones: <b><#DETENCION></b></td><td>T. Total: <b><#TIEMPRECO></b></td><td>T. Detenido: <b><#TIEMPDETE></b></td><td>T. sin Respaldo: <b><#TIEMPSR></b></td><td>T. Movimiento: <b><#TIEMPEFECT></b></td></tr></table><br><table width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" border=\"1\" class=\"textrep\"><tr><td colspan=\"2\" bgcolor=\"#EDF3F8\"><span class=\"t1rep\" style=\"background-color:#EDF3F8; border: 1px solid #330000\">Calidad de los Datos</span></td></tr><tr><td>Tama&ntilde;o del Kijo: <b><#SIZE></b> MB</td></tr><tr><td width=\"44%\">Total de Tramas: <b><#TRAMAS></b></td><td width=\"56%\">Tramas no V&aacute;lidas: <b><#TRAMAS_NOVALID></b></td></tr><tr><td>Tramas Simplificadas:<b><#SIMPLIF></b> </td><td>Tramas no V&aacute;lidas al Inicio: <b><#NO_V_IN></b></td></tr><tr><td>Error de Suma Chequeo: <b><#CHECK></b></td><td>Tramas no V&aacute;lidas al Final:<b><#NO_V_FI></b></td></tr><tr><td>Tramas Transferidas:<b><#TRANSFER></b> </td><td>Tramas V&aacute;lidas:<b><#TRAMAS_VALID></b> </td></tr></table><br><table width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" border=\"1\" class=\"textrep\"><tr><td colspan=\"2\" bgcolor=\"#EDF3F8\"><span class=\"t1rep\" style=\"background-color:#EDF3F8; border: 1px solid #330000\">Resumen General de Desconexiones </span></td></tr><tr><td>Cantidad: <b><#NUM_DESCON></b></td><td width=\"56%\"></td></tr><tr><td>Desconexiones del GPS por Tarjeta:<b><#NUM_KIJO></b> </td><td>Tiempo Total (H:M:S):<b><#TOTAL_KIJO></b> </td></tr><tr><td>Desconexiones por Datos no V&aacute;lidos por posici&oacute;n:<b><#NUM_NOVALID></b> </td><td>Tiempo Total (H:M:S):<b><#TOTAL_NOVALID></b> </td></tr><tr><td>Desconexiones por Datos no V&aacute;lidos por sat&eacute;lite:<b><#NUM_NOVALIDSAT></b> </td><td>Tiempo Total (H:M:S):<b><#TOTAL_NOVALIDSAT></b></td></tr><tr><td>Desconexiones por Falta de Tramas:<b><#NUM_TRAMAS></b></td><td>Tiempo Total (H:M:S):<b><#TOTAL_FALTANTE></b></td></tr><tr><td>Desconexiones del GPS por Corriente:<b><#NUM_CORR></b> </td><td>Tiempo Total (H:M:S):<b><#TOTAL_CORR></b></td></tr><tr><td>Desconexiones por Alteraci&oacute;n de Voltaje:<b><#NUM_VOLT></b> </td><td>Tiempo Total (H:M:S):<b><#TOTAL_VOLT></b></td></tr><tr><td width=\"44%\">Desconexiones de Antena:<b><#NUM_ANTENA></b></td><td width=\"56%\">Tiempo Total (H:M:S):<b><#TOTAL_ANTENA></b></td></tr></table><br><#CDDETAIL><#ABASTDETAIL></body></html>";
   Datos_Hoja_de_Ruta dhr;
   Entrada en;
   CargaDescarga cd;
   Abastecimiento abast;

   public Reporte(Datos_Hoja_de_Ruta dhr, Entrada en, CargaDescarga cd, Abastecimiento abast) {
      this.dhr = dhr;
      this.en = en;
      this.cd = cd;
      this.abast = abast;
   }

   public String Fecha_Actual() {
      DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
      Date date = new Date();
      String datestr = dateformat.format(date);
      return datestr;
   }

   public void LlenarReporte() throws IOException {
      TablaReporteHR tabla = new TablaReporteHR(this);
      String ReporteHR = tabla.LlenarTabla();
      String RepCD = "";
      if (this.dhr.trafico.isSelected()) {
         ReporteCD rcd = new ReporteCD(this, this.cd, this.en, this.dhr);
         RepCD = rcd.LlenarTabla();
      }

      String RepABAST = "";
      if (this.dhr.abastecimient.isSelected()) {
         ReporteAbastecimiento rabast = new ReporteAbastecimiento(this, this.abast, this.en, this.dhr);
         RepABAST = rabast.LlenarTabla();
      }

      String version = this.en.version;
      String fecha_actual = this.Fecha_Actual();
      String desde = this.en.Fecha_Inicial + " " + this.en.Hora_Inicial;
      String hasta = this.en.Fecha_Final + " " + this.en.Hora_Final;
      String chapa = this.en.chapa;
      String indice_consumo = String.valueOf(this.en.Consumo);
      String indice_consumo_tec = String.valueOf(this.en.ConsumoTec);
      double desv_indice_consumo = this.dhr.desv_IConsumo;
      double desv_indice_consumo_tec = this.dhr.desv_IConsumo_Tec;
      desv_indice_consumo = this.dhr.Redondear_Numero(desv_indice_consumo, 2);
      String numero_vehiculo = this.en.NumeroVehiculo;
      String conductor;
      if (this.dhr.chofer_auxiliar.equalsIgnoreCase("")) {
         conductor = this.dhr.chofer;
      } else {
         conductor = this.dhr.chofer + " " + "y" + " " + this.dhr.chofer_auxiliar;
      }

      String CantidadHR = String.valueOf(this.dhr.ListaHr.size());
      double size = (double)this.en.Size / 1048576.0D;
      size = this.en.Redondear_Numero(size, 2);
      boolean alteracion = this.en.posible_alteracion;
      this.CalcularTipoDesconexiones();
      String total_tramas = String.valueOf(this.en.numero_de_lineas);
      String error_suma_chequeo = String.valueOf(this.en.chequeo_suma_fallido);
      String tramas_simplificadas = String.valueOf(this.en.tramas_simplificadas);
      String tramas_no_validas = String.valueOf(this.en.tramas_no_validas);
      String tramas_no_validas_inicio = String.valueOf(this.en.tramas_V_al_inicio);
      String tramas_no_validas_final = String.valueOf(this.en.tramas_V_al_final);
      String tramas_validas = String.valueOf(this.en.tramas_validas);
      String falla_de_datos = String.valueOf(this.en.lineas_nulas);
      int tramas_transferidas = this.dhr.cant_lineas_shp;
      double dist_GPS = 0.0D;
      if (this.dhr.en.Transferencia.equalsIgnoreCase("1")) {
         dist_GPS = this.dhr.distancia_recorrida_total / 1000.0D;
      } else if (this.dhr.en.Transferencia.equalsIgnoreCase("2")) {
         dist_GPS = this.dhr.distancia_recorrida_total / 1000.0D;
      } else if (this.dhr.en.Transferencia.equalsIgnoreCase("3")) {
         dist_GPS = this.dhr.distancia_recorrida_total / 1000.0D;
      } else if (this.dhr.en.Transferencia.equalsIgnoreCase("4")) {
         dist_GPS = this.dhr.distancia_recorrida_total / 1000.0D;
      } else {
         dist_GPS = this.dhr.distancia_recorrida_total / 1000.0D;
      }

      dist_GPS = this.dhr.Redondear_Numero(dist_GPS, 2);
      String distancia_GPS_Total = String.valueOf(dist_GPS);
      String distancia_GPS_HR = this.CalcularDistanciaGPS_HR();
      double distanciaGPSHR = Double.valueOf(distancia_GPS_HR);
      String distanciaSResp = this.CalcularDistanciaSResp();
      double distanciaSR = Double.valueOf(distanciaSResp);
      String dist_HR = this.CalcularDistanciaHR();
      String dist_sin_Resp = this.CalcularDistanciaSR();
      String diferenciaHr_GPS = this.CalcularDiferencia(dist_GPS, dist_HR);
      int veloc = (int)this.en.velocidad_maxima;
      String velocidad = String.valueOf(veloc);
      int velocprom = (int)this.en.velocidad_promedio;
      String velocidadprom = String.valueOf(velocprom);
      String combust_GPS = String.valueOf(this.dhr.Redondear_Numero(dist_GPS / this.en.Consumo, 2));
      String combust_GPS_HR = String.valueOf(this.dhr.Redondear_Numero(distanciaGPSHR / this.en.Consumo, 2));
      String combustSResp = String.valueOf(this.dhr.Redondear_Numero(distanciaSR / this.en.Consumo, 2));
      double combust_HR = Double.parseDouble(dist_HR) / this.en.Consumo;
      String combust_HRuta = String.valueOf(this.dhr.Redondear_Numero(combust_HR, 2));
      double combust_sin_Resp = Double.parseDouble(dist_sin_Resp) / this.en.Consumo;
      String combust_sin_Respaldo = String.valueOf(this.dhr.Redondear_Numero(combust_sin_Resp, 2));
      String diferencia_combust_HR_GPS = this.CalcularDiferenciaComb(combust_GPS, combust_HRuta);
      String cant_detenciones = String.valueOf(this.en.Paradas.size());
      String tiempo_total = this.Calcular_Tiempo_Total();
      String tiempo_detenido = this.Calcular_Tiempo_Detenido();
      String tiempo_sr = this.Calcular_Tiempo_SR();
      String tiempo_mov = this.Calcular_Tiempo_Mov(tiempo_total, tiempo_detenido);
      this.Reporte = this.Reporte.replace("<#HRDETAIL>", ReporteHR);
      this.Reporte = this.Reporte.replace("<#VERS>", version);
      this.Reporte = this.Reporte.replace("<#DESDE>", desde);
      this.Reporte = this.Reporte.replace("<#HASTA>", hasta);
      this.Reporte = this.Reporte.replace("<#CHAPA>", chapa);
      this.Reporte = this.Reporte.replace("<#INDICE>", indice_consumo);
      this.Reporte = this.Reporte.replace("<#DESVINDICE>", String.valueOf(desv_indice_consumo));
      this.Reporte = this.Reporte.replace("<#INDICETEC>", indice_consumo_tec);
      this.Reporte = this.Reporte.replace("<#DESVINDICETEC>", String.valueOf(desv_indice_consumo_tec));
      this.Reporte = this.Reporte.replace("<#NUMERO>", numero_vehiculo);
      this.Reporte = this.Reporte.replace("<#FECHA>", fecha_actual);
      this.Reporte = this.Reporte.replace("<#CONDUCTOR>", conductor);
      this.Reporte = this.Reporte.replace("<#CANTHR>", CantidadHR);
      this.Reporte = this.Reporte.replace("<#SIZE>", String.valueOf(size));
      this.Reporte = this.Reporte.replace("<#NUM_DESCON>", String.valueOf(this.cant_desconexiones));
      this.Reporte = this.Reporte.replace("<#TRAMAS>", total_tramas);
      this.Reporte = this.Reporte.replace("<#CHECK>", error_suma_chequeo);
      this.Reporte = this.Reporte.replace("<#TRAMAS_NOVALID>", tramas_no_validas);
      this.Reporte = this.Reporte.replace("<#NO_V_IN>", tramas_no_validas_inicio);
      this.Reporte = this.Reporte.replace("<#NO_V_FI>", tramas_no_validas_final);
      this.Reporte = this.Reporte.replace("<#TRAMAS_VALID>", tramas_validas);
      this.Reporte = this.Reporte.replace("<#TRANSFER>", String.valueOf(tramas_transferidas));
      this.Reporte = this.Reporte.replace("<#SIMPLIF>", tramas_simplificadas);
      this.Reporte = this.Reporte.replace("<#TRAMAS_FALLA>", falla_de_datos);
      this.Reporte = this.Reporte.replace("<#NUM_KIJO>", String.valueOf(this.desc_kijo));
      this.Reporte = this.Reporte.replace("<#NUM_NOVALID>", String.valueOf(this.desc_DatosV));
      this.Reporte = this.Reporte.replace("<#NUM_NOVALIDSAT>", String.valueOf(this.desc_DatosVSAT));
      this.Reporte = this.Reporte.replace("<#NUM_TRAMAS>", String.valueOf(this.desc_faltaT));
      this.Reporte = this.Reporte.replace("<#NUM_CORR>", String.valueOf(this.desc_corriente));
      this.Reporte = this.Reporte.replace("<#NUM_VOLT>", String.valueOf(this.desc_voltaje));
      this.Reporte = this.Reporte.replace("<#NUM_EXTERNA>", String.valueOf(this.desc_aliment_externa));
      this.Reporte = this.Reporte.replace("<#NUM_IGNICION>", String.valueOf(this.desc_ignicion));
      this.Reporte = this.Reporte.replace("<#NUM_ENERGIA>", String.valueOf(this.desc_ahorro_energia));
      this.Reporte = this.Reporte.replace("<#NUM_ANTENA>", String.valueOf(this.desc_antena));
      this.Reporte = this.Reporte.replace("<#NUM_SATELITE>", String.valueOf(this.desc_sinSat));
      this.Reporte = this.Reporte.replace("<#TOTAL_KIJO>", String.valueOf(this.t_desc_gps));
      this.Reporte = this.Reporte.replace("<#TOTAL_NOVALID>", String.valueOf(this.t_desc_V));
      this.Reporte = this.Reporte.replace("<#TOTAL_NOVALIDSAT>", String.valueOf(this.t_desc_datosVSAT));
      this.Reporte = this.Reporte.replace("<#TOTAL_FALTANTE>", String.valueOf(this.t_desc_faltat));
      this.Reporte = this.Reporte.replace("<#TOTAL_CORR>", String.valueOf(this.t_desc_corr));
      this.Reporte = this.Reporte.replace("<#TOTAL_VOLT>", String.valueOf(this.t_desc_volt));
      this.Reporte = this.Reporte.replace("<#TOTAL_EXTERNA>", String.valueOf(this.t_desc_aliment_externa));
      this.Reporte = this.Reporte.replace("<#TOTAL_IGNICION>", String.valueOf(this.t_desc_ignicion));
      this.Reporte = this.Reporte.replace("<#TOTAL_ENERGIA>", String.valueOf(this.t_desc_ahorro));
      this.Reporte = this.Reporte.replace("<#TOTAL_ANTENA>", String.valueOf(this.t_desc_antena));
      this.Reporte = this.Reporte.replace("<#TOTAL_SATELITE>", String.valueOf(this.t_desc_sinSat));
      this.Reporte = this.Reporte.replace("<#DISTANCIA>", distancia_GPS_Total);
      this.Reporte = this.Reporte.replace("<#DISTANCIAGPSHR>", distancia_GPS_HR);
      this.Reporte = this.Reporte.replace("<#DISTANCIASResp>", distanciaSResp);
      this.Reporte = this.Reporte.replace("<#DISTANCIAHR>", dist_HR);
      this.Reporte = this.Reporte.replace("<#DISTANCIASR>", dist_sin_Resp);
      this.Reporte = this.Reporte.replace("<#DISTANCIADIFF>", diferenciaHr_GPS);
      this.Reporte = this.Reporte.replace("<#CONSUMO>", combust_GPS);
      this.Reporte = this.Reporte.replace("<#CONSUMOGPSHR>", combust_GPS_HR);
      this.Reporte = this.Reporte.replace("<#CONSUMOSResp>", combustSResp);
      this.Reporte = this.Reporte.replace("<#CONSUMOHR>", combust_HRuta);
      this.Reporte = this.Reporte.replace("<#CONSUMOSR>", combust_sin_Respaldo);
      this.Reporte = this.Reporte.replace("<#CONSUMODIFF>", diferencia_combust_HR_GPS);
      this.Reporte = this.Reporte.replace("<#MAXVEL>", velocidad);
      this.Reporte = this.Reporte.replace("<#VELPROM>", velocidadprom);
      this.Reporte = this.Reporte.replace("<#DETENCION>", cant_detenciones);
      this.Reporte = this.Reporte.replace("<#TIEMPRECO>", tiempo_total);
      this.Reporte = this.Reporte.replace("<#TIEMPDETE>", tiempo_detenido);
      this.Reporte = this.Reporte.replace("<#TIEMPSR>", tiempo_sr);
      this.Reporte = this.Reporte.replace("<#TIEMPEFECT>", tiempo_mov);
      this.Reporte = this.Reporte.replace("<#CDDETAIL>", RepCD);
      this.Reporte = this.Reporte.replace("<#ABASTDETAIL>", RepABAST);
      File rep = new File(this.dhr.reporte.getPath());
      FileWriter fw = new FileWriter(rep, true);
      fw.write(this.Reporte);
      fw.close();
      String camino = rep.getPath();
      String Comando = "cmd /c \"" + camino + "\"";
      Process p = Runtime.getRuntime().exec(Comando);
   }

   public String CalcularDistanciaHR() {
      double distancia = 0.0D;

      HR hr;
      for(Iterator it = this.dhr.ListaHr.iterator(); it.hasNext(); distancia += hr.kmrec) {
         hr = (HR)it.next();
      }

      distancia = this.dhr.Redondear_Numero(distancia, 2);
      return String.valueOf(distancia);
   }

   public String CalcularDistanciaSR() {
      double distancia = 0.0D;

      HR hr;
      for(Iterator it = this.dhr.ListaHr.iterator(); it.hasNext(); distancia += hr.km_sin_respaldo) {
         hr = (HR)it.next();
      }

      distancia /= 1000.0D;
      distancia = this.dhr.Redondear_Numero(distancia, 2);
      return String.valueOf(distancia);
   }

   public String CalcularDiferencia(double dist_GPS, String dist_HR) {
      double distanciaHR = Double.parseDouble(dist_HR);
      double diferencia = dist_GPS - distanciaHR;
      diferencia = this.dhr.Redondear_Numero(diferencia, 2);
      return String.valueOf(diferencia);
   }

   public String CalcularDiferenciaComb(String combust_GPS, String combust_HR) {
      double dif = Double.parseDouble(combust_GPS) - Double.parseDouble(combust_HR);
      dif = this.dhr.Redondear_Numero(dif, 2);
      return String.valueOf(dif);
   }

   public String Calcular_Tiempo_Total() {
      int tiempo = 0;

      HR hr;
      for(Iterator it = this.dhr.ListaHr.iterator(); it.hasNext(); tiempo = (int)((long)tiempo + hr.tiempoHR)) {
         hr = (HR)it.next();
      }

      int hora = tiempo / 60;
      int min = tiempo % 60;
      String h = String.valueOf(hora);
      if (hora < 10) {
         h = "0" + hora;
      }

      String m = String.valueOf(min);
      if (min < 10) {
         m = "0" + min;
      }

      String t = h + ":" + m + ":" + "00";
      return t;
   }

   public String Calcular_Tiempo_Detenido() {
      int tiempo = 0;
      HR hr = null;

      for(Iterator it = this.dhr.ListaHr.iterator(); it.hasNext(); tiempo = (int)((long)tiempo + hr.tiempo_det_HR)) {
         hr = (HR)it.next();
      }

      int hora = tiempo / 60;
      int min = tiempo % 60;
      String h = String.valueOf(hora);
      if (hora < 10) {
         h = "0" + hora;
      }

      String m = String.valueOf(min);
      if (min < 10) {
         m = "0" + min;
      }

      String t = h + ":" + m + ":" + "00";
      return t;
   }

   public String Calcular_Tiempo_SR() {
      int tiempo = 0;
      Iterator it = this.dhr.ListaHr.iterator();
      int cant = this.dhr.ListaHr.size();
      byte c = 1;

      while(it.hasNext()) {
         HR hr = (HR)it.next();
         tiempo = (int)((long)tiempo + hr.tiempo_SR);
         if (c == cant) {
            tiempo = (int)((long)tiempo + hr.tiempo_after);
         }
      }

      int hora = tiempo / 60;
      int min = tiempo % 60;
      String h = String.valueOf(hora);
      if (hora < 10) {
         h = "0" + hora;
      }

      String m = String.valueOf(min);
      if (min < 10) {
         m = "0" + min;
      }

      String t = h + ":" + m + ":" + "00";
      return t;
   }

   public String Calcular_Tiempo_Mov(String tiempo_total, String tiempo_detenido) {
      String[] ttotal = tiempo_total.split(":");
      String[] tdet = tiempo_detenido.split(":");
      boolean acarreo = false;
      int h1 = Integer.parseInt(ttotal[0]);
      int min1 = Integer.parseInt(ttotal[1]);
      int h2 = Integer.parseInt(tdet[0]);
      int min2 = Integer.parseInt(tdet[1]);
      int min = min1 - min2;
      if (min < 0) {
         min += 60;
         acarreo = true;
      }

      int hora;
      if (acarreo) {
         hora = h1 - h2 - 1;
      } else {
         hora = h1 - h2;
      }

      String h = String.valueOf(hora);
      if (hora < 10) {
         h = "0" + hora;
      }

      String m = String.valueOf(min);
      if (min < 10) {
         m = "0" + min;
      }

      String t = h + ":" + m + ":" + "00";
      return t;
   }

   public void CalcularTipoDesconexiones() {
      long tiempo_desc_gps = 0L;
      long tiempo_desc_V = 0L;
      long tiempo_desc_datosVSAT = 0L;
      long tiempo_desc_faltat = 0L;
      long tiempo_desc_corr = 0L;
      long tiempo_desc_voltaje = 0L;
      long tiempo_desc_antena = 0L;
      long tiempo_desc_sinSat = 0L;
      long tiempo_desc_ign = 0L;
      long tiempo_desc_ahorro = 0L;
      long tiempo_aliment_externa = 0L;
      Iterator it = this.en.Desconexiones.iterator();

      while(it.hasNext()) {
         Desconexion desc = (Desconexion)it.next();
         if (desc.motivo == 0) {
            ++this.cant_desconexiones;
            ++this.desc_kijo;
            tiempo_desc_gps += desc.Tiempo_Desconexion();
         } else if (desc.motivo == 1) {
            ++this.cant_desconexiones;
            ++this.desc_DatosV;
            tiempo_desc_V += desc.Tiempo_Desconexion();
         } else if (desc.motivo == 6) {
            ++this.cant_desconexiones;
            ++this.desc_DatosVSAT;
            tiempo_desc_datosVSAT += desc.Tiempo_Desconexion();
         } else if (desc.motivo == 3) {
            ++this.cant_desconexiones;
            ++this.desc_corriente;
            tiempo_desc_corr += desc.Tiempo_Desconexion();
         } else if (desc.motivo == 5) {
            ++this.cant_desconexiones;
            ++this.desc_faltaT;
            tiempo_desc_faltat += desc.Tiempo_Desconexion();
         } else if (desc.motivo == 7) {
            ++this.cant_desconexiones;
            ++this.desc_voltaje;
            tiempo_desc_voltaje += desc.Tiempo_Desconexion();
         } else if (desc.motivo == 8) {
            ++this.cant_desconexiones;
            ++this.desc_antena;
            tiempo_desc_antena += desc.Tiempo_Desconexion();
         } else if (desc.motivo == 9) {
            ++this.desc_sinSat;
            tiempo_desc_sinSat += desc.Tiempo_Desconexion();
         } else if (desc.motivo == 10) {
            ++this.desc_ignicion;
            tiempo_desc_ign += desc.Tiempo_Desconexion();
         } else if (desc.motivo == 11) {
            ++this.desc_ahorro_energia;
            tiempo_desc_ahorro += desc.Tiempo_Desconexion();
         } else if (desc.motivo == 12) {
            ++this.desc_aliment_externa;
            tiempo_aliment_externa += desc.Tiempo_Desconexion();
         }
      }

      this.t_desc_gps = this.Tiempo(tiempo_desc_gps);
      this.t_desc_V = this.Tiempo(tiempo_desc_V);
      this.t_desc_corr = this.Tiempo(tiempo_desc_corr);
      this.t_desc_datosVSAT = this.Tiempo(tiempo_desc_datosVSAT);
      this.t_desc_faltat = this.Tiempo(tiempo_desc_faltat);
      this.t_desc_volt = this.Tiempo(tiempo_desc_voltaje);
      this.t_desc_antena = this.Tiempo(tiempo_desc_antena);
      this.t_desc_sinSat = this.Tiempo(tiempo_desc_sinSat);
      this.t_desc_ignicion = this.Tiempo(tiempo_desc_ign);
      this.t_desc_ahorro = this.Tiempo(tiempo_desc_ahorro);
      this.t_desc_aliment_externa = this.Tiempo(tiempo_aliment_externa);
   }

   public String Alteracion() {
      String retorno = "No";
      boolean alteracion = this.en.posible_alteracion;
      if (alteracion) {
         retorno = "<span class=\"Estilo4\">Sí</span>";
      }

      return retorno;
   }

   private String Tiempo(long tiempo_desc_faltat) {
      String hora = "0";
      String minuto = "0";
      String segundo = "0";
      int m = (int)(tiempo_desc_faltat / 60L);
      int seg = (int)(tiempo_desc_faltat % 60L);
      int h = m / 60;
      int min = m % 60;
      if (h < 10) {
         hora = hora + String.valueOf(h);
      } else {
         hora = String.valueOf(h);
      }

      if (min < 10) {
         minuto = minuto + String.valueOf(min);
      } else {
         minuto = String.valueOf(min);
      }

      if (seg < 10) {
         segundo = segundo + String.valueOf(seg);
      } else {
         segundo = String.valueOf(seg);
      }

      return hora + ":" + minuto + ":" + segundo;
   }

   public String ConvertirTiempo(long tiempoHR) {
      String hora = "0";
      String minuto = "0";
      int h = (int)(tiempoHR / 60L);
      int min = (int)(tiempoHR % 60L);
      if (h < 10) {
         hora = hora + h;
      } else {
         hora = String.valueOf(h);
      }

      if (min < 10) {
         minuto = minuto + min;
      } else {
         minuto = String.valueOf(min);
      }

      return hora + ":" + minuto;
   }

   public String ConvertirTiempo(long tiempoHR, long tiempo_det_HR) {
      long TiempoMov = tiempoHR - tiempo_det_HR;
      return this.ConvertirTiempo(TiempoMov);
   }

   private String LlenarDetalles() {
      String detail = "";
      if (this.en.Detalles.size() <= 0) {
         return detail;
      } else {
         String d;
         for(Iterator it = this.en.Detalles.iterator(); it.hasNext(); detail = detail + "<p>" + d + "</p>") {
            d = (String)it.next();
         }

         return detail;
      }
   }

   private String CalcularDistanciaGPS_HR() {
      double distancia = 0.0D;

      HR hr;
      for(Iterator it = this.dhr.ListaHr.iterator(); it.hasNext(); distancia += hr.km_gps) {
         hr = (HR)it.next();
      }

      distancia = this.dhr.Redondear_Numero(distancia / 1000.0D, 2);
      return String.valueOf(distancia);
   }

   private String Cant_Desconexiones() {
      int cant = 0;
      Iterator it = this.en.Desconexiones.iterator();

      while(it.hasNext()) {
         Desconexion d = (Desconexion)it.next();
         if (d.motivo != 0) {
            ++cant;
         }
      }

      return String.valueOf(cant);
   }

   private String CalcularDistanciaSResp() {
      double distancia = 0.0D;
      int cant_hr = this.dhr.ListaHr.size();
      int j = 0;
      Iterator it = this.dhr.ListaHr.iterator();

      while(it.hasNext()) {
         ++j;
         HR hr = (HR)it.next();
         distancia += hr.km_sin_respaldo;
         if (j == cant_hr) {
            distancia += hr.km_after;
         }
      }

      distancia = this.dhr.Redondear_Numero(distancia / 1000.0D, 2);
      return String.valueOf(distancia);
   }
}
