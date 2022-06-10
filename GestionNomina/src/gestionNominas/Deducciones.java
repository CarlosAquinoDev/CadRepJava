package gestionNominas;


import java.io.Serializable;
import java.util.ArrayList;

public class Deducciones implements Serializable {
    //ATRIBUTOS
    private double irpf;
    private ArrayList<DiasDeBaja> listaDiasDeBaja;

    //CONSTRUCTORES
    public Deducciones(double irpf){
        this.irpf=irpf;
        this.listaDiasDeBaja=new ArrayList<>();
    }

    //GETTERS Y SETTERS
    public double getIrpf() {
        return irpf;
    }
    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }
    public ArrayList<DiasDeBaja> getListaDiasDeBaja() {
        return listaDiasDeBaja;
    }
    public void setListaDiasDeBaja(ArrayList<DiasDeBaja> listaDiasDeBaja) {
        this.listaDiasDeBaja = listaDiasDeBaja;
    }

    //METODOS
    void annadirDiasDeBaja(int mes, int a√nos, int numero){
        DiasDeBaja diasDeBaja = new DiasDeBaja( mes, a√nos,  numero);
        listaDiasDeBaja.add(diasDeBaja);
    }
    int calculaDiasDeBaja(int mes, int a√nos){
        int num = 0;
        for (DiasDeBaja d : listaDiasDeBaja){
            if((d.getMes())== mes && (d.getA√no())==a√nos){
                num = d.getNumero();
            }
        }
        return num;
    }
}
