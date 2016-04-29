package es.upm.dit.isst.tfg;
import java.awt.List;
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


public class NuevoTFGServlet extends HttpServlet {
	
		
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String titulo = req.getParameter("titulo").toString();
		String resumen = req.getParameter("resumen").toString();
		String autor = req.getParameter("autor").toString();
		String tutor = req.getParameter("tutor").toString();
		String secretario = req.getParameter("secretario").toString();
		String fichero = req.getParameter("fichero").toString();
		
		
		TFGDAO dao = TFGDAOImpl.getInstance();
		
		
		dao.create(autor, titulo, resumen, tutor,secretario, fichero, 2);
		resp.sendRedirect("/login");
		
		
		
		
		
	}

		
	
	

}
