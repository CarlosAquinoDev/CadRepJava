package gestionNominas;

import java.io.Serializable;

public class Fecha implements Serializable {
    //ATRIBUTOS
    private int dia;
    private int mes;
    private int a√nos;

    //CONSTRUCTORES
    public Fecha(int dia, int mes, int a√nos) throws Exception {
        if (!esFechaValida(dia, mes, a√nos)){
            throw new Exception("Parece que la fecha no es valida.");
        }
        this.dia = dia;
        this.mes = mes;
        this.a√nos = a√nos;
    }

    //GETTERS Y SETTERS
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) throws Exception{
        if (! esFechaValida(dia, this.mes, this.a√nos)){
            throw new Exception("El valor del dia NO es valido.");
        }
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) throws Exception {
        if (! esFechaValida(this.dia, mes, this.a√nos)){
            throw new Exception("El valor del mes NO es valido.");
        }
        this.mes = mes;
    }
    public int getA√nos() {
        return a√nos;
    }
    public void setA√nos(int a√nos) throws Exception {
        if (! esFechaValida(this.dia, this.mes, a√nos)){
            throw new Exception("El valor del a√no NO es valido.");
        }
        this.a√nos = a√nos;
    }
    //METODOS
    public int diferenciaFechaTrienios(Fecha otra){
        return(Math.abs(this.a√nos-otra.a√nos)/3);
    }
    private boolean esFechaValida(int dia, int mes, int a√nos){
        if(dia<1 || dia>31){
            return false;
        }
        if(mes<1 || mes>12){
            return false;
        }
        if(a√nos<1582){
            return false;
        }
        return true;
    }
    public boolean esAnterior(Fecha otra){
        if (this.a√nos < otra.a√nos){
            return true;
        }
        if(this.a√nos == otra.a√nos && this.mes< otra.mes){
            return true;
        }
        if(this.a√nos == otra.a√nos && this.mes== otra.mes && this.dia<otra.dia){
            return true;
        }
        return false;
    }

    public String toString (){
        return  "" + dia + "/" + mes + "/"+ a√nos;
    }

}