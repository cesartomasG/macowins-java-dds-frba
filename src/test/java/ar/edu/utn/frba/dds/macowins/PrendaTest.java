package ar.edu.utn.frba.dds.macowins;

import ar.edu.utn.frba.dds.macowins.estados.Nueva;
import ar.edu.utn.frba.dds.macowins.estados.Liquidacion;
import ar.edu.utn.frba.dds.macowins.estados.Promocion;


import ar.edu.utn.frba.dds.macowins.modelo.Prenda;
import ar.edu.utn.frba.dds.macowins.modelo.Tipo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {

  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    assertEquals(camisaNueva(200).getTipo().toString(), "CAMISA");
  }

  @Test
  public void elTipoDeUnSacoEnLiquidacionEsSACO() {
    assertEquals(sacoEnLiquidacion(200).getTipo().toString(), "SACO");
  }

  @Test
  public void elPrecioDeUnaCamisaNuevaEsSuPrecioBase() {
    assertEquals(camisaNueva(4000).precio(), 4000, 0);
    assertEquals(camisaNueva(5000).precio(), 5000, 0);
  }

  @Test
  public void elPrecioDeUnSacoEnLiquidacionEsSuLaMitadDeSuPrecioBase() {
    assertEquals(sacoEnLiquidacion(3000).precio(), 1500, 0);
    assertEquals(sacoEnLiquidacion(8000).precio(), 4000, 0);
  }

  @Test
  public void elPrecioDeUnPantalonEnPromocionEsSuPrecioBaseMenosSuDecuento() {
    assertEquals(pantalonEnPromocion(1500, 200).precio(), 1300, 0);
    assertEquals(pantalonEnPromocion(1500, 100).precio(), 1400, 0);
  }

  private Prenda pantalonEnPromocion(int precioBase, int descuento) {
    return new Prenda(Tipo.PANTALON, precioBase, new Promocion(descuento));
  }


  private Prenda camisaNueva(double precioBase) {
    return new Prenda(Tipo.CAMISA, precioBase, new Nueva());
  }

  private Prenda sacoEnLiquidacion(double precioBase) {
    return new Prenda(Tipo.SACO, precioBase, new Liquidacion());
  }
}
