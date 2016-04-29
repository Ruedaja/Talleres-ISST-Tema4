package es.dit.upm.isst.tfg.dao;

import es.upm.dit.isst.tfg.model.TFG;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class TFGDAOImpl implements TFGDAO {

	private static TFGDAOImpl instance;
	
	
	private TFGDAOImpl(){
		
	}
	
	public static  TFGDAOImpl getInstance(){
		if(instance==null)
			instance = new TFGDAOImpl();
		return instance;
	}
	@Override
	public TFG create(String autor, String titulo, String resumen, String tutor, String secretario, String fichero, int estado) { 
				
		TFG tfg = null; 
		EntityManager em = EMFService.get().createEntityManager();
		tfg = new TFG (autor,titulo,resumen,tutor,secretario,fichero,estado);
		em.persist(tfg);
		
		em.close(); 
		return tfg; 
		} 

	@Override
	public void delete(String id) { 
			
			EntityManager em = EMFService.get().createEntityManager(); 
		try { 
			TFG todo = em.find(TFG.class, id); 
			em.remove(todo); 
		} finally { 
		em.close(); 
		} 
		} 
		
	@Override 
	public TFG update(TFG tfg) { 
			EntityManager em = EMFService.get().createEntityManager(); 
			TFG res = em.merge(tfg); 
			em.close(); 
		return res; 
		} 
		
	@Override 
	public List<TFG> read() { 
		EntityManager em = EMFService.get().createEntityManager(); 
		Query q = em.createQuery("select m from TFG m"); 
		List<TFG> res = q.getResultList(); 
				em.close(); 
		return res; 
		}

		@Override 
	public TFG readAlumno(String autor) {
			
			EntityManager em = EMFService.get().createEntityManager(); 
			Query q = em.createQuery("select t from TFG t where t.autor = :autor"); 
			q.setParameter("autor", autor); 
			TFG res =  null; 
			List<TFG> tfgs = q.getResultList();
			
			if (tfgs.size() > 0) 
				res = (TFG) (q.getResultList().get(0)); 
				em.close(); 
			return res; 
		}
		public List<TFG> readTutor(String tutor) { 
			EntityManager em = EMFService.get().createEntityManager(); 
			Query q = em.createQuery("select t from TFG t where t.tutor = :tutor"); 
			q.setParameter("tutor", tutor); 
			 
			List<TFG> tfgs = q.getResultList();
			em.close(); 
			return tfgs; 
			
		}
		
		public List<TFG> readEstado(int estado) { 
			EntityManager em = EMFService.get().createEntityManager(); 
			Query q = em.createQuery("select t from TFG t where t.tutor = :tutor"); 
			q.setParameter("estado", estado); 
			 
			List<TFG> tfgs = q.getResultList();
			em.close(); 
			return tfgs; 
			
		}
		
		

}
