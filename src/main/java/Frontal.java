import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.treinamento.view.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frontal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frontal frame = new Frontal();
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
	public Frontal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastroCafe = new JButton("Cadastro de café");
		btnCadastroCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCafe cadastroCafe = new CadastroCafe();
				cadastroCafe.setVisible(true);
			}
		});
		btnCadastroCafe.setBounds(31, 27, 152, 23);
		contentPane.add(btnCadastroCafe);
		
		JButton btnCadastroSala = new JButton("Cadastro de sala");
		btnCadastroSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroSala cadastroSala = new CadastroSala();
				cadastroSala.setVisible(true);
			}
		});
		btnCadastroSala.setBounds(31, 61, 152, 23);
		contentPane.add(btnCadastroSala);
		
		JButton btnCadastroPessoa = new JButton("Cadastro de pessoa");
		btnCadastroPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPessoa cadastroPessoa = new CadastroPessoa();
				cadastroPessoa.setVisible(true);
			}
		});
		btnCadastroPessoa.setBounds(31, 95, 152, 23);
		contentPane.add(btnCadastroPessoa);
		
		JButton btnConsultaCafe = new JButton("Consultar café");
		btnConsultaCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCafe consulaCafe = new ConsultaCafe();
				consulaCafe.setVisible(true);
			}
		});
		btnConsultaCafe.setBounds(31, 129, 152, 23);
		contentPane.add(btnConsultaCafe);
		
		JButton btnConsultaSala = new JButton("Consultar sala");
		btnConsultaSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaSala consultaSala = new ConsultaSala();
				consultaSala.setVisible(true);
			}
		});
		btnConsultaSala.setBounds(31, 163, 152, 23);
		contentPane.add(btnConsultaSala);
		
		JButton btnConsultaPessoa = new JButton("Consultar pessoa");
		btnConsultaPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaPessoa consultaPessoa = new ConsultaPessoa();
				consultaPessoa.setVisible(true);
			}
		});
		btnConsultaPessoa.setBounds(31, 197, 152, 23);
		contentPane.add(btnConsultaPessoa);
	}

}
