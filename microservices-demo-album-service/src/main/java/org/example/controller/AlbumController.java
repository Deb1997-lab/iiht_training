package org.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.example.dto.AlbumDto;
import org.example.model.AlbumEntity;
import org.example.service.AlbumService;
import org.example.ui.AlbumRequestUi;
import org.example.ui.AlbumResponseUi;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/albums")
@AllArgsConstructor
public class AlbumController {
	
	private final AlbumService albumService;
	private final ModelMapper modelMapper;
	
	@PostMapping("/add")
	public ResponseEntity<AlbumResponseUi> addAlbum(@RequestBody AlbumRequestUi albumRequestUi){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AlbumDto albumDto = modelMapper.map(albumRequestUi, AlbumDto.class);
		albumDto.setAlbumId(UUID.randomUUID().toString());
		albumService.addAlbum(albumDto);
		AlbumResponseUi albumResponseUi = modelMapper.map(albumDto, AlbumResponseUi.class);
		return ResponseEntity.ok(albumResponseUi);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<AlbumResponseUi>> showAlbums(){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<AlbumEntity> albumList = albumService.showAlbums();
		List<AlbumResponseUi> uiList = new ArrayList<>();
		for(AlbumEntity a:albumList) {
			AlbumResponseUi tempAl = modelMapper.map(a, AlbumResponseUi.class);
			uiList.add(tempAl);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(uiList);
	}
	
	@GetMapping("/find/{albumId}")
	public ResponseEntity<?> findById(@PathVariable("albumId") String albumId){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AlbumEntity albumEntity = albumService.findById(albumId);
		AlbumResponseUi albumResponseUi = modelMapper.map(albumEntity, AlbumResponseUi.class);
		return ResponseEntity.status(HttpStatus.FOUND).body(albumResponseUi);
	}
	
	@PatchMapping("/update/{albumId}")
	public ResponseEntity<?> updateById(@PathVariable("albumId") String albumId, @RequestBody AlbumRequestUi albumRequestUi){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AlbumDto albumDto = modelMapper.map(albumRequestUi, AlbumDto.class);
		albumDto.setAlbumId(albumId);
		AlbumEntity albumEntity = albumService.updateById(albumId, albumDto);
		AlbumResponseUi albumResponseUi = modelMapper.map(albumEntity, AlbumResponseUi.class);
		return ResponseEntity.status(HttpStatus.OK).body(albumResponseUi);
		
	}
	
	@DeleteMapping("/delete/{albumId}")
	public ResponseEntity<String> deleteById(@PathVariable("albumId") String albumId){
		return ResponseEntity.ok(albumService.deleteById(albumId));
	}
}
