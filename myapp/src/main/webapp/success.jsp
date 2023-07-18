<!DOCTYPE html>

<%@page import="org.hibernate.Session"%>
<%@page import="org.example.entity.LeagueEntity"%>
<%@page import="org.example.model.League"%>
<%@page import="org.example.factory.MyHibernateSessionFactory"%>
<html>

<head>
	<meta charset="UTF-8">
	<title>SUCCESS PAGE</title>
</head>

<body>
<% 	    League league = (League) request.getAttribute("LEAGUE");
		LeagueEntity entity=new LeagueEntity(league.getYear(), league.getSeason(), league.getTitle());
		try {
			
		
		Session my_sess = MyHibernateSessionFactory.getHibernateSession();
		my_sess.getTransaction().begin();
		my_sess.save(entity);
		my_sess.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		%>
		 <h2>League Added Successfully</h2>
    <hr>
    <br/>
    League year: <%= league.getYear()%><br/>
    League season: <%= league.getSeason() %><br/>
    League title: <%= league.getTitle() %><br/><br/>

    <a href="index.jsp">Home</a>
</body>
	
</html>