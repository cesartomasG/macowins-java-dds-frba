package ar.edu.utn.frba.dds.macowins.estados;

public class Liquidacion implements Estado {
  @Override
  public double precioFinal(double precioOriginal) {
    return precioOriginal * 0.5;
  }
}