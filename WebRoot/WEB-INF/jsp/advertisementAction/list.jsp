<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
	    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/forum.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
	</head>
	<body>
	
	<table>
			<tr>
				<th>
					链接地址
				</th>
				<th>
					图片保存地址
				</th>
				<th>
					图片预览
				</th>
				<th>
					操作
				</th>
			</tr>
			<s:iterator value="#advertisementList">
				<tr>
					<td>
						<s:property value="url" />
					</td>
					<td>
						<s:property value="picUrl" />
					</td>
					<td>
						<img src="uploadImage/<s:property value="imageName"/>" height="100" width="100"/>
					</td>
					<td>
						<s:a action="advertisement_delete?id=%{id}">删除</s:a>
						<s:a action="advertisement_updateUI?id=%{id}">修改</s:a>
						<s:a action="advertisement_up?id=%{id}" >上移</s:a>
						<s:a action="advertisement_down?id=%{id}">下移</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<s:a action="advertisement_addUI">添加</s:a>
		<!-- 分页信息 -->
		<%@include file="/WEB-INF/jsp/public/split.jspf" %>
		<script type="text/javascript">
			function gotoPageNum(currentPage){
				window.location.href="advertisement_list.action?currentPage="+currentPage;
			}
		</script>
	
	
	
	</body>
</html>
