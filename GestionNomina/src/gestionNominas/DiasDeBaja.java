package gestionNominas;

import java.io.Serializable;

public class DiasDeBaja implements Serializable {

    // Declaramos atributos:
    private int mes;
    private int a√no;
    private int numero;

    // Constructor:
    public DiasDeBaja(int mes, int a√no, int numero) {
        this.mes = mes;
        this.a√no = a√no;
        this.setNumero(numero);
    }

    // Getters y setters de cada atributo
    public int getMes() {

        return mes;
    }

    public void setMes(int mes) {

        this.mes = mes;
    }

    public int getA√no() {

        return a√no;
    }

    public void setA√no(int a√no) {

        this.a√no = a√no;
    }

    public int getNumero() {

        return numero;
    }

    public void setNumero(int numero) {

        this.numero = numero;
    }
}

