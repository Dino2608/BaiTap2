package dao;

import java.util.List;

import Entity.Category;
import Entity.Video;

public interface IVideoDao {
	int count();

	List<Video> findAll(int page, int pagesize);

	List<Video> findByTitle(String title);

	List<Video> findAll();

	Video findById(String videoid);

	void delete(String videoid) throws Exception;

	void update(Video video);

	void insert(Video video);
}
