package ar.edu.utn.frba.dds.macowins.modelo;

import ar.edu.utn.frba.dds.macowins.estados.Estado;

public class Prenda {
  private Tipo tipo;
  private double precioBase;
  private Estado estado;

  public Prenda(Tipo tipo, double precioBase, Estado estado) {
    this.tipo = tipo;
    this.precioBase = precioBase;
    this.estado = estado;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public double precio() {
    return estado.precioFinal(precioBase);
  }
}
