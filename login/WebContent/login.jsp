<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--strutsタグ --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8">
	<title>ログイン画面</title>
</head>
<body>
	<s:from action="LoginAction">
		<s:textfield  name="name"/>
		<s:password name="password"/>
		<s:submit value="ログイン"/>
	</s:from>
</body>
</html>

<%--strutsタグとはStrutsフレームワークで使える専用のHTMLタグ。

<s:from action="LoginAction">
		<s:textfield  name="name"/>←「name=""」で指定した名前と同盟のActionクラスの変数に情報を渡す。
		<s:password name="password"/>
		<s:submit value="ログイン"/>
</s:from>
※情報が渡される前提として、Actionクラスで該当する変数のsetterの定義が必要--%>