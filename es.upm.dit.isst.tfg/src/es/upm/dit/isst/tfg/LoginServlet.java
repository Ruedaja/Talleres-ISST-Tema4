package es.upm.dit.isst.tfg;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.dit.upm.isst.tfg.dao.TFGDAO;
import es.dit.upm.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

public class LoginServlet extends HttpServlet {
	
		
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

	TFGDAO dao = TFGDAOImpl.getInstance();
	List<TFG> tfgs = dao.read();
    
    UserService userService = UserServiceFactory.getUserService();
	String url = userService.createLoginURL( req.getRequestURI());
	String urlLinktext = "Login" ;
	String user = "" ;
	if ( req.getUserPrincipal() != null ){
		user = req.getUserPrincipal().getName();
		url = userService.createLogoutURL( req.getRequestURI());
		urlLinktext = "Logout" ;
	}
	req.getSession().setAttribute( "user" , user );
	req.getSession().setAttribute( "url" , url );
	req.getSession().setAttribute( "urlLinktext" , urlLinktext );
	req.getSession().setAttribute( "tfgs" , new ArrayList<TFG>( tfgs ));
	
	
	
    RequestDispatcher view = req.getRequestDispatcher("MostrarTFG.jsp");
    view.forward(req, resp);

}
}
