package complejoTuristico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class datos {

	
	//Variables
	static String alojamientos_Enlace="C:/Users/caqui/OneDrive/Escritorio/Proyectos Fiver/Nueva carpeta/Alojamientos.txt";
	static String clientes_Enlace="C:/Users/caqui/OneDrive/Escritorio/Proyectos Fiver/Nueva carpeta/Clientes.txt";
	static ArrayList<alojamiento> alojamientos = new ArrayList<alojamiento>();
	static ArrayList<cliente> clientes = new ArrayList<cliente>();
	static ArrayList<clienteVIP> clientesVIP = new ArrayList<clienteVIP>();
	static List <String> alojamientosDisponibles = new ArrayList<String>();
	
	
	public static void cargar () {
		// Añadimos al Arraylist los alojamientos
				try {
					// Cargamos datos en un buffered, definimos la ruta del archivo
					BufferedReader reader = new BufferedReader(new FileReader(alojamientos_Enlace));
					//Definimos una linea
					String Linea;
					String[] constructorAlojamiento=null;
					List<String> arlist = new ArrayList<String>();
					//Leemos el documento
					while((Linea=reader.readLine())!= null){ 
			            arlist.add(Linea);
			          } 
					
					for (String st : arlist){
						//Colocamos los datos en el arraylist de tipo alojamiento
			               Pattern  patrón = Pattern.compile(" ");
			               constructorAlojamiento = patrón.split(st);
			               alojamientos.add(new alojamiento(constructorAlojamiento[0],constructorAlojamiento[1],
			            		   Integer.parseInt(constructorAlojamiento[2]),Integer.parseInt(constructorAlojamiento[3]),
			            		   Integer.parseInt(constructorAlojamiento[4]),constructorAlojamiento[5],
			            		   Boolean.parseBoolean(constructorAlojamiento[6])) ); 
			            // Actualizar alojamientos Disponibles
			               alojamientosDisponibles.add(constructorAlojamiento[1]);
			               }
					
			          //Cerramos el reader
			            reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("No se ha encontrado el archivo de alojamiento");
					
				}
				
				// Añadimos al Arraylist los clientes
				try {
					// Cargamos datos en un buffered, definimos la ruta del archivo
					BufferedReader reader = new BufferedReader(new FileReader(clientes_Enlace));
					//Definimos una linea
					String Linea;
					String[] constructorCliente = null;
					List<String> arlist = new ArrayList<String>();
					//Leemos el documento
					while((Linea=reader.readLine())!= null){ 
			            arlist.add(Linea);
			          } 
					//Colocamos los datos en el arraylist de tipo alojamiento
					
					for (String st : arlist){
			               Pattern  patrón = Pattern.compile(" ");
			               constructorCliente = patrón.split(st);
			               
			               //Si es VIP, tendrá más de 4 datos, por lo que lo añadiremos a la clase vip
			               if (constructorCliente.length>4) {
			            	//System.out.println(constructorCliente[4]);
			            	
			            	   clientesVIP.add(new clienteVIP(constructorCliente[0],constructorCliente[1],
			            			   constructorCliente[2],Boolean.parseBoolean(constructorCliente[3]),constructorCliente[4]));
			            	   
			               }else {
			            	 //Si no, será un cliente normal y lo añadimos
			            	   clientes.add(new cliente(constructorCliente[0],constructorCliente[1],
				            		   (constructorCliente[2]),
				            		   Boolean.parseBoolean(constructorCliente[3]))); 
			               	}
			                  
			               }
					       
			          //Cerramos el reader
			            reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("No se ha encontrado el archivo de clientes");
					
				}
	}
	
	
	public ArrayList<alojamiento> cargarAlojamientos() {
		
		return alojamientos;
		
	}
	
	
	public ArrayList<cliente> cargarClientes() {
		
		return clientes;
		
	}
	
	public ArrayList<clienteVIP> cargarClientesVIP() {
		
		return clientesVIP;
		
	}
	
	public List<String> cargarAlojamientosDisponibles() {
		
		return alojamientosDisponibles;
		
	}
	
	
	
	
}
