package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.webharas.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
	
	Video FindById(long id);

}
