package Entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Video.class)
public abstract class Video_ {

	public static final String QUERY_VIDEO_FIND_ALL = "Video.findAll";
	public static final String ACTIVE = "active";
	public static final String DESCRIPTION = "description";
	public static final String VIDEO_ID = "videoId";
	public static final String TITLE = "title";
	public static final String CATEGORY = "category";
	public static final String POSTER = "poster";
	public static final String VIEWS = "views";

	
	/**
	 * @see Entity.Video#active
	 **/
	public static volatile SingularAttribute<Video, Integer> active;
	
	/**
	 * @see Entity.Video#description
	 **/
	public static volatile SingularAttribute<Video, String> description;
	
	/**
	 * @see Entity.Video#videoId
	 **/
	public static volatile SingularAttribute<Video, String> videoId;
	
	/**
	 * @see Entity.Video#title
	 **/
	public static volatile SingularAttribute<Video, String> title;
	
	/**
	 * @see Entity.Video#category
	 **/
	public static volatile SingularAttribute<Video, Category> category;
	
	/**
	 * @see Entity.Video
	 **/
	public static volatile EntityType<Video> class_;
	
	/**
	 * @see Entity.Video#poster
	 **/
	public static volatile SingularAttribute<Video, String> poster;
	
	/**
	 * @see Entity.Video#views
	 **/
	public static volatile SingularAttribute<Video, Integer> views;

}

