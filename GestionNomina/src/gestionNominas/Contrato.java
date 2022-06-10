package gestionNominas;

import java.io.Serializable;

public class Contrato implements Serializable{
    //ATRIBUTOS
    protected String puesto;
    protected double salarioBase;
    protected Fecha fechaAlta;
    protected Fecha fechaBaja;
    protected Complementos c;
    protected Deducciones d;

    //CONSTRUCTORES
    public Contrato(String puesto, double salarioBase, Fecha fecha, Complementos c, Deducciones d){
        this.puesto=puesto;
        this.salarioBase=salarioBase;
        this.fechaAlta=fecha;
        this.fechaBaja=null;
        this.c=c;
        this.d=d; 
    }
    public Contrato (String puesto, double salarioBase, Fecha fechaAlta, Fecha fechaBaja, Complementos c, Deducciones d){

        this.puesto=puesto;
        this.salarioBase=salarioBase;
        this.fechaAlta=fechaAlta;
        this.fechaBaja=fechaBaja;
        this.c= c;
        this.d =d;
    }

    //METODOS
    public void annadeComplementos(int trienios, int mes, int a√nos){
        c.setTrienios(trienios);
        c.annadirHoras(mes, a√nos, c.bonificacionHorasExtras(mes, a√nos));
    }
    public void eliminaComplementos(){
        c=null;
    }
    public void annadeDeducciones(int mes, int a√nos, int numero){
        d.annadirDiasDeBaja(mes, a√nos, numero);
    }
    public void eliminaDeducciones(){
        d=null;
    }

    //GETTERS Y SETTERS
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    public Fecha getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(Fecha fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public Fecha getFechaBaja() {
        return fechaBaja;
    }
    public void setFechaBaja(Fecha fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    public Complementos getC() {
        return c;
    }
    public void setC(Complementos c) {
        this.c = c;
    }
    public Deducciones getD() {
        return d;
    }
    public void setD(Deducciones d) {
        this.d = d;
    }
}
