package ar.edu.utn.frba.dds.macowins.ventas;

public class VentaConTarjeta extends Venta {
  private int cantidadCuotas;
  private static final double COEFICIENTE_TARJETA = 0.05;

  public VentaConTarjeta(String fecha, int cantidadCuotas) {
    super(fecha);
    this.cantidadCuotas = cantidadCuotas;
  }

  @Override
  public double importe() {
    double base = precioBase();
    double recargo = cantidadCuotas * COEFICIENTE_TARJETA + 0.01 * base;
    return base + recargo;
  }
}
