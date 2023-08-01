package org.example.encrypt;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Encryption {
	private String password;
	
	public String encrypt() {
		StringBuffer sb = new StringBuffer();
		sb.append(password);
		return sb.reverse().toString();
	}
	
}
