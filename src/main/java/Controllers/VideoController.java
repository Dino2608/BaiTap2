package Controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import Entity.*;
import dao.ICategoryDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import services.CategoryService;
import services.ICategoryService;
import services.IVideoService;
import services.VideoService;
import utils.Constant;

@MultipartConfig
@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/edit", "/admin/video/update",
		"/admin/video/insert", "/admin/video/add", "/admin/video/delete" })
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IVideoService videoService = new VideoService();
	ICategoryService categoryService = new CategoryService();

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("videos")) {
			List<Video> list = videoService.findAll();
			req.setAttribute("listvideo", list);
			req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
		} else if (url.contains("/admin/video/edit")) {
			String videoid = req.getParameter("videoid");
			Video video = videoService.findById(videoid);
			req.setAttribute("video", video);
			req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
		}
		else if (url.contains("/admin/video/add")) {
			req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
		} else if (url.contains("/admin/video/delete")) {
			String id = req.getParameter("videoid");
			try {
				videoService.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
		}
	}

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();

		if (url.contains("/admin/video/update")) {
			String videoid = req.getParameter("videoid");
			int active = Integer.parseInt(req.getParameter("actives"));
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			int views = Integer.parseInt(req.getParameter("views"));
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));

			Video video = new Video();

			video.setVideoId(videoid);
			video.setActive(active);
			video.setTitle(title);
			video.setDescription(description);
			video.setViews(views);
			video.setCategory(categoryService.findById(categoryid));
			// lưu hình cũ
			Video vidold = videoService.findById(videoid);
			String fileold = vidold.getPoster();
			// xử lý images
			String fname = "";
			String fname2 = "";
			String uploadPath = Constant.UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("poster");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// đổi tên file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// up load file
					part.write(uploadPath + "/" + fname);
					// ghi tên file vào data
					video.setPoster(fname);
				} else {
					video.setPoster(fileold);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Part part = req.getPart("videoid1");
				if (part.getSize() > 0) {
					String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = fileName.lastIndexOf(".");
					String ext = fileName.substring(index + 1);
					fname2 = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname2);
					video.setVideoId(fname2);
				} else if (videoid != null) {
					video.setVideoId(videoid);
				} else {
					video.setVideoId("thumbnail.mp4");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			videoService.update(video);

			resp.sendRedirect(req.getContextPath() + "/admin/videos");

		} else if (url.contains("/admin/video/insert")) {
			Video video = new Video();

			String videoid = req.getParameter("videoid");
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			int active = Integer.parseInt(req.getParameter("actives"));
			int views = Integer.parseInt(req.getParameter("views"));
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));

			video.setVideoId(videoid);
			video.setTitle(title);
			video.setDescription(description);
			video.setActive(active);
			video.setViews(views);
			video.setCategory(categoryService.findById(categoryid));

			String fname = "";
			String fname2 = "";

			String uploadPath = Constant.UPLOAD_DIRECTORY;

			File uploadDir = new File(uploadPath);

			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("poster");
				if (part.getSize() > 0) {
					String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = fileName.lastIndexOf(".");
					String ext = fileName.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname);
					video.setPoster(fname);
				} else {
					video.setPoster("avatar.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Part part = req.getPart("videoid1");
				if (part.getSize() > 0) {
					String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = fileName.lastIndexOf(".");
					String ext = fileName.substring(index + 1);
					fname2 = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname2);
					video.setVideoId(fname2);
				} else if (videoid != null) {
					video.setVideoId(videoid);
				} else {
					video.setVideoId("thumbnail.mp4");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			videoService.insert(video);
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
		}
	}
}
