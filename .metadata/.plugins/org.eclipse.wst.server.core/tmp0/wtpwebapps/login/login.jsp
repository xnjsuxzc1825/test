<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--strutsタグ --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
</head>
<body>
	<s:form action="LoginAction">
		<s:textfield  name="name"/>
		<s:password name="password"/>
		<s:submit value="ログイン"/>
	</s:form>
</body>
</html>

<%--strutsタグとはStrutsフレームワークで使える専用のHTMLタグ。

<s:form action="LoginAction">
		<s:textfield  name="name"/>←「name=""」で指定した名前と同盟のActionクラスの変数に情報を渡す。
		<s:password name="password"/>
		<s:submit value="ログイン"/>
</s:form>
※情報が渡される前提として、Actionクラスで該当する変数のsetterの定義が必要--%>