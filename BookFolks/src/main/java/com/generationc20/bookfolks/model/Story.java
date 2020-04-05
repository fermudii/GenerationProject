package com.generationc20.bookfolks.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "story")
public class Story {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String synopsis;
	private String urlImage;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDateTime;
	
	//Foreign keys
	private int id_genre;
	private int id_textType;
	
	public Story() {}

	public Story(Integer id, String title, String synopsis, String urlImage, int id_genre, int id_textType, Date creationDateTime) {
		super();
		this.id = id;
		this.title = title;
		this.synopsis = synopsis;
		this.urlImage = urlImage;
		this.id_genre = id_genre;
		this.id_textType = id_textType;
		this.creationDateTime = creationDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public int getId_genre() {
		return id_genre;
	}

	public void setId_genre(int id_genre) {
		this.id_genre = id_genre;
	}

	public int getId_textType() {
		return id_textType;
	}

	public void setId_textType(int id_textType) {
		this.id_textType = id_textType;
	}
	
	public Date getCreacionDateTime() {
		return creationDateTime;
	}

	public void setCreacionDateTime(Date creacionDateTime) {
		this.creationDateTime = creacionDateTime;
	}

	
}
