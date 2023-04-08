package clase7CarritoCDescYTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class descuentoPorcentajeTest {

	@Test
	void testRealizarDescPorc() {
		descuentoPorcentaje descPorc = new descuentoPorcentaje();
		double totalCarrito = 270;
		double totalDescPorc = descPorc.realizarDescPorc(10,totalCarrito);
		assertEquals(243,totalDescPorc);
	}

}
