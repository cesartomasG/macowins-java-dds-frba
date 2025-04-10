import estados.*;
import modelo.*;
import ventas.*;

public class Main {
  public static void main(String[] args) {
    Negocio macowins = new Negocio();

    Prenda saco = new Prenda(Tipo.SACO, 150.0, new Nueva());
    Prenda pantalon = new Prenda(Tipo.PANTALON, 120.0, new Promocion(20.0));
    Prenda camisa = new Prenda(Tipo.CAMISA, 80.0, new Liquidacion());

    Venta venta1 = new VentaEnEfectivo("2024-04-01");
    venta1.agregarItem(saco, 2);
    venta1.agregarItem(pantalon, 1);
    macowins.registrarVenta(venta1);

    Venta venta2 = new VentaConTarjeta("2024-04-01", 3);
    venta2.agregarItem(camisa, 2);
    macowins.registrarVenta(venta2);

    System.out.println("Ganancias del día: " + macowins.gananciasDe("2024-04-01"));
  }
}

/*
Este es el main del tp anterior aunque en este no se use.

Para el tp1 no continue con el desarrollo del tp0 y lo reforme para que sea mas similar
 a la solucion propuesta en los videos de templates
 */