package org.example.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.example.dto.AlbumDto;
import org.example.exception.AlbumNotFoundException;
import org.example.model.AlbumEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@EnableTransactionManagement
@Repository
@AllArgsConstructor
public class AlbumRepoImpl implements AlbumRepo {
	
	@Autowired
	private final EntityManager entityManager;
	private final ModelMapper modelMapper;
	
	@Transactional
	@Override
	public void addAlbum(AlbumDto albumDto) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AlbumEntity albumEntity = modelMapper.map(albumDto, AlbumEntity.class);
		
		entityManager.persist(albumEntity);
	}
	
	@Transactional
	@Override
	public List<AlbumEntity> showAlbums() {
		// TODO Auto-generated method stub
		TypedQuery<AlbumEntity> query = entityManager.createQuery("FROM AlbumEntity A", AlbumEntity.class);
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public AlbumEntity findById(String albumId) {
		// TODO Auto-generated method stub
		AlbumEntity album = null;
		try {
		TypedQuery<AlbumEntity> query = (TypedQuery<AlbumEntity>) entityManager.createQuery("SELECT a FROM AlbumEntity a WHERE a.albumId = :albumId");
		query.setParameter("albumId", albumId);
		album = query.getSingleResult();
		}catch(Exception e) {
			throw new AlbumNotFoundException("Album with ID: "+albumId+" not found");
		}
		
			return album;
		
		
	}
	
	@Transactional
	@Override
	public AlbumEntity updateById(String albumId, AlbumDto albumDto) {
		// TODO Auto-generated method stub
		AlbumEntity album = entityManager.find(AlbumEntity.class, albumId);
		if(album==null) {
			throw new AlbumNotFoundException("Album with ID: "+albumId+" not found");
		}else {
			album.setAlbumName(albumDto.getAlbumName());
			album.setAlbumCompany(albumDto.getAlbumCompany());
			album.setAlbumPrice(albumDto.getAlbumPrice());
			entityManager.merge(album);
			return album;
		}
		
	}
	
	@Transactional
	@Override
	public String deleteById(String albumId) {
		// TODO Auto-generated method stub
		AlbumEntity album = entityManager.find(AlbumEntity.class, albumId);
		if(album==null) {
			throw new AlbumNotFoundException("Album with ID: "+albumId+" not found");
		}else {
			entityManager.remove(album);
			return ("Album with ID: "+albumId+" has been deleted");
		}
		
	}

}
