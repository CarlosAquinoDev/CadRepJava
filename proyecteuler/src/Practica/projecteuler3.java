package Practica;

import java.math.BigInteger;

public class projecteuler3 {

	public static void main(String[] args) {
		//600851475143
		BigInteger a= new BigInteger("11");
		BigInteger suma= new BigInteger("1");
		BigInteger b= new BigInteger("0");
		BigInteger c= new BigInteger("0");
		BigInteger cero= new BigInteger("0");
		BigInteger contador= new BigInteger("0");
		
		
		
			
			while (!a.equals(b)) {
				
				b=b.add(suma);
				if (a.remainder(b).equals(cero)) {		
					c=c.add(suma);
						while(b.remainder(c).equals(cero)) {
							c=c.add(suma);	
							//System.out.println(contador);
							
							//System.out.println(b);
							contador=contador.add(suma);
							if(contador.intValue()>2) {
								break;
							}else if(contador.intValue()==2) {
								System.out.println(b);
								contador=cero;
							}else {
								contador=contador.add(suma);
							}
							
						}
				}
			}
	}
}
