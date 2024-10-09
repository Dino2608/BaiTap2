package services;

import java.util.List;

import Entity.Category;
import Entity.Video;
import dao.VideoDao;

public class VideoService implements IVideoService{

	VideoDao viddao = new VideoDao();
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return viddao.count();
	}

	@Override
	public List<Video> findAll(int page, int pagesize) {
		// TODO Auto-generated method stub
		return viddao.findAll(page, pagesize);
	}

	@Override
	public List<Video> findByTitle(String title) {
		// TODO Auto-generated method stub
		return viddao.findByTitle(title);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return viddao.findAll();
	}

	@Override
	public Video findById(String videoid) {
		// TODO Auto-generated method stub
		return viddao.findById(videoid);
	}

	@Override
	public void delete(String videoid) throws Exception {
		// TODO Auto-generated method stub
		viddao.delete(videoid);
	}

	@Override
	public void update(Video video) {
		// TODO Auto-generated method stub
		viddao.update(video);
	}

	@Override
	public void insert(Video video) {
		// TODO Auto-generated method stub
		viddao.insert(video);
	}

}
