<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'top.jsp' starting page</title>
	</head>

	<body>
		<table width="100%" height="100%" border="1">
			<tr>
				<td>
					<s:a action="init">首页</s:a>
				</td>
				<td>
					<s:a action="user_MyLibrary">我的图书馆</s:a>
				</td>
				<td>
					悦读专区
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td height="77" colspan="4">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td height="22" colspan="4">
					<div align="right">
						<s:a action="user_logout">注销</s:a>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
