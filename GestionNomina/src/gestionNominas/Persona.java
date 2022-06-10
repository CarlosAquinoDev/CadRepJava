package gestionNominas;

import java.io.Serializable;

public abstract class Persona implements Serializable {

	 	protected String nombre;
	    protected String telefono;
	    protected Fecha fechaNacimiento;
	    protected String dni;
	    protected String nombreEntidad;
	    protected String iban;
	    protected CuentaBancaria cuentaBancaria;
	    protected Contrato contrato;

	   
	    // Constructor:
	    public Persona(String nombre, String telefono, Fecha fechaNacimiento, String dni,
	                   CuentaBancaria cuentaBancaria, Contrato contrato) {
	        this.nombre = nombre;
	        this.telefono = telefono;
	        this.fechaNacimiento = fechaNacimiento;
	        this.dni = dni;
	        this.cuentaBancaria=cuentaBancaria;
	        this.contrato = contrato;

	    }
	   
	    public String getpersona() {
	    	return "Nombre: "+nombre+" Telefono: "+telefono+" DNI: "+dni+" Fecha de nacimiento: "+fechaNacimiento+"\r\n";
	    }
	    
	    // Getters y setters
	    public String getNombre() {
	        return nombre;
	    }
	

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }

	    public Fecha getFechaNacimiento() {
	        return fechaNacimiento;
	    }

	    public void setFechaNacimiento(Fecha fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }

	    public String getDni() {
	        return dni;
	    }

	    public void setDni(String dni) {
	        this.dni = dni;
	    }

	    public CuentaBancaria getCuentaBancaria() {
	        return cuentaBancaria;
	    }

	    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
	        this.cuentaBancaria = cuentaBancaria;
	    }

	    public Contrato getContrato() {
	        return contrato;
	    }

	    public void setContrato(Contrato contrato) {
	        this.contrato = contrato;
	    }

	    public abstract double calculaNomina( int mes, int anno);
	
}
