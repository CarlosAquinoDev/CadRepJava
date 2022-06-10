package autoClicker;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class clicker {
	
	private static int pedirAhoraX=0;
	private static int pedirAhoraY=0;
	private static int vendidoX=0;
	private static int vendidoY=0;
	private static Thread t;
	
	public static void menu () {
			
		JFrame j = new JFrame();
		JPanel p = new JPanel();
		JButton jbStart = new JButton("Start");
		JButton jbStop = new JButton("Stop");
		//Pedir
		JButton jbSetPedirAhora = new JButton("Set");
		JLabel pedirAhoraTxt2 = new JLabel("Pedir Ahora");
		//
		JButton jbSetVendido = new JButton("Set");
		JLabel setVendido2 = new JLabel("Vendido");
		
		
		
		j.setSize(250,200);
		j.setTitle("Cotps bot");
		j.add(p);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel
		p.setLayout(null);
		p.setBackground(Color.gray.brighter());
		
		
		/*
		 * 
		 * Pedir ahora
		 * 
		 */
		pedirAhoraTxt2.setBounds(30,35,150,25);
		p.add(pedirAhoraTxt2);
		
		jbSetPedirAhora.setBounds(110,35,80,25);
		p.add(jbSetPedirAhora);
		
		jbSetPedirAhora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JFrame jf = new JFrame ();
				jf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				jf.setUndecorated(true);
				jf.setOpacity(0.1f);
				
				jf.setVisible(true);
				jf.setLocationRelativeTo(null);
				
				j.setExtendedState(1);
				
				jf.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						
						Point punto = MouseInfo.getPointerInfo().getLocation();
						 pedirAhoraTxt2.setText(punto.x+","+punto.y);
						 pedirAhoraX=punto.getLocation().x;
						 pedirAhoraY=punto.getLocation().y;
						 j.setExtendedState(0);
						 jf.dispose();
					}
				});
			}
		});
		
		
		/*
		 * 
		 * Vendido
		 * 
		 */
		setVendido2.setBounds(30,80,150,25);
		p.add(setVendido2);
		
		jbSetVendido.setBounds(110,80,80,25);
		p.add(jbSetVendido);
		
		jbSetVendido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JFrame jf = new JFrame ();
				jf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				jf.setUndecorated(true);
				jf.setOpacity(0.1f);
				
				jf.setVisible(true);
				jf.setLocationRelativeTo(null);
				
				j.setExtendedState(1);
				
				jf.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						
						Point punto = MouseInfo.getPointerInfo().getLocation();
						setVendido2.setText(punto.x+","+punto.y);
						vendidoX=punto.getLocation().x;
						vendidoY=punto.getLocation().y;
						 j.setExtendedState(0);
						 jf.dispose();
					}
				});
			}
		});
		
		//start
		jbStart.setBounds(20,120,80,25);
		p.add(jbStart);
		
		jbStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Runnable r = new movimientoClickHilos(pedirAhoraX, pedirAhoraY, vendidoX, vendidoY);
				
				t = new Thread (r);
				
				t.start();
				
				
				
				
			}
		});
		
		//Stop
		
		jbStop.setBounds(120,120,80,25);
		p.add(jbStop);
		
		jbStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				detener();
				
			}

			private void detener() {
				
				t.interrupt();
				
			}
		});
		
		
		
		//end
		j.setLocationRelativeTo(null);
		j.setVisible(true);
		
		
		
	}
	
	

	
}





