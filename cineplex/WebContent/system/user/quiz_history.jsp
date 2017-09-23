<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="quizHistoryList" 
    type="net.cineplex.webmodel.QuizHistoryList"
    scope="session">
</jsp:useBean>

<jsp:useBean id="quizVO" 
    class="net.cineplex.webmodel.QuizVO"
    scope="page">
</jsp:useBean>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>影院在线-活动历史</title>
	<%@ include file="import.jsp" %>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<br/>
	<div class="am-g">
  		<div class="am-u-lg-9 am-u-md-10 am-u-sm-centered" >
  			<br/>
  			<br/>
  			 <table class="am-table am-table-striped am-table-hover">
			              <thead>
			                  <tr>
			                      <th>&nbsp;&nbsp;影片</th>
			                      <th>问题&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			                      <th>获取积分</th>
			                  </tr>
			              </thead>
			              <tbody>
			                  <% int n=quizHistoryList.getSize();
			                  for(int i=0;i<n;i++){
			                	  pageContext.setAttribute("quizVO",quizHistoryList.getItem(i));
			                	  
			                	  %>
			                  
			                  <tr>
			                      <td>&nbsp;&nbsp;<jsp:getProperty name="quizVO" property="movie" /></td>
			                      <td><jsp:getProperty name="quizVO" property="question" /></td>
			                      <td><jsp:getProperty name="quizVO" property="result" /></td>
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