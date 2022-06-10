package TiendaZapatillas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public static final String controlador="com.mysql.cj.jdbc.Driver";
	public static final String url="jdbc:mysql://localhost:3306/zapatillasapp";
	public static final String usuario="root";
	public static final String password="";
	public static Connection conexion = null;
	
	static {
		try {
			Class.forName(controlador);
		}catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el driver");
		}
		
	}
	
	@SuppressWarnings("finally")
	public Connection conectar() throws SQLException {
		
		
		
			try {
				
				//
				conexion = DriverManager.getConnection(url,usuario,password);
				
				//System.out.println("Conexión OK");
				
				
				
			} catch (SQLException e) {
				System.out.println("Error al conectarse a base de datos");
			}finally {

				return conexion;
				
			}
		
		
		
		
		
	}
	
	

}
