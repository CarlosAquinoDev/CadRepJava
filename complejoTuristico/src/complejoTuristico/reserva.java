package complejoTuristico;

public class reserva {
	
	private String idReserva,idAlojamiento,idCliente;
	private int diasReserva;
	
	public reserva(String idReserva,String idAlojamiento,String idCliente,int diasReserva) {
		this.idReserva=idReserva;
		this.idAlojamiento=idAlojamiento;
		this.idCliente=idCliente;
		this.diasReserva=diasReserva;
	}
	
	public String getDatos() {
		return "idReserva:"+idReserva+" Cliente: "+idCliente+" Alojado en:"+idAlojamiento+" durante: "+diasReserva+"días";
	}

	public String getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	public String getIdAlojamiento() {
		return idAlojamiento;
	}

	public void setIdAlojamiento(String idAlojamiento) {
		this.idAlojamiento = idAlojamiento;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public int getDiasReserva() {
		return diasReserva;
	}

	public void setDiasReserva(int diasReserva) {
		this.diasReserva = diasReserva;
	}
	

}
