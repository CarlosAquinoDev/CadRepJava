package Practica;

public class projecteuler1 {

	public static void main(String[] args) {
		int a=0;
		
		for ( int i=0; i<1000;i++) {
			if(i%3==0||i%5==0) {
				a+=i;
			}			
		}		
		System.out.println(a);
	}

}
