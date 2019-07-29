<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>TEST</title>
</head>
<body>
<p>こんにちは</p>
<%--コメント--%>

<%--スクリプトレット--%>
<% out.println(new java.util.Date()); %>
<%--JSPのタグでは記述できない処理をJavaコードで処理する場合に使用する --%>

<%--宣言文--%>
<%! int add(int a, int b){
		return a+b;
}%>
<%--変数、メソッドを宣言--%>

<%--式--%>
<p>1+2=<%=add(1,2) %></p>
<p>1+2=<%=add(3,4) %></p>
<%--Javaコードを記述し、その実行結果を表示する。voidのメソッドや変数の宣言のみを式に記述することは出来ない --%>

<%! int countA=0; %>
<% int countB=0;
	countA++;
	countB++;
%>

<p>宣言による変数 countA=<%=countA %></p>
<p>スクリプトレットによる変数 countB=<%=countB %></p>

<p><% out.println(Math.random()); %></p>
<p><%=Math.random() %></p>

<p>お名前を入力してくだい。</p>
<form method="post" action="greeting-out.jsp">
<input type="text" name="user">
<input type="submit" value="確定">
</form>

<form method="post" action="total-out.jsp">
<input type="text" name="price">
円x
<input type="text" name="count">
値+送料
<input type="text" name="delivery">
<input type="submit" value="計算">
</form>




</body>
</html>