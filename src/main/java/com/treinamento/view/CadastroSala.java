package com.treinamento.view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.treinamento.service.SalaService;

import pasta.treinamento.model.Sala;

public class CadastroSala extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField nomeSala;
	private JTextField lotacaoSala;
	private SalaService salaService;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroSala frame = new CadastroSala();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CadastroSala() {
		salaService = new SalaService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome 	Sala");
		lblNewLabel.setBounds(33, 26, 54, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lotação");
		lblNewLabel_1.setBounds(33, 54, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		nomeSala = new JTextField();
		nomeSala.setBounds(106, 23, 175, 20);
		contentPane.add(nomeSala);
		nomeSala.setColumns(10);
		
		lotacaoSala = new JTextField();
		lotacaoSala.setBounds(106, 51, 175, 20);
		contentPane.add(lotacaoSala);
		lotacaoSala.setColumns(10);
		
		final JButton buttonSala = new JButton("Cadastrar");
		buttonSala.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Sala sala = new Sala();				
				sala.setNome(nomeSala.getText());
				sala.setLotacao(Integer.parseInt(lotacaoSala.getText()));
				try {
					salaService.addSala(sala);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(buttonSala, ex.getMessage(),
		                    "ERROR", JOptionPane.ERROR_MESSAGE);
	 		    }		
			}			
		});
		buttonSala.setBounds(34, 99, 99, 23);
		contentPane.add(buttonSala);		
	}
}