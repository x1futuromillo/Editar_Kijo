package Diferido;

public class ReporteCD {
   Reporte rep;
   CargaDescarga cd;
   Entrada en;
   Datos_Hoja_de_Ruta dhr;
   String CD = "<table width=\"100%\" border=\"1\" cellPadding=\"0\" cellSpacing=\"0\" class=\"textrep\"><tr><td colspan=\"5\" bgcolor=\"#EDF3F8\"><span class=\"t1rep\" style=\"background-color:#EDF3F8; border: 1px solid #330000\">Datos de Carga y Descarga</span></td></tr><tr><td width=\"14%\"><div align=\"center\"><strong>Documento</strong></div></td><td width=\"14%\"><div align=\"center\"><strong>N&uacute;mero</strong></div></td><td width=\"33%\"><div align=\"center\"><strong>Mercanc&iacute;a</strong></div></td><td width=\"19%\"><div align=\"center\"><strong>Cantidad</strong></div></td></tr><#Filas><tr><td colspan=\"4\"><strong>N&uacute;mero de Viajes:<b><#NV></strong></b> </td></tr></table><br>";
   String Datos = "<tr><td><div align=\"center\"><#Doc></div></td><td><div align=\"center\"><#No></div></td><td><div align=\"center\"><#Prod></div></td><td><div align=\"center\"><#Cant></div></td></tr>";

   public ReporteCD(Reporte rep, CargaDescarga cd, Entrada en, Datos_Hoja_de_Ruta dhr) {
      this.rep = rep;
      this.cd = cd;
      this.en = en;
      this.dhr = dhr;
   }

   public String LlenarTabla() {
      String Filas = "";
      int cant = this.dhr.listado_prod.size();

      for(int i = 0; i < cant; ++i) {
         Productos p = (Productos)this.dhr.listado_prod.get(i);
         String f = this.Datos;
         f = f.replace("<#Doc>", p.documento);
         f = f.replace("<#No>", p.numero);
         f = f.replace("<#Prod>", p.mercancia);
         f = f.replace("<#Cant>", p.cant_merc);
         Filas = Filas + f;
      }

      this.CD = this.CD.replace("<#Filas>", Filas);
      this.CD = this.CD.replace("<#NV>", String.valueOf(this.dhr.viajes));
      return this.CD;
   }
}
