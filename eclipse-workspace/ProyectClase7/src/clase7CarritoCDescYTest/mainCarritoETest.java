package clase7CarritoCDescYTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class mainCarritoETest {

	@Before
	public double hacerAntes() {
		String ruta = "C:\\\\Users\\\\Matias\\\\OneDrive\\\\Escritorio\\\\Mati\\\\cursos\\\\6.UTNArgProg\\\\clase5\\\\clase5.txt";

		int Id = 1;
		String DescProducto;
		Double Cantidad;
		Double Precio;
		File file = new File(ruta);
		double totalCarrito = 0;

		carritoComprasE Carrito = new carritoComprasE();

		try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8)) {

			while (sc.hasNextLine()) {

				String[] VectorString = (sc.nextLine()).split(",");

				DescProducto = VectorString[2];
				Cantidad = Double.parseDouble(VectorString[0]);
				Precio = Double.parseDouble(VectorString[1]);

				productoE obj = new productoE();
				obj.Descripcion = DescProducto;
				obj.idProducto = Id;
				obj.PrecioUnitario = Precio;
				Id += 1;

				itemCarritoE obj2 = new itemCarritoE();
				obj2.Leer_Cargar(obj, Cantidad);

				Carrito.precio(obj2);

				totalCarrito = Carrito.Total;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return totalCarrito;

	}

	@Test
	void testScannerClassIgual() {
		double precioTotalTest = hacerAntes();
		assertEquals(270.00, precioTotalTest);
	}
	
	@Test
	void testScannerClassNotNull() {
		double precioTotalTest = hacerAntes();
		assertNotNull(precioTotalTest);
	}
	
	@Test
	void testScannerClassFalse() {
		double precioTotalTest = hacerAntes
				();
		assertFalse(270.00 != precioTotalTest);
	}
	
	@Test
	void testScannerClassTrue() {
		double precioTotalTest = hacerAntes();
		assertTrue(270.00 == precioTotalTest);
	}

}

