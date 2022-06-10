package complejoTuristico;

public class alojamiento {
	
	private int precioNoche,maxVisitantes,ubicacion;
	private String tipo_Alojamiento,id_Alojamiento,info_Compartida1;
	private boolean info_Compartida2;
	
	
	public alojamiento (String tipo_Alojamiento, String id_Alojamiento, int precioNoche,int maxVisitantes, int ubicacion,String info_Compartida1,Boolean info_Compartida2) {
		
		this.tipo_Alojamiento=tipo_Alojamiento;
		this.id_Alojamiento=id_Alojamiento;
		this.precioNoche=precioNoche;
		this.maxVisitantes=maxVisitantes;
		this.ubicacion=ubicacion;
		this.info_Compartida1=info_Compartida1;
		this.info_Compartida2=info_Compartida2;
	
	}

public String mostrar_Alojamiento () {
	return  " id: "+id_Alojamiento+" Precio noche: "+precioNoche+" Visitantes máximos: "+maxVisitantes+" Ubicado en zona: "+ubicacion;
}

	public String getInfo_Compartida1() {
		return info_Compartida1;
	}



	public void setInfo_Compartida1(String info_Compartida1) {
		this.info_Compartida1 = info_Compartida1;
	}



	public boolean isInfo_Compartida2() {
		return info_Compartida2;
	}


	public void setInfo_Compartida2(boolean info_Compartida2) {
		this.info_Compartida2 = info_Compartida2;
	}



	public String getId_Alojamiento() {
		return id_Alojamiento;
	}



	public void setId_Alojamiento(String id_Alojamiento) {
		this.id_Alojamiento = id_Alojamiento;
	}



	public String getTipo_Alojamiento() {
		return tipo_Alojamiento;
	}



	public void setTipo_Alojamiento(String tipo_Alojamiento) {
		this.tipo_Alojamiento = tipo_Alojamiento;
	}



	public int getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(int precioNoche) {
		this.precioNoche = precioNoche;
	}

	public int getMaxVisitantes() {
		return maxVisitantes;
	}

	public void setMaxVisitantes(int maxVisitantes) {
		this.maxVisitantes = maxVisitantes;
	}

	public int getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	
	

}
