<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>My JSP 'list.jsp' starting page</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/forum.css" />
	</head>
	<body>
		<table width="586" border="1">
		  <tr>
		    <td width="59">留言内容</td>
		    <td width="59">留言时间</td>
		    <td width="45">赞同数</td>
		    <td width="152">不赞同数</td>
		    <td width="114">发表者</td>
		    <td width="117">操作</td>
		  </tr>
	<s:iterator value="#messageList">
		  <tr>
		    <td><s:a action="remark_list?id=%{id}"><s:property value="content"/></s:a></td>
		    <td><s:property value="publishTime"/></td>
		    <td><s:property value="agreeCount"/></td>
		    <td><s:property value="disagreeCount"/></td>
		    <td><s:property value="user.name"/></td>
		    <td>
		    <s:property value="id"/>
		    <s:a action="message_delete?id=%{id}">删除</s:a>
		    <s:a action="message_updateUI?id=%{id}">修改</s:a>
		    
		    </td>
		  </tr>
	</s:iterator>
		</table>
		<!-- 分页信息-->
		<%@include file="/WEB-INF/jsp/public/split.jspf" %>
		<SCRIPT type="text/javascript">
			function gotoPageNum(var currentPage){
				window.location.href = "message_list.action?currentPage="+currentPage;

				}
		</SCRIPT>
	</body>
	<s:a action="message_addUI">添加</s:a>
	<s:property value="#session.user.name"/>
</html>
