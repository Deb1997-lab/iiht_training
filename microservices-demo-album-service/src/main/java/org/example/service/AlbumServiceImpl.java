package org.example.service;

import java.util.List;

import org.example.dto.AlbumDto;
import org.example.model.AlbumEntity;
import org.example.repo.AlbumRepo;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {
	
	private final AlbumRepo albumRepo;
	
	@Override
	public void addAlbum(AlbumDto albumDto) {
		// TODO Auto-generated method stub
		albumRepo.addAlbum(albumDto);
	}

	@Override
	public List<AlbumEntity> showAlbums() {
		// TODO Auto-generated method stub
		return albumRepo.showAlbums();
	}

	@Override
	public AlbumEntity findById(String albumId) {
		// TODO Auto-generated method stub
		return albumRepo.findById(albumId);
	}

	@Override
	public AlbumEntity updateById(String albumId, AlbumDto albumDto) {
		// TODO Auto-generated method stub
		return albumRepo.updateById(albumId, albumDto);
	}

	@Override
	public String deleteById(String albumId) {
		// TODO Auto-generated method stub
		return albumRepo.deleteById(albumId);
	}

}
