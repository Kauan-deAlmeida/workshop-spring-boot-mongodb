package com.kauanalmeida.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kauanalmeida.workshopmongo.domain.User;
import com.kauanalmeida.workshopmongo.dto.UserDTO;
import com.kauanalmeida.workshopmongo.repository.UserRepository;
import com.kauanalmeida.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id){
		User user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		return user;
	}
	
	public User insert(User user){
		return repo.save(user);
	}
	
	public void deleteById(String id){
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO userDTO){
		return new User(userDTO.getId(), userDTO.getNome(), userDTO.getEmail());
	}
}
