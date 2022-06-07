<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int n = Integer.parseInt(request.getParameter("num"));
		int sum = 0;
		for(int i=1;i<=n;i++){
			sum += i;
			if(i==n){
				out.print(i + "=" + sum);
			}else{
				out.print(i + "+");
			}
		}
	%>
</body>
</html>