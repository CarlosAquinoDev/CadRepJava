package gestionNominas;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class gestion_Nominas {
	
	
public static void main(String[] args) {
		
		
		//Definimos el ArrayList con el que deseamos trabajar, importante colocar los datos del array, si se encuentra en otra clase
		ArrayList <Persona> empresa = new ArrayList<Persona>();
		//En mi caso añado datos al arraylist, dado que el mio está vacío, en su caso, pueden hacer referencia al ArrayList, si lo tienen
		//creado en otras clases
		
		
		CuentaBancaria cB= new CuentaBancaria("Santander", "ES");
		Complementos com = new Complementos();
		Deducciones de= new Deducciones(0);
		Fecha f = null;
		try {
			f = new Fecha(14, 1, 1980);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Contrato c = new Contrato("Jefe", 1020.60, f, com, de);
		
		
		empresa.add(new Persona("Ana Lopez", "615482298", f, "16485997T", cB, c) {
		
			@Override
			public double calculaNomina(int mes, int anno) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		empresa.add(new Persona("ejemplo2", "615482298", f, "9754616T", cB, c) {
			
			@Override
			public double calculaNomina(int mes, int anno) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
		Boolean consultando=true;
		
		try (Scanner d = new Scanner(System.in)) {
			
			String consulta;
			
			while (consultando==true) {
				
				System.out.println("Bienvenid@ usuari@\r\n"
						+ "¿Que deseas hacer?\r\n"
						+ "\r\n"
						+ "1. Guardar todos los empleados en un archivo \r\n"
						+ "2. Leer la información del archivo de datos\r\n"
						+ "3. Generar nomina de un usuario especifico\r\n"
						+ "4. Generar nomina de todos los usuarios\r\n"
						+ "0. Salir");
				
					consulta = d.next();
			
					
					switch(consulta)
					{
						
						
						case "1": 	
							
							gestion_Nominas.escribirInformacion(empresa);
							
							break;
						case "2":
							
							gestion_Nominas.leerInformacion();
							
							break;
						case "3": 	
							gestion_Nominas.calcularNominaUsuario(empresa);
							
							break;
						case "4":
							gestion_Nominas.calcularTodasLasNominas(empresa);
							break;
						case "0":
						consultando=false;
						break;
						
						default:
							System.out.println("No es una opción válida");
					}
					
			}
			
		}catch (Exception e) {
			System.out.println("Error de consulta");
		}
		
		
	}
	
	
	
	
	    
	    public static void escribirInformacion(ArrayList<Persona> empresa) {
	    	
	    	try {
	    		
	    		FileOutputStream fichero = null;
	    		fichero = new FileOutputStream("datosEmpleados.txt");
	    		ObjectOutputStream Out = new ObjectOutputStream(fichero);
	    	
	    		//String data=null;
	    		
	    		//Es importante que se implemente la clase Serializable a cada una de las clases que se van a usar
	    			Out.writeObject(empresa);	    				    		
	    		
	    			Out.close();
	    			
	    	}catch (IOException e) {
				System.out.println("Error al crear archivo");
			}
	    	
	    	
	    }
	    
	    public static void leerInformacion() {
	    	
	    	
	    	try {
	    		String fichero="datosEmpleados.txt";
	    		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichero));
	    		
	    		ArrayList<Persona> empresa = (ArrayList<Persona>)in.readObject();
	    		
	    		for (Persona p:empresa) {
	    			System.out.println(p.getpersona());
	    		}
	    		
	    			
	    	}catch (IOException e) {
				System.out.println("Error al cargar el archivo.");
			} catch (ClassNotFoundException e) {
				System.out.println("No se ha encontrado la clase persona");
			}
	    	
	    	
	    }
	    
	    
	    public static void calcularNominaUsuario(ArrayList<Persona> empresa) {
	    	
	    	Scanner d = new Scanner(System.in);
	    	
	    	double salarioMes= 0;
	    	int trienios = 0;
	    	int horasExtra=0;
	    	int porJefe=0;
	    	double IRPF=0;
	    	int desempleo=0;
	    	int contingencias=0;
	    	double aPercibir=0;
	    	String nombre=null;
	    	String puesto=null;
	    	String datosBanco=null;
	    	
	    	boolean consultando=true;
	    	boolean encontrado=false;
	    	
	    	while (consultando==true) {
	    	
	    	System.out.println("Introduce el año de la nomina");
	    	String anyo=d.next();
	    	System.out.println("Introduce el mes de la nomina");
	    	String mes=d.next();
	    	System.out.println("Introduce el dni del usuario");
	    	String dni=d.next();
	    	
	    	
	    	
	    	
	    	//Agregar mas condiciones de igualdad al if (p.anio) o (p.mes) dependiendo de donde se encuentre la informacion (Si es necesario)
	    	for (Persona p: empresa) {
	    		
	    		if (p.dni.equals(dni)) {
	    			
	    			encontrado=true;
	    			
	    			
	    			
		    		try {
		    			
		    			//Introducir sentencias que igualen los valores consultados en la clase persona ej:salarioMes,trienios,horasExtras,etc
		    			nombre=p.getNombre();
		    			puesto=p.getContrato().getPuesto();
		    			datosBanco=p.getCuentaBancaria().getNombreEntidad();
		    			salarioMes=p.getContrato().getSalarioBase();
		    			trienios=p.getContrato().getC().getTrienios();
		    			//Rellenar con la información necesaria 
		    			//horasExtra=p.getContrato().getC().bonificacionHorasExtras(1, 3);
		    			//Rellenar con la información necesaria 
		    			porJefe=15;
		    			IRPF=p.getContrato().getD().getIrpf();
		    			//Rellenar con la información necesaria
		    			desempleo=10;
		    			//Rellenar con la información necesaria
		    			contingencias=25;
		    			
		    			//Calculo del total(Corregir formula de ser necesario)
		    			aPercibir=salarioMes+trienios+horasExtra+porJefe-IRPF-desempleo-contingencias;
		    			
		    			
		    			String fichero = anyo+"_"+mes+"_"+nombre+".nomina.txt";
		    			File ficheroBorrado = new File(fichero);
		    			ficheroBorrado.delete();
		    			FileWriter fw = new FileWriter(fichero, true);
		    			
		    			
		    			String nominaUsuario = "Nombre: "+nombre+" Puesto: "+puesto+"\r\n"
		    	    			+ "DNI: "+dni+"\r\n"
		    	    			+ "Banco de abono: "+datosBanco+"\r\n"
		    	    			+ "---------------------------------------------------------\r\n"
		    	    			+ "| Concepto | Complementos | Deducciones|\r\n"
		    	    			+ "---------------------------------------------------------\r\n"
		    	    			+ "| Salario mes: | "+salarioMes+"€ | |\r\n"
		    	    			+ "| Por trienios: | "+trienios+"€ | |\r\n"
		    	    			+ "| Horas extra: | "+horasExtra+"€ | |\r\n"
		    	    			+ "| Por jefe: | "+porJefe+"€ | |\r\n"
		    	    			+ "| IRPF: | | "+IRPF+"€ |\r\n"
		    	    			+ "| Desempleo: | | "+desempleo+"€ |\r\n"
		    	    			+ "| Contingencias: | | "+contingencias+"€ |\r\n"
		    	    			+ "---------------------------------------------------------\r\n"
		    	    			+ "| A percibir: "+String.format("%.3f", aPercibir)+"€ |\r\n"
		    	    			+ "---------------------------------------------------------";
		    			
		    			fw.write(nominaUsuario);
		    			
		    			fw.close();
		    			consultando=false;
		    			
		    			
						
						
					} catch (FileNotFoundException e) {
						System.out.println("Error al encontrar direccion del fichero");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Error al crear fichero");
					}
		    		
	    		}
	    	}
	    	
	    
	    	if (encontrado==false) {
    			System.out.println("Este dni no está disponible o no existe");
    			consultando=false;
    		}
	    	
	    	
	    	}
	    	
	    	
	    	
	    }
	    
	    public static void calcularTodasLasNominas(ArrayList<Persona> empresa) {
	    	
	    	Scanner d = new Scanner(System.in);
	    	
	    	
	    	double salarioMes= 0;
	    	int trienios = 0;
	    	int horasExtra=0;
	    	int porJefe=0;
	    	double IRPF=0;
	    	int desempleo=0;
	    	int contingencias=0;
	    	double aPercibir=0;
	    	String nombre=null;
	    	String puesto=null;
	    	String datosBanco=null;
	    	String dni=null;
	    	
	    	boolean consultando=true;
	    	boolean encontrado=false;
	    	
	    	
	    	while (consultando==true) {
	    	
	    	System.out.println("Introduce el año de la nomina");
	    	String anyo=d.next();
	    	System.out.println("Introduce el mes de la nomina");
	    	String mes=d.next();
	    	
	    	for (Persona p: empresa) {
	    		
	    		//Rellenar el if con la información correspondiente al anio y mes de la nomina solicitada, para verificar la existencia
	    		
	    		//if (anyo.equals(p.)&&mes.equals(p.) {
	    			
	    			encontrado=true;
	    			
	    			
	    			
		    		try {
		    			
		    			//Introducir sentencias que igualen los valores consultados en la clase persona ej:salarioMes,trienios,horasExtras,etc
		    			nombre=p.getNombre();
		    			dni=p.getDni();
		    			puesto=p.getContrato().getPuesto();
		    			datosBanco=p.getCuentaBancaria().getNombreEntidad();
		    			salarioMes=p.getContrato().getSalarioBase();
		    			trienios=p.getContrato().getC().getTrienios();
		    			//Rellenar con la información necesaria 
		    			//horasExtra=p.getContrato().getC().bonificacionHorasExtras(1, 3);
		    			//Rellenar con la información necesaria 
		    			porJefe=15;
		    			IRPF=p.getContrato().getD().getIrpf();
		    			//Rellenar con la información necesaria
		    			desempleo=10;
		    			//Rellenar con la información necesaria
		    			contingencias=25;
		    			
		    			//Calculo del total(Corregir formula de ser necesario)
		    			aPercibir=salarioMes+trienios+horasExtra+porJefe-IRPF-desempleo-contingencias;
		    			
		    			
		    			String fichero = anyo+"_"+mes+"_"+nombre+".nomina.txt";
		    			File ficheroBorrado = new File(fichero);
		    			ficheroBorrado.delete();
		    			FileWriter fw = new FileWriter(fichero, true);
		    			
		    			
		    			String nominaUsuario = "Nombre: "+nombre+" Puesto: "+puesto+"\r\n"
		    	    			+ "DNI: "+dni+"\r\n"
		    	    			+ "Banco de abono: "+datosBanco+"\r\n"
		    	    			+ "---------------------------------------------------------\r\n"
		    	    			+ "| Concepto | Complementos | Deducciones|\r\n"
		    	    			+ "---------------------------------------------------------\r\n"
		    	    			+ "| Salario mes: | "+salarioMes+"€ | |\r\n"
		    	    			+ "| Por trienios: | "+trienios+"€ | |\r\n"
		    	    			+ "| Horas extra: | "+horasExtra+"€ | |\r\n"
		    	    			+ "| Por jefe: | "+porJefe+"€ | |\r\n"
		    	    			+ "| IRPF: | | "+IRPF+"€ |\r\n"
		    	    			+ "| Desempleo: | | "+desempleo+"€ |\r\n"
		    	    			+ "| Contingencias: | | "+contingencias+"€ |\r\n"
		    	    			+ "---------------------------------------------------------\r\n"
		    	    			+ "| A percibir: "+String.format("%.3f", aPercibir)+"€ |\r\n"
		    	    			+ "---------------------------------------------------------";
		    			
		    			fw.write(nominaUsuario);
		    			
		    			fw.close();
		    			consultando=false;
		    			
		    			
						
						
					} catch (FileNotFoundException e) {
						System.out.println("Error al encontrar direccion del fichero");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Error al crear fichero");
					}
		    		
	    		//}
	    		}	
	    	}
	    
	    }
	
	
}
