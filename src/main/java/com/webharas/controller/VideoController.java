package com.webharas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webharas.model.Video;
import com.webharas.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/video")
@Api(value="API Video")
@CrossOrigin(origins = "*")
public class VideoController {

	@Autowired
	private VideoService videoservice;

	public VideoController(VideoService videoService){
		this.videoservice = videoService;		
	}

	@GetMapping()
	@ApiOperation(value="Lista de Video")
	public ResponseEntity<List<Video>> listarVideos(){
		List<Video> videos = videoservice.findAll();
		return ResponseEntity.ok(videos);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Video")
	public ResponseEntity<Video> getVideo(@PathVariable(value="id") long id){
		Video video = videoservice.FindById(id);
		return ResponseEntity.ok(video);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Salvar Video")
	public ResponseEntity<String> saveVideo(@RequestBody Video video){
		videoservice.save(video);
		return ResponseEntity.ok("Video Salvo com Sucesso");		
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value= "Alterar Video")
	public ResponseEntity<String> updateVideo(@RequestBody Video video, @PathVariable(value="id") long id){
		videoservice.update(id, video);
		return ResponseEntity.ok("Video Atualizado com Sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar Video")
	public ResponseEntity<String> deleteVideo(@PathVariable(value="id") long id){
		videoservice.delete(id);
		return ResponseEntity.ok("Video Deletado com Sucesso");
	}
	
}
