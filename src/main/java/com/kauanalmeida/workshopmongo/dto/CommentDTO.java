package com.kauanalmeida.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private String id;
	private String texto;
	private Date data; 
	private AuthorDTO author;
	
	public CommentDTO() {}

	public CommentDTO(String id, String texto, Date data, AuthorDTO author) {
		super();
		this.id = id;
		this.texto = texto;
		this.data = data;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
