package org.example.controller;
import org.springframework.ui.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.example.factory.JDBCConnect;
import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;


@Controller
public class HelloController {
	
	
	private JDBCConnect connect;
	
	@Autowired
	public HelloController(JDBCConnect connect) {
		super();
		this.connect = connect;
	}
	
	@GetMapping
	public String goHome() {
		return "home";
	}

	@GetMapping("/showForm")
	public String showForm() {
		return "showForm";
	}
	
	@Transactional
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestParam("t1") String ename, @RequestParam("t2") String eageStr, Model model) {
		
			
		
		String page = null;
		int eage = 0;
		List<String> err_list = new ArrayList<String>();
		if(ename.length()<=0) {
			err_list.add("Name field cannot be empty");
		}
		try {
			eage = Integer.parseInt(eageStr);
			if (eage<=18) {
				err_list.add("Age must be greater than 18 years");
			}
		}catch(Exception e) {
			err_list.add("Age field must not be empty or non-numeric");
		}
		try{
			PreparedStatement pst = connect.getConnection().prepareStatement("INSERT INTO employee(name,age) VALUES(?,?)");
			pst.setString(1,ename);
			pst.setInt(2,eage);
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(!err_list.isEmpty()) {
			model.addAttribute("err", err_list);
			page = "showForm";
		}else {
			model.addAttribute("emp", new Employee(ename,eage));
			page = "success";
		}
		
		
		
		return page;
	}

	
}