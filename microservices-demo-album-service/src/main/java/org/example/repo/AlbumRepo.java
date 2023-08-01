package org.example.repo;

import java.util.List;

import org.example.dto.AlbumDto;
import org.example.model.AlbumEntity;

public interface AlbumRepo {
	
	void addAlbum(AlbumDto albumDto);
	
	List<AlbumEntity> showAlbums();
	
	AlbumEntity findById(String albumId);
	
	AlbumEntity updateById(String albumId, AlbumDto albumDto);
	
	String deleteById(String albumId);
	
	
	
}
