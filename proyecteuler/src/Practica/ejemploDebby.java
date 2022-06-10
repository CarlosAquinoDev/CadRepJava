package Practica;

public class ejemploDebby {

	static int a=0;
	static int b=7;
	
	
	public static void main(String[] args) {
		
		
		for (int i =0;i<100;i++) {
			a=i;
			i=i*b;
			System.out.println(i);
			i=a;
		}
		

	}

}
