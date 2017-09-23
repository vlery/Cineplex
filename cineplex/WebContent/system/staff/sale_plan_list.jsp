<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="planList" 
    type="net.cineplex.webmodel.PlanListVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="moviePlan" 
   	class="net.cineplex.webmodel.MoviePlanByDay"
    scope="page">
</jsp:useBean>
<jsp:useBean id="planItem" 
   	class="net.cineplex.webmodel.PlanVO"
    scope="page">
</jsp:useBean>


<html>
<head>
  <meta charset="utf-8">
  <title>影院在线——服务员</title>
  <%@ include file="import.jsp" %>
  
 <script type="text/javascript">
 			function buyTicket(planID){
 				var url="/cineplex/planSelect?plan="+planID;
 				window.open(url);
 			}
			function alertLog(){
				alert("请先登陆!!!");		
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">售票</strong> / <small>sale</small></div>
		      <br/>
		      
		      <div class="am-tabs am-margin" data-am-tabs>
				        <ul class="am-tabs-nav am-nav am-nav-tabs">
				          <li class="am-active"><a href="#plist">计划列表</a></li>
				          
				        </ul>
		        
				        <div class="am-tabs-bd">
				          <div class="am-tab-panel am-fade am-in am-active am-g" id="plist">
				              <div class="am-u-sm-centered am-u-md-11 am-u-lg-10">
				         					 <div>
										        
										  			 <br/>
										                       
													<% for(int i=0;i<planList.getSize();i++) {
										                	pageContext.setAttribute("moviePlan",planList.getItemByTime(i) ); 
										                	moviePlan=planList.getItemByTime(i);
										                	
										                	%>
											                	<label class="am-text-secondary am-text-md"><strong>
											                	 <%      
											            	 String[] sp= planList.getItemByTime(i).getDay().split("-");
											                        		out.print(sp[1]);
											                        		out.print("月");
											                        		out.print(sp[2]);
											                        		out.print("日");
											                        		%>
											                	</strong></label>
										                	
										                		<div>
										                              <table class="am-table am-table-striped am-table-hover">
										                                    <thead>
										                                        <tr>
										                                            <th>放映时间</th>
										                                            <th>放映厅</th>
										                                            <th>票价（元）</th>
										                                            <th>选座购票</th>
										                                        </tr>
										                                    </thead>
										                                    <tbody>
										                                       <% for(int j=0;j<moviePlan.getSize();j++){ 
										                                    	  pageContext.setAttribute("planItem",moviePlan.getItem(j) );
										                                    	  planItem=moviePlan.getItem(j);
										                                       	%>
										                                        <tr>
										                                            <td><jsp:getProperty name="planItem" property="time" /></td>
										                                            <td><jsp:getProperty name="planItem" property="hall" /></td>
										                                            <td><jsp:getProperty name="planItem" property="price" /></td>
										                                            <td> <button class="am-btn am-btn-success am-btn-sm" name="<jsp:getProperty name="planItem" property="pid" />" id="<jsp:getProperty name="planItem" property="pid" />" onclick="
										                                            <% if(null!=session.getAttribute("mngID")){
										                                            				out.print("buyTicket("+planItem.getPid()+");");
										                                            	}else{
										                                            				out.print("alertLog();");	
										                                            	}
										                                            	%>
										                                            ">购 票</button></td>
										                                        </tr>
										                                        <% }%>
										                                   </tbody>
										                                </table>
										                        </div>
										                        
										                     
										               	
										               	<%
										            if(i!=planList.getSize()-1){
										            	out.print("<hr/>");
										            }
													
													
													
													} %>
										          		
											  	 </div>
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