<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="100%" height="100%" bordercolor="Gray">

<tr align="center">		<!-- header -->
	<td height="10%" colspan="2">
		<tiles:insertAttribute name="header"/>
	</td>
</tr>

<tr>
	<td width="30%" align="left" valign="top">
		<tiles:insertAttribute name="side"/>
	</td>
	
	<td>	<!-- main -->
		<tiles:insertAttribute name="content"/>
	</td>	
</tr>

<tr>	<!-- footer -->
	<td height="10%" colspan="2">
		<tiles:insertAttribute name="footer"/>
	</td>
</tr>

</table>


</body>
</html>