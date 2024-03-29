package cn.gamechanger.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.*;
import cn.gamechanger.model.dao.*;

@WebServlet("/upload-immagini")
@MultipartConfig
public class UploadImmaginiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "C:/Users/Isidoro/git/GameChangerRep/GameChanger/WebContent/imgs/prodotti";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    Collection<Part> parts = request.getParts();
	    Iterator<Part> iterator = parts.iterator();
	    String nomeIniziale = null;
	    ProdottoDao pDao = null;
	    try {
	        pDao = new ProdottoDao(DbCon.getConnection());
	        Prodotto ultimoProdotto = pDao.getUltimoProdotto();
	        nomeIniziale = ultimoProdotto.getNome();
	        System.out.println("Nome iniziale ottenuto dal database: " + nomeIniziale); // Aggiungi questa riga per il debug
	        System.out.println(nomeIniziale);
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    int imageNumber = 1;

	    while (iterator.hasNext() && imageNumber <= 3) {
	        Part part = iterator.next();
	        String fileExtension = getFileExtension(part.getSubmittedFileName());
	        String destinationFileName = nomeIniziale + " " + imageNumber + fileExtension;
	        String destinationPath = UPLOAD_DIRECTORY + File.separator + destinationFileName;
	        
	        System.out.println(destinationFileName);
	        System.out.println(destinationPath);

	        // Assicurati che la cartella di destinazione esista
	        File destinationDir = new File(UPLOAD_DIRECTORY);
	        if (!destinationDir.exists()) {
	            destinationDir.mkdirs();
	        }

	        // Copia il file nella cartella di destinazione
	        File destinationFile = new File(destinationPath);
	        FileUtils.copyInputStreamToFile(part.getInputStream(), destinationFile);

	        imageNumber++;
	    }

	    request.getRequestDispatcher("prodottoAggiunto.jsp").forward(request, response);
	}

    // Metodo per ottenere l'estensione del file da un nome di file completo
    private String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf(".");
        if (lastIndex != -1) {
            return fileName.substring(lastIndex);
        }
        return "";
    }
}
