package com.kauanalmeida.workshopmongo.resources;

import com.kauanalmeida.workshopmongo.domain.Post;
import com.kauanalmeida.workshopmongo.resources.util.URL;
import com.kauanalmeida.workshopmongo.services.PostService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostResources {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
    	return ResponseEntity.ok().body(service.findById(id));
    }
    
    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text){
    	text = URL.coadeParam(text);
    	List<Post> posts = service.findByTitle(text);	
    	return ResponseEntity.ok().body(posts);
    }
    
    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
    		@RequestParam(value="text", defaultValue="") String text,
    		@RequestParam(value="minData", defaultValue="") String minData,
    		@RequestParam(value="maxData", defaultValue="") String maxData){
    	text = URL.coadeParam(text);
    	Date min = URL.convertDate(minData, new Date(0L));
    	Date max = URL.convertDate(maxData, new Date());
    	List<Post> posts = service.fullSearch(text, min, max);
    	return ResponseEntity.ok().body(posts);
    }
}
