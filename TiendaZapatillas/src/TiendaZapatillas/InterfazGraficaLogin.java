package TiendaZapatillas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InterfazGraficaLogin {
			
	
	//Statics
	
	//label
	private static JLabel labelC = new JLabel("Password");
	private static JLabel labelCn = new JLabel("Password");
	private static JLabel labelCo = new JLabel("Correo");
	private static JLabel labelU = new JLabel("Usuario");
	private static JLabel Mensaje = new JLabel("");
	//Textfields - passwordfield
	private static JTextField textU = new JTextField(1);
	private static JPasswordField textC = new JPasswordField(2);
	private static JPasswordField textCn = new JPasswordField(3);
	private static JTextField textCo = new JTextField(4);
	//buttons
	private static JButton botonEnviar = new JButton ("Login");
	private static JButton botonRegistro = new JButton ("Registro");
	private static JButton botonGuardar = new JButton ("Guardar");
	private static JButton botonCancelar = new JButton ("Cancelar");
	
	public static void iniciar () {
		
		 JFrame frameLogin= new JFrame();
		 JPanel panelLogin= new JPanel();
		
		//frame
		frameLogin.setSize(350,200);
		frameLogin.setTitle("Login");
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.add(panelLogin);
		
		//Panel
		panelLogin.setLayout(null);
		panelLogin.setBackground(Color.gray.brighter());
		
		
		//Usuario
		labelU.setBounds(20,20,80,25);
		panelLogin.add(labelU);
		textU.setBounds(110,20,165,25);
		panelLogin.add(textU);
		
		
		//password	
		labelC.setBounds(20,50,80,25);
		textC.setBounds(110,50,165,25);
		panelLogin.add(labelC);
		panelLogin.add(textC);
		
		
		
		//Buttons
		//Conectar
		botonEnviar.setBounds(175,95,100,25);
		botonEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (Sentenciassql.accederClientes(textU.getText(), textC.getPassword())) {
					Mensaje.setText("Conectado correctamente");
					InterfazGraficaArmario.iniciar();
					frameLogin.dispose();
					
				} else {
					Mensaje.setForeground(Color.red);
					Mensaje.setText("Usuario o password invalido.");
				}
				
			}
		});
		
		//Borrar
		botonRegistro.setBounds(60,95,100,25);
		botonRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				
				registrar();
				Mensaje.setText("");
				textU.setText("");
				textC.setText("");
				textCo.setText("@gmail.com");
				textCn.setText("");
				frameLogin.dispose();
			}
		});
		

		
		//Agregar a panel
		panelLogin.add(botonEnviar);
		panelLogin.add(botonRegistro);

		
		
		
		//Mensaje
		Mensaje.setBounds(10,130,300,25);
		panelLogin.add(Mensaje);
		
		frameLogin.setLocationRelativeTo(null);
		frameLogin.setVisible(true);
		
		
		
	}

	public static void registrar () {
		
		
		JFrame frameRegistro= new JFrame();
		JPanel panelRegistro= new JPanel();
		
		//frame
		frameRegistro.setSize(350,250);
		frameRegistro.setTitle("Registro");
		frameRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRegistro.add(panelRegistro);
		
		//Panel
		panelRegistro.setLayout(null);
		panelRegistro.setBackground(Color.gray.brighter());
		
		
		//Usuario
		labelU.setBounds(20,20,80,25);
		textU.setBounds(110,20,165,25);
		panelRegistro.add(labelU);
		panelRegistro.add(textU);
		
		//Correo
		labelCo.setBounds(20,50,80,25);
		textCo.setBounds(110,50,165,25);
		panelRegistro.add(labelCo);
		panelRegistro.add(textCo);
				
				
		//password	
		labelC.setBounds(20,80,80,25);
		textC.setBounds(110,80,165,25);
		panelRegistro.add(labelC);
		panelRegistro.add(textC);
		
		//password nuevamente
		labelCn.setBounds(20,110,80,25);
		textCn.setBounds(110,110,165,25);
		panelRegistro.add(labelCn);
		panelRegistro.add(textCn);
		
		
		
		
		//Botones
		//Cancelar
		botonCancelar.setBounds(50,160,100,25);
		botonCancelar.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
						iniciar();
						frameRegistro.dispose();
						Mensaje.setText("");
						textC.setText("");
						textU.setText("");
						textCn.setText("");
						textCo.setText("");
			}
		});
		//Guardar
		botonGuardar.setBounds(175,160,100,25);
		botonGuardar.addActionListener(new ActionListener() {
							
			@Override
			public void actionPerformed(ActionEvent e) {
				
						
					if (textU.getText().isEmpty()||textCo.getText().isEmpty()||textC.getPassword().length==0||textCn.getPassword().length==0) {
						Mensaje.setText("Debe rellenar todos los datos");
						Mensaje.setForeground(Color.red);
					}else if (!Arrays.equals(textC.getPassword(), textCn.getPassword())) {
						Mensaje.setText("El password deben coincidir");
						Mensaje.setForeground(Color.red);
					}else if(Arrays.equals(textC.getPassword(), textCn.getPassword()) ) {
						Sentenciassql.registrar(textU.getText(), textCo.getText(), textC.getPassword());
						Mensaje.setText("Se ha creado el usuario correctamente.");
						Mensaje.setForeground(Color.green.darker());
						iniciar();
						frameRegistro.dispose();
					}		
						
						
					}
				});
		
		
		
		
		//Mensaje
		Mensaje.setBounds(10,130,300,25);
		panelRegistro.add(Mensaje);
		
		panelRegistro.add(botonCancelar);
		panelRegistro.add(botonGuardar);
		frameRegistro.setLocationRelativeTo(null);
		frameRegistro.setVisible(true);
		
	}
	
	
	
	
}
