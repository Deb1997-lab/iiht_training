package org.example.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlbumResponseUi {
	private String albumId;
	private String albumName;
	private String albumCompany;
	private double albumPrice;
}
