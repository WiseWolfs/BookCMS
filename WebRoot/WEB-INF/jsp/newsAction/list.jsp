<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>My JSP 'list.jsp' starting page</title>
	</head>
	<body>
		<table>
			<tr>
				<th>
					新闻标题
				</th>
				<th>
					操作
				</th>
			</tr>
			<s:iterator value="#newsList">
				<tr>
					<td>
						<s:property value="title" />
					</td>
					<td>
						<s:a action="news_delete?id=%{id}&type=%{type}">删除</s:a>
						<s:a action="news_updateUI?id=%{id}&type=%{type}">修改</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<s:a action="news_addUI?type=%{type}">添加</s:a>
	</body>
</html>
