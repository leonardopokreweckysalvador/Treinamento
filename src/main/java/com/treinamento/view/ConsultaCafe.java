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

import com.treinamento.service.CafeService;

import java.util.List;
import pasta.treinamento.model.Cafe;

public class ConsultaCafe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable tableListCafe;
	private JScrollPane scrollPane;
	private CafeService cafeService;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCafe frame = new ConsultaCafe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ConsultaCafe() {
		cafeService = new CafeService();
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
		List<Cafe> cafes = null;
		try {			
			cafes = cafeService.getAllCafes();
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
		}		
		for (Cafe cafe : cafes) {
			String[] row = {String.valueOf(cafe.getId()), cafe.getNome(), String.valueOf(cafe.getLotacao()) };		
			model.addRow(row);
		}	
		tableListCafe = new JTable();
		tableListCafe.setModel(model);
		
		tableListCafe.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tableListCafe);
		tableListCafe.setToolTipText("");
		
		JButton mostrarCafe = new JButton("Informação do café");
		mostrarCafe.setBounds(142, 227, 145, 23);
		mostrarCafe.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		contentPane.setLayout(null);
		contentPane.add(mostrarCafe);
		
		JLabel lblNewLabel = new JLabel("Lista café");
		lblNewLabel.setBounds(30, 11, 85, 14);
		contentPane.add(lblNewLabel);	
	}
}