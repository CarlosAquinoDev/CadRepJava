package gestionNominas;

import java.io.Serializable;
import java.util.ArrayList;
public class Complementos implements Serializable {

    private int trienios;
    private ArrayList<HorasExtras> h;

    public Complementos (int trienios) {
        this.trienios = trienios;
        this.h = new ArrayList<>();
    } 
    public Complementos () {
    }

    public int getTrienios() {
        return trienios;
    }
    public void setTrienios(int trienios) {
        this.trienios = trienios; }

    public ArrayList<HorasExtras> getH() {

        return h;
    }

    public void setH(ArrayList<HorasExtras> h) {

        this.h = h;
    }

    public int bonificacionHorasExtras(int a√no, int mes) {
        int bonificacion = 0;
        for (int i = 0; i < h.size(); i++) {

            if ((h.get(i).getA√no() == a√no) && (h.get(i).getMes() == mes)) {
                bonificacion = h.get(i).getNumero();
            }
        }
        return bonificacion * 15;
    }

    public void annadirHoras (int a√no, int mes, int numero){

        h.add (new HorasExtras(a√no, mes, numero));
    }
}





