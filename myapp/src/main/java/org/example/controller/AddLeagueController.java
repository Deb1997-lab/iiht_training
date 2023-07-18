package org.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.model.League;

public class AddLeagueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processesRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processesRequest(request, response);
	}

	protected void processesRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		int year = 0;
		String season = null;
		String title = null;
		List<String> errors = new ArrayList<String>();

		season = request.getParameter("season");
		if (season.equals("Unknown")) {
			errors.add("please select a season.");

		}
		title=request.getParameter("title");
		if(title.length()<=0)
		{
			errors.add("title field can not be blank.");
		}
		
		try {
			year=Integer.parseInt(request.getParameter("year"));
			if(year<2023)
			{
				errors.add("year must be present year(2023)");
			}
			
		} catch (NumberFormatException e) {
		    errors.add("year field must be numeric.");
		} catch (Exception e) {
		    e.printStackTrace();
		    errors.add("an error occurred while processing the year field.");
		}
		
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("add_league.jsp");
			view.forward(request, response);
		}
		
		else
		{
			request.setAttribute("LEAGUE", new League(year, season, title));
			RequestDispatcher view=request.getRequestDispatcher("success.jsp");
			view.forward(request, response);
		}

	}
}