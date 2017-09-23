<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="m_feedback" uri="/WEB-INF/tlds/planModifyFeedback.tld" %>
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
<html>
<head>
  <meta charset="utf-8">
  <title>影院在线——服务员</title>
  <%@ include file="import.jsp" %>
  
  <script type="text/javascript">
      function modify(pid){
    	  var url="/cineplex/planModify?planID="+pid;
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
				              <%@ include file="plan_add_panel.jsp" %>
				              </div>
				          </div>
				          
				          <div class="am-tab-panel am-fade am-in am-active am-g" id="modify">
				                  <div class="am-u-sm-centered am-u-md-11 am-u-lg-10">
				                       <br/>
				                       <m_feedback:show/>
				                       <div class="am-panel-group" >
				                    <%   for(int i=0;i<planList.getSize();i++){
				                    	pageContext.setAttribute("moviePlan",planList.getItem(i));	
				                    		moviePlan=planList.getItem(i);
				                    	
				                    	%>
				                          <div class="am-panel am-panel-default">
				                            
				                            
				                            <div class="am-panel-hd">
				                              <h4 class="am-panel-title" data-am-collapse="{parent: '#mlist', target: '#movie-<jsp:getProperty name="moviePlan" property="mid" />'}">
				                               	<jsp:getProperty name="moviePlan" property="name" />
				                              </h4>
				                            </div>
				                            <div id="movie-<jsp:getProperty name="moviePlan" property="mid" />" class="am-panel-collapse am-collapse am-in">
				                              <div class="am-panel-bd">
				                                <table  class="am-table am-table-striped am-table-hover">
				                          		
				                                  <tr>
				                                    <td>日期&nbsp;&nbsp;&nbsp;&nbsp;</td>
				                                    <td>时间&nbsp;&nbsp;&nbsp;&nbsp;</td>
				                                    <td>放映厅</td>
				                                    <td>票价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				                                    <td></td>
				                                  </tr>
				                                	<% for(int j=0;j<moviePlan.getListSize();j++){ 
				                                		pageContext.setAttribute("planItem",moviePlan.getPlanItem(j));	
				                                	%>
				                                  <tr>
				                                    <td><jsp:getProperty name="planItem" property="day" /></td>
				                                    <td><jsp:getProperty name="planItem" property="time" /></td>
				                                    <td><jsp:getProperty name="planItem" property="hall" /></td>
				                                    <td><jsp:getProperty name="planItem" property="price" /></td>
				                                    <td><button class="am-btn am-btn-success am-btn-sm" 
				                                    			name="<jsp:getProperty name="planItem" property="pid" />" 
				                                    			id="<jsp:getProperty name="planItem" property="pid" />"
				                                    			onclick="modify(<jsp:getProperty name="planItem" property="pid" />)">修改</button></td>
				                                  </tr>
				                                 <% }%>
				                                </table>
				                              </div>
				                            </div>
				                          </div>
				                         <%} %>
				                       </div>
				                                           
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