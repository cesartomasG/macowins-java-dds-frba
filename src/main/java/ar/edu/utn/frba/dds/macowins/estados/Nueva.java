package ar.edu.utn.frba.dds.macowins.estados;

public class Nueva implements Estado {
  @Override
  public double precioFinal(double precioOriginal) {
    return precioOriginal;
  }
}