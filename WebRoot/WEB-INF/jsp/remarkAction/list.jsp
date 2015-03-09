<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>My JSP 'list.jsp' starting page</title>
	</head>
	<body>
			<table width="681" height="155" border="1">
				  <tr>
				    <td>回留言：<s:property value="content"/></td>
				  </tr>
				  <s:iterator value="#messRemarkList" >
					  <tr>
					  	<td><s:property value="content"/></td>
					    <td> 赞同 [1]楼 发表时间:[<s:property value="publishTime"/>]</td>
		 			 </tr>
	 			 </s:iterator>
			</table>	
			<s:a action="remark_addUI?id=%{id}">添加</s:a>
	</body>
</html>
