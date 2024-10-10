package Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.Constant;

/**
 * Servlet implementation class DownloadFileController
 */
@WebServlet(urlPatterns = {"/image", "/video"})
public class DownloadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadFileController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("fname");
		File file = new File(Constant.UPLOAD_DIRECTORY + "/" + fileName);
		String urlString = request.getRequestURI();
		if (urlString.contains("/image")) {
			response.setContentType("image/jpeg");
			if (file.exists()) {
				IOUtils.copy(new FileInputStream(file), response.getOutputStream());
			}
		} else if (urlString.contains("/video")) {
			response.setContentType("video/mp4");
			if (file.exists()) {
				IOUtils.copy(new FileInputStream(file), response.getOutputStream());
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
