<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影院在线-电影</title>
		<%@ include file="import.jsp" %>
		<script type="text/javascript">
 			function buyTicket(planID){
 				var url="planSelect?plan="+planID;
 				window.open(url);
 			}
			function alertLog(){
				alert("请先登陆!!!");		
			}      
    	</script>
</head>
<body>

	<%@ include file="header.jsp" %>
	 	<br/>
	 	<div class="am-g">
  			<div class="am-u-lg-10 am-u-md-10 am-u-sm-centered">
  			
  					<%@ include file="navi.jsp" %>	
    			
  					<%@ include file="movie_info.jsp"  %>
  			
  			
  			</div>
  			<%@ include file="footer.jsp" %>
	   </div>
</body>
</html>