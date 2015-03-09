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
					简介
				</th>
				<th>
					图片保存地址
				</th>
				<th>
					图片预览
				</th>
				<th>
					区域类型
				</th>
				<th>
					操作
				</th>
			</tr>
						<s:property value="imageName"/>
			<s:iterator value="#channelList">
				<tr>
					<td>
						<s:property value="profile" />
					</td>
					<td>
						<s:property value="picUrl" />
					</td>
					<td>
						<img src="uploadImage/<s:property value="imageName"/>"	width="100" height="100"/>
					</td>
					<td>
						<s:if test="type == 0">
							购买专区
						</s:if>
						<s:elseif test="type == 1">
							交换专区
						</s:elseif>
						<s:elseif test="type == 2">
							爱心捐赠
						</s:elseif>
						<s:else>
							电子资源"
						</s:else>
					</td>
					<td>
						<s:a action="channel_delete?id=%{id}&type=%{type}">删除</s:a>
						<s:a action="channel_updateUI?id=%{id}&type=%{type}">修改</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<s:a action="channel_addUI?type=%{type}">添加</s:a>
	</body>
</html>
