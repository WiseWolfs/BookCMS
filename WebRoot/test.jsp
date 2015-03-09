<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript">
		function test(){
			var testName = "${userName}";
	    	alert("testName:"+testName);
		}
		
    
    </script>
    <title>My JSP 'test.jsp' starting page</title>
  </head>
  
  <body>

<a onclick="test()" href="#">test!</a>
  </body>
</html>
