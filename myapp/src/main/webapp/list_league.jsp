<%@page import="javax.persistence.TypedQuery"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.example.entity.LeagueEntity"%>
<%@page import="org.example.model.League"%>
<%@page import="org.example.factory.MyHibernateSessionFactory"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Duke’s Soccer League: List Leagues</title>
</head>
<%
List<LeagueEntity> leagueList = null;
try{
	Session hib_session = MyHibernateSessionFactory.getHibernateSession();
	TypedQuery<LeagueEntity> query= hib_session.createQuery(" FROM LeagueEntity L",LeagueEntity.class);
	leagueList=query.getResultList();
}catch(Exception e){
	e.printStackTrace();
}

%>
<body bgcolor="white">

    <!-- Page Heading -->
    <table border="1" cellpadding="5" cellspacing="0" width="400">
        <tr bgcolor="#CCCCFF" align="center" valign="center" height="20">
            <td><h3>Duke’s Soccer League: List Leagues</h3></td>
        </tr>
    </table>

    <p>
        The set of soccer leagues are:
    </p>

    <ul>
        <% 
        if (leagueList != null) {
            for (LeagueEntity league : leagueList) {
        %>
        <li><%= league.getTitle() %></li>
        <% 
            }
        }
        %>
    </ul>
    
    <br/><br/>
    <a href="index.jsp">Home</a>
</body>
</html>