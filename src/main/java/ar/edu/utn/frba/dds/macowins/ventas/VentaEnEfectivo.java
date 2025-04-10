package ar.edu.utn.frba.dds.macowins.ventas;

public class VentaEnEfectivo extends Venta {
  public VentaEnEfectivo(String fecha) {
    super(fecha);
  }

  @Override
  public double importe() {
    return precioBase();
  }
}
