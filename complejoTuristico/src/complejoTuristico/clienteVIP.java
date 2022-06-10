package complejoTuristico;

public class clienteVIP extends cliente {

	private String tarjetaVIP;
	
	public clienteVIP(String nombre, String NIF, String tarjeta, boolean antiguedad, String tarjetaVIP) {
		super(nombre, NIF, tarjeta, antiguedad);
		
		this.tarjetaVIP=tarjetaVIP;
	}

	public String getDatos() {
		return this.getNombre()+this.getNIF()+this.getTarjeta()+this.getAntiguedad()+tarjetaVIP;
	}

	
	
	public String getTarjetaVIP() {
		return tarjetaVIP;
	}

	public void setTarjetaVIP(String tarjetaVIP) {
		this.tarjetaVIP = tarjetaVIP;
	}
	
}
