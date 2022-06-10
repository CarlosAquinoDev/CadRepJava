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
import java.util.Objects;
import java.util.Scanner;

public class GestionNomina {
	
	public static Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args) throws Exception {
    	
        //ATRIBUTOS
        ArrayList<Persona> empresa = new ArrayList<>();

        JefeDeGrupo j1 = new JefeDeGrupo("Berta", "653990877", new Fecha(25, 4, 1990), "89765646H",
                new CuentaBancaria("Banco Santander", "ES4321000418894324568932"),
                new Contrato("Jefe", 850000, new Fecha(9, 5, 2010), new Complementos(5),new Deducciones(8)),"grupo1" );
        Tecnico t1 = new Tecnico("Jaime", "606552847", new Fecha(2, 4, 2003), "67876543A",
                new CuentaBancaria("BBVA", "ES912100041844532189765432"),
                new Contrato("Tecnico", 55000, new Fecha(21, 12, 2018),new Complementos(3),new Deducciones(6)));
        Administracion admin1 = new Administracion("Juan", "698776543", new Fecha(13, 3, 2001), "12655443J",
                new CuentaBancaria("Banco Santander", "ES1264890234556675438920"),
                new Contrato("Administracion", 34000, new Fecha(10, 12, 2015), new Complementos(4),new Deducciones(10)));
        JefeDeGrupo j2 = new JefeDeGrupo("Gonzalo", "650908765", new Fecha(29, 11, 2000), "32898056L",
                new CuentaBancaria("Sabadel", "ES1453389976522183450988140"),
                new Contrato("Jefe", 890000, new Fecha(12, 1, 2019), new Complementos(4),new Deducciones(2)),"Grupo2");
        Tecnico t2 = new Tecnico("Maria", "6389766228", new Fecha(12, 5, 1990), "45327881R",
                new CuentaBancaria("Santander", "ES9121847175644893245677869843"),
                new Contrato("Tecnico", 90000, new Fecha(28, 7, 2021),new Complementos(5),new Deducciones(9)));

        empresa.add(j1); //A√nado empleados para poder crear una lista
        empresa.add(t1);
        j1.getEquipo().add(t1);
        empresa.add(admin1);
        empresa.add(j2);
        empresa.add(t2);
        j2.getEquipo().add(t2);



        int numeroUsuario;
        
        do{
        	
        	Scanner teclado = new Scanner(System.in);
        	
            System.out.println("""
                    1-Dar de alta un contrato
                    2-Dar de baja un contrato\s
                    3-A√nadir t√©cnico
                    4-Quitar t√©cnico
                    5-A√nadir horas extra
                    6-A√nadir d√≠as de baja
                    7-Listado de empleados actuales
                    8-Listado empleados dados de baja
                    9-Listado de empleados de administraci√≥n
                    10-Listado de equipos
                    11-Generar n√≥mina
                    12-Generar n√≥minas
                    13.Guardar todos los empleados en un archivo
                    14.Leer la informaciÛn del archivo de datos
                    15.Generar nomina de un usuario especifico
                    16.Generar nomina de todos los usuarios
                    0-Salir
                    """);
            numeroUsuario = 1;
            System.out.println("Por favor elija una opci√≥n:");
            numeroUsuario = teclado.nextInt();

            switch (numeroUsuario) {
                case 1:
                    darAlta(empresa);
                    break;
                case 2:
                    darBaja(empresa);
                    break;
                case 3:
                    annadirTecnico(empresa);
                    break;
                case 4:
                    quitarTecnico(empresa);
                    break;
                case 5:
                    annadirHorasExtra(empresa);
                    break;
                case 6:
                    annadirDiasBaja(empresa);
                    break;
                case 7:
                    listadoEmpleados(empresa);
                    break;
                case 8:
                    listadoEmpleadosBaja(empresa);
                    break;
                case 9:
                    listadoAdministracion(empresa);
                    break;
                case 10:
                    listadoEquipos(empresa);
                    break;
                case 11:
                    generarNomina(empresa);
                    break;
                case 12:
                    gNominas(empresa);
                    break;
                case 13:
                	escribirInformacion(empresa);
                	break;
                case 14:
                	leerInformacion();
                	break;
                case 15:
                	calcularNominaUsuario(empresa);
                	break;
                case 16:
                	calcularTodasLasNominas(empresa);
                	break;
                    
                case 0:
                    System.out.println("Quiere salir del programa?");
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextLine();
                    String respuesta = scanner.nextLine();
                    if(Objects.equals(respuesta, "NO") || Objects.equals(respuesta, "no")){
                        numeroUsuario = -50;
                    }
                    break;
            }
        } while (numeroUsuario != 0);

    }
    //METODOS
    public static void darAlta(ArrayList<Persona> Empresa) {
        double salarioBase, irpf;
        int trienio;
        String trabajo, nombre, telefono, dni, respuesta, entidad, iban;
        String equipo = "";
        Fecha fechaNacimiento, fechaAlta, fechaBaja;
        CuentaBancaria cuenta;
        int dia, mes, a√nos;
        Contrato contrato;
        Complementos complementos;
        Deducciones deducciones;
        Scanner s = new Scanner(System.in);

        try {
            // Se pide al usuario los datos personales de la persona que quiere darse de alta
            System.out.println("-----------");
            System.out.println("Darse de alta");
            System.out.println("-----------");


            System.out.println("Introduzca el puesto de trabajo (Administraci√≥n, T√©cnico o Jefe) : ");
            trabajo = s.nextLine();

            if(Objects.equals(trabajo, "JEFE") || Objects.equals(trabajo, "jefe")){
                System.out.println("Introduzca el nombre de su equipo: ");
                equipo = s.nextLine();
            }

            System.out.println("Introduzca el nombre de la persona a la que se quiere dar de alta: ");
            nombre = s.nextLine();

            System.out.println("Introduzca el DNI: ");
            dni = s.nextLine();

            System.out.println("Introduzca el n√∫mero de tel√©fono ");
            telefono = s.nextLine();

            System.out.println("Introduzca la fecha de nacimiento: ");
            System.out.println("D√≠a: ");
            dia = s.nextInt();
            System.out.println("Mes: ");
            mes = s.nextInt();
            System.out.println("A√no: ");
            a√nos = s.nextInt();
            fechaNacimiento = new Fecha(dia, mes, a√nos);

            System.out.println("Introduzca su entidad bancaria: ");
            entidad = s.next();

            System.out.println("Introduzca el IBAN: ");
            iban = s.next();
            cuenta = new CuentaBancaria(entidad, iban);

            System.out.println("Procesando la informaci√≥n. Por favor, espere...");
            System.out.println("Introduzca el salario base: ");
            salarioBase = s.nextDouble();

            System.out.println("Introduzca la fecha de alta: ");
            System.out.println("D√≠a: ");
            dia = s.nextInt();
            System.out.println("Mes: ");
            mes = s.nextInt();
            System.out.println("A√no: ");
            a√nos = s.nextInt();
            fechaAlta = new Fecha(dia, mes, a√nos);

            System.out.println("Introduzca la cantidad de dinero que recibe por trienio: ");
            trienio = s.nextInt();
            complementos = new Complementos( trienio);

            System.out.println("Introduzca el IRPF: ");
            irpf = s.nextDouble();

            deducciones = new Deducciones(irpf);

            System.out.println("Procesando informaci√≥n. Por favor, espere...");

            System.out.println("¬øTiene fecha de baja? Conteste con Si o No.");
            respuesta = s.next();

            if(Objects.equals(trabajo, "T√©cnico") || Objects.equals(trabajo, "TECNICO") || Objects.equals(trabajo, "tecnico") || Objects.equals(trabajo, "t√©cnico")){

                if (respuesta.equals("Si") || respuesta.equals("si")|| respuesta.equals("SI") || respuesta.equals("s√≠") || respuesta.equals("S√≠")) {
                    // En caso afirmativo, se pide la fecha de baja
                    System.out.println("Introduzca la fecha de baja: ");
                    System.out.println("D√≠a: ");
                    dia = s.nextInt();
                    System.out.println("Mes: ");
                    mes = s.nextInt();
                    System.out.println("A√no: ");
                    a√nos = s.nextInt();
                    fechaBaja = new Fecha(dia, mes, a√nos);
                    contrato = new Contrato(trabajo, salarioBase, fechaAlta, fechaBaja, complementos,deducciones);
                    Tecnico t = new Tecnico(nombre, telefono, fechaNacimiento, dni, cuenta, contrato);
                    Empresa.add(t);

                } else if (respuesta.equals("No") || respuesta.equals("no") || respuesta.equals("NO")) {
                    // En caso negativo, la fecha de baja no tendr√° valor
                    contrato = new Contrato(trabajo, salarioBase, fechaAlta, complementos, deducciones);
                    Tecnico t = new Tecnico(nombre, telefono, fechaNacimiento, dni, cuenta, contrato);
                    Empresa.add(t);
                }


            } else if(Objects.equals(trabajo, "Administraci√≥n") || Objects.equals(trabajo, "ADMINISTRACION") || Objects.equals(trabajo, "admin") || Objects.equals(trabajo, "ADMIN")){

                if (respuesta.equals("Si") || respuesta.equals("si")|| respuesta.equals("SI") || respuesta.equals("s√≠") || respuesta.equals("S√≠")) {
                    // En caso afirmativo, se pide la fecha de baja
                    System.out.println("Introduzca la fecha de baja: ");
                    System.out.println("D√≠a: ");
                    dia = s.nextInt();
                    System.out.println("Mes: ");
                    mes = s.nextInt();
                    System.out.println("A√no: ");
                    a√nos = s.nextInt();
                    fechaBaja = new Fecha(dia, mes, a√nos);
                    contrato = new Contrato(trabajo, salarioBase, fechaAlta, fechaBaja, complementos,deducciones);
                    Administracion a = new Administracion(nombre, telefono, fechaNacimiento, dni, cuenta, contrato);
                    Empresa.add(a);

                } else if (respuesta.equals("No") || respuesta.equals("no") || respuesta.equals("NO")) {
                    // En caso negativo, la fecha de baja no tendr√° valor
                    contrato = new Contrato(trabajo, salarioBase, fechaAlta, complementos, deducciones);
                    Administracion a = new Administracion(nombre, telefono, fechaNacimiento, dni, cuenta, contrato);
                    Empresa.add(a);
                }

            }else if(Objects.equals(trabajo, "JEFE") || Objects.equals(trabajo, "jefe")){

                if (respuesta.equals("Si") || respuesta.equals("si")|| respuesta.equals("SI") || respuesta.equals("s√≠") || respuesta.equals("S√≠")) {
                    // En caso afirmativo, se pide la fecha de baja
                    System.out.println("Introduzca la fecha de baja: ");
                    System.out.println("D√≠a: ");
                    dia = s.nextInt();
                    System.out.println("Mes: ");
                    mes = s.nextInt();
                    System.out.println("A√no: ");
                    a√nos = s.nextInt();
                    fechaBaja = new Fecha(dia, mes, a√nos);
                    contrato = new Contrato(trabajo, salarioBase, fechaAlta, fechaBaja, complementos,deducciones);
                    JefeDeGrupo j = new JefeDeGrupo(nombre, telefono, fechaNacimiento, dni, cuenta, contrato, equipo);
                    Empresa.add(j);

                } else if (respuesta.equals("No") || respuesta.equals("no") || respuesta.equals("NO")) {
                    // En caso negativo, la fecha de baja no tendr√° valor
                    contrato = new Contrato(trabajo, salarioBase, fechaAlta, complementos, deducciones);
                    JefeDeGrupo j = new JefeDeGrupo(nombre, telefono, fechaNacimiento, dni, cuenta, contrato, equipo);
                    Empresa.add(j);
                }
            }


            // Se le pregunta al usuario si tiene o no fecha de baja


            } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void darBaja(ArrayList<Persona> empresa) {
        String dni;
        Fecha fechaBaja;
        int dia, mes, a√nos;

        System.out.println("-----------");
        System.out.println("Darse de baja");
        System.out.println("-----------");

        // Se le pide al usuario el DNI de la persona que quiere darse de baja y la fecha de baja
        System.out.println("Introduce el DNI de la persona que se quiere dar de baja: ");
        Scanner scanner = new Scanner(System.in);

        try {
            dni = scanner.nextLine();

            System.out.println("Introduce la fecha de baja: ");
            System.out.println("D√≠a: ");
            dia = scanner.nextInt();
            System.out.println("Mes: ");
            mes = scanner.nextInt();
            System.out.println("A√no: ");
            a√nos = scanner.nextInt();
            fechaBaja = new Fecha(dia, mes, a√nos);

            for (Persona p : empresa) { // Se busca en el ArrayList el DNI introducido
                if (Objects.equals(p.dni, dni)) { // Una vez encontrado, se cambia la fecha de baja a la actual y el salario base se iguala a 0
                    p.contrato.fechaBaja = fechaBaja;
                    p.contrato.salarioBase = 0;
                }
            }

        } catch (Exception e) {
            System.out.print("Los datos introducidos no son v√°lidos");
        }
        scanner.close();
    }

    public static void annadirTecnico(ArrayList<Persona> empresa) {
        String nombreDeEquipo;
        String dni;

        System.out.println("--------------");
        System.out.println("A√nadir un tecnico");
        System.out.println("--------------");

        // Se pide al usuario el nombre del equipo al que se quiere a√nadir y el DNI
        System.out.println("Introduce el nombre del equipo: ");
        Scanner teclado = new Scanner(System.in);
        nombreDeEquipo = teclado.nextLine();

        System.out.println("Introduce el DNI de la persona que se quiere a√nadir al equipo: ");
        dni = teclado.nextLine();

        JefeDeGrupo j;
        for (Persona p : empresa) { // Se busca en el ArrayList el nombre de equipo y el DNI introducido
            if (p instanceof JefeDeGrupo) {
                j = (JefeDeGrupo) p;
                if (Objects.equals(j.getNombreDeEquipo(), nombreDeEquipo)) {
                    for (Persona e : empresa) {
                        if (Objects.equals(e.dni, dni)) { // se a√nade al equipo
                            j.getEquipo().add((Tecnico) e);
                        }
                    }
                }

            }
        }
        teclado.close();

    }

    public static void quitarTecnico(ArrayList<Persona> empresa) {
        String nombreDeEquipo;
        String dni;

        System.out.println("--------------");
        System.out.println("Quitar un tecnico");
        System.out.println("--------------");

        // Se le pide al usuario el nombre del equipo del que se quiere quitar y el DNI
        System.out.println("Introduce el nombre del equipo: ");
        Scanner teclado = new Scanner(System.in);
        nombreDeEquipo = teclado.nextLine();


        System.out.println("Introduce el DNI del tecnico que desea quitar: ");
        dni = teclado.nextLine();

        JefeDeGrupo j;
        for (Persona p : empresa) { // Se busca en el ArrayList el nombre de equipo y el DNI introducido
            if (p instanceof JefeDeGrupo) {
                j = (JefeDeGrupo) p;
                if (j.getNombreDeEquipo().equals(nombreDeEquipo)) {
                    for (Persona e : empresa) {
                        if (e.dni.equals(dni)) {//se elimina del equipo
                            j.getEquipo().remove((Tecnico) e);
                        }
                    }
                }

            }
        }
        teclado.close();

    }

    public static void annadirHorasExtra(ArrayList<Persona> empresa) {
        String dni;
        int mes, a√nos, numero;

        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------");
        System.out.println("A√nadir horas extra");
        System.out.println("------------------");

        // Se le pide al usuario introducir los datos (
        System.out.println("Introduce el DNI de la persona a la que quieres a√nadir horas extra: ");
        dni = scanner.nextLine();
        System.out.println("Introduce el mes: ");
        mes = scanner.nextInt();
        System.out.println("Introduce el a√no: ");
        a√nos = scanner.nextInt();
        System.out.println("Introduce el numero de horas extra: ");
        numero = scanner.nextInt();


        for (Persona i : empresa) {
            if (i.dni.equals(dni)) {
                i.contrato.c.annadirHoras(mes, a√nos, numero);
            }
        }
        scanner.close();

    }

    public static void annadirDiasBaja(ArrayList<Persona> empresa) {
        String dni;
        int numero, mes, a√nos;

        System.out.println("-------------------");
        System.out.println("A√nadir dias de baja");
        System.out.println("-------------------");

        // Se le pide al ususario el DNI de la persona a la que se le a√naden los d√≠as de baja
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el DNI de la persona a la que quieres a√nadir d√≠as de baja");
        dni = scanner.nextLine();
        for (Persona i : empresa) {
            if (Objects.equals(dni, i.dni)) {
                // Se guardan el n√∫mero de dias, el mes y el a√no que quiere a√nadir el usuario
                System.out.println("Introduzca el mes:");
                mes = scanner.nextInt();
                System.out.println("Introduzca el a√no:");
                a√nos = scanner.nextInt();
                System.out.println("Introduce los d√≠as de baja que quieres a√nadir:");
                numero = scanner.nextInt();
                i.contrato.d.annadirDiasDeBaja(mes, a√nos, numero);
            }

        }
        scanner.close();
    }

    public static void listadoEmpleados(ArrayList<Persona> empresa) {
        System.out.println("----------------------------------");
        System.out.println("Listado de empleados dados de alta");
        System.out.println("----------------------------------");
        for (Persona i : empresa) {

            if (i.contrato.salarioBase != 0 || i.contrato.fechaBaja == null || (i.contrato.fechaBaja.getMes() >= 5 && i.contrato.fechaBaja.getA√nos() >= 2022)) {

                System.out.println("Nombre: " + i.nombre);
                System.out.println("Puesto: " + i.contrato.puesto);
                if (i instanceof Administracion) {
                    System.out.println("Tipo: Administraci√≥n");
                } else if (i instanceof Tecnico) {
                    if (i instanceof JefeDeGrupo) {
                        System.out.println("Tipo: Jefe de grupo");
                    } else {
                        System.out.println("Tipo: T√©cnico");
                    }
                }
                System.out.println("Fecha de Alta: " + i.contrato.fechaAlta);
            }

        }

    }

    public static void listadoEmpleadosBaja(ArrayList<Persona> empresa) {
        System.out.println("----------------------------------");
        System.out.println("Listado de empleados de baja");
        System.out.println("----------------------------------");
        for (Persona i : empresa) {
            if (i.contrato.salarioBase != 0 || (i.contrato.fechaBaja.getMes() < 5 && i.contrato.fechaBaja.getA√nos() == 2022) || i.contrato.fechaBaja.getA√nos() < 2022) {
                System.out.println("Nombre:" + i.nombre);
                System.out.println("Puesto: " + i.contrato.puesto);
                if (i instanceof Administracion) {
                    System.out.println("Tipo: Administraci√≥n");
                } else if (i instanceof Tecnico) {
                    if (i instanceof JefeDeGrupo) {
                        System.out.println("Tipo: Jefe de grupo");
                    } else {
                        System.out.println("Tipo: T√©cnico");
                    }
                }
                System.out.println("Fecha de Alta: " + i.contrato.fechaAlta);
            }
        }
    }

    public static void listadoAdministracion(ArrayList<Persona> empresa) {

        System.out.println("--------------------------------------");
        System.out.println("Listado de empleados en administracion");
        System.out.println("--------------------------------------");
        Administracion admin;
        for (Persona i : empresa) {
            if (i instanceof Administracion) {
                admin = (Administracion) i;
                System.out.println("Nombre:" + admin.nombre);
                System.out.println("Puesto: " + admin.contrato.puesto);
            }
        }
    }

    public static void listadoEquipos(ArrayList<Persona> empresa) {
        for (Persona i : empresa) {
            int k = 0;
            if (i instanceof JefeDeGrupo) {
                JefeDeGrupo jefe;
                jefe = (JefeDeGrupo) i;
                System.out.println("Nombre del equipo: " + jefe.getNombreDeEquipo());
                for (Tecnico j : jefe.getEquipo()) {
                    k++;
                    System.out.println("T√©cnico " + k + ": " + j.nombre);
                }
            }
        }
    }

    public static void generarNomina(ArrayList<Persona> empresa) {
    	
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el DNI del empleado:");
        String dni = teclado.nextLine();
        for (Persona i : empresa) {
        	
            if (dni.equals(i.dni)) {
            	System.out.println("Introduzca el mes:");
                int mes = teclado.nextInt();
                System.out.println("Introduzca el a√no");
                int a√nos = teclado.nextInt();
                
                i.calculaNomina(mes,a√nos);
            }
        }
        
        teclado=null;
    }

    public static void gNominas(ArrayList<Persona> empresa) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el mes:");
        int mes = teclado.nextInt();
        System.out.println("Introduzca el a√no");
        int a√nos = teclado.nextInt();
        for (Persona i: empresa){
            i.calculaNomina(mes,a√nos);
        }
        teclado=null;
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
    	double porJefe=0;
    	double IRPF=0;
    	double desempleo=0;
    	double contingencias=0;
    	double aPercibir=0;
    	String nombre=null;
    	String puesto=null;
    	String datosBanco=null;
    	
    	boolean consultando=true;
    	boolean encontrado=false;
    	
    	while (consultando==true) {
    	
    	System.out.println("Introduce el aÒo de la nomina");
    	int anyo=d.nextInt();
    	System.out.println("Introduce el mes de la nomina");
    	int mes=d.nextInt();
    	System.out.println("Introduce el dni del usuario");
    	String dni=d.next();
    	
    	
    	
    	
    	for (Persona p: empresa) {
    		
    		if (p.dni.equals(dni)) {
    			
    			encontrado=true;
    			
    			
    			
	    		try {
	    			double ss = p.getContrato().getSalarioBase()/12;
	    			nombre=p.getNombre();
	    			puesto=p.getContrato().getPuesto();
	    			datosBanco=p.getCuentaBancaria().getNombreEntidad();
	    			salarioMes=ss;
	    			trienios=p.getContrato().getC().getTrienios();
	    			horasExtra=p.getContrato().getC().bonificacionHorasExtras(mes, anyo);
	    			
	    			if(p instanceof JefeDeGrupo) {
	    				int tamanioEquipo =((JefeDeGrupo) p).getEquipo().size();
	    				System.out.println(tamanioEquipo);
	    				porJefe=ss*0.02*(double)tamanioEquipo;
	    				System.out.println(porJefe);
	    			}else {
	    				porJefe=0;
	    			}
	    			
	    			IRPF=p.getContrato().getD().getIrpf();
	    			desempleo= ss*0.016;
	    			contingencias=ss*0.047;
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
	    	    			+ "| Salario mes: | "+salarioMes+"Ä | |\r\n"
	    	    			+ "| Por trienios: | "+trienios+"Ä | |\r\n"
	    	    			+ "| Horas extra: | "+horasExtra+"Ä | |\r\n"
	    	    			+ "| Por jefe: | "+porJefe+"Ä | |\r\n"
	    	    			+ "| IRPF: | | "+IRPF+"Ä |\r\n"
	    	    			+ "| Desempleo: | | "+desempleo+"Ä |\r\n"
	    	    			+ "| Contingencias: | | "+contingencias+"Ä |\r\n"
	    	    			+ "---------------------------------------------------------\r\n"
	    	    			+ "| A percibir: "+String.format("%.3f", aPercibir)+"Ä |\r\n"
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
			System.out.println("Este dni no est· disponible o no existe");
			consultando=false;
		}
    	
    	
    	}
    	
    	
    	
    }
    
    public static void calcularTodasLasNominas(ArrayList<Persona> empresa) {
    	
    	Scanner d = new Scanner(System.in);
    	
    	
    	double salarioMes= 0;
    	int trienios = 0;
    	int horasExtra=0;
    	double porJefe=0;
    	double IRPF=0;
    	double desempleo=0;
    	double contingencias=0;
    	double aPercibir=0;
    	String nombre=null;
    	String puesto=null;
    	String datosBanco=null;
    	String dni=null;
    	
    	boolean consultando=true;
    	boolean encontrado=false;
    	
    	
    	while (consultando==true) {
    	
    	System.out.println("Introduce el aÒo de la nomina");
    	int anyo=d.nextInt();
    	System.out.println("Introduce el mes de la nomina");
    	int mes=d.nextInt();
    	
    	for (Persona p: empresa) {
    			
    			encontrado=true;
    			
    			
    			
	    		try {
	    			double ss = p.getContrato().getSalarioBase()/12;
	    			//Introducir sentencias que igualen los valores consultados en la clase persona ej:salarioMes,trienios,horasExtras,etc
	    			nombre=p.getNombre();
	    			dni=p.getDni();
	    			puesto=p.getContrato().getPuesto();
	    			datosBanco=p.getCuentaBancaria().getNombreEntidad();
	    			salarioMes=p.getContrato().getSalarioBase();
	    			trienios=p.getContrato().getC().getTrienios();
	    			horasExtra=p.getContrato().getC().bonificacionHorasExtras(mes, anyo);
	    			
	    			if(p instanceof JefeDeGrupo) {
	    				int tamanioEquipo =((JefeDeGrupo) p).getEquipo().size();	    				
	    				porJefe=ss*0.02*(double)tamanioEquipo;
	    			}else {
	    				porJefe=0;
	    			}
	    			
	    			IRPF=p.getContrato().getD().getIrpf();
	    			desempleo= ss*0.016;
	    			contingencias=ss*0.047;
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
	    	    			+ "| Salario mes: | "+salarioMes+"Ä | |\r\n"
	    	    			+ "| Por trienios: | "+trienios+"Ä | |\r\n"
	    	    			+ "| Horas extra: | "+horasExtra+"Ä | |\r\n"
	    	    			+ "| Por jefe: | "+porJefe+"Ä | |\r\n"
	    	    			+ "| IRPF: | | "+IRPF+"Ä |\r\n"
	    	    			+ "| Desempleo: | | "+desempleo+"Ä |\r\n"
	    	    			+ "| Contingencias: | | "+contingencias+"Ä |\r\n"
	    	    			+ "---------------------------------------------------------\r\n"
	    	    			+ "| A percibir: "+String.format("%.3f", aPercibir)+"Ä |\r\n"
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
    
    }
    
    
    
}

