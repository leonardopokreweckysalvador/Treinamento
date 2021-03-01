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

import com.treinamento.service.PessoaService;

import pasta.treinamento.model.Pessoa;

public class CadastroPessoa extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField nomePessoa;
	private JTextField sobrenomePessoa;
	private PessoaService pessoaService;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPessoa frame = new CadastroPessoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CadastroPessoa() {
		pessoaService = new PessoaService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(33, 26, 54, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sobrenome");
		lblNewLabel_1.setBounds(33, 54, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		nomePessoa = new JTextField();
		nomePessoa.setBounds(106, 23, 175, 20);
		contentPane.add(nomePessoa);
		nomePessoa.setColumns(10);
		
		sobrenomePessoa = new JTextField();
		sobrenomePessoa.setBounds(106, 51, 175, 20);
		contentPane.add(sobrenomePessoa);
		sobrenomePessoa.setColumns(10);
		
		final JButton buttonPessoa = new JButton("Cadastrar");
		buttonPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoa = new Pessoa();				
				pessoa.setNome(nomePessoa.getText());
				pessoa.setSobrenome(sobrenomePessoa.getText());
				try {
					pessoaService.addPessoa(pessoa);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(buttonPessoa, ex.getMessage(),
		                    "ERROR", JOptionPane.ERROR_MESSAGE);
	 		    }
			}
		});
		buttonPessoa.setBounds(34, 99, 99, 23);
		contentPane.add(buttonPessoa);	
	}
}