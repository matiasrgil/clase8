package clase8;

public class productoE {

	public productoE(double idProd, String desc, double PU) {
		this.idProducto = idProd;
		this.Descripcion = desc;
		this.PrecioUnitario = PU;
	} 

	// Atributos
	public double idProducto;
	public String Descripcion;
	public double PrecioUnitario;

	// Metodos Atributos
	public double getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(double idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return PrecioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		PrecioUnitario = precioUnitario;
	}

	// Metodos
	public void Leer_Mostrar(double idProd, String desc, double PU) {
		this.idProducto = idProd;
		this.Descripcion = desc;
		this.PrecioUnitario = PU;
	}
}