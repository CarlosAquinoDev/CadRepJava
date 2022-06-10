package Practica;

public class Divisionsinresto {

	public static void main(String[] args) {
	
		int x=0;
		
		int b=0;
		
		int limite=0;
	
		
			for (int a=1;limite==0;a++) {
				
				for (int i =1;i<=20;i++) {
				
					if(a%i==0) {
					b++;
					x=a;
					}else {
						b=0;
						break;
					}					
				}
			
				if (b==20) {
				limite=x;	
				System.out.println(limite);
				}
			}
			
		
		
		
	
		
		
	}

}
