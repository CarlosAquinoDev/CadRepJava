package TiendaZapatillas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class TablaZapatillas extends JFrame{
	
	private static int idSelected ;
	private static JTable table;
	
	
	public static JScrollPane ScrollTablaZapatos() {
		
		//data
		Object [] [] data = Sentenciassql.tablaZapatillas();
		//titulo Columna
		String columnT[]={"Id","Modelo","Color","Valor",""};
		
		
		//modelo de la tabla
		DefaultTableModel model = new DefaultTableModel(data,columnT);
		
		//Introducimos datos en la tabla
		table = new JTable(model);
		
		//Colocamos el renderer
		table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRendererZapatillas());
		
		//colocamos el editor a las columnas
		table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditorZapatillas(new JTextField()));
		
		//Tamano columnas
		table.setRowHeight(30);
		
		
		//ScrollPane
		JScrollPane pane = new JScrollPane(table);
		
		return pane;
		
	}

	public static JTable getTabla() {
		return table;
	}

	public static int getIdSelected() {
		return idSelected;
	}


	public static void setIdSelected(int idSelected) {
		TablaZapatillas.idSelected = idSelected;
	}

}
	//RendererClass
	class ButtonRendererZapatillas extends JButton implements TableCellRenderer{

	//constructor
	public ButtonRendererZapatillas() {
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
	class ButtonEditorZapatillas extends DefaultCellEditor
	{
	
	
	protected JButton btn;
	private String lbl;
	private boolean clicked;
	public ButtonEditorZapatillas(JTextField txt) {
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
		
		TablaZapatillas.setIdSelected(row);
		
		return btn;
	}
	
	//si cambia el valor de un método
	@Override
	public Object getCellEditorValue() {
		
		if(clicked) {
			
			String idClickeado = (String)TablaZapatillas.getTabla().getValueAt(TablaZapatillas.getIdSelected(), 0);
			if(!idClickeado.isEmpty()||!idClickeado.isBlank()) {

				Sentenciassql.agregarArmario(idClickeado);
				
				JOptionPane.showMessageDialog(btn, " ID: "+idClickeado+" ha sido anadido a su armario.");
			}
			
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
