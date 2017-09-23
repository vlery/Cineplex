<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="feedback" uri="/WEB-INF/tlds/planCreateFeedback.tld" %>
<jsp:useBean id="hallList" 
    type="net.cineplex.webmodel.HallList"
    scope="session">
</jsp:useBean>
<jsp:useBean id="movieModList" 
    type="net.cineplex.webmodel.MovieModifiableList"
    scope="session">
</jsp:useBean>
<jsp:useBean id="movie" 
	class="net.cineplex.model.Movie"
	scope="page">
</jsp:useBean>
<jsp:useBean id="planList" 
    type="net.cineplex.webmodel.PlanListVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="moviePlan" 
    class="net.cineplex.webmodel.MoviePlanVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="planItem" 
    class="net.cineplex.webmodel.PlanVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="plan" 
    type="net.cineplex.model.Plan"
    scope="session">
</jsp:useBean>
<html>
<head>
  <meta charset="utf-8">
  <title>影院在线——服务员</title>
  <%@ include file="import.jsp" %>
  
  
</head>
<body>


<%@ include file="header.jsp" %>
 
<div class="am-cf admin-main">
 	 <!-- sidebar start -->
 		<%@ include file="side_bar.jsp" %>
  	 <!-- sidebar end -->

 
  	 <!-- content start -->
   	<div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">放映计划</strong> / <small>plan</small></div>
		      <br/>
		      
		      <div class="am-tabs am-margin" data-am-tabs>
				        <ul class="am-tabs-nav am-nav am-nav-tabs">
				          <li><a href="#add">添加</a></li>
				          <li  class="am-active"><a href="#modify">修改</a></li>
				        </ul>
		        
				        <div class="am-tabs-bd">
				          <div class="am-tab-panel am-fade" id="add">
				              <div class="am-u-sm-centered am-u-md-8 am-u-lg-7">
				              		<feedback:show/>
				              <form  class="am-form" method="post" action="/cineplex/planCreate">
				                    <label for="movie">电影 :</label>
				                   
				                    <select name="movie" id="movie"  required>
				                     <option value="" ></option>
				                      <% for(int i=0;i<movieModList.getSize();i++){ 
				                    	  pageContext.setAttribute("movie",movieModList.getItem(i)); %>
				                      	<option value="<jsp:getProperty name="movie" property="mid" />">
				                      		<jsp:getProperty name="movie" property="name" />
				                      	</option>
				                      <% } %>
				                    </select>
				                    <br/>
				
				                    <label for="hall">放映厅 :</label>
				                   
				                    <select name="hall" id="hall" required>
				                    <option value=""></option>
				                      <% for(int i=0;i<hallList.getSize();i++){ 
				                      		 %>
				                      	<option value=" <% out.print(hallList.getHidByIndex(i)); %>">
				                      		<% out.print(hallList.getNameByIndex(i)); %>
				                      	</option>
				                      <% } %>
				                    </select>
				                    <br/>
				
				                    <label for="day">放映日期:</label>
				                    <p><input type="text" class="am-form-field" id="day" name="day" data-am-datepicker readonly required/></p>
				
				
				                    <label for="time">开始时间:</label>
				                    <input  type="text" id="time" name="time" required></input> 
				                    <br/>
				                   
				                    <label for="price">票价（元）:</label>
				                    <input  type="text" id="price" name="price" required></input> 
				                    <br/> 
				                    <input type="submit" name="add" value="&nbsp; &nbsp;确 定&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr">
				              </form>
				              </div>
				          </div>
				          
				          <div class="am-tab-panel am-fade am-in am-active am-g" id="modify">
				                  <div class="am-u-sm-centered am-u-md-11 am-u-lg-10">
				                       
				                       <form  class="am-form" method="post" action="/cineplex/planModify">
			                                  <label for="movie_m">电影 :</label>
			                                    <select name="movie_m" id="movie_m"  disabled>
							                     
							                      <% for(int i=0;i<movieModList.getSize();i++){ 
							                    	  pageContext.setAttribute("movie",movieModList.getItem(i));
							                    	  movie=movieModList.getItem(i);  %>
							                      	<option value="<jsp:getProperty name="movie" property="mid" />"
							                      			<% if(movie.getMid().equals(plan.getMid())){
							                      				out.print("selected");
							                      			}
							                      				%>
							                      	>
							                      			
							                      		<jsp:getProperty name="movie" property="name" />
							                      	</option>
							                      <% } %>
							                    </select>
			                                  <br/>
			
			                                  <label for="hall_m">放映厅 :</label>
			                                 
			                                  <select name="hall_m" id="hall_m" >
			                                   <% for(int i=0;i<hallList.getSize();i++){ 
				                      		 	%>
				                      				<option value=" <% out.print(hallList.getHidByIndex(i)); %>"
				                      							<% if(plan.getHid().equals(String.valueOf(hallList.getHidByIndex(i)))){
							                      						out.print("selected");
							                      					}
							                      				%>
				                      				>
				                      				<% out.print(hallList.getNameByIndex(i)); %>
				                      				</option>
				                      			<% } %>
			                                  </select>
			                                  <br/>
			
			                                  <label for="day_m">放映日期:</label>
			                                  <p><input name="day_m" id="day_m" value="<% out.print(String.valueOf(plan.getDay())); %>" type="text" class="am-form-field"  data-am-datepicker readonly/></p>
			
			
			                                  <label for="time_m">开始时间:</label>
			                                  <input  id="time_m" name="time_m"  value="<% out.print(plan.getTime().getHours());  
			                                  											   out.print(":");
			                                  											   out.print(plan.getTime().getMinutes());
			                                  											%>" type="text" ></input> 
			                                   <br/>
			                                  
			                                 
			                                   <label for="price_m">票价（元）:</label>
			                                   <input  id="price_m" name="price_m" type="text" name="price"
			                                  	value="<jsp:getProperty name="plan" property="price" />"></input> 
			                                    <br/> 
			
			                                  <input type="submit" name="delete" value="&nbsp; &nbsp;删 除&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr">
			                                  <label  class="am-fr">&nbsp;&nbsp;&nbsp;</label>
			
			
			                                  <input type="submit" name="modify" value="&nbsp; &nbsp;修 改&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr">
			                                  <label  class="am-fr">&nbsp;&nbsp;&nbsp;</label>
			                                  <input type="submit" name="back" value="&nbsp; &nbsp;返 回&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr">
			                            </form>
				                                           
				                  </div>
				
				          </div>
		
		        		</div>
      		 </div>
    </div>
	</div>
	 <!-- content end -->

</div>


<%@ include file="footer.jsp" %>

</body>
</html>