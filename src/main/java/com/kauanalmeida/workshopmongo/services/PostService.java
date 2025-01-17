package com.kauanalmeida.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kauanalmeida.workshopmongo.domain.Post;
import com.kauanalmeida.workshopmongo.repository.PostRepository;
import com.kauanalmeida.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id){
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
