package clase7CarritoCDescYTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class descuentoFijoETest {
	
	@Test
	void testDescuentoFijoE() {
		descuentoFijoE descFijo = new descuentoFijoE();
		double totalCarrito = 270;
		double totalDescFijo = descFijo.realizarDescFijo(totalCarrito);
		assertEquals(243,totalDescFijo);
	}

}
