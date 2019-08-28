package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controllers.Controller;
import Controllers.ISistema;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		
		ISistema controller = Controller.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 12, 228, 235);
		contentPane.add(scrollPane);
		
		
		String [] nombreColumnas = {"File in directory"};
		DefaultTableModel  tablemodel = new DefaultTableModel(nombreColumnas, 0);
		ArrayList<String> dir = controller.lookDirectory();
		
		for(String d:dir) {
			tablemodel.addRow(
					new Object[] {
							d
					}
					);
			
		}
		
		table = new JTable();
		table.setModel(tablemodel);
		scrollPane.setViewportView(table);
		
		JButton btnLeerAudio = new JButton("Leer audio");
		btnLeerAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				file = controller.readAudio(file);
				Text txt = new Text(file);
				System.out.println("ASD");
				
			}
		});
		btnLeerAudio.setBounds(311, 12, 114, 25);
		contentPane.add(btnLeerAudio);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent ev) {
				// TODO Auto-generated method stub
				if(ev.getValueIsAdjusting()) {
					file = (String) table.getValueAt(table.getSelectedRow(),0);
					
				}
			}
			
		});
		
		

	}
}
