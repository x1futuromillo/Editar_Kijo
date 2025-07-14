package Diferido;

public class ReporteAbastecimiento {
   Reporte rep;
   Abastecimiento abs;
   Entrada en;
   Datos_Hoja_de_Ruta dhr;
   String ABAT = "<table width=\"100%\" border=\"1\" cellPadding=\"0\" cellSpacing=\"0\" class=\"textrep\"><tr><td colspan=\"9\" bgcolor=\"#EDF3F8\"><span class=\"t1rep\" style=\"background-color:#EDF3F8; border: 1px solid #330000\">Datos de Abastecimientos</span></td></tr><tr><td width=\"10%\"><div align=\"center\"><strong>Fecha Hora</strong></div></td><td width=\"10%\"><div align=\"center\"><strong>Comprobante</strong></div></td><td width=\"10%\"><div align=\"center\"><strong>Tarjeta</strong></div></td><td width=\"10%\"><div align=\"center\"><strong>Saldo Inicial ($)</strong></div></td><td width=\"10%\"><div align=\"center\"><strong>Abastecido (L)</strong></div></td><td width=\"10%\"><div align=\"center\"><strong>Saldo Final ($)</strong></div></td><td width=\"10%\"><div align=\"center\"><strong>Localidad</strong></div></td><td width=\"15%\"><div align=\"center\"><strong>Establecimiento</strong></div></td><td width=\"15%\"><div align=\"center\"><strong>Tipo Abastecimiento</strong></div></td></tr><#Filas></table>";
   String Datos = "<tr><td><div align=\"center\"><#Fech></div></td><td><div align=\"center\"><#No></div></td><td><div align=\"center\"><#Tarj></div></td><td><div align=\"center\"><#SaldoI></div></td><td><div align=\"center\"><#Cant></div></td><td><div align=\"center\"><#SaldoF></div></td><td><div align=\"center\"><#Loc></div></td><td><div align=\"center\"><#Est></div></td><td><div align=\"center\"><#Tipo></div></td></tr>";

   public ReporteAbastecimiento(Reporte rep, Abastecimiento abs, Entrada en, Datos_Hoja_de_Ruta dhr) {
      this.rep = rep;
      this.abs = abs;
      this.en = en;
      this.dhr = dhr;
   }

   public String LlenarTabla() {
      String Filas = "";
      int cant = this.dhr.listado_chip.size();

      for(int i = 0; i < cant; ++i) {
         ChipCombustible chip = (ChipCombustible)this.dhr.listado_chip.get(i);
         String f = this.Datos;
         f = f.replace("<#Fech>", chip.getFecha());
         f = f.replace("<#No>", chip.getNoComprobante());
         f = f.replace("<#Tarj>", chip.getNumero_tarjeta());
         f = f.replace("<#SaldoI>", chip.getSaldoInicial().toString());
         f = f.replace("<#Cant>", chip.getCantAbastecida().toString());
         f = f.replace("<#SaldoF>", chip.getSaldoFinal().toString());
         f = f.replace("<#Loc>", chip.getLocalidad());
         f = f.replace("<#Est>", chip.getEstablecimiento());
         f = f.replace("<#Tipo>", chip.getTipoAbastecimiento());
         Filas = Filas + f;
      }

      this.ABAT = this.ABAT.replace("<#Filas>", Filas);
      return this.ABAT;
   }
}
