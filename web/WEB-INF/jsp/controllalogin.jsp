<%-- 
    Document   : controllalogin
    Created on : 1-giu-2016, 12.54.31
    Author     : FSEVERI\ramescu2755
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="config.HibernateUtil"%>
<%@page import="crud.CRUD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>controllaLogin</title>
    </head>
    <body>
        
        <%
            CRUD c = new CRUD(HibernateUtil.getSessionFactory());
            String nu=(String)request.getAttribute("nomeUtente");
            String p=(String)request.getAttribute("password");
            String pa=c.getPwdCliente(nu);
            
            if(pa!=null && pa.equals(p)){
                session.setAttribute("username",request.getAttribute("nomeUtente"));
                response.sendRedirect("./index");
            }else{
                response.sendRedirect("./?m=NomeUtenteoPasswordErrati!");
            }
        %>
        
    </body>
</html>
