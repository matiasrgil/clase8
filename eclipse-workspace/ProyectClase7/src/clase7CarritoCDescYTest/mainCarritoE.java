package clase7CarritoCDescYTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class mainCarritoE {

	public static void main(String[] args) {

		String ruta = "C:\\\\Users\\\\Matias\\\\OneDrive\\\\Escritorio\\\\Mati\\\\cursos\\\\6.UTNArgProg\\\\clase5\\\\clase5.txt";

		ScannerClass(ruta);
	}

	public static void ScannerClass(String ruta) {
		int Id = 1;
		String DescProducto;
		Double Cantidad;
		Double Precio;
		File file = new File(ruta);
		
		double totalCarrito = 0;
		String valueDesc = "";
		int valueMenu = 0;
		int desc1 = 0;
		int desc2 = 0;
		int descAux = 0;

		carritoComprasE Carrito = new carritoComprasE();
		try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8)) {
			System.out.println("cant	precioUnitario	producto	\n");

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

				System.out.println(obj2.Cantidad + "	" + obj.PrecioUnitario + "		" + obj.Descripcion);
				// System.out.println("\n "+ obj.idProducto + " - " + obj.Descripcion + " x " +
				// obj2.Cantidad);
				// System.out.println("Precio unitario: $" + obj.PrecioUnitario + " Precio x " +
				// obj2.Cantidad + ": $" + (obj.PrecioUnitario*obj2.Cantidad));
			}
			System.out.println("	carrito.precio()==" + totalCarrito);
			// System.out.println("\nTotalCarrito: $"+ totalCarrito);

			System.out.println("\nDesea realizar un descuento? (S/N)");

			do {

				Scanner valueDescScn = new Scanner(System.in);
				valueDesc = valueDescScn.nextLine().toUpperCase();

				if (valueDesc.equals("N")) {
					System.out.println(
							"\nNo se le ha realizado ningun descuento\nGracias por utilizar nuestros servicios");
					break;
				} else if (valueDesc.equals("S")) {

					System.out.println("\nSeleccione la opcion deseada");
					System.out.println("1 - Descuento fijo del 10%");
					System.out.println("2 - Descuento por porcentaje");
					System.out.println("3 - Descuento por porcentaje con un tope maximo del 30%");
					System.out.println("4 - Para no realizar descuento");

					Scanner valueMenuScn = new Scanner(System.in);
					valueMenu = valueMenuScn.nextInt();

					switch (valueMenu) {
					case 1:
						descuentoFijoE descuentoFijo = new descuentoFijoE();
						double totalCdescFijo = descuentoFijo.realizarDescFijo(totalCarrito);

						System.out.println("El total con el descuento fijo del 10 % es $" + totalCdescFijo);
						break;
					case 2:
						descuentoPorcentaje descPorc = new descuentoPorcentaje();

						System.out.println("Introduzca el descuento a realizar");
						Scanner desc1Scn = new Scanner(System.in);
						desc1 = desc1Scn.nextInt();

						double totalDescPorc = descPorc.realizarDescPorc(desc1, totalCarrito);
						System.out.println("El total con el descuento de " + desc1 + "% es $" + totalDescPorc);
						break;
					case 3:
						DescuentoPorcentajeConTope descPorcCTope = new DescuentoPorcentajeConTope();

						System.out.println("Introduzca el descuento a realizar");
						Scanner desc2Scn = new Scanner(System.in);
						desc2 = desc2Scn.nextInt();
						double totalDescPorcCTope = descPorcCTope.realizarDescPorcCTope(desc2, totalCarrito);
						descAux = descPorcCTope.getDescAux();
						if (descAux != 0) {
							totalDescPorcCTope = descPorcCTope.realizarDescPorcCTope(descAux, totalCarrito);
							descAux = descPorcCTope.getDescAux();
							System.out.println(
									"El total con el otro descuento de " + descAux + "% es $" + totalDescPorcCTope);
						} else {
							System.out.println("El total con el descuento de " + desc2 + "% es $" + totalDescPorcCTope);
						}
						break;
					case 4:
						System.out.println(
								"\nNo se le ha realizado ningun descuento\nGracias por utilizar nuestros servicios");
						break;
					}
				} else {
					System.out.println("Solo debe responder 'S' o 'N', segun desee\n");
				}
			} while ((!valueDesc.equals("S")) && (!valueDesc.equals("N")));

		} catch (

		IOException e) {
			e.printStackTrace();
		}
	}

}

