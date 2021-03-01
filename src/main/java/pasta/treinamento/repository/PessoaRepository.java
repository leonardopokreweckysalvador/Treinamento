package pasta.treinamento.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import pasta.treinamento.model.Pessoa;

public class PessoaRepository {

String queryPessoa = "from Pessoa";
String queryPessoaCafe1 = "select * From Pessoa p where cafe1_id = :idCafe";
String queryPessoaCafe2 = "select * From Pessoa p where cafe2_id = :idCafe";
String queryPessoaSala1 = "select * From Pessoa p where cafe1_id = :idCafe";
String queryPessoaSala2 = "select * From Pessoa p where cafe2_id = :idCafe";
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyBD");
	EntityManager em = emf.createEntityManager();
	
	// buscar por ID
	public Pessoa pessoaPorId(int id) {
		em.getTransaction().begin();
		
		Pessoa pessoa = em.find(Pessoa.class, id);
		
		em.getTransaction().commit();
		emf.close();
		
		return pessoa;
	}
	
	// salvar e atualizar pessoa
	public void salvarPessoa(Pessoa pessoa) {
		em.getTransaction().begin();
		
		em.merge(pessoa);
		
		em.getTransaction().commit();
		emf.close();
	}
	
	//listar todas as pessoas
	public List<Pessoa> listarPessoa() {
		
		List<Pessoa> pessoa = null;
		em.getTransaction().begin();
		try {
			TypedQuery<Pessoa> typedQuery = em.createQuery(queryPessoa,Pessoa.class);
			pessoa = typedQuery.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}finally {
			emf.close();
		}
		
		return pessoa;
	}	
	
public List<Pessoa> listarPessoaCafe(int idCafe) {
		
		List<Pessoa> pessoa = null;
		em.getTransaction().begin();
		try {
			TypedQuery<Pessoa> typedQuery = em.createQuery(queryPessoaCafe1,Pessoa.class)
					.setParameter("idCafe", idCafe);
			
			pessoa = typedQuery.getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
			
		}finally {
			
			emf.close();
		}
		
		return pessoa;
	}	
}