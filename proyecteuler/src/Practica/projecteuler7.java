package Practica;

public class projecteuler7 {

	public static void main(String[] args) {
		
		
		
		boolean b=true;
		
		int c=0;
		
		for (int primo=2;primo<1000;primo++) {
			b=true;
			for (int i =2;i<1000;i++) {
				if (primo%i==0&&b==true) {
					
					if(primo!=i) {
						b=false;
					}else {
						c++;
						//if (c==10001) {
							//System.out.println(primo+" Es primo"+i);
						//}
						System.out.println(c+". "+primo+" Es primo");
					}
				}
				
			}
			
		}
		

	}

}
