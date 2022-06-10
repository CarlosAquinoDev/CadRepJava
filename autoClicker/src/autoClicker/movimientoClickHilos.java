package autoClicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class movimientoClickHilos implements Runnable {


	int i=0;
	int transacciones = 6;
	private int secondsOnMillis = 1000;
	private int secondsOnMins = 60;
	private int minutesToWait = 135;
	private int mouseButton = InputEvent.BUTTON1_DOWN_MASK;
	private int pedirAhoraX;
	private int pedirAhoraY;
	private int vendidoX;
	private int vendidoY;
	
	 public movimientoClickHilos(int pedirAhoraX, int pedirAhoraY, int vendidoX ,int vendidoY) {
		 	i=0;
			transacciones = 6;	
			this.pedirAhoraX=pedirAhoraX;
			this.pedirAhoraY=pedirAhoraY;
			this.vendidoX=vendidoX;
			this.vendidoY=vendidoY;
	}
	
	
	@Override
	public void run() {
		
		try {
			URI uri;
			uri = new URI("https://www.cotps.com/#/pages/transaction/transaction");
			
		Robot r = new Robot();
		
		
		while (i<transacciones+1) {
			java.awt.Desktop.getDesktop().browse(uri);
			switch (i) {
			
			case 0,1,2,3,4,5: 
				
			//Posición de botón pedir ahora
			r.mouseMove(pedirAhoraX, pedirAhoraY);
			Thread.sleep(secondsOnMillis * 2);
			
			//clicks
			Thread.sleep(3000);
			r.mousePress(mouseButton);
			Thread.sleep(400);
			r.mouseRelease(mouseButton);
			Thread.sleep(3000);
			
			//posición botón vendido
			r.mouseMove(vendidoX, vendidoY);
			
			
			//clicks Click vendido
			Thread.sleep(4000);
			r.mousePress(mouseButton);
			Thread.sleep(400);
			r.mouseRelease(mouseButton);
			Thread.sleep(4000);
			
			//click Confirmar
			Thread.sleep(3000);
			r.mousePress(mouseButton);
			Thread.sleep(400);
			r.mouseRelease(mouseButton);
			Thread.sleep(3000);
			
			
			i++;
			
				break;
			case 6: 
				Thread.sleep(secondsOnMillis * 2);
				Thread.sleep(minutesToWait * secondsOnMins * secondsOnMillis);
				i=0;
				break;
				
			}
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error general");
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error de robot");
		}catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error de robot");
		}
		
		
		
	}

}
