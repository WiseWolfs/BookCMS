<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>首页</title>
		<script language=javascript> 
			var curIndex=0; 
			//时间间隔 单位毫秒 
			var timeInterval=1000; 
			var arrPic=new Array(); 
			arrPic[0]="${advertisementList[0].imageName}"; 
			arrPic[1]="${advertisementList[1].imageName}"; 
			arrPic[2]="${advertisementList[2].imageName}"; 
			arrPic[3]="${advertisementList[3].imageName}"; 
			arrPic[4]="${advertisementList[4].imageName}"; 
			
			var arrHref = new Array();
			arrHref[0]="${advertisementList[0].url}";
			arrHref[1]="${advertisementList[1].url}";
			arrHref[2]="${advertisementList[2].url}";
			arrHref[3]="${advertisementList[3].url}";
			arrHref[4]="${advertisementList[4].url}";
	
			setInterval(changeImg,timeInterval); 
			function changeImg() 
			{ 
				var objPic=document.getElementById("showpic"); 
				var objHref=document.getElementById("showhref");
				if (curIndex==arrPic.length-1) 
				{ 
					curIndex=0; 
				} 
				else 
				{ 
					curIndex+=1; 
				} 
				objPic.src="uploadImage/"+arrPic[curIndex]; 
				objHref.href=arrHref[curIndex];
			}
		</script>

	</head>

	<body>
		<%@include file="top.jsp" %>
		
		<%@include file="center.jsp" %>
		
		<%@include file="bottom.jsp" %>
	</body>
</html>
