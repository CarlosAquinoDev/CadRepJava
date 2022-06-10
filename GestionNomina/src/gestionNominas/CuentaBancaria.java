package gestionNominas;

import java.io.Serializable;

public class CuentaBancaria implements Serializable {
	
    //ATRIBUTOS
    private String nombreEntidad;
    private String iban;

    //CONSTRUCTORES
    public CuentaBancaria(String nombreEntidad, String iban){
        this.nombreEntidad=nombreEntidad;
        this.iban=iban;
    }

    //GETTERS Y SETTERS
    public String getIban() {

        return iban;
    }
    public void setIban(String iban) {

        this.iban = iban;
    }
    public String getNombreEntidad() {
        return nombreEntidad;
    }
    public void setNombreEntidad(String nombreEntidad) {

        this.nombreEntidad = nombreEntidad;
    }
}

