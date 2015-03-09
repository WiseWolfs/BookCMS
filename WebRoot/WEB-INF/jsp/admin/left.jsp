<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'left.jsp' starting page</title>


	</head>

	<body>
		<table width="200" border="1">
			<tr>
				<td>
					<strong>书籍管理</strong>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						免费书籍
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						交换书籍
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						捐赠书籍
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						电子书籍
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						试题
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<strong>系统管理</strong>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						<a href="user_list.action" target="rightFrame">用户管理</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						爱心榜管理
					</div>
				</td>
			</tr>
			<tr>
				<td>
				<div align="center">
						<a href="advertisement_list.action" target="rightFrame">广告管理</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<strong>新闻管理</strong>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						<a href="news_list.action?type=0" target="rightFrame">公告管理</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						<a href="news_list.action?type=1" target="rightFrame">业界动态</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<strong>悦读专区</strong>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						<a href="article_list.action" target="rightFrame">文章管理</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<strong>捐赠管理</strong>
				</td>
			</tr>
			<tr>
				<td>
					<strong><a href="role_list.action" target="rightFrame">角色管理</a></strong>
				</td>
			</tr>
			<tr>
				<td>
					<strong><a href="message_list.action" target="rightFrame">留言管理</a></strong>
				</td>
			</tr>
			<tr>
				<td>
					<strong>频道管理</strong>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						<a href="channel_list.action?type=0" target="rightFrame">免费专区</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						<a href="channel_list.action?type=1" target="rightFrame">交换专区</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						<a href="channel_list.action?type=2" target="rightFrame">爱心捐赠</a>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
