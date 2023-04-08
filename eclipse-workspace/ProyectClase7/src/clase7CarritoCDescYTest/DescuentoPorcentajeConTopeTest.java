package clase7CarritoCDescYTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DescuentoPorcentajeConTopeTest {

	@Test
	void testRealizarDescPorcCTope() {
		DescuentoPorcentajeConTope descPorcCTope = new DescuentoPorcentajeConTope();
		double totalCarrito = 270;
		double totalDescPorcCTope = descPorcCTope.realizarDescPorcCTope(10,totalCarrito);
		assertEquals(243,totalDescPorcCTope);
	}

}
