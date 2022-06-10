package Practica;

public class projecteuler3b {

	public static void main(String[] args) {

		int a=12;
		int b=0;
		int c=0;
		
		for (int i=1;i<=a;i++) {
			
			if(a%i==0) {
				
			for (int y=1;y<=i;y++) {
				
				if(i%y==0){
					b++;
					if (b<=2) {
						c++;
						
					}
					//System.out.println(i);
					//System.out.println(y);
					//System.out.println(b);
				}				
				}
			}
			
			
		}
		
		
		

	}

}
