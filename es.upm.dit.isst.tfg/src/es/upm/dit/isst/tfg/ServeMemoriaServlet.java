package es.upm.dit.isst.tfg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import es.dit.upm.isst.tfg.dao.TFGDAO;
import es.dit.upm.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

@SuppressWarnings("serial")


public class ServeMemoriaServlet extends HttpServlet {
	
	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
		
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
	BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
	blobstoreService.serve(blobKey, resp);
}
}
