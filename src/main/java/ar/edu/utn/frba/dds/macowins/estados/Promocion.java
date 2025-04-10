package ar.edu.utn.frba.dds.macowins.estados;

public class Promocion implements Estado {
  private double descuento;

  public Promocion(double descuento) {
    this.descuento = descuento;
  }

  @Override
  public double precioFinal(double precioOriginal) {
    return precioOriginal - descuento;
  }
}