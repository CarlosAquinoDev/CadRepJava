package complejoTuristico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menu {

	
	public static void iniciar() {
		
		
		
				//Variables
				Boolean consultando=true;
				try (Scanner d = new Scanner(System.in)) {
					String consulta;
					
					datos.cargar();
					
					ArrayList<alojamiento> alojamientos = datos.alojamientos;
					ArrayList<cliente> clientes = datos.clientes ;
					ArrayList<clienteVIP> clientesVIP = datos.clientesVIP;
					ArrayList<reserva> reservas = new ArrayList<reserva>();
					List <String> alojamientosDisponibles = datos.alojamientosDisponibles;
					int maxReserva=0;

					//Inicialización del programa
					while (consultando==true) {
						
						System.out.println("Bienvenid@ usuari@\r\n"
								+ "¿Que deseas hacer?\r\n"
								+ "\r\n"
								+ "1. Consultar disponibilidad de alojamiento\r\n"
								+ "2. Calcular limpieza de cabañas no ocupadas\r\n"
								+ "3. Realizar reserva de cliente\r\n"
								+ "4. Consultar precio de reserva\r\n"
								+ "5. Mostar reservas de clientes\r\n"
								+ "6. Calcular ganancias de publicidad (Alojamientos disponibles durante 7 días) \r\n"
								+ "7. Mostar la información de los alojamientos con barbacoa, que tienen reservado un cliente VIP\r\n"
								+ "0. Salir");
						
							consulta = d.next();
							
							
							
							switch(consulta)
							{
								
								
								case "1": 	
									System.out.println("Los alojamientos disponibles son: ");
									
									for (alojamiento al: alojamientos) {	
										for (String aloja: alojamientosDisponibles) {
											if(al.getId_Alojamiento().equals(aloja)) {
												System.out.println(al.mostrar_Alojamiento());
											}
											
										}
									}
									
									
								break;
								
								case "2": 
									
									int sumaLimpieza=0;
									//Hacemos una doble iteración para encontrar los alojamientos disponibles y sumarlos
									for(alojamiento alo: alojamientos) {
										for (String aloDis: alojamientosDisponibles) {
											//teniendo ya los alojamientos disponibles, haremos las consultas aqui
											if(alo.getId_Alojamiento().equals(aloDis)) {
												
												// Sumamos todos los bungalos, ya que tienen barbacoa
												if(alo.getTipo_Alojamiento().equals("b")) { sumaLimpieza=sumaLimpieza+2; }
												//sumamos las parcelas con barbacoa
												if(alo.getTipo_Alojamiento().equals("p")&&alo.isInfo_Compartida2()) {
													sumaLimpieza=sumaLimpieza+2;
												}
												sumaLimpieza=sumaLimpieza+15;
											}
										}							
									}
									
									System.out.println("El coste total es: "+sumaLimpieza+" Euros");
									break;
								
								case "3":  ;
								
								//variables Temporales
								String nombre,nif = null,tarjeta,dias = null,alojado = null;
								String idReserva = null;
								boolean disponible=false;
								boolean guardado1=false;
								boolean guardado2=false;
								boolean limite=false;
								int x=0;
								maxReserva=1;
								
								System.out.println("¿Es cliente nuevo? 0=Si 1=No");
								
								consulta = d.next();
								
								
								//Cliente nuevo
								if (consulta.equals("0")) {
									System.out.println("Introduce el nombre del cliente");
									nombre=d.next();
									System.out.println("Introduce el dni del cliente");
									nif=d.next();
									System.out.println("Introduce la tarjeta del cliente");
									tarjeta=d.next();
									
									
									//Mostramos los alojamientos disponibles
									for (String aloja: alojamientosDisponibles) {
										System.out.println(aloja); 
									}
									
									while (!disponible){
										System.out.println("Elige un alojamiento disponible");
										alojado=d.next();
										
										for (String aloja: alojamientosDisponibles) {
											
											if(aloja.toLowerCase().equals(alojado.toLowerCase())) {
												
												disponible=true; 
												}
											}	
									}
									
									System.out.println("Introduce los días de reserva");
									dias=d.next();
									while (!dias.matches("[0-9]+")) {
										System.out.println("Introduce una cantidad de días válida");
										dias=d.next();
									}
									//removemos de la lista el alojamiento que escogimos
									alojamientosDisponibles.remove(alojado.toUpperCase());
									//Añadimos la información al array de reservas
									idReserva=String.valueOf(reservas.size());
									reservas.add(new reserva(idReserva,alojado,nif,Integer.parseInt(dias)));
									
									for (reserva res:reservas) {	
										if (res.getIdReserva().equals(idReserva)) {
											System.out.println(res.getDatos());
										}
									}
									
									System.out.println("Se ha introducido correctamente");
									
								//Cliente fidelizado	
								}else if (consulta.equals("1")) {
									
									
									//Verificaremos si es cliente VIP o regular
									while (!guardado1&&!guardado2){
										
										limite=false;
										
										for (cliente c : clientes){ System.out.println(c.getNIF()); }
										for (clienteVIP c : clientesVIP){ System.out.println(c.getNIF()); }
										
										
										System.out.println("Introduce el DNI del cliente");
										nif=d.next();
										//En el caso de ser cliente normal, salimos del bucle
										for (cliente c : clientes){
											
											if(c.getNIF().equals(nif.toUpperCase())) {
												
												guardado1=true; 
											}
							            	
							            }
										
																	
										//En el caso de ser cliente VIP, salimos del bucle
										for (clienteVIP c : clientesVIP){
											
											if(c.getNIF().equals(nif.toUpperCase())) {
												
												guardado2=true; 
											}
							            	
							            }
										
										
										
										if(!guardado1&&!guardado2) {System.out.println("No coincide con un cliente, intentalo otra vez");	}
										
										
										for (reserva r:reservas) {
											if(r.getIdCliente().equals(nif)) {
												maxReserva++;
											}
										}
										
										if(maxReserva>5) {
											System.out.println("Este cliente dispone de 5 reservas o más, no podría hacer una nueva.");
											limite=true;
										}
										
									}
									if(!limite) {
										
									
									//Mostramos los alojamientos disponibles
									for (String aloja: alojamientosDisponibles) {
										System.out.println(aloja); 
									}
									//Nos aseguramos de que coincida con los alojamientos que incluimos en el Array de disponibles
									while (!disponible){
										System.out.println("Elige un alojamiento disponible");
										alojado=d.next();
										for (String aloja: alojamientosDisponibles) {
											//Cuando sea uno de ellos, salimos del bucle
											if(aloja.toLowerCase().equals(alojado)) {
												
												disponible=true; 
												}
											}	
									}
									//Introducimos los días de reserva
									System.out.println("Introduce los días de reserva");
									dias=d.next();
									while (!dias.matches("[0-9]+")) {
										System.out.println("Introduce una cantidad de días válida");
										dias=d.next();
									}
									
									//removemos de la lista el alojamiento que escogimos
									alojamientosDisponibles.remove(alojado.toUpperCase());
									//Añadimos la información al array de reservas
									idReserva=String.valueOf(reservas.size());
									reservas.add(new reserva(idReserva,alojado,nif,Integer.parseInt(dias)));
									//Mostramos la reserva realizada
									for (reserva res:reservas) {	
										if (res.getIdReserva().equals(idReserva)) {
											System.out.println(res.getDatos());
										}
									}
									System.out.println("Se ha introducido correctamente");
									
									
								}else {
									System.out.println("No se ha introducido un valor válido");
								}
									
								}
								
							break;
								
								case "4":  
									
									String idAloja;
									
									
									System.out.println("ID "+"Precio");
									for(alojamiento aloja : alojamientos) {
										System.out.println(aloja.getId_Alojamiento()+" "+aloja.getPrecioNoche());
										
									}
									
									System.out.println("Introduzca el id del alojamiento a reservar");
									idAloja=d.next();
									
									System.out.println("Introduzca los días de la reserva");
									dias=d.next();
									
									for(cliente cli:clientes) {
										System.out.println(cli.getNIF());
									}
									for(clienteVIP cli:clientesVIP) {
										System.out.println(cli.getNIF());
									}
									System.out.println("Introduzca el NIF del cliente registrado");
									consulta = d.next();
									Boolean guardado3=false;
									Boolean guardado4=false;
									Boolean descuento1=false;
									Boolean descuento2=false;
									int precioNoche=0;
									int precioTotal=0;
									while (!guardado3&&!guardado4) {
										
										for (cliente cli:clientes) {
											if(cli.getNIF().equals(consulta.toUpperCase())) {
												//Si coincide el nif del cliente con alguna reserva, se aplicará el primer descuento
												for(reserva res:reservas) {
													if(res.getIdCliente().equals(consulta)) {
														descuento1=true;
													}
												}
												for (alojamiento aloja:alojamientos) {
													if(aloja.getId_Alojamiento().equals(idAloja.toUpperCase())) {
														precioNoche=aloja.getPrecioNoche();
														precioTotal=(precioNoche*Integer.parseInt(dias));
														System.out.println("El precio total sin descuento es: "+precioTotal+"€");
													}
												}
												
												if(descuento1) {
													System.out.println("Aplicando un descuento de 5%...");
													double descuento=(precioTotal*0.05);
													System.out.println("El precio total con descuento es: "+(precioTotal-descuento)+"€");
												}else {
													System.out.println("No es aplicable ningún descuento");
													System.out.println("El precio final es: "+precioTotal+"€");
												}
												
												guardado3=true;	
											}
										}
										
										
										for(clienteVIP cliVIP:clientesVIP) {
											if(cliVIP.getNIF().equals(consulta.toUpperCase())) {	
													
												
												//Si coincide con el nif, se activa el descuento
												for(reserva res:reservas) {
													if(res.getIdCliente().equals(consulta)) {
														descuento2=true;
													}
												}
												
												for (alojamiento aloja:alojamientos) {
													if(aloja.getId_Alojamiento().equals(idAloja.toUpperCase())) {
														precioNoche=aloja.getPrecioNoche();
														precioTotal=(precioNoche*Integer.parseInt(dias));
														System.out.println("El precio total sin descuento es: "+precioTotal+"€");
													}
												}
												

												if(descuento2) {
													System.out.println("¡Cliente VIP! Aplicando un descuento de 10%...");
													double descuento=(precioTotal*0.10);
													System.out.println("El precio total con descuento es: "+(precioTotal-descuento)+"€");
												}else {
													double descuento=(precioTotal*0.05);
													System.out.println("¡Cliente VIP! Aplicando descuento de 5%");
													System.out.println("El precio final es: "+(precioTotal-descuento)+"€");
												}
												
												
												guardado4=true;	
											}
										}
										
										if(!guardado3&&!guardado4) {
											System.out.println("No coincide con un cliente, intentalo con un cliente ya registrado. Si deseas salir, escriba 0.");
											consulta = d.next();
										}
										
										if(consulta.equals("0")) { guardado3=true;}
										
									}
									
									
									
									
								break;
								
								case "5":  
									
									
									
									System.out.println("Introduce el NIF del cliente a consultar");
									consulta = d.next();
									Boolean in1=true;
									Boolean in2=true;
									while(in1&&in2) {
										
										for (cliente cli:clientes) {
											
											if(cli.getNIF().equals(consulta.toUpperCase())) {
												for (reserva res: reservas) {
													
													if(res.getIdCliente().equals(consulta.toUpperCase())) {
														System.out.println(res.getDatos());
														in1=false;
														
													}
													
												}
											}
											
										}
										
										for (clienteVIP cli:clientesVIP) {
											
											if(cli.getNIF().equals(consulta.toUpperCase())) {
												for (reserva res: reservas) {
													
													if(res.getIdCliente().equals(consulta.toUpperCase())) {
														System.out.println(res.getDatos());
														in2=false;
														
													}
													
												}
											}
											
										}
										
									}
									
									
									
									
									
								break;

								case "6":  
									
									double sumaTotal=0;
									
									
									for (alojamiento aloja:alojamientos) {
										
										for (String alo: alojamientosDisponibles) {
											
											if (aloja.getId_Alojamiento().equals(alo)) {
												sumaTotal=sumaTotal+aloja.getPrecioNoche();
											}
										}
										
										
									}
									sumaTotal=sumaTotal*7;
									double descuento_publicidad = sumaTotal*0.05;
									
									System.out.println("La empresa de publicidad ganaría: "+(descuento_publicidad)+" Euros");
									
									
									
								break;

								case "7":  
									
									
									for (clienteVIP cli : clientesVIP) {
										
										System.out.println(cli.getNIF());
											
										}
									System.out.println("Introduce el NIF del cliente a consultar");
									consulta = d.next();
									String aloja_p="p";
									Boolean con=false;
									Boolean vipcheck=false;
									Boolean reserva=false;
									Boolean aloja_Barbacoa=false;
									while(!con) {
										
										for (clienteVIP cli : clientesVIP) {
											//verificamos que exista el cliente VIP y los casos en los que exista barbacoa
											if(cli.getNIF().equals(consulta.toUpperCase())) {
												vipcheck=true;
												for (reserva res:reservas) {							
													if(res.getIdCliente().equals(consulta)) {
														reserva=true;
														for (alojamiento aloja:alojamientos) {		
															if(aloja.getTipo_Alojamiento().equals(aloja_p.toLowerCase())&&aloja.isInfo_Compartida2()
																	&&res.getIdAlojamiento().equals(aloja.getId_Alojamiento().toLowerCase())) {
																System.out.println(aloja.mostrar_Alojamiento());
																con=true;
																aloja_Barbacoa=true;
															}
														}
													}
												}
											}
										}			
										
										if (!vipcheck) {
											System.out.println("No es un cliente VIP, intentroduce un cliente VIP");
											consulta = d.next();
										}
										
										if (!reserva) {
											System.out.println("Este cliente VIP, no dispone de reserva, intenté nuevamente o envíe 0 para salir");
											consulta = d.next();
										}
										
										if (!aloja_Barbacoa) {
											System.out.println("Ningún alojamiento reservado por este cliente, posee barbacoa");
											consulta = d.next();
										}
										
										if (consulta.equals("0")) {
											con=true;
										}
									}
									
									
								break;

								case "0": System.out.println("Hasta pronto!"); consultando=false; 
								
								break;
								
								default :
									System.out.println("No es una opción válida, intenta otra vez");
								
								
										
						}
					}
				}
	}


	
	
	
	
}
