package es.upm.dit.isst.tfg;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.*;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.dit.upm.isst.tfg.dao.TFGDAO;
import es.dit.upm.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

public class UploadMemoriaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		TFGDAO dao = TFGDAOImpl.getInstance();
		

	
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKey = blobs.get("file");
	
	
	if (blobKey == null || blobKey.isEmpty() || blobKey.get(0) == null) {
		res.sendError(1200);
	}
	
	TFG tfg2=dao.create("javi", "jaja", "jaja", "jaja", "jaja", "jaja", 2);
	System.out.print(blobKey);
	tfg2.setMemoria(blobKey.get(0).getKeyString());
	tfg2.setEstado(3);
	dao.update(tfg2);
	
	res.sendRedirect("/serveMemoria?blob-key=" + blobKey.get(0).getKeyString());

}
}

