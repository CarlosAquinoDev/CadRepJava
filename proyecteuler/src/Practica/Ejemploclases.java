package Practica;

public class Ejemploclases {

	public static void main(String[] args) {
	
		

		Ejemploclases a= new Ejemploclases();
		a.calculo(2);
		
		
	}
	
	public double calculo (double n) {

		double a=0;
		a=n;
		
		for ( int i=0; i<1000;i++) {
			if(i%3==0||i%5==0) {
				a+=i;
			}			
		}		
		System.out.println(a);
		
		return a;
		
	}
	
	
	
	}


