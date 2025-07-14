package Diferido;

import com.vividsolutions.jts.geom.Point;

public class ChipCombustible {
   private String fecha;
   private String numero_tarjeta;
   private String noComprobante;
   private Double cantAbastecida;
   private String localidad;
   private String establecimiento;
   private Integer idtarjeta;
   private Integer idloc;
   private Integer idest;
   private Double saldoInicial;
   private Double saldoFinal;
   private String tipoAbastecimiento;
   private Point geomEstablecimiento;

   public ChipCombustible(String fecha, String numero_tarjeta, String noComprobante, Double cantAbastecida, String localidad, String establecimiento, Integer idtarjeta, Integer idloc, Integer idest, String tipoAbast, Point geomEstab, double saldoInicial, double saldoFinal) {
      this.fecha = fecha;
      this.numero_tarjeta = numero_tarjeta;
      this.noComprobante = noComprobante;
      this.cantAbastecida = cantAbastecida;
      this.localidad = localidad;
      this.establecimiento = establecimiento;
      this.idtarjeta = idtarjeta;
      this.idloc = idloc;
      this.idest = idest;
      this.tipoAbastecimiento = tipoAbast;
      this.geomEstablecimiento = geomEstab;
      this.saldoInicial = saldoInicial;
      this.saldoFinal = saldoFinal;
   }

   public String getFecha() {
      return this.fecha;
   }

   public String getNumero_tarjeta() {
      return this.numero_tarjeta;
   }

   public String getNoComprobante() {
      return this.noComprobante;
   }

   public Double getCantAbastecida() {
      return this.cantAbastecida;
   }

   public String getLocalidad() {
      return this.localidad;
   }

   public String getEstablecimiento() {
      return this.establecimiento;
   }

   public Integer getidtarjeta() {
      return this.idtarjeta;
   }

   public Integer getidloc() {
      return this.idloc;
   }

   public Integer getidest() {
      return this.idest;
   }

   public String getTipoAbastecimiento() {
      return this.tipoAbastecimiento;
   }

   Point getGeomEstablecimiento() {
      return this.geomEstablecimiento;
   }

   public Double getSaldoInicial() {
      return this.saldoInicial;
   }

   public Double getSaldoFinal() {
      return this.saldoFinal;
   }

   public void setFecha(String fecha) {
      this.fecha = fecha;
   }

   public void setNumero_tarjeta(String numero_tarjeta) {
      this.numero_tarjeta = numero_tarjeta;
   }

   public void setNoComprobante(String noComprobante) {
      this.noComprobante = noComprobante;
   }

   public void setCantAbastecida(Double cantAbastecida) {
      this.cantAbastecida = cantAbastecida;
   }

   public void setLocalidad(String localidad) {
      this.localidad = localidad;
   }

   public void setEstablecimiento(String establecimiento) {
      this.establecimiento = establecimiento;
   }

   public void setidtarjeta(Integer idtarjeta) {
      this.idtarjeta = idtarjeta;
   }

   public void setidloc(Integer idloc) {
      this.idloc = idloc;
   }

   public void setidest(Integer idest) {
      this.idest = idest;
   }

   public void setTipoAbastecimiento(String tipoAbastecimiento) {
      this.tipoAbastecimiento = tipoAbastecimiento;
   }

   public void setGeomEstablecimiento(Point geomEstablecimiento) {
      this.geomEstablecimiento = geomEstablecimiento;
   }

   public void setSaldoInicial(Double saldoInicial) {
      this.saldoInicial = saldoInicial;
   }

   public void setSaldoFinal(Double saldoFinal) {
      this.saldoFinal = saldoFinal;
   }
}
