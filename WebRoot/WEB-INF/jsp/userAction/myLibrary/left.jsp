<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
	</head>
	<body>
		<table width="233" height="450" border="1">
			<tr>
				<td width="195">
					<div align="center">
						<s:a action="user_MyLibrary">我的图书馆</s:a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<table width="216" height="367" border="1">
						<tr>
							<td width="206">
								<div align="center">
									<s:a action="user_show?id=%{id}">用户资料</s:a>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="center">
									密码修改
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="center">
									免费专区
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="center">
									交换管理
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="center">
									爱心捐赠
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="center">
									留言吧
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="center">
									悦读专区
								</div>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
						</tr>
						<tr>
							<td height="38">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
