package Practica;

public class Ej1 {

	public static void main(String[] args) {
		
		int a=1;
		int b=1;
		int c=0;
		 
		for (int i=0;a<4000000||b<4000000;i++ ) {
									
			b=b+a;
			System.out.println(a);
			a=a+b; 
			System.out.println(b);
			
			if (a%2==0) {
				System.out.println(c);
				c=c+a;
				
				
			}else if(b%2==0) {
				System.out.println(c);
				c=c+b;
				
			}
			
			
		}
	
		
		
		
		
	}

}
