<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'forward.jsp' starting page</title>
    <script>
    	function forward(){
        	document.getElementById("init").submit();
        	}
    
    </script>
  </head>
  <body onload="forward()">
  	<form action="init.action" id="init"></form>
  </body>
</html>
