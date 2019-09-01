<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>LOGIN</title>
</head>
<body>
<s:property value="LoginDTOList.get(0).username"/>さん、ようこそ!
<br>
<table>
<tbody>
<tr>
	<th>USERNAME</th>
	<th>PASSWORD</th>
</tr>
<s:iterator value="loginDTOList">
<tr>
	<td><s:property value="username"/></td>
	<td><s:property value="password"/></td>
</tr>
</s:iterator>
</tbody>
</table>
</body>
</html>