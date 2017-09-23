<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="movieHistoryList" 
    type="net.cineplex.webmodel.MovieHistoryList"
    scope="session">
</jsp:useBean>


<jsp:useBean id="movieVO" 
   	class="net.cineplex.webmodel.MovieHistoryVO"
    scope="page">
</jsp:useBean>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>影院在线-观影历史</title>
	<%@ include file="import.jsp" %>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<br/>
	<div class="am-g">
  		<div class="am-u-lg-6 am-u-md-7 am-u-sm-centered" >
  			<br/>
  			<br/>
  			<table class="am-table am-table-striped am-table-hover">
			              <thead>
			                  <tr>
			                      <th>&nbsp;&nbsp;日期</th>
			                      <th>影片</th>
			                  </tr>
			              </thead>
			              <tbody>
			              <%  int j=movieHistoryList.getSize();
			              	  
			              	  for(int i=0;i<j;i++){ 
			            	  pageContext.setAttribute("movieVO",movieHistoryList.getItem(i));
			              		%>
			                  <tr>
			                      <td>&nbsp;&nbsp;<jsp:getProperty name="movieVO" property="day" /></td>
			                      <td><jsp:getProperty name="movieVO" property="movie" /></td>
			                      
			                  </tr>
			              <%} %>
			                  
			              </tbody>
			          </table>
  		
  		</div>
  		<br/><br/><br/><br/><br/><br/><br/>
  		<br/><br/><br/><br/><br/><br/><br/>
   		<%@ include file="../footer.jsp" %>
  	</div>
</body>
</html>