import ventas.Venta;

import java.util.ArrayList;
import java.util.List;

public class Negocio {
  private List<Venta> ventas = new ArrayList<>();

  public void registrarVenta(Venta venta) {
    ventas.add(venta);
  }

  public double gananciasDe(String fecha) {
    return ventas.stream()
        .filter(venta -> venta.getFecha().equals(fecha))
        .mapToDouble(Venta::importe)
        .sum();
  }
}
