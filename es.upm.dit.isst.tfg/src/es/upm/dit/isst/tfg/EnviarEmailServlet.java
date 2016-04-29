package es.upm.dit.isst.tfg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.*;

import com.google.appengine.api.mail.MailService.Message;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.dit.upm.isst.tfg.dao.TFGDAO;
import es.dit.upm.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

public class EnviarEmailServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req,  HttpServletResponse resp) throws IOException {
    	
    	TFGDAO dao = TFGDAOImpl.getInstance();
    	
		UserService userService = UserServiceFactory.getUserService();
		String user = req.getUserPrincipal().getName();
		
		String tutoremail = req.getSession().getAttribute("tutor").toString();
		String alumno = req.getSession().getAttribute("autor").toString();
		
		String titulo = req.getSession().getAttribute("titulo").toString();
		String resumen = req.getSession().getAttribute("resumen").toString();
		String secretario = req.getSession().getAttribute("secretario").toString();
		String fichero = req.getSession().getAttribute("fichero").toString();
		
		
		
		dao.readAlumno(alumno);
		
		TFG tfg = dao.create(alumno, titulo, resumen, tutoremail, secretario, fichero, 2);
		dao.update(tfg);
			
    	
		try {
		MimeMessage message = new MimeMessage(Session.getDefaultInstance(new Properties(), null), req.getInputStream());
		String tutor = new InternetAddress(message.getFrom()[0].toString()).getAddress();
		String autor = message.getSubject();
		
       
			message.setFrom(new InternetAddress("tfg@isst-15-16-t4.appspotmail.com", "Sistema de gestion de TFG"));
			message.addRecipient(MimeMessage.RecipientType.TO,  new InternetAddress(autor, "Solicitante de TFG"));
	        message.setSubject("El profesor " + user + " acepta actuar como tutor del TFG");
	        message.setText("El profesor " + user + " acepta actuar como tutor del TFG propuesto por " + autor + " con titulo " + tfg.getTitulo());
	        
	        Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        resp.sendRedirect("/");

    }
        
}
