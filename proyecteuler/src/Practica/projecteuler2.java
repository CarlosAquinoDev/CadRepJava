package Practica;

public class projecteuler2 {

	public static void main(String[] args) {
		
		int a=1;
		int b=2;
		int c=0;
		
		for (int i=0;i<100;i++) {
			
			
			if(a%2==0&&c<4000000) {
				c+=a;
			}
			if(b%2==0&&c<4000000) {
				c+=b;
			}
			a=a+b;
			b=b+a;
			
		}
		System.out.println(c);

	}

}
