<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
  </head>
  <body>
    <%@include file="/jsp/indexAction/top.jsp" %>
    您当前位置>：留言板
    <table border="1" style="width:1080px;height:400px">
    	<s:iterator value="#messageList">
    		<tr>
    			<td>
    				<s:property value="%{content}"/>&nbsp;....................&nbsp;${publishTime}
    			</td>
    		</tr>
    	</s:iterator>
    </table>
    	<!-- 分页信息 -->
		<%@include file="/WEB-INF/jsp/public/split.jspf" %>
		<script type="text/javascript">
			function gotoPageNum(currentPage){
				window.location.href="message_more.action?currentPage="+currentPage;
			}
		</script>
    <%@include file="/jsp/indexAction/bottom.jsp" %>
  </body>
</html>
