package complejoTuristico;

public class cliente {

	
	private String nombre,NIF,tarjeta;
	
	boolean antiguedad;
	
	
	public cliente ( String nombre, String NIF, String tarjeta, boolean antiguedad) {
		this.NIF=NIF;
		this.nombre=nombre;
		this.tarjeta=tarjeta;
		this.antiguedad=antiguedad;
	}
	
	public String getDatos() {
		return "Nombre: "+nombre+" NIF:"+NIF+" Tarjeta: "+tarjeta+" Antiguedad:"+antiguedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String NIF) {
		this.NIF = NIF;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}


	public boolean getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(boolean antiguedad) {
		this.antiguedad = antiguedad;
	}

}
