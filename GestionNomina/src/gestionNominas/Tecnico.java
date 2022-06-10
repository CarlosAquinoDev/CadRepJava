package gestionNominas;

import java.io.Serializable;

public class Tecnico extends Persona implements Serializable{
    //CONSTRUCTOR
    public Tecnico(String nombre, String telefono, Fecha fechaNacimiento, String dni, CuentaBancaria cuentaBancaria, Contrato contrato) {
        super(nombre, telefono, fechaNacimiento, dni, cuentaBancaria, contrato);
    }

    @Override
    public double calculaNomina(int mes, int a√nos) {
        System.out.println(this.nombre + " " +this.dni);
        System.out.println("Cuenta: " + this.cuentaBancaria.getIban());
        System.out.println("Puesto: " + this.contrato.getPuesto());
        double s =  this.contrato.getSalarioBase() /12;
        System.out.println("Salario mes: "+s);
        s += (double) this.contrato.c.getTrienios()*20;
        System.out.println("Por trienios: " + (double) this.contrato.c.getTrienios()*20);
        s += (double) 15 * this.contrato.c.bonificacionHorasExtras(mes, a√nos);
        System.out.println("+ Horas Extra: " + (double) 15 * this.contrato.c.bonificacionHorasExtras(mes, a√nos));

        s+= this.contrato.getSalarioBase() * this.contrato.d.calculaDiasDeBaja(mes, a√nos);

        System.out.println("- IRPF: " + s * this.contrato.getD().getIrpf());
        s*=(1-this.contrato.getD().getIrpf());
        System.out.println("- Desempleo: " + s * 0.016);
        s*=0.984;
        System.out.println("- Contingencias: " + s * 0.047);
        s*=0.953;
        System.out.println("- Apercibir: " + s);

        return s;
    }

}