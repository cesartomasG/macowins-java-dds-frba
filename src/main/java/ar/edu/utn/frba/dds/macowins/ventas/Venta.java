package ar.edu.utn.frba.dds.macowins.ventas;

import ar.edu.utn.frba.dds.macowins.modelo.Item;
import ar.edu.utn.frba.dds.macowins.modelo.Prenda;
import java.util.ArrayList;
import java.util.List;


public abstract class Venta {
  protected List<Item> items = new ArrayList<>();
  protected String fecha;

  public Venta(String fecha) {
    this.fecha = fecha;
  }

  public void agregarItem(Prenda prenda, int cantidad) {
    items.add(new Item(prenda, cantidad));
  }

  protected double precioBase() {
    return items.stream().mapToDouble(Item::importe).sum();
  }

  public abstract double importe();

  public String getFecha() {
    return fecha;
  }
}