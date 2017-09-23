<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影院在线-首页</title>
	<%@ include file="import.jsp" %>
</head>
<body>
		<%@ include file="header.jsp" %>
	 	<br/>
	 	<div class="am-g">
  			<div class="am-u-lg-10 am-u-md-10 am-u-sm-centered">
    			<%@ include file="log_panel.jsp" %>	
    			<br/>
    			<%@ include file="movie_display.jsp" %>
  			</div>
			<%@ include file="footer.jsp" %>
		</div>	 	
</body>
</html>