package com.treinamento.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import com.treinamento.service.SalaService;
import pasta.treinamento.model.Sala;

public class ConsultaSala extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable tableListSala;
	private JScrollPane scrollPane;
	private SalaService salaService;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaSala frame = new ConsultaSala();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
    	});
	}
	

	public ConsultaSala() {
		salaService = new SalaService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 30, 367, 180);
		contentPane.add(scrollPane);		
		
		String[] tblHead={"ID","Nome","Lotacao"};
		DefaultTableModel model = new DefaultTableModel(tblHead, 0);
		List<Sala> salas = null;
		try {			
			salas = salaService.getAllSalas();
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
		}		
		for (Sala sala : salas) {
			String[] row = {String.valueOf(sala.getId()), sala.getNome(), String.valueOf(sala.getLotacao()) };		
			model.addRow(row);
		}		
		tableListSala = new JTable();
		tableListSala.setModel(model);
		
		tableListSala.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tableListSala);
		tableListSala.setToolTipText("");
		
		
		
		
		JButton mostrarSala = new JButton("Informação da sala");
		mostrarSala.setBounds(142, 227, 145, 23);
		mostrarSala.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		contentPane.setLayout(null);
		contentPane.add(mostrarSala);
		
		JLabel lblNewLabel = new JLabel("Lista sala");
		lblNewLabel.setBounds(30, 11, 85, 14);
		contentPane.add(lblNewLabel);	
	}
}