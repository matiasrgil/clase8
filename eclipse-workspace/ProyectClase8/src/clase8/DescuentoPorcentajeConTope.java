package clase8;


import java.util.Scanner;

public class DescuentoPorcentajeConTope extends descuentoE {

	DescuentoPorcentajeConTope() {

	}
	
	int descAux= 0;

	public int getDescAux() {
		return descAux;
	}

	public void setDescAux(int descAux) {
		this.descAux = descAux;
	}
	
	
	public double realizarDescPorcCTope(int desc, double valor) {
		double totalCDesc = 0;

		do {
			if (desc < 30) {
				totalCDesc = valor - ((valor * desc) / 100);
				break;
			} else {
				System.out.println("No se puede realizar dicho descuento\nEl descuento no puede pasar el 30%");
				System.out.println("Introduzca el descuento a realizar");
				Scanner descScn = new Scanner(System.in);
				desc = descScn.nextInt();
				descAux = desc;
			}
		} while (desc > 30);

		return totalCDesc;
	}
}

