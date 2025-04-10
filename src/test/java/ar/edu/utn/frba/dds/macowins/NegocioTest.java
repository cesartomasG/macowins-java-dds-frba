package ar.edu.utn.frba.dds.macowins;

import ar.edu.utn.frba.dds.macowins.modelo.Prenda;
import ar.edu.utn.frba.dds.macowins.modelo.Tipo;
import ar.edu.utn.frba.dds.macowins.estados.Nueva;
import ar.edu.utn.frba.dds.macowins.estados.Liquidacion;
import ar.edu.utn.frba.dds.macowins.ventas.Venta;
import ar.edu.utn.frba.dds.macowins.ventas.VentaEnEfectivo;
import ar.edu.utn.frba.dds.macowins.ventas.VentaConTarjeta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NegocioTest {

  @Test
  public void calculaCorrectamenteLasGananciasDelDia() {
    Negocio macowins = new Negocio();

    // Venta en efectivo: 1500 + 800 = 2300
    Venta venta1 = new VentaEnEfectivo("2025-04-10");
    venta1.agregarItem(new Prenda(Tipo.SACO, 1500, new Nueva()), 1);
    venta1.agregarItem(new Prenda(Tipo.PANTALON, 1600, new Liquidacion()), 1); // 1600 / 2 = 800

    // Venta con tarjeta: 1000 + recargos
    Venta venta2 = new VentaConTarjeta("2025-04-10", 2);
    venta2.agregarItem(new Prenda(Tipo.CAMISA, 1000, new Nueva()), 1);
    // recargo: (2 * 0.05) + 1% de 1000 = 0.10 + 10 = 10.10 -> total = 1010.10

    macowins.registrarVenta(venta1);
    macowins.registrarVenta(venta2);

    double gananciasEsperadas = 2300 + 1010.10;

    assertEquals(gananciasEsperadas, macowins.gananciasDe("2025-04-10"), 0.01);
  }

  @Test
  public void noCuentaVentasDeOtrasFechas() {
    Negocio macowins = new Negocio();

    Venta venta = new VentaEnEfectivo("2025-04-09");
    venta.agregarItem(new Prenda(Tipo.CAMISA, 500, new Nueva()), 1);

    macowins.registrarVenta(venta);

    assertEquals(0, macowins.gananciasDe("2025-04-10"), 0.01);
  }
}
