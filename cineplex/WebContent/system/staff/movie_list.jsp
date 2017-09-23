<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="m_feedback" uri="/WEB-INF/tlds/movieModifyFeedback.tld" %>
<jsp:useBean id="movieModList" 
    type="net.cineplex.webmodel.MovieModifiableList"
    scope="session">
</jsp:useBean>
<jsp:useBean id="movie" 
	class="net.cineplex.model.Movie"
	scope="page">
</jsp:useBean>
<html>
<head>
  <meta charset="utf-8">
 
  <title>影院在线——服务员</title>
  <%@ include file="import.jsp" %>
  
    <script type="text/javascript">
      function modify(movieID){
    	  var url="/cineplex/modifyMovie?movieID="+movieID;
    	  window.location.href = url;
        }
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">电影管理</strong> / <small>movie</small></div>
      <br/>
      <div class="am-tabs am-margin" data-am-tabs>
        <ul class="am-tabs-nav am-nav am-nav-tabs">
          <li><a href="#add">添加</a></li>
          <li class="am-active"><a href="#modify">修改</a></li>
        </ul>

        <div class="am-tabs-bd">
          <div class="am-tab-panel am-fade" id="add">
              <div class="am-u-sm-centered am-u-md-8 am-u-lg-7">
			   <%@ include file="movie_add_panel.jsp" %>
              </div>
           </div>

       
      

          <div class="am-tab-panel am-fade am-in am-active am-g" id="modify">
          		 <div class="am-u-sm-centered am-u-md-8 am-u-lg-7">
	                  <br/>
	                  <m_feedback:show />
	                  
	                  <table  class="am-table am-table-striped am-table-hover">
	                  <tr>
	
	                    <td><b>电 影&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
	                    <td></td>
	                  </tr>
	                  
	                  <% 
							for(int i=0;i<movieModList.getSize();i++){
								pageContext.setAttribute("movie",movieModList.getItem(i));
						%>
	                  <tr>
	                    <td><jsp:getProperty name="movie" property="name" /></td>
	                    <td><button class="am-btn am-btn-success am-btn-sm" name="movie<jsp:getProperty name="movie" property="mid" />" 
	                    		id="<jsp:getProperty name="movie" property="mid" />"   onclick="modify('<jsp:getProperty name="movie" property="mid" />');">修改</button></td>
	                  </tr>
	                  <%  }%>
	
	                  </table>
	              </div>
	            
	          </div>

        </div>     

         
       
      </div>

    </div>
  </div>

</div>
<!-- content end -->






<%@ include file="footer.jsp" %>


</body>
</html>