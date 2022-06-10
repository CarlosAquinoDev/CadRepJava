package TiendaZapatillas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;




public class InterfazGraficaArmario {
	
		public static boolean s = false;
		
	
	public static void iniciar() {
		
			JFrame frameI= new JFrame();
			JPanel panelI= new JPanel();
			JButton botonArmario = new JButton ("Mi armario");
			JButton botonZapatillas = new JButton ("Zapatillas");
			
			
			
				//frame
				frameI.setSize(350,150);
				frameI.setTitle("Menú Usuario");
				frameI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameI.add(panelI);
				
				//Panel
				panelI.setLayout(null);
				panelI.setBackground(new Color(34, 158, 236));
				
				
				
				//BotonArmario
				botonArmario.setBounds(60,40,100,25);
				botonArmario.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						frameI.dispose();
						armario();
						
					}
				});
				
				//BotonZapatillas
				
				botonZapatillas.setBounds(180,40,100,25);
				botonZapatillas.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						frameI.dispose();
						
						zapatillas();
						
					}
				});
				
				// Agregar a pannel
				panelI.add(botonArmario);
				panelI.add(botonZapatillas);
				
				//Visibilidad
				frameI.setLocationRelativeTo(null);
				frameI.setVisible(true);
				
				
	}
	
	
	public static void armario() {
		
		
		
		JFrame frameA = new JFrame();	
		JPanel panelA= new JPanel();
		JButton botonVolver = new JButton ("Volver");
		JButton botonRefrescar = new JButton ("Refrescar");
		
		//frame
		frameA.setSize(600,350);
		frameA.setTitle("Tu Armario");
		frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameA.add(panelA);
	
		//Panel
		panelA.setLayout(null);
		panelA.setBackground(new Color(34, 158, 236));
		
		
		//tabla
		//ScrollPane
		JTable t = TablaArmario.TablaArmario();
		JScrollPane sp = new JScrollPane(t);
		sp.setBounds(40,40,500,200);
		
		panelA.add(sp);
		
		//Borrar
		botonVolver.setBounds(40,250,100,25);
		botonVolver.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								iniciar();
								
								frameA.dispose();
								
							}
						});
		
		panelA.add(botonVolver);
		
		//Refrescar
		botonRefrescar.setBounds(425,250,100,25);
		botonRefrescar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frameA.dispose();
				armario();
			}
		});
		panelA.add(botonRefrescar);
		
		
		//Visibilidad
		frameA.setLocationRelativeTo(null);
		frameA.setVisible(true);
		
		
	}
	
	
	
	
	
	
	public static void zapatillas() {
		
		
		JFrame frameZ= new JFrame();
		JPanel panelZ= new JPanel();
		JButton botonVolver = new JButton ("Volver");
		
		
		//frame
		frameZ.setSize(600,350);
		frameZ.setTitle("Inventario Zapatillas");
		frameZ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameZ.add(panelZ);
			
		//Panel
		panelZ.setLayout(null);
		panelZ.setBackground(new Color(183, 209, 184));
						
		
		
		//tabla
		JScrollPane sp = TablaZapatillas.ScrollTablaZapatos();
		sp.setBounds(40,40,500,200);
		panelZ.add(sp);
		
		
		//Borrar
		botonVolver.setBounds(240,250,100,25);
		botonVolver.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						iniciar();
						frameZ.dispose();
					}
				});
		
		panelZ.add(botonVolver);
				
		//Visibilidad
		frameZ.setLocationRelativeTo(null);
		frameZ.setVisible(true);
		
	}
	
	
}
