package TiendaZapatillas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TablaArmario extends JFrame{

	private static int elegida ;
	public static boolean actArmario=false;
	private static Object [] [] data;
	private static final String columnT[]={"Id","Modelo","Color","Valor",""};
	private static AbstractTableModel model = new DefaultTableModel(data,columnT);
	private static JTable tableArmario = new JTable(model);
	private static JPanel miPanel = new JPanel();
	
	public static JTable TablaArmario() {
		
		
		//data
		Object [] [] data = Sentenciassql.tablaArmario();
		//titulo Columna
		String columnT[]={"Id","Modelo","Color","Valor",""};
		
		//modelo de la tabla
		AbstractTableModel model = new DefaultTableModel(data,columnT);
		
		//creamos la tabla
		tableArmario = new JTable(model);
		TablaArmario().setModel(model);
		//Colocamos el renderer
		tableArmario.getColumnModel().getColumn(4).setCellRenderer(new ButtonRendererArmario());
		
		//colocamos el editor a las columnas
		tableArmario.getColumnModel().getColumn(4).setCellEditor(new ButtonEditorArmario(new JTextField()));
		
		//Tamano columnas
		tableArmario.setRowHeight(30);
		
		
		
		return tableArmario;
		
	}

	public void updateTabla() {
		
		
		
		data = Sentenciassql.tablaArmario();
		
		model = new DefaultTableModel(data,columnT);
		//renderer
		tableArmario.getColumnModel().getColumn(4).setCellRenderer(new ButtonRendererArmario());
		//colocamos el editor a las columnas
		tableArmario.getColumnModel().getColumn(4).setCellEditor(new ButtonEditorArmario(new JTextField()));
		//tamano
		tableArmario.setRowHeight(30);
		
		miPanel.add(new JScrollPane(tableArmario));
		
		
		
	}
	
	public static JComponent getComponent() {
		return miPanel;
	}

	 

	public static JTable getTabla() {
		return tableArmario;
	}

	public static boolean isActArmario() {
		return actArmario;
	}
	
	public static void setActArmario(boolean actArmario) {
		TablaArmario.actArmario=actArmario;
	}
	
	
	public static int getIdSelected() {
		return elegida;
	}


	public static void setIdSelected(int elegida) {
		TablaArmario.elegida = elegida;
	}
	
}

//RendererClass
	class ButtonRendererArmario extends JButton implements TableCellRenderer{

	//constructor
	public ButtonRendererArmario() {
		//Propiedades del boton
		setOpaque(true);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		
		
		//Colocar el objeto como Botón
		setText((obj==null)? "":obj.toString());
		return this;
	}
	
	
	}
	
	//Editor Class
		class ButtonEditorArmario extends DefaultCellEditor
		{
		
		
		protected JButton btn;
		private String lbl;
		private boolean clicked;
		public ButtonEditorArmario(JTextField txt) {
			super(txt);
			btn=new JButton();
			btn.setOpaque(true);
			
			//al ser pulsado el boton
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					fireEditingStopped();
					
				}
			});
		}
		
		//override methods
		@Override
		public Component getTableCellEditorComponent(JTable table, Object obj, boolean isSelected, int row, int column) {
			
			
			// colocar texto al botón, resultado de ser clickeado,retornar objeto btn
			lbl=((obj==null)? "":obj.toString());
			btn.setText(lbl);
			clicked=true;
			TablaArmario.setIdSelected(row);
			
			return btn;
		}
		
		//si cambia el valor de un método
		@Override
		public Object getCellEditorValue() {
			
			if(clicked) {
				
				String idClickeado = (String)TablaArmario.getTabla().getValueAt(TablaArmario.getIdSelected(), 0);
				Sentenciassql.borrarArmario(idClickeado);
				JOptionPane.showMessageDialog(btn, " ID: "+idClickeado+" ha sido borrado de su armario.");
				
				
				
			}
			clicked=false;
			return new String(lbl);
		}
		
		@Override
		public boolean stopCellEditing() {
			clicked=false;
			
			return super.stopCellEditing();
		}
		
		@Override
		protected void fireEditingStopped() {
			// TODO Auto-generated method stub
			super.fireEditingStopped();
		}
		
		
	}
