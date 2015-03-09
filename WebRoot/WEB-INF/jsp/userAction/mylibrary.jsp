<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<head>
	</head>
	<frameset rows="150,*,50">
		<frame src="library_top.action" />
		<frameset cols="250,*">
			<frame src="library_left.action" />
			<frame src="library_right.action" />
		</frameset>
		<frame src="library_bottom.action" />
	</frameset>
	<noframes></noframes>

</html>
