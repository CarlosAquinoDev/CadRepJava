package TiendaZapatillas;



public class Main {

	
	public static void main(String[] args) {
		
		
		
		try {
			
			Conexion con = new Conexion();
			
			con.conectar();
			InterfazGraficaLogin.iniciar();
			
		}catch (Exception e) {
			System.out.println("Error al incializar la ventana");
		}
		
		
		

	}

}
