<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="movieList" 
    type="net.cineplex.webmodel.MovieDisplayVOList"
    scope="session">
</jsp:useBean>
<jsp:useBean id="movie" 
	class="net.cineplex.webmodel.MovieDisplayVO"
	scope="page">
</jsp:useBean>


				<div>
		      		<label class="am-text-xl">
		       			 线上电影
		      		</label>
		    	</div>
		<% 
			for(int i=0;i<movieList.getSize();i++){
				pageContext.setAttribute("movie",movieList.getItem(i));
		%>
		
		    	<hr/>
				<div class="am-g">
		      		<div class="am-u-lg-2 am-u-md-3 am-u-sm-4">
		      			<a href="/cineplex/showMovie?movie=<jsp:getProperty name="movie" property="mid" />"  target="_self"><img src="/cineplex/system/assets/i/<jsp:getProperty name="movie" property="mid" />.jpg" alt="movie<jsp:getProperty name="movie" property="mid" />" /></a>
		      		</div>    
			      	<div class="am-u-lg-8 am-u-md-6 am-u-sm-4">
			        	<h1><jsp:getProperty name="movie" property="name" /></h1>
			        	<p><jsp:getProperty name="movie" property="simpleInfo" />
			       		</p>
			      	</div>
			      	<div class="am-u-lg-2 am-u-md-3 am-u-sm-4 am-vertical-align" style="height:200px">
			       		<div class="am-vertical-align-middle">
			        		<label >评分</label>
			        
			        		<label class="am-text-xxl"><strong>&nbsp;<jsp:getProperty name="movie" property="score" /></strong></label>
			        	</div>
			      	</div>
			    </div>
	 	<%} %>
	 		
      			
      			<br/>