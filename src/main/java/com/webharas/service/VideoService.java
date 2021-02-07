package com.webharas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webharas.model.Video;
import com.webharas.repository.VideoRepository;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository videoRepository;
	
	public List<Video> FindAll(){
		return videoRepository.findAll();
	}
	
	public Video FindById(long id){
		return videoRepository.FindById(id);
	}
	
	public Video save(Video video) {
		return videoRepository.save(video);		
	}
	
	
	public Video update(long id, Video video) {
		video.setId(id);
		return videoRepository.save(video);
	}
	
	
	public void delete(long id) {
		videoRepository.deleteById(id);
		return;
	}
	

}
