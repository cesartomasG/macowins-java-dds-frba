package estados;

public class Promocion implements Estado {
  private double descuento;

  public Promocion(double descuento) {
    this.descuento = descuento;
  }

  @Override
  public double precioFinal(double precioBase) {
    return precioBase - descuento;
  }
}