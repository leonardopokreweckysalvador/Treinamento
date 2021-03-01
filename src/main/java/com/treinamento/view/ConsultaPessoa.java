package com.treinamento.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.treinamento.service.PessoaService;

import pasta.treinamento.model.Pessoa;

public class ConsultaPessoa extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable tableListPessoa;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private PessoaService pessoaService;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPessoa frame = new ConsultaPessoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConsultaPessoa() {
		pessoaService = new PessoaService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 30, 367, 180);
		contentPane.add(scrollPane);
		
		
		String[] tblHead={"ID","Nome","Sobrenome","Cafe 1", "Cafe 2", "Sala 1", "Sala 2"};
		DefaultTableModel model = new DefaultTableModel(tblHead, 0);
		List<Pessoa> pessoas = null;
		try {			
			pessoas = pessoaService.getAllPessoas();
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
		}		
		for (Pessoa pessoa : pessoas) {
			String[] row = {String.valueOf(pessoa.getId()), pessoa.getNome(), pessoa.getSobrenome(), String.valueOf(pessoa.getCafe1().getNome()), String.valueOf(pessoa.getCafe2().getNome()), String.valueOf(pessoa.getSala1().getNome()),String.valueOf(pessoa.getSala2().getNome())};		
			model.addRow(row);
		}		
		tableListPessoa = new JTable();
		tableListPessoa.setModel(model);
		
		tableListPessoa.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tableListPessoa);
		tableListPessoa.setToolTipText("");
		
		JButton mostrarPessoa = new JButton("Informação da pessoa");
		mostrarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		mostrarPessoa.setBounds(142, 227, 145, 23);
		contentPane.add(mostrarPessoa);
		
		lblNewLabel = new JLabel("Lista pessoas");
		lblNewLabel.setBounds(30, 11, 85, 14);
		contentPane.add(lblNewLabel);
	}
}
