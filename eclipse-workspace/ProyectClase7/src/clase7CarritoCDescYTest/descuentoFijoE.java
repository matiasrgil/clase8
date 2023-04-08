package clase7CarritoCDescYTest;

public class descuentoFijoE extends descuentoE{
	
	public descuentoFijoE(){
		
	}

	public double realizarDescFijo(double valor) {
		double totalCDesc = 0;
		totalCDesc = valor - ((valor * 10)/100);
		return totalCDesc;
	}
	
}