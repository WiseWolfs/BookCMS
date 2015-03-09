<%@ page language="java" import="java.util.*,com.njit.lib.domain.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
	  	<frameset rows="60,*,60" >
  			<frame src="home_top.action" ></frame>
					
  			<frameset cols="240,*">
  				<frame src="home_left.action" />
  				<frame src="home_right.action" name="rightFrame"/>
  			</frameset>
  			<frame src="home_bottom.action"></frame>
 		 </frameset>
</html>
