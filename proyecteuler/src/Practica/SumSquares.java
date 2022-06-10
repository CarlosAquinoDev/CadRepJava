package Practica;

public class SumSquares {

	public static void main(String[] args) {
		
		
		double a=0;
		double b=0;
		
		for (int i=1;i<=100;i++) {
			a = Math.pow(i, 2) + a;
		}
		
		for (int i=1;i<=100;i++) {
			b=b+i;
		}
		
		b=Math.pow(b, 2);
		//System.out.println(b-a);
		System.out.printf("%.0f%n", b-a);

	}

}
