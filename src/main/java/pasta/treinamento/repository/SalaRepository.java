package pasta.treinamento.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pasta.treinamento.model.Sala;

public class SalaRepository {
	
	String querySala = "from Sala s";
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyBD");
	EntityManager em = emf.createEntityManager();
	
	// buscar por ID
	public Sala salaPorId(int id) {
		em.getTransaction().begin();
		
		Sala sala = em.find(Sala.class, id);
		
		em.getTransaction().commit();
		emf.close();
		
		return sala;
	}
	
	// salvar e atualizar sala
	public void salvarSala(Sala sala) {
		em.getTransaction().begin();
		
		em.merge(sala);
		
		em.getTransaction().commit();
		emf.close();
	}
	
	//listar todas as salas
		public List<Sala> listarSala() {
			em.getTransaction().begin();
			
			TypedQuery<Sala> typedQuery = em.createQuery(querySala,Sala.class);
			List<Sala> sala = typedQuery.getResultList();		
			
			em.getTransaction().commit();
			emf.close();
			
			return sala;	
		}
}