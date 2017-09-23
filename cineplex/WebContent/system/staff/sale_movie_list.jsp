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


<html>
<head>
  <meta charset="utf-8">
  <title>影院在线——服务员</title>
  <%@ include file="import.jsp" %>
  
  <script type="text/javascript">
    
    </script>
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">售票</strong> / <small>sale</small></div>
		      <br/>
		      
		      <div class="am-tabs am-margin" data-am-tabs>
				        <ul class="am-tabs-nav am-nav am-nav-tabs">
				          <li class="am-active"><a href="#movielist">电影列表</a></li>
				          
				        </ul>
		        
				        <div class="am-tabs-bd">
				          <div class="am-tab-panel am-fade am-in am-active am-g" id="movielist">
				              <div class="am-u-sm-centered am-u-md-11 am-u-lg-10">
				         		<% 
									for(int i=0;i<movieList.getSize();i++){
										pageContext.setAttribute("movie",movieList.getItem(i));
								%>
								<div>
									<a href="/cineplex/officialSale?movie=<jsp:getProperty name="movie" property="mid" />"  target="_self">
										<h3><jsp:getProperty name="movie" property="name" /></h3>
									</a>
								</div>
								<% }%>
				         		
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