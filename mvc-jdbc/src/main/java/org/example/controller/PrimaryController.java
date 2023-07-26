package org.example.controller;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.example.factory.JDBCConnection;
import org.example.model.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrimaryController {
	
	private final JDBCConnection connection;
	
	@Autowired
	public PrimaryController(JDBCConnection connection) {
		super();
		this.connection = connection;
	}

	@GetMapping
	public String goHome() {
		return "index";
	}
	
	@GetMapping("/showForm")
	public String showForm() {
		return "showForm";
	}
	
	@GetMapping("/showList")
	public String showList() {
		return "showList";
	}
	
	
	@PostMapping("/addLeague")
	public String addLeague(@RequestParam("year") String yearStr, @RequestParam("season") String season, @RequestParam("title") String title, Model model) {
		String page = null;
		int year = 0;
		List<String> err_list = new ArrayList<>();
		try {
			year = Integer.parseInt(yearStr);
			if (year<=2023) {
				err_list.add("Year cannot be before 2023");
			}
		}catch(Exception e) {
			err_list.add("Year field cannot be empty");
		}
		if (season.equals("Unkown")) {
			err_list.add("Please select a season");
		}
		if (title.length()==0) {
			err_list.add("Title cannot be empty");
		}
		
		if(!err_list.isEmpty()) {
			page = "showForm";
			model.addAttribute("err",err_list);
		}else {
			try {
				PreparedStatement statement = connection.getConnection().prepareStatement("INSERT INTO league_table(title,season,year) VALUES(?,?,?)");
				statement.setString(1,title);
				statement.setString(2, season);
				statement.setInt(3, year);
				statement.executeUpdate();
				page = "success";
				model.addAttribute("league", new League(year,season,title));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return page;
	}
}
