<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
				              
				          