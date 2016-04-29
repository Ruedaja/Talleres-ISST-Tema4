package es.upm.dit.isst.tfg;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.dit.upm.isst.tfg.dao.TFGDAO;
import es.dit.upm.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

@SuppressWarnings("serial")
public class Es_upm_dit_isst_tfgServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Listado de TFGs");
		
		TFGDAO dao = TFGDAOImpl.getInstance();
		dao.create("Javier", "titulo","resumen" , "tutor", "Secretario", "fichero", 0);
		dao.create("Rueda", "titulo2","resumen2" , "tutor2", "Secretario2", "fichero2", 0);
		dao.create("Perez", "titulo3","resumen3" , "tutor3", "Secretario3", "fichero3", 0);
		
		for (TFG tfg : dao.read()) {
			resp.getWriter().println("Autor: "+ tfg.getAutor()+ "Titulo: "+ tfg.getTitulo());
		}
		
		
		
	    

       
            
	}
	
}
