package TiendaZapatillas;

public class Zapatilla {

	private String id;
	private String modelo,color,valor;
	
	public Zapatilla(String id, String modelo, String color, String valor) {
		this.id=id;
		this.modelo=modelo;
		this.color=color;
		this.valor=valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
}
