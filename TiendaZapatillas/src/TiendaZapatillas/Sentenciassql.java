package TiendaZapatillas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class Sentenciassql {
	
	
	private static String idUsuarioOn= null;
	
	
	public static boolean accederClientes(String n, char[] p) {
		
		boolean conectar=false;
		
		try {		
			
			
			Conexion con = new Conexion();
			ResultSet rs = null;
			
			Connection cn = con.conectar();
			Statement stm=cn.createStatement();
			
			rs = stm.executeQuery("SELECT * FROM usuario");
			
			while (rs.next()) {
				String nick=rs.getString(3);
				char[] password=rs.getString(4).toCharArray();
				
				if (n.equals(nick)&&Arrays.equals(p, password )) {
					conectar=true;
					idUsuarioOn=rs.getString(1);
				}
			
			}
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta");
		}

		return conectar;
		
	}

	
	public static void registrar(String nick_r,String Correo_r,char[]pass_r ) {
		
		
		String datosRegistro;
		int id=0;
		try {		
			
			Conexion con = new Conexion();
			ResultSet rs = null;
			
			Connection cn = con.conectar();
			Statement stm=cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuario");
			while (rs.next()) {
				id=id+1;
			}			
			
			String ps=String.valueOf(pass_r);
			id=id+1;
			datosRegistro="INSERT INTO usuario (id,correo,nick,password,armario) VALUES('"+id+"','"+Correo_r+"','"+nick_r+"','"+ps+"','')";
			
			
			stm.executeUpdate(datosRegistro);
			
			
			cn.close();
			rs.close();
			stm.close();
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de registro");
		}
		
	}
	
	
	public static Object [] [] tablaZapatillas() {

		
		ArrayList<Zapatilla> zap = new ArrayList<Zapatilla>();
		
		try {
			Conexion con = new Conexion();
			ResultSet rs = null;
			Connection cn = con.conectar();
			Statement stm=cn.createStatement();
			
			
			
			
			rs = stm.executeQuery("SELECT * FROM zapatilla");
			
			while (rs.next()) {
				
				String idZapatilla=rs.getString(1);
				String modelo=rs.getString(2);
				String color=rs.getString(3);
				String valor=rs.getString(4);
				
				zap.add(new Zapatilla(idZapatilla,modelo,color,valor));
				
			}
			
			cn.close();
			rs.close();
			stm.close();
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta");
		}
		
		Object s[] [] = new String [zap.size()] [5] ;
		
		int spin=0;
			
				
				for (Zapatilla z: zap) {
					s[spin][0]=z.getId();
					s[spin][1]=z.getModelo();
					s[spin][2]=z.getColor();
					s[spin][3]=z.getValor();
					s[spin][4]="guardar";
					spin++;
				}
		
				
				
				
		return s;
		
	}

	
	
	public static Object [] [] tablaArmario() {
		
		
		
		ArrayList<Zapatilla> zap = new ArrayList<Zapatilla>();
		String [] idsMiArmarioUs = null ;
		
		try {			
			Conexion con = new Conexion();
			ResultSet rs = null;
			Connection cn = con.conectar();
			Statement stm=cn.createStatement();
			
			rs = stm.executeQuery("SELECT * FROM zapatilla");
			while (rs.next()) {	
				
				String idZapatilla=rs.getString(1);
				String modelo=rs.getString(2);
				String color=rs.getString(3);
				String valor=rs.getString(4);
				
				zap.add(new Zapatilla(idZapatilla,modelo,color,valor));
				
			}
			
			rs = stm.executeQuery("SELECT * FROM usuario where id='"+idUsuarioOn+"'");
			while (rs.next()) {	
				idsMiArmarioUs=rs.getString(5).split("\\s+");
			}
			
			
			
			cn.close();
			rs.close();
			stm.close();
					
		} catch (SQLException e) {
			System.out.println("Error en la consulta de registro");
		}
		
		Object s[] [] = new String [zap.size()] [5] ;
		
		int spin=0;
		
		String a = "0";
		
		
		for (Zapatilla z:zap) {
			for(String i:idsMiArmarioUs) {
				if(z.getId().equals(i)) {
					s[spin][0]=z.getId();
					s[spin][1]=z.getModelo();
					s[spin][2]=z.getColor();
					s[spin][3]=z.getValor();
					s[spin][4]="Borrar";
					spin++;
				}
				
			}
			
		}
		return s;
		
	}
	
	public static void borrarArmario(String idClick) {
		
		 
		String datosRegistro;
		
		String [] idsMiArmarioUs = null;
		
		try {	
			Conexion con = new Conexion();
			ResultSet rs = null;
			Connection cn = con.conectar();
			Statement stm=cn.createStatement();
			
			rs = stm.executeQuery("SELECT * FROM usuario where id='"+idUsuarioOn+"'");
			while (rs.next()) {	
				idsMiArmarioUs = idsMiArmarioUs=rs.getString(5).split("\\s+");
			}
			
			for(int i=0;i<idsMiArmarioUs.length;i++) {
				
				if(idClick.equals(idsMiArmarioUs[i])) {
					List<String> arrayTemp = new ArrayList<String>();
					Collections.addAll(arrayTemp, idsMiArmarioUs);
					arrayTemp.remove(i);
					
					if(arrayTemp.size()>0) {
						String [] c = new String[arrayTemp.size()];
						c=arrayTemp.toArray(c);
						idsMiArmarioUs=c;
					}
					
				}
				
			}
			
			String stringArmarioAct = String.join(" ", idsMiArmarioUs);
			
			datosRegistro="UPDATE usuario SET armario = ('"+stringArmarioAct+"') where id='"+idUsuarioOn+"';";
			stm.executeUpdate(datosRegistro);
			
			cn.close();
			rs.close();
			stm.close();
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de registro");
		}
		
	}
	
	
	public static void agregarArmario (String idClick) {
		
		
		String datosRegistro;
	
		try {	
			Conexion con = new Conexion();
			Connection cn = con.conectar();
			Statement stm=cn.createStatement();
			
			datosRegistro="UPDATE usuario SET armario = CONCAT(armario, ' "+idClick+"') where id='"+idUsuarioOn+"';";
			stm.executeUpdate(datosRegistro);
			
			cn.close();
			stm.close();
			
		} catch (SQLException e) {
			System.out.println("Error en la consulta de registro");
		}
		
		
	}
	
	
	
	
}
