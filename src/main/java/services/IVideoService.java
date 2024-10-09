package services;

import java.util.List;

import Entity.Category;
import Entity.Video;

public interface IVideoService {
	int count();

	List<Video> findAll(int page, int pagesize);

	List<Video> findByTitle(String title);

	List<Video> findAll();

	Video findById(String videoid);

	void delete(String id) throws Exception;

	void update(Video video);

	void insert(Video video);
}
