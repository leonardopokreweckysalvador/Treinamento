package com.treinamento.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.treinamento.service.CafeService;

import pasta.treinamento.model.Cafe;

public class CadastroCafe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField nomeCafe;
	private JTextField lotacaoCafe;
	private CafeService cafeService;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCafe frame = new CadastroCafe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CadastroCafe() {
		cafeService = new CafeService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do café");
		lblNewLabel.setBounds(33, 26, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lotação");
		lblNewLabel_1.setBounds(33, 54, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		nomeCafe = new JTextField();
		nomeCafe.setBounds(133, 23, 175, 20);
		contentPane.add(nomeCafe);
		nomeCafe.setColumns(10);
		
		lotacaoCafe = new JTextField();
		lotacaoCafe.setBounds(133, 51, 175, 20);
		contentPane.add(lotacaoCafe);
		lotacaoCafe.setColumns(10);
		
		
		final JButton buttonCafe = new JButton("Cadastrar");
		buttonCafe.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Cafe cafe = new Cafe();				
				cafe.setNome(nomeCafe.getText());
				cafe.setLotacao(Integer.parseInt(lotacaoCafe.getText()));
				try {
					cafeService.addCafe(cafe);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(buttonCafe, ex.getMessage(),
							"ERRO", JOptionPane.ERROR_MESSAGE);
				    }	
			}
		});
		buttonCafe.setBounds(34, 99, 99, 23);
		contentPane.add(buttonCafe);
	}
}
