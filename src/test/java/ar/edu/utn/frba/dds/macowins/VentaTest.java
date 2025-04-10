package ar.edu.utn.frba.dds.macowins;

import ar.edu.utn.frba.dds.macowins.modelo.Prenda;
import ar.edu.utn.frba.dds.macowins.modelo.Tipo;
import ar.edu.utn.frba.dds.macowins.ventas.Venta;
import ar.edu.utn.frba.dds.macowins.ventas.VentaConTarjeta;
import ar.edu.utn.frba.dds.macowins.ventas.VentaEnEfectivo;
import ar.edu.utn.frba.dds.macowins.estados.Nueva;
import ar.edu.utn.frba.dds.macowins.estados.Liquidacion;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VentaTest {

  @Test
  public void ventaEnEfectivoCalculaBienElImporte() {
    Venta venta = new VentaEnEfectivo("2025-04-10");
    Prenda camisa = new Prenda(Tipo.CAMISA, 1000, new Nueva());
    Prenda pantalon = new Prenda(Tipo.PANTALON, 800, new Liquidacion()); // 800 / 2 = 400

    venta.agregarItem(camisa, 1);   // 1000
    venta.agregarItem(pantalon, 2); // 400 * 2 = 800

    assertEquals(1800, venta.importe(), 0.01); // 1000 + 800
  }

  @Test
  public void ventaConTarjetaCalculaBienElImporte() {
    Venta venta = new VentaConTarjeta("2025-04-10", 3);
    Prenda camisa = new Prenda(Tipo.CAMISA, 2000, new Nueva());

    venta.agregarItem(camisa, 1); // base = 2000

    // recargo: 3 * 0.05 = 0.15 + (1% de 2000 = 20) => total = 2000 + 0.15 + 20 = 2020.15
    assertEquals(2020.15, venta.importe(), 0.01);
  }

  @Test
  public void sePuedeObtenerLaFechaDeUnaVenta() {
    Venta venta = new VentaEnEfectivo("2025-04-10");
    assertEquals("2025-04-10", venta.getFecha());
  }
}
