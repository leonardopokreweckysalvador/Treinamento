package pasta.treinamento.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pasta.treinamento.model.Cafe;

public class CafeRepository {

String queryCafe = "from Cafe c";
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyBD");
	EntityManager em = emf.createEntityManager();
	
	// buscar por ID
		public Cafe cafePorId(int id) {
			em.getTransaction().begin();
			
			Cafe cafe = em.find(Cafe.class, id);
			
			em.getTransaction().commit();
			emf.close();
			
			return cafe;
		}
		
		// salvar e atualizar cafe
		public void salvarCafe(Cafe cafe) {
			em.getTransaction().begin();
			
			em.merge(cafe);
			
			em.getTransaction().commit();
			emf.close();
		}
		
		//listar todas as cafés
		
		public List<Cafe> listarCafe() {
			em.getTransaction().begin();
			
			TypedQuery<Cafe> typedQuery = em.createQuery(queryCafe,Cafe.class);
			List<Cafe> cafe = typedQuery.getResultList();		
			
			em.getTransaction().commit();
			emf.close();
			
			return cafe;
			
		}
}