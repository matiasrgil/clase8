package clase7CarritoCDescYTest;

public class descuentoPorcentaje {

	descuentoPorcentaje() {

	}

	public double realizarDescPorc(int desc, double valor) {

		double totalCDescPorc = 0;
		totalCDescPorc = valor - ((valor * desc) / 100);

		return totalCDescPorc;
	}
}
