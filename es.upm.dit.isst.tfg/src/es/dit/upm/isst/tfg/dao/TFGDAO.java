package es.dit.upm.isst.tfg.dao;

import java.util.List;

import es.upm.dit.isst.tfg.model.*;

public interface TFGDAO {
		
	public TFG create(String autor, String titulo, String resumen, String tutor, String secretario, String fichero, int estado) ;
	
	public void delete(String id);

	public TFG update(TFG tfg);

	public List<TFG> read();

	public TFG readAlumno(String autor);
	
	public List<TFG> readTutor(String tutor);
	
	public List<TFG> readEstado(int estado);
	
}
