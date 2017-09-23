<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="seat" uri="/WEB-INF/tlds/seatSelect.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="choosePlan" 
    type="net.cineplex.webmodel.PlanVO"
    scope="session">
</jsp:useBean>

<jsp:useBean id="chooseSeat" 
    type="net.cineplex.webmodel.SeatList"
    scope="session">
</jsp:useBean>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影院在线-座位</title>
	<%@ include file="import.jsp" %>
  
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<br/>
	<div class="am-g">
    <div class="am-u-lg-10 am-u-md-10 am-u-sm-centered">
			  <label>&nbsp;&nbsp;&nbsp;&nbsp;购买成功！！</label>
		      <br/>
		      <br/>
		      <table class="am-table am-table-striped am-table-hover">
		                  <thead>
		                      <tr>
		                            <th>电影</th>
		                            <th>日期</th>
		                            <th>放映时间</th>
		                            <th>放映厅</th>
		                            <th>座位</th>
		                            
		                      </tr>
		                  </thead>
		                  <tbody>
		                  	<% for(int i=0;i<chooseSeat.getSize();i++){   %>
		                      <tr>
		                            <td><jsp:getProperty name="choosePlan" property="movie" /></td>
		                            <td><jsp:getProperty name="choosePlan" property="day" /></td>
		                            <td><jsp:getProperty name="choosePlan" property="time" /></td>
		                            <td><jsp:getProperty name="choosePlan" property="hall" /></td>
		                            <td><% out.print(chooseSeat.getItem(i)); %></td>
		                      </tr>
		                      <%} %>
		                      
		                </tbody>
		      </table>
		      <br/>
		      <br/>
		      <br/>
		      <br/>
		      <br/>
		      <br/>
		      <br/>
		
			 
      	
	</div>
	<%@ include file="../footer.jsp" %>
	
	</div>





</body>
</html>